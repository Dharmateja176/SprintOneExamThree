//Question 7
import java.util.Arrays;
import java.util.Scanner;

//Name this class as Account
class AccountBase{
    protected String accountNumber;
    protected double balance;
    protected String accountHolderName;
}
//Change AccountBase name accordingly to that you used in above baseClass
class SavingAccount extends AccountBase{
    protected double minimumBalance;
}
class FixedAccount extends SavingAccount{
    private int lockingPeriod;

    public int getLockingPeriod() {
        return lockingPeriod;
    }

    public void setLockingPeriod(int lockingPeriod) {
        this.lockingPeriod = lockingPeriod;
    }
}

class AccountBO{
    public void getAccountDetail(String detail){
        String[] array = detail.split(",");
        System.out.println(Arrays.toString(array));
        System.out.format("%-20s %-10s %-20s %-20s %s\n","Account Number","Balance","Account holder name","Minimum balance","Locking period");
        FixedAccount fa = new FixedAccount();
        fa.accountNumber = array[0];
        fa.balance = Double.parseDouble(array[1]);
        fa.accountHolderName =array[2];
        fa.minimumBalance = Integer.parseInt(array[3]);
        fa.setLockingPeriod(Integer.parseInt(array[4]));
        System.out.format("%-20s %-10.2f %-20s %-20.2f %d\n",fa.accountNumber,fa.balance,fa.accountHolderName,fa.minimumBalance,fa.getLockingPeriod());

    }
}
//Name this class as Main
public class AccountDetails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String detail = sc.nextLine();
        AccountBO bo = new AccountBO();
        bo.getAccountDetail(detail);
    }
}
