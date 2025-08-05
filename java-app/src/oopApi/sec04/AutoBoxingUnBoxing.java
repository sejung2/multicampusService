package oopApi.sec04;

public class AutoBoxingUnBoxing {
    public static void main(String[] args) {
        Integer obj = 100;
        // 오토 박싱: Integer 객체를 기본형 int로 변환
        System.out.println("obj = " + obj.intValue());

        // 언박싱: Integer 객체를 기본형 int로 변환
        int value = obj; // 오토 언박싱
        int result = obj + 100; // 오토 언박싱 후 덧셈
        System.out.println(result);

        Short.parseShort("100"); // 문자열을 short로 변환
        Double.parseDouble("3.5"); // 문자열을 double로 변환
        Boolean.parseBoolean("true"); // 문자열을 boolean으로 변환

        // wrapper 클래스의 내부 값 비교 : == != 연산자 사용불가
    }
}
