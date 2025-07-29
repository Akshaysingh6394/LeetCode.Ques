# Write your MySQL query statement below
SELECT tweet_id
FROM Tweets
WHERE SUBSTRING(content, 16, 1) <> '';