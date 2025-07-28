package package2;

public class Break {
    public static void main(String[] args) {
        int i = 0;

        while (true) {
            i += 3;

            System.out.println("i = " + i);
            if( i > 20) break;
        }
    }
}
