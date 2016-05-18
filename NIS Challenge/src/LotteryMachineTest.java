import org.junit.Test;

public class LotteryMachineTest {

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
