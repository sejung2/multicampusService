package oopException.sec06;

public class BalanceInsufficientException extends Exception {
    // 예외 클래스여도 사용자 정의 클래스이므로 필드, 생성자, 메소드 등을 정의할 수 있음
    // 매개변수가 없는 기본 생성자(없어도 됨)와 예외 메시지를 받는 생성자를 정의
    public BalanceInsufficientException() {
    }

    public BalanceInsufficientException(String message) {
        super(message); // Exception 클래스의 생성자에 메시지를 전달
    }

}
