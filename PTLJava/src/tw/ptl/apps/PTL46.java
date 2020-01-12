package tw.ptl.apps;
//測試 複製貼上 讀檔案 寫一遍讀到的檔案  此檔案為一次讀一個byte
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class PTL46 {

	public static void main(String[] args) {
		File src = new File("dir2/PTL.mp3");			//來源
		File dst = new File("dir1/PTL.mp3");			//要建立的目標位置的檔案
		try {
			long start = System.currentTimeMillis();
			FileInputStream fin = 			//先建立讀Stream	1.
					new FileInputStream(src);
			FileOutputStream fout =			//再來寫Stream	3.
					new FileOutputStream(dst);
			
			int b;										//	6.
			while( (b = fin.read()) != -1) {
				fout.write(b);
			}
			
			fout.flush();					//				4.
			fout.close();					//關寫Stream		5.
			fin.close();					//關讀Stream		2.
			System.out.println(System.currentTimeMillis() - start );
		}catch(Exception e) {
			System.out.println(e.toString());
		}
	}

}
