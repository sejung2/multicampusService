package array;

public class ArrayClone {
    public static void main(String[] args) {
        // Object.clone() 메서드를 사용한 깊은 복사
        int[] a = {1, 2, 3, 4};
        int[] b = a.clone(); // clone() 메서드를 사용하여 깊은 복사

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + " ");
        }
        System.out.println();

        b[0] = 100; // b를 통해 a의 값 변경
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + " ");
        }
    }
}
