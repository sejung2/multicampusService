package sec04;

import java.util.ArrayList;

// book
public interface IBookDAO {

    // 도서 정보 등록
    void insertBook(BookDTO dto);

    // 전체 도서 정보 조회
    ArrayList<BookDTO> getAllBook();

    // 상세 도서 정보 조회
    BookDTO detailBook(String bookNo);

    // 도서 정보 삭제
    void deleteBook(String bookNo);

    // 도서 정보 수정
    void updateBook(BookDTO dto);
}
