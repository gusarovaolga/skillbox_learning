public interface Employee extends Comparable<Employee> {

    int getMonthSalary();

    @Override
    default int compareTo(Employee o) {
        return Double.compare(getMonthSalary(), o.getMonthSalary());
    }

    default int setSalary() {

        int minSalary = 10000;
        int maxSalary = 100000;
        return (int) (Math.random() * ++maxSalary) + minSalary;
    }
}
