package practice;

public class IndividualBusinessman extends Client {

    private double commission;

    @Override
    public void put(double amountToPut) {

        double amountBusinessman = getAmount();

        if (amountToPut > 0) {
            if (amountToPut < 1000) {
                conditionsPut = "пополнение с комиссией 1%";
                commission = 0.01;
            } else if (amountToPut >= 1000) {
                conditionsPut = "пополнение с комиссией 0,5%";
                commission = 0.005;
            }
            amountBusinessman = amountBusinessman  + amountToPut - commission * amountToPut;
            setAmount(amountBusinessman);
        }
    }

}
