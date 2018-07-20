package com.capg.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.capg.bank.entity.Account;
import com.capg.bank.entity.Customer;

public class BankDao {

	// private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	// private ResultSet rs = null;
	// private ResultSet rs1 = null;
	static ResultSet rsset;
	static String depositinfo,withdrawinfo,fundtransfer;
	Account account = new Account();
	static int acc;
	JdbcUtil util = new JdbcUtil();

	public int addCustomerDetails(Customer customer) {
		JdbcUtil util = new JdbcUtil();
		Connection connect = util.getConnection();

		try {

			Statement statement = connect.createStatement();

			PreparedStatement preparedStatement = connect
					.prepareStatement("insert into  bankdb.Customer values (?, ?, ?, ?, ? , ?, ?,?)");
			preparedStatement.setString(1, customer.getName());
			preparedStatement.setInt(2, customer.getAge());
			preparedStatement.setString(3, customer.getGender());
			preparedStatement.setInt(4, customer.getAadharNo());
			preparedStatement.setInt(5, customer.getPhoneNo());
			preparedStatement.setString(6, customer.getUsername());
			preparedStatement.setString(7, customer.getPassword());
			preparedStatement.setInt(8, customer.getAccountNo());
			int n = preparedStatement.executeUpdate();
			System.out.println(n + "rows inserted");
			connect.close();
			return n;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;

	}

	public int addAccountDetails(Account account) {
		// TODO Auto-generated method stub
		try {
			JdbcUtil util = new JdbcUtil();
			Connection connect = util.getConnection();

			Statement statement = connect.createStatement();

			PreparedStatement preparedStatement = connect
					.prepareStatement("insert into  bankdb.Account values ( ?, ?, ?, ? )");

			preparedStatement.setString(1, account.getBranch());
			preparedStatement.setString(2, account.getAccountType());
			preparedStatement.setInt(3, account.getBalance());
			preparedStatement.setInt(4, account.getAccountNo());
			int n = preparedStatement.executeUpdate();
			System.out.println(n + "rows inserted");
			connect.close();
			return n;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public boolean login(String username1, String password1) {
		// TODO Auto-generated method stub

		Connection connect = util.getConnection();

		try {
			Statement statement = connect.createStatement();
			String selectQuery = "select * from Customer";
			ResultSet rs = statement.executeQuery(selectQuery);

			while (rs.next()) {

				if (username1.equals(rs.getString("username")) && password1.equals(rs.getString("password"))) {// acc =
																												// rs.getInt(8);
					System.out.println("Login sucess....");
					System.out.println("-----------------------------------");
					storingResult(username1, password1);
					return true;
				}

			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;

	}

	private void storingResult(String username, String password) {

		Connection connect = util.getConnection();

		try {
			Statement statement = connect.createStatement();
			String selectQuery = "select * from Customer where username='" + username + "' AND password='" + password
					+ "'";
			rsset = statement.executeQuery(selectQuery);
			while(rsset.next())
			{
				acc = rsset.getInt("accountNo");
			}
			connect.close();} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public int deposit(int amount) {
		// int accountNo = acc;
		Connection connect = util.getConnection();
	 depositinfo = "Amount deposited is:"+amount;
	//	PreparedStatement pst;
		
		try {
		//	pst = connect.prepareStatement("insert into transactions values(?,?)");
         //   pst.setInt(1, acc);
         //   pst.setString(2, depositinfo);
         //   pst.executeUpdate();
			Statement statement = connect.createStatement();
		//	rsset=statement.executeQuery(sql)
			
			String selectQuery = "select * from Account where accountNo='" + acc + "'";

			ResultSet rsdeposit = statement.executeQuery(selectQuery);
			while (rsdeposit.next()) {
				int balance = rsdeposit.getInt(3);
				int balancenew = balance + amount;
				String query = "UPDATE Account SET balance='" + balancenew + "' where accountNo='" + acc + "'";
				PreparedStatement p;
				p = connect.prepareStatement(query);
				p.execute();
				System.out.println("Amount deposited...");
System.out.println("Available balance:"+balancenew);
System.out.println("-----------------------------------");
			}
			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//

		return 0;

	}

	public int withdraw(int amountWithdraw) {
		
		
		
		
		Connection connect = util.getConnection();
	 withdrawinfo = "Amount withdrawn is:"+amountWithdraw;
	//	PreparedStatement pst;
		try {
	//		pst = connect.prepareStatement("insert into transactions values(?,?)");
     //       pst.setInt(1, acc);
    //        pst.setString(2, withdrawinfo);
    //        pst.executeUpdate();
			
			Statement statement = connect.createStatement();
			
			String selectQuery = "select * from Account where accountNo='" + acc + "'";

			ResultSet rsdeposit = statement.executeQuery(selectQuery);
			while (rsdeposit.next()) {
				int balance = rsdeposit.getInt(3);
				int balancenew = balance - amountWithdraw;
				String query = "UPDATE Account SET balance='" + balancenew + "' where accountNo='" + acc + "'";
				PreparedStatement p;
				p = connect.prepareStatement(query);
				p.execute();
				System.out.println("Amount withdrawn...");
				System.out.println("Available balance:"+balancenew);
				System.out.println("-----------------------------------");
			}
			
			connect.close();
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return amountWithdraw;

	}
	

	public int showBalance() {
		
		Connection connect = util.getConnection();
		
		try {
			Statement statement = connect.createStatement();
			System.out.println("Account number:"+acc);
			String selectQuery = "select balance from Account where accountNo='" + acc + "'";
			
			ResultSet rsWithdraw = statement.executeQuery(selectQuery);
		//	System.out.println(rsWithdraw.next());
			if(rsWithdraw.first())
			{
			System.out.println("Your balance is:"+rsWithdraw.getInt("balance"));
			System.out.println("-----------------------------------");
			}
			return 1;} 
	catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			connect.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return 0;
		
	}
	public void fundTransfer(int amounttransfer,int accountNo2)
	{
		Connection connect = util.getConnection();
	fundtransfer = "Amount deposited :'"+amounttransfer+"'to account'"+accountNo2+"'";
		//PreparedStatement pst;
		try {
		//	pst = connect.prepareStatement("insert into transactions values(?,?)");
         // //  pst.setInt(1, acc);
         //   pst.setString(2, fundtransfer);
         //   pst.executeUpdate();
			Statement statement = connect.createStatement();
			String selectQuery = "select balance from Account where accountNo='" + acc + "'";
			ResultSet rssender= statement.executeQuery(selectQuery);
			if(rssender.first())
			{
			//System.out.println("Your balance is:"+rssender.getInt("balance"));
			int balance = rssender.getInt("balance");
		balance = balance-amounttransfer;
		System.out.println("The amount after transfer:"+balance);
		preparedStatement = connect.prepareStatement("UPDATE Account SET balance='"+ balance+"' where accountNo='" + acc + "'");
		int n = preparedStatement.executeUpdate();
		System.out.println(n+"rows updated");
				
			}
			String selectQuery2 = "select balance from Account where accountNo='" + accountNo2 + "'";
			ResultSet rsreceiver= statement.executeQuery(selectQuery2);
			if(rsreceiver.first())
			{
		//	System.out.println("Your balance is:"+rsreceiver.getInt("balance"));
			int balance2 = rsreceiver.getInt("balance");
			balance2 = balance2+amounttransfer;
			System.out.println("The amount debited:"+balance2);
			preparedStatement = connect.prepareStatement("UPDATE Account SET balance='"+ balance2+"' where accountNo='" + accountNo2 + "'");
			int n = preparedStatement.executeUpdate();
			System.out.println(n+"rows updated");
		
			}
			connect.close();
			}
			
			
			
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

		
		
	
}
	public void printTransaction()
	{   Connection connect = util.getConnection();
		Statement statement;
		try {
			statement = connect.createStatement();
			PreparedStatement pst;
			
				pst = connect.prepareStatement("insert into printTransaction values(?,?,?,?)");
	            pst.setInt(1, acc);
	            pst.setString(2, depositinfo);
	            pst.setString(3, withdrawinfo);
	            pst.setString(4, fundtransfer);
	            pst.executeUpdate();
			String selectQuery = "select * from printTransaction where accountNo='" + acc + "'";
			ResultSet transaction = statement.executeQuery(selectQuery);
		if(transaction.first())
			{
				System.out.println(transaction.getInt("accountNo"));
				System.out.println(transaction.getString("deposit"));
				System.out.println(transaction.getString("withdraw"));
				System.out.println(transaction.getString("fundTransfer"));
			}
				} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(acc);
		try {
			connect.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	}
