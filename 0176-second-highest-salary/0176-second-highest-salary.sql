# Write your MySQL query statement below
SELECT 
    (SELECT DISTINCT Salary
    FROM 
        EMPLOYEE
    ORDER BY Salary DESC
    LIMIT 1 OFFSET 1) as SecondHighestSalary