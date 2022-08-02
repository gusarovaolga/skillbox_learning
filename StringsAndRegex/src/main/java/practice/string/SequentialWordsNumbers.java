package practice.string;

import java.util.Scanner;

public class SequentialWordsNumbers {
    public static void main(String[] args) {
        System.out.print("Введите текст: ");
        String text = new Scanner(System.in).nextLine().trim();
        System.out.println(sequentialWordsNumbers(text));
    }

    public static String sequentialWordsNumbers(String text) {

        int number = 1;
        StringBuilder sequentialWords = new StringBuilder().append("(").append(number).append(") ");
        for (int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);

            if (symbol == ' ') {
                number++;
                sequentialWords.append(" (").append(number).append(") ");
            } else {
                sequentialWords.append(symbol);
            }
        }
        return sequentialWords.toString().trim();
    }
}
