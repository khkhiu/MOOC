from django.http import HttpResponse
from django.contrib.auth.decorators import login_required
from django.shortcuts import render, redirect
from django.contrib.auth.models import User
from .models import Account
from django.db.models import Q
import json

# Requires the user to be logged in to access this view
@login_required  
def addView(request):
    # Retrieves the User object for the currently logged-in user
    user = User.objects.get(username=request.user)  
    # Prints the username and password of the user to the console
    print(user.username)  
    print(user.password) 
    # Creates an Account object with the owner set to the user and the iban obtained from the POST data
    account = Account.objects.create(owner=user, iban=request.POST.get('iban'))  
    # Saves the account object to the database and redirect to root URL
    account.save()  
    return redirect('/') 

# Requires the user to be logged in to access this view
@login_required 
def homePageView(request):
    # Retrieves a queryset of Account objects filtered by the currently logged-in user
    user_account = Account.objects.filter(owner=request.user)  
    # Renders the 'index.html' template and passes the user_account queryset as the 'accounts' context variable
    return render(request, 'pages/index.html', {'accounts': user_account})

