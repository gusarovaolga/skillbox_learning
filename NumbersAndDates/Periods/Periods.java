

import java.time.LocalDate;
import java.time.Period;

public class Periods {
    public static void main(String[] args) {

        int day = 23;
        int month = 5;
        int year = 1995;

        LocalDate firstDate = LocalDate.of(year, month, day);
        LocalDate secondDate = LocalDate.now();

        System.out.println("Количество лет, месяцев и дней с момента основания Java до сегодняшнего дня: ");
        System.out.println(Periods.getPeriodFromBirthday(firstDate, secondDate));
    }

    public static String getPeriodFromBirthday(LocalDate firstDate, LocalDate secondDate) {

        StringBuilder string = new StringBuilder();
        Period period = Period.between(firstDate, secondDate);

        string.append("years:").append(period.getYears()).append(", ")
                .append("months:").append(period.getMonths()).append(", ")
                .append("days:").append(period.getDays());
        return string.toString();
    }

}
