package com.immutable.alias;

import org.junit.Test;

import static org.junit.Assert.*;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers. *;

public class JUnitTest {

	// 匹配符 anyOf 表示任何一个条件满足则成立，类似于逻辑或 "||"， 匹配符 containsString 表示是否含有参数子字符串
	@SuppressWarnings("unchecked")
	@Test
	public void testAssertThat() {
		String s = "developerWorks";
		assertThat(s, anyOf(containsString("developesr"), containsString("Works"))); 
	}
	
	@Test
	public void testIs() {
		Integer x = 3;
		assertThat(x,is(3));
	}
	
	
	@Test
	public void testEqualTo() {
		System.out.println(equalTo("helloWorld"));
	}
	
	// 联合匹配符not和equalTo表示“不等于”
	@Test
	public void testNot() {
		String something = "Java_developer";
		assertThat( something, not( equalTo( "developer" ) ) ); 
	}
	
	
	@Test
	public void testNotContainsString() {
		// 联合匹配符not和containsString表示“不包含子字符串”
		String something = "java_Works";
		assertThat( something, not( containsString( "Works" ) ) ); 
	}
	
	
	@Test
	public void testAnyOfContainsString() {
		// 联合匹配符anyOf和containsString表示“包含任何一个子字符串”
		String something = "Java_Works";
		assertThat(something, anyOf(containsString("developer"), containsString("Works")));
	}
	
	@Test
	public void testMsg() {
		String s = "hello world!"; 
		assertThat( s, anyOf( containsString("developer"), containsString("Works") ) ); 
	}
	

	
}
