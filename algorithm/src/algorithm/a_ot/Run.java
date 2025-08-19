package algorithm.a_ot;

public class Run {
    public static void main(String[] args) {
        //swap();
        swapUsingBit();

    }

    private static void swapUsingBit() {
        int a = 11;
        int b = 16;

        // (a ^ b) ^ b = a
        // (a ^ b) ^ b = b
        a = a^b;
        b = a^b;
        a = b^a;

        System.out.println(a);
        System.out.println(b);
        // a xor 0 은 언제나 a
        // a xor 1 은 언제나 not a
    }

    private static void swap() {
        // a 값 b에, b에 담긴값 a에
        int a = 10;
        int b = 15;

        int temp = a;

        a = b;
        b = temp;
        System.out.println(a);
        System.out.println(b);
    }
}
