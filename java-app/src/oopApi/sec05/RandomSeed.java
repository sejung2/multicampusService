package oopApi.sec05;

import java.util.Random;

public class RandomSeed {
    public static void main(String[] args) {
        Random r = new Random(); // 실행 시 시드가 고정되지 않음
        // Random r = new Random(12345); // 시드를 고정하면 항상 같은 난수를 생성
        for (int i = 0; i < 5; i++) {
            int x = r.nextInt(10) + 1;
            System.out.println(x);
        }
    }
}
