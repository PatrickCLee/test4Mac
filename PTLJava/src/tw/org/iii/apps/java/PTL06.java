package tw.org.iii.apps.java;

public class PTL06 {

	public static void main(String[] args) {
//此稱為過濾式
		int score = (int) (Math.random() * 101);
		System.out.println(score);
		if (score >= 90)
			System.out.println("A");
		else if (score >= 80)
			System.out.println("B");
		else if (score >= 70)
			System.out.println("C");
		else if (score >= 60)
			System.out.println("D");
		else
			System.out.println("E");
	}
}
