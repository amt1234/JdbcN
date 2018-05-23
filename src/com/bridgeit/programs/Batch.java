package com.bridgeit.programs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.bridgeit.utility.Utility;

public class Batch {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/StatementDataBase", "root",
				"root");
		try {
			connection.setAutoCommit(false);

			Statement statement = connection.createStatement();

			boolean flag = true;

			while (flag) {
				System.out.println("want to enter data(y/n)?");
				String option = Utility.inputString();
				if (option.equals("y")) {
					System.out.println("enter the id");
					int id = Integer.parseInt(Utility.inputString());

					System.out.println("enter the name");
					String name = Utility.inputString();

					System.out.println("enter the post");
					String post = Utility.inputString();

					statement.addBatch("insert into StatementTable values(" + id + ",'" + name + "','" + post + "')");
				} else {
					flag = false;
				}
			}

			statement.executeBatch();

			System.out.println("commit");
			connection.commit();

		} catch (SQLException e) {

			System.out.println(e);
			System.out.println("rollback");
			connection.rollback();

		}

	}

}
