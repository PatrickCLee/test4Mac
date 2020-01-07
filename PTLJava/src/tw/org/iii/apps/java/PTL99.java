package tw.org.iii.apps.java;

public class PTL99 {

	public static void main(String[] args) {
		int row = 5;
		int start = 1;
		int col = 3;

		for (int k = 0; k < row; k++) {
			for (int j = 1; j <= 9; j++) {
				for (int i = start; i < start + col; i++) {
					int ii = i + k * col;
					int r = ii * j;
					System.out.printf("%d x %d = %d\t", ii, j, r);
				}
				System.out.println();
			}
			System.out.println();
		}

	}

}
