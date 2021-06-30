// Runtime: 298 ms, faster than 65.21% of MySQL online submissions for Combine Two Tables.
// Memory Usage: 0B, less than 100.00% of MySQL online submissions for Combine Two Tables.
# Write your MySQL query statement below
SELECT FirstName, LastName, Address.City, Address.State FROM Person LEFT OUTER JOIN Address ON Person.PersonId = Address.PersonId;
