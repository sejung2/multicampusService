package array;

import java.util.Arrays;

public class ArraySystemCopy {
    public static void main(String[] args) {
        // System.arraycopy() (원본, 시작인덱스, 대상, 대상 시작인덱스, 길이) : 원본 배열에서 지정된 범위의 요소를 대상 배열로 복사
        int[] a = {1, 2, 3, 4};
        int[] b = new int[a.length];
        //System.arraycopy(a, 0, b, 1, 3);
        System.arraycopy(a, 0, b, 1, a.length-1);

        System.out.println("Original array a: " + Arrays.toString(a));
        System.out.println("Copied array b: " + Arrays.toString(b));
        b[0] = 100; // b를 통해 a의 값 변경
        System.out.println("After modifying b:");
        System.out.println("Array a: " + Arrays.toString(a));
        System.out.println("Array b: " + Arrays.toString(b));

    }
}
