package tw.org.iii.apps.java;

import java.util.Scanner;

public class PTL01 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int x = scanner.nextInt();
		int y = scanner.nextInt();
		int addition = x + y;
		int subtraction = x - y;
		int multiplication = x * y;
		int quotient = x / y;
		int remainder = x % y;
		System.out.printf("%d + %d = %d\n", x, y, addition);
		System.out.printf("%d - %d = %d\n", x, y, subtraction);
		System.out.printf("%d * %d = %d\n", x, y, multiplication);
		System.out.printf("%d / %d = %d ...%d", x, y, quotient, remainder);

	}

}
