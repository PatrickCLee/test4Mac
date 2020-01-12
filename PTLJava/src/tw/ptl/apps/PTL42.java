package tw.ptl.apps;
// flush & write
import java.io.FileOutputStream;

public class PTL42 {

	public static void main(String[] args) {
		try {
			FileOutputStream fout = 
					new FileOutputStream("dir2/file3.txt");//檔案若不在則建立新檔，檔案若在則內容清除
			fout.write("Hello, world".getBytes());	//String.getBytes()需注意
			fout.flush();
			fout.close();	//Stream有開就要關，開在建立時就開了
			System.out.println("OK");
		}catch(Exception e) {
			System.out.println(e.toString());
		}
	//檔案若不在，會建立新檔，檔案在則內容全部重置
	
	
	}

}
