select b.flavor
from first_half a join (
    select flavor, sum(total_order) as total_order
    from july
    group by flavor
) b on a.flavor = b.flavor
order by (a.total_order + b.total_order) desc
limit 3
