package com.spring.mvcProject2.dto;
import java.util.Date;
public class ProductDTO {
    private String prdNo;
    private String prdName;
    private String prdPrice;
    private String prdMaker;
    private String prdColor;
    private String ctgNo;

    public ProductDTO() {
    }

    public ProductDTO(String prdNo, String prdName, String prdPrice, String prdMaker, String prdColor, String ctgNo) {
        this.prdNo = prdNo;
        this.prdName = prdName;
        this.prdPrice = prdPrice;
        this.prdMaker = prdMaker;
        this.prdColor = prdColor;
        this.ctgNo = ctgNo;
    }

    public String getPrdNo() {
        return prdNo;
    }

    public void setPrdNo(String prdNo) {
        this.prdNo = prdNo;
    }

    public String getPrdName() {
        return prdName;
    }

    public void setPrdName(String prdName) {
        this.prdName = prdName;
    }

    public String getPrdPrice() {
        return prdPrice;
    }

    public void setPrdPrice(String prdPrice) {
        this.prdPrice = prdPrice;
    }

    public String getPrdMaker() {
        return prdMaker;
    }

    public void setPrdMaker(String prdMaker) {
        this.prdMaker = prdMaker;
    }

    public String getPrdColor() {
        return prdColor;
    }

    public void setPrdColor(String prdColor) {
        this.prdColor = prdColor;
    }

    public String getCtgNo() {
        return ctgNo;
    }

    public void setCtgNo(String ctgNo) {
        this.ctgNo = ctgNo;
    }
}
