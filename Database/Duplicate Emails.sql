SELECT Email
FROM Person
GROUP by Email
HAVING count(*) > 1
