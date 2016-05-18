import org.junit.Test;

// -------------------------------------------------------------------------
/**
 *  Personal test class, can work as an executor if you want to test my code
 *  Not used for anything other than my or your debugging
 *
 *  @author Brian Green
 *  @version May 17, 2016
 */
public class LotteryMachineTest {

	@SuppressWarnings("javadoc")
    @Test
	public void LotteryMachineSanity() {
		Ticket pick3 = new Pick_3();
		Ticket pick4 = new Pick_4();
		Ticket pick5 = new Pick_5();

		Ticket[] tickets = 	{pick3, pick4, pick5};
		int[] amounts = 		{50,40,60};

		LotteryMachine lm = new LotteryMachine(tickets, amounts);
		System.out.print(lm.getWinner(0).getTicketValueAsString());
	}

}
