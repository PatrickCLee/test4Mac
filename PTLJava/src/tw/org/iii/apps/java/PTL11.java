package tw.org.iii.apps.java;
// for的定義及運用方式
public class PTL11 {

	public static void main(String[] args) {
		int i = 0;
		for (printPTL(); i < 10; printLine()) {
			System.out.println(i++);
		}
	}

	static void printPTL() {
		System.out.println("PTL");
	}

	static void printLine() {
		System.out.println("========");
	}
}
