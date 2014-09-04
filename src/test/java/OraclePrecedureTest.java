import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


public class OraclePrecedureTest {
	
    private final static String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
    private final static String DB_CONNECTION = "jdbc:oracle:thin:@localhost:1521:cgq";
    private final static String DB_NAME = "scott";
    private final static String DB_PWd = "tiger";
    private static Connection conn = null;  
    private static CallableStatement callStmt = null;
	
    @BeforeClass
    public static void berforClass() {
    	   System.out.println("-------  start 测试调用存储过程：无返回值");  
	      
	     
	       try {
			Class.forName(DB_DRIVER);  
			   conn = DriverManager.getConnection(DB_CONNECTION, DB_NAME, DB_PWd);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    }
    
    @AfterClass
    public static void afterClass() {
    	   if (null != callStmt) {  
               try {
				callStmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
           }  
           if (null != conn) {  
               try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
           } 
    }
    
    
	@Test
	public void testPrecNoOot() {
		
	       try {  
	           // 存储过程 TEST_MICHAEL_NOOUT 其实是向数据库插入一条数据  
	           callStmt = conn.prepareCall("{call P_TEST(?,?,?,?)}");  
	           // 参数index从1开始，依次 1,2,3...  
	           callStmt.setString(1, "jdbc2");  
	           callStmt.setString(2, "JDBC");  
	           callStmt.setDouble(3, 8000.00);  
	           callStmt.setTimestamp(4, new Timestamp(new Date().getTime()));
	           callStmt.execute();  
	           System.out.println("-------  Test End.");  
	       } catch (Exception e) {  
	           e.printStackTrace(System.out);  
	       } 
	}
	
}
