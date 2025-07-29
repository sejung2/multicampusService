package oopClass.sec04;

import java.util.Scanner;

public class ProductMain {
    public static void main(String[] args) {
        Product product = new Product();
        Scanner sc = new Scanner(System.in);

        System.out.println("****상품 정보 입력****");
        System.out.print("상품명: ");
        String prdName = sc.nextLine();
        System.out.print("가격: ");
        int prdPrice = sc.nextInt();
        System.out.print("판매 수량: ");
        int prdSold = sc.nextInt();
        System.out.print("재고 수량: ");
        int prdStock = sc.nextInt();
        product.inputPrdInfo(prdName, prdPrice, prdSold, prdStock);
        System.out.println("****상품 정보 출력****");
        product.showPrdInfo();
        product.showSalesAmount();
        product.showStockAmount();
    }
}
