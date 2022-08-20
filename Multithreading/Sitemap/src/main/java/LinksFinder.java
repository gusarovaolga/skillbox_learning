import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.RecursiveAction;

public class LinksFinder extends RecursiveAction {

    private static final CopyOnWriteArrayList<String> allLinks = new CopyOnWriteArrayList<>();
    private static volatile String url;
    private final String urlSite;

    public LinksFinder(String urlSite) {
        this.urlSite = urlSite;
    }

    public LinksFinder(String urlSite, String url) {
        this(urlSite);
        LinksFinder.url = url;
        allLinks.add(urlSite);
    }

    public CopyOnWriteArrayList<String> getAllLinks() {
        return allLinks;
    }

    public void collectLinks(List<LinksFinder> subTasks) {
        Document doc;
        Elements elements;

        try {
            doc = Jsoup.connect(urlSite).userAgent("YaBrowser 22.5").get();
            elements = doc.select("a");
            Thread.sleep(200);

            for (Element element : elements) {
                String link = element.attr("abs:href");

                if (!link.isEmpty()
                        && link.matches(urlSite + "[a-zA-Z0-9_\\-/]+[a-zA-Z0-9_\\-]+[/]?")
                        && !allLinks.contains(link)
                        && !link.contains("#")) {

//                    System.out.println(link);

                    String linkChek = conformityLink(link);
                    LinksFinder task = new LinksFinder(linkChek);
                    task.fork();
                    subTasks.add(task);
                    allLinks.add(linkChek);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private String conformityLink(String link) {

        if (link.equals(urlSite)) {
            link = urlSite;
        } else if (!link.matches(urlSite + "[a-zA-Z0-9_\\-/]+[a-zA-Z0-9_\\-]+[/]")) {
            link = link + "/";
        }

        return link;
    }

    @Override
    protected void compute() {

        System.out.println(Thread.currentThread().getName());

        List<LinksFinder> subTasks = new CopyOnWriteArrayList<>();

        collectLinks(subTasks);

        for (LinksFinder subTask : subTasks) {
            subTask.join();
        }
    }
}
