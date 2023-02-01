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

    public abstract double calculateInterest(Date dueDate);

}

class CurrentAccount extends Account {

    @Override
    public double calculateInterest(Date dueDate) {
        double roi = 0.12d;
        Calendar calandar = Calendar.getInstance();
        calandar.setTime(startDate);
        int startYear = calandar.get(Calendar.YEAR);
        calandar.setTime(dueDate);
        int endYear = calandar.get(Calendar.YEAR);
        System.out.println(startYear+" "+endYear);
        long diff = endYear - startYear;
        System.out.println(diff);
        return (balance * diff * roi);
    }
}

class SavingsAccount extends Account {

    @Override
    public double calculateInterest(Date dueDate) {
        double roi = 0.05d;

        Calendar calandar = Calendar.getInstance();
        calandar.setTime(startDate);
        int startYear = calandar.get(Calendar.YEAR);
        calandar.setTime(dueDate);
        int endYear = calandar.get(Calendar.YEAR);
        System.out.println(startYear+" "+endYear);
        long diff = endYear - startYear;
        System.out.println(diff);
        return (balance * diff * roi);
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
        sc.nextLine();
        int amount = sc.nextInt();
        sc.nextLine();
        String startDate = sc.nextLine();
        String endDate = sc.nextLine();

        if (type == 1) a = new CurrentAccount();
        else a = new SavingsAccount();
        a.name = name;
        a.number = number;
        a.balance = amount;
        a.startDate = sdf.parse(startDate);
        System.out.println(a.calculateInterest(sdf.parse(endDate)));
    }
}
