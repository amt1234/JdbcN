package com.bridgeit.programs;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import com.bridgeit.utility.Utility;

import java.sql.Connection;

public class StatementPre {

	public static void main(String[] args) {

		try {
			//resister driver class
			Class.forName("com.mysql.jdbc.Driver");

			//to establish connection
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/StatementDataBase", "root",
					"root");
			
			Statement statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery("select * from StatementTable");
			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3));
			}
			
			System.out.println("enter id :");
			int id = Integer.parseInt(Utility.inputString());
			
			System.out.println("enter the name :");
			String name = Utility.inputString();
			
			System.out.println("enter the post :");
			String post = Utility.inputString();
			
			int resultExe = statement.executeUpdate("insert into StatementTable values(" + id + ",'" + name + "','" + post + "')");
			// int resultExe=statement.executeUpdate("alter table StatementTablemodify column post varchar(20)");
		
			System.out.println(resultExe + " record affected");
			
			connection.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
