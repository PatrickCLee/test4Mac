package tw.ptl.apps;
//測試 複製貼上 讀寫分開 先讀檔案 再寫一遍讀到的檔案
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class PTL48 {

	public static void main(String[] args) {
		File src = new File("dir2/PTL.mp3");
		File dst = new File("dir1/PTL.mp3");
		try {
			long start = System.currentTimeMillis();
			FileInputStream fin = 
					new FileInputStream(src);
			
			byte[] buf = new byte[(int)src.length()];//一次把資料丟到buffer，記得int限制所以檔案只能2G以內
			fin.read(buf);
			fin.close();
			
			FileOutputStream fout =
					new FileOutputStream(dst);
			fout.write(buf);
			fout.flush();
			fout.close();
			
			System.out.println(System.currentTimeMillis() - start );
		}catch(Exception e) {
			System.out.println(e.toString());
		}
	}

}
