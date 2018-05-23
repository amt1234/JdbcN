package com.bridgeit.programs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import com.bridgeit.utility.Utility;

public class Transaction {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// resister driver class
		Class.forName("com.mysql.jdbc.Driver");

		// to establish connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/PreparedStatementDB", "root",
				"root");
		try {
			// set autocommit to false
			connection.setAutoCommit(false);

			while (true) {
				System.out.println("enter id :");
				int id = Integer.parseInt(Utility.inputString());

				System.out.println("enter the name :");
				String name = Utility.inputString();

				System.out.println("enter the post :");
				String post = Utility.inputString();

				PreparedStatement preparedStement = connection
						.prepareStatement("insert into PreparedTable values(?,?,?)");
				preparedStement.setInt(1, id);
				preparedStement.setString(2, name);
				preparedStement.setString(3, post);

				int result = preparedStement.executeUpdate();
				System.out.println("successfully affected" + result);

				System.out.println("commit");
				connection.commit();
			}
		} catch (SQLException e) {
			System.out.println(e);

			System.out.println("rollback");
			connection.rollback();

		}
		connection.close();
	}

}
