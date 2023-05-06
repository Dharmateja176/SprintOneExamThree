package GST;
//ignore package
//start from here
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

class Event {
    String name, detail, type, ownerName;
    double costPerDay;

    public Event(String name, String detail, String type, String ownerName, double costPerDay) {
        this.name = name;
        this.detail = detail;
        this.type = type;
        this.ownerName = ownerName;
        this.costPerDay = costPerDay;
    }
}
class Exhibition extends Event {

    int noOfStall;
    final double rate = 0.05;

    public Exhibition(String name, String detail, String type, String ownerName, double costPerDay, int noOfStall) {
        super(name, detail, type, ownerName, costPerDay);
        this.noOfStall = noOfStall;
    }

    public Double getRate() {
        return rate;
    }
}
class StageEvent extends Event {
    int noOfSeats;
    final double rate = 0.15;

    public StageEvent(String name, String detail, String type, String ownerName, double costPerDay, int noOfSeats) {
        super(name, detail, type, ownerName, costPerDay);
        this.noOfSeats = noOfSeats;
    }

    public Double getRate() {
        return rate;
    }
}

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        int option = sc.nextInt();
        sc.nextLine();
        String name = sc.nextLine();
        String detail = sc.nextLine();
        String type = sc.nextLine();
        String ownerName = sc.nextLine();
        double costPerDay = sc.nextDouble();
        sc.nextLine();
        int number = sc.nextInt();
        sc.nextLine();
        Date startDate = sdf.parse(sc.nextLine());
        Date endDate = sdf.parse(sc.nextLine());
        long timeDiff = Math.abs(endDate.getTime() - startDate.getTime());
        long daysDiff = TimeUnit.DAYS.convert(timeDiff, TimeUnit.MILLISECONDS);
        switch (option) {
            case 1: {
                Exhibition event = new Exhibition(name, detail, type, ownerName, costPerDay, number);
                double total_cost = costPerDay * daysDiff;
                System.out.println(total_cost * event.getRate());
                break;
            }
            case 2: {
                StageEvent event = new StageEvent(name, detail, type, ownerName, costPerDay, number);
                double total_cost = costPerDay * daysDiff;
                System.out.println(total_cost * event.getRate());
                break;
            }
            default:
                System.out.println("Invalid input");
        }
    }
}
