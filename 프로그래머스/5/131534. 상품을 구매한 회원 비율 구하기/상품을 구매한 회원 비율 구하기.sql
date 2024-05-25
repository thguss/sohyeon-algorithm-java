select date_format(B.sales_date, '%Y') as year,
    date_format(B.sales_date, '%m') as month,
    count(distinct(A.user_id)) as puchased_users,
    round(count(distinct(A.user_id)) / (select count(*)
                                        from user_info
                                        where joined like '2021%'), 1) as puchased_ratio
from user_info A inner join online_sale B on A.user_id = B.user_id
where A.joined like '2021%'
group by year, month
order by year, month