-- 시퀀스(p.463)
-- 시퀀스 삭제
drop sequence dept_deptno_seq;
-- 10부터 시작하여 10씩 증가됨
-- create sequence 시퀀스이름
create sequence dept_deptno_seq
increment by 10
start with 10;
-- 데이터 사전 조회
select * from user_sequences;
-- 시퀀스이름.currval : 현재 번호 계산
-- 시퀀스이름.nextval  : 다음 번호 계산
select dept_deptno_seq.currval from dual;
select dept_deptno_seq.nextval from dual;
-- 테스트 테이블 생성
create table dept03 as select * from dept where 0=1;
-- 부서코드를 시퀀스를 사용하여 계산  
insert into dept03 values ( dept_deptno_seq.nextval, '관리팀', '서울'); 
insert into dept03 values ( dept_deptno_seq.nextval, '총무팀', '과천'); 
insert into dept03 values ( dept_deptno_seq.nextval, '전산팀', '대전'); 
insert into dept03 values ( dept_deptno_seq.nextval, '홍보팀', '부산'); 
select * from dept03;

-- 서브쿼리를 이용하여 일련번호 계산
drop table dept02;
create table dept02 as select * from dept where 0=1;

select max(deptno)+10 from dept02;
-- nvl ( A, B )   A가 null이면 B
select nvl( max(deptno)+10, 10 ) from dept02;

insert into dept02 values 
( (select nvl( max(deptno)+10, 10 ) from dept02), '전산팀', '수원'); 
insert into dept02 values 
( (select nvl( max(deptno)+10, 10 ) from dept02), '경리팀', '구로'); 
insert into dept02 values 
( (select nvl( max(deptno)+10, 10 ) from dept02), '총무팀', '강남'); 
insert into dept02 values 
( (select nvl( max(deptno)+10, 10 ) from dept02), '홍보팀', '일산'); 
select * from dept02;
-- 사원번호에 일련번호 사용
create sequence emp_seq
start with 1
increment by 1
maxvalue 1000;

-- 시퀀스의 최대값을 수정
alter sequence emp_seq
maxvalue 10000;

--데이터 사전 확인
select * from user_sequences;

drop table emp03;
create table emp03 as select * from emp where 0=1;

insert into emp03 (empno, ename, hiredate) values
( emp_seq.nextval, 'kim', sysdate);
insert into emp03 (empno, ename, hiredate) values
( emp_seq.nextval, 'park', sysdate);
insert into emp03 (empno, ename, hiredate) values
( emp_seq.nextval, 'hong', sysdate);
select * from emp03;



-- 사원번호 4번부터 1500번까지 입력 
--ORA-08004: sequence EMP_SEQ.NEXTVAL exceeds MAXVALUE and cannot be instantiated
--ORA-06512: at line 5
declare  -- 선언부 
    i number := 4;
begin
    while i <= 1500 loop
        insert into emp03 (empno, ename, hiredate) values
        ( emp_seq.nextval, '사원'||i, sysdate);
        i := i + 1;
    end loop;
end;
/

select * from emp03 order by empno;    

-- 인덱스 정보 조회(p.479)
select * from user_indexes;
desc emp;

drop table emp03;
create table emp03 as select * from emp;
select * from emp03;
-- emp03 테이블에 PK 추가 
alter table emp03 add primary key(empno);
-- PK 제거
alter table emp03 drop primary key;
-- 제약조건 이름을 설정
alter table emp03 add constraint emp03_empno_pk primary key(empno);

select * from user_indexes where table_name='EMP03';

select * from emp03 where empno=7369;
-- 인덱스를 사용할 경우 : index unique scan
-- 인덱스를 사용하지 않을 경우 : table full access
select rowid, empno from emp03;

select * from emp03 where ename='ALLEN';
--이름 컬럼에 인덱스 추가
-- create index 인덱스이름 on 테이블이름(컬럼이름);
create index emp03_ename_idx on emp03(ename);
-- 인덱스 삭제
-- drop index 인덱스이름;
drop index  emp03_ename_idx;
select * from user_indexes where table_name='EMP03';
-- index 사용 : cost 2, bytes : 87
select * from emp03 where ename='ALLEN'; 
drop table emp3;
create table emp3 (
no number,
name varchar2(10),
sal number
);

declare 
  i int := 1;
  name  varchar(20) := 'kim';
  sal int := 0;
begin
  while i < 1000000 loop
    if i mod 2 = 0 then
      name := 'kim' || to_char(i);
      sal := 300;
    elsif i mod 3  = 0 then
      name := 'park' ||  to_char(i);
      sal := 400;
    elsif i mod 5  = 0 then
      name := 'hong' || to_char(i);
      sal := 500;
    else
      name := 'shin' || to_char(i);
      sal := 250;
    end if;
    insert into emp3 values (i,name,sal);
    i := i + 1;
  end loop;
end;
/

select * from emp3 where name = 'shin691';
--이름에 인덱스 추가
create index emp3_name_idx on emp3(name);
select * from emp3 where name = 'shin691';
alter table emp3 add constraint emp3_no_pk primary key(no);
alter table emp3 drop primary key; 
select * from user_indexes where table_name='EMP3';
select * from emp3 where no=999;

select * from emp3 where name like 'park1111%' and sal > 300;
-- or 연산자의 경우 인덱스를 사용하지 않음
select * from emp3 where name like 'park1111%' or sal > 300;
