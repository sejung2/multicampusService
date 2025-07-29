package oopClass.sec09;

public class Book {
    String title;
    String author;
    int price;

    public Book(String title, String author, int price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void show(){
        System.out.println("도서명 : " + title);
        System.out.println("저자명 : " + author);
        System.out.println("가격 : " + price + "원");
    }
}
