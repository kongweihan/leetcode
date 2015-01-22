SELECT max(e.Salary)
FROM Employee e
WHERE e.Salary <
    (
        SELECT max(Salary)
        FROM Employee
    )
