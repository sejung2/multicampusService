package algorithm.g_divideandconquer;

import algorithm.d_datastructure.stack._Stack;
import algorithm.util.SortUtil;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 2, 4, 6, 8, 10};
        SortUtil.checkTime(() -> {
            quickSort(arr, 0, arr.length - 1);
            System.out.println(Arrays.toString(arr));
        });
    }

    // 재귀를 사용하지 않은 퀵 정렬
    private static void quickSort(int[] arr, int left, int right) {
        if (left >= right) return;
        _Stack<Integer> stack = new _Stack<>();

        stack.push(left);
        stack.push(right);
        while (!stack.isEmpty()) {
            right = stack.pop();
            left = stack.pop();

            if (left >= right) continue; // 무효한 구간 건너뛰기

            int pivotIndex = partition(arr, left, right);

            if (pivotIndex - 1 > left) {
                stack.push(left);
                stack.push(pivotIndex - 1);
            }

            if (pivotIndex + 1 < right) { // 조건 추가
                stack.push(pivotIndex + 1);
                stack.push(right);
            }
        }
    }

    private static int partition(int[] arr, int first, int last) {
        int pivotElement = arr[first];
        int lp = first;
        int rp = last;

        while (true) {
            while (lp < last && arr[lp] <= pivotElement) {
                lp++;
            }
            while (rp > first && arr[rp] > pivotElement) { // 복습 참고사항: >=, > 차이??
                rp--;
            }

            if (lp >= rp) break;
            SortUtil.swap(arr, lp, rp);
            lp++;
            rp--;
        }
        SortUtil.swap(arr, first, rp);
        return rp;
    }
}
