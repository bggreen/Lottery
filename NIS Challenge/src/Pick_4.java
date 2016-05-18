import java.util.Random;

public class Pick_4 extends Ticket {

	public Pick_4()
	{
		Random rn = new Random();
		this.ticketValue = rn.nextInt(10000);
	}
}
