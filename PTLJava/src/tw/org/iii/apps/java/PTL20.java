package tw.org.iii.apps.java;
//搭配Bike 但此檔案已經被21取代 老師上課時已刪除
public class PTL20 {

	public static void main(String[] args) {
		Bike b1 = new Bike();
		Bike b2 = new Bike();

		for (int i = 0; i <= 4; i++) {
			b1.upSpeed();
		}
		System.out.println(b1.getSpeed());

	}

}
