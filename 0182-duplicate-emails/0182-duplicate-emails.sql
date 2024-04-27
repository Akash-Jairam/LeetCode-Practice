# Write your MySQL query statement below
SELECT email from person p
GROUP by email
having count(email) > 1