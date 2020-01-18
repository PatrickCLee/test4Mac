package tw.ptl.apps;
//連線Connection的物件實體
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class PTL66 {

	public static void main(String[] args) {
//		try {								
//			Class.forName("com.mysql.cj.jdbc.Driver");	//載入Driver，新版JAVA會自動載入
//			System.out.println("OK");
//		}catch(Exception e){
//			System.out.println(e.toString());
//		}

		try {
//			Connection conn =				//第一招 全部連成一個字串
//					DriverManager.getConnection(
//							"jdbc:mysql://localhost:3306/iii?"	//冒號就是講話，jdbc跟mysql講話；問號帶參數
//							+ "user=root&password=root&serverTimezone=Asia/Taipei");//；此敘述句連到了伺服器且到了iii資料庫底下

		
//			Connection conn = 				//第二招 第二和第三parameters固定為帳號和密碼
//					DriverManager.getConnection(
//							"jdbc:mysql://localhost:3306/iii?serverTimezone=Asia/Taipei",
//							"root","root");
			
			Properties prop = new Properties();	//第三招 用屬性
			prop.put("user", "root");			//前parameter為參數名 後為value
			prop.put("password", "root");
			prop.put("serverTimezone", "Asia/Taipei");
			Connection conn = DriverManager.getConnection(	//得到實做connection界面的物件實體
					"jdbc:mysql://localhost:3306/iii", prop);
			Statement stmt = conn.createStatement();
//			stmt.executeUpdate("INSERT INTO cust (cname,tel,birthday)"//裡面是SQL語法	新增
//					+ " VALUES('謝謝你','123456','2000-01-01')");

//			stmt.executeUpdate("DELETE FROM cust WHERE id = 2");//刪除
			
//			stmt.executeUpdate("UPDATE cust SET cname='Pak', tel='654321' WHERE id = 1");//修
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM cust");//回傳RS物件, 內含資料內容
			
			while(rs.next()) {
				String id = rs.getString("id");			//雖然資料庫內id是數字，但抓取時可以直接定義為String
				String name = rs.getString("cname");
				String tel = rs.getString("tel");
				String birthday = rs.getString("birthday");
				System.out.println(id+":"+name+":"+tel+":"+birthday);
			}
			
			conn.close();
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}

}
