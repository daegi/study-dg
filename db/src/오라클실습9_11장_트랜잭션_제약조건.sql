-- p.338
--테이블 삭제
drop table dept01;
--테이블 복사
create table dept01 as select * from dept;

delete from dept01;
select * from dept01;
commit;
-- savepoint 테스트를 위한 테이블 생성
create table dep(
    id varchar2(10) primary key, 
    name varchar2(15) not null,
    location varchar2(50) 
);

insert into dep values('10', '영업부', '서울 강남구');
savepoint a;
insert into dep values('20', '회계부', '부산 동래구');
savepoint b;
insert into dep values('30', '개발부', '인천 계양구');
rollback to a;
select * from dep;
commit;
select * from dep;
delete from dep where id=10;
-- p.369
select * from dept;
insert into dept values (null, null, 'SEOUL');
desc dept;
-- 제약조건 확인 
select * from user_constraints where table_name='DEPT';
-- p.370
--unique constraint (JAVA.PK_DEPT) violated  
-- primary key : 유일한 값 ( null값을 허용하지 않음 )
-- unique : 유일한 값 ( null값 허용 )
insert into dept values (10, 'test', 'seoul');
-- P.374 NOT NULL 제약조건
drop table emp01;
-- 제약조건 이름을 직접 지정하는 방법
-- constraint 테이블이름_컬럼이름_제약조건코드
create table emp01 (
empno number(4) constraint emp01_empno_nn not null,
ename varchar2(10) constraint emp01_ename_nn not null,
job varchar2(9),
deptno number(2)
);
--ORA-01400: cannot insert NULL into ("JAVA"."EMP01"."EMPNO")
insert into emp01 values ( null, null, 'salesman', 30);
select * from emp01;
-- 제약조건 확인
desc emp01;
-- 데이터 사전에서 제약조건 확인
-- CONSTRAINT_TYPE : C ( not null, check 제약조건 )
select * from user_constraints where table_name='EMP01';


-- unique 제약조건(p.378)
-- 특정 컬럼에 자료가 중복되지 않도록 구분하기 위한 제약조건
-- primary key와 다른 점 : null을 허용함
-- primary key = unique + not null
-- emp03 테이블 삭제
drop table emp03;
-- emp03 테이블 복사(데이터 제외)
create table emp03 as select * from emp where 1=0;
-- unique 제약조건을 적용시킨 테이블
create table emp03 (
empno number(4) constraint emp03_empno_uk unique ,
ename varchar2(50) ,
sal number(5)
);   

select * from emp03;

desc emp03;

--자료 입력
insert into emp03 (empno, ename) values (1, 'kim');
-- 사번이 중복됨
--ORA-00001: unique constraint (JAVA.SYS_C007125) violated
insert into emp03 (empno, ename) values (1, 'park');
-- null 입력이 가능함  
insert into emp03 (empno, ename) values (null, 'park');
insert into emp03 (empno, ename) values (null, 'hong');   

select * from emp03;
-- 데이터 사전 조회
select * from user_constraints where table_name='EMP03';
-- primary key
drop table emp05;
create table emp05 (
empno number(4) constraint emp05_empno_pk primary key,
ename varchar2(50)
);

create table 성적 (
학번 number(4),
과목코드 number(4),
학점 char(2),
primary key(학번,과목코드)
);
select * from 성적;

insert into emp05 values (1, 'kim');
--ORA-00001: unique constraint (JAVA.SYS_C007129) violated
--ORA-00001: unique constraint (JAVA.EMP05_EMPNO_PK) violated
insert into emp05 values (1, 'park'); -- 사번이 중복 입력됨
--ORA-01400: cannot insert NULL into ("JAVA"."EMP05"."EMPNO")
insert into emp05 values (null, 'hong'); -- 사번에 null이 입력됨 
select * from emp05;
--데이터 사전 확인
select * from user_constraints where table_name='EMP05';
-- p.386( Foreign key 제약조건 )
-- 참조무결성(integrity) : 잘못된 FK를 사용하는 경우  
-- Foreign Key : 다른 테이블의 Primary Key를 참조 
--ORA-02291: integrity constraint (JAVA.FK_DEPTNO) violated 
-- - parent key not found
insert into emp (empno, ename, deptno) values ( 5000, 'park', 50 ); 
select * from dept;

drop table emp05;
create table emp05 as select * from emp;
-- 부서 테이블에 존재하지 않는 50번 부서가 입력되는 문제 발생
insert into emp05 (empno, ename, deptno) values (500, 'kim', 50);
-- 잘못된 부서코드 입력으로 인해 테이블 조인 실패 
select ename, dname 
from emp05 e, dept d
where e.deptno = d.deptno and empno=500;
--테이블 삭제
drop table emp05;
-- 참조무결성 제약조건을 추가한 테이블 생성
-- references 테이블이름(컬럼이름) 
create table emp05 (
empno number(5),
ename varchar2(100),
deptno number(4) constraint emp05_deptno_fk references dept(deptno)
);
insert into emp05 (empno, ename, deptno) values (500, 'kim', 10);
--ORA-02291: integrity constraint (JAVA.SYS_C007133) violated 
-- - parent key not found
--ORA-02291: integrity constraint (JAVA.EMP05_DEPTNO_FK) violated - parent key not found
insert into emp05 (empno, ename, deptno) values (500, 'kim', 50);

select * from user_constraints where table_name='EMP05';

commit;

select  * from guestbook order by idx desc;
-- check 제약조건(p.395)
-- 입력값의 범위(domain)를 설정하는 것
drop table emp03;
create table emp03 (
empno number(4),
ename varchar2(50),
sal number(5) constraint emp03_sal_ck check(sal > 0),  -- 음수값이 입력될 수 없음
gender char(1) constraint emp03_gender_ck check(gender in ('M','F'))  -- M/F 만 입력 가능
);
insert into emp03 values (1, 'kim', 5000, 'M');
insert into emp03 values (2, 'park', 3000, 'F');
--ORA-02290: check constraint (JAVA.EMP03_GENDER_CK) violated
insert into emp03 values (3, 'hong', 3000, 'A');  -- 잘못된 값이 입력됨
--ORA-02290: check constraint (JAVA.EMP03_SAL_CK) violated
insert into emp03 values (4, 'choi', -2000, 'M');
select * from emp03;
-- 데이터사전 조회
select * from user_constraints where table_name='EMP03';
-- default 제약조건 : 기본값을 입력
drop table emp03;
create table emp03 (
empno number(4),
ename varchar(50),
sal number(5) default 0,
gender char(1) default 'M',
hiredate date default sysdate
);
insert into emp03 (empno, ename) values (1,'kim');
insert into emp03 (empno, ename, gender) values (2,'park','M');
insert into emp03 (empno, ename, gender) values (3,'hong','F');
select * from emp03;
-- null과의 연산결과는 항상 null
select * from emp03 where gender = null; 
select * from emp03 where gender is null; -- is, is not을 써야 함
-- 성별 통계
select gender, count(gender)
from emp03
group by gender
having gender is not null;

-- 이미 사용중인 테이블에 제약조건을 추가하는 방법
drop table emp03;
create table emp03 (
empno number(4),
ename varchar(50),
sal number(5),
gender char(1),
hiredate date
);
-- empno를 primary key로 설정
--ORA-02437: cannot validate (JAVA.SYS_C007140) - primary key violated
-- constraint 테이블_컬럼_제약조건코드  : 제약조건 이름 설정 
alter table emp03 add constraint emp03_empno_pk primary key(empno);
insert into emp03 (empno,ename) values (1,'kim');
--ORA-00001: unique constraint (JAVA.SYS_C007139) violated
--ORA-00001: unique constraint (JAVA.EMP03_EMPNO_PK) violated
insert into emp03 (empno,ename) values (1,'park');
-- 성별에 check 제약조건 추가  ( 'M', 'F' 만 입력 가능)
alter table emp03 
add constraint emp03_gender_ck check( gender in ('M','F'));
--ORA-02290: check constraint (JAVA.EMP03_GENDER_CK) violated
insert into emp03 (empno,ename,gender) values (5,'park','A');
-- not null 제약조건의 추가(p.404)
drop table emp03;
create table emp03 (
empno number(4),
ename varchar(50),
sal number(5),
gender char(1),
hiredate date
);
-- 잘못된 문법
-- alter table emp03 add not null(ename);
alter table emp03 modify ename not null;
--ORA-01400: cannot insert NULL into ("JAVA"."EMP03"."ENAME")
insert into emp03 (empno) values (1);
-- 제약조건을 수정하려면?  수정은 안되고 삭제 후 새로 만들어야 함
-- 제약조건 삭제
-- alter table 테이블이름 drop constraint 제약조건이름  제약조건종류;
drop table emp03;
create table emp03 (
empno number(4) primary key,
ename varchar(50) constraint emp03_ename_nn not null,
sal number(5),
gender char(1),
hiredate date
);
insert into emp03 (empno,ename) values (1,'kim');
--ORA-00001: unique constraint (JAVA.SYS_C007144) violated
insert into emp03 (empno,ename) values (1,'park');
-- primary key 제약조건 제거
alter table emp03 drop primary key;
-- 중복된 사번이 입력됨
insert into emp03 (empno,ename) values (1,'park');
select * from emp03;
--ORA-01400: cannot insert NULL into ("JAVA"."EMP03"."ENAME")
insert into emp03 (empno) values (5);
-- not null 제약조건 제거
alter table emp03 drop constraint emp03_ename_nn;
-- null값이 입력됨
insert into emp03 (empno) values (5);

-- 제약조건의 비활성화/활성화
--비활성화
--alter table 테이블이름 disable constraint 제약조건이름;
--활성화
--alter table 테이블이름 enable constraint 제약조건이름;

drop table emp03;
create table emp03 (
empno number(4) primary key,
ename varchar(50) ,
sal number(5),
gender char(1),
hiredate date
);
insert into emp03 (empno,ename) values (1,'kim');
--중복된 사번으로 인해 에러 발생
--ORA-00001: unique constraint (JAVA.SYS_C007147) violated
insert into emp03 (empno,ename) values (1,'lee');
-- pk 제약조건을 비활성화시킴
alter table emp03 disable primary key;
insert into emp03 (empno,ename) values (1,'hong');
insert into emp03 (empno,ename) values (1,'min');
select * from emp03;
-- PK를 다시 활성화시킴
--ORA-02437: cannot validate (JAVA.SYS_C007147) - primary key violated
-- 중복된 자료들을 미리 정리해야 함
delete from emp03 where ename <> 'kim';
alter table emp03 enable primary key;










