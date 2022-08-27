import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Нахождение всех пар положительных чисел, произведение которых равно заданному значению");
        System.out.println("Чтобы закончить введите цифру 0");

        int value = 1;
        while (value != 0) {

            System.out.print("Введите значение: ");
            value = new Scanner(System.in).nextInt();

            if (value >= 0) {
                for (int i = 1; i <= value; i++) {
                    for (int j = value; j >= 1; j--) {
                        if (i * j == value) {
                            System.out.println(i + "*" + j + " = " + value);
                        }
                    }
                }
            } else {
                System.out.println("Введено отрицательное число. Пожалуйста введите, положительное число.");
            }
        }
        System.out.println("Программа завершена");
    }
}
