package tw.ptl.apps;
// 觀念釐清 到車行租車 
public class PTL31 {

	public static void main(String[] args) {
		Car obj1 = new Car();
		Ferrari obj2 = new Ferrari();
		obj1.accelerate();
		obj2.accelerate();
		Car obj3 = new Ferrari();	//宣告為何種物件，就是用該觀點看待他，只有他的功能
									//思考為我要一台車，也得到一台車(法oo)
		obj3.accelerate();			//車有加速功能，但骨子裡是法oo，所以加速就是法oo的加速
		//obj3.hyperSpeed();		//無法呼叫，因為不知道是法oo，只知道這是一台車，不知道有這個功能
		((Ferrari)obj3).hyperSpeed(); //強制轉型(認識到是法oo)，可以呼叫，因為他本質上是法oo
		
		//Ferrari obj4 = new Car(); //編譯失敗，要一台法oo，但給你一台車，沒人會要
		//((Ferrari)obj1).hyperSpeed(); //編譯成功，但是骨子裡有誤，執行後拋出錯誤 
		System.out.println("=====");
		test1(obj1);
		System.out.println("-----");
		test1(obj2);
		System.out.println(".....");
		obj1.accelerate();
		obj2.accelerate();
		obj3.accelerate();
		System.out.println("=====");
		System.out.println(obj3.getClass());
			
	}

	static void test1(Car objx) {
		objx.accelerate();
		
		if(objx instanceof Ferrari) {
			((Ferrari)objx).hyperSpeed();
		}
	}
	
}

class Car{
	int speed = 10;
	void accelerate() {	System.out.println("Car:accelerate()" + speed);	}
}
class Ferrari extends Car{	//法拉利是車
	int speed = 20;
	void accelerate() {	System.out.println("Ferrari:accelerate()" + speed + ":" + "super " + super.speed);	}	//override
	void hyperSpeed() {	System.out.println("Ferrari:hyperSpeed()");	}
}