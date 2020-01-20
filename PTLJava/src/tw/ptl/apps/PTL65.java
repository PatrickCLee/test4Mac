package tw.ptl.apps;
//爬蟲之後用它內部連結方式直接使用功能，跳過按鈕觸發視窗……
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class PTL65 {

	public static void main(String[] args) {
		String myurl = "https://www.gamer.com.tw";
		try {
			URL url = new URL("https://pdfmyurl.com/?url=" + myurl); //看到sourceCode的form底下input的name是url,  
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.connect();
			
			BufferedInputStream bin = 
					new BufferedInputStream(conn.getInputStream());
			
			BufferedOutputStream bout = 
					new BufferedOutputStream(
							new FileOutputStream("dir2/gamer.pdf"));
			
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
