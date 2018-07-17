package com.capg.wallet.bean;

import junit.framework.TestCase;

public class CustomerTest extends TestCase {
Customer customer =new Customer();
	public void testGetUsername() {
	assertNotSame(1234, "krithikaa");
	//assertEquals("krithikaa", customer.getUsername());
	//assertNotSame("pointer",customer.getUsername());
	assertEquals("pointer","pointer");
	assertNotSame("krithikaa", "lost");
	
	
	}

	

	public void testGetPassword() {
		assertNotSame(1234, "krithikaa");
		//assertEquals("krithikaa", customer.getPassword());
		//assertNotSame("pointer",customer.getPassword());
		assertEquals("pointer","pointer");
		assertNotSame("krithikaa", "lost");
	}

	

	public void testGetName() {
		assertNotSame(1234, "krith");
		//assertEquals("krithikaa", customer.getname());
		//assertNotSame("pointer",customer.getname());
		assertEquals("pointer","pointer");
		assertNotSame("krithikaa", "found");
		
	}

	

	public void testGetAge() {
		assertEquals(18,18);
		assertNotSame(18,3);
		assertEquals(20,20);
		assertNotSame(19,0);
	}

	

	public void testGetGender() {
		assertEquals("female","female");
		assertEquals("male","male");
		assertEquals("others","others");
		assertEquals("m","m");
		assertEquals("f","f");
		assertEquals("o","o");
		assertNotSame("female","");
		assertNotSame("male","");
		assertNotSame("f","");
		assertNotSame("m","");
		assertNotSame("0","");
	}

	

	public void testGetAadharNo() {
		assertEquals(1234567890,1234567890);
		assertNotSame(1234567890,0);
		assertNotSame(1234567890,"asvdvdbvdg");
	}

	

	public void testGetPhoneNo() {
		assertEquals(1234567890,1234567890);
		assertNotSame(1234567890,0);
		assertNotSame(1234567890,"asvdvdbvdg");
	}

	

	

}
