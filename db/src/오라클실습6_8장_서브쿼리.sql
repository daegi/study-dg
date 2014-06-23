-- ��������(sub query)
select empno,ename
, ( select ename from emp where e.mgr = empno) �Ŵ���
from emp e;

-- FORD�� ���� �μ����� �ٹ��ϴ� ����̸�, �μ��ڵ� ���
select * from emp where ename='FORD';  -- 20�� �μ�

select ename, deptno 
from emp
where deptno =  (select deptno from emp where ename='FORD');
-- ������ ���� ���� �޴� ���
select min(sal) from emp;
select * from emp where sal=800;
-- ���������� �ݵ�� ��ȣ�� ����� ��
select * from emp where sal=(select min(sal) from emp);
-- ��� �޿� �̻��� �޴� ������
select avg(sal) from emp;
select * from emp where sal >= 2225;
select * from emp where sal >= (select avg(sal) from emp);
-- 30�� �μ��� �ٹ��ϴ� ������� ��ձ޿����� �޿��� ���� ������
-- �����ȹ Ȯ�� : Ctrl+E 
select avg(sal) from emp where deptno=30;
select * from emp where sal > 1566;
select * from emp 
where sal > (select avg(sal) from emp where deptno=30);
-- NEW YORK ���� �ٹ��ϴ� ����̸�, �μ���ȣ
select deptno from dept where loc='NEW YORK';
select * from emp where deptno=10;
select * from emp 
where deptno=(select deptno from dept where loc='NEW YORK'); 

select ename, e.deptno, loc
from emp e, dept d
where e.deptno = d.deptno
    and loc='NEW YORK';
-- SALES �μ����� �ٹ��ϴ� ����̸�, �޿�
select deptno from dept where dname='SALES';
select ename,sal from emp where deptno=30;
select ename,sal from emp 
where deptno=(select deptno from dept where dname='SALES');

select ename,sal
from emp e, dept d
where e.deptno=d.deptno and dname='SALES';

-- 2�� �Խù��� �� ����
select * from memo where idx=2;
rollback;
--update ���̺� set �÷�=�� where �÷�=��
update memo set writer='�����', memo='�� ������ ���ô�' 
where idx=2;
delete from memo where idx=2;
--p.244 ������ ���� ����
select distinct deptno from emp where sal >= 3000;
-- ���� �߻� ����
select ename, sal, deptno from emp
where deptno = (select distinct deptno from emp where sal >= 3000);
-- ���������� ����� 2�� �̻��� ���
select ename, sal, deptno from emp
where deptno in (select distinct deptno from emp where sal >= 3000);

select ename, sal, deptno from emp where deptno in (10, 20, 30, 40);

select ename, sal, deptno from emp 
where deptno = 10 or deptno = 20 or deptno = 30 or deptno = 40;
-- where ������ ����Ǵ� ��������
-- where �÷� = (������ �������� )
-- where �÷� in (������ ��������)
-- 30�� �μ��� ���� ������� �ִ� ���޺��� �޿��� ���� ������
-- 1. 30�� �μ��� ���� ������� �ִ� ����
select max(sal) from emp where deptno=30;

select * from emp where sal > 2850;

select * from emp 
where sal > (select max(sal) from emp where deptno=30);
-- ���� �߻�
select * from emp 
where sal > (select sal from emp where deptno=30);
-- �÷� in( ���� )  ������ ��� ��� �߿��� 1�� �̻� ����
-- �÷� > all( ���� )   ������ ��� ����� ���� �����ؾ� ��
-- �÷� > any( ���� ) ������ ��� ��� �߿��� �ּ� 1�� ����
select * from emp 
where sal > all(select sal from emp where deptno=30); -- �ִ밪

select * from emp 
where sal > any(select sal from emp where deptno=30); -- �ּҰ�
-- ���������� �������� ��������
-- ���������� �������� ��������

-- ����̸�, �μ��ڵ�, �μ��� 
select ename, deptno, (select dname from dept where deptno=e.deptno)
from emp e;

select ename, e.deptno, dname
from emp e, dept d
where e.deptno=d.deptno(+);

select d.deptno, dname, count(empno)
from dept d, emp e
where d.deptno=e.deptno(+)
group by d.deptno, dname
order by deptno;
-- scalar subquery(��Į�� ��������) - select���� �÷� 1��
select deptno, dname
, (select count(empno) from emp where deptno=d.deptno) ������
from dept d;
-- from���� ��ġ�� ��������( �ζ��� �� , inline view )
select distinct job from emp;
-- ��å�� CLERK�� �������� �̸�, ��å, �μ��� ���
select ename, job, dname
from emp e, dept d
where d.deptno=e.deptno and job='CLERK'; 
-- inline view
select ename, job, dname
from (select ename, job, deptno from emp where job='CLERK') e, dept d
where d.deptno=e.deptno; 


-- ������ ���� �μ��� ��ձ޿����� �޿��� ���� ������
select * from emp;
select avg(sal) from emp where deptno=20;

select 
 ename, sal,  (select avg(sal) from emp where deptno=e.deptno) ��ձ޿�
from emp e
where sal < (select avg(sal) from emp where deptno=e.deptno) 
order by ��ձ޿� desc;








    

