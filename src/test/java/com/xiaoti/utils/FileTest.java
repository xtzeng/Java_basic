package com.xiaoti.utils;


import java.io.*;
public class FileTest{
   public static void main(String args[]){
      File f =new File("TileTest.java");
      String fileName = f.getName();
      String suffix = fileName.substring(fileName.lastIndexOf(".")+1);
      System.out.println(suffix);
  }
}
