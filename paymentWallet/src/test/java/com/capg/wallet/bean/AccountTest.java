package com.capg.wallet.bean;

import junit.framework.TestCase;

public class AccountTest extends TestCase {

	Account account = new Account();
	


	public void testGetAccountNo() {
		assertEquals(1234, 1234);
		assertNotNull(account.getAccountNo());
		assertNotSame("1223", account.getAccountNo());
		assertNotSame("", account.getAccountNo());
	}

	

	public void testGetBranch() {
		
		assertEquals("chennai", "chennai");
	//	assertNotNull(account.getBranch());
		assertNotSame("1223", account.getBranch());
		assertNotSame("", account.getBranch());
	}

	

	public void testGetAccountType() {
		assertNotSame("savings", "current");
		assertEquals("savings", "savings");
	//	assertNotNull(account.getAccountType());
		assertNotSame("1223", "current");
		assertNotSame("", "savings");
	}

	

	public void testGetBalance() {
		assertEquals(1000,1000);
		assertNotSame(1000,0);
		assertNotSame(15000, 1500);
	}

	

	

}
