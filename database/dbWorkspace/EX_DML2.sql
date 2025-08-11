--1.도서 테이블에서 가격 순으로 내림차순 정렬하여,  도서명, 저자, 가격 출력 (가격이 같으면 저자 순으로 오름차순 정렬)
SELECT bookName, bookAuthor, bookPrice FROM BOOK2
ORDER BY bookPrice DESC, bookAuthor;
--2.도서 테이블에서 저자에 '길동'이 들어가는 도서의 총 재고 수량 계산하여 출력
SELECT SUM(bookStock) AS 총재고 FROM BOOK2
WHERE bookAuthor LIKE '%길동%';
--3.도서 테이블에서 ‘서울 출판사' 도서 중 최고가와 최저가 출력
SELECT MAX(bookPrice) AS 최고가, MIN(bookPrice) AS 최저가 FROM BOOK2
WHERE PUBNO = '1';
--4.도서 테이블에서 출판사별로 총 재고수량과 평균 재고 수량 계산하여 출력 (‘총 재고 수량’으로 내림차순 정렬)
SELECT pubNo, SUM(bookStock) AS "총 재고 수량", AVG(bookStock)AS "평균 재고 수량" FROM BOOK2
GROUP BY PUBNO
ORDER BY "총 재고 수량" DESC;
-- + 반올림
SELECT pubNo, SUM(bookStock) AS "총 재고 수량", ROUND(AVG(bookStock), 2) AS "평균 재고 수량" FROM BOOK2
GROUP BY pubNo
ORDER BY "총 재고 수량" DESC;
--5.도서판매 테이블에서 고객별로 ‘총 주문 수량’과 ‘총 주문 건수’ 출력. 단 주문 건수가 2이상인 고객만 해당
SELECT clientNo, SUM(BSQTY) AS 총주문수량, COUNT(*) AS 총주문건수 FROM BOOKSALE
GROUP BY clientNo
HAVING COUNT(*) >= 2;
--------------------------------------------------------------------------------

-- 1.모든 도서에 대하여 도서의 도서번호, 도서명, 출판사명 출력
select B.bookNo, B.bookName, P.pubName
from book2 B
    inner join publisher2 P on P.pubNo = B.pubNo
-- 2.‘서울 출판사'에서 출간한 도서의 도서명, 저자명, 출판사명 출력 (출판사명 사용)
select B.bookName, B.bookAuthor, P.pubName
from book2 B
    inner join publisher2 P on P.pubNo = B.pubNo
where P.pubName = '서울 출판사';
-- 3.＇정보출판사'에서 출간한 도서 중 판매된 도서의 도서명 출력 (중복된 경우 한 번만 출력) (출판사명 사용)
select UNIQUE B.bookName, P.pubName
from bookSale BS
    inner join book2 B on B.bookno = BS.bookNo
    inner join publisher2 P on P.pubNo = B.pubNo
where P.pubName = '정보출판사';
-- 4.도서가격이 30,000원 이상인 도서를 주문한 고객의 고객명, 도서명, 도서가격, 주문수량 출력
select C.clientName, B.bookName, B.bookPrice, BS.bsQty
from booksale BS
    inner join client C on C.clientNo = BS.clientNo
    inner join book2 B on B.bookNo = BS.bookNo
where B.bookPrice >= 30000;
-- 5.'안드로이드 프로그래밍' 도서를 구매한 고객에 대하여 도서명, 고객명, 성별, 주소 출력 (고객명으로 오름차순 정렬)
select B.bookName, C.clientName, C.clientGender, C.clientAddress
from booksale BS
    inner join client C on C.clientNo = BS.clientNo
    inner join book2 B on B.bookNo = BS.bookNo
where B.bookName = '안드로이드 프로그래밍'
order by C.clientName;
-- 6.‘도서출판 강남'에서 출간된 도서 중 판매된 도서에 대하여 ‘총 매출액’ 출력
select SUM(BS.bsQty * B.bookPrice) as "총 매출액"
from book2 B
    inner join publisher2 P on P.pubNo = B.pubNo
    inner join bookSale BS on BS.bookNo = B.bookNo
where P.pubName = '도서출판 강남';
-- 7.‘서울 출판사'에서 출간된 도서에 대하여 판매일, 출판사명, 도서명, 도서가격, 주문수량, 주문액 출력
select BS.bsDate, P.pubName, B.bookName, B.bookPrice, BS.bsQty, B.bookPrice * BS.bsQty
from book2 B
    inner join publisher2 P on P.pubNo = B.pubNo
    inner join bookSale BS on BS.bookNo = B.bookNo
where P.pubName = '서울 출판사';
-- 8.판매된 도서에 대하여 도서별로 도서번호, 도서명, 총 주문 수량 출력
select B.bookNo, B.bookName, sum(BS.bsQty)
from bookSale BS
    inner join book2 B on B.bookNo = BS.bookNo
group by B.bookNo, B.bookName;
-- 9.판매된 도서에 대하여 고객별로 고객명, 총구매액 출력 ( 총구매액이 100,000원 이상인 경우만 해당)
select C.clientName, sum(BS.bsQty * B.bookPrice) as "총구매액"
from bookSale BS
    inner join client C on C.clientNo = BS.clientNo
    inner join book2 B on B.bookNo = BS.bookNo
group by C.clientName
having sum(BS.bsQty * B.bookPrice) >= 100000;
-- 10.판매된 도서 중 ＇도서출판 강남'에서 출간한 도서에 대하여 고객명, 주문일, 도서명, 주문수량, 출판사명 출력 (고객명으로 오름차순 정렬)
select C.clientName, BS.bsDate, B.bookName, BS.bsQty, P.pubName
from bookSale BS
    inner join client C on C.clientNo = BS.clientNo
    inner join book2 B on B.bookNo = BS.bookNo
    inner join publisher2 P on P.pubNo = B.pubNo
where P.pubName='도서출판 강남'
order by C.clientName;
