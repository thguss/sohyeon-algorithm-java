-- 코드를 입력하세요
SELECT A.book_id, B.author_name, date_format(A.published_date, '%Y-%m-%d') as published_date
from book A join author B on A.author_id = B.author_id
where A.category = '경제'
order by A.published_date