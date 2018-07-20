package com.capg.bank.service;

import com.capg.bank.exception.NotValidException;

public class Validation {

	public boolean validateName(String name) {
	    if(name.length()<4||name.matches("1234567890")||name.isEmpty())
	    {
			try
			{
				throw new NotValidException();
			}
			catch(NotValidException e)
			{
				System.err.println(e);
			}
	    }
	    return true;
		}

		public boolean validateGender(String gender) {
		if(gender.equalsIgnoreCase("male")||gender.equalsIgnoreCase("female")||gender.equalsIgnoreCase("other"))
		{		return true;
		}
		try
		{
			throw new NotValidException();
		}
		catch(NotValidException e)
		{
			System.err.println(e);
		}
		return false;
		}
		public boolean validateAadhar(int aadharNumber) {
			{
				char[] c = String.valueOf(aadharNumber ).toCharArray();
				
				if(c.length>10)
				{
					return false;
				}
			}
			return true;
		}

		public boolean validatePhone(int phoneNumber) {
			{
			char[] c = String.valueOf(phoneNumber ).toCharArray();
			
			if(c.length>10)
			{
				return false;
			}
			}
			
			return true;
		}

		public boolean validateUsername(String username) {
			
			if(username.isEmpty()||username.length()<4)
			{
				return false;
			}
			
			return true;
		}

		public boolean validateAccountType(String accountType) {
			if(accountType.equalsIgnoreCase("savings")||accountType.equalsIgnoreCase("current"))
			{
				return true;
			}
			return false;
		}

		public boolean validateAge(int age) {
			// TODO Auto-generated method stub
			if(age>=18)
			{
				return true;
			}
			try
			{
				throw new NotValidException();
			}
			catch(NotValidException e)
			{
				System.err.println(e);
			}
			return false;
		}

}
