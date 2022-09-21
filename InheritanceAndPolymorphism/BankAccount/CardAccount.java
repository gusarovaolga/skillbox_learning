public class CardAccount extends BankAccount {

    private final double commission = 0.01;

    @Override
    public void take(double amountToTake) {
        double scoreCard = getAmount();
        if (amountToTake <= scoreCard) {
            scoreCard = scoreCard - amountToTake - commission * amountToTake;
        }
        setScore(scoreCard);
    }
}
