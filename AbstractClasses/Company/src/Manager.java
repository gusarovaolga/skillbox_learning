import java.util.Random;

public class Manager implements Employee {

    private final double BONUS_PERCENT = 0.05;
    private int salary = setSalary() * 5;
    private Company company;
    private Random random = new Random();

    public Manager(Company company) {
        this.company = company;
        double profit = random.nextInt(25000) + 115000;
        salary = (int) (salary + BONUS_PERCENT * profit);
    }

    @Override
    public int getMonthSalary() {
        return salary;
    }
}
