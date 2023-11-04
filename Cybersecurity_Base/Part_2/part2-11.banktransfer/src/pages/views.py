from django.shortcuts import render
from django.template import loader
from django.db import transaction
from .models import Account


# Create your views here.
def transfer(sender, receiver, amount):
    # Do not perform transfer for negative amounts OR when transferring to yourself
    if amount <= 0 or sender == receiver:
        return  

	# documentation for atomic() -> https://docs.djangoproject.com/en/4.2/topics/db/transactions/
    with transaction.atomic():
        """
		The `select_for_update()` method is used to acquire locks on the selected rows.
		This is important to prevent concurrent modifications and ensure data consistency
		during the transfer process. By acquiring locks, other transactions attempting to
		modify the same rows will have to wait until the current transaction completes.
		This helps maintain data integrity and avoids race conditions.
		
		`sender` and `receiver` are the Account objects corresponding to the sender and
		receiver accounts, respectively. The `select_for_update()` method is used on the
		Account model to acquire locks on the rows that match the specified 'iban' (International
		Bank Account Number) values for the sender and receiver.
		""" 
        sender = Account.objects.select_for_update().get(iban=sender)
        receiver = Account.objects.select_for_update().get(iban=receiver)

		# Check if sender has sufficient balance for transfer
        if sender.balance >= amount:
            # Perform the transfer
            sender.balance -= amount
            receiver.balance += amount

			# Save changes to the DB
            sender.save()
            receiver.save()


def homePageView(request):
	if request.method == 'POST':
		sender = request.POST.get('from')
		receiver = request.POST.get('to')
		amount = int(request.POST.get('amount'))
		transfer(sender, receiver, amount)

	accounts = Account.objects.all()
	context = {'accounts': accounts}
	return render(request, 'pages/index.html', context)
