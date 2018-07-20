package com.capg.bank.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.capg.bank.dao.BankDao;
import com.capg.bank.entity.Account;
import com.capg.bank.entity.Customer;
import com.capg.bank.service.BankService;
import com.capg.bank.service.Validation;

public class Client {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
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
				BankDao dao = new BankDao();
				// dao.getConnection();
				
				BankService service = new BankService();
				System.out.println("***Fill the below details for account creation***");
				System.out.println("Enter your name:");
				try {
					String name = br.readLine();
					boolean isValidName = valid.validateName(name);
					if (!isValidName)

					{
						System.err.println("Enter a valid name please:");
						name = br.readLine();

					}

					System.out.println("Enter your gender:(male/female/others)");
					String gender = br.readLine();
					boolean isValidGender = valid.validateGender(gender);
					if (!isValidGender) {
						System.err.println("Enter a valid gender please:");
						gender = br.readLine();
					}
					System.out.println("Enter your age:(>18)");
					int age = Integer.parseInt(br.readLine());
					boolean isValidAge = valid.validateAge(age);
					if (!isValidAge) {
						System.err.println("Enter a valid age please:");
						age = Integer.parseInt(br.readLine());
					}

					System.out.println("Enter your aadhar number:(10 digits)");
					int aadharNumber = Integer.parseInt(br.readLine());
					boolean isValidAadhar = valid.validateAadhar(aadharNumber);
					if (!isValidAadhar) {

						System.err.println("Enter a valid aadhar number please:");
						aadharNumber = Integer.parseInt(br.readLine());
					}
					System.out.println("Enter your phone number:");
					int phoneNumber = Integer.parseInt(br.readLine());
					boolean isValidPhone = valid.validatePhone(phoneNumber);
					if (!isValidPhone) {

						System.err.println("Enter a valid phone number please:");
						phoneNumber = Integer.parseInt(br.readLine());
					}

					System.out.println("Ënter new username:(length>3)");
					String username = br.readLine();
					boolean isValidUsername = valid.validateUsername(username);
					if (!isValidUsername) {
						System.err.println("Enter a valid username please:");
						username = br.readLine();
					}
					System.out.println("Ënter new password:");
					String password = br.readLine();
					boolean isValidPassword = valid.validateUsername(password);
					if (!isValidPassword) {
						System.err.println("Enter a valid password please:");
						password = br.readLine();
					}
					System.out.println("Enter your account number:");
					int accountNumber = Integer.parseInt(br.readLine());
					// System.out.println("Enter your account number:");
					// int accountNumber1 = Integer.parseInt(br.readLine());
					System.out.println("Enter your branch name:");
					String branchName = br.readLine();
					System.out.println("Enter your account type:(Savings/Current)");
					String accountType = br.readLine();
					boolean isValidAccountType = valid.validateAccountType(accountType);
					if (!isValidAccountType) {
						System.err.println("Enter a valid account type please:");
						accountType = br.readLine();
					}

					if (isValidAadhar && isValidAccountType && isValidGender && isValidName && isValidPassword
							&& isValidPhone && isValidUsername) {
						customer.setName(name);
						customer.setGender(gender);
						customer.setAge(age);
						customer.setAadharNo(aadharNumber);

						customer.setUsername(username);
						customer.setPassword(password);
						customer.setAccountNo(accountNumber);

						account.setAccountNo(accountNumber);
						account.setAccountType(accountType);
						account.setBalance(1000);
						account.setBranch(branchName);

						// service.addAccountDetails(account);

						System.out.println("Account added successfully...");
						service.addCustomerDetails(customer);
						service.addAccountDetails(account);

						/*
						 * System.out.println("***LOGIN***"); System.out.println("username:");
						 * 
						 * username = br.readLine(); System.out.println("password:"); password =
						 * br.readLine(); service.login(username, password);
						 * System.out.println("Welcome to wallet," + username);
						 */
						// bankOperation();
					} else {
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
				BankService service = new BankService();
				System.out.println("***LOGIN***");
				System.out.println("USERNAME:");
				String username;
				try {
					username = br.readLine();
					System.out.println("PASSWORD:");
					String password = br.readLine();
				boolean isValid = 	service.login(username, password);
if(isValid)
{		System.out.println("Welcome to wallet," + username);

					do {
						System.out.println("1.Deposit amount");
						System.out.println("2.Withdraw amount");
						System.out.println("3.Show balance");
						System.out.println("4.Fund transfer");
						System.out.println("5.Print transaction");
						System.out.println("6.Log out");
						System.out.println("-----------------------------------");
						choice = Integer.parseInt(br.readLine());
						switch (choice) {

						case 1:
							System.out.println("---You have entered DEPOSIT AMOUNT----");
							System.out.println("Enter the amount you want to deposit:");
							int amount = Integer.parseInt(br.readLine());
							service.deposit(amount);
							//isValid=true;
							break;
						case 2:
							System.out.println("---You have entered WITHDRAW AMOUNT----");
							System.out.println("Enter the amount you want to Withdraw:");
							int amountWithdraw = Integer.parseInt(br.readLine());
							service.withdraw(amountWithdraw);
							break;
						case 3:
							System.out.println("---You have entered SHOW BALANCE----");
							service.showBalance();
							break;
						case 4:
							System.out.println("---You have entered FUND TRANSFER----");
						System.out.println("Enter amount:");
						int amounttransfer = Integer.parseInt(br.readLine());
						System.out.println("Enter receiver's account number:");
						int accountNo2 = Integer.parseInt(br.readLine());
							service.fundTransfer(amounttransfer,accountNo2);
							break;
						case 5: System.out.println("---You have entered PRINT TRANSACTION----");
						service.printTransaction();
							break;
						case 6:
							break;

						}
					} while (choice > 6);
}
else
{
System.out.println("Login failed....");
}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			}

		}

	}
}
