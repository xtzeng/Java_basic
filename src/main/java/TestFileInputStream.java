
import java.io.*;
public class TestFileInputStream {
  public static void main(String[] args) {
    int b = 0;
    FileInputStream in = null;
    try {
      String relativelyPath = System.getProperty("user.dir");
      String path = relativelyPath + File.separator+"src"+ File.separator+ "main"+File.separator+"java"
        		+ File.separator + "TestFileInputStream.java";
      in = new FileInputStream(path);
      System.out.println(path);
    } catch (FileNotFoundException e) {
      System.out.println("找不到指定文件"); 
      System.exit(-1);
    }
    
    try {
      long num = 0;
      while((b=in.read())!=-1){
        System.out.print((char)b); 
        num++;
      }
      in.close();  
      System.out.println("共读取了 "+num+" 个字节");
    } catch (IOException e1) {
      System.out.println("文件读取错误"); System.exit(-1);
    }
  }
}