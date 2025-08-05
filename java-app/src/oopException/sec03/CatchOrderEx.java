package oopException.sec03;

public class CatchOrderEx {
    public static void main(String[] args) {
        // 모든 예외처리 클래스는 상위 클래스인 Exception 클래스를 상속받는다.
        // Exception 클래스는 모든 예외를 처리할 수 있는 클래스이므로 다른 예외처리 클래스보다 아래에 위치해야 한다.
        try {
            String data = "a3";
            int var1 = Integer.parseInt(data);
            System.out.println(var1 + 10);
        } catch (NumberFormatException e) {
            System.out.println("오류 발생");
        } catch (Exception e) {
            System.out.println("오류발생 : 상위 클래스");
        } finally {

        }
    }
}
