package sec04;

import java.sql.*;
import java.util.ArrayList;

public class BookDAO implements IBookDAO {
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    BookDTO book = null;
    ArrayList<BookDTO> bookList = null;

    public BookDAO() {
        con = DBConnect.getConnection();
    }

    @Override
    public void insertBook(BookDTO dto) {
        try {
            String sql = "INSERT INTO book2 VALUES(?, ?, ?, ?, ?, ?, ?)";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, dto.getBookNo());
            pstmt.setString(2, dto.getBookName());
            pstmt.setString(3, dto.getBookAuthor());
            pstmt.setInt(4, dto.getBookPrice());
            pstmt.setDate(5, new java.sql.Date(dto.getBookDate().getTime()));
            pstmt.setInt(6, dto.getBookStock());
            pstmt.setString(7, dto.getPubNo());

            int result = pstmt.executeUpdate();

            if (result > 0) {
                System.out.println("도서 정보가 성공적으로 입력되었습니다.");
            } else {
                System.out.println("도서 정보 입력에 실패했습니다.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBConnect.close(pstmt);
        }
    }

    @Override
    public ArrayList<BookDTO> getAllBook() {
        // 전체 도서 정보 조회
        bookList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM book2 ORDER BY bookNo";
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                String bookNo = rs.getString(1);
                String bookName = rs.getString(2);
                String bookAuthor = rs.getString(3);
                int bookPrice = rs.getInt(4);
                Date bookDate = rs.getDate(5);
                int bookStock = rs.getInt(6);
                String pubNo = rs.getString(7);

                // StudentDTO 객체 생성 후 리스트에 추가
                book = new BookDTO(bookNo, bookName, bookAuthor, bookPrice, bookDate, bookStock, pubNo);
                bookList.add(book);
            }
        } catch (SQLException e) {
            System.out.println("SQL 예외 발생: " + e.getMessage());
            e.printStackTrace();
        } finally {
            DBConnect.close(pstmt, rs);
        }
        return bookList;
    }

    @Override
    public BookDTO detailBook(String bookNo) {
        // 도서 정보 상세 조회
        try {
            String sql = "SELECT * FROM book2 WHERE bookNo = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, bookNo);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                String bookName = rs.getString(2);
                String bookAuthor = rs.getString(3);
                int bookPrice = rs.getInt(4);
                Date bookDate = rs.getDate(5);
                int bookStock = rs.getInt(6);
                String pubNo = rs.getString(7);
                book = new BookDTO(bookNo, bookName, bookAuthor, bookPrice, bookDate, bookStock, pubNo);
            } else {
                System.out.println("해당 도서 정보가 없습니다.");
                book = null; // 도서 정보가 없을 경우 null 반환
            }

        } catch (SQLException e) {
            System.out.println("SQL 예외 발생: " + e.getMessage());
            e.printStackTrace();
        } finally {
            DBConnect.close(pstmt, rs);
        }
        return book;
    }

    @Override
    public void deleteBook(String bookNo) {
        try {
            String sql = "DELETE FROM book2 WHERE bookNo = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, bookNo);

            int result = pstmt.executeUpdate();
            if (result > 0) {
                System.out.println("도서 정보가 성공적으로 삭제되었습니다.");
            } else {
                System.out.println("도서 정보 삭제에 실패했습니다. 해당 도서가 존재하지 않습니다.");
            }

        } catch (Exception e) {
            System.out.println("SQL 예외 발생: " + e.getMessage());
            e.printStackTrace();
        } finally {
            DBConnect.close(pstmt);
        }
    }

    @Override
    public void updateBook(BookDTO dto) {
        try {
            String sql = "UPDATE book2 SET bookName = ?, bookAuthor = ?, bookPrice = ?, " +
                    "bookDate = ?, bookStock = ?, pubNo = ? WHERE bookNo = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, dto.getBookName());
            pstmt.setString(2, dto.getBookAuthor());
            pstmt.setInt(3, dto.getBookPrice());
            pstmt.setDate(4, new java.sql.Date(dto.getBookDate().getTime()));
            pstmt.setInt(5, dto.getBookStock());
            pstmt.setString(6, dto.getPubNo());
            pstmt.setString(7, dto.getBookNo());

            int result = pstmt.executeUpdate();

            if (result > 0) {
                System.out.println("도서 정보가 성공적으로 수정되었습니다.");
            } else {
                System.out.println("도서 정보 수정에 실패했습니다.");
            }

        } catch (Exception e) {
            System.out.println("SQL 예외 발생: " + e.getMessage());
            e.printStackTrace();
        } finally {
            DBConnect.close(pstmt);
        }
    }
}
