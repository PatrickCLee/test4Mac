package tw.ptl.apps;
// FlowLayout玩視窗及按鈕 以及解釋interface和多型   1/4新增listener
import java.awt.FlowLayout;	
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class PTL28 extends JFrame implements ActionListener{
	private JButton open, close, exit; // 用JButton這個class創造3個名為* * *的東西 
										// 因為要設為private 所以要寫在這 不能直接創造出來
	
	public PTL28() {		// constructor
		super("我的視窗");

		setLayout(new FlowLayout(FlowLayout.RIGHT)); 
		
		open = new JButton("Open");
		close = new JButton("Close");
		exit = new JButton("Exit");
		
		add(open); add(close); add(exit);
		
		MyButtonListener2 myButtonListener2 = new MyButtonListener2();
		open.addActionListener(myButtonListener2);
		
		open.addActionListener(this); 		//本class有考到Listener證照，因此直接用this
		close.addActionListener(this);
		
		MyButtonListener myButtonListener = new MyButtonListener(); //宣告在此只是區域變數，但下行
		exit.addActionListener(myButtonListener);	//exit認識了myBL的reference，因此記憶體不會回收，此物件存在
		
		open.addActionListener(myButtonListener);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE); //因此方法定義在JFrame中故可直接呼叫
		setSize(640, 480);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == open) {
			System.out.println("OK0");			
		}else if(e.getSource() == close) {
			System.out.println("OK1");
		}
	}
	
	
	
	public static void main(String[] args) {
		new PTL28();	// 只需要物件存在就好不需要呼叫他，所以沒有將他assign給某個名稱
	}

}
class MyButtonListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("OK2");
	}
	
}

class MyButtonListener2 implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("OK222");
	}
	
}