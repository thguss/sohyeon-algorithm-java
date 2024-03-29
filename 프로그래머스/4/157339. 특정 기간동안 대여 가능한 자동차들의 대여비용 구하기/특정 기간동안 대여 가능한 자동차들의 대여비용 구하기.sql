-- 코드를 입력하세요
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