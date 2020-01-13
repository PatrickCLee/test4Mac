package tw.ptl.apps;
//UDP 發送
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class PTL59 {
//Socket是用來發送封包用的
	public static void main(String[] args) {
		String mesg = "Hello, World ellen";
		byte[] send = mesg.getBytes();	//先把資料轉成byte陣列
		try {
			DatagramSocket socket = new DatagramSocket();
			DatagramPacket packet = new DatagramPacket(
					send, send.length, //要送的資料，
					InetAddress.getByName("10.0.103.69"), 8888);//要送去哪個IP，哪個port
			socket.send(packet);		//send()將封包送出，不管對方有無收到
			socket.close();
			System.out.println("OK");
		}catch (Exception e) {
			System.out.println(e.toString());
		}
	}

}
