package package1;

public class Reap {
    public static void main(String[] args) {
        int sum = 0;

        for (int i = 0; i < 10; i++) {
            System.out.println("i = " + i);
            sum += i;
        }
        System.out.println("Sum = " + sum);
    }
}
