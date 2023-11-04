from django.http import HttpResponse
from .models import Message


# Create your views here.

def homePageView(request):
	getId = request.GET.get('id')
	content = Message.objects.get(id=getId).content

		
	return HttpResponse(content)
