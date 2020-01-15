package all.from.PTL;
// 練習傳檔案
// TCP server端 接收, 第一步確認收到, 第二步建立串流收資料
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class P62 {

	public static void main(String[] args) {
		while (true) {
			try {
				ServerSocket server = new ServerSocket(7003);	
				Socket socket = server.accept();		
				InputStream in = socket.getInputStream();	
				
				InetAddress urip = socket.getInetAddress();
				System.out.println(urip.getHostAddress());
			
				File file = new File("dir2/file4.txt");
				FileOutputStream fos = new FileOutputStream(file);
				byte[] buf = new byte[1024];
				int len;
				while( (len = in.read(buf)) != -1) {
					fos.write(buf,0,len);
				}
				
				fos.flush();
				fos.close();
						
				in.close();
				server.close();
			}catch(Exception e) {
				System.out.println(e.toString());
				break;
			}
		}
	}

}
