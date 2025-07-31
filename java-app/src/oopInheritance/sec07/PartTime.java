package oopInheritance.sec07;

public class PartTime extends Worker {
    private int hours;
    private int unitPrice;

    public PartTime(String joomiNo, String name, int hours, int unitPrice) {
        super(joomiNo, name);
        this.hours = hours;
        this.unitPrice = unitPrice;
    }

    public int calculatePay() {
        return hours * unitPrice;
    }

    @Override
    public String toString() {
        return super.toString() + "PartTime{" +
                "hours=" + hours +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
