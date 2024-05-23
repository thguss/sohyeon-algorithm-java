# select A.product_id, B.product_name, (A.price * sum(B.amount)) as total_sales
# from FOOD_PRODUCT A inner join FOOD_ORDER B on A.product_id = B.product_id
# where B.produce_date like '2022-05%'
# group by A.product_id


select A.product_id, A.product_name, (A.price * total_sum) as total_sales
from FOOD_PRODUCT A inner join (
    select product_id, SUM(amount) as total_sum
    from FOOD_ORDER
    where produce_date like '2022-05%'
    group by product_id
) B on A.product_id = B.product_id
order by total_sales desc, A.product_id

