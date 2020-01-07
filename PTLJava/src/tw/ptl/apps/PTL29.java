package tw.ptl.apps;
// 多型的範例

import tw.org.iii.apps.tool.Student;

public class PTL29 {
	public static void main(String[] args) {
		P291 obj1 = new P291();
		P292 obj2 = new P292();
		Student obj3 = new Student("PTL");
		doSomething(obj1);
//		doSomething(obj3);  會出現錯誤 因為Student並沒有考過認證

	}
	static void doSomething(Javaer javaer) {
		javaer.OCAJP();
	}
}
interface Javaer {		//Java有兩個認證 只說要考過 但不限方法
	void OCAJP();
	void OCPJP();
}
class P291 implements Javaer{ //用某種方法考過認證

	public void OCAJP() {System.out.println("A");	}
	public void OCPJP() {	}
	
}
class P292 implements Javaer{ //用另種方法考過認證

	public void OCAJP() {System.out.println("B");	}
	public void OCPJP() {	}
	
}