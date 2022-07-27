import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;

public class FileUtils {

    private static char[] sizeMultipliers = {'B', 'K', 'M', 'G', 'T'};
    private static HashMap<Character, Integer> char2multiplier = getMultipliers();

    private static void checkFolder(File folder) throws Exception {

        if (!folder.exists()) {
            throw new FileNotFoundException("Directory not found!");
        }
        if (!folder.canRead()) {
            throw new IllegalArgumentException("This directory not readable");
        }
    }

    public static long calculateFolderSize(String path) {

        File folder = new File(path);

        try {
            checkFolder(folder);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        if (folder.isFile()) {
            return folder.length();
        }

        File[] files = folder.listFiles();
        long sum = 0;
        if (files != null) {
            for (File file : files) {
                String pathFile = file.getAbsolutePath();
                sum += calculateFolderSize(pathFile);
            }
            return sum;
        } else {
            throw new NullPointerException("Directory does not exist");
        }
    }

    public static String getHumanReadableSize(long size) {

        for (int i = 0; i < sizeMultipliers.length; i++) {
            double value = ((double) size) / Math.pow(1024, i);
            if (value < 1024) {
                return Math.round(value * 10) / 10. + " " +
                        sizeMultipliers[i] +
                        (i > 0 ? "b" : "");
            }
        }
        return "Very big!";
    }

    private static HashMap<Character, Integer> getMultipliers() {
        HashMap<Character, Integer> char2multiplier = new HashMap<>();
        for (int i = 0; i < sizeMultipliers.length; i++) {
            char2multiplier.put(
                    sizeMultipliers[i],
                    (int) Math.pow(1024, i)
            );
        }
        return char2multiplier;
    }

}


