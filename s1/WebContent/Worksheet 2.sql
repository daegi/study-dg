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


CREATE SEQUENCE seq_notice;
