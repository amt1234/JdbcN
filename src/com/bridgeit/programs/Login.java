package com.bridgeit.programs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.bridgeit.utility.Utility;

public class Login {

	public static void main(String[] args) throws ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/StatementDataBase", "root",
					"root");

			Statement statement = connection.createStatement();
			System.out.println("enter username :");
			String name = Utility.inputString();

			System.out.println("enter id");
			int id = Utility.inputInteger();

			ResultSet resultSet = statement
					.executeQuery("select * from StatementTable where id=" + id + " and name='" + name + "'");
			System.out.println("select * from StatementTable where id=" + id + " and name='" + name + "'");

			while (resultSet.next()) {
				System.out.println("successfully " + resultSet.getInt(1) + " " + resultSet.getString(2));
				// }else
				// {System.out.println("invalid");
			}
		} catch (Exception e) {

			System.out.println(e);
		}

	}

}
