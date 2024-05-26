# Write your MySQL query statement below
select e.name as Employee
from Employee e
Where e.salary > (select salary from Employee where id = e.managerId)