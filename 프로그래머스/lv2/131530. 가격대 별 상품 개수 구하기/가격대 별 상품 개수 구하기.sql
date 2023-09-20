-- 코드를 입력하세요
SELECT 
        case
            when PRICE <10000 then 0
            else truncate(PRICE,-4)
        end as PRICE_GROUP, COUNT(PRODUCT_ID) AS PRODUCTS
from PRODUCT
GROUP BY PRICE_GROUP
ORDER BY PRICE_GROUP;






