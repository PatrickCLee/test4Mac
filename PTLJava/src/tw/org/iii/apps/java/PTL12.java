package tw.org.iii.apps.java;
// break(跳出迴圈) 和 continue(其後的code不運行, 跳往下一圈迴圈)
public class PTL12 {

	public static void main(String[] args) {
		for (int i = 0; i < 20; i++) {
			if (i == 17) {
//				break;
				continue;
			}
			System.out.println(i);
		}
		System.out.println("GG");
	}

}
