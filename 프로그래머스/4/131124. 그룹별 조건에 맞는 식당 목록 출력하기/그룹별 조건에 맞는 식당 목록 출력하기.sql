select A.member_name, B.review_text, date_format(B.review_date, '%Y-%m-%d') as review_date
from member_profile A inner join rest_review B on A.member_id = B.member_id
where A.member_id in (
    select B.member_id
    from member_profile A inner join rest_review B on A.member_id = B.member_id
    group by B.member_id
    having count(*) = (
        select count(*)
        from member_profile A inner join rest_review B on A.member_id = B.member_id
        group by B.member_id
        order by count(*) desc
        limit 1
    )
)
order by review_date, B.review_text

