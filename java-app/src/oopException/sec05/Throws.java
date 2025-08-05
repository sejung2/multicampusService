package oopException.sec05;

public class Throws {
    public static void main(String[] args) {
        // findClass(); // 메소드에 throws가 선언되어 있어 예외가 발생할 수 있음 try catch로 처리해야 함
        try {
            findClass();
        } catch (ClassNotFoundException e) {
            System.out.println("메소드에서 throws로 떠넘긴 예외는 메소드 호출 시 반드시 처리해야 함");
        }
    }

    public static void findClass() throws ClassNotFoundException {
        Class clazz = Class.forName("java.lang.String2");
    }
}
