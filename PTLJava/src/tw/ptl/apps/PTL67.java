package tw.ptl.apps;
//google 農委會 open data 經老師指示連到 http://data.coa.gov.tw/Service/OpenData/ODwsv/ODwsvTravelFood.aspx
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

import org.json.JSONArray;
import org.json.JSONObject;

public class PTL67 {

	public static void main(String[] args) {
		try {
			URL url = new URL("http://data.coa.gov.tw/Service/OpenData/ODwsv/ODwsvTravelFood.aspx");
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.connect();
			BufferedReader reader = 
					new BufferedReader(new InputStreamReader(conn.getInputStream()));
			StringBuffer sb = new StringBuffer();
			String line;
			while((line=reader.readLine()) != null) {//有資料就讀進來
				sb.append(line);					//用StringBuffer串起來
			}
			reader.close();
			System.out.println("Step 1 OK");
			parseJSON(sb.toString());
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	static void parseJSON(String json) {		
		try {
			Properties prop = new Properties();	//此段從66偷來的
			prop.put("user", "root");			//前parameter為參數名 後為value
			prop.put("password", "root");
			prop.put("serverTimezone", "Asia/Taipei");
			Connection conn = DriverManager.getConnection(	//得到實做connection界面的物件實體
					"jdbc:mysql://localhost:3306/iii", prop);
			
//			Statement stmt = conn.createStatement();	//此二行為後來新增 直接新增table和欄位 
//			stmt.execute("create table foodv2(id integer primary key auto_increment,fname varchar(255),tel varchar(255))");
//
//			stmt.executeUpdate("delete from food");		//此行也為後來新增 因為下方已經執行過
			
			String sql = "INSERT INTO food (fname,tel,addr,city,town,lat,lng,pic)"+
					" VALUES (?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql); //PreSta可避免隱碼攻擊, 各大語言都有此招
			
			
			JSONArray root = new JSONArray(json);
			for(int i = 0; i<root.length(); i++) {
				JSONObject row = root.getJSONObject(i);
				String fname = row.getString("Name");		//此處大小寫嚴格區分
				String tel = row.getString("Tel");
				String addr = row.getString("Address");
				String city = row.getString("City");
				String town = row.getString("Town");
				String latlng = row.getString("Coordinate");
				String lat = "", lng = "";
				try {
					String[] coor = latlng.split(",");
					lng = coor[0];
					lat = coor[1];
				} catch (Exception e) {
					lat = lng = "";
				}
				String pic = row.getString("PicURL");
				
				pstmt.setString(1, fname);	//參考https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setString-int-java.lang.String-
				pstmt.setString(2, tel);
				pstmt.setString(3, addr);
				pstmt.setString(4, city);
				pstmt.setString(5, town);
				pstmt.setString(6, lat);
				pstmt.setString(7, lng);
				pstmt.setString(8, pic);
				pstmt.executeUpdate();
			}
			
			System.out.println("Step 2 OK");
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

}
