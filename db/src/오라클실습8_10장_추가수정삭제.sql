-- 새로운 행 추가(p.290)
-- 모든 컬럼에 값을 입력
-- insert into 테이블 values (값1, 값2,,,,);
-- 지정된 컬럼에 값을 입력
-- insert into 테이블 (컬럼1, 컬럼2, 컬럼3,,,,) values (값1, 값2, 값3,,,);
drop table dept01;
create table dept01 as select * from dept where 0=1;

select * from dept01;
-- 숫자 데이터 - 따옴표로 묶지 않음
-- 문자 데이터 - 따옴표로 묶음
insert into dept01 (deptno, dname, loc) values 
( 10, 'ACCOUNTING', 'NEW YORK');
-- 값이 부족한 경우(에러)
insert into dept01 (deptno, dname, loc) values ( 20, 'SALES');
-- 값이 많은 경우(에러)
insert into dept01 (deptno, dname, loc) values
 ( 20, 'SALES', '부산', 20);
-- 컬럼 이름이 잘못된 경우(에러)
insert into dept01 (num, dname, loc) values
 ( 20, 'SALES', '부산'); 
-- 컬럼 이름을 생략(모든 컬럼을 순서대로 입력)
insert into dept01 values ( 20, 'SALES', '부산');
-- null 값의 입력 방법(p.298)  
-- 암시적으로 null값이 삽입됨
insert into dept01 (deptno, dname) values (30, 'SALES');
-- 명시적으로 null값 삽입
insert into dept01 values ( 40, 'OPERATIONS', null );
select  * from dept01;
desc dept01;
-- 다중행 입력(p.303)
-- insert into 테이블 select명령어;
--테이블 복사
create table emp_hir 
as select empno, ename, hiredate  from emp where 0=1;
-- 다중행 입력
insert into emp_hir select empno, ename, hiredate from emp;

select * from emp_hir;
-- 새로운 테이블을 만들어서 자료 복사
create table emp02 as select * from emp;
-- 기존에 존재하는 테이블에 자료 복사
-- insert into 새테이블 select * from 테이블
-- table or view does not exist
insert into emp02 select * from emp;
-- 오라클에서는 에러 발생
select * into emp03 from emp;

-- update (p.311)
--update 테이블 set 컬럼1=값1, 컬럼2=값2 where 조건
create table emp01 as select * from emp;

select * from emp01;
-- 조건절이 없으면 모든 레코드의 값이 변경됨
update emp01 set deptno=30;
-- 전체 직원의 급여를 20% 인상
update emp01 set sal = sal * 1.2;
-- 전체 직원의 입사일자를 오늘날짜로 변경
update emp01 set hiredate = sysdate;

rollback;
select * from emp01; 

-- 부서코드가 10번인 사원의 부서코드를 30으로 변경
update emp01 set deptno=30 where deptno=10;
-- 급여가 3000 이상인 사원들의 급여를 10% 인상
update emp01 set sal = sal * 1.1 where sal >= 3000;
select * from emp01;
-- SMITH 사원의 부서를 30으로, 직급을 MANAGER로 변경
update emp01 set deptno=30, job='MANAGER' 
where ename='SMITH';
--ALLEN의 입사일자를 오늘날짜로, 급여를 3000으로 커미션을 500으로 변경
update emp01 set hiredate=sysdate, sal=3000, comm=500
where ename= 'ALLEN';
-- 삭제(p.323)
-- delete from 테이블 where 조건   ( from 생략 가능 )
select * from dept01;
-- 조건절이 없으면 모든 레코드가 삭제됨(주의)
delete from dept01;
select * from dept02;
--30번 부서 삭제
delete dept02 where deptno=30;

select * from board where idx=100000;

update board
set name='park', subject='제목 수정', content='내용 수정'
where idx=100000;

delete from board where idx=100000;

--방명록 테이블
create table guestbook (
idx number(5) not null,
name varchar2(50) not null,
email varchar2(50) ,
content varchar2(2000) not null,
post_date date default sysdate,
primary key(idx)
);
-- 테스트 자료 입력
insert into guestbook (idx,name,email,content) values
(1, 'kim', 'kim@test.com', '첫번째 방명록');

select * from guestbook;
-- 서브쿼리를 사용하여 일련번호 계산
-- nvl( A, B ) A가 null일 때 B
insert into guestbook (idx,name,email,content) values
( (select nvl(max(idx)+1,1) from guestbook) 
    , 'park', 'park@test.com', '두번째 방명록'); 

commit;


commit;



 
    





select * from dept01; 

