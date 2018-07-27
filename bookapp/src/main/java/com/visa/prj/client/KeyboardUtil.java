package com.visa.prj.client;

import java.util.Scanner;

public class KeyboardUtil {
	public static int getInt(String msg) {
		System.out.println(msg);
		Scanner scanner = new Scanner(System.in);
		return scanner.nextInt();
	}
	
	public static String getString(String msg) {
		System.out.println(msg);
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}
	
	public static Double getDouble(String msg) {
		System.out.println(msg);
		Scanner scanner = new Scanner(System.in);
		return scanner.nextDouble();
	}
	
	
}
