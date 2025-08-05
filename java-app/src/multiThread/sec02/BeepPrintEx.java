package multiThread.sec02;

public class BeepPrintEx {
    public static void main(String[] args) {
        Runnable beepTask = new BeepTask(); // 스레드가 진행할 작업 객체
        Thread thread = new Thread(beepTask); // 작업객체를 포함한 스레드 생성

        thread.start(); // 스레드 시작

        for (int i = 0; i < 5; i++) {
            System.out.println("띵");
            try {
                Thread.sleep(500);
            } catch (Exception e) {
            }

        }
    }
}
