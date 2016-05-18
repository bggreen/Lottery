
// -------------------------------------------------------------------------
/**
 *  This abstract class is the basis of any number of pick_X tickets,
 *  if you wanted to make a pick_14 you could because the lottery only cares
 *  about being able to call the 2 getter methods in this AC
 *
 *  @author Brian Green
 *  @version May 17, 2016
 */
public abstract class Ticket {
	@SuppressWarnings("javadoc")
    protected int ticketValue;

	@SuppressWarnings("javadoc")
    public int getTicketValue()
	{
		return this.ticketValue;
	}

	@SuppressWarnings("javadoc")
    public String getTicketValueAsString()
	{
		return String.format("%03d", this.ticketValue);
	}

}
