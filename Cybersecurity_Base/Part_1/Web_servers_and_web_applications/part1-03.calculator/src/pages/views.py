from django.http import HttpResponse


# Create your views here.

# FX to sum 2 arguments
def addPageView(request):
	first = request.GET.get('first')
	second = request.GET.get('second')
	return HttpResponse(int(first)+int(second))
	
# FX to multiply 2 arguments
def multiplyPageView(request):
	first = request.GET.get('first')
	second = request.GET.get('second')
	return HttpResponse(int(first)*int(second))
