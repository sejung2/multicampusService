package greedy;

import java.util.Arrays;

public class Q1 {
    public static void main(String[] args) {
        int money = 3456;
        int[] coins = {500, 100, 50, 10, 1};
        int[] count = new int[coins.length];
        for (int i = 0; i < coins.length; i++) {
            count[i] = money / coins[i];
            money %= coins[i];
        }
        System.out.println(Arrays.toString(count));
    }
}
