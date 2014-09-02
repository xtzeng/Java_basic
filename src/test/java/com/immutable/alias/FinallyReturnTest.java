package com.immutable.alias;

import org.junit.Test;

public class FinallyReturnTest {

	
	public static int tt(){   
	     int b = 23;   
	     try{   
	    	 System.out.println("yes");
	    	 b += 88;
	    	 return  b;   
	     }catch(Exception e){   
	    	 System.out.println("error: " + e);   
	     }finally{   
	    	 if(b>25){   
	    		 b += 1000;
	    		 System.out.println("【b>25:】"+b);
	    		 
	    		 b = 100;
	    		// return b;
	    		 //结论，在finally里加return会把try里的return覆盖掉
	    	 }   
	    	 
	    	 System.out.println("finally");   
	     }
	     
	     return b;   
	}
	
	@Test
	public void testFinallyReturn() {
		System.out.println(tt());
	}
}
