package genericCollection.sec03;

public class ProductMain {
    public static void main(String[] args) {
        Product<Tv, String> prd1 = new Product<>();
        Product<Car, String> prd2 = new Product<>();

        prd1.setType(new Tv());
        prd1.setModel("Samsung QLED");
        prd2.setType(new Car());
        prd2.setModel("Tesla Model S");

        String tvModel = prd1.getModel();
        String carModel = prd2.getModel();

        System.out.println("TV Model: " + tvModel);
        System.out.println("Car Model: " + carModel);
    }
}
