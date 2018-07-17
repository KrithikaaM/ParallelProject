package com.capg.wallet.bean;

import java.util.List;

public class Account {

	private int accountNo;
	private String branch;
	private String accountType;
	private double balance;
	
	
	
	public int getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", branch=" + branch + ", accountType=" + accountType + ", balance="
				+ balance + "]";
	}
	
	
	
	
	
}
