import java.text.DecimalFormat;
import java.util.Scanner;

class Shape {
    protected double area;
    protected Scanner sc = new Scanner(System.in);
    protected DecimalFormat df = new DecimalFormat("0.00");

    public void computeArea() {
        area = 0;
    }
}

class Circle extends Shape {
    private final double radius;

    Circle() {
        radius = sc.nextDouble();
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

    Rectangle() {
        length = sc.nextDouble();
        breadth = sc.nextDouble();
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

    Triangle() {
        base = sc.nextDouble();
        height = sc.nextDouble();
    }

    @Override
    public void computeArea() {
        area = 0.5 * base * height;
        System.out.println(df.format(area));
    }
}

//  Name the AreaCalculator as Main
class AreaCalculator {
    public static void main(String[] args) {
        Shape shape = null;
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
        switch (option) {
            case 1 -> shape = new Circle();
            case 2 -> shape = new Rectangle();
            case 3 -> shape = new Triangle();
            default -> System.out.println("Invalid Input");
        }
        if (option <= 3 && option >= 1)
            shape.computeArea();
    }
}

