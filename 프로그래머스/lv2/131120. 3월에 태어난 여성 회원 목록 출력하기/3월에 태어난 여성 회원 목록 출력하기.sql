-- 코드를 입력하세요
SELECT MEMBER_ID, MEMBER_NAME, GENDER, date_format(DATE_OF_BIRTH,'%Y-%m-%d') as DATE_OF_BIRTH
FROM MEMBER_PROFILE
where TLNO is not null and month(date_of_birth)=3 and GENDER='W'
order by MEMBER_ID