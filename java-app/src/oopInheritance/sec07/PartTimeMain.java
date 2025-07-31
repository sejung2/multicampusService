package oopInheritance.sec07;

public class PartTimeMain {
    public static void main(String[] args) {
        PartTime partWorker = new PartTime("123456-1234567", "홍길동", 10, 10000);
        Worker worker = new Worker("123456-1234567", "홍길동");
        System.out.println(partWorker);
    }
}
