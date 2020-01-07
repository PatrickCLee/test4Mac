package tw.ptl.apps;
//視窗化的猜數字
import javax.swing.JOptionPane;

public class PTL24 {

	public static void main(String[] args) {
//		int len = 3;			// 被我更改為要求使用者輸入如下兩行
		String length = JOptionPane.showInputDialog("要猜幾位數?");
		int len = Integer.parseInt(length);
		PTL24 obj = new PTL24();
		String answer = obj.createAnswer(len);
//		System.out.println(answer);

		boolean isWinner = false;
		StringBuffer log = new StringBuffer();
		for (int i = 0; i < 10; i++) {
			String guess = JOptionPane.showInputDialog((i + 1) + " 輸入數字\n" + log.toString());

			if (!obj.checkGuess(guess, len))
				continue;
			String result = obj.checkAB(answer, guess);
			log.append(guess + " => " + result + "\n");
			JOptionPane.showMessageDialog(null, result);
			if (result.equals(len + "A0B")) {
				isWinner = true;
				break;
			}
		}
		if (isWinner) {
			JOptionPane.showMessageDialog(null, "ya");
		} else {
			JOptionPane.showMessageDialog(null, "Loser: " + answer);
		}
	}

	boolean checkGuess(String g, int len) {
		boolean ret = false;
		if (g.matches("^[0-9]{" + len + "}$")) { // ^開頭,[]裡面的字元出現(預設一次) ,{8}出現8次,$結尾
			boolean isDup = false;
			for (int i = 0; i < len - 1; i++) { // 往後檢查是否有重複 最後一個字元不用檢查
				char c = g.charAt(i);
				if (g.substring(i + 1).indexOf(c) >= 0) {
					isDup = true;
					break;
				}
			}
			ret = !isDup;
		}
		return ret;
	}

	String checkAB(String a, String g) {
		int A, B;
		A = B = 0;
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) == g.charAt(i)) {
				A++;
			} else if (a.indexOf(g.charAt(i)) != -1) {
				B++;
			}
		}
		return A + "A" + B + "B";
	}

	String createAnswer(int d) { 
		int[] poker = new int[10];			// 從此開始整段抄洗牌
		for (int i = 0; i < poker.length; i++)
			poker[i] = i;

		for (int i = poker.length - 1; i > 0; i--) {
			int ran = (int) (Math.random() * (i + 1)); // ran here represents the index
			// poker[ran] <=> poker[i]
			int temp = poker[ran];
			poker[ran] = poker[i];
			poker[i] = temp;				// 洗牌結束
		}
		StringBuffer str = new StringBuffer();
		for (int i = 0; i < d; i++) {
			str.append(poker[i]);
		}
		return str.toString();
	}
}
