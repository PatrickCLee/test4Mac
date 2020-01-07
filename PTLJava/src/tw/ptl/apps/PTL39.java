package tw.ptl.apps;
// 跳脫字元以及路徑 建議都使用相對路徑
import java.io.File;

public class PTL39 {

	public static void main(String[] args) {
		System.out.println(File.pathSeparator);
		System.out.println(File.separator);
		
		File test1 = new File("c:\\PTL/test1");
		System.out.println(test1.exists());
		
		File[] roots = File.listRoots();
		for(File root : roots) {
			System.out.println(root.getAbsolutePath());
		}
	}

}
