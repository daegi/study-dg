-- p.338
--���̺� ����
drop table dept01;
--���̺� ����
create table dept01 as select * from dept;

delete from dept01;
select * from dept01;
commit;
-- savepoint �׽�Ʈ�� ���� ���̺� ����
create table dep(
    id varchar2(10) primary key, 
    name varchar2(15) not null,
    location varchar2(50) 
);

insert into dep values('10', '������', '���� ������');
savepoint a;
insert into dep values('20', 'ȸ���', '�λ� ������');
savepoint b;
insert into dep values('30', '���ߺ�', '��õ ��籸');
rollback to a;
select * from dep;
commit;
select * from dep;
delete from dep where id=10;
-- p.369
select * from dept;
insert into dept values (null, null, 'SEOUL');
desc dept;
-- �������� Ȯ�� 
select * from user_constraints where table_name='DEPT';
-- p.370
--unique constraint (JAVA.PK_DEPT) violated  
-- primary key : ������ �� ( null���� ������� ���� )
-- unique : ������ �� ( null�� ��� )
insert into dept values (10, 'test', 'seoul');
-- P.374 NOT NULL ��������
drop table emp01;
-- �������� �̸��� ���� �����ϴ� ���
-- constraint ���̺��̸�_�÷��̸�_���������ڵ�
create table emp01 (
empno number(4) constraint emp01_empno_nn not null,
ename varchar2(10) constraint emp01_ename_nn not null,
job varchar2(9),
deptno number(2)
);
--ORA-01400: cannot insert NULL into ("JAVA"."EMP01"."EMPNO")
insert into emp01 values ( null, null, 'salesman', 30);
select * from emp01;
-- �������� Ȯ��
desc emp01;
-- ������ �������� �������� Ȯ��
-- CONSTRAINT_TYPE : C ( not null, check �������� )
select * from user_constraints where table_name='EMP01';


-- unique ��������(p.378)
-- Ư�� �÷��� �ڷᰡ �ߺ����� �ʵ��� �����ϱ� ���� ��������
-- primary key�� �ٸ� �� : null�� �����
-- primary key = unique + not null
-- emp03 ���̺� ����
drop table emp03;
-- emp03 ���̺� ����(������ ����)
create table emp03 as select * from emp where 1=0;
-- unique ���������� �����Ų ���̺�
create table emp03 (
empno number(4) constraint emp03_empno_uk unique ,
ename varchar2(50) ,
sal number(5)
);   

select * from emp03;

desc emp03;

--�ڷ� �Է�
insert into emp03 (empno, ename) values (1, 'kim');
-- ����� �ߺ���
--ORA-00001: unique constraint (JAVA.SYS_C007125) violated
insert into emp03 (empno, ename) values (1, 'park');
-- null �Է��� ������  
insert into emp03 (empno, ename) values (null, 'park');
insert into emp03 (empno, ename) values (null, 'hong');   

select * from emp03;
-- ������ ���� ��ȸ
select * from user_constraints where table_name='EMP03';
-- primary key
drop table emp05;
create table emp05 (
empno number(4) constraint emp05_empno_pk primary key,
ename varchar2(50)
);

create table ���� (
�й� number(4),
�����ڵ� number(4),
���� char(2),
primary key(�й�,�����ڵ�)
);
select * from ����;

insert into emp05 values (1, 'kim');
--ORA-00001: unique constraint (JAVA.SYS_C007129) violated
--ORA-00001: unique constraint (JAVA.EMP05_EMPNO_PK) violated
insert into emp05 values (1, 'park'); -- ����� �ߺ� �Էµ�
--ORA-01400: cannot insert NULL into ("JAVA"."EMP05"."EMPNO")
insert into emp05 values (null, 'hong'); -- ����� null�� �Էµ� 
select * from emp05;
--������ ���� Ȯ��
select * from user_constraints where table_name='EMP05';
-- p.386( Foreign key �������� )
-- �������Ἲ(integrity) : �߸��� FK�� ����ϴ� ���  
-- Foreign Key : �ٸ� ���̺��� Primary Key�� ���� 
--ORA-02291: integrity constraint (JAVA.FK_DEPTNO) violated 
-- - parent key not found
insert into emp (empno, ename, deptno) values ( 5000, 'park', 50 ); 
select * from dept;

drop table emp05;
create table emp05 as select * from emp;
-- �μ� ���̺� �������� �ʴ� 50�� �μ��� �ԷµǴ� ���� �߻�
insert into emp05 (empno, ename, deptno) values (500, 'kim', 50);
-- �߸��� �μ��ڵ� �Է����� ���� ���̺� ���� ���� 
select ename, dname 
from emp05 e, dept d
where e.deptno = d.deptno and empno=500;
--���̺� ����
drop table emp05;
-- �������Ἲ ���������� �߰��� ���̺� ����
-- references ���̺��̸�(�÷��̸�) 
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
-- check ��������(p.395)
-- �Է°��� ����(domain)�� �����ϴ� ��
drop table emp03;
create table emp03 (
empno number(4),
ename varchar2(50),
sal number(5) constraint emp03_sal_ck check(sal > 0),  -- �������� �Էµ� �� ����
gender char(1) constraint emp03_gender_ck check(gender in ('M','F'))  -- M/F �� �Է� ����
);
insert into emp03 values (1, 'kim', 5000, 'M');
insert into emp03 values (2, 'park', 3000, 'F');
--ORA-02290: check constraint (JAVA.EMP03_GENDER_CK) violated
insert into emp03 values (3, 'hong', 3000, 'A');  -- �߸��� ���� �Էµ�
--ORA-02290: check constraint (JAVA.EMP03_SAL_CK) violated
insert into emp03 values (4, 'choi', -2000, 'M');
select * from emp03;
-- �����ͻ��� ��ȸ
select * from user_constraints where table_name='EMP03';
-- default �������� : �⺻���� �Է�
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
-- null���� �������� �׻� null
select * from emp03 where gender = null; 
select * from emp03 where gender is null; -- is, is not�� ��� ��
-- ���� ���
select gender, count(gender)
from emp03
group by gender
having gender is not null;

-- �̹� ������� ���̺� ���������� �߰��ϴ� ���
drop table emp03;
create table emp03 (
empno number(4),
ename varchar(50),
sal number(5),
gender char(1),
hiredate date
);
-- empno�� primary key�� ����
--ORA-02437: cannot validate (JAVA.SYS_C007140) - primary key violated
-- constraint ���̺�_�÷�_���������ڵ�  : �������� �̸� ���� 
alter table emp03 add constraint emp03_empno_pk primary key(empno);
insert into emp03 (empno,ename) values (1,'kim');
--ORA-00001: unique constraint (JAVA.SYS_C007139) violated
--ORA-00001: unique constraint (JAVA.EMP03_EMPNO_PK) violated
insert into emp03 (empno,ename) values (1,'park');
-- ������ check �������� �߰�  ( 'M', 'F' �� �Է� ����)
alter table emp03 
add constraint emp03_gender_ck check( gender in ('M','F'));
--ORA-02290: check constraint (JAVA.EMP03_GENDER_CK) violated
insert into emp03 (empno,ename,gender) values (5,'park','A');
-- not null ���������� �߰�(p.404)
drop table emp03;
create table emp03 (
empno number(4),
ename varchar(50),
sal number(5),
gender char(1),
hiredate date
);
-- �߸��� ����
-- alter table emp03 add not null(ename);
alter table emp03 modify ename not null;
--ORA-01400: cannot insert NULL into ("JAVA"."EMP03"."ENAME")
insert into emp03 (empno) values (1);
-- ���������� �����Ϸ���?  ������ �ȵǰ� ���� �� ���� ������ ��
-- �������� ����
-- alter table ���̺��̸� drop constraint ���������̸�  ������������;
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
-- primary key �������� ����
alter table emp03 drop primary key;
-- �ߺ��� ����� �Էµ�
insert into emp03 (empno,ename) values (1,'park');
select * from emp03;
--ORA-01400: cannot insert NULL into ("JAVA"."EMP03"."ENAME")
insert into emp03 (empno) values (5);
-- not null �������� ����
alter table emp03 drop constraint emp03_ename_nn;
-- null���� �Էµ�
insert into emp03 (empno) values (5);

-- ���������� ��Ȱ��ȭ/Ȱ��ȭ
--��Ȱ��ȭ
--alter table ���̺��̸� disable constraint ���������̸�;
--Ȱ��ȭ
--alter table ���̺��̸� enable constraint ���������̸�;

drop table emp03;
create table emp03 (
empno number(4) primary key,
ename varchar(50) ,
sal number(5),
gender char(1),
hiredate date
);
insert into emp03 (empno,ename) values (1,'kim');
--�ߺ��� ������� ���� ���� �߻�
--ORA-00001: unique constraint (JAVA.SYS_C007147) violated
insert into emp03 (empno,ename) values (1,'lee');
-- pk ���������� ��Ȱ��ȭ��Ŵ
alter table emp03 disable primary key;
insert into emp03 (empno,ename) values (1,'hong');
insert into emp03 (empno,ename) values (1,'min');
select * from emp03;
-- PK�� �ٽ� Ȱ��ȭ��Ŵ
--ORA-02437: cannot validate (JAVA.SYS_C007147) - primary key violated
-- �ߺ��� �ڷ���� �̸� �����ؾ� ��
delete from emp03 where ename <> 'kim';
alter table emp03 enable primary key;










