package oopInheritance.sec07;

public class Car {

    private String carNo;
    private String carName;
    private String carMaker;
    private int carYear;

    public Car(String carNo, String carName, String carMaker, int carYear) {
        this.carNo = carNo;
        this.carName = carName;
        this.carMaker = carMaker;
        this.carYear = carYear;
    }

    @Override
    public String toString() {
        return "차량번호 : " + carNo+ '\n' +
                "차종 : " + carName + '\n' +
                "제조사 : " + carMaker + '\n' +
                "연식 : " + carYear;
    }
}
