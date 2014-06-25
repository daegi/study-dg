select * from tab;

CREATE TABLE bbs (
   num NUMBER NOT null,
   name varchar2(50) not null,
   subject varchar2(100)not null,
   content varchar2(4000)    not null,
   pwd varchar2(50),
   hitCount number,
   created DATE DEFAULT SYSDATE,
   CONSTRAINT pk_bbs_num PRIMARY KEY(num)
)


insert into bbs values(seq_bbs.nextval,'12','24','3','2','56',sysdate,'234');



select num, subject from bbs

select num, subject from bbs order by num desc;

select rownum, num, subject from bbs;

--rownum ; order by 절이 있거나 where 절에서 사용하면 이상한 현상이 일어남
select rownum, num, subject from bbs order by num desc

--순위 추출
select * from(
	select 
	row_number() over(order by num desc) 
	rnum, num, subject from bbs)
	where rnum >= 5 and rnum <= 10 order by num desc;

create sequence seq_bbs
   

select * from seq
select * from tab;
select * from col;

alter table bbs add(ipAddr varchar2(50))

select * from col where tname='bbs';


select * from bbs;



create table guest(
num number not null,
name varchar2(50) not null,
content varchar2(4000) not null,
pwd varchar2(50),
created date deaault sysdate,
constraint pk_bbs_num primary key(num)

);

create sequence seq_guest;






