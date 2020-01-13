package tw.ptl.apps;
// 結合49 50的寫法, 只要接兩個管子
import java.io.BufferedReader;
import java.io.FileReader;

public class PTL51 {

	public static void main(String[] args) {
		try {
			BufferedReader reader =
					new BufferedReader(
							new FileReader("dir2/Book1.csv"));
			String line;
			while( (line = reader.readLine()) != null ) {
				String[] data = line.split(",");
				System.out.println(data[2]);
			}
			
			reader.close();			//一個關全部關
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

}
