package com.trail.neutral;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayTest {

	public static void main(String[] args) {
		List<Integer> lstint = new ArrayList<Integer>();
	    lstint.add(1);
	    lstint.add(2);
	    lstint.add(3);
	    
	 // Iterator遍历一
	    Iterator<Integer> iterator = lstint.iterator();
	    while (iterator.hasNext()) {
		     int i = (Integer) iterator.next();
		     System.out.println("Iterator遍历一----"+i);
	    }
	    
	    // Iterator遍历二
	    for (Iterator<Integer> it = lstint.iterator(); it.hasNext();) {
	     int i = (Integer) it.next();
	     System.out.println("Iterator遍历二----"+i);
	    }
	    
	    // for循环
	    for (int i = 0; i < lstint.size(); i++) {
	     System.out.println("for循环----"+lstint.get(i));
	    }
	    
	    // for循环加强版
	    for (Integer i : lstint) {
	     System.out.println("加强版for循环----"+i);
	    }
	    
	}
}
