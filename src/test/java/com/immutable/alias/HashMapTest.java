package com.immutable.alias;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class HashMapTest {

	@Test
	public void testView() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("a", "hello");
		map.put("b","world");
	}
}
