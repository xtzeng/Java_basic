import java.io.*;

public class TestFileWriter2 {
	public static void main(String[] args) throws Exception {
		String relativelyPath = System.getProperty("user.dir");
		FileReader fr = new FileReader(relativelyPath+ "/src/main/java/TestFileWriter2.java");
		FileWriter fw = new FileWriter(relativelyPath+ "/src/main/java/TestFileWriter2.bak");
		int b;
		while((b = fr.read()) != -1) {
			fw.write(b);
		}
		fr.close();
		fw.close();
	}
}