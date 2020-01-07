package tw.ptl.apps;
// 介面觀念 注意下面星號 曾經觀念錯誤
public class PTL34 {
	public static void main(String[] args) {
		iPTL341 obj1 = new PTL344();
		System.out.println(obj1 instanceof iPTL341);//t
		System.out.println(obj1 instanceof PTL344);	//t
		System.out.println(obj1 instanceof iPTL342);//t
		System.out.println(obj1 instanceof iPTL343);// F
		System.out.println(obj1 instanceof PTL345); // F
		System.out.println("---111");
		iPTL341 obj2 = new PTL345();
		System.out.println(obj2 instanceof iPTL341);//t
		System.out.println(obj2 instanceof PTL345); //t
		System.out.println(obj2 instanceof PTL344);	// F
		System.out.println(obj2 instanceof iPTL342);//t
		System.out.println(obj2 instanceof iPTL343);//t
		System.out.println("---222");
		PTL344 obj3 = new PTL344();
		System.out.println(obj3 instanceof PTL344);	//t
		System.out.println(obj3 instanceof iPTL341);//t
		System.out.println(obj3 instanceof iPTL342);//t
		System.out.println(obj3 instanceof iPTL343);// F
		//不用問他是不是 345, 編譯會出錯
		System.out.println("---333");
		iPTL342 obj4 = new PTL344();
		System.out.println(obj4 instanceof iPTL342);//t
		System.out.println(obj4 instanceof PTL344);	//t
		System.out.println(obj4 instanceof iPTL341);//t  ***思考時答錯 
		System.out.println(obj4 instanceof iPTL343);// F
		System.out.println(obj4 instanceof PTL345); // F 
		System.out.println("---444");
		iPTL342 obj5 = new PTL345();
		System.out.println(obj5 instanceof iPTL342);//t
		System.out.println(obj5 instanceof PTL345); //t
		System.out.println(obj5 instanceof iPTL341);//t
		System.out.println(obj5 instanceof iPTL343);//t
		System.out.println(obj5 instanceof PTL344);	// F
		System.out.println("---555");
		iPTL343 obj6 = new PTL345();
		System.out.println(obj6 instanceof iPTL343);//t
		System.out.println(obj6 instanceof PTL345); //t
		System.out.println(obj6 instanceof iPTL342);//t
		System.out.println(obj6 instanceof iPTL341);//t
		System.out.println(obj6 instanceof PTL344);	// F
		System.out.println("---666");
		PTL345 obj7 = new PTL345();
		System.out.println(obj7 instanceof PTL345); //t
		System.out.println(obj7 instanceof iPTL343);//t
		System.out.println(obj7 instanceof iPTL342);//t
		System.out.println(obj7 instanceof iPTL341);//t
		//不用問是不是344, 編譯出錯
		
		
	}
}
interface iPTL341{
	void m1();
	void m2();
}
interface iPTL342{
	void m2();
	void m3();
}
interface iPTL343 extends iPTL341, iPTL342{
	void m4();
}
class PTL344 implements iPTL341, iPTL342{
	public void m1() {}
	public void m2() {}
	public void m3() {}
}
class PTL345 implements iPTL343{
	public void m1() {}
	public void m2() {}
	public void m3() {}
	public void m4() {}
}

abstract class PTL346{	//抽象類別也有建構式, 也有super, 但無法做出實體
	void m1() {}
}