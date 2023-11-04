#!/usr/bin/env python3
import sys
import sqlite3

# FX to add entru into DB
def add_agent(conn, aid, name):
	cur = conn.cursor()
	cur.execute("INSERT INTO agent VALUES (?, ?)", (aid, name))
	conn.commit()
	pass # write code here, don't forget to commit results once you execute the insert

# FX to delete entry from DB
def delete_agent(conn, aid):
	cur = conn.cursor()
	cur.execute("DELETE FROM agent WHERE id = (?)", (aid, ))
	conn.commit()
	pass # write code here, don't forget to commit results once you execute the insert

# FX to read entries from DB
def read_database(conn):
	agents = []
	cursor = conn.cursor()
	# output should be a list of pairs agents = [(id1, name1), (id2, name2), (id3, name3), ...] ordered by id
	# write code here
	# code from previous exercise
	output = cursor.execute('SELECT * FROM agent ORDER BY id')
	for entry in output:
		pair = (entry[0], entry[1])
		agents.append(pair)	

	return agents

# Provided code
def main(argv):
	name = sys.argv[1]
	conn = sqlite3.connect(name)
	while True:
		agents = read_database(conn)
		print('\nActive agents:\n')
		for agent in agents:
			print(agent[0], agent[1])
		print()
		command = input('What would you like to do: [a]dd, [r]emove, or [q]uit? ')

		if command[0].startswith('a'):
			aid = input('id? ')
			name = input('name? ')
			add_agent(conn, aid, name)
			pass
		elif command[0].startswith('r'):
			aid = input('id? ')
			delete_agent(conn, aid)
			pass
		elif command[0].startswith('q'):
			break
	

# This makes sure the main function is not called immediatedly
# when TMC imports this module
if __name__ == "__main__": 
	if len(sys.argv) != 2:
		print('usage: python %s database' % sys.argv[0])
	else:
		main(sys.argv)
