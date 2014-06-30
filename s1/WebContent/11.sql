
--멤버테이블 작성
DROP TABLE join_detail PURGE;
DROP TABLE join_basic PURGE;

CREATE TABLE join_basic (
     userId      VARCHAR2(50) NOT NULL
     ,userName VARCHAR2(50) NOT NULL
     ,userPwd   VARCHAR2(100) NOT NULL
     ,enabled    NUMBER(1) DEFAULT 1
     ,created_date    DATE DEFAULT SYSDATE
     ,modify_date     DATE DEFAULT SYSDATE
     ,CONSTRAINT pk_join_basic_userId PRIMARY KEY(userId)
);

CREATE TABLE join_detail (
     userId      VARCHAR2(50) NOT NULL
     ,birth        DATE
     ,email       VARCHAR2(50)
     ,tel          VARCHAR2(15)
     ,question  VARCHAR2(50)
     ,answer    VARCHAR2(50)
     ,job         VARCHAR2(50)
     ,zip          VARCHAR2(7)
     ,addr1      VARCHAR2(50)
     ,addr2      VARCHAR2(50)
     ,CONSTRAINT pk_join_detail_userId PRIMARY KEY(userId)
     ,CONSTRAINT fk_join_detail_userId FOREIGN KEY(userId)
                  REFERENCES join_basic(userId) ON DELETE CASCADE
);


update member set email=?,tel=?,question=?, zip=? ,addr1=?,addr2=? where userId=? 

,userPwd


email       VARCHAR2(50)
     ,tel          VARCHAR2(15)
     ,question  VARCHAR2(50)
     ,answer    VARCHAR2(50)
     ,job         VARCHAR2(50)
     ,zip          VARCHAR2(7)
     ,addr1      VARCHAR2(50)
     ,addr2   


CREATE TABLE post (
	seq  NUMBER  NOT NULL
	,zipcode  VARCHAR2(10)
	,sido  VARCHAR2(50)
	,gugun  VARCHAR2(100)
	,dong  VARCHAR2(100)
	,bunji  VARCHAR2(50)
        ,PRIMARY KEY (seq)
);





