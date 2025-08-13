-- 오라클 내장함수

-- 수학 함수
-- round(값, 자릿수): 자릿수 아래에서 반올림

select round(3.862, 1) from dual;
select round(3.862, 2) from dual;

-- 고객별 평균 주문액을 계산해서 조회(백원단위에서 반올림한 계산결과 조회)
select clientNo, round(avg(bookPrice*bsQty)) as 평균주문액,
                 round(avg(bookPrice*bsQty), 0) as 평균주문액,
                 round(avg(bookPrice*bsQty), -1) as "10자리",
                 round(avg(bookPrice*bsQty), -2) as "100자리",
                 round(avg(bookPrice*bsQty), -3) as "1000자리"
from book2, booksale
where book2.bookNo = booksale.bookNo
group by clientNo
order by clientNo;

--------------------------------------------------------------------------------
-- 문자함수
-- replace(): 문자열 치환
-- length(): 글자의 수
-- lengthb(): 바이트 수
-- substr(): 지정한 길이만큼 문자열 반환

select replace('자바프로그래밍', '자바', '파이썬') from dual;

select replace('apple airplane apart', 'ap', '*^') from dual;

-- 도서명이 안드로이드인 도서명을 ANDROID로 변경해서 조회, select된 결과에 함수 적용
select bookNo, replace(bookName, '안드로이드', 'ANDROID') bookName, bookAuthor, bookprice
from book2
where bookName like '%안드로이드%';

-- 각 도서의 도서명에 대한 크기를 확인
-- 도서명은 문자열 크기(갯수, 바이트수)
select bookName as 도서명, length(bookname) as 문자수, lengthb(bookName) as 바이트
from book2;

-- substr(문자열, 시작위치, 길이)
select substr(bookAuthor, 1, 1)
from book2;

select substr(bookAuthor, 2, 2)
from book2;

-- concat: 문자열 연결
-- 데이터베이스에 저장은 리터럴로 저장됨 -> 저자: 도서명 : 가격 형식의 데이터가 개발시 필요
select concat('문자열', ':'), '문자열'|| '' ||'연결방법2' from dual;

select bookAuthor || ':' || bookName || ':' || bookPrice as 도서정보
from book2;

-- 순위출력
-- rank()
-- dense_rank()
-- row_number()

-- 순위함수() over (order by 열) 형식으로 사용

select bookPrice,
    rank() over(order by bookPrice desc) "RANK",
    dense_rank() over(order by bookPrice desc) "DENSE_RANK",
    row_number() over(order by bookPrice desc) "ROW_NUMBER"
from book2;

-- Top N 조회: ROWNUM
select rownum, bookPrice
from book2
where rownum between 1 and 5;

-- cube()
-- 각 그룹의 모든 경우에 수에 대한 소계와 총계 산출
-- 각 항목들간의 다차원적인 소계를 계산

-- grouping sets()
-- 특정 항목에 대한 소계 산출
CREATE TABLE CUBETBL(
    PRDNAME VARCHAR2(10),
    COLOR VARCHAR2(6),
    AMOUNT NUMBER(2)
    );
INSERT INTO CUBETBL VALUES('컴퓨터','검정',11);
INSERT INTO CUBETBL VALUES('컴퓨터','파랑',22);
INSERT INTO CUBETBL VALUES('모니터','검정',33);
INSERT INTO CUBETBL VALUES('모니터','파랑',44);
INSERT INTO CUBETBL VALUES('마우스','검정',55);
INSERT INTO CUBETBL VALUES('마우스','파랑',66);

SELECT * FROM PIVOTTEST;

SELECT * FROM PIVOTTEST
    PIVOT(SUM(AMOUNT)
          FOR SEASON
          IN ('봄','여름','가을','겨울'));
          
----------------------------------------------------------------------------------------------
-- 날짜 반환 함수
-- SYSDATE, CURRENT_DATE

SELECT SYSDATE FROM DUAL; -- 현재일자(오늘)
SELECT CURRENT_DATE FROM DUaL;

SELECT SYSDATE +1 FROM DUAL; -- 1일 후
SELECT SYSDATE -1 FROM DUAL; -- 1일 전

SELECT ADD_MONTHS(SYSDATE, 1) FROM DUAL; -- 1달후
SELECT ADD_MONTHS(SYSDATE, -1) FROM DUAL; -- 1달전

SELECT ADD_MONTHS(SYSDATE, 12) FROM DUAL; -- 1년후
SELECT ADD_MONTHS(SYSDATE, -12) FROM DUAL; -- 1년전


-- 날짜 데이터에서 년,월,일 추출
--EXTRACT()

SELECT EXTRACT(YEAR FROM SYSDATE)-1 년,
       EXTRACT(MONTH FROM SYSDATE) 월,
       EXTRACT(DAY FROM SYSDATE) 일
FROM DUAL;

-- 현재 시간
SELECT CURRENT_TIMESTAMP FROM DUAL;

SELECT TO_CHAR(SYSDATE, 'HH:MI:SS') FROM DUAL;

SELECT TO_CHAR(SYSDATE, 'HH24:MI:SS') FROM DUAL;

SELECT TO_CHAR(SYSDATE, 'HH24') FROM DUAL;

SELECT TO_CHAR(SYSDATE, 'MI') FROM DUAL;

SELECT TO_CHAR(SYSDATE, 'SS') FROM DUAL;

SELECT TO_CHAR(SYSDATE, 'YYYY') FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'MM') FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'DD') FROM DUAL;