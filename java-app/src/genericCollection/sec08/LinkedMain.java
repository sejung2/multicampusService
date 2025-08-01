package genericCollection.sec08;

import java.util.LinkedList;

public class LinkedMain {
    public static void main(String[] args) {
        LinkedList<Product> products = new LinkedList<>();
        products.add(new Product("사과", 50000, 5));
        products.add(new Product("바나나", 70000, 6));
        products.add(new Product("체리", 90000, 3));

        for (Product product : products) {
            System.out.println("상품명: " + product.getName() + ", 가격: " + product.getPrice() + ", 수량: " + product.getQuantity());
        }
    }
}
