package tw.org.iii.apps.java;
// Math.random()擲骰子
public class PTL14 {

	public static void main(String[] args) {
		int n1, n2, n3, n4, n5, n6;
		n1 = n2 = n3 = n4 = n5 = n6 = 0;
		for (int i = 0; i < 100000; i++) {
			int ran = (int) (Math.random() * 6 + 1);
			switch (ran) {
			case 1:
				n1++;
				break;
			case 2:
				n2++;
				break;
			case 3:
				n3++;
				break;
			case 4:
				n4++;
				break;
			case 5:
				n5++;
				break;
			case 6:
				n6++;
				break;
			}
		}
		System.out.println(n1 + " n1");
		System.out.println(n2 + " n2");
		System.out.println(n3 + " n3");
		System.out.println(n4 + " n4");
		System.out.println(n5 + " n5");
		System.out.println(n6 + " n6");

	}

}
