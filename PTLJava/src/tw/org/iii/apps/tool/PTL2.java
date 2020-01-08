package tw.org.iii.apps.tool;
// 祖宗八代及沒名稱的static method
public class PTL2 {
	public static void main(String[] args) {
//		PTL22 obj1 = new PTL22();
//		System.out.println(obj1.a);
		
//		PTL21.m1();
//		PTL21.m1();
//		PTL21.m1();
		
//		PTL21 obj1 = new PTL21();
//		PTL21 obj2 = new PTL21();
//		PTL21 obj3 = new PTL21();
		
//		PTL22.m2();
		
		PTL22 obj1 = new PTL22();
		PTL22 obj2 = new PTL22();
		PTL22 obj3 = new PTL22();
		
	}
}
class PTL21{
	int a = 12;
	public PTL21() { //此constructor外界還是看不到(因class沒有public) 因此public沒意義
		System.out.println("21 cons");
	}
	{
		System.out.println("21.{} a = " + a);
	}
	static {
		System.out.println("static 21{}");
	}
	static void m1() {
		System.out.println("static 21 m1()");
	}
}
class PTL22 extends PTL21{
	PTL22(){
		System.out.println("22 cons");
	}
	{
		System.out.println("22.{}");
	}
	static {
		System.out.println("static 22{}");
	}
	static void m2() {
		System.out.println("static 22 m2()");
	}
}
