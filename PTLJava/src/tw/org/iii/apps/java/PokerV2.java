package tw.org.iii.apps.java;

public class PokerV2 {

	public static void main(String[] args) {
		long now = System.currentTimeMillis();

		// shuffle
		int[] poker = new int[52];
//		for (int i = 0; i < poker.length; i++)poker[i] = i;

		for (int i = 0; i < poker.length; i++) {
			int ran;
			boolean isRepeat = false;
			do {
				ran = (int) (Math.random() * 52);
				// check repeat
				isRepeat = false;
				for (int j = 0; j < i; j++) {
					if (ran == poker[j]) // repeat happened
						isRepeat = true;
					break;
				}
			} while (isRepeat);
			poker[i] = ran;
			System.out.println(poker[i]);

		}
		System.out.println("===");
		System.out.println(System.currentTimeMillis() - now);
	}

}
