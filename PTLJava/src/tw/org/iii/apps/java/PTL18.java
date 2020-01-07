package tw.org.iii.apps.java;

public class PTL18 {

	public static void main(String[] args) {
		int a = 10, b = 3;
		a = a + b;
		b = a - b;
		a = a - b;
		System.out.printf("a = %d, b = %d", a, b);

		System.out.println();

		int i = 0;
		String[] mesg = { "OK", "XX" };
		System.out.println(mesg[i]);
//		i = i ^ 1;
		i ^= 1;
		System.out.println(mesg[i]);
//		i = i ^ 1;
		i ^= 1;
		System.out.println(mesg[i]);

	}

}
