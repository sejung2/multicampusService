package oopInheritance.carEx;

public class CarAutomobile {
    public static void main(String[] args) {
        Car car = new Car("01가 1234", "소나타", "현대", 2023);
        AutoMobile autoMobile = new AutoMobile("02나 5678", "아반떼", "현대", 2023, "자동");

        System.out.println(car);
        System.out.println("--------------------");
        System.out.println(autoMobile);
    }
}
