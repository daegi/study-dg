drop table zipcode;

CREATE TABLE ZIPCODE (
	ZIPCODE	VARCHAR2(7),
	SIDO	VARCHAR2(50),
	GUGUN	VARCHAR2(50),
	DONG	VARCHAR2(52),
	BUNJI	VARCHAR2(50)
	);

-- 동면리로 검색
select * from zipcode 
where dong like '창동%';
-- 시도
--distinct 중복값 제거
select distinct sido 
from zipcode
order by sido;
-- 서울시의 모든 구
select distinct gugun 
from zipcode
where sido='서울'
order by gugun;
-- 서울 종로구의 모든 동
select distinct dong from zipcode
where sido='서울' and gugun='종로구'
order by dong;

	
	
	
	
	
	
	
	
	
	
	
	
