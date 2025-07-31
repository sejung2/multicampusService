package oopInheritance.sec11;

public class CatMain {
    public static void main(String[] args) {
        Animal ani = null;

        ani = new Cat();
        ani.show();
        ani.sound();

        ani.animalMethod();

        Cat c = (Cat) ani; // Downcasting
        c.catMethod(); // Now we can call Cat specific method

        Animal aa = new Animal();
        if (aa instanceof Cat) {
            Cat cc = (Cat) aa; // This will throw ClassCastException at runtime
            cc.catMethod();
        } else {
            System.out.println("aa is not an instance of Cat");
        }
    }
}
