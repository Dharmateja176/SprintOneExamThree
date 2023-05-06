package Question_4;
// ignore package name
//start from here
import java.util.Scanner;

//Question 4
class Event{
    protected String name,detail,type,organiserName;

    public Event() {
    }

    public Event(String name, String detail, String type, String organiserName) {
        this.name = name;
        this.detail = detail;
        this.type = type;
        this.organiserName = organiserName;
    }
    @Override
    public String toString() {
        return name+" "+detail+" "+type+" "+organiserName;
    }
}
class Exhibition extends Event{
    private int noOfStalls;

    public Exhibition() {
        super();
    }
    public Exhibition(String name, String detail, String type, String organiserName, int number) {
        super(name, detail, type, organiserName);
        this.noOfStalls = number;
    }

    @Override
    public String toString() {
        return super.toString()+" "+noOfStalls;
    }
}
class StageEvent extends Event{
    private int noOfSeats;
    public StageEvent(){}
    public StageEvent(String name, String detail, String type, String organiserName, int noOfSeats) {
        super(name, detail, type, organiserName);
        this.noOfSeats = noOfSeats;
    }
    @Override
    public String toString() {
        return super.toString()+" "+noOfSeats;
    }
}

public class Main {
    public static void main(String[] args) {
        Event event = null;
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
        sc.nextLine();
        String details = sc.nextLine();
        String[] array = details.split(",");
        String name = array[0];
        String detail = array[1];
        String type = array[2];
        String organiserName = array[3];
        int number = Integer.parseInt(array[4]);
        if (option == 1) {
            event = new StageEvent(name, detail, type, organiserName, number);
        } else if (option == 2) {
            event = new Exhibition(name, detail, type, organiserName, number);
        } else {
            System.out.println("Invalid input");
        }
        if(event != null)
            System.out.println(event);
    }
}
