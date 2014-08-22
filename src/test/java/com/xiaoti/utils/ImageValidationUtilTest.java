package com.xiaoti.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import com.immutable.alias.utils.ImageValidationUtil;


public class ImageValidationUtilTest {

	public static void main(String[] args) throws IOException {
		
	    String imagePath = "C:\\beach.jpg"; 
	    File image = new File(imagePath); 
	    InputStream is = new FileInputStream(image); 
	    //读取两个byte 
	    byte[] bt = new byte[2];   
	    is.read(bt); 
	    System.out.println(ImageValidationUtil.bytesToHexString(bt));//output 8950 
	     
	    boolean b = ImageValidationUtil.isImage(image); 
	    System.out.println(b); 
	} 
}
