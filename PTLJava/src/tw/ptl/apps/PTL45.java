package tw.ptl.apps;
// 一次讀3bytes
import java.io.FileInputStream;

public class PTL45 {
	public static void main(String[] args) {
		try {
			FileInputStream fin = 
				new FileInputStream("dir2/file3.txt");
			byte[] buf = new byte[3]; int total = 0;
			while ( (total = fin.read(buf)) != -1) {
				System.out.print(new String(buf));
			}
			
//			while (fin.available() > 0) {		//遇到中文就破功
//				System.out.print((char)fin.read());
//			}
			
			
			fin.close();
			System.out.println("OK");
		}catch(Exception e) {
			System.out.println(e.toString());
		}
	}
}
