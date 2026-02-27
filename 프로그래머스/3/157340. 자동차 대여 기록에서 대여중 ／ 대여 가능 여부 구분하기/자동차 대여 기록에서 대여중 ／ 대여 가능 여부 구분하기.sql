# SELECT CAR_ID, 
# CASE 
#     WHEN CAR_ID in (SELECT CAR_ID
#                     FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
#                     WHERE END_DATE >= '2022-10-16'
#                     AND HISTORY_ID in (SELECT MAX(HISTORY_ID) 
#                                        FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
#                                        GROUP BY CAR_ID)
#                    ) THEN '대여중'
#     ELSE '대여 가능'
# END 'AVAILABILITY'
# FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
# GROUP BY CAR_ID
# ORDER BY CAR_ID desc;


# SELECT CAR_ID
# FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
# WHERE CAR_ID in (SELECT CAR_ID
#                     FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
#                     WHERE END_DATE >= '2022-10-16'
#                     AND HISTORY_ID in (SELECT MAX(HISTORY_ID) 
#                                         FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
#                                         GROUP BY CAR_ID)
# ORDER BY CAR_ID desc;
                 
                 
                 
SELECT CAR_ID, 
CASE 
    WHEN CAR_ID in (SELECT CAR_ID
                    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
                    WHERE '2022-10-16' BETWEEN START_DATE AND END_DATE )
                    THEN '대여중'
    ELSE '대여 가능'
END as AVAILABILITY
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
GROUP BY CAR_ID
ORDER BY CAR_ID desc;


