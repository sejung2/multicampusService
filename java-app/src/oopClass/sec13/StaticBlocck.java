package oopClass.sec13;

class StaticBlock {
    int a;

    void method() {
    }

    static int staticA;

    static void staticMethod() {
    }

    static {
        int b = 1;
        // method1() {} // Cannot define instance methods in static block

        staticA = 10;
        staticMethod();
    }

    static {
        int c = 10;
        double bc = 5.0;
    }
}
