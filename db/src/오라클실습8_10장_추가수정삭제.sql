-- ���ο� �� �߰�(p.290)
-- ��� �÷��� ���� �Է�
-- insert into ���̺� values (��1, ��2,,,,);
-- ������ �÷��� ���� �Է�
-- insert into ���̺� (�÷�1, �÷�2, �÷�3,,,,) values (��1, ��2, ��3,,,);
drop table dept01;
create table dept01 as select * from dept where 0=1;

select * from dept01;
-- ���� ������ - ����ǥ�� ���� ����
-- ���� ������ - ����ǥ�� ����
insert into dept01 (deptno, dname, loc) values 
( 10, 'ACCOUNTING', 'NEW YORK');
-- ���� ������ ���(����)
insert into dept01 (deptno, dname, loc) values ( 20, 'SALES');
-- ���� ���� ���(����)
insert into dept01 (deptno, dname, loc) values
 ( 20, 'SALES', '�λ�', 20);
-- �÷� �̸��� �߸��� ���(����)
insert into dept01 (num, dname, loc) values
 ( 20, 'SALES', '�λ�'); 
-- �÷� �̸��� ����(��� �÷��� ������� �Է�)
insert into dept01 values ( 20, 'SALES', '�λ�');
-- null ���� �Է� ���(p.298)  
-- �Ͻ������� null���� ���Ե�
insert into dept01 (deptno, dname) values (30, 'SALES');
-- ��������� null�� ����
insert into dept01 values ( 40, 'OPERATIONS', null );
select  * from dept01;
desc dept01;
-- ������ �Է�(p.303)
-- insert into ���̺� select��ɾ�;
--���̺� ����
create table emp_hir 
as select empno, ename, hiredate  from emp where 0=1;
-- ������ �Է�
insert into emp_hir select empno, ename, hiredate from emp;

select * from emp_hir;
-- ���ο� ���̺��� ���� �ڷ� ����
create table emp02 as select * from emp;
-- ������ �����ϴ� ���̺� �ڷ� ����
-- insert into �����̺� select * from ���̺�
-- table or view does not exist
insert into emp02 select * from emp;
-- ����Ŭ������ ���� �߻�
select * into emp03 from emp;

-- update (p.311)
--update ���̺� set �÷�1=��1, �÷�2=��2 where ����
create table emp01 as select * from emp;

select * from emp01;
-- �������� ������ ��� ���ڵ��� ���� �����
update emp01 set deptno=30;
-- ��ü ������ �޿��� 20% �λ�
update emp01 set sal = sal * 1.2;
-- ��ü ������ �Ի����ڸ� ���ó�¥�� ����
update emp01 set hiredate = sysdate;

rollback;
select * from emp01; 

-- �μ��ڵ尡 10���� ����� �μ��ڵ带 30���� ����
update emp01 set deptno=30 where deptno=10;
-- �޿��� 3000 �̻��� ������� �޿��� 10% �λ�
update emp01 set sal = sal * 1.1 where sal >= 3000;
select * from emp01;
-- SMITH ����� �μ��� 30����, ������ MANAGER�� ����
update emp01 set deptno=30, job='MANAGER' 
where ename='SMITH';
--ALLEN�� �Ի����ڸ� ���ó�¥��, �޿��� 3000���� Ŀ�̼��� 500���� ����
update emp01 set hiredate=sysdate, sal=3000, comm=500
where ename= 'ALLEN';
-- ����(p.323)
-- delete from ���̺� where ����   ( from ���� ���� )
select * from dept01;
-- �������� ������ ��� ���ڵ尡 ������(����)
delete from dept01;
select * from dept02;
--30�� �μ� ����
delete dept02 where deptno=30;

select * from board where idx=100000;

update board
set name='park', subject='���� ����', content='���� ����'
where idx=100000;

delete from board where idx=100000;

--���� ���̺�
create table guestbook (
idx number(5) not null,
name varchar2(50) not null,
email varchar2(50) ,
content varchar2(2000) not null,
post_date date default sysdate,
primary key(idx)
);
-- �׽�Ʈ �ڷ� �Է�
insert into guestbook (idx,name,email,content) values
(1, 'kim', 'kim@test.com', 'ù��° ����');

select * from guestbook;
-- ���������� ����Ͽ� �Ϸù�ȣ ���
-- nvl( A, B ) A�� null�� �� B
insert into guestbook (idx,name,email,content) values
( (select nvl(max(idx)+1,1) from guestbook) 
    , 'park', 'park@test.com', '�ι�° ����'); 

commit;


commit;



 
    





select * from dept01; 

