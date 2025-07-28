package array;

public class ArrayCopy {
    public static void main(String[] args) {
        // 얕은 복사: 참조값만 복사
        // 변수 이름만 다르고 참조하는 객체는 동일
        // 원본 변수를 통해 변경하면 복사된 변수에도 영향을 미침
        int[] a = {1, 2, 3, 4,};
        int b[] = a; // 얕은 복사

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
        System.out.println();


    }
}
