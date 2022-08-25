import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Вычисление факториала");

        while (true) {
            System.out.print("Введите число в диапазоне от 1 до 12: ");
            int value = new Scanner(System.in).nextInt();
            int result = 1;
            StringBuilder builder = new StringBuilder();


            if (value <= 0 || value > 12) {
                System.out.println("Введеное число не соответствует указанному диапазону");
            } else {
                for (int i = 1; i <= value; i++) {
                    result = result * i;
                    builder.append(i).append("*");
                }
                String str = builder.toString();
                System.out.println(value + "! = " + getString(str) + " = " + result);
                break;
            }
        }
    }

    public static String getString(String str) {
        if (str != null && str.length() > 0 && str.charAt(str.length() - 1) == '*') {
            str = str.substring(0, str.length() - 1);
        }
        return str;
    }
}

