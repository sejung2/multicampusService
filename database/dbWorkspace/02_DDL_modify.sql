-- ALTER TABLE (ADD/DROP/MODIFY/RENAME)

-- ALTER TABLE ADD : 속성 추가
ALTER TABLE PRODUCT ADD (prdUnitPrice NUMBER(8), prdStock NUMBER(12));

-- 열의 데이터 형식 변경 : ALTER TABLE 테이블명 MODIFY 속성명 변경타입
ALTER TABLE PRODUCT MODIFY prdUnitPrice NUMBER(4); -- 데이터가 존재할 때 크기 변경 시 범위를 벗어나는 데이터가 존재하면 변환오류 발생

-- 열의 제약 조건 NOT NULL -> NULL로 변경
ALTER TABLE PRODUCT MODIFY PRDNAME VARCHAR2(30) NULL;

-- 열 이름 변경 ALTER TABLE 테이블 명 RENAME COLUMN 기존컬럼명 to 새 컬럼명
ALTER TABLE PRODUCT RENAME COLUMN prdUnitPrice TO prUnitPrice;

-- 열 삭제
ALTER TABLE PRODUCT DROP COLUMN prdStock;

-- 여러개의 열 삭제
ALTER TABLE PRODUCT DROP (prdCompany, prdPrice);

--기본키 삭제 : 기본키는 반드시 있어야 하는 건 아님 단, 논리적 특징 유지를 위해 기본키는 설정해야함
-- 학생테이블 교수테이블을 참고하고 있음 -> 외부 테이블 참조 기본키는 참조오류로 기본키제약조건 삭제 불가
ALTER TABLE department
DROP PRIMARY KEY;

-- 제약조건(참조제약) 무시, 무조건 기본키를 삭제하기 원할 때 - CASCADE
ALTER TABLE department
DROP PRIMARY KEY CASCADE;

-- 제약조건 추가 : 기본키 추가
ALTER TABLE department
ADD CONSTRAINT PK_department_dptNo
PRIMARY KEY(dptNo);

ALTER TABLE STUDENT
ADD CONSTRAINT FK_student_department
FOREIGN KEY(dptNo) REFERENCES DEPARTMENT(dptNo);

-- 외래키 제약 조건 삭제 : DROP CONSTRAINT 제약조건명
ALTER TABLE student
DROP CONSTRAINT FK_student_department;

-- 기본키 삭제 - 참조하고 있는 다른 테이블이 없으면 바로 삭제됨
ALTER TABLE DEPARTMENT
DROP PRIMARY KEY;

-- 기본키 삭제하려고 할 때 기본키를 참조하는 테이블들에 대해 참조제약조건 삭제 후 기본키 제약조건 삭제 진행
-- cascade 이용 시 강제로 모든 참조 삭제

-----------------------------------------------------
-- 테이블 제약 조건 확인 쿼리
-- 일반 유저 설정 제약조건은 USER_CONSTRAINTS 테이블에 정보가 저장되어 있음
-- 일반 유저는 조회 권한을 가지고 있음
SELECT * FROM USER_CONSTRAINTS; --해당 USER 소유 테이블의 모든 제약조건 확인
SELECT * FROM USER_CONSTRAINTS
WHERE TABLE_NAME='STUDENT'; --해당 USER가 소유한 STUDENT 테이블의 제약조건 확인

--제약조건 타입
-- C : Check on a table, Check, Not Null
-- P : Primary Key
-- R : Foreign Key
-----------------------------

-- 데이터가 삭제되는 경우 삭제되는 레코드가 다른 테이블에서 참조되는 경우 데이터베이스 삭제 제약 받음
-- on delete cascade: 참조되고 있는 테이블의 데이터도 같이 삭제
ALTER TABLE STUDENT
ADD CONSTRAINT FK_STUDENT_DEPARTMENT
FOREIGN KEY(dptNo) REFERENCES department(dptNo)
on delete cascade;

-----------------------------

-- 테이블 삭제 : 테이블 모든 구조와 데이터 삭제
-- 데이터만 삭제 : DML의 DELETE 문
-- DROP TABLE 테이블명 [PURGE:CASCADE CONSTRAINTS]
-- PURGE: 복구 가능한 임시 테이블 생성 없이 영구 삭제
-- CASCADE CONSTRAINTS: 제약 조건 무시하고 기준 테이블을 강제 삭제(권장하지 않음)

-- 외래 키에 의해 참조되는 고유/기본 키가 테이블에 있습니다. 삭제 불가
DROP TABLE department;

-- 참조 상관없이 무조건 테이블 삭제
DROP TABLE department CASCADE CONSTRAINTS;

-- 참조 제약 조건 상관없는 테이블
DROP TABLE product;