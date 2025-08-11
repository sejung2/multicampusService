-- JOIN
-- 여러개의 테이블을 결합하여 조건에 맞는 행 검색
-- ex. 홍길동 학생의 소속과 명
-- 조인종류
-- 1. inner join/outer join
-- 1. inner join: 두 테이블에 공통되는 열이 있을 때
-- 2. outer join: 두 테이플에 공통되는 열이 없을때도 표현

-- 고객 / 주문 테이블
-- 상품을 주문한 고객을 조회 (inner)
-- 상품을 주문한 고객과 주문하지 않은 고객도 주문내역과 같이 조회 (outer)

-- 형식
/* SELECT 열리스트
    FROM 테이블명 1
    INNER JOIN 테이블명 2
    on 조인조건(기본키 = 외래키)
 */
 /* SELECT 열리스트
    FROM 테이블명 1, 테이블명 2
    WHERE 조인 조건(기본키=외래키)
 */
  /* SELECT 테이블명.속성명, 테이블명.속성명
    FROM 테이블명 1, 테이블명 2
    WHERE 조인 조건(기본키=외래키)
 */
 
 -- 주문한 적이 있는 고객의 번호 이름
 -- 고객테이블에서 고객 번호와 이름이 있지만 주문여부는 확인 불가능
 -- 주문테이블에서는 주문여부의 확인이 가능하지만 고객번호와 고객이름은 확인 불가능
 
 -- 주문한 적이 있는 고객의 모든 정보
 -- 가장 많이 사용되는 방법
 SELECT CLIENT.clientNo, clientName FROM CLIENT
 INNER JOIN BOOKSALE
 ON CLIENT.clientNo = BOOKSALE.clientNo;
 
 -- 결과는 clientno를 제외하고는 테이블명 포함시키지 않아도 동일함
 -- 오라클 서버 입장에서는 속성의 소속을 명확히 하게됨으로 위치를 정확히 알려주므로 성능이 향상
 SELECT client.clientno, clientname, booksale.bsqty
 from client, booksale
 where client.clientno = booksale.clientno;
 
 -- 테이블에 별칭 사용
 SELECT C.clientno, C.clientname, B.bsqty
 from client C, booksale B
 where C.clientno = B.clientno
 
  -- 주문한 적이 있는 고객의 모든 정보 - join(inner join의 약어)
 SELECT CLIENT.clientNo, clientName
 FROM CLIENT
    JOIN BOOKSALE
    ON CLIENT.clientNo = BOOKSALE.clientNo;

  -- 주문한 적이 있는 고객의 정보
  -- 중복을 제거해서 조회
  -- 고객번호를 기준으로 정렬
 SELECT UNIQUE C.clientNo, C.clientName
 FROM CLIENT C
    inner join BOOKSALE BS
    ON C.clientNo = BS.clientNo
    ORDER BY C.clientNo;
    
-- 소장 도서에 대한 도서명과 출판사명
SELECT bookName, pubName
from book2 B
inner join publisher2 P
on B.pubNo = P.pubNo;

--------------------------------------------------------------------------------
-- 주문된 도서의 도서번호와 고객번호
select bookNo, clientNo
from bookSale;

-- 주문된 도서의 도서명과 고객명을 확인
select bookName, clientName
from bookSale

-- 주문(bookSale)된 도서의 도서명(book)과 고객명(client)을 확인
-- 3개 테이블 조인 진행 : select ~ from ~ inner join ~ on ~ inner join ~ on ~
select C.clientName, B.bookName
from bookSale BS
    inner join client C on C.clientNo = BS.clientNo
    inner join book2 B on B.bookNo = BS.bookNo;

-- 도서를 주문한 고객의 고객 정보, 주문 정보, 도서 정보    
select C.clientName, B.bookName, BS.bsDate, bs.bsQty
from bookSale BS
    inner join client C on C.clientNo = BS.clientNo
    inner join book2 B on B.bookNo = BS.bookNo;

-- 고객별 총 주문 수량 계산
-- 주문수량 기준 내림차순 정렬
select clientNo, sum(bsQty) as "총 주문 수량"
from bookSale
group by clientNo
order by "총 주문 수량" desc;

-- 고객별 총 주문 수량 계산
-- 주문수량 기준 내림차순 정렬
-- 고객명을 표현할 것
-- 고객별로 그룹 생성 시 동명이인이 있을 수 있기 때문에 고객명이 필요하다고 해서 무조건 고객이름만 가지고 그룹을 만들면 안됨
select C.clientNo, C.clientName, sum(BS.bsQty) as "총 주문 수량"
from bookSale BS
    inner join client C on C.clientNo = BS.clientNo
group by C.clientNo, C.clientName 
order by "총 주문 수량" desc;

-- GROUP BY 다음에 없는 열 이름이 select 절에 올 수 없음

-- 쿼리를 통한 연산 진행 - 가공필드 생성 가능
-- 주문된 도서의 주문일, 고객명, 도서명, 도서가격, 주문수량, 주문액(계산 가능: 주문 수량 * 단가)을 조회
select BS.bsDate, C.clientName, B.bookName, B.bookPrice, BS.bsQty, BS.bsqty * B.bookPrice as "주문액"
from bookSale BS
    inner join client C on C.clientNo = BS.clientNo
    inner join book2 B on B.bookNo = BS.bookNo
order by "주문액" desc;

-- 조인된 결과를 활용한 가공필드 생성
select BS.bsDate, C.clientName, B.bookName, B.bookPrice, BS.bsQty, BS.bsqty * B.bookPrice as "주문액"
from bookSale BS
    inner join client C on C.clientNo = BS.clientNo
    inner join book2 B on B.bookNo = BS.bookNo
where (BS.bsQty * B.bookPrice) >= 100000 -- 별칭 사용 불가능(별칭 구성 전에 실행됨)
order by "주문액" desc; -- 별칭 사용 가능

-- 2018년부터 현재까지 판매된 도서의 주문일, 고객명, 도서명, 도서가격, 주문수량, 주문액 계산 후 조회
select BS.bsDate, C.clientName, B.bookName, B.bookPrice, BS.bsQty, BS.bsqty * B.bookPrice as "주문액"
from bookSale BS
    inner join client C on C.clientNo = BS.clientNo
    inner join book2 B on B.bookNo = BS.bookNo
where BS.bsDate >= '2018-01-01'
order by BS.bsDate;

-- ==========================
-- client 테이블과 bookSale 테이블 활용 outer join 예시
-- 왼쪽(LEFT) 기준
select *
from client C
    left outer join booksale BS
    on C.clientNo = BS.clientNo
order by C.clientNo;

-- 조회결과 clientno_1 컴럼에 null이라고 표현되는 튜플은 주문한적이 없는 고객에 대한 정보를 주문정보 없이 표현

-- 오른쪽(RIGHT) 기준 : inner join 과 동일한 결과
-- 서점의 고객 중 주문하지 않은 고객은 존재 가능 단, 주문한 고객 중 서점의 회원이 아닌 고객은 없음
select *
from client C
    right outer join booksale BS
    on C.clientNo = BS.clientNo
order by C.clientNo;

-- 완전(FULL) OUTER JOIN
-- client가 아니면 주문 불가능 제약조건이 있음 : LEFT OUTER JOIN과 동일
select *
from client C
    full outer join booksale BS
    on C.clientNo = BS.clientNo
order by C.clientNo;

-- 오라클 OUTER 조인
-- (+)연산자로 조인시킬 값이 없는 조인측에 위치
-- 고객의 주문정보 확인하되 주문이 없는 고객의 정보 확인
select *
from client C, bookSale BS
where C.clientNo = BS.clientNo (+)
order by C.clientNo;

select *
from client C, bookSale BS
where C.clientNo(+) = BS.clientNo
order by C.clientNo;

--select *
--from client C, bookSale BS
--where C.clientNo(+) = BS.clientNo (+) -- ORA-01468: outer-join된 테이블은 1개만 지정할 수 있습니다
--order by C.clientNo;

