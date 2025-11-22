-- 코드를 작성해주세요

with cte as (
    select ID, ntile(4) over(order by SIZE_OF_COLONY desc) as level
    from ECOLI_DATA
)
select ID, case level
            when 1 then 'CRITICAL'
            when 2 then 'HIGH'
            when 3 then 'MEDIUM'
            ELSE 'LOW'
        end as 'COLONY_NAME'
from cte
order by ID;