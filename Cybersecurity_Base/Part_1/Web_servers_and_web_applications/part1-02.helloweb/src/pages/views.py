from django.http import HttpResponse


# Create your views here.
# The file views.py contains the actual definition of homePageView.
def homePageView(request):
    return HttpResponse('Hello Web!')
