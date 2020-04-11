
public class Account
{
	//object variable declaration
	private double accountBalance;
	
	//since there are only two account types, checking and savings, I'll simply 'true' to checking and 'false' to savings.
	//not super important, but checking is 'true' because you can withdraw from it, whereas you can't withdraw from the savings so it's 'false'
	//easy decision :D
	private boolean accountType;
	//the rest of the object variable declaration
	private int accountNumber;
	private int numberOfTransactions;
	
	//object creation/definition
	public Account(double initialBalance, boolean accType)
	{
		this.accountBalance = initialBalance;
		this.accountType = accType;
		this.numberOfTransactions = 0;
	}
	
	//defines "deposit" method
	public void deposit(double money)
	{
		this.accountBalance = this.accountBalance + money;
		this.numberOfTransactions++;
		if(this.accountType == true)
			System.out.println("$"+money+" has been deposited into your Checking Account\n");
		else
			System.out.println("$"+money+" has been deposited into your Savings Account\n");
		
		compoundInterest();
	}
	
	//defines "withdraw" method
	public void withdraw(double money)
	{
		if(this.accountType == false)
			System.out.println("You can't withdraw from your savings account.\n");
		else if(money>this.accountBalance)
			System.out.println("You do not have the funds to make this withdrawl.\n");
		else
		{
			this.accountBalance = this.accountBalance - money;
			this.numberOfTransactions++;
			compoundInterest();
		}
	}
	
	//applies interest to the appropriate account
	public void compoundInterest()
	{
		if(this.accountType == false)
		{
			System.out.println("5% interest added to your Savings Account\n");
			this.accountBalance = this.accountBalance * 1.05;
		}
		else
		{
			System.out.println("3% interest added to your Checking Account\n");
			this.accountBalance = this.accountBalance * 1.03;
		}
	}
	
	//defines a method that prints the current account balance out for the user to see
	public void printBalance()
	{
		if(this.accountType == true)
			System.out.println("Your Checking Account Balance is: $"+this.accountBalance+"\n");
		else
			System.out.println("Your Savings Account Balance is: $"+this.accountBalance+"\n");
	}
}
