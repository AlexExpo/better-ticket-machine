/**
 * TicketMachine models a ticket machine that issues
 * flat-fare tickets.
 * The price of a ticket is specified via the constructor.
 * Instances will check to ensure that a user only enters
 * sensible amounts of money, and will only print a ticket
 * if enough money has been input.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class TicketMachine
{
    // The price of a ticket from this machine.
    private int price;
    // The amount of money entered by a customer so far.
    private int balance;
    // The total amount of money collected by this machine.
    private int total;
    
    private int prizeMachine;
    
    private int maximunTicket;
    
    private int sold;

    /**
     * Create a machine that issues tickets of the given price.
     * Si es una M�quina normal es o.
     * Si es una M�quina con premio es mayor o igual que 1.
     */
    public TicketMachine(int cost, int prize, int maximunSold)
    {
        price = cost;
        prizeMachine = prize;
        maximunTicket = maximunSold;
        balance = 0;
        total = 0;
        sold = 0;
    }

    /**
     * @Return The price of a ticket.
     */
    public int getPrice()
    {
        return price;
    }

    /**
     * Return The amount of money already inserted for the
     * next ticket.
     */
    public int getBalance()
    {
        return balance;
    }

    /**
     * Receive an amount of money from a customer.
     * Check that the amount is sensible.
     */
    public void insertMoney(int amount)
    {
        if(amount > 0) {
            balance = balance + amount;
        }
        else {
            System.out.println("Use a positive amount rather than: " +
                               amount);
        }
    }

    /**
     * Print a ticket if enough money has been inserted, and
     * reduce the current balance by the ticket price. Print
     * an error message if more money is required.
     */
    public void printTicket()
    {
        if (sold <= maximunTicket) {
            if (prizeMachine <= 0 && balance >= price) {
                // Simulate the printing of a ticket.
                System.out.println("##################");
                System.out.println("# The BlueJ Line");
                System.out.println("# Ticket");
                System.out.println("# " + price + " cents.");
                System.out.println("##################");
                System.out.println();
                sold = sold + 1;

                // Update the total collected with the price.
                total = total + price;
                // Reduce the balance by the prince.
                balance = balance - price;
        }
            else {
                System.out.println("You must insert at least: " +
                               (price - balance) + " more cents.");
                    
        }
        if (prizeMachine >=1) {
            System.out.println("##################");
            System.out.println("# The BlueJ Line");
            System.out.println("# Ticket");
            System.out.println("# " + price + " cents.");
            System.out.println("##################");
            System.out.println();
            
            System.out.println("##################");
            System.out.println("# The BlueJ Line");
            System.out.println("# Extra Ticket");
            System.out.println("# Free");
            System.out.println("##################");
            System.out.println();
        }
        
        if (sold > maximunTicket) {
            System.out.println("##################");
            System.out.println("ERROR");
            System.out.println("##################");
        }
    }
        
    }

    /**
     * Return the money in the balance.
     * The balance is cleared.
     */
    public int refundBalance()
    {
        int amountToRefund;
        amountToRefund = balance;
        balance = 0;
        return amountToRefund;
    }
    
    public int emptyMachine()
    {
        if (balance > 0) {
            return -1;
        }
        else {
            int emptyMachine = total;
            total = 0;
            return emptyMachine;
        }
        
    }   
}
