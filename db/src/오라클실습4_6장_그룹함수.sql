--6�� �׷��Լ�
-- sum() �հ�, count() ����, avg() ���, max() �ִ밪, min() �ּҰ�
select count(*), sum(sal), avg(sal), max(sal), min(sal) from emp;
-- ���� ���̺��� �μ� ����
select count(*) from emp;  -- null �� ����
select count(deptno) from emp;  -- null �� ���� 
select count(distinct deptno) from emp;  -- distinct �ߺ��� ����

select count(*), sum(sal), avg(sal), max(sal), min(sal) 
from emp
where deptno=10;
-- �μ��� �޿����
-- select���� �÷��� group by ���� �÷��� ���ƾ� ��(�����Լ� ����)
select deptno, count(*), sum(sal), avg(sal), max(sal), min(sal) 
from emp
group by deptno   -- ���� ���� �÷�
order by deptno;
-- �����з��� ���� ��� 
select deptno, job,count(*), sum(sal), avg(sal), max(sal), min(sal) 
from emp
group by deptno,job   -- ���� ���� �÷�
order by deptno;
-- �μ��� ��� �޿��� 2000 �̻��� �μ��� ��ձ޿� ���
-- where : from ���� ���ڵ� �߿��� ����
select * from emp
where sal >= 2000;

select deptno, avg(sal)
from emp
group by deptno
having avg(sal) >= 2000  -- group by�� ������ �� �߿��� ����
order by deptno;
-- ���, �̸�, �μ��ڵ�, �μ��̸�
-- ���� ���̺� ���� �̸��� �÷��� ���� ��� :  ���̺��̸�.�÷��̸�
select empno, ename, e.deptno, dname
from emp e, dept d   -- ������ ��� ���̺�
where e.deptno=d.deptno;  -- ��������(�� ���̺��� ��������)

-- cross join
select empno, ename, e.deptno, dname
from emp e, dept d;
-- equi join(��������)
select empno, ename, e.deptno, dname
from emp e, dept d
where e.deptno=d.deptno; 
-- sales �μ� ������ ����Ϸ���?
select empno, ename, e.deptno, dname
from emp e, dept d
where e.deptno=d.deptno  -- ���� ���� 
    and e.deptno=30;  -- �Ϲ� ���� 
-- ����Ŭ�� ���� ���
-- ANSI JOIN
-- Oracle JOIN
-- A���̺� join B���̺� on A���̺�.�÷�=B���̺�.�÷�    
select empno, ename, e.deptno, dname
from emp e inner join dept d          -- ������ ��� ���̺�
    on  e.deptno=d.deptno      -- ���� ����
where e.deptno=30;
-- ���忡�� �ٹ��ϴ� ����� �̸��� �޿� ���
select ename, sal
from emp e, dept d
where e.deptno=d.deptno
    and loc='NEW YORK';
    
select ename, sal
from emp e join dept d      -- ��ǥ�� join����
    on e.deptno=d.deptno    -- where�� on ����
where loc='NEW YORK';       -- and�� where�� 

-- ������ MANAGER�� ����� �̸�, �μ��� ���
select ename, dname
from emp e, dept d
where e.deptno=d.deptno
    and job='MANAGER';    
    

-- �μ���, ��ձ޿�
select dname, avg(sal)
from emp e, dept d
where e.deptno=d.deptno
group by dname;
-- �ٹ���, �ٹ�������, �޿����
select loc �ٹ���, count(loc) ������, round( avg(sal), 1 ) �޿����
from emp e, dept d
where e.deptno=d.deptno
group by loc
order by �޿���� desc;
-- p.215 Non-Equi join(�񵿵�����)
select * from salgrade;
select * from emp where empno=7369;
-- �̸�, �޿���, ȣ��
select ename, sal, grade
from emp e, salgrade s
where sal between losal and hisal;  -- Non-Equi Join(�񵿵�����)
-- ����̸�, �μ��̸�, ȣ��
select ename, dname, grade
from emp e, dept d, salgrade s
where e.deptno=d.deptno                     -- Equi Join
    and e.sal between s.losal and s.hisal;    -- Non-Equi Join
select * from salgrade;    
select ename, dname--, grade
from emp e join dept d
            on e.deptno=d.deptno
      join salgrade s                     
            on e.sal between s.losal and s.hisal; 
-- ������(sequence) p.462 ����
-- �Ϸù�ȣ�� ������ִ� ��ü
-- create sequence �������̸� 
create sequence memo_seq
increment by 1      -- ������
start with 1;           -- ���۰�
-- �������̸�.nextval  ���ο� �Ϸù�ȣ �߱�
select memo_seq.nextval from dual;

insert into memo (idx, writer, memo ) values 
( memo_seq.nextval, 'kim', '�޸𿬽�' );

select * from memo order by idx desc;
delete from memo where idx=29;
commit;    
    
-- <�±�>          





