-- 데이터 조작어(DML)
-- 데이터 입력/삭제/수정/검색
-- INSERT : 테이블의 데이터(튜플)을 저장하는 조작을 진행
-- INSERT INTO 테이블명(열이름 리스트) VALUES(값 리스트) : 부분열만 저장 가능 - NULL 허용하는 열의 값은 생략해도 됨
-- INSERT INTO 테이블명 VALUES(값 리스트) : 값 리스트에 모든 열의 값이 순서에 맞춰서 존재해야 함

-- STUDENT 테이블에 행 삽입 -- 열 이름 리스트 나열하면 열 순서 상관없음, 값 순서는 나열한 열 순서와 동일 해야함
INSERT INTO STUDENT(stdNo, stdGrade, stdName, dptNo)
values('2016007', 4, '김철수', 1); 

-- 열 나열 없이 실제 값만 나열: 단, 모든 필드의 값이 다 나열되어야 함
INSERT INTO STUDENT
values('2016005', 3, '홍길동', 2); 

--==============================
INSERT INTO book
VALUES('5', '자바스크립트', 23000, '2019-05-17', '2');

-- book 테이블 내용 조회
SELECT * FROM BOOK;

SELECT bookName FROM BOOK WHERE bookNo='2';

-- 여러개의 튜플을 저장 INSERT ALL INTO 테이블명() VALUES() INTO 테이블명() ...
INSERT ALL
    INTO BOOK VALUES('6', 'ORM', 53000, '2022-12-30', '2')
    INTO BOOK VALUES('7', 'JPA', 35000, '2022-10-30', '1')
SELECT *
FROM DUAL;

--========================================================================
-- 시퀀스
-- 오라클 DB 객체로 유일한 값의 일련번호 생성
-- 지정한 수치로 증가하거나 감소
-- 기본키에 자동증가값을 사용할때 유용
-- 최대 15개 까지 생성 가능
-- 테이블과 독립적으로 저장 생성
-- 하나의 시퀀스 여러 테이블에서 사용가능

CREATE SEQUENCE NO_SEQ
    START WITH 1
    INCREMENT BY 1
    MAXVALUE 10000
    MINVALUE 1
    NOCYCLE;
    
--  시퀀스 적용할 테이블 생성
CREATE TABLE  board(
    bNo NUMBER PRIMARY KEY, -- 기본키 (시퀀스 적용할 컬럼)
    bSubject VARCHAR2(30) NOT NULL,
    bname   VARCHAR2(20) NOT NULL
);

-- 데이터 추가
INSERT INTO BOARD VALUES(NO_SEQ.NEXTVAL, '추석', '홍길동'); -- NO_SEQ.NEXTVAL: 현재값에서 증가분만큼 증가시켜 반환하고 변환된 값 저장
INSERT INTO BOARD VALUES(NO_SEQ.NEXTVAL, '미세먼지', '김철수');
INSERT INTO BOARD VALUES(NO_SEQ.NEXTVAL, '휴가', '김영희');

SELECT * FROM BOARD;

-- 시퀀스 값 검색
SELECT NO_SEQ.CURRVAL FROM DUAL;

-- 시퀀스 수정
ALTER SEQUENCE NO_SEQ
    MAXVALUE 1000;
    
-- 수정 결과 검색: 구조에 대한 검색, 시퀀스 정보 저장 테이블 USER_SEQUENCES
SELECT SEQUENCE_NAME, MAX_VALUE
FROM USER_SEQUENCES;

-- 시퀀스 삭제 : DROP SEQUENCE
DROP SEQUENCE NO_SEQ;

-- 삭제 확인
SELECT SEQUENCE_NAME FROM USER_SEQUENCES; -- 삭제했으므로 반환되는 결과 내용은 없음, 빈테이블이 반환됨

-- DUAL 테이블
-- 오라클 자체에서 제공되는 테이블
-- 1개의 행과 1개의 열만 존재하는 더미 테이블
-- SYS 소유지만 모든 사용자가 사용가능
-- 간단한 함수 계산 결과 값 확인할 때 테이블 생성없이 결과값 확인(리턴 받을 수 있음)
SELECT CURRENT_DATE FROM DUAL;

-----------------------------------------------------------------------------
-- 데이터 임포트
-- 텍스트 파일을 읽어서 테이블 생성 및 데이터 구성
DROP TABLE PRODUCT2;
-- 데이터 임포트 후 제약조건 추가
ALTER TABLE PRODUCT3
    ADD CONSTRAINT PK_PRODUCT_PRDNO3
    PRIMARY KEY(PRDNO);
    
    -- update문
-- 특정 열의 값을 수정하는 명령어
-- 기본형식
-- UPDATE 테이블명 SET 속성명 = 값 -> 특정속성열의 모든 값을 동일한 값으로 변경시킴
-- WHERE 절을 보통 사용함 -> 특정 튜플에 대해서만 값을 변경

-- PRDNO가 5인 상품을 찾아서 PRDNAME을 UHD TV로 변경
UPDATE PRODUCT3 SET PRDNAME = 'UHD TV' WHERE PRDNO = '5';

--DELETE 문
-- 테이블의 기존 행을 삭제하는 명령어
-- DELETE FROM 테이블명 [WHERE 조건]; -> 조건 생략시 테이블의 모든 데이터 삭제됨
--WHERE 조건 특정 튜플만 삭제
-- DELETE 문으로 테이블의 모든 행을 삭제해도 테이블은 그대로 유지됨

DELETE FROM PRODUCT3 WHERE PRDNAME='그늘막 텐트';

-- DELETE 문의 반환 결과는 몇 개행이 삭제되었는지에 대한 결과가 반환


SELECT * FROM PRODUCT3;