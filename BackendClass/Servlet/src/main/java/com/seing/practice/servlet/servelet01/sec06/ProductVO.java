package com.seing.practice.servlet.servelet01.sec06;

public class ProductVO {
    private String prodNo;
    private String prodName;
    private int prodPrice;

    public ProductVO() {}

    public ProductVO(String prodNo, String prodName, int prodPrice) {
        this.prodNo = prodNo;
        this.prodName = prodName;
        this.prodPrice = prodPrice;
    }

    public String getProdNo() {
        return prodNo;
    }

    public void setProdNo(String prodNo) {
        this.prodNo = prodNo;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public int getProdPrice() {
        return prodPrice;
    }

    public void setProdPrice(int prodPrice) {
        this.prodPrice = prodPrice;
    }
}
