package multiThread.sec02;

import java.awt.*;

public class BeepTask implements Runnable {
    @Override
    public void run() {
        // 5번 비프음을 울리는 작업
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        for (int i = 0; i < 5; i++) {
            toolkit.beep();
            try {
                Thread.sleep(500); // 0.5초 대기
            } catch (Exception e) {
            }
        }
    }
}
