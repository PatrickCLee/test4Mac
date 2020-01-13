package tw.ptl.apps;
//TCP server端
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class PTL62 {

	public static void main(String[] args) {
		while (true) {
			try {
				ServerSocket server = new ServerSocket(7777);	//做出物件實體
				Socket socket = server.accept();		//等候，直到有人傳進來
				InputStream in = socket.getInputStream();	//取得進來的管道
				
				InetAddress urip = socket.getInetAddress();
				System.out.println(urip.getHostAddress());
				
				BufferedReader reader = new BufferedReader(	//用BufferReader因為可以一列一列讀
						new InputStreamReader(in));		//用Reader讀不然還要轉型別
				String line;
				while ((line = reader.readLine()) != null) {
					System.out.println(line);
				}
				in.close();
				server.close();
			}catch(Exception e) {
				System.out.println(e.toString());
			}
		}
	}

}
