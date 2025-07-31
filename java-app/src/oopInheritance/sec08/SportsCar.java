package oopInheritance.sec08;


public class SportsCar extends MyCar {
    @Override
    public void speedUp() {
        super.speedUp();
    }

    @Override
    public void stop() {
        System.out.println("스포츠카가 멈춥니다.");
        super.stop();
    }
}
