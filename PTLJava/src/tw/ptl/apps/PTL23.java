package tw.ptl.apps;
// 字串reference解釋及字串幾個功能
import tw.org.iii.apps.tool.PTL;

public class PTL23 {

	public static void main(String[] args) {
		String s1 = new String();
		System.out.println(s1);

		byte[] b1 = { 97, 98, 99, 100, 101, 102, 103 };
		String s2 = new String(b1); // 用byte陣列建構字串
		System.out.println(s2);

		String s3 = new String(b1, 2, 4);
		System.out.println(s3);
		System.out.println("=====");
		String a1 = new String(b1); // "abcdefg"
		String a2 = new String(b1); // "abcdefg"
		System.out.println(a1 == a2); // 比較的是reference
		System.out.println(a1.equals(a2)); // 比較內容 (此為String "override"的method

		PTL ptl1 = new PTL();
		PTL ptl2 = new PTL();
		System.out.println(ptl1 == ptl2);
		System.out.println(ptl1.equals(ptl2)); // 與上行的意義相同 此為Object的method
		System.out.println("obj=====");
		String a3 = "abcdefg"; // 將在String pool中的"abcdefg"的reference給a3
		String a4 = "abcdefg"; // 同上 給a4
		System.out.println(a3 == a4);	// 指向同個reference 因此為true
		System.out.println(a3.charAt('0'));
		System.out.println(a3.substring(2, 6));
		System.out.println("hamburger".substring(4, 8));
		String a5 = "PTL";
		String a6 = a5;
		System.out.println(a5 == a6);	// 指向同個reference 因此為true
		a5 = "Parker";
		System.out.println(a5 == a6);
		System.out.println(a5.concat(" Peter"));
		System.out.println(a5);
	}

}
