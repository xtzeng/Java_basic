package com.xiaoti.logger;

import org.junit.Test;

import com.immutable.alias.jdbc.TestMysqlConnection;

public class TestLogger {

	
	@Test
	public void test() {
		new TestMysqlConnection().test();
	}
}
