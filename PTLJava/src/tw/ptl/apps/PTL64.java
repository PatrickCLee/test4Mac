package tw.ptl.apps;
//用URL抓圖檔
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class PTL64 {

	public static void main(String[] args) {
		try {
			URL url = new URL("https://cnet1.cbsistatic.com/img/1gzKRz3KNXpEAjFXsecawMw2baI=/980x551/2018/07/16/87518406-dde9-41e5-b99b-8ae54755b4c6/jokers-heathledger-1.jpg");	
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.connect();
			
			BufferedInputStream bin = 
					new BufferedInputStream(conn.getInputStream());
			
			BufferedOutputStream bout = 
					new BufferedOutputStream(
							new FileOutputStream("dir2/joker.jpg"));
			
			byte[]buf = new byte[1024*1024]; int len;
			while((len = bin.read(buf)) != -1) {
				bout.write(buf, 0, len);
			}
			
			bout.flush();
			bout.close();
			bin.close();
			System.out.println("OK");
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
