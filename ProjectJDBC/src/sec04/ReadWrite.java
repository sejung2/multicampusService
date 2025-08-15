package sec04;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

// 입출력 기능
public class ReadWrite {
    // 도서 정보 입력
    // BookDTO 타입
    public static BookDTO getBookInfo(Scanner sc) {
        BookDTO dto = null;
        try {
            // 학생 데이터 입력
            System.out.println("도서 정보 등록");
            System.out.print("도서번호 입력 : ");
            String bookNo = sc.nextLine();

            System.out.print("도서명 입력 : ");
            String bookName = sc.nextLine();

            System.out.print("저자 입력 : ");
            String bookAuthor = sc.nextLine();

            System.out.print("가격 입력 : ");
            int bookPrice = sc.nextInt();
            sc.nextLine(); // 버퍼 비우기

            System.out.print("출판일 입력 : ");
            String bookDateInput = sc.next();

            System.out.print("재고 입력 : ");
            int bookStock = sc.nextInt();
            sc.nextLine(); // 버퍼 비우기

            System.out.println("출판사번호 입력 : ");
            String pubNo = sc.nextLine();

            // 날짜 형식 변환
            SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
            Date bookDate = fm.parse(bookDateInput);

            // BookDTO 객체 생성
            dto = new BookDTO(bookNo, bookName, bookAuthor, bookPrice, bookDate, bookStock, pubNo);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dto;
    }


    public static void writeBookInfo(ArrayList<BookDTO> bookList) {
        System.out.println("----- 전체 도서 정보 조회 ------");
        System.out.format("%-10s\t %-20s\t %-15s %-10s \t%13s %5s %5s\n",
                "도서번호", "도서명", "저자", "가격", "출판일", "재고", "출판사번호");

        for (BookDTO dto : bookList) {
            String bookNo = dto.getBookNo();
            String bookName = dto.getBookName();
            String bookAuthor = dto.getBookAuthor();
            int bookPrice = dto.getBookPrice();
            Date bookDate = dto.getBookDate();
            int bookStock = dto.getBookStock();
            String pubNo = dto.getPubNo();

            // 한 행씩 출력
            System.out.format("%-10s\t %-20s\t %-15s %6d %13s \t%3d %5s\n",
                    bookNo, bookName, bookAuthor, bookPrice, bookDate, bookStock, pubNo);
        }
    }

    // 학생 1명 정보 출력
    public static void writeBookInfo(BookDTO bookList) {
        System.out.println("----- 도서 정보 조회 ------");
        System.out.format("%-10s\t %-20s\t %-15s %-10s \t%13s %5s %5s\n",
                "도서번호", "도서명", "저자", "가격", "출판일", "재고", "출판사번호");

        String bookNo = bookList.getBookNo();
        String bookName = bookList.getBookName();
        String bookAuthor = bookList.getBookAuthor();
        int bookPrice = bookList.getBookPrice();
        Date bookDate = bookList.getBookDate();
        int bookStock = bookList.getBookStock();
        String pubNo = bookList.getPubNo();
        // 한 행씩 출력
        System.out.format("%-10s\t %-20s\t %-15s %6d %13s \t%3d %5s\n",
                bookNo, bookName, bookAuthor, bookPrice, bookDate, bookStock, pubNo);
    }
}

