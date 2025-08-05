package multiThread.sec04;

public class MultiThreadEx {
    public static void main(String[] args) {
        MultiThread t1 = new MultiThread(1); // 스레드 1 생성
        MultiThread t2 = new MultiThread(2); // 스레드 2 생성
        MultiThread t3 = new MultiThread(3); // 스레드 3 생성

        t1.start();
        t2.start();
        t3.start();
    }
}
