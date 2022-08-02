package practice.regex;

import java.util.Scanner;

public class SplitText {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        System.out.println(splitTextIntoWords(input));
    }

    public static String splitTextIntoWords(String input) {

        if (input.equals("")) {
            return "";
        } else {
            input = input.replaceAll("[0-9]+", "").replaceAll("-", "\n")
                    .replaceAll("[.,;():]", "");
            String[] words = input.split("\\s+");
            StringBuilder allWords = new StringBuilder();
            for (String word : words) {
                allWords.append(word).append("\n");
            }
            return allWords.substring(0, allWords.length() - 1);
        }
    }
}