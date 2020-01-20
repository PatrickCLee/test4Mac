package tw.ptl.apps;
//爬蟲, URL為普通class, URLC為抽象, 底下來自URLC的api
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
//The connection object is created by invoking the openConnection method on a URL.
//The setup parameters and general request properties are manipulated.
//The actual connection to the remote object is made, using the connect method.
//The remote object becomes available. The header fields and the contents of the remote object can be accessed.
public class PTL63 {

	public static void main(String[] args) {
		try {
			URL url = new URL("https://tw.stock.yahoo.com/q/bc?s=0050");		//做出url物件
			URLConnection cone = url.openConnection();	//將HURLC改為URLC並把後續conn都改為cone也可以跑, 但URLC物件也可代表ftp及mail和其他形式, 保險起見使用HURLC
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();	//url.opC()回傳URLC物件, HURLC為其子類別, 強制轉型
			conn.connect();					
			BufferedReader reader = 			
					new BufferedReader(
							new InputStreamReader(conn.getInputStream()));
			String line;
			while( (line = reader.readLine()) != null ) {
				System.out.println(line);
			}
			reader.close();
			
			
		}catch(Exception e) {
			
		}
	}
}

