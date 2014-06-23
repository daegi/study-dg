--p.134  �������̺� dual
-- sysdate   �ý����� ���� ��¥/�ð�
select sysdate from dual;
select sysdate from member;
select sysdate;  -- from���� �����Ƿ� ���� �߻�
desc dual;
select * from dual;
-- �ݿø�, ����, �ø� �Լ�
-- round �ݿø�, floor ����, ceil �ø�
select 10.5 , round(10.5), floor(10.5), ceil(10.1) from dual;
-- �빮�ڷ� ��ȯ : upper(), �ҹ��ڷ� ��ȯ lower()
select 'Welcome', upper('Welcome'), lower('Welcome') from dual;
-- �ܾ��� ù���ڸ� �빮�ڷ� ��ȯ : initcap()
select 'Welcome to oracle', initcap('Welcome to oracle') from dual;
-- ���ڿ� ���� substr( '���ڿ�', start, length )
select substr('Welcome to oracle', 4,3) from dual;
-- 801231-1234567  ���� ����, ���� ���
select 
substr('801231-1234567',1,2) ����
, 2014 - ( substr('801231-1234567',1,2) + 1900) ����
from dual;
-- 82�⵵�� �Ի��� ����
select * from emp;
-- �÷� between A and B : �÷��� ���� A~B
select * from emp where hiredate between '1982-01-01' and '1982-12-31';
select * from emp where substr(hiredate,1,2) = '14';
insert into emp (empno, ename, hiredate) values (4, 'choi', '1914-08-01');
insert into emp (empno, ename, hiredate) values (5, 'park', sysdate);
select * from emp where substr(hiredate,1,2) = '14';
-- to_char( ��¥, ������� ) ��¥�� ���ڿ��� ��ȯ
-- ��������� p.168 ����
select * from emp where to_char(hiredate,'yyyy') = '2014'; --4�ڸ� ����
select * from emp where to_char(hiredate,'yyyy') = '1914';
select * from emp where to_char(hiredate,'yy') = '14'; -- 2�ڸ� ����
select  * from emp;
-- �̸��� 'N'���� ������ ���
-- -1 �ڿ��� ù��° ���� 
select * from emp where substr(ename,-1,1) = 'N'; 
-- p.154  LPAD, RPAD �¿��� ������ ä��� �Լ�
select lpad( 'Oracle', 20, '$') from dual;
select rpad( 'Oracle', 20, '#') from dual;
-- LTRIM, RTRIM �¿��� ���� ����
select ltrim('      Oracle'), rtrim( 'Oracle     ') from dual;
-- length(���ڿ�) : ���ڿ��� ����
select 
    length('   Oracle'), length(ltrim('    Oracle')), length(rtrim( 'Oracle    ')) 
from dual;
-- p.158 ��¥ ���� 
select sysdate , sysdate + 11, sysdate - 10 from dual;
-- p.162   months_between( ��¥1, ��¥2 )  �� ��¥���� ������
-- �Ի����� ��� �Ǿ����� ���( �ݿø� )
-- round( ����, �Ҽ������ڸ��� ) 
select ename, hiredate
, round(months_between( sysdate, hiredate ), 1) from emp;
-- �ٹ��ϼ�(�ݿø�), �ٹ�����(�ݿø�)
select 
ename, round(sysdate-hiredate,1) �ٹ��ϼ�
, round((sysdate-hiredate)/365,1) �ٹ�����
from emp;
-- p.168 to_char( ��¥ or ����, ������� )    ���ڿ��� ��ȯ
-- to_date( ���ڿ� )  : ��¥�� ��ȯ
-- to_number ( ���ڿ� ) : ���ڷ� ��ȯ
-- day : ����, hh24 24�ð���, hh 12�ð��� 
select sysdate, to_char(sysdate, 'yyyy/mm/dd day hh24:mi:ss') ��¥ 
from dual;
-- ����̸�, �Ի����� ���( ����4�ڸ�, ��, ��, ���� )
-- mon - ��(����), dy ���Ͼ���
select ename, to_char( hiredate, 'yyyy/mon/dd dy') from emp;
-- ����̸�, ����, ���� ���
-- nvl(A, B) A�� null�̸� B
select ename, sal, sal*12 + nvl(comm,0) ���� from emp;
-- to_char(����, '999,999') õ���� �ĸ�
-- to_char(����, 'L999,999') õ���� �ĸ�(������ ȭ����� ǥ��)
select ename, to_char(sal,'L999,999')
, to_char( sal*12 + nvl(comm,0), 'L999,999') ���� from emp;
-- to_date(����)  ��¥�� ��ȯ
select * from emp where hiredate = '80-12-17';
select * from emp where hiredate = to_date('19801217', 'yyyy-mm-dd');
-- to_number  ���ڷ� ��ȯ
select '200' - 100 from dual;
select to_number('200') - 100 from dual;
--p.177   
-- decode( ǥ����, ����1, ���1, ����2, ���2, ����3, ���3, ����Ʈ���)
-- decode( ����, 90����, A, 80����, B, 70����, C, 60����, D, F )
-- �μ��ڵ� 10 =>  ACCOUNTING, 20 => RESEARCH, 30=>SALES
select * from dept;
-- �̸�, �μ��ڵ�, �μ��� 
select ename, deptno
, decode( deptno, 10, 'ACCOUNTING', 20, 'RESEARCH', 30,'SALES','��Ÿ')
from emp;
-- decode �Լ� : ������, ���� �����ĸ� �� ����
-- �μ��ڵ� 10 =>  ACCOUNTING, 20 => RESEARCH, 30=>SALES, ��Ÿ
-- case when ����1 then ���1
--        when ����2 then ���2
--        when ����3 then ���3
--        else  ����Ʈ���
-- end 
select ename, deptno
, case when deptno=10 then 'ACCOUNTING'
        when deptno=20 then 'RESEARCH'
        when deptno=30 then 'SALES'
        else '��Ÿ'
  end �μ���
from emp;      
-- 4000 �ʰ� '��׿�����',  3000~4000 '��տ�����', �׿ܿ��� '�⺻������'
select * from emp order by sal desc;
select ename, sal
, case when sal > 4000 then '��׿�����'
        when sal between 3000 and 4000 then '��տ�����'
        else '�⺻������'
  end ��������
from emp;

-- ���ٸ޸��� ���̺�
create table memo (
idx int not null,       -- �Խù���ȣ 
writer varchar2(50) not null,
memo varchar2(500) not null,
post_date date default sysdate, -- �ۼ����ڴ� �⺻������ ���� ��¥�� �Է�
primary key(idx) 
);
insert into memo (idx,writer,memo) values (1, 'kim', '�޸� ����');
select * from memo;
commit;