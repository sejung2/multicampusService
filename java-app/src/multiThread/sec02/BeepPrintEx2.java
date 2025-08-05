package multiThread.sec02;

import java.awt.*;

public class BeepPrintEx2 {
    public static void main(String[] args) {
        // 익명 구현 객체로 Runnable 인터페이스 구현
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Toolkit toolkit = Toolkit.getDefaultToolkit();
                for (int i = 0; i < 5; i++) {
                    toolkit.beep();
                    try {
                        Thread.sleep(500); // 0.5초 대기
                    } catch (Exception e) {
                    }
                }
            }
        });
        thread.start();

        for (int i = 0; i < 5; i++) {
            System.out.println("띵");
            try {
                Thread.sleep(500); // 0.5초 대기
            } catch (Exception e) {
                // 예외 처리
            }
        }
    }
}
