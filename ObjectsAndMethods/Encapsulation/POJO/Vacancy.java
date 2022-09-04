public class Vacancy {

    private String position;
    private String workplace;
    private int salary;
    private boolean fullTimeJob;

    public Vacancy(String position, int salary) {
        this.position = position;
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public boolean getFullTimeJob() {
        return fullTimeJob;
    }

    public void setFullTimeJob(boolean fullTimeJob) {
        this.fullTimeJob = fullTimeJob;
    }
}
