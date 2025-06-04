-- 코드를 입력하세요
SELECT fp.category, fp2.m max_price, fp.product_name
from food_product fp join 
    (select max(price) as m, category 
    from food_product
    group by category) fp2
on fp2.category=fp.category and fp2.m=fp.price
where fp.category='국'or fp.category='과자'or fp.category='김치'or fp.category='식용유'
order by max_price desc
