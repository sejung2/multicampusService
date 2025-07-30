package oopClass.sec13;

public class Share {
    int a;
    static int staticA;

    public void set(int n) {
        a += n;
        staticA += n;
    }

    public int getA() {
        return a;
    }

    public int getStaticA() {
        return staticA;
    }

    static {
        int b = 1;
    }

    static void staticMethod2() {
        // this.a = 100; // Cannot access instance variables in static method

        StaticBlock s = new StaticBlock();
        s.a = 200;
        s.method();
    }
}