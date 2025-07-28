package package1;

public class TypeCasting {
    public static void main(String[] args) {
        // 타입변환
        // 데이터 타입을 다른 타입으로 변환하는 것
        // 묵시적(자동) 타입변환: Promotion, 명시적(강제) 타입변환: Casting
        // 타입변환은 변수의 타입이 저장하고자하는 리터럴 크기보다 크거나 작을 때

        // 자동타입변환 : 작은 크기 타입이 큰 크기 타입으로 저장될 때
        // long형을 float형에 저장할 수 있나? 8byte -> 4byte 저장
        // byte 크기가 아닌 값의 표현 범위에 따라 규정
        // byte < short < int < long < float < double

        byte byteVal = 10;
        int intVal = byteVal;
        System.out.println("intVal = " + intVal);

        char charVal = '가';
        intVal = charVal; // 2byte 크기의 값이 4byte 변수에 저장
        System.out.println("intVal = " + intVal); // '가'의 유니코드 값 44032
    }
}
