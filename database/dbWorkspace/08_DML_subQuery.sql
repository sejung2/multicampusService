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
    
-- 도서를 한번도 구매한 적이 없는 고객의 번호와 고객명을 조회
select clientNo, clientName
from client
where clientNo not in(
    select clientNo
    from bookSale);
    
--------------------------------------------------------------------------------
-- 중첩 서브쿼리
-- 도서명이 '안드로이드 프로그래밍'인 도서를 구매한 고객의 고객명 출력
-- '안드로이드 프로그래밍'도서의 도서번호 확인
select clientName
from client
where clientNo in (
    select clientNo
    from bookSale
    where bookNo=(
        select bookNo
        from book2
        where bookName='안드로이드 프로그래밍'));
-- 서브 쿼리를 사용했더라도 서브쿼리의 결과는 조건값이므로
-- where절 뒤에 모든 필요한 질의어 추가 가능
select clientName
from client
where clientNo in (
    select clientNo
    from bookSale
    where bookNo=(
        select bookNo
        from book2
        where bookName='안드로이드 프로그래밍'))
order by clientName;
--------------------------------------------------------------------------------
-- 다중행 서브쿼리 연산자 (EXISTS, NOT EXISTS)
-- EXISTS: 서브쿼리의 결과가 행을 반환하면 참
--          참조무결성에 대한 조건검사가 병행되어야 함
--          상관서브쿼리연산이 가능: 서브쿼리에서 메인쿼리의 컬럼을 사용가능
-- 도서를 구매한 적이 있는 고객
select clientNo, clientName
from client
where exists (
    select clientNo
    from booksale
    where client.clientNo = booksale.clientNo);
    
-- 도서를 한번도 주문한 적이 없는 고객
select clientNo, clientName
from client
where not exists (
    select clientNo
    from booksale
    where client.clientNo = booksale.clientNo);
    
-- 도서를 한번도 주문한 적이 없는 고객
-- 서브쿼리의 조건에 해당하는 행이 없으면 참

-- 위 예시는 IN NOT IN 사용시와 같은 결과
-- null값을 포함하고 있는 컬럼: IN VS EXISTS
-- client 테이블의 clientHobby 컬럼은 null값을 포함
select clientHobby from client;

-- exists: 서브쿼리 결과에 null값 포함
select clientNo
from client
where exists (
    select clientHobby
    from client);
-- subquery 결과에 null값이 포함되지 않음
select clientNo
from client
where clientHobby in (
    select clientHobby
    from client);
--------------------------------------------------------------------------------
-- ALL/ANY
-- 관계연산자와 같이 사용
-- ALL: 서브쿼리의 결과 리스트가 조건검사대상이되는 컬럼의 값과 비교할 때 리스트의 모든 값이 비교 연산에 대해 참이되는 경우 참
-- 컬럼값이 10 > ALL(3, 4, 5, 6) -> 참
-- ANY: 서브쿼리의 결과 리스트가 조건검사대상이되는 컬럼의 값과 비교할 때 리스트의 하나의 값이라도 비교 연산에 대해 참이되는 경우 참
-- 컬럼값이 10 > ALL(11,12,13,14) -> 참

-- 2번 고객이 주문한 도서의 최고 주문수량보다 더 많은 도서를 구입한 고객의 고객번호, 주문번호, 주문수량 출력
-- 서브쿼리에서 max 집계함수를 사용한 예시
select clientNo, bsNo, bsQty
from booksale
where bsQty > (
    select max(bsQty)
    from booksale
    where clientNo='2');
-- 메인 쿼리에서 all 사용
select clientNo, bsNo, bsQty
from booksale
where bsQty > all(
    select bsQty
    from booksale
    where clientNo='2');
-- 서브쿼리의 결과리스트 중 최대값보다 크다는 의미

-- 2번 고객의 주문 내역들과 비교할 때 한번이라도 더 많은 주문을 한 적이 있는 고객(2번 고객이 3번 주문한 주문수량들 중 어떤 수량이어도 더 많이 주문한 고객의 주문번호
-- 주문수량을 조회
-- 2번고객의 최소 주문수량보다 더 많이 주문했던 고객의 주문정보

-- 2번 고객을 포함한 모든 고객에 대해 2번고객이 주문한 수량 중 최소 주문수량보다 많이 주문한 주문정보
select clientNo, bsNo, bsQty
from booksale
where bsQty > any(
    select bsQty
    from booksale
    where clientNo='2');
    
select clientNo, bsNo, bsQty
from booksale
where bsQty >(
    select bsQty
    from booksale
    where clientNo='2');
-- 2번 고객이 주문한 최소 주문 수량보다 많이 주문한 고객의 주문정보(2번고객은 제외)
select clientNo, bsNo, bsQty
from booksale
where bsQty > any(
    select bsQty
    from booksale
    where clientNo='2')
and clientNo != 2;
--------------------------------------------------------------------------------
--
--스칼라 서브쿼리 EX
--select 절에서 사용
--서브쿼리의 결과로 단일열의 스칼라값으로 반환
--select나 update에서 사용
--고객별로 총 주문 수량
--고객번호, 고객이름, 총주문수량

select clientNo, sum(bsQty) as 총주문수량
from booksale
group by clientNo
order by clientNo;

-- 스칼라 서브쿼리 사용
select clientNo,
    ( select clientName -- where 절에서 비교되는 clientNo가 group 기준으로 반환되므로 반환되는 clientName은 그룹별로 반환됨
      from client
      where client.clientNo = booksale.clientNo),
    sum(bsQty) as 총주문수량
from booksale
group by clientNo
order by clientNo;

-- DBMS VIEW 객체 제공
-- 한개의 릴레이션에 모든 정보가 저장되지는 않음
-- 필요한 정보를 얻기위해 조인, 서브쿼리등을 진행하게 됨
-- 많은 연산 수행이 동반됨
-- 한 번 연산해놓은 결과를 다시 동일한 데이터를 사용하려고 할 때 빠른 연산을 위해 연산의 순서를 기록해 놓은것
-- 물리적 의미는 위와 같지만 사용할 때는 릴레이션처럼 사용 가능
-- 개발중에 뷰가 필요한 경우 뷰를 생성하면
-- 관리 문제나 트랜잭션 등의 성능 문제가 발생할 수 있음
-- 가상의 뷰, 인라인 뷰를 사용

-- 인라인 뷰: 반환되는 데이터는 다중행, 다중열이어도 상관없음

-- 도서 가격이 25000원 이상인 도서 중 판매된 도서에 대해 도서별로 도서명, 도서가격, 총판매수량, 총판매액 조회
select BOOK.bookName, BOOK.bookPrice, count(*) as 판매건수, sum(bsQty) as 총판매수량, sum(bookPrice * bsQty) as  총판매액
from booksale BS,
        (select bookNo, bookName, bookPrice
         from book2
         where bookPrice > 25000) BOOK
where BOOK.bookNo = BS.bookNo
group by BOOK.bookNo, BOOK.bookName, BOOK.bookPrice;