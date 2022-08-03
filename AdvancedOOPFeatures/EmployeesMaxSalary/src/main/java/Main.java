import java.util.Calendar;
import java.util.Comparator;
import java.util.List;

public class Main {

    private static final String STAFF_TXT = "data/staff.txt";
    private static final int YEAR = 2017;

    public static void main(String[] args) {
        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);
        Employee employeeMaxSalary = findEmployeeWithHighestSalary(staff, YEAR);
        System.out.println("Сотрудник с наибольшей зарплатой, пришедший в " + YEAR + " году:"+ System.lineSeparator()
                + employeeMaxSalary);
    }

    public static Employee findEmployeeWithHighestSalary(List<Employee> staff, int year) {
        Calendar calendar = Calendar.getInstance();
        return staff.stream().filter(employee -> {
            calendar.setTime(employee.getWorkStart());
            return calendar.get(Calendar.YEAR) == year;
        }).max(Comparator.comparing(Employee::getSalary)).orElseThrow();
    }
}