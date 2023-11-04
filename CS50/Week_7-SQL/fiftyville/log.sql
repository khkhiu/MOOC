-- Keep a log of any SQL queries you execute as you solve the mystery.

-- Step 1. Find how 'crime_scene_reports' where created
.schema crime_scene_reports

-- Step 2. Find any crimes reported on 28 july 2021, Humphrey Street
SELECT description FROM crime_scene_reports
WHERE day = 28
AND month = 7
AND year = 2021
AND street LIKE '%Humphrey Street%';
-- Theft of duck occurred at 1015, Humphrey Street
-- 3 witnesses, all mentoining a  bakery.

-- Step 3. Find names of the 3 witnesses, using interview conducted on 7 july 2021
SELECT name, transcript FROM interviews
WHERE day = 28
AND month = 7
AND year = 2021;
-- Ruth, Eugene, Raymond mentioned a thief, these are the 3 witnesses from Step 2.
-- Ruth saw car drive away within 10 minutes of the theft
-- Eugene saw thief withdrawing money from an ATM on Leggett Street
-- Raymond heard theif saying he wanted to leave on the earliest flight on 29 jul 2021, phone call lasted less than a minute

-- Step 4. working on Ruth's clues
-- Step 4a. Find how 'bakery_security_logs' and 'people' were created
.schema bakery_security_logs
.schema people
-- Step 4b. Check security logs between 1015 to 1025 on 28 july 2021
SELECT name, bakery_security_logs.hour, bakery_security_logs.minute FROM people
-- Use license plate to join 'bakery_security_logs' and 'people'
-- This allows us to identify the names of potential suspects
JOIN bakery_security_logs ON people.license_plate = bakery_security_logs.license_plate
WHERE bakery_security_logs.day = 28
AND bakery_security_logs.month = 7
AND bakery_security_logs.year = 2021
AND bakery_security_logs.hour = 10
AND bakery_security_logs.minute >= 15
AND bakery_security_logs.minute <= 25
ORDER BY bakery_security_logs.minute;
-- 8 names, identified: Vanessa, Bruce, Barry, Luca, Sofia, Iman, Diana, Kelsey

-- Step 5. working on Eugene's clues
-- Step 5a. Find how 'atm_transactions', 'bank_accounts' and 'people' were created
.schema atm_transactions
.schema bank_accounts
.schema people
-- Step 5b. check atm withdrawals from 'Leggett Street' on 28 July 2021
SELECT name FROM people
JOIN bank_accounts ON bank_accounts.person_id = people.id
JOIN atm_transactions ON atm_transactions.account_number = bank_accounts.account_number
WHERE atm_transactions.atm_location LIKE '%Leggett Street%'
AND atm_transactions.transaction_type = 'withdraw'
AND atm_transactions.day = 28
AND atm_transactions.month = 7
AND atm_transactions.year = 2021;
-- Common names between step 4 and 5: Bruce, Diana, Iman, Luca

-- Step 6. working on Raymond's clues
-- Step 6a. Find how 'phone_calls' and 'people' where created
.schema phone_calls
.schema people
-- Step 6b. find all phone calls lasting less than a minute, on 28 july 2021 on the caller's end
SELECT name, phone_calls.duration FROM people
JOIN phone_calls ON people.phone_number = phone_calls.caller
--JOIN phone_calls ON people.phone_number = phone_calls.receiver
WHERE phone_calls.day = 28
AND phone_calls.month = 7
AND phone_calls.year = 2021
AND phone_calls.duration <= 60
ORDER BY phone_calls.duration;
-- Common names so far: Bruce, Diana

-- Step 6c. find all phone calls lasting less than a minute, on 28 july 2021 on the receiver's end
SELECT name, phone_calls.duration FROM people
--JOIN phone_calls ON people.phone_number = phone_calls.caller
JOIN phone_calls ON people.phone_number = phone_calls.receiver
WHERE phone_calls.day = 28
AND phone_calls.month = 7
AND phone_calls.year = 2021
AND phone_calls.duration <= 60
ORDER BY phone_calls.duration;
-- Common names so far: Luca
-- Judging by duration, the following are talking to each other:
-- Bruce->Robin, 45s
-- Diana->Philip, 49s
-- Kathryn->Luca, 60s

-- Step 7. check flight records
-- Step 7a. Find how 'airports', 'flights' and 'passengers' where created
.schema airports
.schema flights
.schema passengers
-- Step 7b. Find Find the airport in Fiftyville
SELECT abbreviation, full_name, city FROM airports
WHERE city = 'Fiftyville';
-- Fiftyville Regional Airport
-- Step 7c. Find all flights out of Fiftyville Regional Airport on 28 July 2028
SELECT flights.id, full_name, city, flights.hour, flights.minute FROM airports
JOIN flights ON airports.id = flights.destination_airport_id
 WHERE flights.origin_airport_id =
(
    SELECT id FROM airports
    WHERE city = 'Fiftyville'
)
AND flights.day = 29
AND flights.month = 7
AND flights.year = 2021;
-- Earliest flight is at 0820 to NYC, LaGuardia Airport
-- Step 7d. Find passengers on flight at 0820, 29 July 2021 to NYC, LaGuardia Airport
SELECT passengers.flight_id, name, passengers.passport_number, passengers.seat FROM people
JOIN passengers ON people.passport_number = passengers.passport_number
JOIN flights ON passengers.flight_id = flights.id
WHERE flights.day = 29
AND flights.month = 7
AND flights.year = 2021
AND flights.hour = 8
AND flights.minute = 20;
-- Common names: Bruce

--Hence, Bruce is likely the thief, and Robin his accomplice. He ran to NYC, LaGuardia Airport