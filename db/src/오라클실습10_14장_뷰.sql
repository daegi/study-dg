--view
-- create view ���̸� as subquery; 
--ORA-00955: name is already used by an existing object
create or replace view emp_view
as
    select * from emp
    where deptno=30;
-- �並 ���̺�ó�� ����� �� ���� 
select * from emp_view;
select * from (select "EMPNO","ENAME","JOB","MGR","HIREDATE","SAL","COMM","DEPTNO" from emp
    where deptno=30);
-- �����ͻ��� ��ȸ 
select * from tab where tname='EMP_VIEW';  
select * from user_views;  
-- �Խ��� ������ ������
select idx, name, subject, hit, post_date, cnt
from ( select A.*, rownum as rn 
         from (
            select idx, name, subject, hit, post_date
                , (select count(*) from board_comment 
                    where board_idx=b.idx ) cnt
            from board b
            order by idx desc ) A ) 
where rn between 51 and 60
order by idx desc;
-- �Խ��� ������ �����⸦ ���� �� ����
create or replace view board_view
as
select idx, name, subject, hit, post_date, cnt, rn
from ( select A.*, rownum as rn 
         from (
            select idx, name, subject, hit, post_date
                , (select count(*) from board_comment 
                    where board_idx=b.idx ) cnt
            from board b
            order by idx desc ) A ) ;
-- cost 826, bytes : 16,052,120            
select * from board_view
where rn between 51 and 60;             

-- �信 ���ڵ� �߰��ϱ�
select * from emp_view;

insert into emp_view (empno, ename,deptno) values (1111,'kim',30);
select * from emp_view;
insert into emp_view (empno, ename,deptno) values (1112,'kim',20);
select * from emp_view;
delete from emp_view where empno=1111;
select * from emp_view;

-- �� ����
-- drop view ���̸�;
drop view emp_view;
-- ������ ���� Ȯ��
select * from user_views;

-- �����ȣ, ����̸�, �μ��ڵ�, �μ��̸�
-- ���̸� : emp_dept_view
create or replace view emp_dept_view 
as
select empno, ename, e.deptno, dname
from emp e, dept d
where e.deptno=d.deptno;

select * from emp_dept_view;

-- �μ��� ������, ��ձ޿�, �ְ�޿�, �����޿�
-- ���̸� : emp_sal_view
--ORA-00998: must name this expression with a column alias

create or replace view emp_sal_view
as
select 
    dname, count(*) �����, avg(sal) ��ձ޿�
    , max(sal) �ְ�޿�, min(sal) �����޿�
from emp e, dept d
where e.deptno=d.deptno
group by dname
union
select
    '��ü',count(*) �����, avg(sal) ��ձ޿�
    , max(sal) �ְ�޿�, min(sal) �����޿�
from emp e, dept d
where e.deptno=d.deptno;
    
-- �÷��� �ƴ� ��쿡�� �ݵ�� �˸��ƽ��� �ʿ��� 
select * from emp_sal_view;
select * from (select 
    dname, count(*) , avg(sal) , max(sal) , min(sal) 
from emp e, dept d
where e.deptno=d.deptno
group by dname);

-- A union B : A�� B�� ������
-- A minus B : A-B (������)
drop table emp1;
create table emp1 as select * from emp where deptno=10;
drop table emp2;
create table emp2 as select * from emp where ename like 'M%';
select * from emp1;
select * from emp2;
-- A union B : A+B(������), �ߺ� ���ڵ�� ����
select * from emp1 union select * from emp2;
-- A union all B : A+B(������), �ߺ� ���ڵ� ����
select * from emp1 union all select * from emp2;
-- A minus B : A-B(������)
select * from emp1 minus select * from emp2;

desc emp;