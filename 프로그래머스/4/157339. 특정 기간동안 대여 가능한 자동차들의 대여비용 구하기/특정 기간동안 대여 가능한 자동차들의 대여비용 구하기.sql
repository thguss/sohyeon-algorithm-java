# select distinct(A.car_id), A.car_type, ((A.daily_fee * 30) * (100 - C.discount_rate) / 100) as fee
# from car_rental_company_car A
#     inner join car_rental_company_rental_history B on A.car_id = B.car_id
#     inner join car_rental_company_discount_plan C on A.car_type = C.car_type
# where (A.car_type like '세단' or A.car_type = 'SUV')
#     and not (B.start_date like '2022-11%' 
#              or B.end_date like '2022-11%' 
#              or (B.start_date < '2022-11-01' and B.end_date > '2022-11-30')
#             )
#     and C.duration_type like '30일 이상'
#     and ((A.daily_fee * 30) * (100 - C.discount_rate) / 100) between 500000 and 2000000
# order by fee desc, A.car_type, A.car_id desc

SELECT DISTINCT(A.CAR_ID), A.CAR_TYPE, ROUND(A.DAILY_FEE * 30 * (100 - C.DISCOUNT_RATE) / 100) AS FEE
FROM CAR_RENTAL_COMPANY_CAR A
JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY B ON A.CAR_ID = B.CAR_ID
JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN C ON A.CAR_TYPE = C.CAR_TYPE
WHERE A.CAR_ID NOT IN (
    SELECT CAR_ID
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE START_DATE BETWEEN '2022-11-01' AND '2022-11-30'
    OR END_DATE BETWEEN '2022-11-01' AND '2022-11-30'
    OR (START_DATE < '2022-11-01' AND END_DATE > '2022-11-30')
)
AND A.CAR_TYPE IN ('세단', 'SUV')
AND ROUND(A.DAILY_FEE * 30 * (100 - C.DISCOUNT_RATE) / 100) BETWEEN 500000 AND 2000000
AND C.DURATION_TYPE = '30일 이상'
ORDER BY FEE DESC, A.CAR_TYPE, A.CAR_ID