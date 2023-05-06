import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

//Name this class as Event
// will be
//class Event {
class GSTEvent {
    String name, detail, type, ownerName;
    double costPerDay;

    public GSTEvent(String name, String detail, String type, String ownerName, double costPerDay) {
        this.name = name;
        this.detail = detail;
        this.type = type;
        this.ownerName = ownerName;
        this.costPerDay = costPerDay;
    }
}

//Name this class as Exhibition and Super class is Event
// will be
// class Exhibition extends Event {
class GSTExhibition extends GSTEvent {

    int noOfStall;
    final double rate = 0.05;

    //   Name it as Exhibtion not GSTExhibition
    public GSTExhibition(String name, String detail, String type, String ownerName, double costPerDay, int noOfStall) {
        super(name, detail, type, ownerName, costPerDay);
        this.noOfStall = noOfStall;
    }

    public Double getRate() {
        return rate;
    }
}

//Name this class as StageEvent
// will be
// class Exhibition extends Event {
class GSTStageEvent extends GSTEvent {
    int noOfSeats;
    final double rate = 0.15;

    //   Name it as StageEvent not GSTStageEvent
    public GSTStageEvent(String name, String detail, String type, String ownerName, double costPerDay, int noOfSeats) {
        super(name, detail, type, ownerName, costPerDay);
        this.noOfSeats = noOfSeats;
    }

    public Double getRate() {
        return rate;
    }
}

public class GSTCalculation {
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
                GSTExhibition event = new GSTExhibition(name, detail, type, ownerName, costPerDay, number);
                double total_cost = costPerDay * daysDiff;
                System.out.println(total_cost * event.getRate());
                break;
            }
            case 2: {
                GSTStageEvent event = new GSTStageEvent(name, detail, type, ownerName, costPerDay, number);
                double total_cost = costPerDay * daysDiff;
                System.out.println(total_cost * event.getRate());
                break;
            }
            default:
                System.out.println("Invalid input");
        }
    }
}
