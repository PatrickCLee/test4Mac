package tw.ptl.apps;
// flush & write
import java.io.FileOutputStream;

public class PTL42 {

	public static void main(String[] args) {
		try {
			FileOutputStream fout = 
					new FileOutputStream("dir2/file3.txt");
			fout.write("Hello, world".getBytes());
			fout.flush();
			fout.close();
			System.out.println("OK");
		}catch(Exception e) {
			System.out.println(e.toString());
		}
	//檔案若不在，會建立新檔，檔案在則內容全部重置
	
	
	}

}
