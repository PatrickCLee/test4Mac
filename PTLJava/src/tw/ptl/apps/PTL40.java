package tw.ptl.apps;
// 路徑

import java.io.File;

public class PTL40 {
	public static void main(String[] args) {
		File approot = new File(".");
		System.out.println(approot.getAbsolutePath());
		File dir1 = new File("./dir1");// 若省略.就是從根講起
//		File dir1 = new File("dir1");  或是寫成這樣
		System.out.println(dir1.exists());
		File dir2 = new File("dir2");
		if(!dir2.exists()) {
			dir2.mkdir();
		}
		File dir1234 = new File("dir1/dir2/dir3/dir4");
//		if(!dir1234.exists()) {
//			dir1234.mkdir();
//		}
		//上述寫法不行，因dir1存在但底下的dir2及dir3不在，無法在其底下創dir4
		if(!dir1234.exists()) {
			dir1234.mkdirs();
		}
		
		
	}

}
