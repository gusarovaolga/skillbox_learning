package practice.regex;

import java.util.Scanner;

public class PhoneCleanerRegex {
    private static final String wrongFormat = "Неверный формат номера";
    private static final String REGEX_IT_WORD = "[A-Za-z]+";
    private static final String REGEX_ONLY_DIGITAL = "[^0-9]";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("0")) {
                scanner.close();
                break;
            }
            if(input.matches(REGEX_IT_WORD)) {
                System.out.println("Номер не найден");

            } else {
                input = input.replaceAll(REGEX_ONLY_DIGITAL, "");
                System.out.println(formatPhoneNumber(input));
            }


            }
        }

    public static String formatPhoneNumber(String input) {
        char code = input.charAt(0);

        if (input.length() > 11 || input.length() < 8) {
            return wrongFormat;
        } else if (input.length() == 10) {
            return "7" + input;
        } else if (code != '7' && code != '8') {
            return wrongFormat;
        } else if (code == '8') {
            char newCode = '7';
            return input.replace(code, newCode);
        } else {
            return input;
        }
    }
}
