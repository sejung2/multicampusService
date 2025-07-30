package oopInheritance.sec06;

public class ComputerMain {
    public static void main(String[] args) {
        int r = 10;

        Calculator cal = new Calculator();
        System.out.println("원의 넓이 : " + cal.areaCircle(r));

        Computer com = new Computer();
        System.out.println("원의 넓이 : " + com.areaCircle(r)); // 재정의하지 않으면 부모 class의 메서드 호출
    }
}
