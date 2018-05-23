package com.bridgeit.programs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.bridgeit.utility.Utility;

import java.sql.PreparedStatement;

public class InsertImage {

	public static void main(String[] args) throws ClassNotFoundException, FileNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/InsertDb", "root", "root");
		String file="/home/bridgelabz/ub/poonam/htmlJS-master/angular app/assets/fwdphoneimages/";
		try {
			
		
			System.out.println("Enter the image name :");
			String name=Utility.inputString();
			
			PreparedStatement preparedStement=connection.prepareStatement("insert into InserImageTable values(?,?)");
			preparedStement.setString(1,name);
			
			System.out.println("Enter the photoName");
			String imagename=Utility.inputString();
			
			FileInputStream fileInputStream=new FileInputStream(file+imagename+".png");
			preparedStement.setBinaryStream(2, fileInputStream);
			
			int record=preparedStement.executeUpdate();
			System.out.println("record affected "+record);
		} catch (SQLException e) {
				System.out.println(e);
				connection.close();
		}
		
	}

}
