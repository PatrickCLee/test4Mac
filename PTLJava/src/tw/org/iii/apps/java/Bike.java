package tw.org.iii.apps.java;
//搭配20 21 22
public class Bike {
	protected double speed;
	protected int color; // 0: no color

	public Bike() {
		// super();			// 預設super(); 註解掉也沒用
		System.out.println("Bike()");
		color = 1;
	}

	public Bike(int color) {
		// super();			// 預設super(); 註解掉也沒用
		System.out.println("Bike(int)");
		if (color > 0)
			this.color = color;
		color = 1;
	}

	public void setColor(int color) {
		if (color > 0) {
			this.color = color;
		}
	}

	public int getColor() {
		return color;
	}

	public void upSpeed() {
		speed = speed < 1 ? 1 : speed * 1.2;
	}

	public void downSpeed() {
		speed = speed < 1 ? 0 : speed * 0.7;
	}

	public double getSpeed() {
		return speed;
	}
}
