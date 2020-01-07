package tw.ptl.apps;
// 多型概念 
public class PTL33 {
	public static void main(String[] args) {
	}
}
abstract class Poly{
	double calLength() {	//假設多邊形邊長算法為全部邊長相加
		return 1.0;
	}
	abstract double calArea();//面積算法依各自形狀不同而有區分
}
class Triangle extends Poly{
	double calArea() {		//實做面積算法
		return 2.0;
	}
}
class Rectangle extends Poly{
	double calArea() {		//實做面積算法
		return 3.0;
	}
}
