select A.product_code, (A.price * SUM(B.sales_amount)) as sales
from product A inner join offline_sale B on A.product_id = B.product_id
group by A.product_code
order by sales desc, A.product_code