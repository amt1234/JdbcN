package com.bridgeit.programs;
import java.sql.*;
import com.bridgeit.utility.Utility;
public class JdbcConnector {
public static void main(String[] args) throws ClassNotFoundException, SQLException
{	
	try
	{
	Class.forName("com.mysql.jdbc.Driver");
	Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/FirstData","root","root");
	
	Statement statement=connection.createStatement();
	
	System.out.println("enter the id");
	int id=Utility.inputInteger();
	
	System.out.println("enter the name");
	String name=Utility.inputString();
	
	PreparedStatement preparedStatement=connection.prepareStatement("insert into JdbcConnect values(?,?)");
	preparedStatement.setInt(1, id);
	preparedStatement.setString(2,name);
	//ResultSet resultSet=statement.executeQuery("insert into table values(?,?)");
	
	int ex=preparedStatement.executeUpdate();
	System.out.println(ex);
//	while(resultSet.next())
//	{
//		System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2));
//	}                                                                                                                                                                                                                                   
	}catch (Exception e) {
		System.out.println(e);
	}
	
}
}
