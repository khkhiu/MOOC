from django.http import HttpResponse
from django.contrib.auth.decorators import login_required
from django.shortcuts import render, redirect
from django.contrib.auth.models import User
from .models import File

"""
TO DO
The assignment template contains the functionality for uploading and storing personal files on a web server. 
The files uploaded by an individual should not be accessible by anyone else. However, there seems to be a few flaws in how this has been implemented. 
Fix the application so that everyone can access only the files that they have uploaded (unauthorized actions should redirect to /).
"""

# Add if else statement to check if user is authorised to access filess
@login_required
def deleteView(request):
	f = File.objects.get(pk=request.POST.get('id'))
	if f.owner == request.user:
		f.delete()
		return redirect('/')
	else:
		return HttpResponse('Unathorized', status=401)
	
# Add if else statement to check if user is authorised to access filess
@login_required
def downloadView(request, fileid):
	f = File.objects.get(pk=fileid)
	if f.owner == request.user:
		filename = f.data.name.split('/')[-1]
		response = HttpResponse(f.data, content_type='text/plain')
		response['Content-Disposition'] = 'attachment; filename=%s' % filename
		return response
	else:
		return HttpResponse('Unathorized', status=401)


@login_required
def addView(request):
	data = request.FILES.get('file')
	f = File(owner=request.user, data=data)
	f.save()
	return redirect('/')


@login_required
def homePageView(request):
	files = File.objects.filter(owner=request.user)
	uploads = [{'id': f.id, 'name': f.data.name.split('/')[-1]} for f in files]	
	return render(request, 'pages/index.html', {'uploads': uploads})
