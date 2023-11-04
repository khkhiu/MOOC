from django.shortcuts import render

# Create your views here.

def addPageView(request):
    # Retrieve the 'items' list from the session, or create an empty list if it doesn't exist
    items = request.session.get('items', [])  
     # Get the value of the 'content' key from the POST data and remove leading/trailing whitespace
    item_insert = request.POST.get('content', '').strip() 
    # Keep only the 10 latest form submissions
	# Add 'item_insert' to the 'items' list
    if len(item_insert) > 0:  
        items.append(item_insert) 
    # Check if the 'items' list has more than 10 elements remove the oldest element (first element) from the 'items' list
    if len(items) > 10:  
        del items[0]  
	# Update the 'items' list in the session with the modified 'items' list
    request.session['items'] = items  
    return render(request, 'pages/index.html', {'items': items}) 


def erasePageView(request):
    # Retrieve the 'items' list from the session, or create an empty list if it doesn't exist
    items = []
    # Update the 'items' list in the session with the same 'items' list (no modifications)
    request.session['items'] = items  
    # Render the 'index.html' template with the 'items' list passed as a context variable
    return render(request, 'pages/index.html', {'items': items})  



def homePageView(request):
	# use sessions (the data is stored in a database db.sqlite that is then accessed using a cookie)
	items = request.session.get('items', [])

	# shorter way of writing instead of loader
	return render(request, 'pages/index.html', {'items' : items})
