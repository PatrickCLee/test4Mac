package tw.ptl.apps;

import java.util.HashSet;

import tw.org.iii.apps.java.Bike;

public class PTL68 {

	public static void main(String[] args) {
		HashSet set = new HashSet();
		set.add("PTL");			//只要物件就可以丟入
		set.add(123);			//int 經 auto-boxing 成 Integer Object
		set.add(new Bird());
		set.add(new Bike());
		set.add(new Bike());	
		set.add(new String("PTL"));	//用equals來看是重複
		System.out.println(set.size());
	}
	

}
