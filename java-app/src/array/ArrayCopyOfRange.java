package array;

import java.util.Arrays;

public class ArrayCopyOfRange {
    public static void main(String[] args) {
        // Arrays.copyOfRange()  (원본 배열, 시작 인덱스, 끝 인덱스) : 원본 배열에서 시작인덱스 ~ 끝 인덱스-1 까지의 요소를 복사하여 새로운 배열을 생성
        int[] a = {1, 2, 3, 4};
        int[] b = Arrays.copyOfRange(a, 1, 3); // a 배열의 인덱스 1부터 2까지의 요소를 b로 깊은 복사
        System.out.println("Original array a: " + Arrays.toString(a));
        System.out.println("Copied array b: " + Arrays.toString(b));
        b[0] = 100; // b를 통해 a의 값 변경
        System.out.println("After modifying b:");
        System.out.println("Array a: " + Arrays.toString(a));
        System.out.println("Array b: " + Arrays.toString(b));

    }
}
