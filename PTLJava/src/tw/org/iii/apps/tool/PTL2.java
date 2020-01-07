package tw.org.iii.apps.tool;

public class PTL2 {
	public static void main(String[] args) {
//		PTL22 obj1 = new PTL22();
//		System.out.println(obj1.a);
		
//		PTL21.m1();
//		PTL21.m1();
//		PTL21.m1();
		
		PTL21 obj1 = new PTL21();
		PTL21 obj2 = new PTL21();
		PTL21 obj3 = new PTL21();
		
//		PTL22.m2();
		
//		PTL22 obj1 = new PTL22();
		
	}
}
class PTL21{
	int a = 12;
	public PTL21() { //此constructor外界還是看不到(因class沒有public) 因此public沒意義
		System.out.println("PTL21()");
	}
	{
		System.out.println("{} a = " + a);
	}
	static {
		System.out.println("static PTL21{}");
	}
	static void m1() {
		System.out.println("static PTL21 m1()");
	}
}
class PTL22 extends PTL21{
	PTL22(){
		System.out.println("PTL22()");
	}
	{
		System.out.println("PTL22.{}");
	}
	static {
		System.out.println("static PTL22{}");
	}
	static void m2() {
		System.out.println("static PTL22 m2()");
	}
}
