-- p. 테이블 구조 변경(9장)
-- sqlplus에서 실행( rowid 확인 )
-- rownum - 일련번호
-- rowid - 레코드의 주소값
select rowid, rownum, empno, ename from emp;
-- 게시판 테이블
drop table board;
create table board (
idx number not null,                -- 게시물 번호
name varchar2(50) not null,        -- 이름
subject varchar2(100) not null,     -- 제목
content varchar2(2000) not null,   -- 내용
hit number default 0,                      -- 조회수
post_date date default sysdate,    -- 작성날짜
primary key(idx)
);

--테스트 레코드 입력
delete from board;
commit;
-- 일련번호 계산
insert into board (idx,name,subject,content) values (1, 'kim', '제목', '내용');
select max(idx)+1 from board;
-- nvl ( A, B ) A가 null 이면 B
select nvl( max(idx)+1, 1 ) from board;


-- PL/SQL 
declare  -- 선언문
    i number := 1;   -- 변수명  자료형   :=   값;  
begin
    while i <= 100000 loop
        insert into board (idx, name, subject, content ) values
        ( (select nvl(max(idx)+1,1) from board), 'kim'||i,
            '제목'||i, '내용'||i );
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
-- 1페이지 출력
select rownum, idx, name, subject, hit, post_date
from board
where rownum <= 10
order by idx desc;
-- rownum < 숫자 (사용가능)
-- rownum > 숫자 (사용불가능) 
--페이지 나누기를 위한 select 명령어
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

--조회수 증가 처리
select * from board where idx=100000;
-- update 테이블 set 컬럼=값 where 컬럼=값;
update board set hit=hit+1 where idx=100000;
commit; 

--댓글 테이블 작성
create table board_comment (
idx number not null,                -- 댓글 일련번호
board_idx number not null,        -- 게시물번호(부모글번호)
name varchar2(100) not null,
content varchar2(1000) not null,
post_date date default sysdate,
primary key( idx )
);
-- 100000번 게시물에 댓글 추가
insert into board_comment ( idx, board_idx, name, content ) values
( (select nvl(max(idx)+1,1) from board_comment)
    , 100000,'park', '첫번째 댓글');

select * from board_comment;
commit;

-- 게시물마다 댓글이 몇개 있는지 출력
select * from board 
order by idx desc;


--업로드 : team - commit
--다운로드 : team - update to head ( 최신버전 )
--    team - update to version ( 특정한 버전 )

-- p.264 
create table emp01(
empno number(4),
ename varchar2(20),
sal number(7,2)  -- 정수 7자리, 소수 2자리 
);
-- int 정수만 입력 => number(38)
-- desc 테이블이름 => 테이블의 정보 확인
desc emp01;
-- 서브쿼리를 이용한 테이블 생성
-- create table 테이블이름 as select쿼리;
-- 테이블 구조 + 데이터 복사
create table emp02
as select * from emp;

select * from emp02;

create table emp03 
as select * from emp where deptno=30;

select * from emp03;

-- 테이블의 구조만 복사할 경우
create table emp04
as select * from emp where 0=1;

select * from emp04;

-- create table 테이블 만들기
-- alter table 테이블 수정
-- drop table 테이블 삭제 

-- 테이블의 구조 변경
-- 컬럼 추가 : alter table 테이블이름 add ( 컬럼이름 자료형(사이즈) );
alter table emp01 add ( job varchar2(9) );

desc emp01;

-- dept02 테이블을 만들고(dept 테이블 복사)
-- 부서장(dmgr) 컬럼 추가( varchar2(10 )
create table dept02
as select * from dept;

alter table dept02 add ( dmgr varchar2(10) );

select * from dept02;

-- 컬럼 속성 변경
-- alter table 테이블이름 modify ( 컬럼이름 자료형(사이즈) );
-- dmgr 컬럼의 사이즈를 50바이트로 변경
alter table dept02 modify ( dmgr varchar2(50) );
desc dept02;
-- emp01 테이블의 job 컬럼의 사이즈를 30바이트로 변경
alter table emp01 modify ( job varchar2(30) );
-- dept02 테이블의 dmgr 컬럼을 숫자 타입(숫자 4자리)으로 변경
alter table dept02 modify ( dmgr number(4) );
-- 컬럼 삭제
-- alter table 테이블이름 drop column 컬럼이름;
-- emp01 테이블의 job 컬럼 삭제
alter table emp01 drop column job;
desc emp01;
-- 테이블 삭제(p.277)
-- drop table 테이블이름;
drop table emp01;
-- 테이블 목록 확인
select * from tab;
-- 테이블 이름 변경(p.281)
-- rename A to B  : A를 B로 변경
rename emp02 to test;
select * from test02;
desc test;
 
desc tab;
-- 데이터 사전(p.282)
-- user_    사용자가 생성한 객체들
-- all_      사용자가 생성했거나 권한을 부여받은 객체들
-- dba_    모든 객체들

-- 뷰(view)
create or replace view emp_v
as
select empno, ename, dname
from emp e, dept d
where e.deptno=d.deptno; 

select * from emp_v;
select * from (select empno, ename, dname
from emp e, dept d
where e.deptno=d.deptno);
-- 테이블, 뷰 목록 확인
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







 



