import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.COPY_ATTRIBUTES;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class FileUtils {
    public static void copyFolder(String sourceDirectory, String destinationDirectory) {

        System.out.println("копирование файлов из: " + sourceDirectory + " в: " + destinationDirectory + " :");

        try {
            checkFolder(sourceDirectory);
            checkFolder(destinationDirectory);

            Path out = Paths.get(sourceDirectory);
            Path in = Paths.get(destinationDirectory);

            Files.walk(out).forEach(source -> {
                Path destination = in.resolve(out.relativize(source));
                if (Files.isDirectory(source)) {
                    if (Files.notExists(destination)) {

                        try {
                            Files.createDirectory(destination);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } else {

                    try {
                        Files.copy(source, destination, REPLACE_EXISTING, COPY_ATTRIBUTES);
                        System.out.println(source.getFileName().toString());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void checkFolder(String path) throws Exception {

        File folder = new File(path);

        if (!folder.exists()) {
            throw new FileNotFoundException("Directory not found!");
        }
        if (!folder.canRead()) {
            throw new IllegalArgumentException("This directory not readable");
        }
        if (!folder.canWrite()) {
            throw new Exception("This directory not write");
        }
    }
}