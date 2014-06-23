-- p.218 self join
select empno, ename, mgr from emp;
-- smith�� �Ŵ��� �̸���?
select * from emp where empno=7902;
-- self join
-- �ߺ��Ǵ� �̸��� �÷��� ���� ��� : ���̺��̸�.�÷��̸�
select a.empno, a.ename, a.mgr, b.ename �Ŵ����̸�
from emp a, emp b
where a.mgr = b.empno; -- join ����
-- �Ŵ����� �̸��� KING�� ������� �̸��� ���� ���
select a.ename, a.job
from emp a, emp b
where a.mgr = b.empno -- join ����
    and b.ename = 'KING';
-- inner join(��������)    
-- p.222 outer join(�ܺ�����) 
select * from emp;
select * from dept;
select distinct deptno from emp; 
-- �μ��� �ٹ�������, �޿��հ�, �޿����
-- �����Ͱ� ���� ���̺� (+)
select dname, count(sal), sum(sal), avg(sal)
from emp e, dept d
where e.deptno(+)=d.deptno
group by dname;
-- ansi inner join
select dname, count(sal), sum(sal), avg(sal)
from emp e inner join dept d
    on e.deptno=d.deptno
group by dname;
-- ansi outer join
-- A���̺� left outer join B���̺�
-- A���̺� right outer join B���̺�
-- A���̺� full outer join B���̺�
select dname, count(sal), sum(sal), avg(sal)
from dept d left outer join emp e
    on e.deptno=d.deptno
group by dname;
-- �Ŵ����� ���� KING�� ������
-- Ctrl + E ( �����ȹ Ȯ�� )
-- �Ľ� -> �����ȹ(Optimizer) 
select a.ename, a.mgr, b.ename �Ŵ���
from emp a, emp b
where a.mgr = b.empno;
-- outer join
select a.empno,a.ename, a.mgr, b.ename �Ŵ���
from emp a, emp b
where a.mgr = b.empno(+);
-- ansi inner join    
select a.empno,a.ename, a.mgr, b.ename �Ŵ���
from emp a inner join emp b
    on a.mgr = b.empno;
-- ansi outer join
select a.empno,a.ename, a.mgr, b.ename �Ŵ���
from emp a left outer join emp b
    on a.mgr = b.empno;
insert into emp (empno, ename,sal) values (7000, '�����', 4000);
select * from emp;
-- ���, �̸�, �μ��̸�, �޿���
-- �μ��ڵ尡 ���� '�����'�� ������
select empno, ename, dname, sal
from emp e, dept d
where e.deptno=d.deptno(+);  -- ¦�� ���� ���̺� (+)

select empno, ename, dname, sal
from emp e left outer join dept d  -- �����Ͱ� �ִ� ���̺��� ���� 
    on e.deptno=d.deptno;
