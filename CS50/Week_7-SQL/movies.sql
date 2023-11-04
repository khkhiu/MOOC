--Q1
SELECT title FROM movies
WHERE year = 2008

--Q2
SELECT birth FROM people
WHERE name = "Emma Stone"

--Q3
SELECT title FROM movies
WHERE year >= 2018
ORDER BY title ASC

--Q4
SELECT COUNT(title) FROM movies
-- Info from different tables are needed
JOIN ratings on movies.id = ratings.movie_id
WHERE rating = 10.0

--Q5
SELECT title, year FROM movies
WHERE title LIKE "%Harry Potter%"
ORDER BY year ASC

--Q6
SELECT AVG(rating) FROM ratings
-- Info from different tables are needed
JOIN movies on movies.id = ratings.movie_id
WHERE year = 2012

--Q7
SELECT movies.title, ratings.rating FROM movies
JOIN ratings on movies.id = ratings.movie_id
WHERE year = 2010
ORDER by rating DESC, title ASC

--Q8
SELECT name FROM people
-- join 'people' table with 'stars' table
JOIN stars ON people.id = person_id
-- join 'stars' table with 'movies' table
JOIN movies ON movie_id = movies.id
WHERE movies.title LIKE "%Toy Story%"

--Q9
SELECT name FROM people
-- join 'people' table with 'stars' table
JOIN stars ON stars.person_id = people.id
-- join 'people' table with 'stars' table
JOIN movies ON stars.movie_id = movies.id
WHERE movies.year = 2004
ORDER BY people.birth

--Q10
SELECT name FROM people
-- join 'people' table with 'directos' table
JOIN directors ON people.id = directors.person_id
-- join 'directors' table with 'rating' table
JOIN ratings ON directors.movie_id = ratings.movie_id
WHERE ratings.rating >= 9.0

--Q11
SELECT movies.title FROM people
-- join 'people' table with 'stars' table
JOIN stars ON people.id = stars.person_id
-- join 'stars' table with 'movies' table
JOIN movies ON stars.movie_id = movies.id
-- join 'movies' table with 'ratings' table
JOIN ratings ON movies.id = ratings.movie_id
WHERE name = "Chadwick Boseman"
ORDER BY rating DESC
LIMIT 5

--Q12
SELECT movies.title FROM people
-- join 'people' table with 'stars' table
JOIN stars ON people.id = stars.person_id
-- join 'stars' table with 'movies' table
JOIN movies ON stars.movie_id = movies.id
WHERE people.name = "Johnny Depp"
--Seperate SELECT ops needed, 'WHERE' cannot have 2 people.name
AND movies.title IN
(
SELECT movies.title FROM people
-- join 'people' table with 'stars' table
JOIN stars ON people.id = stars.person_id
-- join 'stars' table with 'movies' table
JOIN movies ON stars.movie_id = movies.id
WHERE people.name = "Helena Bonham Carter"
)

--Q13
SELECT DISTINCT(name) FROM people
-- join 'people' table with 'stars' table
JOIN stars ON people.id = stars.person_id
-- join 'stars' table with 'movies' table
JOIN movies ON stars.movie_id = movies.id
WHERE movies.title IN(
SELECT DISTINCT(movies.title) FROM people
-- join 'people' table with 'stars' table
JOIN stars ON people.id = stars.person_id
-- join 'stars' table with 'movies' table
JOIN movies ON stars.movie_id = movies.id
WHERE people.name = "Kevin Bacon" AND people.birth = 1958)
AND people.name != "Kevin Bacon"