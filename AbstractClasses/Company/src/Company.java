import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Company {

    private int income;
    private List<Employee> employeeList = new ArrayList<>();

    public void hire(Employee employee) {
        employeeList.add(employee);
    }

    public void hireAll(List<Employee> employees) {
        this.employeeList = employees;
    }

    public void fire(Employee employee) {
        employeeList.remove(employee);
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void printSalaryList(List<Employee> tops) {

        for (int i = 0; i < tops.size(); i++) {
            System.out.println(String.format("%, d", employeeList.get(i).getMonthSalary()) + " руб.");
        }
    }

    public List<Employee> getTopSalaryStaff(int count) {

        Collections.sort(employeeList);
        Collections.reverse(employeeList);
        List<Employee> tops = new ArrayList<>();

        if (count > 0 && count <= employeeList.size()) {
            tops = employeeList.subList(0, count);
            System.out.println("Список из " + count + " зарплат по убыванию:");
            printSalaryList(tops);
            return tops;
        } else if (count > employeeList.size()) {
            printSalaryList(employeeList);
            return employeeList;
        } else {
            System.out.println("нельзя сформировать список из отрицательных значений");
            return tops;
        }
    }

    public List<Employee> getLowestSalaryStaff(int count) {

        List<Employee> lowest = new ArrayList<>();
        Collections.sort(employeeList);
        if (count > 0 && count <= employeeList.size()) {
            lowest = employeeList.subList(0, count);
            System.out.println("Список из " + count + " зарплат по возрастанию:");
            printSalaryList(lowest);
            return lowest;
        } else if (count > employeeList.size()) {
            printSalaryList(employeeList);
            return employeeList;
        } else {
            System.out.println("нельзя сформировать список из отрицательных значений");
            return lowest;
        }
    }

    public double setIncome() {
        double minIncome = 0.0;
        double maxIncome = 15_000_000.0;

        return (Math.random() * ++maxIncome) + minIncome;
    }

    public double getIncome() {
        return income;
    }
}
