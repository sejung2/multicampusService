--1.호날두(고객명)가 주문한 도서의 총 구매량 출력
select sum(bsQty)
from booksale
where clientNo=(
    select clientNo
    from client
    where clientName='호날두');
--2.‘정보출판사’에서 출간한 도서를 구매한 적이 있는 고객명 출력
select clientName
from client
where clientNo in (
    select clientNo
    from booksale
    where bookNo in(
        select bookNo
        from book2
        where pubNo=(
            select pubNo
            from publisher
            where pubName='정보출판사')));
--3.베컴이 주문한 도서의 최고 주문수량 보다 더 많은 도서를 구매한 고객명 출력
select clientName
from client
where clientNo in(
    select clientNo
    from booksale
    where bsQty > (
        select max(bsQty)
        from booksale
        where clientNo = (
            select clientNo
            from client
            where clientName='베컴')));
--4.천안에 거주하는 고객에게 판매한 도서의 총 판매량 출력
select sum(bsQty)
from booksale
where clientNo in (
    select clientNo
    from client
    where clientAddress='천안');
--------------------------------------------------------------------------------
-- 저자 중 성(姓)이'손'인 모든 저자출력
SELECT bookAuthor
FROM book2
WHERE substr(bookAuthor,1,1)='손';
--저자중에서 같은성(姓)을 가진 사람이 몇 명이나 되는지 알아보기 위해 성(姓)별로 그룹지어 인원 수 출력
SELECT
    SUBSTR(bookAuthor, 1, 1) AS "성",
    COUNT(*) AS "인원수"
FROM book2
GROUP BY SUBSTR(bookAuthor, 1, 1);
--------------------------------------------------------------------------------
CREATE TABLE sales (
    prdName VARCHAR2(20),
    salesDate VARCHAR2(10),
    prdCompany VARCHAR2(10),
    salesAmount NUMBER(8)
);

INSERT INTO sales VALUES ('노트북', '2021.01', '삼성', 10000);
INSERT INTO sales VALUES ('노트북', '2021.03', '삼성', 20000);
INSERT INTO sales VALUES ('냉장고', '2021.01', 'LG', 12000);
INSERT INTO sales VALUES ('냉장고', '2021.03', 'LG', 20000);
INSERT INTO sales VALUES ('프린터', '2021.01', 'HP', 3000);
INSERT INTO sales VALUES ('프린터', '2021.03', 'HP', 1000);

-- rollup : 각 그룹의 소계와 총계를 계층적으로 보여줌
SELECT prdCompany, prdName, SUM(salesAmount) AS "총매출"
FROM sales
GROUP BY ROLLUP(prdCompany, prdName);

-- cube : 각 그룹의 모든 경우에 수에 대한 소계와 총계 산출
SELECT prdCompany, prdName, SUM(salesAmount) AS "총매출"
FROM sales
GROUP BY CUBE(prdCompany, prdName);

-- grouping sets : 지정된 경우에 수에 대한 소계와 총계 산출
SELECT prdCompany, prdName, SUM(salesAmount) AS "총매출"
FROM sales
GROUP BY GROUPING SETS((prdCompany), (prdName));

--------------------------------------------------------------------------------
SELECT
    to_char(bsDate, 'YYYY-MM-DD') as 주문일,
    to_char(bsDate+7, 'YYYY-MM-DD') as 배송일
FROM booksale;
--
SELECT
    bookName AS "도서명",
    EXTRACT(YEAR FROM bookdate) AS "출판연도"
FROM BOOK2;