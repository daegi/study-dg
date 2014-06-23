-- 서브쿼리(sub query)
select empno,ename
, ( select ename from emp where e.mgr = empno) 매니저
from emp e;

-- FORD와 같은 부서에서 근무하는 사원이름, 부서코드 출력
select * from emp where ename='FORD';  -- 20번 부서

select ename, deptno 
from emp
where deptno =  (select deptno from emp where ename='FORD');
-- 월급을 가장 적게 받는 사원
select min(sal) from emp;
select * from emp where sal=800;
-- 서브쿼리는 반드시 괄호로 묶어야 함
select * from emp where sal=(select min(sal) from emp);
-- 평균 급여 이상을 받는 사원목록
select avg(sal) from emp;
select * from emp where sal >= 2225;
select * from emp where sal >= (select avg(sal) from emp);
-- 30번 부서에 근무하는 사원들의 평균급여보다 급여가 높은 사원목록
-- 실행계획 확인 : Ctrl+E 
select avg(sal) from emp where deptno=30;
select * from emp where sal > 1566;
select * from emp 
where sal > (select avg(sal) from emp where deptno=30);
-- NEW YORK 에서 근무하는 사원이름, 부서번호
select deptno from dept where loc='NEW YORK';
select * from emp where deptno=10;
select * from emp 
where deptno=(select deptno from dept where loc='NEW YORK'); 

select ename, e.deptno, loc
from emp e, dept d
where e.deptno = d.deptno
    and loc='NEW YORK';
-- SALES 부서에서 근무하는 사원이름, 급여
select deptno from dept where dname='SALES';
select ename,sal from emp where deptno=30;
select ename,sal from emp 
where deptno=(select deptno from dept where dname='SALES');

select ename,sal
from emp e, dept d
where e.deptno=d.deptno and dname='SALES';

-- 2번 게시물의 상세 정보
select * from memo where idx=2;
rollback;
--update 테이블 set 컬럼=값 where 컬럼=값
update memo set writer='김과장', memo='밥 먹으러 갑시다' 
where idx=2;
delete from memo where idx=2;
--p.244 다중행 서브 쿼리
select distinct deptno from emp where sal >= 3000;
-- 에러 발생 구문
select ename, sal, deptno from emp
where deptno = (select distinct deptno from emp where sal >= 3000);
-- 서브쿼리의 결과가 2개 이상일 경우
select ename, sal, deptno from emp
where deptno in (select distinct deptno from emp where sal >= 3000);

select ename, sal, deptno from emp where deptno in (10, 20, 30, 40);

select ename, sal, deptno from emp 
where deptno = 10 or deptno = 20 or deptno = 30 or deptno = 40;
-- where 절에서 실행되는 서브쿼리
-- where 컬럼 = (단일행 서브쿼리 )
-- where 컬럼 in (복수행 서브쿼리)
-- 30번 부서에 속한 사원들의 최대 월급보다 급여가 높은 사원목록
-- 1. 30번 부서에 속한 사원들의 최대 월급
select max(sal) from emp where deptno=30;

select * from emp where sal > 2850;

select * from emp 
where sal > (select max(sal) from emp where deptno=30);
-- 에러 발생
select * from emp 
where sal > (select sal from emp where deptno=30);
-- 컬럼 in( 집합 )  집합의 모든 요소 중에서 1개 이상 만족
-- 컬럼 > all( 집합 )   집합의 모든 요소의 값을 만족해야 함
-- 컬럼 > any( 집합 ) 집합의 모든 요소 중에서 최소 1개 만족
select * from emp 
where sal > all(select sal from emp where deptno=30); -- 최대값

select * from emp 
where sal > any(select sal from emp where deptno=30); -- 최소값
-- 메인쿼리와 독립적인 서브쿼리
-- 메인쿼리에 의존적인 서브쿼리

-- 사원이름, 부서코드, 부서명 
select ename, deptno, (select dname from dept where deptno=e.deptno)
from emp e;

select ename, e.deptno, dname
from emp e, dept d
where e.deptno=d.deptno(+);

select d.deptno, dname, count(empno)
from dept d, emp e
where d.deptno=e.deptno(+)
group by d.deptno, dname
order by deptno;
-- scalar subquery(스칼라 서브쿼리) - select절의 컬럼 1개
select deptno, dname
, (select count(empno) from emp where deptno=d.deptno) 직원수
from dept d;
-- from절에 위치한 서브쿼리( 인라인 뷰 , inline view )
select distinct job from emp;
-- 직책이 CLERK인 직원들의 이름, 직책, 부서명 출력
select ename, job, dname
from emp e, dept d
where d.deptno=e.deptno and job='CLERK'; 
-- inline view
select ename, job, dname
from (select ename, job, deptno from emp where job='CLERK') e, dept d
where d.deptno=e.deptno; 


-- 본인이 속한 부서의 평균급여보다 급여가 적은 사원목록
select * from emp;
select avg(sal) from emp where deptno=20;

select 
 ename, sal,  (select avg(sal) from emp where deptno=e.deptno) 평균급여
from emp e
where sal < (select avg(sal) from emp where deptno=e.deptno) 
order by 평균급여 desc;








    

