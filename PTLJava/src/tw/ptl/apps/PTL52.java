package tw.ptl.apps;
// 自動關閉的範例 不用close()
import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class PTL52 {

	public static void main(String[] args) {
		try (FileOutputStream fout = 
				new FileOutputStream("dir2/PTL.data"); //此處只能放auto close的敘述句
				DataOutputStream dout = 
				new DataOutputStream(fout);
				) {
			dout.writeInt(123);
			dout.writeBoolean(true);
			dout.writeDouble(3.14);
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

}
