import java.util.Random;

// -------------------------------------------------------------------------
/**
 *  We create pick_x classes to allow the user to very easity expand
 *  this testing.  We can simply create pick_6.java and add it to the drawing
 *
 *  @author Brian Green
 *  @version May 17, 2016
 */
public class Pick_3 extends Ticket {

	@SuppressWarnings("javadoc")
    public Pick_3()
	{
		Random rn = new Random();
		this.ticketValue = rn.nextInt(1000);
	}
}
