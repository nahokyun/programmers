-- 코드를 입력하세요
select flavor
from(
select fh.ss+j.s t, fh.flavor
from
(select sum(total_order) ss, flavor
from first_half
group by flavor
 ) fh
 join (select sum(total_order) s, flavor
from july 
group by flavor) j
on fh.flavor=j.flavor
order by t desc
)
where rownum<4

