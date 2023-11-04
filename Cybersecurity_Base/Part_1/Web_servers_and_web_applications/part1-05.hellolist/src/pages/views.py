from django.shortcuts import render

# Create your views here.
    #The assignment has the server side functionality that handles a request to the root path and adds a list for the template to process. 
    #The template that is used to create the site is missing some functionality however.
    #Your task is to (1) print the values in the list between <ul> and </ul> tags, and (2) add a form that can be used to send content to the server.
	#The task is done in index.html
def homePageView(request):
	# use sessions (the data is stored in a database db.sqlite that is then accessed using a cookie)
	items = request.session.get('items', [])

	# handling post request
	if request.method == 'POST':
		item = request.POST.get('content', '').strip()
		if len(item) > 0:
			items.append(item)
		request.session['items'] = items

	# shorter way of writing instead of loader
	return render(request, 'pages/index.html', {'items' : items})
