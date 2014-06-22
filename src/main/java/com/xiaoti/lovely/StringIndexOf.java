package com.xiaoti.lovely;

public class StringIndexOf {

	public static void main(String[] args) {
		String str = "Java is a programming language";
		
		if (str.indexOf("Java")!=-1) {
			System.out.println("String contains Java at index " + str.indexOf("Java"));
		}
		
		if (str.matches("J.*")) {
			System.out.println("String starts with J");
		}
		
		String str1 = "Do you like Java ME or Java EE";
		
		if (str1.lastIndexOf("Java")!=-1) {
			System.out.println("Str2 contains Java lastly at:" + str1.lastIndexOf("Java") );
		}
		
		String subString = str.substring(0,12);
		System.out.println("SubString：" + subString);
	}
}
