--student
-- 속성과 값 모두 나열
SELECT * FROM STUDENT;
--값만 나열
SELECT STDNAME FROM STUDENT WHERE STDYEAR='4';
-- 전체 한번에 저장		
INSERT ALL
    INTO STUDENT VALUES('2015002', '성춘향', 3, '1996-12-10', 3)
    INTO STUDENT VALUES('2014004', '이몽룡', 4, '1997-03-03', 2)
    INTO STUDENT VALUES('2016002', '변사또', 4, '1995-05-07', 1)
    INTO STUDENT VALUES('2015001', '이순신', 4, '1997-11-01', 2)
SELECT *
FROM DUAL;
--------------------------------------------------------------------------------
-- book
-- 1. 행삽입
INSERT ALL
    INTO BOOK VALUES('8', 'java프로그래밍', 30000, '2021-03-10', '2')
    INTO BOOK VALUES('9', '파이썬 데이터 과학', 24000, '2018-10-30', '1')
SELECT *
FROM DUAL;
-- 2. 도서명이 데이터베이스인 행의 가격을 2000으로 변경
UPDATE BOOK SET BOOKPRICE =  2000 WHERE BOOKNAME='데이터베이스';
-- 3. book 테이블에서 발행일이 2018년도인 행 삭제
DELETE FROM BOOK WHERE EXTRACT(YEAR FROM BOOKDATE) = 2018;
-------------------------------------------------------------------------------
-- 종합
-- 고객테이블(customer) 생성
DROP TABLE customer;
CREATE TABLE customer(
    CUSTNO VARCHAR2(10) not null primary key,
    CUSTNAME VARCHAR2(30) not null,
    CUSTPHONE VARCHAR2(30),
    CUSTADDRESS VARCHAR2(50),
    CUSTGENDER VARCHAR2(5),
    CUSTAGE NUMBER(5),
    CONSTRAINT PK_customer_custno PRIMARY KEY(CUSTNO)
);
-- 주문 테이블(orderProduct)생성 
drop table orderProduct;
CREATE TABLE orderProduct(
    ORDERNO VARCHAR2(10) NOT NULL PRIMARY KEY,
    ORDERDATE DATE,
    ORDERQTY NUMBER(5),
    CUSTNO VARCHAR2(10) NOT NULL,
    PRDNO VARCHAR2(5) NOT NULL,
    CONSTRAINT FK_ORDERPRODUCT_CUSTOMER FOREIGN KEY(CUSTNO) REFERENCES customer(CUSTNO),
    CONSTRAINT FK_ORDERPRODUCT_PRODUCT FOREIGN KEY(PRDNO) REFERENCES PRODUCT3(PRDNO)
);
-- 고객 테이블의 전화번호 열을 NOT NULL로 변경
ALTER TABLE CUSTOMER MODIFY CUSTPHONE VARCHAR2(30) NOT NULL;
-- 고객 테이블에 '성별', 나이열 추가 
ALTER TABLE CUSTOMER ADD (GENDER VARCHAR(5), AGE NUMBER(3));
-- 고객, 주문 테이블에 데이터 삽입(3개)
// 고객
INSERT ALL
    INTO CUSTOMER VALUES('1001', '홍길동', '010-1111-1111', '강원도 평창', '남', 22)
    INTO CUSTOMER VALUES('1002', '이몽룡', '010-2222-2222', '서울시 종로구', '남', 23)
    INTO CUSTOMER VALUES('1003', '성춘향', '010-3333-3333', '서울시 강남구', '여', 22)
SELECT *
FROM DUAL;
// 주문
INSERT ALL
    INTO ORDERPRODUCT VALUES('1', '2018-01-10', 3, '1003', '3')
    INTO ORDERPRODUCT VALUES('2', '2018-03-03', 1, '1001', '7')
    INTO ORDERPRODUCT VALUES('3', '2018-04-05', 3, '1002', '2')
SELECT *
FROM DUAL;
-- 주문 테이블에서 상품번호가 2인행의 주문수량을 3으로 수정
UPDATE ORDERPRODUCT SET ORDERQTY = '3'
WHERE PRDNO = '2';
--------------------------------------------------------------------------------
--------------------------------------------------------------------------------
--1.고객 테이블에서 고객명, 생년월일, 성별 출력
SELECT CLIENTNAME, CLIENTBIRTH, CLIENTGENDER
FROM CLIENT;
--2.고객 테이블에서 주소만 검색하여 출력 (중복되는 튜플은 한번만 출력)
SELECT DISTINCT CLIENTADDRESS
FROM CLIENT;
--3.고객 테이블에서 취미가 '축구'이거나 '등산'인 고객의 고객명, 취미 출력
SELECT CLIENTNAME, CLIENTHOBBY
FROM CLIENT
WHERE CLIENTHOBBY = '축구' OR CLIENTHOBBY = '등산';
--4.도서 테이블에서 저자의 두 번째 위치에 '길'이 들어 있는 저자명 출력 (중복되는 튜플은 한번만 출력)
SELECT DISTINCT BOOKAUTHOR
FROM BOOK2
WHERE BOOKAUTHOR LIKE '_길%';
--5.도서 테이블에서 발행일이 2018년인 도서의 도서명, 저자, 발행일 출력
SELECT BOOKNAME, BOOKAUTHOR, BOOKDATE
FROM BOOK2
WHERE BOOKDATE LIKE '2018%';
--6.도서판매 테이블에서 고객번호1, 2를 제외한 모든 튜플 출력
SELECT * FROM BOOKSALE
WHERE CLIENTNO NOT IN(1, 2);
--7.고객 테이블에서 취미가 NULL이 아니면서 주소가 '서울'인 고객의 고객명, 주소, 취미 출력
SELECT CLIENTNAME, CLIENTADDRESS, CLIENTHOBBY
FROM CLIENT
WHERE CLIENTHOBBY IS NOT NULL AND CLIENTADDRESS='서울';
--8.도서 테이블에서 가격이 25000 이상이면서 저자 이름에 '길동'이 들어가는 도서의 도서명, 저자, 가격, 재고 출력
SELECT BOOKNAME, BOOKAUTHOR, BOOKPRICE, BOOKSTOCK FROM BOOK2
WHERE BOOKPRICE >= 25000 AND BOOKAUTHOR LIKE '%길동%';
--9.도서 테이블에서 가격이 20,000 ~25,000원인 모든 튜플 출력
SELECT * FROM BOOK2
WHERE BOOKPRICE BETWEEN 20000 AND 25000;
--10.도서 테이블에서 저자명에 '길동'이 들어 있지 않는 도서의 도서명, 저자 출력
SELECT BOOKNAME, BOOKAUTHOR FROM BOOK2
WHERE BOOKAUTHOR NOT LIKE '%길동%';
--------------------------------------------

--order by
SELECT bookName, bookAuthor from Book
where bookAuthor not like "%길동"
ORDER BY bookPrice asc, bookAuthor desc;
