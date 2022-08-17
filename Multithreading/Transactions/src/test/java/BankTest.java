import junit.framework.TestCase;
import org.junit.Before;

import java.util.HashMap;
import java.util.Map;

public class BankTest extends TestCase {

    Bank testBank = new Bank();
    Account account1 = new Account(0, "1");
    Account account2 = new Account(100_000, "2");
    Account account3 = new Account(200_000, "3");
    Account account4 = new Account(1000, "4");
    Map<String, Account> accounts;

    @Override
    protected void setUp() throws Exception {
        accounts = new HashMap<>();
        testBank.addAccount(account1);
        testBank.addAccount(account2);
        testBank.addAccount(account3);
        testBank.addAccount(account4);

    }

    @Before
    public void clearBank() {
        testBank = null;
    }

    public void testTransfer() {

        String fromAccountNum = account4.getAccNumber();
        String toAccountNum = account1.getAccNumber();
        long amount = 1000;
        testBank.transfer(fromAccountNum, toAccountNum, amount);

        long actualFrom = account4.getMoney();
        long expectedFrom = 0;
        long actualTo = account1.getMoney();
        long expectedTo = 1000;

        assertEquals(expectedFrom, actualFrom);
        assertEquals(expectedTo, actualTo);

    }

    public void testTransferWithBlockedAcc() {
        String fromAccountNum = account3.getAccNumber();
        String toAccountNum = account2.getAccNumber();
        long amount = 500;
        account3.setBlocked(true);
        testBank.transfer(fromAccountNum, toAccountNum, amount);

        long actualFrom = account3.getMoney();
        long expectedFrom = 200_000;
        long actualTo = account2.getMoney();
        long expectedTo = 100_000;

        assertEquals(expectedFrom, actualFrom);
        assertEquals(expectedTo, actualTo);
    }

    public void testTransferWithNotEnoughMoney() {
        String fromAccountNum = account1.getAccNumber();
        String toAccountNum = account2.getAccNumber();
        long amount = 5000;
        testBank.transfer(fromAccountNum, toAccountNum, amount);

        long actualFrom = account1.getMoney();
        long expectedFrom = 0;
        long actualTo = account2.getMoney();
        long expectedTo = 100_000;

        assertEquals(expectedFrom, actualFrom);
        assertEquals(expectedTo, actualTo);
    }

    public void testGetBalance() {
        long actual = testBank.getBalance(account1.getAccNumber());
        long expected = 0;
        assertEquals(expected, actual);

    }

    public void testGetSumAllAccounts() {

        long actual = testBank.getSumAllAccounts();
        long expected = 301_000;
        assertEquals(expected, actual);
    }

}
