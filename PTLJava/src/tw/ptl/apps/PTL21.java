package tw.ptl.apps;
// 搭配Bike Scooter
import tw.org.iii.apps.java.Bike;
import tw.org.iii.apps.tool.Scooter;

public class PTL21 {

	public static void main(String[] args) {
		Bike b1 = new Bike(3);
		b1.upSpeed();b1.upSpeed();b1.upSpeed();
		System.out.println(b1.getSpeed());
		Scooter s1 = new Scooter();
		s1.upSpeed(1);s1.upSpeed(2);s1.upSpeed(3);
		System.out.println(s1.getSpeed());
	}

}
