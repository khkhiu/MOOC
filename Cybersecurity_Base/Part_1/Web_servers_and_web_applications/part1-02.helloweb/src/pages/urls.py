from django.urls import path

from .views import homePageView
#The file urls.py tells the server that if the client (browser) requests for a root web page, 
#the ouput of homePageView should be provided as a response.
urlpatterns = [
    path('', homePageView, name='home')
]
