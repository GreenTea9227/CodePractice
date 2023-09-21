-- 코드를 입력하세요
SET @TOTAL = (
    SELECT COUNT(*)
    FROM USER_INFO U
    WHERE YEAR(U.JOINED) = 2021 
);

SELECT YEAR(SALES_DATE) AS YEAR,MONTH(SALES_DATE) AS MONTH,COUNT(DISTINCT USER_ID) AS PUCHASED_USERS, ROUND(COUNT(DISTINCT USER_ID) / @TOTAL,1) AS PUCHASED_RATIO
FROM ONLINE_SALE 
WHERE USER_ID IN (
    SELECT USER_ID
    FROM USER_INFO 
    WHERE YEAR(JOINED) = 2021
)
GROUP BY  YEAR, MONTH
ORDER BY YEAR, MONTH;

