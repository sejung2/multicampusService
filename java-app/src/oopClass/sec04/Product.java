package oopClass.sec04;

import java.text.DecimalFormat;

public class Product {

    private String prdName;
    private int prdPrice;
    private int prdSold;
    private int prdStock;

    DecimalFormat amountFormat = new DecimalFormat("#,###"); // 매출액, 재고액 포맷


    public void inputPrdInfo(String prdName, int prdPrice, int prdSold, int prdStock) {
        this.prdName = prdName;
        this.prdPrice = prdPrice;
        this.prdSold = prdSold;
        this.prdStock = prdStock;
    }

    public void showPrdInfo() {
        System.out.println("상품명: " + prdName);
        System.out.println("가격: " + prdPrice);
        System.out.println("판매 수량: " + prdSold);
        System.out.println("재고 수량: " + prdStock);
    }
    // 매출액 계산 출력
    public void showSalesAmount() {
        System.out.println("매출액: " +  amountFormat.format((long) prdPrice * prdSold));
    }
    // 재고액 계산 출력
    public void showStockAmount() {
        System.out.println("재고액: " + amountFormat.format((long) prdPrice * prdStock));
    }
}
