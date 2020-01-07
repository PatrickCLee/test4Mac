package tw.org.iii.apps.java;

import java.util.Collections;
import java.util.LinkedList;

public class PokerV4 {

	public static void main(String[] args) {

		LinkedList<Integer> poker = new LinkedList<>();
		for (int i = 0; i < 52; i++)
			poker.add(i);
		Collections.shuffle(poker);

		for (Integer num : poker) {
			System.out.println(num);
		}
	}

}
