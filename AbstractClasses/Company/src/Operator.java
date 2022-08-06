public class Operator implements Employee {

    private int salary = setSalary();
    private Company company;

    public Operator(Company company) {
        this.company = company;
    }

    @Override
    public int getMonthSalary() {
        return salary;
    }
}
