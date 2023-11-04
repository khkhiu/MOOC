In this exercise, you review and test the code in the Starter project, isolate and fix a logic issue, and then verify that your updated application is working as expected.

You complete the following tasks during this exercise:

    Code review: review the contents of the Program.cs file.

    The Program.cs includes the following code sections:
        Top-level statements: the top-level statements simulate a series of transactions using either an array of testData or a larger number of randomly generated transactions.
        LoadTillEachMorning: the LoadTillEachMorning method is used to configure the cash register till with a predefined number of bills in each denomination.
        MakeChange: the MakeChange method is used to manage the cash till during purchase transactions.
        LogTillStatus: the LogTillStatus method is used to display the number of bills of each denomination currently in the till.
        TillAmountSummary: the TillAmountSummary method is used display a message showing the amount of cash in the till.

    Initial testing: verify that MakeChange successfully balances the money till when using the testData array to simulate transactions.

    Code debugging: isolate and correct a logic issue that's exposed when using randomly generated data.

    Verification test: perform a verification test on the code you develop in this exercise.

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