package com.xiaoti.utils;

import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;

public class ImageValidationUtil {

	
	/**
	 * 读取图片前两个字节
	 * @param src
	 * @return
	 */ 
	public static String bytesToHexString(byte[] src) { 
	    StringBuilder stringBuilder = new StringBuilder(); 
	    if (src == null || src.length <= 0) { 
	        return null; 
	    } 
	    for (int i = 0; i < src.length; i++) { 
	        int v = src[i] & 0xFF;//byte to int 
	        String hv = Integer.toHexString(v); 
	        if (hv.length() < 2) { 
	            stringBuilder.append(0); 
	        } 
	        stringBuilder.append(hv); 
	    } 
	    return stringBuilder.toString(); 
	} 
	 
	/**
	 * 通过判断图片的宽度和高度来确定是否是图片
	 * @param imageFile
	 * @return
	 */ 
	 public static boolean isImage(File imageFile) { 
		 
	        if (!imageFile.exists()) { 
	            return false; 
	        } 
	        Image img = null; 
	        try { 
	            img = ImageIO.read(imageFile); 
	            if (img == null || img.getWidth(null) <= 0 || img.getHeight(null) <= 0) { 
	                return false; 
	            } 
	            return true; 
	        } catch (Exception e) { 
	            return false; 
	        } finally { 
	            img = null; 
	        } 
	    } 
}
