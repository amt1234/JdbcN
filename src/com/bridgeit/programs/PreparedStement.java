package com.bridgeit.programs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import com.bridgeit.utility.Utility;

public class PreparedStement {

	public static void main(String[] args) throws ClassNotFoundException {
		//resister driver class
		Class.forName("com.mysql.jdbc.Driver");
		
		try {
			//to establish connection
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/PreparedStatementDB",
					"root", "root");

			System.out.println("enter id :");
			int id = Integer.parseInt(Utility.inputString());

			System.out.println("enter the name :");
			String name = Utility.inputString();

			System.out.println("enter the post :");
			String post = Utility.inputString();

			PreparedStatement preparedStement = connection.prepareStatement("insert into  PreparedTable values(?,?,?)");
			preparedStement.setInt(1, id);
			preparedStement.setString(2, name);
			preparedStement.setString(3, post);

			int Result = preparedStement.executeUpdate();
			System.out.println(Result + " record affected");

			connection.close();
		} catch (Exception e) {

			System.out.println(e);
		}

	}

}
