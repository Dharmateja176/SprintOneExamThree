package Account;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

abstract class Account {
    String name;
    int number;
    int balance;
    Date startDate;
    Calendar calendar = Calendar.getInstance();

    public Account(String name, int number, int balance, Date startDate) {
        this.name = name;
        this.number = number;
        this.balance = balance;
        this.startDate = startDate;
    }

    public abstract double calculateInterest(Date dueDate);

}

class CurrentAccount extends Account {
    public CurrentAccount(String name, int number, int balance, Date startDate) {
        super(name, number, balance, startDate);
    }

    @Override
    public double calculateInterest(Date dueDate) {
        double roi = 0.12d;

        calendar.setTime(startDate);
        int startYear = calendar.get(Calendar.YEAR);

        calendar.setTime(dueDate);
        int endYear = calendar.get(Calendar.YEAR);

        long diff = endYear - startYear;

        return (balance * diff * roi);
    }
}

class SavingsAccount extends Account {
    public SavingsAccount(String name, int number, int balance, Date startDate) {
        super(name, number, balance, startDate);
    }

    @Override
    public double calculateInterest(Date dueDate) {
        double roi = 0.05d;
        calendar.setTime(startDate);
        int startYear = calendar.get(Calendar.YEAR);
        calendar.setTime(dueDate);
        int endYear = calendar.get(Calendar.YEAR);
        long diff = endYear - startYear;
        return (balance * diff * roi);
    }
    public void greet(){

    }
}

class CalculateInterest {
    public static void main(String[] args) throws ParseException {
        Account a;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Scanner sc = new Scanner(System.in);
        int type = sc.nextInt();
        sc.nextLine();
        String name = sc.nextLine();
        int number = sc.nextInt();
        int amount = sc.nextInt();
        sc.nextLine();
        String startDate = sc.nextLine();
        String endDate = sc.nextLine();

        if (type == 1) a = new CurrentAccount(name, number, amount, sdf.parse(startDate));
        else a = new SavingsAccount(name, number, amount, sdf.parse(startDate));
        System.out.println(a.calculateInterest(sdf.parse(endDate)));
    }
}
