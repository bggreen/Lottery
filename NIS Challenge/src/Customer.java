import java.util.concurrent.ThreadLocalRandom;
import java.util.Arrays;

public class Customer {
	// Instance Variables
	private int PID;
	private int wantedTickets;
	private Ticket[] boughtTickets;
	private int failedPurchases = 0;
	
	// Constructor
	public Customer(int id)
	{
		this.PID = id;
		this.wantedTickets =  ThreadLocalRandom.current().nextInt(1, 6);
		System.out.println("Customer want(s): " + wantedTickets + " ticket(s)" );
		this.boughtTickets = new Ticket[this.wantedTickets];
	}
	
	
	// Methods
	public boolean checkIfWinner(int[] winners)
	{
		boolean iWin = false;
		// Compare each of my tickets to each of the winners 
		// Double for loop is ok with small array size
		for(int i = 0; i < this.boughtTickets.length; i++)
		{
			// Edge case: Array has null value
			if (Arrays.asList(this.boughtTickets).contains(null))
			{
				break;
			}
			for(int j = 0; j < winners.length; j++)
			{
				
				if(this.boughtTickets[i].getTicketValue() == winners[j])
				{
					iWin = true;
					System.out.println("I won with ticket: " + boughtTickets[i].getTicketValueAsString() +"!" );
				}
			}
		}
		return iWin;
	}
	
	public void buyTickets(LotteryMachine lm)
	{
		// Pick a random ticket
		Ticket[] typeArray = lm.getTicketTypes();
		for(int i = 0; i < this.wantedTickets; i++)
		{
		int chosenIndex =  ThreadLocalRandom.current().nextInt(0, typeArray.length);
		Class<? extends Ticket> ticketClass = typeArray[chosenIndex].getClass();
		this.boughtTickets[i] = lm.dispenseTicket(ticketClass);;
		if (this.boughtTickets[i] == null)
			{
				i--;
				this.failedPurchases++;
				if(lm.checkIfEmpty())
				{
					break;
				}
			}
		}
	}
	
	public int getPID()
	{
		return this.PID;
	}
	public int getTotalFailedPurchases()
	{
		return this.failedPurchases;
	}
	public Ticket[] getBoughtTickets()
	{
		return this.boughtTickets;
	}

}
