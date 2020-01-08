package tw.ptl.apps;

import java.io.DataInputStream;
import java.io.FileInputStream;

public class PTL53 {

	public static void main(String[] args) {
		try(DataInputStream din = 
				new DataInputStream(
						new FileInputStream("dir2/PTL.data"))){
			int v1 = din.readInt();
			boolean v2 = din.readBoolean();
			double v3 = din.readDouble();	//讀取的順序也要按照資料順序讀 因按照資料型別的空間讀取
			System.out.println(v1+":"+v2+":"+v3);
		}catch(Exception e) {
			
		}
		System.out.println("test");
		System.out.println("really?");
	}

}
