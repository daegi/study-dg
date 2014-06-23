--6장 그룹함수
-- sum() 합계, count() 갯수, avg() 평균, max() 최대값, min() 최소값
select count(*), sum(sal), avg(sal), max(sal), min(sal) from emp;
-- 직원 테이블의 부서 갯수
select count(*) from emp;  -- null 값 포함
select count(deptno) from emp;  -- null 값 제외 
select count(distinct deptno) from emp;  -- distinct 중복값 제거

select count(*), sum(sal), avg(sal), max(sal), min(sal) 
from emp
where deptno=10;
-- 부서별 급여통계
-- select절의 컬럼과 group by 절의 컬럼은 같아야 함(집계함수 제외)
select deptno, count(*), sum(sal), avg(sal), max(sal), min(sal) 
from emp
group by deptno   -- 집계 기준 컬럼
order by deptno;
-- 하위분류의 집계 방법 
select deptno, job,count(*), sum(sal), avg(sal), max(sal), min(sal) 
from emp
group by deptno,job   -- 집계 기준 컬럼
order by deptno;
-- 부서별 평균 급여가 2000 이상인 부서의 평균급여 출력
-- where : from 절의 레코드 중에서 선택
select * from emp
where sal >= 2000;

select deptno, avg(sal)
from emp
group by deptno
having avg(sal) >= 2000  -- group by를 실행한 행 중에서 선택
order by deptno;
-- 사번, 이름, 부서코드, 부서이름
-- 양쪽 테이블에 같은 이름의 컬럼이 있을 경우 :  테이블이름.컬럼이름
select empno, ename, e.deptno, dname
from emp e, dept d   -- 조인할 대상 테이블
where e.deptno=d.deptno;  -- 조인조건(두 테이블의 연결조건)

-- cross join
select empno, ename, e.deptno, dname
from emp e, dept d;
-- equi join(동등조인)
select empno, ename, e.deptno, dname
from emp e, dept d
where e.deptno=d.deptno; 
-- sales 부서 직원만 출력하려면?
select empno, ename, e.deptno, dname
from emp e, dept d
where e.deptno=d.deptno  -- 조인 조건 
    and e.deptno=30;  -- 일반 조건 
-- 오라클의 조인 방식
-- ANSI JOIN
-- Oracle JOIN
-- A테이블 join B테이블 on A테이블.컬럼=B테이블.컬럼    
select empno, ename, e.deptno, dname
from emp e inner join dept d          -- 조인할 대상 테이블
    on  e.deptno=d.deptno      -- 조인 조건
where e.deptno=30;
-- 뉴욕에서 근무하는 사원의 이름과 급여 출력
select ename, sal
from emp e, dept d
where e.deptno=d.deptno
    and loc='NEW YORK';
    
select ename, sal
from emp e join dept d      -- 쉼표를 join으로
    on e.deptno=d.deptno    -- where를 on 으로
where loc='NEW YORK';       -- and를 where로 

-- 직급이 MANAGER인 사원의 이름, 부서명 출력
select ename, dname
from emp e, dept d
where e.deptno=d.deptno
    and job='MANAGER';    
    

-- 부서명, 평균급여
select dname, avg(sal)
from emp e, dept d
where e.deptno=d.deptno
group by dname;
-- 근무지, 근무직원수, 급여평균
select loc 근무지, count(loc) 직원수, round( avg(sal), 1 ) 급여평균
from emp e, dept d
where e.deptno=d.deptno
group by loc
order by 급여평균 desc;
-- p.215 Non-Equi join(비동등조인)
select * from salgrade;
select * from emp where empno=7369;
-- 이름, 급여액, 호봉
select ename, sal, grade
from emp e, salgrade s
where sal between losal and hisal;  -- Non-Equi Join(비동등조인)
-- 사원이름, 부서이름, 호봉
select ename, dname, grade
from emp e, dept d, salgrade s
where e.deptno=d.deptno                     -- Equi Join
    and e.sal between s.losal and s.hisal;    -- Non-Equi Join
select * from salgrade;    
select ename, dname--, grade
from emp e join dept d
            on e.deptno=d.deptno
      join salgrade s                     
            on e.sal between s.losal and s.hisal; 
-- 시퀀스(sequence) p.462 참조
-- 일련번호를 만들어주는 개체
-- create sequence 시퀀스이름 
create sequence memo_seq
increment by 1      -- 증가값
start with 1;           -- 시작값
-- 시퀀스이름.nextval  새로운 일련번호 발급
select memo_seq.nextval from dual;

insert into memo (idx, writer, memo ) values 
( memo_seq.nextval, 'kim', '메모연습' );

select * from memo order by idx desc;
delete from memo where idx=29;
commit;    
    
-- <태그>          





