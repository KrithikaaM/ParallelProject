package com.capg.wallet.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

import com.capg.wallet.bean.Account;
import com.capg.wallet.bean.Customer;
import com.capg.wallet.exception.NotValidException;
import com.capg.wallet.service.Validation;
import com.capg.wallet.service.WalletService;

public class Client {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static WalletService service = new WalletService();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("***Welcome to HDD bank**");
		System.out.println("1.New user              ");
		System.out.println("2.Login                 ");
        System.out.println("************************");
		int choice = sc.nextInt();
		switch (choice) {
		case 1: {
			Customer customer = new Customer();
			Account account = new Account();
			Validation valid = new Validation();
			WalletService service = new WalletService();
			System.out.println("***Fill the below details for account creation***");
			System.out.println("Enter your name:");
			try {
				 String name = br.readLine();
				 boolean isValidName = valid.validateName(name);
				 if(!isValidName)
				 
				 {
					 System.err.println("Enter a valid name please:");
					 name = br.readLine();
					 
				 }
				
				System.out.println("Enter your gender:(male/female/others)");
				String gender = br.readLine();
				 boolean isValidGender = valid.validateGender(gender);
				 if(!isValidGender)
				 {
					 System.err.println("Enter a valid gender please:");
					 gender = br.readLine();
				 }
				System.out.println("Enter your age:");
				int age = Integer.parseInt(br.readLine());
				boolean isValidAge = valid.validateAge(age);
				 if(!isValidAge)
				 {
					 System.err.println("Enter a valid age please:");
					 age = Integer.parseInt(br.readLine());
				 }
				
				System.out.println("Enter your aadhar number:(10 digits)");
				int aadharNumber = Integer.parseInt(br.readLine());
				boolean isValidAadhar = valid.validateAadhar(aadharNumber);
				if(!isValidAadhar)
				{
					 
						 System.err.println("Enter a valid aadhar number please:");
						 aadharNumber = Integer.parseInt(br.readLine());
				 }				
				System.out.println("Enter your phone number:");
				int phoneNumber = Integer.parseInt(br.readLine());
				 boolean isValidPhone = valid.validatePhone(phoneNumber);
				 if(!isValidPhone)
				 {

					 System.err.println("Enter a valid phone number please:");
					 phoneNumber = Integer.parseInt(br.readLine());
				 }
				
				System.out.println("Ënter new username:(length>3)");
				String username = br.readLine();
				 boolean isValidUsername = valid.validateUsername(username);
				 if(!isValidUsername)
				 {
					 System.err.println("Enter a valid username please:");
					 username = br.readLine();
				 }
				System.out.println("Ënter new password:");
				String password = br.readLine();
				  boolean isValidPassword = valid.validateUsername(password);
				  if(!isValidPassword)
				  {
					  System.err.println("Enter a valid password please:");
					  password = br.readLine();
				  }
				System.out.println("Enter your account number:");
				int accountNumber = Integer.parseInt(br.readLine());
				System.out.println("Enter your branch name:");
				String branchName = br.readLine();
				System.out.println("Enter your account type:(Savings/Current)");
				String accountType = br.readLine();
				boolean isValidAccountType = valid.validateAccountType(accountType);
				if(!isValidAccountType)
				{
					 System.err.println("Enter a valid account type please:");
					 accountType = br.readLine();
				}
                
               
               
              
                
                if(isValidAadhar&&isValidAccountType&&isValidGender&&isValidName&&isValidPassword&&isValidPhone&&isValidUsername)
                {
				customer.setName(name);
				customer.setGender(gender);
				customer.setAge(age);
				customer.setAadharNo(aadharNumber);
				customer.setPhoneNo(phoneNumber);
				customer.setUsername(username);
				customer.setPassword(password);

				account.setAccountNo(accountNumber);
				account.setAccountType(accountType);
				account.setBalance(1000);
				account.setBranch(branchName);

				service.addCustomerDetails(customer);
				service.addAccountDetails(account);

				System.out.println("Account added successfully...");
				System.out.println("***LOGIN***");
				System.out.println("username:");

				username = br.readLine();
				System.out.println("password:");
				password = br.readLine();
				service.login(username, password);
				System.out.println("Welcome to wallet," + username);
				bankOperation();
                }
                else
                {
                	System.err.println("Please enter valid details");
                System.exit(0);
             
                }
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;
		}

		case 2: {
			WalletService service = new WalletService();
			System.out.println("***LOGIN***");
			System.out.println("USERNAME:");
			String username;
			try {
				username = br.readLine();
				System.out.println("PASSWORDS:");
				String password = br.readLine();
				service.login(username, password);
				System.out.println("Welcome to wallet," + username);
				bankOperation();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		}

	}

	private static void bankOperation() throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		System.out.println("1.Deposit amount");
		System.out.println("2.Withdraw amount");
		System.out.println("3.Show balance");
		System.out.println("4.Fund transfer");
		System.out.println("5.Print transaction");
		System.out.println("6.Log out");
		int choice;
		do {
			Scanner sc = new Scanner(System.in);
			choice = sc.nextInt();

			switch (choice) {

			case 1:
				// WalletDao dao = new WalletDao();
				System.out.println("You have chosen to deposit amount..");
				System.out.println("Enter amount you would like to deposit");

				double amount = Double.parseDouble(br.readLine());
				service.deposit(amount);
				Random rand = new Random();
				int tid = rand.nextInt((1600 - 1000) + 1) + 1000;
				
				// System.out.println("Deposit success:"+amount);

				break;
			case 2:
				System.out.println("You have chosen to withdraw amount..");
				System.out.println("Enter amount you would like to withdraw");

				double withdrawAmount = Double.parseDouble(br.readLine());
				service.withdraw(withdrawAmount);
				break;
			case 3:
			
				System.out.println("You have chosen to show balance:");
				service.showBalance();
				break;
			case 4:
			{
				Customer customer = new Customer();
				Account account = new Account();
				System.out.println("You have chose for fund transfer");
				System.out.println("Enter your account number:");
				int accountNumber1 = Integer.parseInt(br.readLine());
				System.out.println("Enter receiver's account number:");
				int accountNumber2 = Integer.parseInt(br.readLine());
				
				service.fundTransfer(accountNumber1, accountNumber2);
				}
				
				break;
			case 5:
				System.out.println("You have chosen to print transaction");
				service.printTransaction();
				break;
			case 6: 
				System.out.println("Logged out successfully !!");
				System.exit(0);
				break;
			default:
					try
					{
					throw new	NotValidException();
					}
					catch(NotValidException e)
					{
						System.out.println(e);
					}
			}

		} while (choice != 7);
	}
}