import java.util.Calendar;

public class DepositAccount extends BankAccount {

    private Calendar lastIncome;

    @Override
    public void put(double amountToPut) {
        super.put(amountToPut);
        lastIncome = Calendar.getInstance();
    }

    @Override
    public void take(double amountToTake) {
        Calendar income = Calendar.getInstance();
        lastIncome.add(Calendar.MONTH, 1);
        double scoreDeposit = getAmount();
        if (income.after(lastIncome) && amountToTake <= getAmount()) {
            scoreDeposit = scoreDeposit - amountToTake;
        }
        setScore(scoreDeposit);
    }
}
