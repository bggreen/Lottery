
// -------------------------------------------------------------------------
/**
 * This class represents the action of extracting tickets and choosing customers
 *
 * @author Brian Green
 * @version May 17, 2016
 */
public class Drawing
{

    // ----------------------------------------------------------
    /**
     * Main Method, execute to run sim
     * @param args None
     */
    // The drawing is the action that drives the simulation therefore it is
    // treated as the main method
    public static void main(String[] args)
    {
        // Create ticket types
        Ticket pick3 = new Pick_3();
        Ticket pick4 = new Pick_4();
        Ticket pick5 = new Pick_5();

        // Place types and numbers into arrays then create Lottery Machine
        Ticket[] tickets = { pick3, pick4, pick5 };
        int[] amounts = { 50, 40, 60 };
        int overallFailedPurchases = 0;

        LotteryMachine lm = new LotteryMachine(tickets, amounts);

        // Dispense tickets to Customers
        int customerPID = 0;
        while (!lm.checkIfEmpty())
        {
            // Customers continue util sold out
            System.out.println("Customer PID:" + customerPID);
            Customer customer = new Customer(customerPID);
            customer.buyTickets(lm);
            overallFailedPurchases += customer.getTotalFailedPurchases();
            customerPID++;

            // Take winning numbers from machine
            // Duplicated static call, though low complexity
            int[] winningNumbers = { lm.getWinner(0).getTicketValue(),
                lm.getWinner(1).getTicketValue(),
                lm.getWinner(2).getTicketValue() };
            customer.checkIfWinner(winningNumbers);
        }
        System.out.println("\nTotal Customers: " + customerPID);
        System.out.println("Total Failed Purchases: " + overallFailedPurchases);
        System.out.println(
            "Winning numbers are: "
                + String.format("%03d", lm.getWinner(0).getTicketValue()) + "  "
                + String.format("%04d", lm.getWinner(1).getTicketValue()) + "  "
                + String.format("%04d", lm.getWinner(2).getTicketValue()));
    }

}
