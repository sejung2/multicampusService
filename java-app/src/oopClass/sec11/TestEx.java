package oopClass.sec11;

public class TestEx {
    public static void main(String[] args) {
        Test t1 = new Test();
        t1.width = 100;
        t1.area();

        Test t2 = new Test();
        t2.width = 500;
        t2.area();

        Test.width1 = 600;
        Test.area1();
    }
}
