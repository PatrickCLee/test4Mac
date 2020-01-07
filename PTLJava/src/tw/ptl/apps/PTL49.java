package tw.ptl.apps;
//使用reader一次讀取一個char 適合讀取文字資料
import java.io.FileReader;

public class PTL49 {

	public static void main(String[] args) {
		try {
			FileReader reader = new FileReader("dir2/file3.txt");
			int c;
			while( (c = reader.read()) != -1) {
				System.out.print((char)c);
			}
			reader.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}

}
