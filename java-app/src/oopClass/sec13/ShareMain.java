package oopClass.sec13;

public class ShareMain {
    public static void main(String[] ignoredArgs) {
        Share s1, s2;

        s1 = new Share();
        s1.set(5);

        System.out.println("After setting s1:");
        System.out.printf("s1.a = %d\n", s1.getA());
        System.out.printf("s1.staticA = %d\n", s1.getStaticA());
        System.out.println();

        s2 = new Share();
        s2.set(5);

        System.out.println("After setting s2:");
        System.out.printf("s2.a = %d\n", s2.getA());
        System.out.printf("s2.staticA = %d\n", s2.getStaticA());
        System.out.printf("Share.staticA = %d\n", Share.staticA);
        System.out.printf("s1.staticA = %d\n", s1.getStaticA());
    }
}
