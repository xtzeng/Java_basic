package com.immutable.alias;

import org.junit.Test;

public class TryCatchFinallyTest {

    static String s="";  
    
    
	@Test
	public void test() {
		 s = a();  
	     System.out.println("8  "+s);
	}
	
	
	//结论：1.无论try里面有没有return语句，finally语句一定都会执行（不愧是finally，名字起的好）。
   // 2.如果finally中没有return语句，try里面有return，那么在执行try中的return语句之前会先去执行finally中的代码，再去执行try中的return语句；
	  //如果在finally中也包含return语句，将会直接返回，不再去执行try中的return语句。
	
	
	
	 public static String a(){  
         
	        try{  
	            System.out.println("try.....");  
	            return s = "a";  
	        }  
	        finally{  
	            s="b";    
	            System.out.println("17  "+s);  
	          //  return "hello";
	        }  
	    }  
}

