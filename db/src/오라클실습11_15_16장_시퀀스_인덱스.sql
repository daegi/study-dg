-- ������(p.463)
-- ������ ����
drop sequence dept_deptno_seq;
-- 10���� �����Ͽ� 10�� ������
-- create sequence �������̸�
create sequence dept_deptno_seq
increment by 10
start with 10;
-- ������ ���� ��ȸ
select * from user_sequences;
-- �������̸�.currval : ���� ��ȣ ���
-- �������̸�.nextval  : ���� ��ȣ ���
select dept_deptno_seq.currval from dual;
select dept_deptno_seq.nextval from dual;
-- �׽�Ʈ ���̺� ����
create table dept03 as select * from dept where 0=1;
-- �μ��ڵ带 �������� ����Ͽ� ���  
insert into dept03 values ( dept_deptno_seq.nextval, '������', '����'); 
insert into dept03 values ( dept_deptno_seq.nextval, '�ѹ���', '��õ'); 
insert into dept03 values ( dept_deptno_seq.nextval, '������', '����'); 
insert into dept03 values ( dept_deptno_seq.nextval, 'ȫ����', '�λ�'); 
select * from dept03;

-- ���������� �̿��Ͽ� �Ϸù�ȣ ���
drop table dept02;
create table dept02 as select * from dept where 0=1;

select max(deptno)+10 from dept02;
-- nvl ( A, B )   A�� null�̸� B
select nvl( max(deptno)+10, 10 ) from dept02;

insert into dept02 values 
( (select nvl( max(deptno)+10, 10 ) from dept02), '������', '����'); 
insert into dept02 values 
( (select nvl( max(deptno)+10, 10 ) from dept02), '�渮��', '����'); 
insert into dept02 values 
( (select nvl( max(deptno)+10, 10 ) from dept02), '�ѹ���', '����'); 
insert into dept02 values 
( (select nvl( max(deptno)+10, 10 ) from dept02), 'ȫ����', '�ϻ�'); 
select * from dept02;
-- �����ȣ�� �Ϸù�ȣ ���
create sequence emp_seq
start with 1
increment by 1
maxvalue 1000;

-- �������� �ִ밪�� ����
alter sequence emp_seq
maxvalue 10000;

--������ ���� Ȯ��
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



-- �����ȣ 4������ 1500������ �Է� 
--ORA-08004: sequence EMP_SEQ.NEXTVAL exceeds MAXVALUE and cannot be instantiated
--ORA-06512: at line 5
declare  -- ����� 
    i number := 4;
begin
    while i <= 1500 loop
        insert into emp03 (empno, ename, hiredate) values
        ( emp_seq.nextval, '���'||i, sysdate);
        i := i + 1;
    end loop;
end;
/

select * from emp03 order by empno;    

-- �ε��� ���� ��ȸ(p.479)
select * from user_indexes;
desc emp;

drop table emp03;
create table emp03 as select * from emp;
select * from emp03;
-- emp03 ���̺� PK �߰� 
alter table emp03 add primary key(empno);
-- PK ����
alter table emp03 drop primary key;
-- �������� �̸��� ����
alter table emp03 add constraint emp03_empno_pk primary key(empno);

select * from user_indexes where table_name='EMP03';

select * from emp03 where empno=7369;
-- �ε����� ����� ��� : index unique scan
-- �ε����� ������� ���� ��� : table full access
select rowid, empno from emp03;

select * from emp03 where ename='ALLEN';
--�̸� �÷��� �ε��� �߰�
-- create index �ε����̸� on ���̺��̸�(�÷��̸�);
create index emp03_ename_idx on emp03(ename);
-- �ε��� ����
-- drop index �ε����̸�;
drop index  emp03_ename_idx;
select * from user_indexes where table_name='EMP03';
-- index ��� : cost 2, bytes : 87
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
--�̸��� �ε��� �߰�
create index emp3_name_idx on emp3(name);
select * from emp3 where name = 'shin691';
alter table emp3 add constraint emp3_no_pk primary key(no);
alter table emp3 drop primary key; 
select * from user_indexes where table_name='EMP3';
select * from emp3 where no=999;

select * from emp3 where name like 'park1111%' and sal > 300;
-- or �������� ��� �ε����� ������� ����
select * from emp3 where name like 'park1111%' or sal > 300;
