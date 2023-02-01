import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

abstract class AccountIfNotWorked {
    String name;
    int number;
    int balance;
    Date startDate;

    public abstract double calculateInterest(Date dueDate);

}

class CurrentAccounttwo extends AccountIfNotWorked {

    @Override
    public double calculateInterest(Date dueDate) {
        double roi = 0.12d;
        long duration = (dueDate.getTime() - startDate.getTime()) / (1000 * 60 * 60 * 24);
        double interest = (balance * roi * duration) / 365;
        return interest;
    }
}

class SavingsAccounttwo extends AccountIfNotWorked {

    @Override
    public double calculateInterest(Date dueDate) {
        double roi = 0.05d;

        long duration = (dueDate.getTime() - startDate.getTime()) / (1000 * 60 * 60 * 24);
        double interest = (balance * roi * duration) / 365;
        return interest;
    }
}

class CalculateInteresttwo {
    public static void main(String[] args) throws ParseException {
        AccountIfNotWorked a;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Scanner sc = new Scanner(System.in);
        int type = sc.nextInt();
        sc.nextLine();
        String name = sc.nextLine();
        int number = sc.nextInt();
        sc.nextLine();
        int amount = sc.nextInt();
        sc.nextLine();
        String startDate = sc.nextLine();
        String endDate = sc.nextLine();

        if (type == 1) a = new CurrentAccounttwo();
        else a = new SavingsAccounttwo();
        a.name = name;
        a.number = number;
        a.balance = amount;
        a.startDate = sdf.parse(startDate);
        System.out.println(a.calculateInterest(sdf.parse(endDate)));
    }
}
