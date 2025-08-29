package bruteforce;

public class Q1 {
    public static void main(String[] args) {
        int end = 5;
        int doom = 666;
        int count = 0;
        for (int i = 1; i <= end; i++) {
            if (i % 10 == 6) {
                for (int j = 0; j < 10; j++) {
                    if(count == end){
                        System.out.println(i + "" +  66 + "" + j);
                        return;
                    }
                    count++;
                }
            }
            if (i == end) {
                System.out.println(i + "" + doom);
                return;
            }
            count++;
        }
    }
}
