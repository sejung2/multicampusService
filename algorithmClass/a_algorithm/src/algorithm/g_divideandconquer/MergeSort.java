package algorithm.g_divideandconquer;

import algorithm.util.SortUtil;

import java.util.Arrays;

// top-down (하양식)
// 커다란 문제를 작은 부분으로 분할하며 해결
// divide(분할) conquer(정복) combine(결합)
// 시작점: 전체배열
// 진행방향: 전체배열 -> 분할 -> 정복 -> 병합
public class MergeSort {

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 7, 9, 2, 4, 6, 8, 10};
        SortUtil.checkTime(() -> {
            mergeSort(SortUtil.createRandomIntArray(10000000));
        });
    }

    private static int[] mergeSort(int[] arr) {
        int n = arr.length;
        if (n <= 1) return arr;

        int mid = n / 2;
        int[] arr1 = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] arr2 = mergeSort(Arrays.copyOfRange(arr, mid, n));
        return merge(arr1, arr2);
    }

    private static int[] merge(int[] a, int[] b) {
        int[] res = new int[a.length + b.length];
        int p1 = 0, p2 = 0, idx = 0;

        while (p1 < a.length && p2 < b.length) {
            if (a[p1] < b[p2]) {
                res[idx] = a[p1];
                p1++;
            } else {
                res[idx] = b[p2];
                p2++;
            }
            idx++;
        }

        while (p1 < a.length) {
            res[idx] = a[p1];
            idx++;
            p1++;
        }
        while (p2 < b.length) {
            res[idx] = b[p2];
            idx++;
            p2++;
        }

        return res;
    }
}
