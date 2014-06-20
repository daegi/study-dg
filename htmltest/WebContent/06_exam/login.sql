/* Formatted on 2014/06/18 오전 10:33:47 (QP5 v5.256.13226.35510) */
--키워드 검색 테이블

CREATE TABLE keywords (keyword VARCHAR2 (100));

--샘플 자료 입력

INSERT INTO keywords
     VALUES ('자바1');

INSERT INTO keywords
     VALUES ('자바2');

INSERT INTO keywords
     VALUES ('자바3');

INSERT INTO keywords
     VALUES ('java1');

INSERT INTO keywords
     VALUES ('java2');

INSERT INTO keywords
     VALUES ('java3');

INSERT INTO keywords
     VALUES ('jsp1');

INSERT INTO keywords
     VALUES ('jsp2');

INSERT INTO keywords
     VALUES ('jsp3');

INSERT INTO keywords
     VALUES ('android1');

INSERT INTO keywords
     VALUES ('android2');

INSERT INTO keywords
     VALUES ('android3');

SELECT * FROM keywords;


SELECT *
  FROM keywords
 WHERE keyword LIKE 'j%';

COMMIT;