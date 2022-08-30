import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Угадайте число\n");

        int value = new Random().nextInt(100);
        int countAttempt = 0;
        
        while (true) {
            System.out.print("Введите число:");
            int attempt = new Scanner(System.in).nextInt();
            countAttempt++;

            if (attempt == value) {
                System.out.println("Вы угадали число с " + countAttempt + " попыток!");
                break;
            } else if (attempt < value) {
                System.out.println("Загаданное число больше");
            } else {
                System.out.println("Загаданное число меньше");
            }
        }
    }
}
