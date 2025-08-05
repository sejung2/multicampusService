package oopException.sec04;

public class MultiCatch {
    public static void main(String[] args) {
        // 동일하게 처리하고 싶은 예외를 | 연산자로 묶어서 처리할 수 있다.
        try {
            int[] arr = {1, 2, 3};
            int a = arr[5];
            int var = Integer.parseInt("a100");
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.out.println("예외 발생: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("기타 예외 발생: " + e.getMessage());
        } finally {
            System.out.println("프로그램 종료");
        }
    }
}
