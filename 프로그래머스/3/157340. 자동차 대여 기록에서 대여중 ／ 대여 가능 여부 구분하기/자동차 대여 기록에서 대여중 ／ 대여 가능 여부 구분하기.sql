-- 코드를 입력하세요
SELECT car_id, case when car_id in (select car_id
                              from CAR_RENTAL_COMPANY_RENTAL_HISTORY
                              where start_date<=to_date('2022-10-16','YYYY-MM-DD') and end_date>=to_date('2022-10-16','YYYY-MM-DD')) 
    then '대여중'
    else '대여 가능'
    end availability
from CAR_RENTAL_COMPANY_RENTAL_HISTORY cr
group by car_id
order by car_id desc