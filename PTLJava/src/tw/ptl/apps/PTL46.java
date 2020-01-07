package tw.ptl.apps;
//測試 複製貼上 讀檔案 寫一遍讀到的檔案  此檔案為一次讀一個byte
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class PTL46 {

	public static void main(String[] args) {
		File src = new File("dir2/PTL.mp3");
		File dst = new File("dir1/PTL.mp3");
		try {
			long start = System.currentTimeMillis();
			FileInputStream fin = 
					new FileInputStream(src);
			FileOutputStream fout =
					new FileOutputStream(dst);
			
			int b;
			while( (b = fin.read()) != -1) {
				fout.write(b);
			}
			
			fout.flush();
			fout.close();
			fin.close();
			System.out.println(System.currentTimeMillis() - start );
		}catch(Exception e) {
			System.out.println(e.toString());
		}
	}

}
