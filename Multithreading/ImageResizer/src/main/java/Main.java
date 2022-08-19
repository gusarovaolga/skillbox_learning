import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.lang.System.in;

public class Main {

    public static void main(String[] args) {

        String srcFolder = "";
        String dstFolder = "";
        int newWidth = 300;
        long start = System.currentTimeMillis();

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            System.out.println("Введите папку с изображениями:");
            srcFolder = reader.readLine();
            System.out.println("Введите папку для сохранения:");
            dstFolder = reader.readLine();

            File imgDir = new File(dstFolder);
            if (!imgDir.exists()) {
                imgDir.mkdirs();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        int numberOfCores = Runtime.getRuntime().availableProcessors();
        System.out.println("Количество ядер процессора: " + numberOfCores);

        File srcDir = new File(srcFolder);
        File[] files = srcDir.listFiles();

        if (files != null) {

            int lengthSubFiles = (int) Math.round((double) files.length / numberOfCores);

            for (int i = 0; i < files.length; i += lengthSubFiles) {

                File[] subFiles = Arrays.copyOfRange(files, i, Math.min(files.length, i + lengthSubFiles));
                new Thread(new ImageResizer(subFiles, newWidth, dstFolder, start)).start();
            }
        }
    }
}
