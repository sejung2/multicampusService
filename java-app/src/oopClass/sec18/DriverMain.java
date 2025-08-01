package oopClass.sec18;

public class DriverMain {
    public static void main(String[] args) {
        Driver driver;
        Vehicle bus = new Bus();
        Vehicle taxi = new Taxi();
        driver = new Driver(bus); // Bus is running
        driver = new Driver(taxi); // Taxi is running
    }
}
