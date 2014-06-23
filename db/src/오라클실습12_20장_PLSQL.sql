/* Formatted on 2014/06/05 오전 11:21:05 (QP5 v5.256.13226.35510) */
--PL/SQL(Procedural Language extension to SQL)
-- 간단한 메시지 출력
--set serveroutput on
--begin -- 시작
--    명령어;
--end; -- 끝
--/ -- 실행하라는 의미

BEGIN
   -- 패키지.함수
   DBMS_OUTPUT.put_line ('hello');                              --오라클 시스템창에 출력
END;
/

-- 변수 선언, 대입문(p.550)
--declare
--    변수 자료형 := 값;
--begin
--    명령어;
--end;
--/
--  A := B;   대입
-- A = B      비교

DECLARE
   vempno   NUMBER (4) := 7788;
   vename   VARCHAR2 (10) := 'SCOTT';
BEGIN
   DBMS_OUTPUT.put_line ('사번 :' || vempno);
   DBMS_OUTPUT.put_line ('이름 :' || vename);
END;
/

DECLARE
   --v_empno number := 7369;
   --v_ename varchar2(50);
   -- 테이블.컬럼%type => 테이블,컬럼에 지정된 자료형으로 처리됨
   v_empno   emp.empno%TYPE := 7369;
   v_ename   emp.ename%TYPE;
BEGIN
   -- select 컬럼 into 변수  : 컬럼의 값을 변수에 복사
   SELECT ename
     INTO v_ename
     FROM emp
    WHERE empno = v_empno;

   DBMS_OUTPUT.put_line ('사번:' || v_empno);
   DBMS_OUTPUT.put_line ('이름:' || v_ename);
END;
/

SELECT * FROM emp;

SELECT deptno, dname FROM dept;

-- 사번 7369이 사용중인지 확인

SELECT COUNT (*)
  FROM emp
 WHERE empno = 7369;                                                                                                                                                                   -- 1 (사용불가능)
-- 사번 7367이 사용중인지 확인

SELECT COUNT (*)
  FROM emp
 WHERE empno = 7367;                                                                                                                                                                   -- 0 (사용가능)

-- p.555(테이블 type)
-- 변수 테이블.컬럼%type => 컬럼 타입
-- type 변수명 is table of 테이블.컬럼%type
-- index by binary_integer

DECLARE
   --테이블 타입 정의
   TYPE ename_table_type IS TABLE OF emp.ename%TYPE
      INDEX BY BINARY_INTEGER;

   --테이블 타입의 변수 선언
   -- 변수명 자료형
   ename_table   ename_table_type;
   i             BINARY_INTEGER := 0;
BEGIN
   -- for 변수 in (집합) loop ~ end loop;
   FOR k IN (SELECT ename FROM emp)
   LOOP
      i := i + 1;
      -- 테이블변수(인덱스)  DB에서는 인덱스가 1부터 시작
      ename_table (i) := k.ename;
      DBMS_OUTPUT.put_line ('이름:' || ename_table (i));
   END LOOP;
END;
/

SELECT '이름:' || ename FROM emp;

-- p.560 선택문(if)
--if 조건식 then
--elsif 조건식 then
--end if;
-- 부서번호로 부서명 출력

DECLARE                                                                  --선언부
   v_deptno   NUMBER;
   v_empno    NUMBER := 7369;
BEGIN
   SELECT deptno
     INTO v_deptno
     FROM emp
    WHERE empno = v_empno;

   DBMS_OUTPUT.put_line ('부서코드:' || v_deptno);

   IF v_deptno = 10
   THEN
      DBMS_OUTPUT.put_line (' Accounting 부서 ');
   ELSIF v_deptno = 20
   THEN
      DBMS_OUTPUT.put_line (' Research 부서 ');
   ELSIF v_deptno = 30
   THEN
      DBMS_OUTPUT.put_line (' Sales 부서 ');
   ELSE
      DBMS_OUTPUT.put_line (' 기타 부서 ');
   END IF;
END;
/

-- 직원 연봉 계산

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

-- nvl 함수 대신 if ~ else ~ end if 연습

DECLARE
   v_ename      emp.ename%TYPE := 'FORD';
   v_year_sal   NUMBER;                                                   --연봉
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
      DBMS_OUTPUT.put_line ('이름:' || v_ename || ',연봉:' || v_year_sal);
   ELSE
      v_year_sal := v_sal * 12 + v_comm;
      DBMS_OUTPUT.put_line ('이름:' || v_ename || ',연봉:' || v_year_sal);
   END IF;
END;
/

-- 반복문(p.567)
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
         EXIT;                                                    -- loop를 벗어남
      END IF;
   END LOOP;
END;
/

-- 구구단 계산

DECLARE
   dan   NUMBER := 5;
   i     NUMBER := 1;
BEGIN
   LOOP
      -- 출력
      DBMS_OUTPUT.put_line (dan || 'x' || i || '=' || dan * i);
      -- i값 증가 처리
      i := i + 1;

      -- i가 9보다 크면 exit
      IF i > 9
      THEN
         EXIT;
      END IF;
   END LOOP;
END;
/

-- for 카운터변수 in (집합) loop
-- end loop;

-- for 카운터변수 in 시작..끝 loop
-- end loop;

DECLARE
BEGIN
   FOR n IN 1 .. 5
   LOOP
      DBMS_OUTPUT.put_line (n);
   END LOOP;
END;
/

-- 사원이름 출력

DECLARE
   --type emp_table is table of emp.ename%type index by binary_integer;
   --v_emp emp_table;
   v_sal   NUMBER;
BEGIN
   FOR v_emp IN (SELECT ename, sal, comm FROM emp)
   LOOP
      DBMS_OUTPUT.put_line ('이름:' || v_emp.ename);
      DBMS_OUTPUT.put_line ('월급:' || v_emp.sal);
      DBMS_OUTPUT.put_line ('보너스:' || v_emp.comm);

      IF v_emp.comm IS NULL
      THEN
         v_sal := v_emp.sal * 12;
      ELSE
         v_sal := v_emp.sal * 12 + v_emp.comm;
      END IF;

      DBMS_OUTPUT.put_line ('연봉:' || v_sal);
   END LOOP;
END;
-- 사원이름, 부서이름 출력

DECLARE                                                                  --선언부
BEGIN
   FOR v_emp IN (SELECT ename, deptno FROM emp)
   LOOP
      DBMS_OUTPUT.put_line ('이름:' || v_emp.ename);

      IF v_emp.deptno = 10
      THEN
         DBMS_OUTPUT.put_line ('부서: Accounting');
      ELSIF v_emp.deptno = 20
      THEN
         DBMS_OUTPUT.put_line ('부서: Research');
      ELSIF v_emp.deptno = 30
      THEN
         DBMS_OUTPUT.put_line ('부서: Sales');
      ELSE
         DBMS_OUTPUT.put_line ('부서: 기타');
      END IF;
   END LOOP;
END;
/

-- while loop (p.572)
--while 조건식 loop
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


-- 사원이름, 매니저의 이름 출력

SELECT ename,
       mgr,
       (SELECT ename
          FROM emp
         WHERE empno = e.mgr)
          매니저
  FROM emp e;

DECLARE                                             --cursor 커서이름 is select쿼리;
   CURSOR c_emp
   IS
      SELECT *
        FROM emp
       WHERE mgr IS NOT NULL;

   v_emp   emp%ROWTYPE;                            --변수 테이블 %rowtype => 레코드 변수
   v_mgr   VARCHAR2 (50);
BEGIN
   --for 레코드 변수 in 커서 loop(커서가 오픈되어 레코드 변수에 전달됨
   FOR v_emp IN c_emp
   LOOP
      SELECT ename
        INTO v_mgr
        FROM emp
       WHERE empno = v_emp.mgr;

      DBMS_OUTPUT.put ('이름:' || v_emp.ename || ',');
      DBMS_OUTPUT.put_line ('매니저:' || v_mgr);
   END LOOP;
END;
/

--저장 프로시저(p.576)
-- stored procedure ( SP )
--create or replace procedure 프로시저이름( 매개변수 )
--is
--    변수선언
--begin
--    명령어
--end;
--/
-- 프로시저를 실행하는 방법
--exec 프로시저이름(매개변수)


DROP TABLE emp03;

CREATE TABLE emp03
AS
   SELECT * FROM emp;

-- 사번이 7369번인 사원의 급여를 10% 인상

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

--메모 추가

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

-- 메모 수정

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
-- 메모 삭제 프로시저

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

-- select 프로시저
-- 출력매개변수 out 자료형
-- sys_refcursor : select 쿼리의 실행결과를 조회하는 시스템 커서

CREATE OR REPLACE PROCEDURE memo_list (rs OUT SYS_REFCURSOR)
IS
BEGIN
   -- open 커서변수 for select쿼리;  select쿼리를 한 행씩 참조하는 커서 오픈
   OPEN rs FOR SELECT * FROM memo;
END;
/

EXECUTE memo_list;


-- 게시물 추가

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


EXEC board_insert('kim', '제목', '내용');
EXECUTE board_insert('kim', '제목', '내용');

  SELECT *
    FROM board
ORDER BY idx DESC;

COMMIT;

--저장 프로시저 목록 확인

SELECT *
  FROM user_objects
 WHERE object_type = 'PROCEDURE';

--저장 프로시저의 소스 확인

SELECT * FROM user_source;

--저장 프로시저의 장점
--간결한 코딩(복잡한 sql문장을 간결하게 함)
--db의 보안성 향상
--쿼리의 실행속도가 빠름(미리 컴파일되어 있는 쿼리)



--사용자 정의 함수(p.590)
--create or replace 함수이름(매개변수)
--is
--    변수선언
--begin
--    sql문장
--    return 리턴값;
--end;
--/

CREATE OR REPLACE FUNCTION fn_update_sal (v_empno NUMBER)
   RETURN NUMBER                                         --리턴되는 변수의 타입을 지정해야 함
IS
   v_sal   NUMBER;
BEGIN
   --update emp set sal = sal * 1.1 where empno = v_empno;
   SELECT sal
     INTO v_sal
     FROM emp
    WHERE empno = v_empno;

   RETURN v_sal;                                                      --리턴되는 값
END;
/

VAR salary NUMBER;
EXECUTE :salary := fn_update_sal(7369);
PRINT salary;

SELECT * FROM emp;

--ORA-14551: cannot perform a DML operation inside a query
--ORA-06512: at "JAVA.FN_UPDATE_SAL", line 6

SELECT fn_update_sal (7369) FROM DUAL;


-- 사원번호에 해당하는  부서이름을 리턴하는 함수

SELECT dname
  FROM emp e, dept d
 WHERE e.deptno = D.DEPTNO AND empno = 7369;

CREATE OR REPLACE FUNCTION fn_emp_dept (v_empno NUMBER)
   RETURN VARCHAR2                                                    --리턴 자료형
IS
   v_dname   VARCHAR2 (50);
BEGIN
   SELECT dname
     INTO v_dname
     FROM emp e, dept d
    WHERE e.deptno = D.DEPTNO AND empno = 7369;

   RETURN v_dname;                                              --변수에 저장된 값 리턴
END;
/


SELECT fn_emp_dept (7369) FROM DUAL;

-- 오라클의 내장함수 소스 보기

SELECT *
  FROM dba_source
 WHERE text LIKE '%NVL%';

--함수를 이용하여 부서 출력

SELECT empno, ename, fn_emp_dept (e.empno)
  FROM emp e;

-- 서브쿼리를 이용하여 부서이름 출력

SELECT empno,
       ename,
       (SELECT dname
          FROM dept
         WHERE deptno = e.deptno)
  FROM emp e;

--테이블 조인을 이용하여 부서이름 출력

SELECT empno, ename, dname
  FROM emp e, dept d
 WHERE e.deptno = d.deptno;


SELECT dname
  INTO v_dname
  FROM emp e, dept d
 WHERE e.deptno = D.DEPTNO AND empno = 7369;

--사번으로 사원의 연봉을 리턴하는 함수
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

-- 사번과 세율을 입력받아 연봉, 세액, 실수령액을 리턴하는 함수

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
         fn_emp_sal (empno) 연봉,
         fn_emp_tax (empno, 0.03) 세액,
         fn_emp_sal (empno) - fn_emp_tax (empno, 0.03) 실수령액
    FROM emp
ORDER BY 실수령액 DESC;

-- 커서(p. 593)
--암시적인 커서

DECLARE
BEGIN
   FOR v_emp IN (SELECT * FROM emp)
   LOOP
      DBMS_OUTPUT.put_line ('이름:' || v_emp.ename);
      DBMS_OUTPUT.put_line ('급여:' || v_emp.sal);
   END LOOP;
END;
/



DECLARE
   v_emp   emp%ROWTYPE;                        -- 테이블 %rowtype => 레코드를 저장하는 변수
BEGIN
   -- no data found (select 쿼리의 결과값이 없을때)
   SELECT *
     INTO v_emp
     FROM emp
    WHERE empno = 1;

   IF SQL%FOUND
   THEN
      DBMS_OUTPUT.put_line (
         '이름:' || v_emp.ename || ',급여:' || v_emp.sal);
   END IF;
EXCEPTION                                                             -- 예외 처리
   WHEN NO_DATA_FOUND
   THEN                                                                -- 예외코드
      DBMS_OUTPUT.put_line ('존재하지 않는 사원입니다');
   WHEN OTHERS
   THEN                                                                --기타 예외
      DBMS_OUTPUT.put_line ('기타 예외 발생');
END;
/

-- 암시적인 커서의 속성
--sql%found   sql문의 영향을 받는 행의 수가 1개 이상일 때
--sql%rowcount    sql문의 영향을 받는 행의 수
--sql%notfound    sql문의 영향을 받는 행의 수가 0개 일 때
--sql%isopen  암시적인 커서가 열려 있는지 여부

DECLARE
   v_count   NUMBER;
BEGIN
   SELECT COUNT (*) INTO v_count FROM emp;

   IF SQL%FOUND
   THEN                                       -- sql 문장의 영향을 받은 행의 수가 1개 이상일 때
      DBMS_OUTPUT.put_line ('행의 수 :' || v_count);
      DBMS_OUTPUT.put_line ('행의 수 :' || TO_CHAR (SQL%ROWCOUNT));
   END IF;

   IF SQL%NOTFOUND
   THEN                                                            -- 자료가 없을 때
      DBMS_OUTPUT.put_line ('not found');
   END IF;

   IF SQL%ISOPEN
   THEN                                                             --커서가 닫혀있음
      DBMS_OUTPUT.put_line ('is open');
   END IF;
END;
/



--명시적인 커서

-------커서변수 선언
--cursor 커서변수명 is select 쿼리;
------커서 오픈
--open 커서변수명;
------커서가 가르치는 한개의 레코드를 변수에 저장
--fetch 커서변수명 into 변수
------커서를 닫음
--close 커서변수명;



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



--게시물 수정

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

-- 게시물 상세 화면
--변수명 out sys_refcursor => 출력용 매개변수(커서)

CREATE OR REPLACE PROCEDURE board_detail (vidx NUMBER, rs OUT SYS_REFCURSOR)
IS
BEGIN
   UPDATE board
      SET hit = hit + 1
    WHERE idx = vidx;

   --open 커서 for select쿼리;
   OPEN rs FOR
      SELECT *
        FROM board
       WHERE idx = vidx;
END;
/

--댓글 갯수 계산

CREATE OR REPLACE PROCEDURE comment_count (vidx NUMBER, vcount OUT NUMBER)
IS
BEGIN
   SELECT COUNT (*)
     INTO vcount
     FROM board_comment
    WHERE board_idx = vidx;
END;
/


-- 댓글 목록

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

--댓글 쓰기

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

--매개변수를 사용하는 커서
--직원 이름 출력

CREATE OR REPLACE PROCEDURE emp_list_p (v_sal NUMBER)
IS
   v_ename   emp.ename%TYPE;                                          --컬럼 자료형

   --커서변수(매개변수))
   CURSOR emp_list (v_sal NUMBER)
   IS
      SELECT ename
        FROM emp
       WHERE sal > v_sal;
BEGIN
   FOR emplist IN emp_list (v_sal)
   LOOP
      DBMS_OUTPUT.put_line ('이름:' || emplist.ename);
   END LOOP;
END;
/

EXECUTE emp_list_p(3000);



--트리거(trigger)
--insert, delete, update 문장이 실행 될 때 자동으로 실행되는 프로시저
--before 트리거
-- after 트리거



--create or replace trigger 트리거이름
--before / after
--    insert or delecte or update on 테이블
--declare
--    변수선언;
--begin
--end;
--/


--테이블 복사
DROP TABLE dept03;

CREATE TABLE dept03
AS
   SELECT *
     FROM dept
    WHERE 0 = 1;

-- 트리거 작성
-- for each row : 행수준 트리거 ( 행마다 실행되는 트리거 )
-- 테이블 수준 트리거

CREATE OR REPLACE TRIGGER trigger1
   AFTER INSERT
   ON dept
   FOR EACH ROW
BEGIN
   -- :new   ,  :old  임시테이블
   INSERT INTO dept03
        VALUES (:new.deptno, :new.dname, :new.loc);
END;
/


INSERT INTO dept
     VALUES (50, '관리팀', '부산');

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
      
--사원 테이블에 insert, update, delete 가 실행될 때 평균급여를 화면에 출력
drop table emp03;
create table emp03 as select * from emp;


create or replace trigger trigger3
after insert or delete or update on emp03
declare
    v_sal number(5);
begin
    select avg(sal) into v_sal from emp03;
    dbms_output.put_line('평균급여:'||v_sal);
end;
/

select avg(sal) from emp03;


insert into emp03(empno,ename,sal) values(1,'kim',3000);
delete from emp03 where empno=7369;
update emp03 set sal= sal*1.2;

select * from emp03;


-- 테이블 스페이스의 정보 확인
select * from dba_tablespaces;
select * from user_tablespaces;

--사용자 정보
select * from dba_users;


--데이터 파일의 정보
select * from dba_data_files;


--사용자의 권한(현재 로그인중인 사용자)
select * from session_roles;;

--사용자 계정별 권한
select * from user_role_privs; -- 현재 사용자
select * from dba_role_privs order by grantee; --전체 사용자



--백업 및 복원
--백업 방법(커맨드에서 실행)
--exp 아이디/비번 file=백업할파일 full=y


-- ex) exp hr/hr file = hr.dmp

--복원방법
--imp 아이디/비번 file=복원할파일 full=y ignor=y
--ex)imp hr/hr file=hr.dmp fully=y


