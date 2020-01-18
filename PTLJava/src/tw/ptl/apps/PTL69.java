package tw.ptl.apps;
//泛型
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class PTL69 {

	public static void main(String[] args) {
		HashSet<Integer> set = new HashSet<>();	
//		set.add("PTL");	//因有泛型故編譯失敗
		
//		set.add(123);
//		set.add(123);
//		set.add(2000);
//		set.add(30000);
//		System.out.println(set.size());		//3, 123重複
		
		while(set.size()<6) {				//樂透號碼
			set.add((int)(Math.random()*49+1));
		}
		System.out.println(set);
		
		TreeSet<Integer> tset = new TreeSet<>();	//換成TreeSet //Constructs a new, empty tree set, sorted according to the natural ordering of its elements.
		while(tset.size()<6) {				
			tset.add((int)(Math.random()*49+1));
		}
		System.out.println(tset);
		
		Iterator<Integer> it = tset.iterator();		//迭代, 只會往一個方向前進
		while(it.hasNext()) {
			Integer temp = it.next();				//此段code結束後, it已經指向末端, 無法回頭, 若要重訪需要再創一次
			System.out.println(temp);
		}
		System.out.println("=====");
		
		for(Integer it2: tset) {					//for each除了陣列也可用在Collection
			System.out.println(it2);				//for each比較好用
		}
	}

}
