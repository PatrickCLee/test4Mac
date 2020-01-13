package tw.ptl.apps;
// 序列化, 解序列化, 祖宗八代	/看完此檔案看MyEditor再看58
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class PTL57 {

	public static void main(String[] args) {
		PTL573 obj = new PTL573();
		try {				//寫出去 序列化
			ObjectOutputStream oout = 
				new ObjectOutputStream(
					new FileOutputStream("dir2/PTL.object"));
			oout.writeObject(obj);
			oout.flush();
			oout.close();
			System.out.println("Save OK");
		}catch(Exception e) {
			System.out.println(e.toString());
		}
		
		System.out.println("----------------");
		
		try {				//讀進來 解序列化
			ObjectInputStream oin = 
				new ObjectInputStream(
					new FileInputStream("dir2/PTL.object"));
			Object obj2 = oin.readObject();
			oin.close();
			System.out.println("read OK");
		}catch(Exception e) {
			System.out.println(e.toString());
		}
		
	}

}
class PTL571  {			
	PTL571(){System.out.println("571()");}
}
class PTL572 extends PTL571{
	PTL572(){System.out.println("572()");}
}	//宣告implements Serializable， 針對那代的物件的屬性去存出去
class PTL573 extends PTL572 implements Serializable  {	//可測試在父輩或祖輩implements
	PTL PTL;	//573 has-a PTL
	PTL573(){	//一個可序列化的obj擁有的屬性也要可序列化
		System.out.println("573()");
		PTL = new PTL();
	}
}
class PTL implements Serializable {	//一個可序列化的obj擁有的屬性也要可序列化
	PTL(){System.out.println("PTL()");}
}
