#!/usr/bin/env python3

import nbformat
import unittest

from tmc import points
from tmc.utils import get_stdout
from tmc.applt import write_result, prepare_cell, Colors

# Define path to Notebook
nb_path = 'taste_python.ipynb'

# Read the notebook
nb = nbformat.read(nb_path, as_version=4)

# Collect indices for notebook cells that contain exercises. Map these indices
# to a dictionary keyed by test names.
exercises = {cell['metadata']['test']: ix for ix, cell in enumerate(nb.cells)
             if 'test' in cell['metadata']}


class CreateVariable(unittest.TestCase):

    @classmethod
    def setUpClass(cls):

        # Prepare the cell by clearing outputs
        prepare_cell(nb.cells[exercises['create_variable']])

    def setUp(self):

        # Get the cell that is to be tested
        self.cell = nb.cells[exercises['create_variable']]

    @points('p1.1.create_variable')
    def test_create_variable(self):

        # Run the cell within the function for local scope
        exec(self.cell.source)

        # Perform test
        try:

            # Check if variable exists
            assert 'my_variable' in locals()

            # Define message for passing the test
            message = {'text/plain': f'{Colors.BOLD}[TMC]{Colors.ENDC} '
                                     f'{Colors.OKGREEN}Variable '
                                     f'"my_variable" was defined successfully! '
                                     f'1 point.{Colors.ENDC}'}

            # Set flag
            fail = False

        except AssertionError:

            # Define error message
            errmsg = 'The variable "my_variable" has not been defined.'

            # Define a message for failing the test
            message = {'text/plain': f'{Colors.BOLD}[TMC]{Colors.ENDC} '
                                     f'{Colors.FAIL}{errmsg}{Colors.ENDC}'}

            # Set flag
            fail = True

        # Write the result to the cell
        write_result(nb=nb,
                     nb_path=nb_path,
                     cell=self.cell,
                     output_type='execute_result',
                     data=message,
                     execution_count=self.cell.execution_count)

        # Check flag
        if fail:

            # Use the fail method to fail the test
            self.fail(errmsg)

    @points('p1.1.check_variable_type')
    def test_variable_type(self):

        # Run the cell within the function for local scope
        exec(self.cell.source)

        # Perform test
        try:

            # Check if variable is of correct type
            assert isinstance(locals()['my_variable'], str)

            # Define a message for passing the test
            message = {'text/plain': f'{Colors.BOLD}[TMC]{Colors.ENDC} '
                                     f'{Colors.OKGREEN}The variable contains '
                                     f'a string object! 1 point.{Colors.ENDC}'}

            # Set flag
            fail = False

        except AssertionError:

            # Define error message
            errmsg = 'The variable does not contain string object! Did you ' \
                     'assign the value in the correct format?'

            # Define a message for failing the test
            message = {'text/plain': f'{Colors.BOLD}[TMC]{Colors.ENDC} '
                                     f'{Colors.FAIL}{errmsg}{Colors.ENDC}'}

            # Set flag
            fail = True

        # Write the result to the cell
        write_result(nb=nb,
                     nb_path=nb_path,
                     cell=self.cell,
                     output_type='execute_result',
                     data=message,
                     execution_count=self.cell.execution_count)

        # Check flag
        if fail:

            # Use the fail method to fail the test
            self.fail(errmsg)

    @points('p1.1.check_variable_value', 'p1.1.check_variable_value_x2')
    def test_variable_value(self):

        # Run the cell within the function for local scope
        exec(self.cell.source)

        # Perform test
        try:

            # Check if the variable contains the correct value
            assert locals()['my_variable'] == "This is my first variable."

            # Define a message for passing the test
            message = {'text/plain': f'{Colors.BOLD}[TMC]{Colors.ENDC} '
                                     f'{Colors.OKGREEN}The variable contains '
                                     f'the correct value! 2 points.'
                                     f'{Colors.ENDC}'}

            # Set flag
            fail = False

        except AssertionError:

            # Define error message
            errmsg = 'The variable does not contain the correct value! Check ' \
                     'the value that you assigned to the variable.'

            # Define a message for failing the test
            message = {'text/plain': f'{Colors.BOLD}[TMC]{Colors.ENDC} '
                                     f'{Colors.FAIL}{errmsg}{Colors.ENDC}'}

            # Set flag
            fail = True

        # Write the result to the cell
        write_result(nb=nb,
                     nb_path=nb_path,
                     cell=self.cell,
                     output_type='execute_result',
                     data=message,
                     execution_count=self.cell.execution_count)

        # Check flag
        if fail:

            # Use the fail method to fail the test
            self.fail(errmsg)


class CreateList(unittest.TestCase):

    @classmethod
    def setUpClass(cls):

        # Prepare cell
        prepare_cell(nb.cells[exercises['create_list']])

    def setUp(self):

        # Get the cell that is to be tested
        self.cell = nb.cells[exercises['create_list']]

    @points('p1.2.create_list')
    def test_create_list(self):

        # Run the cell within the function for local scope
        exec(self.cell.source)

        # Perform test
        try:

            # Check if variable exists
            assert 'my_list' in locals()

            # Define message for passing the test
            message = {'text/plain': f'{Colors.BOLD}[TMC]{Colors.ENDC} '
                                     f'{Colors.OKGREEN}Variable "my_list" '
                                     f'was defined successfully! 1 point.'
                                     f'{Colors.ENDC}'}

            # Set flag
            fail = False

        except AssertionError:

            # Define error message
            errmsg = 'The variable "my_list" has not been defined.'

            # Define a message for failing the test
            message = {'text/plain': f'{Colors.BOLD}[TMC]{Colors.ENDC} '
                                     f'{Colors.FAIL}{errmsg}{Colors.ENDC}'}

            # Set flag
            fail = True

        # Write the result to the cell
        write_result(nb=nb,
                     nb_path=nb_path,
                     cell=self.cell,
                     output_type='execute_result',
                     data=message,
                     execution_count=self.cell.execution_count)

        # Check flag
        if fail:

            # Use the fail method to fail the test
            self.fail(errmsg)

    @points('p1.2.list_type')
    def test_list_type(self):

        # Run the cell within the function for local scope
        exec(self.cell.source)

        # Perform test
        try:

            # Check if the variable is of correct type
            assert isinstance(locals()['my_list'], list)

            # Define message for passing the test
            message = {'text/plain': f'{Colors.BOLD}[TMC]{Colors.ENDC} '
                                     f'{Colors.OKGREEN}The variable contains a '
                                     f'list object! 1 point.{Colors.ENDC}'}

            # Set flag
            fail = False

        except AssertionError:

            # Define error message
            errmsg = 'The variable is not a list object. Did you use the ' \
                     'split() method?'

            # Define a message for failing the test
            message = {'text/plain': f'{Colors.BOLD}[TMC]{Colors.ENDC} '
                                     f'{Colors.FAIL}{errmsg}{Colors.ENDC}'}

            # Set flag
            fail = True

        # Write the result to the cell
        write_result(nb=nb,
                     nb_path=nb_path,
                     cell=self.cell,
                     output_type='execute_result',
                     data=message,
                     execution_count=self.cell.execution_count)

        # Check flag
        if fail:

            # Use the fail method to fail the test
            self.fail(errmsg)

    @points('p1.2.list_contents', 'p1.2.list_contents_x2')
    def test_list_contents(self):

        # Run the cell within the function for local scope
        exec(self.cell.source)

        # Perform test
        try:

            # Check if the list contents are correct
            assert "one two three four five".split() == locals()['my_list']

            # Define message for passing the test
            message = {'text/plain': f'{Colors.BOLD}[TMC]{Colors.ENDC} '
                                     f'{Colors.OKGREEN}The list contains the '
                                     f'correct items! 2 points.{Colors.ENDC}'}

            # Set flag
            fail = False

        except AssertionError:

            # Define error message
            errmsg = 'The list does not contain expected items. Did you ' \
                     'split the correct string?'

            # Define a message for failing the test
            message = {'text/plain': f'{Colors.BOLD}[TMC]{Colors.ENDC} '
                                     f'{Colors.FAIL}{errmsg}{Colors.ENDC}'}

            # Set flag
            fail = True

        # Write the result to the cell
        write_result(nb=nb,
                     nb_path=nb_path,
                     cell=self.cell,
                     output_type='execute_result',
                     data=message,
                     execution_count=self.cell.execution_count)

        # Check flag
        if fail:

            # Use the fail method to fail the test
            self.fail(errmsg)


class GetItemFromList(unittest.TestCase):

    @classmethod
    def setUpClass(cls):

        # Prepare cell
        prepare_cell(nb.cells[exercises['get_item']])

    def setUp(self):

        # Get the cell that is to be tested
        self.cell = nb.cells[exercises['get_item']]

    @points('p1.3.get_item')
    def test_item_name(self):

        # Run the cell within the function for local scope
        exec(self.cell.source)

        # Perform test
        try:

            # Check if variable exists
            assert 'item_5' in locals()

            # Define message for passing the test
            message = {'text/plain': f'{Colors.BOLD}[TMC]{Colors.ENDC} '
                                     f'{Colors.OKGREEN}Variable "item_5" '
                                     f'defined successfully! 1 point.'
                                     f'{Colors.ENDC}'}

            # Set flag
            fail = False

        except AssertionError:

            # Define error message
            errmsg = 'The variable "item_5" has not been defined.'

            # Define a message for failing the test
            message = {'text/plain': f'{Colors.BOLD}[TMC]{Colors.ENDC} '
                                     f'{Colors.FAIL}{errmsg}{Colors.ENDC}'}

            # Set flag
            fail = True

        # Write the result to the cell
        write_result(nb=nb,
                     nb_path=nb_path,
                     cell=self.cell,
                     output_type='execute_result',
                     data=message,
                     execution_count=self.cell.execution_count)

        # Check flag
        if fail:

            # Use the fail method to fail the test
            self.fail(errmsg)

    @points('p1.3.item_value')
    def test_item_value(self):

        # Run the cell within the function for local scope
        exec(self.cell.source)

        # Perform test
        try:

            # Check if the variable contains the correct value
            assert locals()['item_5'] == "ok"

            # Define a message for passing the test
            message = {'text/plain': f'{Colors.BOLD}[TMC]{Colors.ENDC} '
                                     f'{Colors.OKGREEN}The variable contains '
                                     f'the correct value! 1 point.'
                                     f'{Colors.ENDC}'}

            # Set flag
            fail = False

        except AssertionError:

            # Define error message
            errmsg = 'The variable does not contain the correct value! Did ' \
                     'you pick the correct item from the list? Remember that ' \
                     'Python starts counting from zero.'

            # Define a message for failing the test
            message = {'text/plain': f'{Colors.BOLD}[TMC]{Colors.ENDC} '
                                     f'{Colors.FAIL}{errmsg}{Colors.ENDC}'}

            # Set flag
            fail = True

        # Write the result to the cell
        write_result(nb=nb,
                     nb_path=nb_path,
                     cell=self.cell,
                     output_type='execute_result',
                     data=message,
                     execution_count=self.cell.execution_count)

        # Check flag
        if fail:

            # Use the fail method to fail the test
            self.fail(errmsg)


class PrintVariable(unittest.TestCase):

    @classmethod
    def setUpClass(cls):

        # Prepare cell
        prepare_cell(nb.cells[exercises['print_variable']])

    def setUp(self):

        # Get the cell that is to be tested
        self.cell = nb.cells[exercises['print_variable']]

    @points('p1.4.print_variable')
    def test_print_variable(self):

        # Run the cell within the function for local scope
        exec(self.cell.source)

        # Get the output and prepare for writing to the cell
        stdout = {'text': get_stdout(),
                  'name': 'stdout'}

        # Write the output to the cell before tests
        write_result(nb=nb,
                     nb_path=nb_path,
                     cell=self.cell,
                     output_type='stream',
                     data=stdout,
                     execution_count=self.cell.execution_count)

        # Perform test
        try:

            # Check that the variable has been printed
            assert get_stdout() == "This is the message."

            # Define a message for passing the test
            message = {'text/plain': f'{Colors.BOLD}[TMC]{Colors.ENDC} '
                                     f'{Colors.OKGREEN}The variable was printed'
                                     f' successfully! 1 point.{Colors.ENDC}'}

            # Set flag
            fail = False

        except AssertionError:

            # Define error message
            errmsg = 'Your solution did not print the expected string. Did ' \
                     'you print out the correct variable? Remember that ' \
                     'variable names must not be placed in quotes.'

            # Define a message for failing the test
            message = {'text/plain': f'{Colors.BOLD}[TMC]{Colors.ENDC} '
                                     f'{Colors.FAIL}{errmsg}{Colors.ENDC}'}

            # Set flag
            fail = True

        # Write the result to the cell
        write_result(nb=nb,
                     nb_path=nb_path,
                     cell=self.cell,
                     output_type='execute_result',
                     data=message,
                     execution_count=self.cell.execution_count)

        # Check flag
        if fail:

            # Use the fail method to fail the test
            self.fail(errmsg)


class StripVariable(unittest.TestCase):

    @classmethod
    def setUpClass(cls):

        # Prepare cell
        prepare_cell(nb.cells[exercises['remove_stop']])

    def setUp(self):

        # Get the cell that is to be tested
        self.cell = nb.cells[exercises['remove_stop']]

    @points('p1.5.variable_exists')
    def test_variable_exists(self):

        # Run the cell within the function for local scope
        exec(self.cell.source)

        # Perform test
        try:

            # Check if variable exists
            assert 'processed' in locals()

            # Define a message for passing the test
            message = {'text/plain': f'{Colors.BOLD}[TMC]{Colors.ENDC} '
                                     f'{Colors.OKGREEN}The variable "processed"'
                                     f' was defined successfully! 1 point.'
                                     f'{Colors.ENDC}'}

            # Set flag
            fail = False

        except AssertionError:

            # Define error message
            errmsg = 'The variable "processed" has not been defined.'

            # Define a message for failing the test
            message = {'text/plain': f'{Colors.BOLD}[TMC]{Colors.ENDC} '
                                     f'{Colors.FAIL}{errmsg}{Colors.ENDC}'}

            # Set flag
            fail = True

        # Write the result to the cell
        write_result(nb=nb,
                     nb_path=nb_path,
                     cell=self.cell,
                     output_type='execute_result',
                     data=message,
                     execution_count=self.cell.execution_count)

        # Check flag
        if fail:

            # Use the fail method to fail the test
            self.fail(errmsg)

    @points('p1.5.check_variable_type')
    def test_variable_type(self):

        # Run the cell within the function for local scope
        exec(self.cell.source)

        # Perform test
        try:

            # Check if variable is of correct type
            assert isinstance(locals()['processed'], str)

            # Define a message for passing the test
            message = {'text/plain': f'{Colors.BOLD}[TMC]{Colors.ENDC} '
                                     f'{Colors.OKGREEN}The variable contains '
                                     f'a string object! 1 point.{Colors.ENDC}'}

            # Set flag
            fail = False

        except AssertionError:

            # Define error message
            errmsg = 'The variable does not contain string object! Did you ' \
                     'assign the value in the correct format?'

            # Define a message for failing the test
            message = {'text/plain': f'{Colors.BOLD}[TMC]{Colors.ENDC} '
                                     f'{Colors.FAIL}{errmsg}{Colors.ENDC}'}

            # Set flag
            fail = True

        # Write the result to the cell
        write_result(nb=nb,
                     nb_path=nb_path,
                     cell=self.cell,
                     output_type='execute_result',
                     data=message,
                     execution_count=self.cell.execution_count)

        # Check flag
        if fail:

            # Use the fail method to fail the test
            self.fail(errmsg)

    @points('p1.5.remove_stop', 'p1.5.remove_stop_x2')
    def test_remove_stop(self):

        # Run the cell within the function for local scope
        exec(self.cell.source)

        # Perform test
        try:

            # Check if the variable contains the correct value
            assert locals()['processed'] == 'This is just another example'

            # Define a message for passing the test
            message = {'text/plain': f'{Colors.BOLD}[TMC]{Colors.ENDC} '
                                     f'{Colors.OKGREEN}The variable contains '
                                     f'the correct value! 2 points.'
                                     f'{Colors.ENDC}'}

            # Set flag
            fail = False

        except AssertionError:

            # Define error message
            errmsg = 'The variable does not contain the correct value! Did ' \
                     'you provide correct input to the strip() method?'

            # Define a message for failing the test
            message = {'text/plain': f'{Colors.BOLD}[TMC]{Colors.ENDC} '
                                     f'{Colors.FAIL}{errmsg}{Colors.ENDC}'}

            # Set flag
            fail = True

        # Write the result to the cell
        write_result(nb=nb,
                     nb_path=nb_path,
                     cell=self.cell,
                     output_type='execute_result',
                     data=message,
                     execution_count=self.cell.execution_count)

        # Check flag
        if fail:

            # Use the fail method to fail the test
            self.fail(errmsg)
