import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.junit.Test;


public class MapIteratorTest {

	
	@Test
	public void testForEach() {
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
	
	
	@Test
	public void testKeysOrValues() {
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("a", 1);
		map.put("b", 2);
		map.put("c", 3);

		//遍历map中的键
		for (String key : map.keySet()) {
		    System.out.println("Key = " + key);
		}

		//遍历map中的值
		for (Integer value : map.values()) {
		    System.out.println("Value = " + value);
		}
		
		//方法二 在for-each循环中遍历keys或values。
		//如果只需要map中的键或者值，你可以通过keySet或values来实现遍历，而不是用entrySet。
		//该方法比entrySet遍历在性能上稍好（快了10%），而且代码更加干净。
	}
	
	@Test
	public void testIterator() {
		Map<String, Integer> map = new HashMap<String, Integer>();

		map.put("a", 1);
		map.put("b", 2);
		map.put("c", 3);
		
		//方法三使用泛型
		Iterator<Map.Entry<String, Integer>> entries = map.entrySet().iterator();

		while (entries.hasNext()) {

		    Map.Entry<String, Integer> entry = entries.next();
		    System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());

		}
	}
	
	@Test
	public void testIterator2() {
		Map map = new HashMap();
		
		map.put("a", 1);
		map.put("b", 2);
		map.put("c", 3);
		
		//不使用泛型
		Iterator entries = map.entrySet().iterator();

		while (entries.hasNext()) {

		    Map.Entry entry = (Map.Entry) entries.next();

		    String key = (String)entry.getKey();

		    Integer value = (Integer)entry.getValue();

		    System.out.println("Key = " + key + ", Value = " + value);

		}
	}
	
	@Test
	public void testViaKey() {
		
		Map<String, Integer> map = new HashMap<String, Integer>();

		map.put("a", 1);
		map.put("b", 2);
		map.put("c", 3);
		
		//通过键找值遍历（效率低）
		//作为方法一的替代，这个代码看上去更加干净；但实际上它相当慢且无效率。
		//因为从键取值是耗时的操作（与方法一相比，在不同的Map实现中该方法慢了20%~200%）。
		//如果你安装了FindBugs，它会做出检查并警告你关于哪些是低效率的遍历。所以尽量避免使用。
		for (String key : map.keySet()) {

		    Integer value = map.get(key);

		    System.out.println("Key = " + key + ", Value = " + value);

		}
	}
	
	//总结
	//如果仅需要键(keys)或值(values)使用方法二。
	//如果你使用的语言版本低于java 5，或是打算在遍历时删除entries，必须使用方法三。否则使用方法一(键值都要)。
	
}
