package tw.ptl.apps;

import java.net.InetAddress;

public class PTL58 {

	public static void main(String[] args) {
		try {
			InetAddress ip = InetAddress.getByName("192.168.3.4");
			System.out.println(ip.getHostAddress());
		}catch(Exception e) {
			System.out.println(e.toString());
		}
	}

}
