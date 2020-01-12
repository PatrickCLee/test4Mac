package tw.ptl.apps;
// read
import java.io.FileInputStream;

public class PTL43 {

	public static void main(String[] args) {
		try {
			FileInputStream fin = 
					new FileInputStream("dir2/file3.txt");
			int c;
			while( (c = fin.read() )!= -1) {  //判斷同時給值
			System.out.print((char)c);		//強制轉型
			}
			
//			while( fin.read() != -1) {		//此段不行，因每執行一次.read()
//				int a = fin.read();			//指標就會指向next byte
//				System.out.println((char)a);//判斷執行一次，code又執行一次
//			}
			
//			while(fin.available() > 0) {		// 或是寫成這樣
//				System.out.print((char)fin.read());
//			}
			
			fin.close();	//Stream有開就要關，建立時已開
			System.out.println();
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

}
