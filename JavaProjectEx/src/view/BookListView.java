package view;

import controller.Controller;
import model.BookDTO;

import java.util.Vector;

public class BookListView {
    // 조회된 전체 도서정보 결과 출력
    Controller controller = Controller.getInstance();

    public void getAllBook() { // controller에 요청만 전달
        controller.getAllBook();
    }

    public static void showAllBook(Vector<BookDTO> dataSet) {
        System.out.println("\n*******************************");
        System.out.println("도서 정보 조회");
        System.out.println("*********************************");

        System.out.println("도서번호\t 도서명\t\t  저자\t\t 가격\t\t 발행일\t\t 재고 \t출판사번호");
        System.out.println("--------------------------------------------");

        for (BookDTO dto : dataSet) {
            System.out.println(dto);
        }
    }
}
