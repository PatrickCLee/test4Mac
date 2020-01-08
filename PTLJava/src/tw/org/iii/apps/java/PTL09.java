package tw.org.iii.apps.java;
// switch可放的資料型態  byte, short, int, char, String, enum
public class PTL09 {

	public static void main(String[] args) {
		int a = 10; final int b = 8;
		switch (a) {
		case 1:
			System.out.println("A");
			break;
		case 10:
			System.out.println("B1");
			break;
		case b+11:			// 此處b不是變數, 宣告為final
			System.out.println("B2");
			break;
		default:
			System.out.println("X");
			break;
		}

	}

}
