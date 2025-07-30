# Write your MySQL query statement below
SELECT unique_id,name
FROM Employees as e
LEFT JOIN EmployeeUNI AS eu
ON e.id = eu.id;