-- 코드를 입력하세요
SELECT Extract(year from os.sales_date) year, Extract(month from os.sales_date) month, ui.gender, count(distinct ui.user_id) users
from user_info ui join online_sale os
on ui.user_id=os.user_id
group by Extract(year from os.sales_date),Extract(month from os.sales_date), ui.gender
having ui.gender is not null
order by year, month, gender