package com.capg.wallet.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import com.capg.wallet.bean.Account;
import com.capg.wallet.bean.Customer;
import com.capg.wallet.exception.NotValidException;

public class WalletDao {
	List<Customer> list = new ArrayList<Customer>();
	List<Account> list1 = new ArrayList<Account>();
	List<String> list2 = new ArrayList<String>();
Account acc = new Account();
	public boolean addCustomerDetails(Customer customer) {
		list.add(customer);
		Iterator it = list.iterator();
		while (it.hasNext()) {
			Customer cust = (Customer) it.next();
			System.out.println(cust);
			return true;

		}
		return false;
	}

	public boolean addAccountDetails(Account account) {
		// TODO Auto-generated method stub

		list1.add(account);
		Iterator it = list1.iterator();
		while (it.hasNext()) {
			Account acc = (Account) it.next();
			System.out.println(acc);
			return true;

		}
		return false;
	}

	public void login(String username, String password) {
		Iterator<Customer> it = list.iterator();
		while (it.hasNext()) {
			Customer customer = (Customer) it.next();
			if (customer.getUsername().equals(username) && customer.getPassword().equals(password)) {
				System.out.println("Login Success...");
				 System.out.println("***********************************************");
			} else {
				System.err.println("Please enter valid login details");
				try
				{
				throw new	NotValidException();
				}
				catch(NotValidException e)
				{
					System.out.println(e);
				}
				System.exit(0);
			}

		}
	}

	public void deposit(double amount) {

	
		  acc.setBalance(1000);
           double bal = acc.getBalance();
           System.out.println("***********************************************");
           System.out.println("Initial balance:"+bal);
            double newbal = bal+amount;
            acc.setBalance(newbal);
			System.out.println("Available balance:"+newbal);
			 System.out.println("***********************************************");
			list2.add("Amount debited:"+amount+" on:"+LocalDate.now()+"");
			
			//System.out.println(list2);
		}
	
	public void withdraw(double withdrawAmount)
	{
		
		  
		
		Account account = new Account();
			double bal = acc.getBalance();
			 System.out.println("***********************************************");
			System.out.println("Initial balance:"+bal);
			double newbalance = bal-withdrawAmount;
			acc.setBalance(newbalance);
			System.out.println("Available balance:"+newbalance);
			 System.out.println("***********************************************");
			
			list2.add("Amount withdrawn:"+withdrawAmount+" on:"+LocalDate.now()+"");
			
		}
	
	public void showBalance()
	{
		double bal = acc.getBalance();
		System.out.println("Balance:"+bal);
	}
	public void fundTransfer(int accountNumber1,int accountNumber2)
	{
       System.out.println("Enter amount you want to transfer");	
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       double amount;
	try {
		amount = Integer.parseInt(br.readLine());
		int transactionId = (int) Math.random();
	       System.out.println("Transaction success..");
	       double bal = acc.getBalance();
	       double newbalance = bal-amount;
	       acc.setBalance(newbalance);
	       System.out.println("Your balance after fund transfer:"+newbalance);
	       System.out.println("***********************************************");
	       list2.add("Amount transferred:"+amount+" on:"+LocalDate.now()+"");
	} catch (NumberFormatException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       
	
	}
	
	
	public void printTransaction()
	{ 
		Random rand = new Random();
		//System.out.println("Transaction date:"+LocalDate.now());
		System.out.println("Transaction ID:"+rand.nextInt((1600 - 1000) + 1) + 1000);
		//		System.out.println("Account number:"+acc.getAccountNo());
		System.out.println("Transaction status: SUCCESS");
		System.out.println(list2);
	}
	
	
	
	
}	
	

