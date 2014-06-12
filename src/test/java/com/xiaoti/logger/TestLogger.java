package com.xiaoti.logger;

import org.junit.Test;

import com.xiaoti.jdbc.TestMysqlConnection;

public class TestLogger {

	
	@Test
	public void test() {
		new TestMysqlConnection().test();
	}
}
