import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Bank {

    private final Random random = new Random();
    private Map<String, Account> accounts = new HashMap<>();

    public void addAccount(Account account) {

        if (!accounts.containsKey(account.getAccNumber())) {
            accounts.put(account.getAccNumber(), account);
        }
    }

    public Map<String, Account> getAccounts() {
        return accounts;
    }

    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
            throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    public void transfer(String fromAccountNum, String toAccountNum, long amount) {

        if (!fromAccountNum.equals(toAccountNum) && amount >= 0) {
            long balanceFromAcc = getBalance(fromAccountNum);
            long balanceToAcc = getBalance(toAccountNum);
            boolean isEnoughMoney = balanceFromAcc >= amount;

            if (!(getAccounts().get(fromAccountNum).isBlocked() || getAccounts().get(toAccountNum).isBlocked())
                    && isEnoughMoney) {

                getAccounts().get(fromAccountNum).setMoney(balanceFromAcc - amount);
                getAccounts().get(toAccountNum).setMoney(balanceToAcc + amount);
            }
        }

        if (amount > 50000) {

            try {
                boolean securityCheck = isFraud(fromAccountNum, toAccountNum, amount);

                if (securityCheck) {
                    accounts.get(fromAccountNum).setBlocked(true);
                    accounts.get(toAccountNum).setBlocked(true);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(getMessage(fromAccountNum, toAccountNum, amount));
    }

    public synchronized long getBalance(String accountNum) {

        return accounts.get(accountNum).getMoney();
    }

    public long getSumAllAccounts() {

        long moneyAllAccount = 0L;
        for (Account account : accounts.values()) {
            moneyAllAccount += account.getMoney();
        }
        return moneyAllAccount;
    }

    public String getMessage(String fromAccountNum, String toAccountNum, long amount)  {
        Account accountFrom = getAccounts().get(fromAccountNum);
        Account accountTo = getAccounts().get(toAccountNum);

        String message = "";

        if ((getAccounts().get(fromAccountNum).isBlocked() || getAccounts().get(toAccountNum).isBlocked())
                || (accountFrom.getMoney() < amount)) {

            String problem = "";

            if (accountFrom.isBlocked()) {
                problem = "счет № " + fromAccountNum + " заблокирован";
            } else if (accountTo.isBlocked()) {
                problem = "счет № " + fromAccountNum + " заблокирован";
            } else  {
                problem = "недостаточно средств на счете № " + fromAccountNum;
            }

            message = ":" + "\nоперация между счетами № " + fromAccountNum + " и № " + toAccountNum
                    + " не возможна: " + problem;
        }

        if (amount > 50000) {

            String messageBlocked = "";

            try {
                if (isFraud(fromAccountNum, toAccountNum, amount)) {

                        messageBlocked = "\nсчета № " + fromAccountNum + " и № " + toAccountNum
                                + " заблокированы службой безопасности";
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            message = ":" + "\nтранзакция между счетами № " + fromAccountNum
                    + " и № " + toAccountNum + " отправлена на проверку." + messageBlocked;
        }

        return "Перевод на сумму " + amount
                + " со счета № " + fromAccountNum + " на счет № " + toAccountNum
                + message + System.lineSeparator();
    }

}
