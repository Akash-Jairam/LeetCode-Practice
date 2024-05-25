# Write your MySQL query statement below
select c.name as Customers from 
Customers c 
LEFT JOIN Orders ON c.id = Orders.customerId
Where Orders.CustomerId IS NULL