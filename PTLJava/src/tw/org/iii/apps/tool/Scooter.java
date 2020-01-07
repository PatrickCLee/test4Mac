package tw.org.iii.apps.tool;
// 搭配21 22
import tw.org.iii.apps.java.Bike;

public class Scooter extends Bike {
	private int gear;

	public Scooter() {
		// super(); 預設會執行的一行 不用寫
		super(4);
		System.out.println("Scooter()");
	}
	
	public void upSpeed() {
		super.upSpeed();
		speed *= 1.2;
	}

	public void upSpeed(int gear) {
		setGear(gear);
		speed = speed < 1 ? 1 : speed * 1.2 * gear;
	}

	private void setGear(int newgear) {
		gear = newgear;
	}
}
