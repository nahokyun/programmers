-- 코드를 입력하세요
SELECT category, sum(sales) total_sales
from book join (select *
               from book_sales
               where to_char(sales_date,'YYYY-MM')='2022-01') bs
on book.book_id=bs.book_id
group by category
order by category