package view;

// controller가 사용자에게 결과 메세지를 보여줌
public class ResultView {
    public static void succMsg(String msg) {
        System.out.println("성공 : " + msg);
    }
    public static void errorMsg(String msg) {
        System.out.println("실패 : " + msg);
    }
}
