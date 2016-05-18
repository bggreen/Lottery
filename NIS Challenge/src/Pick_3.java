import java.util.Random;

public class Pick_3 extends Ticket {

	public Pick_3()
	{
		Random rn = new Random();
		this.ticketValue = rn.nextInt(1000);
	}
}
