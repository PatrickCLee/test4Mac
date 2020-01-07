package tw.ptl.apps;
//測試 複製貼上 讀檔案 寫一遍讀到的檔案
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class PTL47 {

	public static void main(String[] args) {
		File src = new File("dir2/PTL.mp3");
		File dst = new File("dir1/PTL.mp3");
		try {
			long start = System.currentTimeMillis();
			FileInputStream fin = 
					new FileInputStream(src);
			FileOutputStream fout =
					new FileOutputStream(dst);
			
			int len; byte[] buf = new byte[4096*1024];//一次讀4MB 邊讀邊寫
			while( (len = fin.read(buf)) != -1) {
				fout.write(buf,0,len);
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
