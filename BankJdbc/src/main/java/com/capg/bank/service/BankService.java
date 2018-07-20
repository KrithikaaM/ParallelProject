package com.capg.bank.service;

import com.capg.bank.dao.BankDao;
import com.capg.bank.entity.Account;
import com.capg.bank.entity.Customer;

public class BankService {
BankDao dao = new BankDao();
	public int addCustomerDetails(Customer customer)
	{
		return dao.addCustomerDetails(customer);
	}
	public int addAccountDetails(Account account)
	{
		return dao.addAccountDetails(account);
	}
	public boolean login(String username,String password)
	{
		return dao.login(username,password);
	}
	public int deposit(int amount)
	{
		return dao.deposit(amount);
	}
	public int withdraw(int amountWithdraw) {
		// TODO Auto-generated method stub
		return dao.withdraw(amountWithdraw);
		
	}
	public int showBalance() {
		// TODO Auto-generated method stub
		return dao.showBalance();
	}
	public void fundTransfer(int amounttransfer,int accountNo2) {
		 dao.fundTransfer(amounttransfer, accountNo2);
	}
	public void printTransaction() {
		// TODO Auto-generated method stub
		dao.printTransaction();
	}
}
