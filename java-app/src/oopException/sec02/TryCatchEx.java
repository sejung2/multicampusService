package oopException.sec02;

public class TryCatchEx {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        try {
            System.out.println(arr[5]); // 예외 발생, catch 에서 진행하지 않았으므로 프로그램 종료
            Class class1 = Class.forName("java.lang.String");
            System.out.println("클래스가 존재합니다");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("배열의 인덱스가 범위를 넘어갔습니다.");
        } catch (ClassNotFoundException e) { // 해당 예외 발생 시 예외 정보를 전달받는 참조변수
            System.out.println("클래스가 존재하지 않습니다");
        }
    }
}
