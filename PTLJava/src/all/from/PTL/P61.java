package all.from.PTL;
// 練習傳檔案, 發送端, 老師建議可先讀完後再一次發出去
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class P61 {

	public static void main(String[] args) {
		try {
			File src = new File("dir2/file3.txt");			//改成先讀
			FileInputStream fis = new FileInputStream(src);
			
			byte[] buf = new byte[(int)src.length()];		
		
			fis.read(buf);
			fis.close();									//讀完關閉
			
			Socket socket = new Socket(						//三方交握
					InetAddress.getByName("192.168.0.9"), 7003);
			OutputStream out = socket.getOutputStream();	
	
//			while( (len = fis.read(buf)) != -1) {	//邊讀邊寫
//				out.write(buf,0,len);
//			}		
			out.flush();
			out.close();
			socket.close();
			System.out.println("OK");
		}catch(Exception e) {
			System.out.println(e.toString());
		}
		
	}

}
