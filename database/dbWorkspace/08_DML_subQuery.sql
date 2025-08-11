-- sub query
-- 하위 질의 / 부속 질의
-- 하나의 SQL 문 안에 다른 SQL문이 중첩
-- 하위 질의 수행 후 반환 릴레이션에 대해 다른 질의 릴레이션으로 포함시킴
-- 다른 테이블에서 가져온 데이터로 현재 테이블에 있는 정보를 찾거나 가공할 때 사용

-- 조인 VS 서브쿼리
-- 1. 조인 : 여러 데이터를 모두 합쳐서 연산
--        : BOOK JOIN PUBLISHER -> 18 * 3 => 54행 반환 후 조건에 맞는 튜플 검색
--        : 카티션 곱 연산 + SELECT 연산
-- 2. 서브 쿼리: 필요한 데이터만 찾아서 제공
--              경우에 따라 조인보다 성능이 더 좋을 수도 있지만 대용량 데이터에서 서브쿼리 수행 성능이 나쁠수도 있음
-- 구성: 메인쿼리 (서브쿼리) -> 서브쿼리 먼저 수행 후 메인쿼리 진행

-- 홍길동(CLIENT) 고객이 주문한 도서의 총 수량(BOOKSALE) -> BOOKSALE에는 CLIENTNO만 있음
select sum(bsQty)
from bookSale
where clientNo = ( -- 서브 쿼리
    select clientNo from client where clientName='메시'
    );
    
-- 서브쿼리 where절에서 사용할 경우
-- 서브쿼리 질의 결과값이 단일행인 경우 : 단일행 서브쿼리 ( = 연산자 사용해서 조건 확인)
-- 비교 연산자 사용: > < >= <= = !=

-- 서브쿼리 질의 결과값이 다중행인 경우 : 다중행 서브쿼리 (IN, ANY, ALL, EXISTS 연산자 사용)
-- IN, NOT IN (집합에 값이 있는지 / 없는지)
-- EXISTS, NOT EXISTS (존재의 의미)
-- ALL(모두), ANY(최소 하나라도) : 한정

-- 고객 호날두의 주문수량 및 주문 날짜 조회
-- 1. CLIENT 테이블에서 '호날두'의 CLIENTNO를 찾아서
-- 2. BOOKSALE 테이블에서 1에서 찾은 CLIENTNO에 해당되는 주문의 주문일/주문 수량을 조회
select bsDate, bsQty
from booksale
where clientNo=(select clientNo
                from client
                where clientName='호날두');
-- 호날두가 주문한 총 주문수량
select sum(bsQty) as "총주문수량"
from booksale
where clientNo=(select clientNo
                from client
                where clientName='호날두');
-- 가장 비싼 도서의 도서명과 가격 출력
select bookName, bookPrice
from book2
where bookPrice=(
    select max(bookPrice)
    from book2);

-- 서점 도서의 평균가격을 초과하는 도서의 이름과 도서 가격을 조회
select bookName, bookPrice
from book2
where bookPrice>(
    select avg(bookPrice)
    from book2
    );

-- 도서를 구매한 적이 있는 고객의 고객명과 지역명을 조회
select clientName, clientAddress
from client
where clientNo=(
    select clientNo
    from bookSale);
-- 비교 연산자는 한 개의 값만 비교할 수 있음
-- 주문한 고객의 고객번호는 여러 값이 반환됨 -> 비교 연산자 사용 불가

select clientName, clientAddress
from client
where clientNo in(
    select clientNo
    from bookSale);