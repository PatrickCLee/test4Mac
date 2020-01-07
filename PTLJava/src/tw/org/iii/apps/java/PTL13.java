package tw.org.iii.apps.java;

public class PTL13 {

	public static void main(String[] args) {
		// Array => Object
		int[] a; // declare
		a = new int[3]; // initialized
		System.out.println(a.length);
		int[] b = new int[4];
		for (int i = 0; i < b.length; i++) {
			System.out.println(b[i]);
		}
		int[] c = new int[] { 1, 2, 3, 4 };
		int[] d = { 1, 2, 3, 4 }; // same meaning as c[]
		for (int i = 0; i < c.length; i++) {
			System.out.println(c[i]);
		}
		int[] e;
		e = new int[] { 9, 8, 7, 6 };
		int[] f;
//		f={9,8,7,6}; // don't do this, do d[] or e[]
	}

}
