package tw.org.iii.apps.java;
// 洗牌 理牌 加上ASCII的圖案
import java.util.Arrays;

public class PokerV3 {

	public static void main(String[] args) {
		int[] poker = new int[52];
		for (int i = 0; i < poker.length; i++)
			poker[i] = i;

		for (int i = poker.length - 1; i > 0; i--) {//從尾巴開始與前面隨機一張牌交換
			int ran = (int) (Math.random() * (i + 1)); // ran here represents the index
			// poker[ran] <=> poker[i]
			int temp = poker[ran];
			poker[ran] = poker[i];
			poker[i] = temp;
		}

		for (int a : poker) {
			System.out.print(a + ".");
		}

		System.out.println();

		int[][] players = new int[4][13];
		for (int i = 0; i < poker.length; i++) {// 依序發給每一家
			players[i % 4][i / 4] = poker[i];
		}
		char[] suit2s = { '\u2660', '\u2665', '\u2666', '\u2663' };
		String[] suits = { "黑桃", "紅心", "方塊", "梅花" };
		String[] values = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", };
		for (int[] player : players) {// 理牌
			Arrays.sort(player); // "Arrays.sort" api/java.util->Arrays->sort
			for (int card : player) {
				System.out.print(suit2s[card / 13] + values[card % 13] + " ");
			}
			System.out.println();
		}

	}

}
