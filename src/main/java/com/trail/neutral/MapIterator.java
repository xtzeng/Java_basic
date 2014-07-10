package com.trail.neutral;

import java.util.HashMap;
import java.util.Map;

public class MapIterator {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();

		map.put("a", 1);
		map.put("b", 2);
		map.put("c", 3);
		
		//方法一 在for-each循环中使用entries来遍历

		//这是最常见的并且在大多数情况下也是最可取的遍历方式。在键值都需要时使用。
		//注意：for-each循环在java 5中被引入所以该方法只能应用于java 5或更高的版本中。
		//如果你遍历的是一个空的map对象，for-each循环将抛出NullPointerException，因此在遍历前你总是应该检查空引用。
		for (Map.Entry<String, Integer> entry : map.entrySet()) {

		    System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());

		}
		
		
	}
}
