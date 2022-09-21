public class BankAccount {

    private double score;

    public double getAmount() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public void put(double amountToPut) {
        if (amountToPut > 0) {
            score = score + amountToPut;
        }
    }

    public void take(double amountToTake) {
        if (amountToTake <= score) {
            score = score - amountToTake;
        }
    }
}
