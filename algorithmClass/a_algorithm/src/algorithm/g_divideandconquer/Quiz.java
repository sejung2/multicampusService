package algorithm.g_divideandconquer;

import algorithm.util.SortUtil;

import java.util.Arrays;

public class Quiz {

    public static void main(String[] args) {
        //cpuCacheHit();
        q1();
    }

    private static void q1() {
        int money = 3456;
        int[] coins = {500, 100, 50, 10, 1};
        int[] count = new int[coins.length];
        for (int i = 0; i < coins.length; i++) {
            count[i] = money / coins[i];
            money %= coins[i];
        }
        System.out.println(Arrays.toString(count));
    }

    private static void cpuCacheHit() {
        int size = 10240;
        int[][] dArr = new int[size][size];

        SortUtil.checkTime(() -> {
            for (int i = 0; i < dArr.length; i++) {
                for (int j = 0; j < dArr.length; j++) {
                    dArr[i][j] = i;
                }
            }
        });
    }
}
