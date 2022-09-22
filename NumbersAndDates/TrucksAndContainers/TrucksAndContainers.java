import java.util.Scanner;

public class TrucksAndContainers {

    public static final int BOXES_IN_CONTAINER = 27;
    public static final int CONTAINERS_IN_TRUCK = 12;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int truck = 0;
        int container = 0;

        System.out.println("Введите количество ящиков для погрузки:");
        int boxes = scanner.nextInt();

        if (boxes > 0) {
            container = 1;
            truck = 1;
            System.out.println("Грузовик: " + truck);
            System.out.println("\tКонтейнер: " + container);

            for (int i = 1; i <= boxes; i++) {
                System.out.println("\t\tЯщик: " + i);
                if (i % (CONTAINERS_IN_TRUCK * BOXES_IN_CONTAINER) == 0) {
                    truck++;
                    System.out.println("Грузовик: " + truck);
                }
                if (i % BOXES_IN_CONTAINER == 0 && boxes > i) {
                    container++;
                    System.out.println("\tКонтейнер: " + container);
                }
            }
        }

        System.out.println("\nНеобходимо:" + "\r\nгрузовиков - " + truck + " шт."
                + "\r\nконтейнеров - " + container + " шт.");
    }
}


