package tw.ptl.apps;
// 自動close()及flush()的範例		寫出去
import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class PTL52 {

	public static void main(String[] args) {
		try (FileOutputStream fout = 		//在try後方的()內只能放入開管子敘述句
				new FileOutputStream("dir2/PTL.data"); 
				DataOutputStream dout = 	//意即"創建autoCloseable物件的敘述句"
				new DataOutputStream(fout)
				) {
			dout.writeInt(123);
			dout.writeBoolean(true);
			dout.writeDouble(3.14);
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

}
