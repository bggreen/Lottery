import java.util.Random;

@SuppressWarnings("javadoc")
public class Pick_5 extends Ticket {

	public Pick_5()
	{
		Random rn = new Random();
		this.ticketValue = rn.nextInt(100000);
	}
}
