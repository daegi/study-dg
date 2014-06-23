-- p. ���̺� ���� ����(9��)
-- sqlplus���� ����( rowid Ȯ�� )
-- rownum - �Ϸù�ȣ
-- rowid - ���ڵ��� �ּҰ�
select rowid, rownum, empno, ename from emp;
-- �Խ��� ���̺�
drop table board;
create table board (
idx number not null,                -- �Խù� ��ȣ
name varchar2(50) not null,        -- �̸�
subject varchar2(100) not null,     -- ����
content varchar2(2000) not null,   -- ����
hit number default 0,                      -- ��ȸ��
post_date date default sysdate,    -- �ۼ���¥
primary key(idx)
);

--�׽�Ʈ ���ڵ� �Է�
delete from board;
commit;
-- �Ϸù�ȣ ���
insert into board (idx,name,subject,content) values (1, 'kim', '����', '����');
select max(idx)+1 from board;
-- nvl ( A, B ) A�� null �̸� B
select nvl( max(idx)+1, 1 ) from board;


-- PL/SQL 
declare  -- ����
    i number := 1;   -- ������  �ڷ���   :=   ��;  
begin
    while i <= 100000 loop
        insert into board (idx, name, subject, content ) values
        ( (select nvl(max(idx)+1,1) from board), 'kim'||i,
            '����'||i, '����'||i );
        i := i + 1;
    end loop;
end;
/   
commit;
select count(*) from board; 
delete from board;
commit;
select * from board order by idx desc; 
commit;
-- 1������ ���
select rownum, idx, name, subject, hit, post_date
from board
where rownum <= 10
order by idx desc;
-- rownum < ���� (��밡��)
-- rownum > ���� (���Ұ���) 
--������ �����⸦ ���� select ��ɾ�
select * from board;

select idx, name, subject, hit, post_date, cnt
from ( select A.*, rownum as rn 
         from (
            select idx, name, subject, hit, post_date
                , (select count(*) from board_comment 
                    where board_idx=b.idx ) cnt
            from board b
            order by idx desc ) A ) 
where rn between 101 and 110
order by idx desc;         

create or replace view board_v
as
select idx, name, subject, hit, post_date, cnt
from ( select A.*, rownum as rn 
         from (
            select idx, name, subject, hit, post_date
                , (select count(*) from board_comment 
                    where board_idx=b.idx ) cnt
            from board b
            order by idx desc ) A ) 
where rn between 101 and 110
order by idx desc;

select * from board_v;   

--��ȸ�� ���� ó��
select * from board where idx=100000;
-- update ���̺� set �÷�=�� where �÷�=��;
update board set hit=hit+1 where idx=100000;
commit; 

--��� ���̺� �ۼ�
create table board_comment (
idx number not null,                -- ��� �Ϸù�ȣ
board_idx number not null,        -- �Խù���ȣ(�θ�۹�ȣ)
name varchar2(100) not null,
content varchar2(1000) not null,
post_date date default sysdate,
primary key( idx )
);
-- 100000�� �Խù��� ��� �߰�
insert into board_comment ( idx, board_idx, name, content ) values
( (select nvl(max(idx)+1,1) from board_comment)
    , 100000,'park', 'ù��° ���');

select * from board_comment;
commit;

-- �Խù����� ����� � �ִ��� ���
select * from board 
order by idx desc;


--���ε� : team - commit
--�ٿ�ε� : team - update to head ( �ֽŹ��� )
--    team - update to version ( Ư���� ���� )

-- p.264 
create table emp01(
empno number(4),
ename varchar2(20),
sal number(7,2)  -- ���� 7�ڸ�, �Ҽ� 2�ڸ� 
);
-- int ������ �Է� => number(38)
-- desc ���̺��̸� => ���̺��� ���� Ȯ��
desc emp01;
-- ���������� �̿��� ���̺� ����
-- create table ���̺��̸� as select����;
-- ���̺� ���� + ������ ����
create table emp02
as select * from emp;

select * from emp02;

create table emp03 
as select * from emp where deptno=30;

select * from emp03;

-- ���̺��� ������ ������ ���
create table emp04
as select * from emp where 0=1;

select * from emp04;

-- create table ���̺� �����
-- alter table ���̺� ����
-- drop table ���̺� ���� 

-- ���̺��� ���� ����
-- �÷� �߰� : alter table ���̺��̸� add ( �÷��̸� �ڷ���(������) );
alter table emp01 add ( job varchar2(9) );

desc emp01;

-- dept02 ���̺��� �����(dept ���̺� ����)
-- �μ���(dmgr) �÷� �߰�( varchar2(10 )
create table dept02
as select * from dept;

alter table dept02 add ( dmgr varchar2(10) );

select * from dept02;

-- �÷� �Ӽ� ����
-- alter table ���̺��̸� modify ( �÷��̸� �ڷ���(������) );
-- dmgr �÷��� ����� 50����Ʈ�� ����
alter table dept02 modify ( dmgr varchar2(50) );
desc dept02;
-- emp01 ���̺��� job �÷��� ����� 30����Ʈ�� ����
alter table emp01 modify ( job varchar2(30) );
-- dept02 ���̺��� dmgr �÷��� ���� Ÿ��(���� 4�ڸ�)���� ����
alter table dept02 modify ( dmgr number(4) );
-- �÷� ����
-- alter table ���̺��̸� drop column �÷��̸�;
-- emp01 ���̺��� job �÷� ����
alter table emp01 drop column job;
desc emp01;
-- ���̺� ����(p.277)
-- drop table ���̺��̸�;
drop table emp01;
-- ���̺� ��� Ȯ��
select * from tab;
-- ���̺� �̸� ����(p.281)
-- rename A to B  : A�� B�� ����
rename emp02 to test;
select * from test02;
desc test;
 
desc tab;
-- ������ ����(p.282)
-- user_    ����ڰ� ������ ��ü��
-- all_      ����ڰ� �����߰ų� ������ �ο����� ��ü��
-- dba_    ��� ��ü��

-- ��(view)
create or replace view emp_v
as
select empno, ename, dname
from emp e, dept d
where e.deptno=d.deptno; 

select * from emp_v;
select * from (select empno, ename, dname
from emp e, dept d
where e.deptno=d.deptno);
-- ���̺�, �� ��� Ȯ��
select * from tab;

desc user_tables;
select * from user_tables;
select * from user_sequences;
select * from user_indexes;
desc all_tables;
select * from all_tables;
select * from all_views;
desc dba_tables;
select * from dba_tables;







 



