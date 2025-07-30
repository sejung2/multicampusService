package oopInheritance.sec05;

class SuperClass {
    int x;
    int y;

    public SuperClass() {
        this.x = 1;
        this.y = 2;
    }
}

class SubClass extends SuperClass {
    int y;

    public SubClass() {
        this.y = 2;
    }

    public void show() {
        System.out.println(x);
        System.out.println("this.x : " + this.x);
        System.out.println("super.x : " + super.x);
        System.out.println(y);
    }
}

public class SuperRefMain {
    public static void main(String[] args) {
        SubClass sc = new SubClass();

        sc.show();
    }    
}
