package com.xiaoti.lovely;

public class StringCompareUsingEqualsMethod {

	
	public static void main(String[] args) {
		String name = "Java"; //1st String Object
		String name_1 = "Java"; //same object referenced by name variable
		String name_2 = new String("Java"); //different String object
		
		if(name.equals(name_1)){
			System.out.println("name and name_1 are equal String by equals method");
		}
		
		if (name.equals(name_2)) {
			System.out.println("name and name_2 are equal String by equals method");
		}
	}
}
