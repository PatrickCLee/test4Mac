package tw.org.iii.apps.java;
// 2 dimension array, 不需有相同數量的elements
public class PTL17 {
	public static void main(String[] args) {
		int[][] a;
		a = new int[2][3];
		System.out.println(a.length);
		System.out.println(a[0].length);
		System.out.println(a[1].length);
		//int[][]aR = {{0,1},{0,1},{0,1}};	//直接創建array 
		//用視覺來理解, aR是一個大array包著3個小array, 
		//每個array有2 elements因此為[3][2]
		for (int j = 0; j < a.length; j++) {
			for (int i = 0; i < a[j].length; i++) {
				System.out.print(a[j][i] + " ");
			}
			System.out.println();
		}

		System.out.println("=====");

		for (int[] i : a) {
			for (int j : i) {
				System.out.print(j + " ");
			}
			System.out.println();
		}

		System.out.println("=====");

		int[][] b = new int[2][];
		b[0] = new int[3];
		b[1] = new int[4];
		System.out.println(b.length);
		System.out.println(b[0].length);
		System.out.println(b[1].length);

		for (int j = 0; j < b.length; j++) {
			for (int i = 0; i < b[j].length; i++) {
				System.out.print(b[j][i] + " ");
			}
			System.out.println();
		}

		System.out.println("=====");

		for (int[] i : b) {
			for (int j : i) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}
}
