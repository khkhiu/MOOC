from django.urls import path

from .views import addPageView
from .views import multiplyPageView

# List to allow math ops in URL through FX call
# e.g http://127.0.0.1:8000/add/?first=10&second=10 == 20
# http://127.0.0.1:8000/multiply/?first=10&second=10 == 100
urlpatterns = [
    path('add/', addPageView, name='add'),
    path('multiply/', multiplyPageView, name='multiply')
]
