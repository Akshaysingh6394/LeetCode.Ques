<h2><a href="https://leetcode.com/problems/game-play-analysis-iv">Game Play Analysis IV</a></h2> <img src='https://img.shields.io/badge/Difficulty-Medium-orange' alt='Difficulty: Medium' /><hr><p>Table: <code>Activity</code></p>

<pre>
+--------------+---------+
| Column Name  | Type    |
+--------------+---------+
| player_id    | int     |
| device_id    | int     |
| event_date   | date    |
| games_played | int     |
+--------------+---------+
(player_id, event_date) is the primary key (combination of columns with unique values) of this table.
This table shows the activity of players of some games.
Each row is a record of a player who logged in and played a number of games (possibly 0) before logging out on someday using some device.
</pre>

<p> </p>

<p>Write a solution to report the <strong>fraction</strong> of players that logged in again on the day after the day they first logged in, <strong>rounded to 2 decimal places</strong>. In other words, you need to determine the number of players who logged in on the day immediately following their initial login, and divide it by the number of total players.</p>

<p>The result format is in the following example.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> 
Activity table:
+-----------+-----------+------------+--------------+
| player_id | device_id | event_date | games_played |
+-----------+-----------+------------+--------------+
| 1         | 2         | 2016-03-01 | 5            |
| 1         | 2         | 2016-03-02 | 6            |
| 2         | 3         | 2017-06-25 | 1            |
| 3         | 1         | 2016-03-02 | 0            |
| 3         | 4         | 2018-07-03 | 5            |
+-----------+-----------+------------+--------------+
<strong>Output:</strong> 
+-----------+
| fraction  |
+-----------+
| 0.33      |
+-----------+
<strong>Explanation:</strong> 
Only the player with id 1 logged back in after the first day he had logged in so the answer is 1/3 = 0.33
</pre>
