/* Formatted on 2014/06/05 ���� 11:21:05 (QP5 v5.256.13226.35510) */
--PL/SQL(Procedural Language extension to SQL)
-- ������ �޽��� ���
--set serveroutput on
--begin -- ����
--    ��ɾ�;
--end; -- ��
--/ -- �����϶�� �ǹ�

BEGIN
   -- ��Ű��.�Լ�
   DBMS_OUTPUT.put_line ('hello');                              --����Ŭ �ý���â�� ���
END;
/

-- ���� ����, ���Թ�(p.550)
--declare
--    ���� �ڷ��� := ��;
--begin
--    ��ɾ�;
--end;
--/
--  A := B;   ����
-- A = B      ��

DECLARE
   vempno   NUMBER (4) := 7788;
   vename   VARCHAR2 (10) := 'SCOTT';
BEGIN
   DBMS_OUTPUT.put_line ('��� :' || vempno);
   DBMS_OUTPUT.put_line ('�̸� :' || vename);
END;
/

DECLARE
   --v_empno number := 7369;
   --v_ename varchar2(50);
   -- ���̺�.�÷�%type => ���̺�,�÷��� ������ �ڷ������� ó����
   v_empno   emp.empno%TYPE := 7369;
   v_ename   emp.ename%TYPE;
BEGIN
   -- select �÷� into ����  : �÷��� ���� ������ ����
   SELECT ename
     INTO v_ename
     FROM emp
    WHERE empno = v_empno;

   DBMS_OUTPUT.put_line ('���:' || v_empno);
   DBMS_OUTPUT.put_line ('�̸�:' || v_ename);
END;
/

SELECT * FROM emp;

SELECT deptno, dname FROM dept;

-- ��� 7369�� ��������� Ȯ��

SELECT COUNT (*)
  FROM emp
 WHERE empno = 7369;                                                                                                                                                                   -- 1 (���Ұ���)
-- ��� 7367�� ��������� Ȯ��

SELECT COUNT (*)
  FROM emp
 WHERE empno = 7367;                                                                                                                                                                   -- 0 (��밡��)

-- p.555(���̺� type)
-- ���� ���̺�.�÷�%type => �÷� Ÿ��
-- type ������ is table of ���̺�.�÷�%type
-- index by binary_integer

DECLARE
   --���̺� Ÿ�� ����
   TYPE ename_table_type IS TABLE OF emp.ename%TYPE
      INDEX BY BINARY_INTEGER;

   --���̺� Ÿ���� ���� ����
   -- ������ �ڷ���
   ename_table   ename_table_type;
   i             BINARY_INTEGER := 0;
BEGIN
   -- for ���� in (����) loop ~ end loop;
   FOR k IN (SELECT ename FROM emp)
   LOOP
      i := i + 1;
      -- ���̺���(�ε���)  DB������ �ε����� 1���� ����
      ename_table (i) := k.ename;
      DBMS_OUTPUT.put_line ('�̸�:' || ename_table (i));
   END LOOP;
END;
/

SELECT '�̸�:' || ename FROM emp;

-- p.560 ���ù�(if)
--if ���ǽ� then
--elsif ���ǽ� then
--end if;
-- �μ���ȣ�� �μ��� ���

DECLARE                                                                  --�����
   v_deptno   NUMBER;
   v_empno    NUMBER := 7369;
BEGIN
   SELECT deptno
     INTO v_deptno
     FROM emp
    WHERE empno = v_empno;

   DBMS_OUTPUT.put_line ('�μ��ڵ�:' || v_deptno);

   IF v_deptno = 10
   THEN
      DBMS_OUTPUT.put_line (' Accounting �μ� ');
   ELSIF v_deptno = 20
   THEN
      DBMS_OUTPUT.put_line (' Research �μ� ');
   ELSIF v_deptno = 30
   THEN
      DBMS_OUTPUT.put_line (' Sales �μ� ');
   ELSE
      DBMS_OUTPUT.put_line (' ��Ÿ �μ� ');
   END IF;
END;
/

-- ���� ���� ���

SELECT ename,
       sal,
       comm,
       (sal * 12 + comm)
  FROM emp;

SELECT ename,
       sal,
       comm,
       (sal * 12 + NVL (comm, 0))
  FROM emp;

-- nvl �Լ� ��� if ~ else ~ end if ����

DECLARE
   v_ename      emp.ename%TYPE := 'FORD';
   v_year_sal   NUMBER;                                                   --����
   v_sal        NUMBER;
   v_comm       NUMBER;
BEGIN
   SELECT ename, sal, comm
     INTO v_ename, v_sal, v_comm
     FROM emp
    WHERE ename = 'FORD';

   IF v_comm IS NULL
   THEN
      v_year_sal := v_sal * 12;
      DBMS_OUTPUT.put_line ('�̸�:' || v_ename || ',����:' || v_year_sal);
   ELSE
      v_year_sal := v_sal * 12 + v_comm;
      DBMS_OUTPUT.put_line ('�̸�:' || v_ename || ',����:' || v_year_sal);
   END IF;
END;
/

-- �ݺ���(p.567)
-- loop ~ end loop;
-- for ~ end loop;
-- while ~ end loop;

DECLARE
   n   NUMBER := 1;
BEGIN
   LOOP
      DBMS_OUTPUT.put_line (n);
      n := n + 1;

      IF n > 5
      THEN
         EXIT;                                                    -- loop�� ���
      END IF;
   END LOOP;
END;
/

-- ������ ���

DECLARE
   dan   NUMBER := 5;
   i     NUMBER := 1;
BEGIN
   LOOP
      -- ���
      DBMS_OUTPUT.put_line (dan || 'x' || i || '=' || dan * i);
      -- i�� ���� ó��
      i := i + 1;

      -- i�� 9���� ũ�� exit
      IF i > 9
      THEN
         EXIT;
      END IF;
   END LOOP;
END;
/

-- for ī���ͺ��� in (����) loop
-- end loop;

-- for ī���ͺ��� in ����..�� loop
-- end loop;

DECLARE
BEGIN
   FOR n IN 1 .. 5
   LOOP
      DBMS_OUTPUT.put_line (n);
   END LOOP;
END;
/

-- ����̸� ���

DECLARE
   --type emp_table is table of emp.ename%type index by binary_integer;
   --v_emp emp_table;
   v_sal   NUMBER;
BEGIN
   FOR v_emp IN (SELECT ename, sal, comm FROM emp)
   LOOP
      DBMS_OUTPUT.put_line ('�̸�:' || v_emp.ename);
      DBMS_OUTPUT.put_line ('����:' || v_emp.sal);
      DBMS_OUTPUT.put_line ('���ʽ�:' || v_emp.comm);

      IF v_emp.comm IS NULL
      THEN
         v_sal := v_emp.sal * 12;
      ELSE
         v_sal := v_emp.sal * 12 + v_emp.comm;
      END IF;

      DBMS_OUTPUT.put_line ('����:' || v_sal);
   END LOOP;
END;
-- ����̸�, �μ��̸� ���

DECLARE                                                                  --�����
BEGIN
   FOR v_emp IN (SELECT ename, deptno FROM emp)
   LOOP
      DBMS_OUTPUT.put_line ('�̸�:' || v_emp.ename);

      IF v_emp.deptno = 10
      THEN
         DBMS_OUTPUT.put_line ('�μ�: Accounting');
      ELSIF v_emp.deptno = 20
      THEN
         DBMS_OUTPUT.put_line ('�μ�: Research');
      ELSIF v_emp.deptno = 30
      THEN
         DBMS_OUTPUT.put_line ('�μ�: Sales');
      ELSE
         DBMS_OUTPUT.put_line ('�μ�: ��Ÿ');
      END IF;
   END LOOP;
END;
/

-- while loop (p.572)
--while ���ǽ� loop
--end loop;

DECLARE
   n   NUMBER := 1;
BEGIN
   WHILE n <= 5
   LOOP
      DBMS_OUTPUT.put_line (n);
      n := n + 1;
   END LOOP;
END;


-- ����̸�, �Ŵ����� �̸� ���

SELECT ename,
       mgr,
       (SELECT ename
          FROM emp
         WHERE empno = e.mgr)
          �Ŵ���
  FROM emp e;

DECLARE                                             --cursor Ŀ���̸� is select����;
   CURSOR c_emp
   IS
      SELECT *
        FROM emp
       WHERE mgr IS NOT NULL;

   v_emp   emp%ROWTYPE;                            --���� ���̺� %rowtype => ���ڵ� ����
   v_mgr   VARCHAR2 (50);
BEGIN
   --for ���ڵ� ���� in Ŀ�� loop(Ŀ���� ���µǾ� ���ڵ� ������ ���޵�
   FOR v_emp IN c_emp
   LOOP
      SELECT ename
        INTO v_mgr
        FROM emp
       WHERE empno = v_emp.mgr;

      DBMS_OUTPUT.put ('�̸�:' || v_emp.ename || ',');
      DBMS_OUTPUT.put_line ('�Ŵ���:' || v_mgr);
   END LOOP;
END;
/

--���� ���ν���(p.576)
-- stored procedure ( SP )
--create or replace procedure ���ν����̸�( �Ű����� )
--is
--    ��������
--begin
--    ��ɾ�
--end;
--/
-- ���ν����� �����ϴ� ���
--exec ���ν����̸�(�Ű�����)


DROP TABLE emp03;

CREATE TABLE emp03
AS
   SELECT * FROM emp;

-- ����� 7369���� ����� �޿��� 10% �λ�

SELECT *
  FROM emp03
 WHERE empno = 7369;

UPDATE emp03
   SET sal = sal * 1.1
 WHERE empno = 7369;

CREATE OR REPLACE PROCEDURE update_sal (v_empno IN NUMBER)
IS
BEGIN
   UPDATE emp03
      SET sal = sal * 1.1
    WHERE empno = v_empno;
END;
/

EXEC update_sal(7499);

SELECT *
  FROM emp03
 WHERE empno = 7499;

--�޸� �߰�

SELECT * FROM memo;

INSERT INTO memo (idx, writer, memo)
     VALUES (memo_seq.NEXTVAL, 'kim', 'memo');

CREATE OR REPLACE PROCEDURE memo_insert (v_name   IN VARCHAR2,
                                         v_memo   IN VARCHAR2)
IS
BEGIN
   INSERT INTO memo (idx, writer, memo)
        VALUES (memo_seq.NEXTVAL, v_name, v_memo);
END;
/

EXEC memo_insert('park', 'memo2');

SELECT * FROM memo;

COMMIT;

-- �޸� ����

CREATE OR REPLACE PROCEDURE memo_update (v_writer   IN VARCHAR2,
                                         v_memo     IN VARCHAR2,
                                         v_idx         NUMBER)
IS
BEGIN
   UPDATE memo
      SET writer = v_writer, memo = v_memo, post_date = SYSDATE
    WHERE idx = v_idx;
END;
/

EXEC memo_update( 'kim2', 'memo2', 81 );
COMMIT;
-- �޸� ���� ���ν���

CREATE OR REPLACE PROCEDURE memo_delete (v_idx NUMBER)
IS
BEGIN
   DELETE FROM memo
         WHERE idx = v_idx;
END;
/

SELECT * FROM memo;

EXEC memo_delete(81);
COMMIT;

-- select ���ν���
-- ��¸Ű����� out �ڷ���
-- sys_refcursor : select ������ �������� ��ȸ�ϴ� �ý��� Ŀ��

CREATE OR REPLACE PROCEDURE memo_list (rs OUT SYS_REFCURSOR)
IS
BEGIN
   -- open Ŀ������ for select����;  select������ �� �྿ �����ϴ� Ŀ�� ����
   OPEN rs FOR SELECT * FROM memo;
END;
/

EXECUTE memo_list;


-- �Խù� �߰�

CREATE OR REPLACE PROCEDURE board_insert (vname       VARCHAR,
                                          vsubject    VARCHAR,
                                          vcontent    VARCHAR)
IS
BEGIN
   INSERT INTO board (idx,
                      name,
                      subject,
                      content)
        VALUES ( (SELECT NVL (MAX (idx) + 1, 1) FROM board),
                vname,
                vsubject,
                vcontent);
END;
/


EXEC board_insert('kim', '����', '����');
EXECUTE board_insert('kim', '����', '����');

  SELECT *
    FROM board
ORDER BY idx DESC;

COMMIT;

--���� ���ν��� ��� Ȯ��

SELECT *
  FROM user_objects
 WHERE object_type = 'PROCEDURE';

--���� ���ν����� �ҽ� Ȯ��

SELECT * FROM user_source;

--���� ���ν����� ����
--������ �ڵ�(������ sql������ �����ϰ� ��)
--db�� ���ȼ� ���
--������ ����ӵ��� ����(�̸� �����ϵǾ� �ִ� ����)



--����� ���� �Լ�(p.590)
--create or replace �Լ��̸�(�Ű�����)
--is
--    ��������
--begin
--    sql����
--    return ���ϰ�;
--end;
--/

CREATE OR REPLACE FUNCTION fn_update_sal (v_empno NUMBER)
   RETURN NUMBER                                         --���ϵǴ� ������ Ÿ���� �����ؾ� ��
IS
   v_sal   NUMBER;
BEGIN
   --update emp set sal = sal * 1.1 where empno = v_empno;
   SELECT sal
     INTO v_sal
     FROM emp
    WHERE empno = v_empno;

   RETURN v_sal;                                                      --���ϵǴ� ��
END;
/

VAR salary NUMBER;
EXECUTE :salary := fn_update_sal(7369);
PRINT salary;

SELECT * FROM emp;

--ORA-14551: cannot perform a DML operation inside a query
--ORA-06512: at "JAVA.FN_UPDATE_SAL", line 6

SELECT fn_update_sal (7369) FROM DUAL;


-- �����ȣ�� �ش��ϴ�  �μ��̸��� �����ϴ� �Լ�

SELECT dname
  FROM emp e, dept d
 WHERE e.deptno = D.DEPTNO AND empno = 7369;

CREATE OR REPLACE FUNCTION fn_emp_dept (v_empno NUMBER)
   RETURN VARCHAR2                                                    --���� �ڷ���
IS
   v_dname   VARCHAR2 (50);
BEGIN
   SELECT dname
     INTO v_dname
     FROM emp e, dept d
    WHERE e.deptno = D.DEPTNO AND empno = 7369;

   RETURN v_dname;                                              --������ ����� �� ����
END;
/


SELECT fn_emp_dept (7369) FROM DUAL;

-- ����Ŭ�� �����Լ� �ҽ� ����

SELECT *
  FROM dba_source
 WHERE text LIKE '%NVL%';

--�Լ��� �̿��Ͽ� �μ� ���

SELECT empno, ename, fn_emp_dept (e.empno)
  FROM emp e;

-- ���������� �̿��Ͽ� �μ��̸� ���

SELECT empno,
       ename,
       (SELECT dname
          FROM dept
         WHERE deptno = e.deptno)
  FROM emp e;

--���̺� ������ �̿��Ͽ� �μ��̸� ���

SELECT empno, ename, dname
  FROM emp e, dept d
 WHERE e.deptno = d.deptno;


SELECT dname
  INTO v_dname
  FROM emp e, dept d
 WHERE e.deptno = D.DEPTNO AND empno = 7369;

--������� ����� ������ �����ϴ� �Լ�
-- fn_emp_sal(7369) => sal * 12 +comm

CREATE OR REPLACE FUNCTION fn_emp_sal (v_empno NUMBER)
   RETURN NUMBER
IS
   v_year_sal   NUMBER;
BEGIN
   SELECT sal * 12 + NVL (comm, 0)
     INTO v_year_sal
     FROM emp
    WHERE empno = 7369;

   RETURN v_year_sal;
END;
/

-- ����� ������ �Է¹޾� ����, ����, �Ǽ��ɾ��� �����ϴ� �Լ�

CREATE OR REPLACE FUNCTION fn_emp_tex (v_empno NUMBER, v_rate NUMBER)
   RETURN NUMBER
IS
   v_tex   NUMBER;
BEGIN
   SELECT (sal * 12 + NVL (comm, 0)) * v_rate
     INTO v_tex
     FROM emp
    WHERE empno = v_empno;

   RETURN v_tex;
END;
/

  SELECT ename,
         fn_emp_sal (empno) ����,
         fn_emp_tax (empno, 0.03) ����,
         fn_emp_sal (empno) - fn_emp_tax (empno, 0.03) �Ǽ��ɾ�
    FROM emp
ORDER BY �Ǽ��ɾ� DESC;

-- Ŀ��(p. 593)
--�Ͻ����� Ŀ��

DECLARE
BEGIN
   FOR v_emp IN (SELECT * FROM emp)
   LOOP
      DBMS_OUTPUT.put_line ('�̸�:' || v_emp.ename);
      DBMS_OUTPUT.put_line ('�޿�:' || v_emp.sal);
   END LOOP;
END;
/



DECLARE
   v_emp   emp%ROWTYPE;                        -- ���̺� %rowtype => ���ڵ带 �����ϴ� ����
BEGIN
   -- no data found (select ������ ������� ������)
   SELECT *
     INTO v_emp
     FROM emp
    WHERE empno = 1;

   IF SQL%FOUND
   THEN
      DBMS_OUTPUT.put_line (
         '�̸�:' || v_emp.ename || ',�޿�:' || v_emp.sal);
   END IF;
EXCEPTION                                                             -- ���� ó��
   WHEN NO_DATA_FOUND
   THEN                                                                -- �����ڵ�
      DBMS_OUTPUT.put_line ('�������� �ʴ� ����Դϴ�');
   WHEN OTHERS
   THEN                                                                --��Ÿ ����
      DBMS_OUTPUT.put_line ('��Ÿ ���� �߻�');
END;
/

-- �Ͻ����� Ŀ���� �Ӽ�
--sql%found   sql���� ������ �޴� ���� ���� 1�� �̻��� ��
--sql%rowcount    sql���� ������ �޴� ���� ��
--sql%notfound    sql���� ������ �޴� ���� ���� 0�� �� ��
--sql%isopen  �Ͻ����� Ŀ���� ���� �ִ��� ����

DECLARE
   v_count   NUMBER;
BEGIN
   SELECT COUNT (*) INTO v_count FROM emp;

   IF SQL%FOUND
   THEN                                       -- sql ������ ������ ���� ���� ���� 1�� �̻��� ��
      DBMS_OUTPUT.put_line ('���� �� :' || v_count);
      DBMS_OUTPUT.put_line ('���� �� :' || TO_CHAR (SQL%ROWCOUNT));
   END IF;

   IF SQL%NOTFOUND
   THEN                                                            -- �ڷᰡ ���� ��
      DBMS_OUTPUT.put_line ('not found');
   END IF;

   IF SQL%ISOPEN
   THEN                                                             --Ŀ���� ��������
      DBMS_OUTPUT.put_line ('is open');
   END IF;
END;
/



--������� Ŀ��

-------Ŀ������ ����
--cursor Ŀ�������� is select ����;
------Ŀ�� ����
--open Ŀ��������;
------Ŀ���� ����ġ�� �Ѱ��� ���ڵ带 ������ ����
--fetch Ŀ�������� into ����
------Ŀ���� ����
--close Ŀ��������;



SELECT COUNT (*)
  FROM emp
 WHERE empno = 100;

SELECT COUNT (*)
  FROM emp
 WHERE empno = 100;

SELECT COUNT (*)
  FROM emp
 WHERE empno = 7369;


SELECT * FROM emp_dept_view;



--�Խù� ����

CREATE OR REPLACE PROCEDURE board_update (vname       VARCHAR,
                                          vsubject    VARCHAR,
                                          vcontent    VARCHAR,
                                          vidx        NUMBER)
IS
BEGIN
   UPDATE board
      SET name = vname, subject = vsubject, content = vcontent
    WHERE idx = vidx;
END;
/


CREATE OR REPLACE PROCEDURE board_delete (vidx NUMBER)
IS
BEGIN
   DELETE FROM board
         WHERE idx = vidx;
END;
/

-- �Խù� �� ȭ��
--������ out sys_refcursor => ��¿� �Ű�����(Ŀ��)

CREATE OR REPLACE PROCEDURE board_detail (vidx NUMBER, rs OUT SYS_REFCURSOR)
IS
BEGIN
   UPDATE board
      SET hit = hit + 1
    WHERE idx = vidx;

   --open Ŀ�� for select����;
   OPEN rs FOR
      SELECT *
        FROM board
       WHERE idx = vidx;
END;
/

--��� ���� ���

CREATE OR REPLACE PROCEDURE comment_count (vidx NUMBER, vcount OUT NUMBER)
IS
BEGIN
   SELECT COUNT (*)
     INTO vcount
     FROM board_comment
    WHERE board_idx = vidx;
END;
/


-- ��� ���

CREATE OR REPLACE PROCEDURE comment_list (vidx NUMBER, rs OUT SYS_REFCURSOR)
IS
BEGIN
   OPEN rs FOR
        SELECT *
          FROM board_comment
         WHERE board_idx = vidx
      ORDER BY idx DESC;
END;
/

--��� ����

CREATE OR REPLACE PROCEDURE comment_insert (v_board_idx    NUMBER,
                                            v_name         VARCHAR,
                                            v_content      VARCHAR)
IS
BEGIN
   INSERT INTO board_comment (idx,
                              board_idx,
                              name,
                              content)
        VALUES ( (SELECT NVL (MAX (idx) + 1, 1) FROM board_comment),
                v_board_idx,
                v_name,
                v_content);
END;
/

--�Ű������� ����ϴ� Ŀ��
--���� �̸� ���

CREATE OR REPLACE PROCEDURE emp_list_p (v_sal NUMBER)
IS
   v_ename   emp.ename%TYPE;                                          --�÷� �ڷ���

   --Ŀ������(�Ű�����))
   CURSOR emp_list (v_sal NUMBER)
   IS
      SELECT ename
        FROM emp
       WHERE sal > v_sal;
BEGIN
   FOR emplist IN emp_list (v_sal)
   LOOP
      DBMS_OUTPUT.put_line ('�̸�:' || emplist.ename);
   END LOOP;
END;
/

EXECUTE emp_list_p(3000);



--Ʈ����(trigger)
--insert, delete, update ������ ���� �� �� �ڵ����� ����Ǵ� ���ν���
--before Ʈ����
-- after Ʈ����



--create or replace trigger Ʈ�����̸�
--before / after
--    insert or delecte or update on ���̺�
--declare
--    ��������;
--begin
--end;
--/


--���̺� ����
DROP TABLE dept03;

CREATE TABLE dept03
AS
   SELECT *
     FROM dept
    WHERE 0 = 1;

-- Ʈ���� �ۼ�
-- for each row : ����� Ʈ���� ( �ึ�� ����Ǵ� Ʈ���� )
-- ���̺� ���� Ʈ����

CREATE OR REPLACE TRIGGER trigger1
   AFTER INSERT
   ON dept
   FOR EACH ROW
BEGIN
   -- :new   ,  :old  �ӽ����̺�
   INSERT INTO dept03
        VALUES (:new.deptno, :new.dname, :new.loc);
END;
/


INSERT INTO dept
     VALUES (50, '������', '�λ�');

SELECT * FROM dept;

SELECT * FROM dept03;


CREATE OR REPLACE TRIGGER trigger2
   AFTER DELETE
   ON dept
   FOR EACH ROW
BEGIN
   DELETE FROM dept03
         WHERE deptno = :old.deptno;
END;
/

DELETE FROM dept
      WHERE deptno = 50;
      
--��� ���̺� insert, update, delete �� ����� �� ��ձ޿��� ȭ�鿡 ���
drop table emp03;
create table emp03 as select * from emp;


create or replace trigger trigger3
after insert or delete or update on emp03
declare
    v_sal number(5);
begin
    select avg(sal) into v_sal from emp03;
    dbms_output.put_line('��ձ޿�:'||v_sal);
end;
/

select avg(sal) from emp03;


insert into emp03(empno,ename,sal) values(1,'kim',3000);
delete from emp03 where empno=7369;
update emp03 set sal= sal*1.2;

select * from emp03;


-- ���̺� �����̽��� ���� Ȯ��
select * from dba_tablespaces;
select * from user_tablespaces;

--����� ����
select * from dba_users;


--������ ������ ����
select * from dba_data_files;


--������� ����(���� �α������� �����)
select * from session_roles;;

--����� ������ ����
select * from user_role_privs; -- ���� �����
select * from dba_role_privs order by grantee; --��ü �����



--��� �� ����
--��� ���(Ŀ�ǵ忡�� ����)
--exp ���̵�/��� file=��������� full=y


-- ex) exp hr/hr file = hr.dmp

--�������
--imp ���̵�/��� file=���������� full=y ignor=y
--ex)imp hr/hr file=hr.dmp fully=y


