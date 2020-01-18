package tw.ptl.apps;
//LinkedList
import java.util.LinkedList;

public class PTL70 {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(1);
		list.add(0,2);			//指定index, index值只能輸入現有list.size()的index
		list.add(1,3);
		list.add(0,4);
//		System.out.println(list.size());
		for(Integer i : list) {
			System.out.println(i);
		}
		System.out.println();
		System.out.println(list.get(1));
		System.out.println();
		for(int i = list.size()-1; i>=0; i--) {	//反向輸出
			System.out.println(list.get(i));
		}
	}

}
