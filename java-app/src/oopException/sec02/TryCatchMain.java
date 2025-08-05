package oopException.sec02;

public class TryCatchMain {
    public static void main(String[] args) {
        String data1 = "3";
        String data2 = "a3";

        try {
            Class class1 = Class.forName("java.lang.String");
            System.out.println("클래스가 존재합니다");
        } catch (ClassNotFoundException e) { // 해당 예외 발생 시 예외 정보를 전달받는 참조변수
            System.out.println("클래스가 존재하지 않습니다");
        }

        // 문자열을 정수로 변환 - 예외 발생 가능( 문자열에 숫자가 아닌 문자가 포함된 경우 )
        try {
            int value1 = Integer.parseInt(data1);
            int value2 = Integer.parseInt(data2);
            int result = value1 + value2;
        } catch (NumberFormatException e) {
            System.out.println("숫자로 변환할 수 없는 문자열이 있습니다");
        } finally {
            System.out.println("다시 실행하세요");
        }

    }
}
