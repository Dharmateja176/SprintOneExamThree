import java.util.Scanner;

class Person {
    protected String name;
    protected int birthYear;

    Person(String name, int birthYear) {
        this.name = name;
        this.birthYear = birthYear;
    }

    @Override
    public String toString() {
        return "Name : "+name+"\n"+"BirthYear : "+birthYear;
    }
}

class Staff extends Person {
    protected double salary;

    Staff(String name, int birthYear, double salary) {
        super(name, birthYear);
        this.salary = salary;
    }

    @Override
    public String toString() {
        return super.toString()+"\n"+"Old Salary : "+salary;
    }
}

class Student extends Person {
    protected String department;
    protected double percentage;

    Student(String name, int birthYear, String department, double percentage) {
        super(name, birthYear);
        this.department = department;
        this.percentage = percentage;
    }

    public String isElgible() {
        if (this.percentage >= 75) return "Yes";
        return "No";
    }

    @Override
    public String toString() {
        return super.toString()+"\n"+"Department : "+department+"\n"+"Eligible : "+this.isElgible();
    }
}

class TeachingStaff extends Staff {
    protected String subject;
    protected double resultPercentage;

    public TeachingStaff(String name, int birthYear, double salary, String subject, double resultPercentage) {
        super(name, birthYear, salary);
        this.subject = subject;
        this.resultPercentage = resultPercentage;
    }

    public double calculateNewSalary() {
        double rate = (resultPercentage * 0.001);
        double amount = this.salary * rate;
        return amount + this.salary;
    }

    @Override
    public String toString() {
        return super.toString()+"\n"+"Subject : "+subject+"\n"+"New Salary : "+this.calculateNewSalary();
    }
}

class NonTeachingStaff extends Staff {
    protected String lab;
    protected int experience;

    public NonTeachingStaff(String name, int birthYear, double salary, String lab, int experience) {
        super(name, birthYear, salary);
        this.lab = lab;
        this.experience = experience;
    }
    public double calculateNewSalary(){
        double rate = this.experience * 0.01;
        double amount = this.salary * rate;
        return amount + this.salary;
    }

    @Override
    public String toString() {
        return super.toString()+"\n"+"Lab : "+lab+"\n"+"New Salary : "+this.calculateNewSalary();
    }
}

//Name School class as Main
public class School {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Person person =null;
        int option = sc.nextInt();
        sc.nextLine();
        switch (option){
            case 1 -> {
                String name = sc.nextLine();
                int year = sc.nextInt();
                sc.nextLine();
                String department = sc.nextLine();
                double percentage = sc.nextDouble();
                person = new Student(name,year,department,percentage);
            }
            case 2 -> {
                String name = sc.nextLine();
                int year = sc.nextInt();
                sc.nextLine();
                String subject = sc.nextLine();
                double resultPercentage = sc.nextDouble();
                sc.nextLine();
                double salary = sc.nextDouble();
                person = new TeachingStaff(name,year,salary,subject,resultPercentage);

            }
            case 3 ->{
                String name = sc.nextLine();
                int year = sc.nextInt();
                sc.nextLine();
                String lab = sc.nextLine();
                int experience = sc.nextInt();
                sc.nextLine();
                double salary = sc.nextInt();
                person = new NonTeachingStaff(name,year,salary,lab,experience);
            }
            default -> System.out.println("Invalid Input");
        }
        if(option <=3 && option >= 1)
            System.out.println(person);
    }
}
