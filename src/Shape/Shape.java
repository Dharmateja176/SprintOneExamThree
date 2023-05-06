package Shape;
//ignore package
//start from here
import java.text.DecimalFormat;
import java.util.Scanner;

class Shape {
    protected double area;
    DecimalFormat df = new DecimalFormat("0.00");
    public void computeArea() {
        area = 0;
    }
}

class Circle extends Shape {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public void computeArea() {
        area = ((3.14) * (radius * radius));
        System.out.println(df.format(area));
    }
}

class Rectangle extends Shape {
    private final double length;
    private final double breadth;

    Rectangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    @Override
    public void computeArea() {
        area = length * breadth;
        System.out.println(df.format(area));
    }
}

class Triangle extends Shape {
    private final double base;
    private final double height;

    Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public void computeArea() {
        area = 0.5 * base * height;
        System.out.println(df.format(area));
    }
}

//  Name the Shape.AreaCalculator as Main
class Main {
    public static void main(String[] args) {
        Shape shape = null;
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
        switch (option) {
            case 1: {
                shape = new Circle(sc.nextDouble());
                break;
            }
            case 2: {
                shape = new Rectangle(sc.nextDouble(), sc.nextDouble());
                break;
            }
            case 3: {
                shape = new Triangle(sc.nextDouble(), sc.nextDouble());
                break;
            }
            default:
                System.out.println("Invalid Input");
        }
        if (shape != null)
            shape.computeArea();
    }
}

