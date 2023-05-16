-- 코드를 입력하세요
SELECT ingredient_type, sum(total_order) as total_order
from first_half left join icecream_info
on first_half.flavor=icecream_info.flavor
group by ingredient_type