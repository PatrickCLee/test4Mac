package tw.org.iii.apps.java;
// 擲骰子變化版, 調整機率
public class PTL15 {

	public static void main(String[] args) {
		int[] num = new int[7];

		for (int i = 0; i < 1000; i++) {
			int ran = (int) (Math.random() * 9 + 1);
			num[ran >= 7 ? ran - 3 : ran]++; // ternary operator
		}

		if (num[0] == 0) {
			for (int i = 1; i <= 6; i++) {
				System.out.printf("%d點出現%4d次\n", i, num[i]);
			}
		}

	}

}
