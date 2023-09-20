-- 코드를 입력하세요
SELECT  b1.CATEGORY	, sum(b2.SALES) as TOTAL_SALES
from BOOK b1
left join BOOK_SALES b2 on b1.BOOK_ID =b2.BOOK_ID
where DATE_FORMAT(b2.SALES_DATE,"%Y-%m") = "2022-01"
group by b1.CATEGORY
order by b1.CATEGORY;
