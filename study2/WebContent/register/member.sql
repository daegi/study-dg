CREATE TABLE MEMBER
(
   userid     VARCHAR2 (50) NOT NULL,
   userpwd    VARCHAR2 (50) NOT NULL,
   username   VARCHAR2 (50) NOT NULL,
   birth      DATE NOT NULL,
   email      VARCHAR2 (50) NOT NULL,
   tel        VARCHAR2 (50) NOT NULL,
   question   VARCHAR2 (50) NOT NULL,
   answer     VARCHAR2 (50) NOT NULL,
   addr1      VARCHAR2 (50) NOT NULL,
   addr2      VARCHAR2 (50) NOT NULL,
   PRIMARY KEY (userid)
);


INSERT INTO MEMBER (userid,
                    userpwd,
                    username,
                    birth,
                    email,
                    tel,
                    question,
                    answer,
                    addr1,
                    addr2)
     VALUES ('chodg',
             '77914444',
             '아몰라',
             '19820703',
             'chodg@naver.com',
             '01077914444',
             '질문',
             '답변',
             '주소1',
             '주소2');

             
CREATE OR REPLACE PROCEDURE member_insert (v_userid     IN VARCHAR2,
                                           v_userpwd    IN VARCHAR2,
                                           v_username   IN VARCHAR2,
                                           v_birth      IN DATE,
                                           v_email      IN VARCHAR2,
                                           v_tel        IN VARCHAR2,
                                           v_question   IN VARCHAR2,
                                           v_answer     IN VARCHAR2,
                                           v_addr1      IN VARCHAR2,
                                           v_addr2      IN VARCHAR2)
IS
BEGIN
   INSERT INTO MEMBER (userid,
                       userpwd,
                       username,
                       birth,
                       email,
                       tel,
                       question,
                       answer,
                       addr1,
                       addr2)
        VALUES (v_userid,
                v_userpwd,
                v_username,
                v_birth,
                v_email,
                v_tel,
                v_question,
                v_answer,
                v_addr1,
                v_addr2);
END;
/

select * from tab;