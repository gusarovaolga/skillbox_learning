import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Company company = new Company();
        company.setIncome();

        List<Employee> employees = new ArrayList<>();

        for (int i = 0; i < 180; i++) {
            employees.add(new Operator(company));
        }

        for (int i = 0; i < 80; i++) {
            employees.add(new Manager(company));
        }

        for (int i = 0; i < 10; i++) {
            employees.add(new TopManager(company));
        }

        company.hireAll(employees);

        System.out.println("количество сотрудников в компании перед сокращением: " + company.getEmployeeList().size());
        company.getTopSalaryStaff(15);
        company.getLowestSalaryStaff(30);

        int fired = employees.size() / 2;
        Random random = new Random();
        for (int i = 0; i < fired; i++) {
            int firedEmployee = random.nextInt(employees.size());
            company.fire(employees.get(firedEmployee));
        }

        System.out.println("количество сотрудников в компании после сокращения: " + company.getEmployeeList().size());
        company.getTopSalaryStaff(15);
        company.getLowestSalaryStaff(30);
    }
}
