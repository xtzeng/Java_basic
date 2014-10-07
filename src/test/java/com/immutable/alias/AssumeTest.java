package com.immutable.alias;

import static org.hamcrest.Matchers.*; //指定接下来要使用的Matcher匹配符
import static org.junit.Assume.*; //指定需要使用假设assume*来辅助理论Theory
import static org.junit.Assert.*; //指定需要使用断言assert*来判断测试是否通过

import org.junit.experimental.theories.DataPoint;	//需要使用注释@DataPoint来指定数据集
import org.junit.experimental.theories.Theories; //接下来@RunWith要指定Theories.class 
import org.junit.experimental.theories.Theory; //注释@Theory指定理论的测试函数
import org.junit.runner.RunWith; //需要使用@RunWith指定接下来运行测试的类

import org.junit.Test;


public class AssumeTest {

	//@Test 注释表明接下来的函数是 JUnit4 及其以后版本的测试用例函数
	@Test
	public void testAssumptions() {
	    //假设进入testAssumptions时，变量i的值为10，如果该假设不满足，程序不会执行assumeThat后面的语句
		Integer i = 10;
	    assumeThat( i, is(10) );
	    //如果之前的假设成立，会打印"assumption is true!"到控制台，否则直接调出，执行下一个测试用例函数
	    System.out.println( "assumption is true!" );	
	}
}
