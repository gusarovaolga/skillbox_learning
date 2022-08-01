package practice;

public abstract class Client {

    private double amount;
    private final String COURSE = "руб.";
    protected String conditionsPut = "без комиссии";
    protected String conditionsTake = "без комиссии";

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void put(double amountToPut) {
        if (amountToPut > 0) {
            amount = amount + amountToPut;
        }
    }

    public void take(double amountToTake) {
        if (amountToTake <= amount) {
            amount = amount - amountToTake;
        }
    }

    public void clientReport() {

        String report = "Баланс: " + amount + COURSE + System.lineSeparator()
                + "Условия пополнения: " + conditionsPut + System.lineSeparator()
                + "Условия снятия: " + conditionsTake;

        System.out.println(report);
    }

}
