package practice;

public class LegalPerson extends Client {

    private final double commission = 0.01;

    @Override
    public void take(double amountToTake) {
        double amountLegal = getAmount();
        conditionsTake = "снятие с комиссией 1%";
        if (amountToTake <= getAmount()) {
            amountLegal = amountLegal - amountToTake - commission * amountToTake;
            setAmount(amountLegal);
        }
    }

}
