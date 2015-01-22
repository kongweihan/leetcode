SELECT distinct(a.Num)
FROM Logs a
JOIN Logs b
ON a.Id+1 = b.Id
JOIN Logs c
ON b.Id+1 = c.Id
WHERE a.Num = b.Num AND b.Num = c.Num
