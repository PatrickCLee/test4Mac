package tw.ptl.apps;
// 抽象方法及類別
public class PTL32 {
	public static void main(String[] args) {
		PTL321 obj1 = new PTL322();
		PTL321 obj2 = new PTL323();
		obj1.m3();
		obj2.m3();
	}
}

abstract class PTL321{			//有抽象方法就是抽象類別
	void m1() {}
	void m2() {}
	abstract void m3() ;		//有宣告沒實做的方法為抽象方法
}
class PTL322 extends PTL321{	//要繼承抽象類別必須要實做，否則也需是抽象類別(因有抽象方法未實做)
	void m3() {System.out.println("322:m3()");}
}
class PTL323 extends PTL321{
	void m3() {System.out.println("323:m3()");}
}