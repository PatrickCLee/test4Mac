package tw.ptl.apps;
// exception
import java.io.IOException;

public class PTL37 {

	public static void main(String[] args) {
		PTL371 obj1 = new PTL371();
		try {
		obj1.m1(6);
		}catch(Exception e) {
			System.out.println("exception");
		}
	}

}

class PTL371 {
	void m1(int a) throws IOException, Exception {
		if(a==7) {
			throw new Exception();
//			throw new RuntimeException();
		}else {
			System.out.println("OK");
		}
	}
}