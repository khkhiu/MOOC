#!/usr/bin/env python3

import os
import unittest
import random

from tmc import points
from tmc.utils import load

from django.contrib.auth.models import User
from server.pages.models import Account
from server.config.simplesession import SessionStore

from django.test import LiveServerTestCase


module_name="src.hijacksession"
test_session = load(module_name, "test_session")


@points('2.7.1 2.7.2 2.7.3 2.7.4 2.7.5')
class HijackTest(LiveServerTestCase):

	def perform_test(self, mincount, maxcount):
		balance = random.randrange(10, 100)
		SessionStore.session_counter = random.randrange(10)

		alice = User.objects.create_user(username='alice', password='redqueen')
		account = Account(user=alice, balance=balance)
		account.save()

		self.client.login(username='alice', password='redqueen')

		self.assertEqual(test_session(self.live_server_url), balance)

	def test_session1(self):
		self.perform_test(0, 10)

	def test_session2(self):
		self.perform_test(0, 10)

	def test_session3(self):
		self.perform_test(0, 10)
