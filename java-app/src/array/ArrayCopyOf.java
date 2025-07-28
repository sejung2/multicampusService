package array;

import java.util.Arrays;

public class ArrayCopyOf {
    public static void main(String[] args) {
        // Arrays.copyOf() 메서드를 사용한 깊은 복사
        int[] a = {1, 2, 3, 4};
        int[] b = Arrays.copyOf(a, 2); // a 배열을 b로 깊은 복사
        System.out.println("Original array a: " + Arrays.toString(a));
        System.out.println("Copied array b: " + Arrays.toString(b));
        b[0] = 100; // b를 통해 a의 값 변경
        System.out.println("After modifying b:");
        System.out.println("Array a: " + Arrays.toString(a));
        System.out.println("Array b: " + Arrays.toString(b));
    }
}
