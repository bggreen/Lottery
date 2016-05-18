import java.util.Arrays;
import java.util.Random;
/**
 * This class is the object representing the Lottery Machine in
 * the simulation.  This class is dependent on Ticket objects

 * @author  Brian Green
 * @version 2016.5.14
 */
public class LotteryMachine {

	// Instance Variables 
	private Ticket[] ticketTypes;
	private int[] avaliableTickets;
	public Ticket[][] allTickets;
	private int[] winningTickets;
	
	//Constructor
	/**
	 * This class is the object representing the Lottery Machine in
	 * the simulation.  This class is dependent on Ticket objects
	 * @author  Brian Green
	 * @version 2016.5.14
	 * 
	 * @param ticketArray - an array of Ticket Interface objects.  By 
	 * passing in this interface allow the lottery machine to handle 
	 * any number of types of tickets, even though we are only using 
	 * 3,4,5
	 * 
	 * @param ticketValues - an array of integers corresponding to the number 
	 * of tickets of each type to generate.  Doing this creates a margin of 
	 * user error but allows greater flexibility at run time 
	 */
	
	public LotteryMachine(Ticket[] ticketArray, int[] ticketValues)
	{
		// Instantiate passed variables
		this.ticketTypes = ticketArray;
		this.avaliableTickets = ticketValues;
		
		// Save the winning ticket indexes
		this.winningTickets = new int[avaliableTickets.length];
		
		// Make total ticket array large enough for all tickets
		int ticketsMax = getLargestValueinArray(avaliableTickets);
		this.allTickets = new Ticket[avaliableTickets.length][ticketsMax];
		
		// Populate the array with Tickets
		for (int i = 0; i < this.avaliableTickets.length; i++)
		{
			for (int j = 0; j < avaliableTickets[i]; j++)
			{
				// Store the ticket objects
				Ticket currentTicket = null;
				try {
					currentTicket = this.ticketTypes[i].getClass().newInstance();
					int ticketValue = currentTicket.getTicketValue();
					if (Arrays.asList(this.allTickets[i]).contains(ticketValue))
					{
						currentTicket = this.ticketTypes[i].getClass().newInstance();
					}
				} catch (InstantiationException | IllegalAccessException e) {
					System.out.println("Failed to generate a ticket on create");
					e.printStackTrace();
				}
				this.allTickets[i][j] = currentTicket;
			}
			// Choose a winner for each type
			int winningIndex = chooseWinningIndex(this.avaliableTickets[i]);
			this.winningTickets[i] = winningIndex;
		}
		
	}
	


	//Public Methods
	public Ticket dispenseTicket(Class<? extends Ticket> t)
	{
		// Get the index of the current ticket Type
		int index = 0;
		Class<? extends Ticket> wantedClass = t;
		for(int i = 0; i < this.ticketTypes.length; i++)
		{
			Class<? extends Ticket> currentClass = this.ticketTypes[i].getClass();
			if (currentClass.equals(wantedClass))
			{
				index = i;
			}
		}
		// If no tickets left here return null 
		if(this.avaliableTickets[index] == 0)
		{
			return null;
		}
		// Get the ticket at that index 
		int ticketsReaminingIndex = this.avaliableTickets[index];
		System.out.println("Buying ticket type:" + wantedClass.getName() + ", ticket numer: " + ticketsReaminingIndex);	
		Ticket dispensedTicket = this.allTickets[index][ticketsReaminingIndex-1];
		
		// Decrement the index
		this.avaliableTickets[index] = ticketsReaminingIndex-1;
		
		// Return Ticket
		return dispensedTicket;
	}
	
	public Ticket getWinner(int indexOfType )
	{
		int indexOfTicket = this.winningTickets[indexOfType];
		Ticket winner = allTickets[indexOfType][indexOfTicket];
		return winner;
	}
	
	public int[] getWinners()
	{
		return this.winningTickets;
	}
	public Ticket[] getTicketTypes()
	{
		return this.ticketTypes;
	}
	
	public boolean checkIfEmpty()
	{
		for (int i = 0; i < avaliableTickets.length; i++)
		{
			if(this.avaliableTickets[i] >= 1)
			{
				return false;
			}
		}
		return true;
	}
	// Private Methods
	/**
	 * Super basic random number generator
	 * 
	 * @param i - the max random number
	 */
	private int chooseWinningIndex(int i) {
		Random rn = new Random();
		int random = rn.nextInt(i);
		return random;
	}

	/**
	 * Basic max function for an array of ints
	 * 
	 * I could have used Collections ->List-> Max but 
	 * this is purely practice for myself
	 * 
	 * @param array - An integer array to get the largest value
	 */
	private int getLargestValueinArray(int[] array)
	{
		int max = 0;
		for (int counter = 0; counter < array.length; counter++)
		{
		     if (array[counter] > max)
		     {
		      max = array[counter];
		     }
		}
		return max;
	}
	
}
