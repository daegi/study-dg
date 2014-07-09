CREATE TABLE notice
(
   num        NUMBER,
   userId     VARCHAR2 (100),
   subject    VARCHAR2 (100),
   content    VARCHAR2 (4000),
   hitCount   NUMBER DEFAULT 0,
   created    DATE DEFAULT SYSDATE,
   CONSTRAINT pk_notice_num PRIMARY KEY (num),
   CONSTRAINT fk_notice_userId FOREIGN KEY
      (userId)
       REFERENCES join_basic (userId) ON DELETE CASCADE
);

select * from tab;


create SEQUENCE seq_notice;



insert into notice(num, userId, subject, content, hitCount, created) 
values(seq_bbs.NEXTVAL,?,?,?,0,TO_CHAR(b.created, 'yyyy-mm-dd') as created);

