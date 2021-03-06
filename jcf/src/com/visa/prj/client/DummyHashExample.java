package com.visa.prj.client;

public class DummyHashExample {
	public static void main(String[] args) {
		String s1 = new String("Hello world");
		String s2 = new String("Hello world");
		
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		System.out.println(s1.equals(s2)); // true, because similar objects
		
		String s4 = new String("Aa");
		String s5 = new String("BB");
		System.out.println(s4.hashCode()); // hashCode and equals are method of java.utils.Object
		System.out.println(s5.hashCode());
		System.out.println(s4.equals(s5)); // false because same hash but different attributes
	}
}
