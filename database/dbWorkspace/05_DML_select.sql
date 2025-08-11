-- SELECT
--SELECT [ALL | DISTINCT] 열이름 리스트
--FROM 테이블명
--[WHERE 검색조건(들)]
--[GROUP BY 열이름]
--[HAVING 검색조건(들)]
--[ORDER BY 열이름 [ASC┃DESC]

-- 서점 관계 테이블
SELECT * FROM BOOK2;

-- 테이블 제약 조건 설정

-- 참조 무결성 제약조건
-- 참조되는 테이블의 기본키를 먼저 구성, 참조하는 테이블에서 외래키 구성

-- 서점의 모든 도서는 거래하고 있는 출판사에서 구매됨 - 도서테이블(BOOK2) 출판사데이터(PUBNO) 출판사테이블(PUBLISHER2)의 기본키 도메인의 범위에 국한됨
-- 서점의 모든 도서는 회원가입되어 있는 회원이 서점에 등록되어 있는 도서를 구매할 수 있다 : 구매관계테이블(BOOKSALE)
ALTER TABLE publisher2
ADD CONSTRAINT pk_publisher_pubNo PRIMARY KEY (pubNo);

ALTER TABLE book2
ADD (
    CONSTRAINT pk_book_bookNo PRIMARY KEY (bookNo),
    CONSTRAINT fk_book_pubNo FOREIGN KEY (pubNo) REFERENCES publisher2(pubNo) -- 왜래키 추가
);

ALTER TABLE client
ADD CONSTRAINT pk_client_clientNo PRIMARY KEY (clientNo);

ALTER TABLE bookSale
ADD (
    CONSTRAINT pk_bookSale_bsNo PRIMARY KEY (bsNo),
    CONSTRAINT fk_bookSale_clientNo FOREIGN KEY (clientNo) REFERENCES client(clientNo), -- 외래키 추가
    CONSTRAINT fk_bookSale_bookNo FOREIGN KEY (bookNo) REFERENCES book2(bookNo) -- 외래키 추가
);

---------
-- 특정 테이블의 모든 튜플을 반환
SELECT * FROM PUBLISHER2;

SELECT * FROM BOOK2;

SELECT * FROM CLIENT;

SELECT * FROM BOOKSALE;
-------------------------------------------------------------------------------
-- BOOK 테이블에서 모든 행 검색하여 출력
SELECT *
FROM BOOK2;

-- BOOK 테이블에서 도서명, 도서 가격만 출력
SELECT BOOKNAME, BOOKPRICE FROM BOOK2;

-- BOOK 테이블에서 저자만 출력
SELECT BOOKAUTHOR FROM BOOK2;

-- BOOK 테이블에서 저자만 출력 (중복 튜플 x) : DISTINCT
SELECT DISTINCT BOOKAUTHOR FROM BOOK2;
---------------------
-- WHERE : 검색의 세분화
/*
조건 사용 연산자
비교: =, <, >, <=, >=, !=
범위: BETWEEN
리스트에 포함: IN, NOT IN 
NULL: IS NULL, IS NOT NULL
논리: AND, OR
패턴 매칭: LIKE
*/

-- 비교: =, <, >, <=, >=, !=
-- 저자가 홍길동인 도서의 도서명, 저자 반환
SELECT BOOKNAME, BOOKAUTHOR FROM BOOK2 WHERE BOOKAUTHOR='홍길동';

-- 도서가 30000원 이상인 도서의 도서명, 가격, 제고 반환
SELECT BOOKNAME, BOOKPRICE, BOOKSTOCK FROM BOOK2 WHERE BOOKPRICE >= 30000;

-- 도서 재고가 3권 이상 5권 이하인 도서의 도서명과 제고 수량 반환
SELECT BOOKNAME, BOOKSTOCK FROM BOOK2 WHERE BOOKSTOCK BETWEEN 3 AND 5;

-- 리스트에 포함: IN, NOT IN: 속성명 IN(값1, 값2, ...) -> 리스트
-- 서울 출판사('1')와 도서 출판 강남('2')의 도서명과 출판사 번호를 출력
SELECT BOOKNAME, PUBNO FROM BOOK
WHERE PUBNO IN ('1', '2');

-- 서울 출판사('1')와 도서 출판 강남('2')의 도서가 아닌 도서명과 출판사 번호를 출력
SELECT BOOKNAME, PUBNO FROM BOOK
WHERE PUBNO NOT IN ('1', '2');

-- NULL: IS NULL, IS NOT NULL

-- 모든 클라이언트의 이름과 취미를 반환
SELECT CLIENTNAME, CLIENTHOBBY FROM CLIENT;

-- 취미 정보가 NULL인 클라이언트의 이름과 취미를 반환
SELECT CLIENTNAME, CLIENTHOBBY FROM CLIENT
WHERE CLIENTHOBBY IS NULL;

-- 취미 정보가 NULL 이 아닌 클라이언트의 이름과 취미를 반환
SELECT CLIENTNAME, CLIENTHOBBY FROM CLIENT
WHERE CLIENTHOBBY IS NOT NULL;

-- 취미 정보가 공백인 클라이언트의 이름과 취미를 반환
SELECT CLIENTNAME, CLIENTHOBBY FROM CLIENT
WHERE CLIENTHOBBY = ' ';

-- 논리(AND, OR)

--저자가 홍길동이면서 제고가 3권이상인 도서의 정보 반환
SELECT * FROM BOOK2
WHERE BOOKAUTHOR = '홍길동' AND BOOKSTOCK >= 3;

-- 저자가 홍길동이거나 성춘향인 도서의 정보
SELECT * FROM BOOK2 WHERE BOOKAUTHOR = '홍길동' OR BOOKAUTHOR = '성춘향';

--IN
SELECT * FROM BOOK2
WHERE BOOKAUTHOR IN('홍길동', '성춘향');

-- 패턴 매칭: LIKE
-- WHERE 컬럼명 LIKE '패턴'
-- % : 0개 이상의 문자를 가진 문자열, _ : 단일 문자
-- '홍%' : 홍으로 시작되는 문자열
-- '%길%' : 길을 포함하는 문자열
-- '%동' : 동으로 끝나는 문자열
-- '____': 4개의 문자로 구성된 문자열

-- 출판사 명에 출판사 문자열이 포함된 출판사 정보
SELECT * FROM PUBLISHER2 WHERE PUBNAME LIKE '%출판사%';

-- 출생년도가 1990 년대인 고객의 정보 반환
SELECT * FROM CLIENT
WHERE CLIENTBIRTH LIKE '199%';

-- 이름이 4글자인 고객의 정보 반환
SELECT * FROM CLIENT
WHERE CLIENTNAME LIKE '____';

-- NOT LIKE
-- 도서명에 안드로이드가 포함되지 않는 도서의 정보
SELECT * FROM BOOK2
WHERE BOOKNAME NOT LIKE '%안드로이드%';
----------------------------------------

-- ORDER BY
-- 특정 열의 값을 기준으로 질의 결과를 정렬
-- 가장 마지막에 진행되는 연산 (ORDER BY는 마지막에 질의가 나옴)
-- 기준열을 두 개 이상 나열 가능 - 우선기준, 두번째 기준, 세번째 기준
-- ASC : 오름차순(생략가능)
-- DESC: 내림차순

-- 도서 정보를 도서명 순으로 정렬
SELECT * FROM BOOK2
ORDER BY BOOKNAME;

-- 내림차순
SELECT * FROM BOOK2
ORDER BY BOOKNAME DESC;

-- 조건절 뒤에 ORDER BY
SELECT BOOKNAME, BOOKAUTHOR, BOOKPRICE, BOOKSTOCK FROM BOOK2
WHERE BOOKPRICE >= 20000
ORDER BY BOOKPRICE;

-- 정렬 조건 2개 이상일 경우
-- 도서 재고 기준 내림차순, 재고가 동일할 경우 저자명을 기준으로 오름차순
SELECT * FROM BOOK2
ORDER BY BOOKSTOCK DESC, BOOKAUTHOR;

-------------------------------------------------------------------------------
-- 집계 함수
-- SUM/AVG/COUNT/COUNT(*)/MAX/MIN

-- SUM
-- 도서의 총 재고 수량 출력
SELECT SUM(BOOKSTOCK) AS "SUM OF BOOKSTOCK" FROM BOOK2;

-- 별칭 한글 가능
SELECT SUM(BOOKSTOCK) AS "총재고량" FROM BOOK2;

--2번 고객이 주문한 총 주문 도서 권수
SELECT SUM(BSQTY) AS "총주문수량"
FROM BOOKSALE
WHERE CLIENTNO='2';

--2번 고객이 주문한 총 주문 도서 권수와 주문 도서번호
-- 총 주문수량은 1개의 튜플
-- 도서번호는 3개의 튜플
-- GROUP BY 를 포함하지 않고 SELECT에 집계함수가 포함되면 다른 컬럼도 집계함수를 포함해야함
--SELECT SUM(BSQTY) AS "총주문수량", BOOKNO AS "도서번호" -> ORA-00937: 단일 그룹의 그룹 함수가 아닙니다
--FROM BOOKSALE
--WHERE CLIENTNO='2';

--2번 고객이 주문한 총 주문 도서 권수와 주문 도서번호
SELECT SUM(BSQTY) AS "총주문수량", AVG(BSQTY) AS "평균주문수량"
FROM BOOKSALE
WHERE CLIENTNO='2';
----
-- 도서판매 현황 중 주문 권수가 가장 많은 주문 권수, 가장 적은 주문권수
select MAX(BSQTY) AS 최대주문량, MIN(BSQTY) AS 최소주문량 FROM booksale;

-- 서점에 존재하는 도서의 전체 가격 총액, 평균가격, 최고가, 최저가 확인
SELECT
    SUM(bookPrice) as 가격총액,
    AVG(bookPrice) as 평균가격,
    MAX(bookPrice) as 최고가,
    MIN(bookPrice) as 최저가
FROM BOOK;

-- 도서판매 테이블에서 도서 판매 건수 조회
-- bsDate가 null을 허용하거나 값이 중복되는 컬럼이라면 count가 원하는 목적과 같이 반환되지 않을 수 있음
SELECT COUNT(bsDate) AS 총판매건수 from BOOKSALE;

-- 특정필드 값의 수가 아닌 튜플의 수를 세고자 하면 count(*)를 활용
SELECT COUNT(*) AS 총판매건수 FROM BOOKSALE;

-- 고객 테이블에서 총 취미의 개수 출력: 취미를 제공한 고객 수
-- count(속성명): 속성값이 null인 경우는 제외하고 수를 센 결과 반환
SELECT COUNT(clientHobby) AS "취미" FROM CLIENT;

-- 서점의 총 고객은 몇명인가?
SELECT COUNT(*) AS 총고객수 FROM CLIENT;

--------------------------------------------------------------------------------
-- GROUP BY 속성
-- 그룹에 대한 질의를 기술할 때 사용
-- 특정 열(속성)의 값을 기준으로 동일한 값의 데이터들끼리 그룹을 구성
-- 각 그룹에 대해 한 행 씩 질의 결과를 생성

-- 각 도서번호별 판매수량 확인
-- GROUP BY 진행 한 경우 SELECT 절에 집계함수를 통해 필요영역 집계 진행 가능, group by에 기준되는 열은 SELECT에 포함시킬 수 있음
SELECT SUM(bsqty), bookno
FROM BOOKSALE
GROUP BY bookno
ORDER BY bookno;

SELECT SUM(bsqty), bookno
FROM BOOKSALE
GROUP BY bookno
ORDER BY 2 -- select된 첫 번째 열을 기준으로 정렬;

-- 각 지역별 고객의 수
SELECT clientAddress as 지역, count(*) as 고객수
FROM CLIENT
GROUP BY clientAddress;

-- 성별에 따른 고객수
SELECT clientGender as 성별, count(*) as 고객수
FROM CLIENT
GROUP BY clientGender;

-- 성별에 따른 고객수와 고객들의 지역명
-- group by의 기준으로 사용하지 않는 필드는 select에 단독으로 사용 불가
/*SELECT clientGender as 성별, count(*) as 고객수, clientAddress as 지역명
FROM CLIENT
GROUP BY clientGender; */

-- 성별에 따른 지역별 고객수
SELECT clientGender as 성별, count(*) as 고객수, clientAddress as 지역명
FROM CLIENT
GROUP BY clientGender, clientAddress;

-- HAVING <검색 조건>
-- group by 절에 의해 구성된 그룹들에 대해 적용할 조건 기술
-- 집계함수와 함께 사용
-- 주의
-- 1. 반드시 GROUP BY 와 함께 사용
-- 2. where절보다 뒤에
-- 3. 검색조건에 집계함수가 와야 함

-- 각 출판사 별 도서가격이 25000 이상인 도서가 2권 이상인 도서의 출판사 번호와 도서 권수
SELECT pubNO, count(*) as 도서합계
FROM BOOK2
WHERE bookPrice >= 25000
GROUP BY pubNo
HAVING count(*) >= 2;