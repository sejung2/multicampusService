package oopClass.sec17;

public class CarMain {
    public static void main(String[] args) {
        Car myCar = new Car();

        myCar.setSpeed(-50);
        System.out.printf("Speed: %d km/h%n", myCar.getSpeed());

        myCar.setSpeed(60);
        System.out.printf("Speed: %d km/h%n", myCar.getSpeed());

        myCar.setStop(true);
        System.out.printf("Is the car stopped? %b%n", myCar.isStop());
        System.out.printf("Speed after stopping: %d km/h%n", myCar.getSpeed());
    }
}
