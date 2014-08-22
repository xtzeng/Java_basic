
package chp07;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Java_Transa {	
	
	// 数据库连接
	public static Connection getConnection() { 
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver"); // 加载Mysql数据驱动
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/test", "root", "root"); // 创建数据连接
		} catch (Exception e) {
			System.out.println("数据库连接失败");
		}
		return con;
	}
	
	// 判断数据库是否支持事务
	public static boolean JudgeTransaction(Connection con) {
		try {
			// 获取数据库的元数据
			DatabaseMetaData md = con.getMetaData();
			// 获取事务处理支持情况
			return md.supportsTransactions();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	// 将一组SQL语句放在一个事务里执行，要么全部执行通过，要么全部不执行
	public static void StartTransaction(Connection con, String[] sqls) throws Exception {
		
		if (sqls == null) {
			return;
		}
		Statement sm = null;
		try {
			// 事务开始
			System.out.println("事务处理开始！");
			con.setAutoCommit(false);	// 设置连接不自动提交，即用该连接进行的操作都不更新到数据库
			sm = con.createStatement();	// 创建Statement对象
			
			//依次执行传入的SQL语句
			for (int i = 0; i < sqls.length; i++) {
				sm.execute(sqls[i]);// 执行添加事物的语句
			}
			System.out.println("提交事务处理！");
			
			con.commit();	// 提交给数据库处理
			
			System.out.println("事务处理结束！");
			// 事务结束
			
		//捕获执行SQL语句组中的异常	
		} catch (SQLException e) {
			try {
				System.out.println("事务执行失败，进行回滚！\n");
				con.rollback();	// 若前面某条语句出现异常时，进行回滚，取消前面执行的所有操作
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			sm.close();
		}
	}

	// 查询表 staff
	public static void query_staff() throws Exception { 
		Connection conect = getConnection(); // 获取连接
		System.out.println("执行事物处理后，表 staff 的全部记录为：\n");
		try {
			String sql = "select * from staff"; 	// 查询数据的sql语句
			Statement st = (Statement) conect.createStatement(); 	// 创建Statement对象			
			ResultSet rs = st.executeQuery(sql); 	// 执行SQL语句并返回查询数据的结果集
			
			//打印输出查询结果
			while (rs.next()) { // 判断是否还有下一个数据
				// 根据字段名获取相应的值
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String sex = rs.getString("sex");
				String depart = rs.getString("depart");
				String address = rs.getString("address");
				String worklen = rs.getString("worklen");
				String wage = rs.getString("wage");
				System.out.println(name + " " + age + " " + sex + " "
						+ address + " " + depart + " " + worklen + " " + wage);
			}
			System.out.println();
			
		} catch (SQLException e) {
			System.out.println("查询数据失败");
		}
	}
	
	// 字符集的设定，解决中文乱码
	public static String charset(String str) throws Exception {
		String newStr = new String(str.getBytes("ISO8859-1"), "UTF-8");
		return newStr;
	}
	
	public static void main(String[] args) throws Exception {
		
		String[] arry = new String[4];	// 定义一组事物处理语句
		arry[0] = "delete from staff where name='Serein'";	//删除staff表格中 name 字段值为 "Serein" 的员工记录
		arry[1] = "UPDATE staff SET address='Shenzhen' where name='lili'";// 执行这条语句会引起错误，因为表 staff 中name='lili'不存在
		arry[2] = "INSERT INTO staff (name,age,sex,address,depart,worklen,wage)"	//SQL插入记录语句
				+ "values ('阿伦',19,'M','Beijing','Engine','4','4800')";	
		arry[3] = "select * from staff";	//SQL查询表 staff 语句
		Connection con = null;
		try {

			con = getConnection();     // 获得数据库连接
			boolean judge = JudgeTransaction(con);      // 判断是否支持批处理
			System.out.print("支持事务处理吗？ ");
			System.out.println(judge ? "支持" : "不支持");
			if (judge) {
				StartTransaction(con, arry);	// 如果支持则开始执行事务
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();   // 关闭数据库连接
		}
		query_staff();
	}	

}
