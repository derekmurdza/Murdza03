
public class SavingsAccount {
	
	// Define Interest Rate for All Accounts
	private static double annualInterestRate = 0;
	
	// Define the Savings Balance that will be Modified by the Interest Rate
	public double savingsBalance;
	
	// Initiate a New "Account"
	public SavingsAccount (double balance) {
		// Set the Balance to the Instance Variable
		savingsBalance = balance;
	}

	// Calculate the Savings Balance using the Monthly Interest Rate
	public void calculateMonthlyInterest() {
		savingsBalance += savingsBalance * (annualInterestRate / 12);
	}
	
	// Modify the Interest Rate
	public static void modifyInterestRate (double updatedRate) {
		annualInterestRate = updatedRate;
	}
}
