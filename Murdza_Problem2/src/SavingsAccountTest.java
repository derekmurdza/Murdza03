public class SavingsAccountTest {

	public static void main(String[] args) {
		
		//Declare a Variable to Keep Track of the Monthly Increment
		int monthCount;
		
		// Set Account Balances to a Specified Amount
		SavingsAccount saver1 = new SavingsAccount(2000);
		SavingsAccount saver2 = new SavingsAccount(3000);
		
		// Set the Interest Rate to 4%
		SavingsAccount.modifyInterestRate(0.04);
		
		// Initialize the Output
		System.out.println("Here are the Current Balances:\n");
		
		//Format the Table to Contain the Month and Balances
		System.out.format("%-8s %8s %9s\n", "Month", "Saver1", "Saver2");
		
		// Call the Calculation Function to Determine the Updated Balance
		for (monthCount = 0; monthCount < 13; monthCount++) {
			saver1.calculateMonthlyInterest();
			saver2.calculateMonthlyInterest();
			
			// Format the Balances
			System.out.format("%-8d %9.2f %9.2f\n", monthCount + 1,
					saver1.savingsBalance, saver2.savingsBalance);
			
			// Change Interest Rate After the 12th Month
			if (monthCount == 11) {
				SavingsAccount.modifyInterestRate(0.05);
			}	
		}
	}
}
