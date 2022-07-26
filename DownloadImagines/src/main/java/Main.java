import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.Map;


public class Main {

    public static void main(String[] args) {

        try {
            Document document = Jsoup.connect("https://lenta.ru").userAgent("YaBrowser 22.5").get();
            Elements imgTags = document.select("img");
            System.out.println("Downloaded files: ");

            for (Element element : imgTags) {
                Map<String, String> map = element.attributes().dataset();
                for (String imgHttps : map.values()) {
                    downloadImage(imgHttps);
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void downloadImage(String imgHttps) {

        String imgName = imgHttps.substring(imgHttps.lastIndexOf("/") + 1);

        File imgDir = new File("img");
        if (!imgDir.exists()) {
            imgDir.mkdirs();
        }

        try (ReadableByteChannel readableByteChannel = Channels.newChannel(new URL(imgHttps).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream(imgDir + File.separator + imgName)) {
            fileOutputStream.getChannel()
                    .transferFrom(readableByteChannel, 0, Long.MAX_VALUE);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(imgName);
    }
}


