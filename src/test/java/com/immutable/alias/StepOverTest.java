package com.immutable.alias;

import org.junit.Test;

public class StepOverTest {

	
	@Test
	public void testStepOver() {
		
		System.out.println("hello");
		test();
		System.out.println("world");
	}
	
	
	public void test() {
		System.out.println("a");
		System.out.println("b");
		System.out.println("c");
	}
}
