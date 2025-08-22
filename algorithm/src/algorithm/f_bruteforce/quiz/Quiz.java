package algorithm.f_bruteforce.quiz;

public class Quiz {
    public static void main(String[] args) {
        q1(8);
        q2();
    }

    private static void q2() {

    }

    private static void q1(int end) {
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
