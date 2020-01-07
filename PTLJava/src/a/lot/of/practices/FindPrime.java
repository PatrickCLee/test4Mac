package a.lot.of.practices;

public class FindPrime {
	public static void main(String[] args) {
		int n = 100;
		boolean is;

		for (int i = 2; i <= n; i++) {
			is = true;
			for (int j = 2; j <= i / 2; j++) {
				if (i % j == 0) {
					is = false;
					break;
				}
			}
			if (is)
				System.out.println(i);
		} 
	}

}
