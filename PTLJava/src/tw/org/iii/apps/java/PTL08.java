package tw.org.iii.apps.java;
// 運算在判斷前或後, 邏輯運算&&||及位元運算&|^
public class PTL08 {

	public static void main(String[] args) {
		int a = 10, b = 3;
		if (a++ <= 10 && b-- >= 3) {
			System.out.printf("OK: a = %d, b = %d\n", a, b);
		} else {
			System.out.printf("XX: a = %d, b = %d\n", a, b);
		}

		int x = 2, y = 3;
		System.out.println(x & y);
		System.out.println(x | y);
		System.out.println(x ^ y);
	
	}

}
