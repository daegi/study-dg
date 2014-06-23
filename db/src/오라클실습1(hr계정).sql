--오라클 접속(cmd)
-- 관리자 계정으로 접속
sqlplus / as sysdba
-- 테이블 스페이스 생성
create tablespace java
datafile 'd:/java/java.dbf' size 50M
autoextend on
next 1M
maxsize 200M;
-- 사용자 계정 생성
create user java identified by java1234
default tablespace java;
-- 사용권한 부여
-- grant 부여할 권한들 to 아이디;
grant connect, resource, dba to java;
-- connect : 접속 권한
-- resource : 리소스 사용 권한
-- dba : DB관리자 권한
-- revoke 회수할 권한들 to 아이디;

-- 외부 서버 접속 방법 
sqlplus 아이디/비번@IP주소
sqlplus   java/java1234@211.63.89.200

-- create : 생성
-- alter : 수정
-- drop : 삭제

-- hr 계정을 활성화시킴
alter user hr identified by hr account unlock;
-- 실행방법 : 마우스 드래그
-- hr 계정의 테이블 목록 확인
select * from tab;
-- desc   테이블이름;    테이블의 정보 확인 
desc departments;
-- varchar2 : 가변길이 문자열         
--   varchar2(50)
-- char : 고정길이 문자열
--   char(50)

select * from employees
order by first_name desc;  
--사번, 이름, 급여
select employee_id, first_name, salary
from employees
order by salary;

-- asc : 오름차순, desc : 내림차순
--부서 목록
select * from departments;
-- 테이블 조인
-- 컬럼이름 or 테이블이름  별칭(alias)
-- 사번, 이름, 부서이름 
-- 테이블이름.컬럼이름
select employee_id, first_name, department_name, e.department_id
from employees e, departments d   
where e.department_id = d.department_id;

-- apache tomcat(아파치 톰캣) 다운로드

--http://tomcat.apache.org
-- 자바 버전
--Java SE ( Standard Edition)
--Java EE ( Enterprise Edition)
--Java ME ( Micro Edition )

-- ojdbc6.jar => WebContent/WEB-INF/lib 에 복사
-- emp_list.jsp => WebContent 에 복사
-- emp_list.jsp를 실행시킴













