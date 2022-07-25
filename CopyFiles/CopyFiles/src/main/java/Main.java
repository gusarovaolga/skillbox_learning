import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите файл или папку для копирования:");
        String sourceDirectory = scanner.nextLine();
        System.out.println("Выберите папку, куда копировать файлы:");
        String destinationDirectory = scanner.nextLine();

        FileUtils.copyFolder(sourceDirectory, destinationDirectory);
    }
}
