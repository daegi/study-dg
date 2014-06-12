/* Formatted on 2014/06/12 오후 12:13:55 (QP5 v5.256.13226.35510) */
DROP TABLE MEMBER;

CREATE TABLE MEMBER
(
   userid      VARCHAR2 (50) NOT NULL PRIMARY KEY,
   passwd      VARCHAR2 (50) NOT NULL,
   name        VARCHAR2 (50) NOT NULL,
   email       VARCHAR2 (50),
   hp          VARCHAR2 (50),
   zipcode     VARCHAR2 (7),
   address1    VARCHAR2 (50),
   address2    VARCHAR2 (50),
   join_date   DATE DEFAULT SYSDATE
);


INSERT INTO MEMBER (userid,
                    passwd,
                    name,
                    email,
                    hp,
                    zipcode,
                    address1,
                    address2)
     VALUES ('kim',
             '1234',
             '김민수',
             'kim@d.com',
             '010-0000-0000',
             '157-911',
             '서울 강서구 화곡동',
             '12번지');

SELECT * FROM MEMBER;

commit;


select * from zipcode;


select * from zipcode where dong like '역삼%'; 













