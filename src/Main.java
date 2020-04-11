

import java.util.Scanner;
public class Main
{
	//initialize Scanner type variable scan for use later
	public static Scanner scan = new Scanner(System.in);
	//initialize other global variables
	public static boolean hasSavings = false;
	public static boolean hasChecking = false;
	
	//initially construct objects (as global variables)
	public static Account mySavings = new Account(0, false);
	public static Account myChecking = new Account(0, true);
	
	public static void main(String[] args) 
	{
		//calls 'create account' method
		createAccount();
		
		//calls 'transaction time' method for making transactions with each account
		transactionTime();
		
	}
	
	public static void createAccount()
	{
		//asks user if they want to open an account/what type while they 
		int result = -2;
		
		//repeats until user is done opening bank accounts
		while(result !=0)
		{
			System.out.println("Would you like to open: \n1)A Savings Account\n2)A Checking Account\n3)Neither\n\nPlease be careful not to create an account type that you already have as it will override your old account");
			int userInput = scan.nextInt();
			result = startupCheck(userInput);
			
			if(result == -1)
				System.out.println("That wasn't a valid option! Try again.\n");
			else if(result!=0)
			{
				//currently not completely functional
				if((userInput == 1 && hasSavings == true)||(userInput == 0 && hasChecking == true))
					System.out.println("You already have an account of that type!\n");
				else
				{
					//gathers initial deposit value for the account
					System.out.println("Alright! What will your initial deposit be?");
					double initialDeposit = scan.nextDouble();
					System.out.println("Creating new Account now...\nAccount Created!\n");
					
					if(userInput == 1)
					{
						mySavings = new Account(initialDeposit, false);
						hasSavings = true;
					}
					else
					{
						myChecking = new Account(initialDeposit, true);
						hasChecking = true;
					}
				}
			}
		}
	}
	
	
	public static void transactionTime()
	{
		System.out.println("Would you like to make a transaction?\n1)Yes\n2)No\n");
		int userResponse = scan.nextInt();
		
		if(userResponse == 2)
			System.out.println("Exiting program...");
		else if(userResponse != 1)
			System.out.println(">>Error: invalid response; Exiting program...");
		else
		{
			System.out.println("Would you like to:\n"+
		"1)Deposit\n2)Withdraw\n3)View Balance");
			int userChoice1 = scan.nextInt();
			
			System.out.println("With your: \n1)Checking Account\n2)Savings Account\n");
			int userChoice2 = scan.nextInt();

			if(userChoice1 == 1 || userChoice1 == 2)
			{
				System.out.println("How much $$ would you like to transfer?");
				double money = scan.nextDouble();
				
				if(userChoice1 == 1)
				{
					if(userChoice2 == 1)
						myChecking.deposit(money);
					else
						mySavings.deposit(money);
				}
				else if(userChoice1 == 2)
				{
					if(userChoice2 == 1)
						myChecking.withdraw(money);
					else
						mySavings.withdraw(money);
				}
			}
			else
			{
				if(userChoice2 == 1)
					myChecking.printBalance();
				else
					mySavings.printBalance();
			}
			
			transactionTime();
		}
	}
	
	
	public static int startupCheck(int userInput)
	{
		if(userInput == 1 || userInput == 2)
			return 1;
		else if(userInput == 3)
			return 0;
		else
			return -1;
	}

}