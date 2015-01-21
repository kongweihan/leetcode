SELECT Name AS Customers
FROM Customers c
LEFT JOIN Orders o
ON c.Id = o.CustomerId
GROUP BY c.Id, c.Name
HAVING COUNT(o.Id) = 0
