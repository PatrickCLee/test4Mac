package tw.ptl.apps;
// TCP	用戶端 發送, 第一步確認對方有回應, 第二步傳資料需要串流
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class PTL61 {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket(
					InetAddress.getByName("192.168.0.9"), 7003);	//要先說要通到哪裡去 port號 此敘述句即會嘗試對方是否願意進行三方交握 若拋出例外則表示對方不願意
			OutputStream out = socket.getOutputStream();	//建立對話管道，回傳OutputStream
			
			out.write("byeHello, Bread\nphphphph".getBytes());	//將資料送出(轉成byte陣列)
			
			out.flush();
			out.close();
			socket.close();
			System.out.println("OK");
		}catch(Exception e) {
			System.out.println(e.toString());
		}
		
	}

}
