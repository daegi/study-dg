-- p.218 self join
select empno, ename, mgr from emp;
-- smith의 매니저 이름은?
select * from emp where empno=7902;
-- self join
-- 중복되는 이름의 컬럼이 있을 경우 : 테이블이름.컬럼이름
select a.empno, a.ename, a.mgr, b.ename 매니저이름
from emp a, emp b
where a.mgr = b.empno; -- join 조건
-- 매니저의 이름이 KING인 사원들의 이름과 직급 출력
select a.ename, a.job
from emp a, emp b
where a.mgr = b.empno -- join 조건
    and b.ename = 'KING';
-- inner join(내부조인)    
-- p.222 outer join(외부조인) 
select * from emp;
select * from dept;
select distinct deptno from emp; 
-- 부서별 근무직원수, 급여합계, 급여평균
-- 데이터가 없는 테이블에 (+)
select dname, count(sal), sum(sal), avg(sal)
from emp e, dept d
where e.deptno(+)=d.deptno
group by dname;
-- ansi inner join
select dname, count(sal), sum(sal), avg(sal)
from emp e inner join dept d
    on e.deptno=d.deptno
group by dname;
-- ansi outer join
-- A테이블 left outer join B테이블
-- A테이블 right outer join B테이블
-- A테이블 full outer join B테이블
select dname, count(sal), sum(sal), avg(sal)
from dept d left outer join emp e
    on e.deptno=d.deptno
group by dname;
-- 매니저가 없는 KING이 누락됨
-- Ctrl + E ( 실행계획 확인 )
-- 파싱 -> 실행계획(Optimizer) 
select a.ename, a.mgr, b.ename 매니저
from emp a, emp b
where a.mgr = b.empno;
-- outer join
select a.empno,a.ename, a.mgr, b.ename 매니저
from emp a, emp b
where a.mgr = b.empno(+);
-- ansi inner join    
select a.empno,a.ename, a.mgr, b.ename 매니저
from emp a inner join emp b
    on a.mgr = b.empno;
-- ansi outer join
select a.empno,a.ename, a.mgr, b.ename 매니저
from emp a left outer join emp b
    on a.mgr = b.empno;
insert into emp (empno, ename,sal) values (7000, '김과장', 4000);
select * from emp;
-- 사번, 이름, 부서이름, 급여액
-- 부서코드가 없는 '김과장'은 누락됨
select empno, ename, dname, sal
from emp e, dept d
where e.deptno=d.deptno(+);  -- 짝이 없는 테이블에 (+)

select empno, ename, dname, sal
from emp e left outer join dept d  -- 데이터가 있는 테이블의 방향 
    on e.deptno=d.deptno;
