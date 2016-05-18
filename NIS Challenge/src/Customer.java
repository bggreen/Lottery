import java.util.concurrent.ThreadLocalRandom;
import java.util.Arrays;

// -------------------------------------------------------------------------
/**
 *  Customer represents the customer who will choose the number of tickets
 *  they want, Buy the tickets and check if they won
 *
 *  @author Brian Green
 *  @version May 17, 2016
 */
public class Customer {
	// Instance Variables
	private int PID;
	private int wantedTickets;
	private Ticket[] boughtTickets;
	private int failedPurchases = 0;

	// ----------------------------------------------------------
	/**
	 * Create a new Customer object. Choose number of tickets to buy
	 *
	 * @param id The ID to give the customer
	 */
	// Constructor
	public Customer(int id)
	{
		this.PID = id;
		this.wantedTickets =  ThreadLocalRandom.current().nextInt(1, 6);
		System.out.println("Customer want(s): " + wantedTickets + " ticket(s)" );
		this.boughtTickets = new Ticket[this.wantedTickets];
	}


	// ----------------------------------------------------------
	/**
	 * Check if any of the tickets the current customer bought won
	 * @param winners - Array of winning indexes
	 * @return - True if winner, false otherwise
	 */
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

	// ----------------------------------------------------------
	/**
	 * Given a lottery machine attempt to purchase the number of desired tickets
	 * chosen at creation.  Invoke dispenseTicket() until we either buy the
	 * tickets we want or the machine is empty
	 * @param lm - the lottery machine to buy from
	 */
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

	@SuppressWarnings("javadoc")
    public int getPID()
	{
		return this.PID;
	}
	@SuppressWarnings("javadoc")
    public int getTotalFailedPurchases()
	{
		return this.failedPurchases;
	}
	@SuppressWarnings("javadoc")
    public Ticket[] getBoughtTickets()
	{
		return this.boughtTickets;
	}

}
