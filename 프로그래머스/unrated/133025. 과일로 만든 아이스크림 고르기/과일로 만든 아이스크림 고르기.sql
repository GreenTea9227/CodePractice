-- 코드를 입력하세요
SELECT i.FLAVOR
FROM ICECREAM_INFO i join FIRST_HALF f
on i.FLAVOR = f.FLAVOR
where i.INGREDIENT_TYPE = "fruit_based" and f.TOTAL_ORDER > 3000
order by f.TOTAL_ORDER desc;
