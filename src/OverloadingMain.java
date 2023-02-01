//Header
public class OverloadingMain {

    //    Code starts here
    private static void main(String s) {

        System.out.println("Overloaded: " + s);
    }
    private static void main(String tom, String jerry) {

        System.out.println("Overloaded: " + tom + " & " + jerry);
    }
    //    Code ends here



//Footer
    public static void main(String[] args) {
        System.out.println("Hi");
        main("Hello world");
        main("Tom", "Jerry");
    }
}
