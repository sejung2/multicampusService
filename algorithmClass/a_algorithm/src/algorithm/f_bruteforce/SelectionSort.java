package algorithm.f_bruteforce;

import algorithm.util.SortUtil;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = SortUtil.createRandomIntArray(10);
        SortUtil.checkTime(()->{
            selectionSort(arr);
            System.out.println(Arrays.toString(arr));
        });
    }

    private static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = indexOfMin(arr, i);
            SortUtil.swap(arr, i, minIndex);
        }
    }

    private static int indexOfMin(int[] arr, int pointer) {
        int min = pointer;
        for (int i = pointer+1; i < arr.length; i++) {
            if (arr[min] > arr[i]) min = i;
        }
        return min;
    }
}
