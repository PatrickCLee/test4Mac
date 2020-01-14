package tw.ptl.apps;

import java.net.InetAddress;

public class PTL58 {

	public static void main(String[] args) {
		try {				//只要IP合理，IP物件就可行成
			InetAddress ip = InetAddress.getByName("google.com.tw");
			System.out.println(ip.getHostAddress());
		}catch(Exception e) {
			System.out.println(e.toString());
		}
	}

}
