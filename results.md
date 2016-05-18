# NIS Challenge: Brian Green

## The Approach
---
My approach to this project was to maximize extensibility and efficiency.  Although the project stated we would only need to support 3 ticket types the way this project was created allows support for any number of new types very easily.  I accomplished this by: 
  - Handling data in array format
  - Use of abstraction and reflection to handle ticket types
  - Magic(jk)

## The Details
---
### Drawing
In a real life lottery the drawing of the tickets and the announcement of the numbers is the primary driver of the transaction.  Because of this Drawing.java serves as the main method of the project.  In it we create our ticket types, lottery machine and customers.  Here we specify the types, order and amount of tickets we want distributed and we create the lottery machine and the customers who then use the machine.  In this class we can specify more or less tickets and create new classes of tickets if we want to.  After all the customers we create finish getting their tickets we finally print the details of the run.

### Customers 
The customer objects only have 2 real functions: buying tickets and checking if they won.   The former simply means making a lottery machine dispense tickets and record the faults and the ticket values while the latter is a comparison expected vs real to see if we won.  

### Lottery Machine 
This is where the magic happens.  The lottery machine expects arrays of arbitrary length defined by the types of tickets and the number of each - This means we can feed the LM any number of Ticket(Abstract class) type objects and their corresponding numbers and the LM will generate the tickets accordingly on creation.  Also on creation we pick and store the winning lottery numbers by their index in the array of tickets to be dispensed.  This means both selecting and checking if a ticket is a winner is a O(1) operation.  

After creation the only other major function outside of getters is the dispensing of tickets.  In order to do this we need to cross reference the ticket type to the number of them given on creation, check if we have any available and if so dispense them.  We do this by keeping an array of indexes of remaining tickets.  Each value of the array holds the number of available tickets which is decremented on dispensing until all tickets are gone.  

### Tickets
The tickets are very simple data structures which are all sub classes of the Ticket super class.  All operations on "Tickets" in the project rely on the methods defined in the abstract class while the sub classes are defined by the size to supply to the super class.  As an example Pick_3 serves as a version of Ticket where its value is a random number between 0 and 999 while Pick_4 is between 0 and 9999.  This reflection is what allows the the LM to treat all tickets the same but with different values.

## The Execution
---
### Running the project
I recommend cloning this project locally then importing it into an Eclipse work space.  By doing this you can simply hit the run bottom in Drawing.java and you can use the j unit tests I have written.  

### Reading the project
All of the requirements listed in the "Simulation Reporting" section of the spec can be found in the stdout of the java program. The types of tickets are listed as they are purchased. The number of failed attempts at purchases is printed at the end along with the winning numbers and total customers.  The winners can be found during execution shouting "I won with ticket:"  

Integrity of the project is secured through the use of arrays - any false input will cause errors at runtime.

### Testing the project 
Live changes to the parameters of the default running of the program can be made in the Drawing class where you can choose the ticket types and the number of tickets.  As well I have included the LMtest.java file which I used for personal simple sanity throughout testing.  Verification of valid results was done by manually parsing the logs and comparing them with the printouts of the arrays.   # need to cross reference the ticket type to the number of them given on creation, check if we have any available and if so dispense them.  We do this by keeping an array of indexes of remaining tickets.  Each value of the array holds the number of available tickets which is decremented on dispensing until all tickets are gone.  