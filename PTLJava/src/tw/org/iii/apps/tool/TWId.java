package tw.org.iii.apps.tool;
// 身份證字號產生器 搭配26 
public class TWId {
	private String id;
	private static String letters = "ABCDEFGHJKLMNPQRSTUVXYWZIO"; // 參考身份證 wiki

	// 為了維護方便，呼叫限制最嚴格的，其他的才都可以呼叫
	public TWId() {
		this((int) (Math.random() * 2) == 0); 
	}

	public TWId(boolean isMale) {
		this((int) (Math.random() * 26), isMale);
	}

	public TWId(int area) {
		this(area, (int) (Math.random() * 2) == 0);
	}

	public TWId(int area, boolean isMale) {
		StringBuffer sb = new StringBuffer(letters.substring(area, area + 1));
		sb.append(isMale ? "1" : "2");
		for (int i = 0; i < 7; i++) { // 因身份證檢查方式為%10==0 所以除了性別的前7碼可隨意
			sb.append((int) (Math.random() * 10));
		}
		String first9 = sb.toString();
		for (int i = 0; i < 10; i++) {
			if (checkId(first9 + i)) {
				id = first9 + i;
				break;
			}
		}
	}

	private TWId(String id) {	
		this.id = id;
	}

	public static TWId createTWId(String id) { // 與物件無關 回傳物件
		TWId temp = null; // null代表物件沒有任何指向
		if (checkId(id)) {
			temp = new TWId(id);
		}
		return temp;
	}

	public static boolean checkId(String id) {

		boolean isTrue = false;
		if (id.matches("[A-Z][12][0-9]{8}")) {
			char c0 = id.charAt(0); // 拿到英文字母
			int n12 = letters.indexOf(c0) + 10;
			int n1 = n12 / 10;
			int n2 = n12 % 10;
			int n3 = Integer.parseInt(id.substring(1, 2));
			int n4 = Integer.parseInt(id.substring(2, 3));
			int n5 = Integer.parseInt(id.substring(3, 4));
			int n6 = Integer.parseInt(id.substring(4, 5));
			int n7 = Integer.parseInt(id.substring(5, 6));
			int n8 = Integer.parseInt(id.substring(6, 7));
			int n9 = Integer.parseInt(id.substring(7, 8));
			int n10 = Integer.parseInt(id.substring(8, 9));
			int n11 = Integer.parseInt(id.substring(9, 10));
			int sum = n1 * 1 + n2 * 9 + n3 * 8 + n4 * 7 + n5 * 6 + n6 * 5 + n7 * 4 + n8 * 3 + n9 * 2 + n10 * 1
					+ n11 * 1;
			isTrue = sum % 10 == 0;
		}
		return isTrue;
	}

	public String getId() {
		return id;
	}
}
