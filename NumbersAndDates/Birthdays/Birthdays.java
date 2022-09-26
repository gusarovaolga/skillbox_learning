
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Birthdays {

    public static void main(String[] args) {

        int day = 31;
        int month = 12;
        int year = 1990;

        System.out.println(collectBirthdays(year, month, day));
    }

    public static String collectBirthdays(int year, int month, int day) {
        LocalDate birthday = LocalDate.of(year, month, day);
        LocalDate today = LocalDate.now();
        int age = 0;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy - EE").localizedBy(new Locale("us"));

        if (birthday.isAfter(today)) {
            return "";
        }

        StringBuilder text = new StringBuilder();

        while (today.isAfter(birthday) || today.isEqual(birthday)) {
            text.append(System.lineSeparator()).append(age).append(" - ").append(formatter.format(birthday));
            birthday = birthday.plusYears(1);
            age++;
        }
        return text.toString();

        //TODO реализуйте метод для построения строки в следующем виде
        //0 - 31.12.1990 - Mon
        //1 - 31.12.1991 - Tue
    }
}
