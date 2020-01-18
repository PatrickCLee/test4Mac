package tw.ptl.apps;
//爬蟲
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class PTL63 {

	public static void main(String[] args) {
		try {
			URL url = new URL("https://tw.stock.yahoo.com/q/bc?s=0050");	
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
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
