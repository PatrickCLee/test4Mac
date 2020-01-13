package tw.ptl.apps;
//UDP 接收
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class PTL60 {

	public static void main(String[] args) {
		while(true) {
			byte[] buf = new byte[1024];	//空的，等著接收
			try {
				DatagramSocket socket = 
					new DatagramSocket(8888);
				DatagramPacket packet = 
					new DatagramPacket(buf, buf.length);
				socket.receive(packet);		//等著接收封包
				socket.close();
				
				InetAddress urip = packet.getAddress();		//封包取得來源IP
				byte[] data = packet.getData();				//取得封包資料
				int len = packet.getLength();				//取得封包大小
				String mesg = new String(data,0,len);		//資料轉字串
				System.out.println(urip.getHostAddress() +":" + mesg);

				if (mesg.equals("bye")) {					//無窮迴圈直到收到bye訊息
					break;									//TODO 無窮迴圈在哪?
				}
			}catch(Exception e) {
				System.out.println(e.toString());
			}
		}
	}

}
