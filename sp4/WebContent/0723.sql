DROP TABLE bbs PURGE;
DROP SEQUENCE seq_bbs;

SELECT * FROM tab;

SELECT * FROM seq;

SELECT *
  FROM col
 WHERE tname = 'bbs';

CREATE TABLE bbs
(
   num        NUMBER,
   name       VARCHAR2 (20) NOT NULL,
   subject    VARCHAR2 (1000) NOT NULL,
   content    VARCHAR2 (4000) NOT NULL,
   pwd        VARCHAR2 (50),
   ipAddr     VARCHAR2 (50),
   hitCount   NUMBER DEFAULT 0,
   created    DATE DEFAULT SYSDATE,
   CONSTRAINT pk_bbs_num PRIMARY KEY (num)
);

CREATE SEQUENCE seq_bbs;


SELECT *
    FROM (SELECT ROW_NUMBER () OVER (ORDER BY num DESC) rnum,
                 name,
                 subject,
                 content,
                 pwd,
                 ipAddr,
                 hitCount,
                 TO_CHAR (created, 'yyyy-MM-dd') AS created
            FROM bbs) bbs
   WHERE rnum >= 1 AND rnum <= 2
ORDER BY rnum DESC;