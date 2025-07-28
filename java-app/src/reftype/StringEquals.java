package reftype;

public class StringEquals {
    public static void main(String[] args) {

        // 문자열 객체 생성 1: string 변수명 = "문자열";
        String strValue1 = "홍길동";
        String strValue2 = "홍길동";
        if (strValue1 == strValue2) {
            System.out.println("strValue1과 strValue는 참조값이 같음");
        } else {
            System.out.println("strValue1과 strValue는 참조값이 다름");
        }

        // equals() 메서드로 문자열 비교
        if (strValue1.equals(strValue2)) {
            System.out.println("strValue1과 strValue2는 문자열 내용이 같음");
        } else {
            System.out.println("strValue1과 strValue2는 문자열 내용이 다름");
        }

        // 문자열 객체 생성 2: new String("문자열");
        String strValue3 = new String("홍길동"); // 명시적인 메모리 할당(객체 새로 생성)
        String strValue4 = new String("홍길동");
        if (strValue3 == strValue4) {
            System.out.println("strValue3과 strValue4는 참조값이 같음");
        } else {
            System.out.println("strValue3과 strValue4는 참조값이 다름");
        }
        if( strValue3.equals(strValue4)) {
            System.out.println("strValue3과 strValue4는 문자열 내용이 같음");
        } else {
            System.out.println("strValue3과 strValue4는 문자열 내용이 다름");
        }
    }
}
