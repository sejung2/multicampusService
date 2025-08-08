-- update 문
-- 특정 열의 값을 수정하는 명령어
-- 기본 형식
-- UPDATE 테이블명 SET 속성명=값 -> 특정 속성열의 모든 값을 동일한 값으로 변경
-- WHERE을 보통 사용함 -> 특정 튜플에 대해서만 값을 변경
-- UPDATE 테이블명 SET 속성명=값 WHERE=조건;

-- PRDNO가 5인 상품의 이름을 UHD TV로 변경하세요
UPDATE PRODUCT SET PRDNAME='UHD TV' WHERE PRDNO='5';