package com.bridgeit.programs;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.PreparedStatement;

public class ResultSetS {

	public static void main(String[] args) throws ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		try {
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/ResultSetDB","root","root");
		PreparedStatement preparedStement=connection.prepareStatement("select * from ResultSetTable",ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_UPDATABLE);
//		ResultSet resultSet=statement.executeQuery("select * from ResultSetTable");
		ResultSet resultSet=preparedStement.executeQuery();
		System.out.println(preparedStement.getResultSetType());
		while(resultSet.next())
		{
			resultSet.updateString(2,"xyz");
			System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2));
		}
		resultSet.previous();
		resultSet.previous();
		System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2));
//		resultSet.updateInt(2, 103);
//		resultSet.updateString(1,"xyz");
//		System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2));
		CallableStatement callableStatement=connection.prepareCall("{call insertR(?,?)}");
		callableStatement.setInt(1, 1011);
		callableStatement.setString(2, "poonam");
		callableStatement.execute();
		
		ResultSetMetaData resultSetMetaData=resultSet.getMetaData();
		
		System.out.println("Column count "+resultSetMetaData.getColumnCount());
		System.out.println("Column name "+resultSetMetaData.getColumnName(1));
		System.out.println("column type "+resultSetMetaData.getColumnTypeName(1));
		
		System.out.println("success");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
