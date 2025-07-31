package oopInheritance.sec09;

public class PolyMorphismMain {
    public static void main(String[] args) {
        Child child = new Child();

        Parent parent;
        parent = child; // Upcasting

        parent.method1();
    }
}
