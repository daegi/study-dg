--p.134  가상테이블 dual
-- sysdate   시스템의 현재 날짜/시각
select sysdate from dual;
select sysdate from member;
select sysdate;  -- from절이 없으므로 에러 발생
desc dual;
select * from dual;
-- 반올림, 버림, 올림 함수
-- round 반올림, floor 버림, ceil 올림
select 10.5 , round(10.5), floor(10.5), ceil(10.1) from dual;
-- 대문자로 변환 : upper(), 소문자로 변환 lower()
select 'Welcome', upper('Welcome'), lower('Welcome') from dual;
-- 단어의 첫글자만 대문자로 변환 : initcap()
select 'Welcome to oracle', initcap('Welcome to oracle') from dual;
-- 문자열 추출 substr( '문자열', start, length )
select substr('Welcome to oracle', 4,3) from dual;
-- 801231-1234567  에서 생년, 나이 출력
select 
substr('801231-1234567',1,2) 생년
, 2014 - ( substr('801231-1234567',1,2) + 1900) 나이
from dual;
-- 82년도에 입사한 직원
select * from emp;
-- 컬럼 between A and B : 컬럼의 값이 A~B
select * from emp where hiredate between '1982-01-01' and '1982-12-31';
select * from emp where substr(hiredate,1,2) = '14';
insert into emp (empno, ename, hiredate) values (4, 'choi', '1914-08-01');
insert into emp (empno, ename, hiredate) values (5, 'park', sysdate);
select * from emp where substr(hiredate,1,2) = '14';
-- to_char( 날짜, 출력형식 ) 날짜를 문자열로 변환
-- 출력형식은 p.168 참조
select * from emp where to_char(hiredate,'yyyy') = '2014'; --4자리 연도
select * from emp where to_char(hiredate,'yyyy') = '1914';
select * from emp where to_char(hiredate,'yy') = '14'; -- 2자리 연도
select  * from emp;
-- 이름이 'N'으로 끝나는 사원
-- -1 뒤에서 첫번째 글자 
select * from emp where substr(ename,-1,1) = 'N'; 
-- p.154  LPAD, RPAD 좌우측 공백을 채우는 함수
select lpad( 'Oracle', 20, '$') from dual;
select rpad( 'Oracle', 20, '#') from dual;
-- LTRIM, RTRIM 좌우측 공백 제거
select ltrim('      Oracle'), rtrim( 'Oracle     ') from dual;
-- length(문자열) : 문자열의 길이
select 
    length('   Oracle'), length(ltrim('    Oracle')), length(rtrim( 'Oracle    ')) 
from dual;
-- p.158 날짜 연산 
select sysdate , sysdate + 11, sysdate - 10 from dual;
-- p.162   months_between( 날짜1, 날짜2 )  두 날짜간의 개월수
-- 입사한지 몇개월 되었는지 계산( 반올림 )
-- round( 숫자, 소수이하자리수 ) 
select ename, hiredate
, round(months_between( sysdate, hiredate ), 1) from emp;
-- 근무일수(반올림), 근무연수(반올림)
select 
ename, round(sysdate-hiredate,1) 근무일수
, round((sysdate-hiredate)/365,1) 근무연수
from emp;
-- p.168 to_char( 날짜 or 숫자, 출력형식 )    문자열로 변환
-- to_date( 문자열 )  : 날짜로 변환
-- to_number ( 문자열 ) : 숫자로 변환
-- day : 요일, hh24 24시간제, hh 12시간제 
select sysdate, to_char(sysdate, 'yyyy/mm/dd day hh24:mi:ss') 날짜 
from dual;
-- 사원이름, 입사일자 출력( 연도4자리, 월, 일, 요일 )
-- mon - 월(문자), dy 요일약자
select ename, to_char( hiredate, 'yyyy/mon/dd dy') from emp;
-- 사원이름, 월급, 연봉 출력
-- nvl(A, B) A가 null이면 B
select ename, sal, sal*12 + nvl(comm,0) 연봉 from emp;
-- to_char(숫자, '999,999') 천단위 컴머
-- to_char(숫자, 'L999,999') 천단위 컴머(국가별 화폐단위 표시)
select ename, to_char(sal,'L999,999')
, to_char( sal*12 + nvl(comm,0), 'L999,999') 연봉 from emp;
-- to_date(문자)  날짜로 변환
select * from emp where hiredate = '80-12-17';
select * from emp where hiredate = to_date('19801217', 'yyyy-mm-dd');
-- to_number  숫자로 변환
select '200' - 100 from dual;
select to_number('200') - 100 from dual;
--p.177   
-- decode( 표현식, 조건1, 결과1, 조건2, 결과2, 조건3, 결과3, 디폴트결과)
-- decode( 점수, 90점대, A, 80점대, B, 70점대, C, 60점대, D, F )
-- 부서코드 10 =>  ACCOUNTING, 20 => RESEARCH, 30=>SALES
select * from dept;
-- 이름, 부서코드, 부서명 
select ename, deptno
, decode( deptno, 10, 'ACCOUNTING', 20, 'RESEARCH', 30,'SALES','기타')
from emp;
-- decode 함수 : 같으냐, 같지 않으냐만 비교 가능
-- 부서코드 10 =>  ACCOUNTING, 20 => RESEARCH, 30=>SALES, 기타
-- case when 조건1 then 결과1
--        when 조건2 then 결과2
--        when 조건3 then 결과3
--        else  디폴트결과
-- end 
select ename, deptno
, case when deptno=10 then 'ACCOUNTING'
        when deptno=20 then 'RESEARCH'
        when deptno=30 then 'SALES'
        else '기타'
  end 부서명
from emp;      
-- 4000 초과 '고액연봉자',  3000~4000 '평균연봉자', 그외에는 '기본연봉자'
select * from emp order by sal desc;
select ename, sal
, case when sal > 4000 then '고액연봉자'
        when sal between 3000 and 4000 then '평균연봉자'
        else '기본연봉자'
  end 연봉수준
from emp;

-- 한줄메모장 테이블
create table memo (
idx int not null,       -- 게시물번호 
writer varchar2(50) not null,
memo varchar2(500) not null,
post_date date default sysdate, -- 작성일자는 기본값으로 현재 날짜로 입력
primary key(idx) 
);
insert into memo (idx,writer,memo) values (1, 'kim', '메모 연습');
select * from memo;
commit;