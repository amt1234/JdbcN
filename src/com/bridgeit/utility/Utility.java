package com.bridgeit.utility;

import java.util.Scanner;

public class Utility {
	private static Scanner scanner = new Scanner(System.in);;

	// INPUT STRING
	public static String inputString() {
		try {
			return scanner.nextLine();
		} catch (Exception e) {
			System.out.println(e);
		}
		return "";
	}

	// INPUT Integer
	public static int inputInteger() {
		try {
			return scanner.nextInt();
		} catch (Exception e) {
			System.out.println("Invalid input try again");
			scanner.nextLine();
			return inputInteger();
		}
	}

}
