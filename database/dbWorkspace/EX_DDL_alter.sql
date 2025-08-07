-- 1.product 테이블에 숫자 값을 갖는 prdStock과 제조일을 나타내는 prdDate 열 추가
ALTER TABLE product ADD (prdStock NUMBER(8), prdDate DATE);

-- 2.product 테이블의 prdCompany 열 기본 추가해서 을 NOT NULL로 변경
ALTER TABLE product ADD prdCompany VARCHAR2(20);
ALTER TABLE product MODIFY prdCompany VARCHAR2(20) NOT NULL;

-- 3.publisher 테이블에 pubPhone, pubAddress 열 추가
ALTER TABLE publisher ADD (pubPhone VARCHAR2(20), pubAddress VARCHAR2(30));

-- 4.publisher 테이블에서 pubPhone 열 삭제
ALTER TABLE publisher DROP COLUMN pubPhone;

