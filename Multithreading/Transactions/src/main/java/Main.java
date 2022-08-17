import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Random random = new Random();
        Bank bank = new Bank();

        for (int i = 1; i <= 100; i++) {
            String numberAccount = String.valueOf(i);
            Account account = new Account(random.nextInt(100_000), numberAccount);
            bank.addAccount(account);
        }

        System.out.println("Сумма в банке до начала транзакций: " + bank.getSumAllAccounts());

        for (int i = 0; i < 100; i++) {

            Thread thread = new Thread(() -> {
                try {
                    for (int j = 1; j <= 1000; j++) {

                        int numberAccFrom = 1 + random.nextInt(bank.getAccounts().size() - 1);
                        int numberAccTo = 1 + random.nextInt(bank.getAccounts().size() - 1);
                        int numberAccBalance = 1 + random.nextInt(bank.getAccounts().size() - 1);
                        long amount = random.nextInt(100_000);

                        if (numberAccFrom == numberAccTo) {
                            numberAccTo = numberAccFrom - 1;
                        }

                        System.out.println("Баланс счета № " + numberAccBalance +
                                ": " + bank.getBalance(String.valueOf(numberAccBalance)));

                        Account accountFrom = bank.getAccounts().get(String.valueOf(numberAccFrom));
                        Account accountTo = bank.getAccounts().get(String.valueOf(numberAccTo));

                        bank.transfer(accountFrom.getAccNumber(), accountTo.getAccNumber(), amount);
                    }

                    System.out.println(bank.getSumAllAccounts());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });
            thread.start();
            System.out.println(thread.getName());
        }

        System.out.println("Сумма в банке по окончанию транзакций: " + bank.getSumAllAccounts());
    }

}
