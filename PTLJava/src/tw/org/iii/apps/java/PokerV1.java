package tw.org.iii.apps.java;

public class PokerV1 {

	public static void main(String[] args) {
		long now = System.currentTimeMillis();

		// shuffle
		int[] poker = new int[52];
//		for (int i = 0; i < poker.length; i++)poker[i] = i;

		for (int i = 0; i < poker.length; i++) {
			int ran = (int) (Math.random() * 52);
			// check repeat
			boolean isRepeat = false;
			for (int j = 0; j < i; j++) {
				if (ran == poker[j])
					isRepeat = true;
				break;
			}
			if (!isRepeat) {
				poker[i] = ran;
				System.out.println(poker[i]);
			} else {
				i--;
			}
		}
		System.out.println("===");
		System.out.println(System.currentTimeMillis() - now);
	}

}
