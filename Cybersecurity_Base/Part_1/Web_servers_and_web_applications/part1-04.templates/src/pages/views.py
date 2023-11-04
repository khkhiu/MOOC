from django.http import HttpResponse
from django.template import loader


# Create your views here.
# 'get_template' will start its search in the 'templates' folder
# Hence we only need to spcify the path under the 'templates' folder
# See here for more information:https://docs.djangoproject.com/en/4.2/topics/templates/
def homePageView(request):
	template = loader.get_template('pages/index.html')
	return HttpResponse(template.render())

def videoPageView(request):
	template = loader.get_template('pages/video.html')
	return HttpResponse(template.render())