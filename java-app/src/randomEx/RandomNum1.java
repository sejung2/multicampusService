package randomEx;

public class RandomNum1 {
    public static void main(String[] args) {
        // 랜덤 숫자 생성 - 1. Math.random() : 0.0 이상 1.0 미만의 난수 생성
        for (int i = 0; i < 10; i++) {
            double num = Math.random() * 10; // 0.0 이상 10.0 미만의 난수 생성
            int num1 = (int)(Math.random() * 10); // 0 이상 10 미만의 정수 난수 생성
            int num2 = (int)(Math.random() * 10) + 1; // 1 이상 11 미만의 정수 난수 생성
            System.out.println("num = " + num);
            System.out.println("num = " + num1);
            System.out.println("num = " + num2);
        }
    }
}
