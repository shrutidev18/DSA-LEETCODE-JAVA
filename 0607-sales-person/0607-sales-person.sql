# Write your MySQL query statement below
Select name from SalesPerson where sales_id 
not in (Select s.sales_id from SalesPerson s inner join Orders o on s.sales_id = o.sales_id
inner join Company c on c.com_id = o.com_id where c.name = 'RED')