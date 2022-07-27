import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь до папки:");
        String path = scanner.nextLine();

        long sizeDir = FileUtils.calculateFolderSize(path);
        System.out.println("Размер папки: " + path + " составляет: " + FileUtils.getHumanReadableSize(sizeDir));
    }
}
