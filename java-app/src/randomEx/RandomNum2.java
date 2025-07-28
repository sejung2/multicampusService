package randomEx;

import java.util.Random;

public class RandomNum2 {
    public static void main(String[] args) {
        // 난수 발생 : Random 클래스 사용
        // Random 클래스는 java.util 패키지에 포함되어 있습니다. import java.util.Random;
        // 참조 객체 생성해서 사용해야 함
        // 객체.nextInt() 특정 범위에서 생성
        Random r = new Random();

        for (int i = 0; i < 10; i++) {
            int num = r.nextInt(10);
            int num2 = r.nextInt(10) + 1;
            System.out.println("num = " + num);
            System.out.println("num2 = " + num2);
        }
    }
}
