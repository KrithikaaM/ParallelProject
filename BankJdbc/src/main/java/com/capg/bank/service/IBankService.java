package com.capg.bank.service;

import com.capg.bank.entity.Account;
import com.capg.bank.entity.Customer;

public interface IBankService {

	public int addCustomerDetails(Customer customer);
	public int addAccountDetails(Account account);
	public boolean login(String username,String password);
	public int withdraw(int amountWithdraw);
	public int deposit(int amount);
	public int showBalance();
	public void fundTransfer(int amounttransfer,int accountNo2);
	public void printTransaction();
}
