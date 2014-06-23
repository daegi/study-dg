--view
-- create view 뷰이름 as subquery; 
--ORA-00955: name is already used by an existing object
create or replace view emp_view
as
    select * from emp
    where deptno=30;
-- 뷰를 테이블처럼 사용할 수 있음 
select * from emp_view;
select * from (select "EMPNO","ENAME","JOB","MGR","HIREDATE","SAL","COMM","DEPTNO" from emp
    where deptno=30);
-- 데이터사전 조회 
select * from tab where tname='EMP_VIEW';  
select * from user_views;  
-- 게시판 페이지 나누기
select idx, name, subject, hit, post_date, cnt
from ( select A.*, rownum as rn 
         from (
            select idx, name, subject, hit, post_date
                , (select count(*) from board_comment 
                    where board_idx=b.idx ) cnt
            from board b
            order by idx desc ) A ) 
where rn between 51 and 60
order by idx desc;
-- 게시판 페이지 나누기를 위한 뷰 생성
create or replace view board_view
as
select idx, name, subject, hit, post_date, cnt, rn
from ( select A.*, rownum as rn 
         from (
            select idx, name, subject, hit, post_date
                , (select count(*) from board_comment 
                    where board_idx=b.idx ) cnt
            from board b
            order by idx desc ) A ) ;
-- cost 826, bytes : 16,052,120            
select * from board_view
where rn between 51 and 60;             

-- 뷰에 레코드 추가하기
select * from emp_view;

insert into emp_view (empno, ename,deptno) values (1111,'kim',30);
select * from emp_view;
insert into emp_view (empno, ename,deptno) values (1112,'kim',20);
select * from emp_view;
delete from emp_view where empno=1111;
select * from emp_view;

-- 뷰 삭제
-- drop view 뷰이름;
drop view emp_view;
-- 데이터 사전 확인
select * from user_views;

-- 사원번호, 사원이름, 부서코드, 부서이름
-- 뷰이름 : emp_dept_view
create or replace view emp_dept_view 
as
select empno, ename, e.deptno, dname
from emp e, dept d
where e.deptno=d.deptno;

select * from emp_dept_view;

-- 부서별 직원수, 평균급여, 최고급여, 최저급여
-- 뷰이름 : emp_sal_view
--ORA-00998: must name this expression with a column alias

create or replace view emp_sal_view
as
select 
    dname, count(*) 사원수, avg(sal) 평균급여
    , max(sal) 최고급여, min(sal) 최저급여
from emp e, dept d
where e.deptno=d.deptno
group by dname
union
select
    '전체',count(*) 사원수, avg(sal) 평균급여
    , max(sal) 최고급여, min(sal) 최저급여
from emp e, dept d
where e.deptno=d.deptno;
    
-- 컬럼이 아닌 경우에는 반드시 알리아스가 필요함 
select * from emp_sal_view;
select * from (select 
    dname, count(*) , avg(sal) , max(sal) , min(sal) 
from emp e, dept d
where e.deptno=d.deptno
group by dname);

-- A union B : A와 B의 합집합
-- A minus B : A-B (차집합)
drop table emp1;
create table emp1 as select * from emp where deptno=10;
drop table emp2;
create table emp2 as select * from emp where ename like 'M%';
select * from emp1;
select * from emp2;
-- A union B : A+B(합집합), 중복 레코드는 제거
select * from emp1 union select * from emp2;
-- A union all B : A+B(합집합), 중복 레코드 포함
select * from emp1 union all select * from emp2;
-- A minus B : A-B(차집합)
select * from emp1 minus select * from emp2;

desc emp;