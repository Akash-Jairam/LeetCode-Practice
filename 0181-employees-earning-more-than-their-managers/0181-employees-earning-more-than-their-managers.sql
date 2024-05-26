# Write your MySQL query statement below
SELECT a.name as Employee
From Employee a join Employee b
on a.managerId = b.Id
AND a.Salary > b.Salary;