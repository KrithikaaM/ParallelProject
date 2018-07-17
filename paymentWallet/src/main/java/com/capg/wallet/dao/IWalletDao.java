package com.capg.wallet.dao;

import com.capg.wallet.bean.Account;
import com.capg.wallet.bean.Customer;

public interface IWalletDao {
	public boolean addCustomerDetails(Customer customer);
	public boolean addAccountDetails(Account account);
	public void login(String username,String password);
	public void deposit(double amount);
	public void withdraw(double withdrawAmount);
	public void showBalance();
	public void fundTransfer(int accountNumber1,int accountNumber2);
	public void printTransaction();
	
}
