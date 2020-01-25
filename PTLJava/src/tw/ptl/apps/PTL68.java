package tw.ptl.apps;
// set, 無順序性, 不可重複(equals)
import java.util.HashSet;

import tw.org.iii.apps.java.Bike;

public class PTL68 {

	public static void main(String[] args) {
		HashSet set = new HashSet();
		set.add("PTL");			//1		//只要物件就可以丟入
		set.add(123);			//2		//int 經 auto-boxing 成 Integer Object
		set.add(123);					//重複
		set.add(new Bird());	//3
		set.add(new Bike());	//4
		set.add(new Bike());	//5
		set.add(new String("PTL"));		//用equals來看是重複
		set.add(true);			//6
		set.add(true);					//重複
		System.out.println(set.size());
	}
	

}
