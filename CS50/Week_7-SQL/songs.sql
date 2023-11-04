--Q1
SELECT name FROM songs;
--Q2
SELECT name FROM songs
ORDER BY tempo ASC;
--Q3
SELECT name FROM songs
ORDER BY duration_ms DESC
LIMIT 5;
--Q4
SELECT name FROM songs
WHERE danceability > 0.75
AND energy > 0.75
AND valence > 0.75;
--Q5
SELECT avg(energy) FROM songs
--Q6
SELECT name FROM songs
-- Artist name is in a different table
WHERE artist_id =
(SELECT id FROM artists WHERE name = "Post Malone");
--Q7
SELECT avg(energy) FROM songs
-- Artist name is in a different table
WHERE artist_id =
(SELECT id FROM artists WHERE name = "Drake");
--Q8
SELECT name FROM songs
-- use % as part of LIKE operator
WHERE name LIKE "%feat.%";