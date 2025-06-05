-- 코드를 입력하세요

SELECT b.time, nvl(count(animal_id),0) count
from animal_outs ao right join(SELECT LEVEL-1 TIME 
    FROM DUAL 
    CONNECT BY LEVEL-1 < 24) b
    on b.time= extract(hour from cast(ao.datetime as timestamp))
group by b.time
order by b.time

