SELECT d.Name AS Department, e.Name AS Employee, e.Salary
FROM Employee e
JOIN (
    SELECT e.DepartmentId, max(e.Salary) AS MaxSalary
    FROM Employee e
    GROUP BY e.DepartmentId
    ) s
ON e.DepartmentId = s.DepartmentId
JOIN Department d
ON e.DepartmentId = d.Id
WHERE e.Salary = s.MaxSalary
