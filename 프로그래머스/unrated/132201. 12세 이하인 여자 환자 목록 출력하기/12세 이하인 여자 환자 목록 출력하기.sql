-- 코드를 입력하세요
SELECT PT_NAME, PT_NO, GEND_CD, AGE, ifnull(TLNO,'NONE') as TLNO 
from patient
where Age<13 and gend_CD='W'
order by age desc, pt_name asc