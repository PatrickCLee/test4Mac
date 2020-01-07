package tw.ptl.apps;
// 讀取試算表的資料 (每行一個人，用逗號隔開每筆屬性)
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class PTL50 {

	public static void main(String[] args) {
		try {
			FileInputStream fin = 
					new FileInputStream("dir2/Book1.csv");
			InputStreamReader irs = 
					new InputStreamReader(fin);
			BufferedReader reader =
					new BufferedReader(irs);
			String line;
			while( (line = reader.readLine()) != null ) {
				String[] data = line.split(",");
				System.out.println(data[1]);
			}
			
			fin.close();			//一個關全部關
			
		} catch (Exception e) {
			
		}
	}

}
