-- 코드를 입력하세요
SELECT ANIMAL_ID id, NAME 
from ANIMAL_INS
where INTAKE_CONDITION <> "Aged"
order by id;
