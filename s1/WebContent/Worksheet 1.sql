DROP TABLE pds PURGE;

SELECT * FROM tab;


SELECT * FROM pds;

DROP TABLE pds PURGE;

CREATE TABLE pds
(
   num                NUMBER PRIMARY KEY,
   userId             VARCHAR2 (20) NOT NULL,
   category           VARCHAR2 (255) NOT NULL,
   gubun              VARCHAR2 (255) NOT NULL,
   os                 VARCHAR2 (255) NOT NULL,
   subject            VARCHAR2 (255) NOT NULL,
   content            VARCHAR2 (4000) NOT NULL,
   imageFileName      VARCHAR2 (255) NOT NULL,
   saveFileName       VARCHAR2 (255) NOT NULL,
   originalFileName   VARCHAR2 (255) NOT NULL,
   fileSize           NUMBER,
   created            DATE DEFAULT SYSDATE,
   downCount          NUMBER DEFAULT 0,
   CONSTRAINT fk_pds_userId FOREIGN KEY
      (userId)
       REFERENCES join_basic (userId)
);

SELECT * FROM tab;


CREATE SEQUENCE seq_pds;

SELECT * FROM seq;
