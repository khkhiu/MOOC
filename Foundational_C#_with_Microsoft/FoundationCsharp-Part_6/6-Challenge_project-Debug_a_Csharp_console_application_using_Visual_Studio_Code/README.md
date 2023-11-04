Specification

In this challenge exercise, you need to configure the variables used to simulate transactions and verify that the transactions report includes the expected discrepancies.

The following requirements apply to the simulated transactions:

    top-level statements simulate transactions using randomly generated item costs.
    top-level statements generate random values for itemCost in the range 2 - 49.
    top-level statements simulate 100 transactions.

The reported transaction output must include:

    A record of 100 attempted transactions.
    Instances of a message stating: "Could not make transaction: InvalidOperationException: Not enough money provided to complete the transaction."
    Instances of a message stating: "Could not make transaction: InvalidOperationException: The till is unable to make change for the cash provided."
    A discrepancy between the reported an expected till values.

/*
This application manages transactions at a store check-out line. The
check-out line has a cash register, and the register has a cash till
that is prepared with a number of bills each morning. The till includes
bills of four denominations: $1, $5, $10, and $20. The till is used
to provide the customer with change during the transaction. The item 
cost is a randomly generated number between 2 and 49. The customer 
offers payment based on an algorithm that determines a number of bills
in each denomination. 

Each day, the cash till is loaded at the start of the day. As transactions
occur, the cash till is managed in a method named MakeChange (customer 
payments go in and the change returned to the customer comes out). A 
separate "safety check" calculation that's used to verify the amount of
money in the till is performed in the "main program". This safety check
is used to ensure that logic in the MakeChange method is working as 
expected.
*/
