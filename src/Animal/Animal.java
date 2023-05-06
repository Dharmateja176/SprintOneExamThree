package Animal;

//Header
public class Animal {
    void Print(){
        System.out.println("Animal");
    }
}

//Code Starts Here
class Dog extends Animal{
    @Override
    void Print(){
        System.out.println("Dog");
    }
}
class Cat extends Animal{
    @Override
    void Print(){
        System.out.println("cat");
    }
}
//Code ends here

//Footer
class AnimalSolution{
    public static void main(String[] args) {
        Animal a;
        a = new Dog();
        a.Print();
        a = new Cat();
        a.Print();

    }
}
