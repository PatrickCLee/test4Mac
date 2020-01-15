package all.from.PTL;
// 練習傳檔案
// TCP	用戶端 發送, 第一步確認對方有回應, 第二步傳資料需要串流
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class P61 {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket(
					InetAddress.getByName("192.168.0.9"), 7003);
			OutputStream out = socket.getOutputStream();	
			FileInputStream fis = new FileInputStream(
					new File("dir2/file3.txt"));
			byte[] buf = new byte[1024];
			int len;	
			while( (len = fis.read(buf)) != -1) {
				out.write(buf,0,len);
			}	
			out.flush();
			out.close();
			socket.close();
			System.out.println("OK");
		}catch(Exception e) {
			System.out.println(e.toString());
		}
		
	}

}
