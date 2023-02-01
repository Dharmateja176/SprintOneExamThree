import java.util.Scanner;

//Question 4
class Event{
    protected String name,detail,type,organiserName;

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


    public Exhibition(String name, String detail, String type, String organiserName,int noOfStalls) {
        super(name, detail, type, organiserName);
        this.noOfStalls = noOfStalls;
    }

    @Override
    public String toString() {
        return super.toString()+" "+noOfStalls;
    }
}
class StageEvent extends Event{
    private int noOfSeats;

    public StageEvent(String name, String detail, String type, String organiserName, int noOfSeats) {
        super(name, detail, type, organiserName);
        this.noOfSeats = noOfSeats;
    }
    @Override
    public String toString() {
        return super.toString()+" "+noOfSeats;
    }
}

//Name this class as Main
public class SuperKeyword {
    public static void main(String[] args) {
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
        Event event = null;
        switch (option){
            case 1-> event = new StageEvent(name, detail,type,organiserName,number);
            case 2 -> event = new Exhibition(name, detail,type,organiserName,number);
            default -> System.out.println("Invalid input");
        }
        if(option == 1 || option == 2)
            System.out.println(event);
    }
}
