package tw.org.iii.apps.java;
// 依序給值放入LinkedList, 直接呼叫Collections的shuffle()
import java.util.Collections;
import java.util.LinkedList;

public class PokerV4 {

	public static void main(String[] args) {
		Long now = System.currentTimeMillis();

		LinkedList<Integer> poker = new LinkedList<>();
		for (int i = 0; i < 52; i++)
			poker.add(i);
		Collections.shuffle(poker);

		for (Integer num : poker) {
			System.out.println(num);
		}
		System.out.println("=====");
		System.out.println(System.currentTimeMillis()-now);
	}

}
