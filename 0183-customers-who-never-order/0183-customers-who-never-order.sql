# Write your MySQL query statement below
Select name as Customers from Customers where id not in(Select C.id from Customers C inner join Orders O
on C.id = O.customerId);