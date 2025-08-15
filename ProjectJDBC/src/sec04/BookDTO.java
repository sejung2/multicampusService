package sec04;

import java.util.Date;

public class BookDTO {
    // db 테이블과 동일한 필드 선언
    private String bookNo; // 도서번호
    private String bookName; // 도서명
    private String bookAuthor; // 저자
    private int bookPrice; // 가격
    private Date bookDate; // 출판일
    private int bookStock; // 재고
    private String pubNo; // 출판사번호

    public BookDTO(String bookNo, String bookName, String bookAuthor, int bookPrice, Date bookDate, int bookStock, String pubNo) {
        this.bookNo = bookNo;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookPrice = bookPrice;
        this.bookDate = bookDate;
        this.bookStock = bookStock;
        this.pubNo = pubNo;
    }

    public String getBookNo() {
        return bookNo;
    }

    public void setBookNo(String bookNo) {
        this.bookNo = bookNo;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public int getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(int bookPrice) {
        this.bookPrice = bookPrice;
    }

    public Date getBookDate() {
        return bookDate;
    }

    public void setBookDate(Date bookDate) {
        this.bookDate = bookDate;
    }

    public int getBookStock() {
        return bookStock;
    }

    public void setBookStock(int bookStock) {
        this.bookStock = bookStock;
    }

    public String getPubNo() {
        return pubNo;
    }

    public void setPubNo(String pubNo) {
        this.pubNo = pubNo;
    }
}
