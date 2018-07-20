package com.capg.bank.dao;

import com.capg.bank.entity.Account;
import com.capg.bank.entity.Customer;

public interface IBankDao {
	public int addCustomerDetails(Customer customer);
	public int addAccountDetails(Account account);
	public boolean login(String username,String password);
	public int deposit(int amount);
	public int withdraw(int amountWithdraw);
	public int showBalance();
	public void fundTransfer(int amounttransfer,int accountNo2);
	public void printTransaction();
}
