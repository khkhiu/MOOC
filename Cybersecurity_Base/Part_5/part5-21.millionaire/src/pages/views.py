"""
The assignment template contains the core elements of the "Who wants to be a millionaire?"-game. In this template, you can observe that the link that is used to input details after finishing the game can be accessed by anyone — although it should be hidden, moreover user can go back and change the topic midway.

Fix these issues Do not change the address scheme though, but do it in the business logic of the application.
"""
from django.shortcuts import render, redirect

from .models import questions

def find_topic(tid):
	for q in questions:
		if q['id'] == tid:
			return q
	return None


def quizView(request, tid):
	topic = find_topic(tid)
	if (request.session['tid'] != tid or request.session['gameover']):
		return render(request, 'pages/cheater.html')
	request.session['level'] = 0
	return render(request, 'pages/question.html', {'topic' : topic, 'question' : topic['questions'][0]})



def answerView(request, tid, aid):
	if (request.session['tid'] != tid or request.session['gameover']):
		return render(request, 'pages/cheater.html')
		
	topic = find_topic(tid)

	level = request.session['level']

	if topic['questions'][level]['correct'] == aid:
		level += 1
		request.session['level'] = level

		if level == len(topic['questions']):
			return redirect('/finish/')

		return render(request, 'pages/question.html', {'topic' : topic, 'question' : topic['questions'][level]})
	else:
		return redirect('/incorrect/')


def incorrectView(request):
	request.session['gameover'] = True
	return render(request, 'pages/incorrect.html')


def finishView(request):
	try:
		if (request.session['level'] != 2):
			return render(request, 'pages/cheater.html')
		return render(request, 'pages/finish.html')
	except:
			return render(request, 'pages/cheater.html')


def cheaterView(request):
	return render(request, 'pages/cheater.html')


def thanksView(request):
	# Like we were going to pay anyone
	return render(request, 'pages/thanks.html')



def topicView(request, tid):
	request.session['tid'] = tid
	topic = find_topic(tid)
	return render(request, 'pages/topic.html', {'topic' : topic})


def topicsView(request):
	request.session['gameover'] = False
	return render(request, 'pages/topics.html', {'questions' : questions})