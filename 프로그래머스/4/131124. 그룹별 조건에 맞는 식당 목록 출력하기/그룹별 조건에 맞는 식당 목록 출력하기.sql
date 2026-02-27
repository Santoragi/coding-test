SELECT rt.MEMBER_NAME, rr.REVIEW_TEXT,
        date_format(rr.REVIEW_DATE, '%Y-%m-%d') as REVIEW_DATE
FROM (SELECT r.MEMBER_ID, m.MEMBER_NAME,
            RANK() OVER (ORDER BY COUNT(r.REVIEW_ID) desc) as ran
            FROM MEMBER_PROFILE as m
            INNER JOIN REST_REVIEW as r
            ON m.MEMBER_ID = r.MEMBER_ID
            GROUP BY r.MEMBER_ID) as rt
INNER JOIN REST_REVIEW as rr
ON rr.MEMBER_ID = rt.MEMBER_ID
AND rt.ran = 1
ORDER BY rr.REVIEW_DATE, rr.REVIEW_TEXT;
