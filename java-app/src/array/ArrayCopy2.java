package array;

public class ArrayCopy2 {

    public static void main(String[] args) {
        // 메서드 사용 없이 깊은 복사
        // 새로운 배열을 생성하고 원본 배열의 값을 복사
        int[] a = {1, 2, 3, 4};
        int[] b = new int[4];

        for (int i = 0; i < a.length; i++) {
            b[i] = a[i]; // 원본 배열의 값을 새로운 배열에 복사
        }

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + " ");
        }

        System.out.println(

        );
    }
}
