package com.wu.crmdemo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import com.wu.crmdemo.entity.Customer;

public class CustomerDAO {
	
	String databaseDriver = "oracle.jdbc.driver.OracleDriver";
	String connectionURL = "jdbc:oracle:thin:@localhost:1521:XE"; 
	String userName = "scott"; 
	String passWord = "tiger";
	String sqlQuery = "SELECT * FROM Customer";
	
	
	public ArrayList<Customer>getCustomers(){
		ArrayList<Customer>customers = new ArrayList<Customer>();
		try {
			Class.forName(databaseDriver);
			Connection con = DriverManager.getConnection(connectionURL,userName,passWord);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sqlQuery);
			while(rs.next()) {
				Customer C1 = new Customer();
				C1.setFirstName(rs.getString(1));
				C1.setLastName(rs.getString(2));
				C1.setEmail(rs.getString(3));
				customers.add(C1);
			}
		con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return customers;
	}


	public void addCustomer(String fristName, String lastName, String email) {
		
		try {
			Class.forName(databaseDriver);
			Connection con = DriverManager.getConnection(connectionURL,userName,passWord);
			PreparedStatement stmt = con.prepareStatement("INSERT INTO Customer VALUES(?,?,?)");
			stmt.setString(3, email);stmt.setString(1, fristName);stmt.setString(2, lastName);
			int i = stmt.executeUpdate();
			System.out.println(i+"Record Inserted");
			con.commit();
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	public void updateCustomer(String fristName, String lastName, String email, String lastName1) {
		try {
			Class.forName(databaseDriver);
			Connection con = DriverManager.getConnection(connectionURL,userName,passWord);
			PreparedStatement stmt = con.prepareStatement("UPDATE Customer SET FIRST_NAME=?,LAST_NAME=?,EMAIL=? WHERE LAST_NAME =?");
			stmt.setString(3, email);stmt.setString(1, fristName);stmt.setString(2, lastName);stmt.setString(4, lastName1);
			int i = stmt.executeUpdate();
			System.out.println(i+"Record Inserted");
			con.commit();
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	public void deleteCustomer(String lastName) {
		try {
			Class.forName(databaseDriver);
			Connection con = DriverManager.getConnection(connectionURL,userName,passWord);
			PreparedStatement stmt = con.prepareStatement("DELETE FROM Customer WHERE LAST_NAME =? ");
			stmt.setString(1, lastName);
			int i = stmt.executeUpdate();
			System.out.println(i+"Record Inserted");
			con.commit();
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	

}
