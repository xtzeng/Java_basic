import java.io.*;
public class FileCopy {
  public static void main(String[] args) {
	  int b = 0;
	  FileReader in = null;
	  FileWriter out = null;
	  try {
		String relativelyPath = System.getProperty("user.dir");
		System.out.println(relativelyPath+ "\\src\\main\\java\\HelloWorld.java");
	    in = new FileReader(relativelyPath + "\\src\\main\\java\\HelloWorld.java");
	    //注意目录底下没有文件可以程序可以生成，但是没有目录或者目录不全会报FileNotFoundException
	    out = new FileWriter(relativelyPath + "/src/main/java/hw/hh.java");
	    while((b=in.read())!=-1){
	      out.write(b);
	    }
	    out.close();
	    in.close(); 
	    
	  } catch (FileNotFoundException e2) {
	    System.out.println("找不到指定文件"); System.exit(-1);
	  } catch (IOException e1) {
	    System.out.println("文件复制错误"); System.exit(-1);
	  }
	  System.out.println("文件已复制");
  }
}
