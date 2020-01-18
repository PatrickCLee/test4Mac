package tw.ptl.apps;
//MAP	用HashMap實做
import java.util.HashMap;

public class PTL71 {

	public static void main(String[] args) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("name", "PTL");
		map.put("gender", true);
		map.put("age", 18);
		map.put("name", "Cool");		//後寫的覆蓋現有的
		System.out.println(map.get("name"));
		System.out.println(map.get("gender"));
		System.out.println(map.get("map"));
	}

}
