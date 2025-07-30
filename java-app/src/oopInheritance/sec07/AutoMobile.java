package oopInheritance.sec07;

public class AutoMobile extends Car {

    private String autoManual;

    public AutoMobile(String carNo, String carName, String carMaker, int carYear, String autoManual) {
        super(carNo, carName, carMaker, carYear);
        this.autoManual = autoManual;
    }

    @Override
    public String toString() {
        return super.toString() + '\n' +
                "기어변속 : " + autoManual;
    }
}
