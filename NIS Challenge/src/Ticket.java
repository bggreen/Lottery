
public abstract class Ticket {
	protected int ticketValue;

	public int getTicketValue()
	{
		return this.ticketValue;
	}
	
	public String getTicketValueAsString()
	{
		return String.format("%03d", this.ticketValue);
	}
	
}
