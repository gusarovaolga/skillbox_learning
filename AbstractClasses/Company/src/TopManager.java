public class TopManager implements Employee {

    private final double BONUS_PERCENT = 1.5;
    private int salary = setSalary() * 10;
    private Company company;

    public TopManager(Company company) {
        this.company = company;
        if (company.getIncome() > 10_000_000) {
            salary = (int) (salary + salary * BONUS_PERCENT);
        }
    }

    @Override
    public int getMonthSalary() {
        return salary;
    }
}
