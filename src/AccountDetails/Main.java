package AccountDetails;
//Question 7
//Ignore Package
//Start from here
import java.util.Scanner;

class Account {
    protected String accountNumber;
    protected double balance;
    protected String accountHolderName;

    public Account(String accountNumber, double balance, String accountHolderName) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountHolderName = accountHolderName;
    }
}
class SavingAccount extends Account {
    protected double minimumBalance;

    public SavingAccount(String accountNumber, double balance, String accountHolderName, double minimumBalance) {
        super(accountNumber, balance, accountHolderName);
        this.minimumBalance = minimumBalance;
    }
}
class FixedAccount extends SavingAccount {
    private int lockingPeriod;

    public FixedAccount(String accountNumber, double balance, String accountHolderName, double minimumBalance, int lockingPeriod) {
        super(accountNumber, balance, accountHolderName, minimumBalance);
        this.lockingPeriod = lockingPeriod;
    }

    public int getLockingPeriod() {
        return lockingPeriod;
    }
}

class AccountBO{
    public  AccountBO(String detail){
        String[] array = detail.split(",");
        System.out.format("%-20s %-10s %-20s %-20s %s\n","Account.Account Number","Balance","Account.Account holder name","Minimum balance","Locking period");
        FixedAccount fa = new FixedAccount(
                array[0],
                Double.parseDouble(array[1]),
                array[2],
                Integer.parseInt(array[3]),
                Integer.parseInt(array[4])
        );
        System.out.format("%-20s %-10.2f %-20s %-20.2f %d\n",
                fa.accountNumber,fa.balance,fa.accountHolderName,fa.minimumBalance,fa.getLockingPeriod());
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String detail = sc.nextLine();
        AccountBO bo = new AccountBO(detail);
    }
}
