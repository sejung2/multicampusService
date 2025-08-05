package multiThread.sec01;

import java.awt.*;

public class BeepPrint {
    public static void main(String[] args) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();

        for (int i = 0; i < 5; i++) {
            toolkit.beep();
            try {
                Thread.sleep(500);
            } catch (Exception e) {
            }
        }

        for (int i = 0; i < 5; i++) {
            System.out.println("띵");
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                // 예외 처리: InterruptedException이 발생할 수 있지만, 여기서는 단순히 무시함
            }
        }
    }
}
