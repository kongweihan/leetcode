SELECT a.Name As Employee
FROM Employee a INNER JOIN Employee b
ON a.ManagerId = b.Id
WHERE a.Salary > b.Salary
