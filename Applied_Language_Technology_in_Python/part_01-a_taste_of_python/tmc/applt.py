
# Import libraries
import nbformat


# Some funky ANSI for output ...
class Colors:
    HEADER = '\033[95m'
    OKBLUE = '\033[94m'
    OKCYAN = '\033[96m'
    OKGREEN = '\033[92m'
    WARNING = '\033[93m'
    FAIL = '\033[91m'
    ENDC = '\033[0m'
    BOLD = '\033[1m'
    UNDERLINE = '\033[4m'


def write_result(nb, nb_path, cell, output_type, data, execution_count):
    """
    This function writes outputs into the cells of a Jupyter Notebook.

    Parameters:
        nb: A Jupyter Notebook as NotebookNode object
        nb_path: A string that defines the path to the Jupyter Notebook
        cell: A NotebookNode object
        output_type: Output type, e.g. 'execute_result' or 'stream'
        data: The message or content to be written into the output
        execution_count: Integer that tracks how many times a cell has been run

    Result:
        Appends the output into the list of outputs under the key 'outputs' of
        a NotebookNode.
    """

    # Process results first
    if output_type == 'execute_result':

        # Create the output
        output = nbformat.v4.new_output(output_type=output_type,
                                        data=data,
                                        execution_count=execution_count)

    # Next, process streams (stdout / stderr)
    elif output_type == 'stream':

        # Create the output
        output = nbformat.v4.new_output(output_type=output_type,
                                        text=data['text'],
                                        name=data['name'])

    # Append the output to the cell outputs
    cell['outputs'].append(output)

    # Write the notebook to disk to preserve changes
    nbformat.write(nb, nb_path)


def prepare_cell(cell):
    """
    This function prepares a cell in Jupyter Notebooks for tests using TMC.

    Parameters:
         cell: A NotebookNode object

    Result:
        The cell outputs are cleared and the execution count is set.
    """

    # Clear previous outputs
    cell.outputs = []

    # Get execution count
    if cell.execution_count is None:

        # Set execution count to 1
        cell.execution_count = 1

    else:

        # Increase execution count by 1
        cell.execution_count += 1
