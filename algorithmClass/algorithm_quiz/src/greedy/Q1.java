package greedy;

import java.util.Arrays;

public class Q1 {
    public static void main(String[] args) {
        // Greedy Quiz
        //매개변수로 금액을 전달하면
        //동전 개수를 최소화 할 수 있는
        //동전 조합을 구하는 함수를 작성하시오
        //동전 종류 : 500, 100, 50, 10, 1
        //입력 :  3465
        //출력 :  {500: 6, 100: 4, 50: 1, 10: 1, 1: 5}

        q1(3465);
    }

    private static void q1(int num) {
        int amount = num;
        int[] coins = {500, 100, 50, 10, 1};
        int[] result = new int[coins.length];

        for (int i = 0; i < coins.length; i++) {
            if (amount >= coins[i]) {
                result[i] = amount / coins[i]; //해당 동전의 개수
                amount = amount % coins[i]; //남은 금액
            }
        }
        System.out.println(Arrays.toString(result));
    }
}
