#!/usr/bin/env python3
import sys
import socket

# FX to find and return port that can be accessed 
def get_accessible_ports(address, min_port, max_port):
    # List to hold address of found ports
    found_ports = []
    # Iterate over the range of ports from min_port to max_port 
    for port in range(min_port, max_port + 1):
        # Create a socket object
		# 'socket.socket' to create a new socket
		# 'socket.AF_INET' configures the socket to use IPv4
		# 'socket.SOCK_STREAM' configures the socket to use TCP
        effective_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        # Try to connect to the address and port
		# 'connect_ex'->non blocking version of 'connect()'->returns error code instead of blocking the program
		# 'connect_ex' checks if ip address and port are connected(represented by == 0)
        if effective_socket.connect_ex((address, port)) == 0:
            # If the connection was successful (port is accessible), add it to the list
            found_ports.append(port)
        
        # Close the socket
        effective_socket.close()

    return found_ports

def main(argv):
    # Assigning command arguments
    address = sys.argv[1]
    min_port = int(sys.argv[2])
    max_port = int(sys.argv[3])

    # Call the get_accessible_ports function to retrieve the accessible ports
    ports = get_accessible_ports(address, min_port, max_port)

    # Print the accessible ports
    for p in ports:
        print(p)

# Check if the script is being executed directly
if __name__ == "__main__": 
    # Check if the correct number of command-line arguments is provided
	# Print instructions for correct command-line arguments
    if len(sys.argv) != 4:
        print('usage: python %s address min_port max_port' % sys.argv[0])
    else:
        # Call the main function with the provided command-line arguments
        main(sys.argv)
