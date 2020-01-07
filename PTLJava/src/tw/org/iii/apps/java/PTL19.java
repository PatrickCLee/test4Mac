package tw.org.iii.apps.java;

public class PTL19 {

	public static void main(String[] args) {
		// 上底加下底乘以高除以2
		int i = 0, sum = 0, last = 9487;
		while (i <= last) {
			// sum+=i;
			// i++;

			sum += i++;
		}
		System.out.printf("1 + 2 + ...... + %d = %d", last, sum);
	}

}
