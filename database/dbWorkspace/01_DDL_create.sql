CREATE TABLE product(
    prdNo VARCHAR2(10) NOT NULL PRIMARY KEY,
    prdName VARCHAR2(30) NOT NULL,
    prdPrice NUMBER(8),
    prdCompany VARCHAR2(30)
);

CREATE TABLE product(
    prdNo VARCHAR2(10) NOT NULL,
    prdName VARCHAR2(30) NOT NULL,
    prdPrice NUMBER(8),
    prdCompany VARCHAR2(30),
    PRIMARY KEY(prdNo)
);
-- 3. 제약 이름과 같이 설정 - 제약 변경이나 삭제 시 유용
CREATE TABLE product(
    prdNo VARCHAR2(10) NOT NULL CONSTRAINT PK_Product_prdNo PRIMARY KEY,
    prdName VARCHAR2(30) NOT NULL,
    prdPrice NUMBER(8),
    prdCompany VARCHAR2(30)
);
-- 4. 따로 설정 제약명 추가
CREATE TABLE product2(
    prdNo VARCHAR2(10) NOT NULL,
    prdName VARCHAR2(30) NOT NULL,
    prdPrice NUMBER(8),
    prdCompany VARCHAR2(30),
    CONSTRAINT PK_Product_prdNo PRIMARY KEY(prdNo)
);

-----------------------------------------------------
/* 출판사 테이블 생성(출판사 번호, 출판사명)
제약조건
- 기본키 not null
*/

CREATE TABLE publisher(
    pubNo VARCHAR2(10) NOT NULL PRIMARY KEY,
    pubName VARCHAR2(30) NOT NULL
);
/* 도서 테이블 생성(도서 번호, 도서명, 가격, 발행일, 출판사 번호)
제약조건
- 기본키
- 외래키
*/
-- 외래키 필드는 참조테이블에서는 기본키여야 함
CREATE TABLE book(
    bookNo VARCHAR2(10) NOT NULL PRIMARY KEY,
    bookName VARCHAR2(30) NOT NULL,
    bookPrice NUMBER(8) DEFAULT 10000 CHECK(bookPrice > 1000),
    bookDate DATE,
    pubNo VARCHAR2(10) NOT NULL,
    CONSTRAINT FK_book_publisher FOREIGN KEY(pubNo) REFERENCES publisher(pubNo)
);
-----------------
--create 연습문제
-- 학과 테이블
create table department (
  dptNo varchar2(10) not null primary key,
    dptName varchar2(30) not null,
    dptTel varchar2(13) not null
);

drop table student;
create table student (
	stdNo varchar2(10) not null primary key,
    stdName varchar2(30) not null,
    stdYear int default 4 check (stdYear BETWEEN 1 AND 4),
    stdBirth date,
    dptNo varchar2(10) not null,
    foreign key (dptNo) references department(dptNo)
);

-----------------------------------------------------
-- 교수 테이블
create table professor (
	profNo varchar2(10) not null primary key,
    profName varchar2(30) not null,
    profPosition varchar2(30),
    profTel varchar2(13),
    dptNo varchar2(10) not null,
    foreign key (dptNo) references department(dptNo)
);

-- 과목 테이블
create table course (
	courseId varchar(10) not null primary key,
    courseName varchar(30) not null,
    courseCredit int,
    profNo varchar(10) not null,
    foreign key (profNo) references professor(profNo)
);

CREATE TABLE SCORES(
    STDNO VARCHAR2(10) NOT NULL,
    COURSEID VARCHAR2(10) NOT NULL,
    SCORE NUMBER(3),
    GRADE VARCHAR(2),
    CONSTRAINT PK_SCORES_STDNO_COURSEID PRIMARY KEY(STDNO, COURSEID),
    CONSTRAINT FK_SCORES_STUDENT FOREIGN KEY(STDNO) REFERENCES STUDENT(STDNO),
    CONSTRAINT FK_SCORES_COURSE FOREIGN KEY(COURSEID) REFERENCES COURSE(COURSEID)
);
---------------------------------------------
CREATE TABLE STUDENT 
(
    STDNO VARCHAR2(10 BYTE) NOT NULL,
    STDNAME VARCHAR2(30 BYTE) NOT NULL,
    STDYEAR NUMBER DEFAULT 4 CHECK (STDYEAR >= 1 AND STDYEAR <= 4),
    STDADDRESS VARCHAR2(30 BYTE),
    STDBIRTH DATE,
    DPTNO VARCHAR2(10 BYTE) NOT NULL,
    CONSTRAINT PK_STUDENT PRIMARY KEY (STDNO)
);

INSERT INTO STUDENT (STDNO, STDNAME, STDYEAR, STDADDRESS, STDBIRTH, DPTNO) 
VALUES ('12345678', '김수지', 2, '서울', DATE '2020-01-01', '003');

INSERT INTO STUDENT (STDNO, STDNAME, STDYEAR, STDADDRESS, STDBIRTH, DPTNO) 
VALUES ('123567', '윤석훈', 1, '서울', DATE '2020-01-01', '003');

INSERT INTO STUDENT (STDNO, STDNAME, STDYEAR, STDADDRESS, STDBIRTH, DPTNO) 
VALUES ('2023001', '홍길동', 3, '서울시', DATE '1999-01-01', '002');

INSERT INTO STUDENT (STDNO, STDNAME, STDYEAR, STDADDRESS, STDBIRTH, DPTNO) 
VALUES ('2023002', '이몽룡', 1, '서울시', DATE '2001-05-03', '001');

INSERT INTO STUDENT (STDNO, STDNAME, STDYEAR, STDADDRESS, STDBIRTH, DPTNO) 
VALUES ('2023003', '성춘향', 4, '경기도', DATE '1996-10-10', '003');

INSERT INTO STUDENT (STDNO, STDNAME, STDYEAR, STDADDRESS, STDBIRTH, DPTNO) 
VALUES ('12345', '김철수', 1, '인천', DATE '2020-01-01', '002');