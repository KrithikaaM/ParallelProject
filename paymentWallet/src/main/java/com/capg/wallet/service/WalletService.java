package com.capg.wallet.service;

import com.capg.wallet.bean.Account;
import com.capg.wallet.bean.Customer;
import com.capg.wallet.dao.WalletDao;

public class WalletService {
WalletDao dao = new WalletDao();
	public boolean addCustomerDetails(Customer customer)
	{
		return dao.addCustomerDetails(customer);
	}
	public boolean addAccountDetails(Account account)
	{
		return dao.addAccountDetails(account);
	}
	public void login(String username,String password)
	{
		dao.login(username, password);
	}
	public void deposit(double amount)
	{
		 dao.deposit(amount);
	}
	public void withdraw(double withdrawAmount)
	{
		dao.withdraw(withdrawAmount);
	}
	public void showBalance() {
		dao.showBalance();
	}
	public void fundTransfer(int accountNumber1,int accountNumber2)
	{
		dao.fundTransfer(accountNumber1, accountNumber2);
	}
	public void printTransaction() {
		dao.printTransaction();
	}
	
}
