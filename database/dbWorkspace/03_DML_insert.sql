-- 데이터 조작어(DML)
-- 데이터 입력/삭제/수정/검색
-- INSERT : 테이블의 데이터(튜플)을 저장하는 조작을 진행
-- INSERT INTO 테이블명(열이름 리스트) VALUES(값 리스트) : 부분열만 저장 가능 - NULL 허용하는 열의 값은 생략해도 됨
-- INSERT INTO 테이블명 VALUES(값 리스트) : 값 리스트에 모든 열의 값이 순서에 맞춰서 존재해야 함

-- STUDENT 테이블에 행 삽입 -- 열 이름 리스트 나열하면 열 순서 상관없음, 값 순서는 나열한 열 순서와 동일 해야함
INSERT INTO STUDENT(stdNo, stdGrade, stdName, dptNo)
values('2016005', 3, '홍길동', 2); 