package tw.ptl.apps;
// read 用File是因為要取得他的檔案大小
import java.io.File;
import java.io.FileInputStream;

public class PTL44 {

	public static void main(String[] args) {
		try {
			File file = new File("dir2/file3.txt");
			FileInputStream fin = 
					new FileInputStream(file);
			byte[] buf = new byte[(int)file.length()];//強制轉型成int所以檔案限制大小為2G
			fin.read(buf);
			System.out.println(new String(buf));

			fin.close();
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

}
