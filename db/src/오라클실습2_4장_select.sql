--수업자료/테스트용 데이터/test_data.sql 파일 다운로드
-- java 계정에서 실행

--위의 방법이 안되면
-- cmd 에서 실행
-- @test_data.sql 
-- null : 자료가 입력되지 않은 미정의 상태
-- null과의 연산결과는 항상 null 
-- p.58
select ename, sal, job, comm, sal*12  연봉, sal*12 + comm 실수령액
from emp;
-- nvl(A,B)  A가 null이면 B, A가 null이 아니면 A
select ename, sal, job, comm, sal*12  연봉
    , sal*12 + nvl(comm,0) 실수령액
from emp;
--  A || B    A와 B를 연결시킴    
select ename || '의 관리자는 '|| 
    case 
        when mgr is null then '없습니다.'
        when mgr is not null then mgr || '입니다'
    end  "mgr"
from emp;
-- 보너스가 없는 직원 목록
-- A is null  A가 null이면 ,  A is not null   A가 null이 아니면
select * from emp where comm is null;
select * from emp where comm = null;  -- null과의 연산 결과는 null
select * from emp where comm = 0; -- 보너스가 0인 직원
-- 관리자가 없는 직원
select * from emp where mgr is null;
select * from emp where mgr = null;  --잘못된 연산 
-- F9 : 현재 라인 실행
-- p.61 alias(별칭)
-- 컬럼 or 테이블 as 별칭   
-- 컬럼 or 테이블 별칭   ( as는 생략가능함 )
-- 컬럼 or 테이블 "별칭"  
-- '문자열'
select ename, sal*12 + nvl(comm,0) as 연봉 from emp;
select ename, sal*12 + nvl(comm,0) 연봉 from emp;
select ename, sal*12 + nvl(comm,0) "연  봉" from emp;
-- p. 66    distinct 중복값 제거, all 중복값을 모두 표시 
-- 부서코드 출력
select deptno from emp order by deptno; 
--중복값 제거
select distinct deptno from emp order by deptno;
-- 중복값을 모두 선택
select all deptno from emp order by deptno;

--p.96   조건절(where)
--p.97   급여가 3000 이상인 직원
select * from emp where sal >= 3000;
-- 부서코드가 10인 직원
select * from emp where deptno=10;
-- 사원이름이 CLARK 인 직원
select * from emp where ename = 'CLARK'; -- 작은 따옴표로 묶음
select * from emp where ename = 'clark'; -- 대소문자 구별
select * from emp where ename = CLARK; -- 컬럼으로 이해함
-- 날짜 데이터 조회
select ename, hiredate from emp order by hiredate;
-- 1981년 6월 1일 이후에 입사한 직원
select ename, hiredate from emp 
where hiredate >= '1981/06/01';  --날짜에도 따옴표를 붙임
-- 날짜에 따옴표를 붙이지 않으면 에러 발생
select ename, hiredate from emp  where hiredate >= 1981/06/01;
-- 2개 이상의 조건 : and , or 
-- 부서코드가 10번이고 직급이 MANAGER인 직원
select * from emp 
where deptno=10 and job='MANAGER';
-- 부서코드가 10번 또는 직급이 MANAGER인 직원
select * from emp 
where deptno=10 or job='MANAGER';

insert into emp (empno,ename) values (1,'kim');
insert into emp (empno,ename) values (2,'KIM');
select * from emp;
-- insert, delete, update를 한 경우에는 commit 을 해야 함
-- 트랜잭션 처리 명령어 
-- commit  변경사항을 확정함
-- rollback  변경사항을 취소시킴 

select * from emp where deptno = 10;
-- 10번 부서에 소속되지 않은 직원
select * from emp where deptno != 10;
select * from emp where deptno <> 10;
select * from emp where not deptno = 10;
-- 급여가 2000~3000인 직원
select * from emp where sal >= 2000 and sal <= 3000;
-- 컬럼  between A and B  : 컬럼값이 A~B 
select * from emp where sal between 2000 and 3000;
-- 커미션이 300 or 500 or 1400 인  직원
select * from emp
where comm = 300 or comm = 500 or comm = 1400;
-- 컬럼 in ( 집합 )  : 집합에 포함되는 경우
select * from emp where comm in (300,500,1400);
-- 커미션이 300 , 500 , 1400 이 아닌  직원
select * from emp
where comm <> 300 and comm <> 500 and comm <> 1400;
-- 컬럼 not in (집합)   : 집합에 포함되지 않는 경우
select * from emp where comm not in (300,500,1400);
-- 사번이 7521, 7654, 7844인 직원
select * from emp 
where empno = 7521 or empno = 7654 or empno = 7844;

select * from emp where empno in (7521,7654,7844); 
-- 이름이 M으로 시작하는 직원
select * from emp where ename like 'M%';
-- 이름에 M이 포함된 직원
select * from emp where ename like '%M%';
-- 이름의 두번째 글자가 A인 직원
select * from emp where ename like '_A%';
-- 이름에 M이 포함되지 않은 직원
select * from emp where ename not like '%M%';
-- 컬럼 like '%키워드%'    키워드가 포함된 레코드
-- 컬럼 like ' 키워드%'      키워드로 시작하는 레코드
-- 컬럼 like ' _J%'      두번째 글자가 J인 레코드 
-- 정렬 
-- order by 컬럼 asc : 오름차순 (기본옵션)
-- order by 컬럼 desc : 내림차순
-- 사원이름순으로 정렬
select * from emp order by ename;
select * from emp order by ename asc; -- asc 생략가능
select * from emp order by ename desc;  --내림차순
-- 입사일자순(입사일이 같으면 이름순)
select * from emp order by hiredate, ename;
-- 최근 입사일자순(입사일이 같으면 이름 오름차순)
select * from emp order by hiredate desc, ename;
-- 회원 테이블
create table member (
userid varchar2(50) not null,
passwd varchar2(50) not null,
name varchar2(50) not null,
primary key(userid)
);
-- create table 테이블이름 (  컬럼이름 자료형(사이즈) 제약조건 )
-- not null : null값을 허용하지 않음(필수입력)
-- primary key : 테이블 내에서 중복되지 않는 유일한 값(식별자)
insert into member values ( 'kim', '1234', '김씨');
insert into member values ( 'park', '1234', '박지성');
insert into member values ( 'admin', '1234', '관리자');
-- insert into 테이블 values ( 값1, 값2,,,, );
select * from member;
-- insert, delete, update 작업은 임시테이블에 저장됨
-- commit을 해야 원본테이블에 적용이 됨
commit;  
--로그인 성공
select name 
from member 
where userid='kim' and passwd='1234';
--로그인 실패
select name 
from member 
where userid='kim' and passwd='123';
--SQL Injection Attack(SQL 삽입 공격)
--id에 
--kkk' or 1=1 --
--비번은 아무 값이나 입력
----관리자로 로그인
--아이디 : admin' --
--비번 : 아무값이나 입력
--select name from member 
--where userid='kkk' or 1=1 --' and passwd='2222'

select name from member where userid='admin' --' and passwd='3333'

-- 파로스 프로그램 다운로드
-- http://www.parosproxy.org