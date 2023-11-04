"""
TO DO
Python package safety can be used to find installed vulnerable packages. The package relies on another package safety-db which is simply a curated JSON file of known vulnerable python modules.

In this assignment, the goal is to write a simple query system that given the safety-db json file and a package name returns a list of all vulnerabilities associated with that package.

The output should contain a list of tuples
"""

#!/usr/bin/env python3
import sys
import json


def get_vulnerabilities(name, db):
	vulnerabilityList = []
	vulnerabilityJson = json.load(db)
	vulnerabilitySelect = vulnerabilityJson[name]
	for vulnerabilityReport in vulnerabilitySelect:
		vulnerabilityList.append((vulnerabilityReport['id'],vulnerabilityReport['v'],vulnerabilityReport['cve']))
	return vulnerabilityList


def main(argv):
	name = sys.argv[1]
	db = open(sys.argv[2])
	vulnerabilities = get_vulnerabilities(name, db)
	for v in vulnerabilities:
		print('%s; %s; %s' % (v[0], v[1], v[2]))


# This makes sure the main function is not called immediatedly
# when TMC imports this module
if __name__ == "__main__": 
	if len(sys.argv) != 3:
		print('usage: python %s name db' % sys.argv[0])
	else:
		main(sys.argv)
