-- 코드를 입력하세요
SELECT b.author_id, a.author_name, b.category, sum(bs.sales*b.price) as total_sales
from book as b join author as a join book_sales as bs
on b.author_id=a.author_id and b.book_id=bs.book_id
where MONTH(bs.sales_date)=1 and year(bs.sales_date)=2022
group by b.author_id , category
order by b.author_id , b.category desc