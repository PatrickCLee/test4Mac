package tw.ptl.apps;
// 序列化, 讀進來
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class PTL56 {

	public static void main(String[] args) {
		try {
			FileInputStream fin = //此處不需file的method故直接字串創造即可
					new FileInputStream("dir2/s1.score");
			ObjectInputStream oin = 			
					new ObjectInputStream(fin);

			while (true) {		//read()為指標的概念，每read()一次指向下一個
				try {
					Student s = (Student)oin.readObject();//強制轉型, readObj傳回物件
					System.out.println(s.getScore());
			
				}catch(EOFException e) {//外層是無窮迴圈，
					break;	//指標若指向空白處會出現End Of File exception
				}			//所以在while迴圈內捕捉EOF
			}
			
			fin.close();
			System.out.println("OK");
		}catch(Exception e) {
			System.out.println(e.toString());
		}
	}

}
