-- 코드를 입력하세요
select ugu.user_id, ugu.nickname, ugb.total_sales
from used_goods_user ugu join (SELECT writer_id, sum(price) as total_sales
    from (select * from used_goods_board where status='DONE') ugb
    group by writer_id
    having sum(price)>=700000) ugb
on ugu.user_id=ugb.writer_id
order by ugb.total_sales
