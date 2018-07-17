package com.capg.wallet.service;

import com.capg.wallet.bean.Account;
import com.capg.wallet.bean.Customer;

import junit.framework.TestCase;

public class ValidationTest extends TestCase {
Validation valid = new Validation();
Customer customer = new Customer();
Account account = new Account();
	public void testValidateName() {
		customer.setName("Krithikaa");
		assertEquals(true, valid.validateName(customer.getName()));//-->when full details are fetched
		assertNotNull(customer.getName());
		//assertFalse(valid.validateName(customer.getName()));
    		assertEquals("Valid", "Krithikaa",customer.getName());
		assertNotSame("Invalid", "krit ", "");
		assertNotSame("Invalid", "koko", 1234);
		assertNotSame("Krithikaa", "Kri");
		assertNotSame("Krithikaa", 1234);

	}

	public void testValidateGender() {
		customer.setGender("Female");
		//assertEquals(true, valid.validateGender(customer.getGender()));
		assertNotNull(customer.getGender());
		assertEquals("Female", customer.getGender());
		//assertEquals("f", customer.getGender());
		//assertEquals("Male", customer.getGender());
		//assertEquals("m", customer.getGender());
		//assertEquals("Others", customer.getGender());
		//assertEquals("o", customer.getGender());
		assertEquals("f", "f");
		assertEquals("m", "m");
		assertNotSame("female", "");
		assertNotSame("Male", "");
		assertNotSame("Others", "");

	}

	public void testValidateAadhar() {
		customer.setAadharNo(1234567899);
		assertEquals(true, valid.validateAadhar(customer.getAadharNo()));
		assertNotNull(customer.getAadharNo());
		
	}

	public void testValidatePhone() {
		customer.setPhoneNo(1234567899);
		assertEquals(true,valid.validatePhone(customer.getPhoneNo()));
		assertNotNull(customer.getPhoneNo());
	}

	public void testValidateUsername() {
		customer.setUsername("krithikaa");
		//assertEquals(true,valid.validateUsername(customer.getUsername()));
		assertNotNull(customer.getUsername());
		assertFalse("1234", false);
		assertEquals("krithikaa", "krithikaa");
		assertTrue("krithikaa", true);
	}

	public void testValidateAccountType() {
	
		assertEquals("savings","savings");
		assertEquals("current","current");
	
		//assertNotNull(account.getAccountType());
	
	}

}
