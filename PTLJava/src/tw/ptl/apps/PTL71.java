package tw.ptl.apps;
//MAP, key唯一, value可重複,	用HashMap實做
import java.util.HashMap;

public class PTL71 {

	public static void main(String[] args) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("name", "PTL");			//用put新增
		map.put("gender", true);
		map.put("age", 18);
		map.put("name", "Cool");		//後寫的覆蓋現有的
		System.out.println(map.get("name"));	//用get key看value
		System.out.println(map.get("gender"));
		System.out.println(map.get("map"));
	}

}
