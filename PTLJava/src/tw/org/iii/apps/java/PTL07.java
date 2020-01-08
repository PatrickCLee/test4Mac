package tw.org.iii.apps.java;

import java.util.Scanner;

public class PTL07 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int year = scanner.nextInt();

//閏年驗證     year%4==0是閏年 year%100==0平年   year%400==0又為閏年
		if (year % 4 == 0) {
			if (year % 100 == 0) {
				if (year % 400 == 0) {
					// 29
					System.out.println("Y");
				} else {
					// 28
				}
			} else {
				// 29
				System.out.println("Y");
			}
		} else {
			// 28
		}
		if(year%4==0 && (year%100!=0 || year%400==0)) {
			System.out.println("2Y");
		}
		if(year%400==0 || (year%4==0 && year%100!=0)) {
			System.out.println("3Y");
		}
	}

}
