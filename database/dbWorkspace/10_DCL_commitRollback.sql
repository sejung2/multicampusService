-- commit/rollback

-- commit
/*
트랜잭션 처리가 정상적으로 종료되는 상황
트랜잭션이 수행한 변경 내용을 데이터베이스에 반영하는 연산
트랜잭션이 commit에 의해 완료되면 db는 완전 변경되어서 시스템 오류가 발생해도 취소되지 않음
*/

-- rollback
/*
트랜잭션 처리가 비정상적으로 종료된 경우
데이터베이스의 일관성이 깨졌다고 판단되면 트랜잭션이 진행한 변경작업을 취소하는 작업 - 이전상태로 되돌림
*/
-- 간단한 예제
-- insert : db table에 변경을 가함(rollback)
insert into book2 values ('12345', 'booktest', 'test', 33000, '2020-01-01', 5, '1');

select * from book2;

commit;

insert into book2 values ('123456', 'booktest2', 'test2', 33000, '2020-01-01', 5, '1');

rollback;