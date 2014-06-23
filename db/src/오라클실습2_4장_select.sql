--�����ڷ�/�׽�Ʈ�� ������/test_data.sql ���� �ٿ�ε�
-- java �������� ����

--���� ����� �ȵǸ�
-- cmd ���� ����
-- @test_data.sql 
-- null : �ڷᰡ �Էµ��� ���� ������ ����
-- null���� �������� �׻� null 
-- p.58
select ename, sal, job, comm, sal*12  ����, sal*12 + comm �Ǽ��ɾ�
from emp;
-- nvl(A,B)  A�� null�̸� B, A�� null�� �ƴϸ� A
select ename, sal, job, comm, sal*12  ����
    , sal*12 + nvl(comm,0) �Ǽ��ɾ�
from emp;
--  A || B    A�� B�� �����Ŵ    
select ename || '�� �����ڴ� '|| 
    case 
        when mgr is null then '�����ϴ�.'
        when mgr is not null then mgr || '�Դϴ�'
    end  "mgr"
from emp;
-- ���ʽ��� ���� ���� ���
-- A is null  A�� null�̸� ,  A is not null   A�� null�� �ƴϸ�
select * from emp where comm is null;
select * from emp where comm = null;  -- null���� ���� ����� null
select * from emp where comm = 0; -- ���ʽ��� 0�� ����
-- �����ڰ� ���� ����
select * from emp where mgr is null;
select * from emp where mgr = null;  --�߸��� ���� 
-- F9 : ���� ���� ����
-- p.61 alias(��Ī)
-- �÷� or ���̺� as ��Ī   
-- �÷� or ���̺� ��Ī   ( as�� ���������� )
-- �÷� or ���̺� "��Ī"  
-- '���ڿ�'
select ename, sal*12 + nvl(comm,0) as ���� from emp;
select ename, sal*12 + nvl(comm,0) ���� from emp;
select ename, sal*12 + nvl(comm,0) "��  ��" from emp;
-- p. 66    distinct �ߺ��� ����, all �ߺ����� ��� ǥ�� 
-- �μ��ڵ� ���
select deptno from emp order by deptno; 
--�ߺ��� ����
select distinct deptno from emp order by deptno;
-- �ߺ����� ��� ����
select all deptno from emp order by deptno;

--p.96   ������(where)
--p.97   �޿��� 3000 �̻��� ����
select * from emp where sal >= 3000;
-- �μ��ڵ尡 10�� ����
select * from emp where deptno=10;
-- ����̸��� CLARK �� ����
select * from emp where ename = 'CLARK'; -- ���� ����ǥ�� ����
select * from emp where ename = 'clark'; -- ��ҹ��� ����
select * from emp where ename = CLARK; -- �÷����� ������
-- ��¥ ������ ��ȸ
select ename, hiredate from emp order by hiredate;
-- 1981�� 6�� 1�� ���Ŀ� �Ի��� ����
select ename, hiredate from emp 
where hiredate >= '1981/06/01';  --��¥���� ����ǥ�� ����
-- ��¥�� ����ǥ�� ������ ������ ���� �߻�
select ename, hiredate from emp  where hiredate >= 1981/06/01;
-- 2�� �̻��� ���� : and , or 
-- �μ��ڵ尡 10���̰� ������ MANAGER�� ����
select * from emp 
where deptno=10 and job='MANAGER';
-- �μ��ڵ尡 10�� �Ǵ� ������ MANAGER�� ����
select * from emp 
where deptno=10 or job='MANAGER';

insert into emp (empno,ename) values (1,'kim');
insert into emp (empno,ename) values (2,'KIM');
select * from emp;
-- insert, delete, update�� �� ��쿡�� commit �� �ؾ� ��
-- Ʈ����� ó�� ��ɾ� 
-- commit  ��������� Ȯ����
-- rollback  ��������� ��ҽ�Ŵ 

select * from emp where deptno = 10;
-- 10�� �μ��� �Ҽӵ��� ���� ����
select * from emp where deptno != 10;
select * from emp where deptno <> 10;
select * from emp where not deptno = 10;
-- �޿��� 2000~3000�� ����
select * from emp where sal >= 2000 and sal <= 3000;
-- �÷�  between A and B  : �÷����� A~B 
select * from emp where sal between 2000 and 3000;
-- Ŀ�̼��� 300 or 500 or 1400 ��  ����
select * from emp
where comm = 300 or comm = 500 or comm = 1400;
-- �÷� in ( ���� )  : ���տ� ���ԵǴ� ���
select * from emp where comm in (300,500,1400);
-- Ŀ�̼��� 300 , 500 , 1400 �� �ƴ�  ����
select * from emp
where comm <> 300 and comm <> 500 and comm <> 1400;
-- �÷� not in (����)   : ���տ� ���Ե��� �ʴ� ���
select * from emp where comm not in (300,500,1400);
-- ����� 7521, 7654, 7844�� ����
select * from emp 
where empno = 7521 or empno = 7654 or empno = 7844;

select * from emp where empno in (7521,7654,7844); 
-- �̸��� M���� �����ϴ� ����
select * from emp where ename like 'M%';
-- �̸��� M�� ���Ե� ����
select * from emp where ename like '%M%';
-- �̸��� �ι�° ���ڰ� A�� ����
select * from emp where ename like '_A%';
-- �̸��� M�� ���Ե��� ���� ����
select * from emp where ename not like '%M%';
-- �÷� like '%Ű����%'    Ű���尡 ���Ե� ���ڵ�
-- �÷� like ' Ű����%'      Ű����� �����ϴ� ���ڵ�
-- �÷� like ' _J%'      �ι�° ���ڰ� J�� ���ڵ� 
-- ���� 
-- order by �÷� asc : �������� (�⺻�ɼ�)
-- order by �÷� desc : ��������
-- ����̸������� ����
select * from emp order by ename;
select * from emp order by ename asc; -- asc ��������
select * from emp order by ename desc;  --��������
-- �Ի����ڼ�(�Ի����� ������ �̸���)
select * from emp order by hiredate, ename;
-- �ֱ� �Ի����ڼ�(�Ի����� ������ �̸� ��������)
select * from emp order by hiredate desc, ename;
-- ȸ�� ���̺�
create table member (
userid varchar2(50) not null,
passwd varchar2(50) not null,
name varchar2(50) not null,
primary key(userid)
);
-- create table ���̺��̸� (  �÷��̸� �ڷ���(������) �������� )
-- not null : null���� ������� ����(�ʼ��Է�)
-- primary key : ���̺� ������ �ߺ����� �ʴ� ������ ��(�ĺ���)
insert into member values ( 'kim', '1234', '�达');
insert into member values ( 'park', '1234', '������');
insert into member values ( 'admin', '1234', '������');
-- insert into ���̺� values ( ��1, ��2,,,, );
select * from member;
-- insert, delete, update �۾��� �ӽ����̺� �����
-- commit�� �ؾ� �������̺� ������ ��
commit;  
--�α��� ����
select name 
from member 
where userid='kim' and passwd='1234';
--�α��� ����
select name 
from member 
where userid='kim' and passwd='123';
--SQL Injection Attack(SQL ���� ����)
--id�� 
--kkk' or 1=1 --
--����� �ƹ� ���̳� �Է�
----�����ڷ� �α���
--���̵� : admin' --
--��� : �ƹ����̳� �Է�
--select name from member 
--where userid='kkk' or 1=1 --' and passwd='2222'

select name from member where userid='admin' --' and passwd='3333'

-- �ķν� ���α׷� �ٿ�ε�
-- http://www.parosproxy.org