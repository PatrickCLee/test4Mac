package tw.ptl.apps;
//UDP 發送
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class PTL59 {
//Socket是用來 發送or接收 封包用的
	public static void main(String[] args) {
		String mesg = "bye";
		byte[] send = mesg.getBytes();	//先把資料轉成byte陣列
		try {
			DatagramSocket socket = new DatagramSocket();//無傳參數因為從哪個port出去無所謂
			DatagramPacket packet = new DatagramPacket(//封包依建構式不同分為傳送和接收
					send, send.length, //要送的資料，和資料長度
					InetAddress.getByName("192.168.0.9"), 8888);//要送去哪個IP，哪個port
			socket.send(packet);		//send()將封包送出，不管對方有無收到
			socket.close();
			System.out.println("OK");
		}catch (Exception e) {
			System.out.println(e.toString());
		}
	}

}
