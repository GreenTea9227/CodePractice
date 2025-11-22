-- 코드를 작성해주세요
with recursive cte as (
    select id,parent_id,1 as level
    from ECOLI_DATA
    where PARENT_ID is null
    union
    select e.id, e.parent_id, level + 1
    from ECOLI_DATA e
    join cte c on e.parent_id = c.id
)
select id
from cte
where level = 3
order by id;