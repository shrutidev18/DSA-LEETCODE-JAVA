# Write your MySQL query statement below
SELECT id, visit_date, people
FROM (
    SELECT *,
           LAG(id, 1) OVER (ORDER BY id) AS prev_id,
           LAG(id, 2) OVER (ORDER BY id) AS prev2_id,
           LEAD(id, 1) OVER (ORDER BY id) AS next_id,
           LEAD(id, 2) OVER (ORDER BY id) AS next2_id
    FROM Stadium
    WHERE people >= 100
) t
WHERE (prev_id = id - 1 AND prev2_id = id - 2)
   OR (prev_id = id - 1 AND next_id = id + 1)
   OR (next_id = id + 1 AND next2_id = id + 2)
ORDER BY visit_date;