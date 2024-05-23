select A.flavor
from FIRST_HALF A inner join (
    select flavor, SUM(TOTAL_ORDER) as TOTAL_ORDER_SUM
    from JULY
    group by flavor
) B on A.flavor = B.flavor
order by (A.total_order + B.total_order_sum) desc
limit 3