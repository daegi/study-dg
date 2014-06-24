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