-- 코드를 입력하세요
SELECT left(PRODUCT_CODE,2) as CATEGORY	, count(left(PRODUCT_ID,2)) as PRODUCTS
from PRODUCT
group by CATEGORY
order by CATEGORY;