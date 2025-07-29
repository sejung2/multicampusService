package oopClass.sec01;

public class Car {
    private String carNo;
    private String carName;
    private String carMaker;
    private int carYear;
    private int carCC;

    public void setCarInfo(){
        this.carNo = "1234";
        this.carName = "Model S";
        this.carMaker = "Tesla";
        this.carYear = 2021;
        this.carCC = 1000;
    }

    public void showCarInfo() {
        System.out.println("Car No: " + carNo);
        System.out.println("Car Name: " + carName);
        System.out.println("Car Maker: " + carMaker);
        System.out.println("Car Year: " + carYear);
        System.out.println("Car CC: " + carCC);
    }
}
