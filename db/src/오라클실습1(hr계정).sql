--����Ŭ ����(cmd)
-- ������ �������� ����
sqlplus / as sysdba
-- ���̺� �����̽� ����
create tablespace java
datafile 'd:/java/java.dbf' size 50M
autoextend on
next 1M
maxsize 200M;
-- ����� ���� ����
create user java identified by java1234
default tablespace java;
-- ������ �ο�
-- grant �ο��� ���ѵ� to ���̵�;
grant connect, resource, dba to java;
-- connect : ���� ����
-- resource : ���ҽ� ��� ����
-- dba : DB������ ����
-- revoke ȸ���� ���ѵ� to ���̵�;

-- �ܺ� ���� ���� ��� 
sqlplus ���̵�/���@IP�ּ�
sqlplus   java/java1234@211.63.89.200

-- create : ����
-- alter : ����
-- drop : ����

-- hr ������ Ȱ��ȭ��Ŵ
alter user hr identified by hr account unlock;
-- ������ : ���콺 �巡��
-- hr ������ ���̺� ��� Ȯ��
select * from tab;
-- desc   ���̺��̸�;    ���̺��� ���� Ȯ�� 
desc departments;
-- varchar2 : �������� ���ڿ�         
--   varchar2(50)
-- char : �������� ���ڿ�
--   char(50)

select * from employees
order by first_name desc;  
--���, �̸�, �޿�
select employee_id, first_name, salary
from employees
order by salary;

-- asc : ��������, desc : ��������
--�μ� ���
select * from departments;
-- ���̺� ����
-- �÷��̸� or ���̺��̸�  ��Ī(alias)
-- ���, �̸�, �μ��̸� 
-- ���̺��̸�.�÷��̸�
select employee_id, first_name, department_name, e.department_id
from employees e, departments d   
where e.department_id = d.department_id;

-- apache tomcat(����ġ ��Ĺ) �ٿ�ε�

--http://tomcat.apache.org
-- �ڹ� ����
--Java SE ( Standard Edition)
--Java EE ( Enterprise Edition)
--Java ME ( Micro Edition )

-- ojdbc6.jar => WebContent/WEB-INF/lib �� ����
-- emp_list.jsp => WebContent �� ����
-- emp_list.jsp�� �����Ŵ













