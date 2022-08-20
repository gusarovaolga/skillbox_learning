import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ForkJoinPool;

public class Main {

    private static final String DST_FOLDER = "src/main/resources/map/";
    private static final String FILE_TYPE = "txt";
    private static String fileName;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Введите адрес сайта:");
        String urlSite = sc.nextLine().trim();
//        String urlSite = "https://skillbox.ru/";

        try {
            fileName = new URL(urlSite).getHost().replace(".", "_");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        System.out.println("Поиск ссылок...");
        long startTime = System.currentTimeMillis();

        LinksFinder finder = new LinksFinder(urlSite, urlSite);
        new ForkJoinPool().invoke(finder);
        System.out.println("Сканирование завершено...");

        CopyOnWriteArrayList<String> allLinks = finder.getAllLinks();
        Collections.sort(allLinks);

        String map = createMap(allLinks);
        writeFiles(map);
        System.out.println("Создание карты сайта " + "\"" + fileName + "\" заняло "
                + ((System.currentTimeMillis() - startTime) / 1000) + " сек.");
    }

    public static String createMap(CopyOnWriteArrayList<String> allLinks) {

        StringBuilder sb = new StringBuilder();

        for (String link : allLinks) {

            int count = countTab(link);
            sb.append("\t".repeat(count)).append(link).append("\n");
        }

        return sb.toString();
    }

    private static int countTab(String link) {

        String charSet = "https://";
        int st = link.indexOf(charSet) + 1;
        int end = link.lastIndexOf("/") - 1;

        int count = -1;
        for (int i = st; i < end; i++) {

            if (link.charAt(i) == '/') {
                count++;
            }
        }
        return count;
    }

    private static void writeFiles(String sitemap) {
        System.out.println("Пишем файл...");

        if (!Files.exists(Paths.get(DST_FOLDER))) {
            new File(DST_FOLDER).mkdir();
        }
        String filePath = DST_FOLDER.concat(fileName).concat(".").concat(FILE_TYPE);
        File file = new File(filePath);

        try (PrintWriter writer = new PrintWriter(file)) {
            writer.write(sitemap);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Карта создана!");
    }
}

