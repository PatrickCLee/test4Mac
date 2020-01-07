package tw.ptl.apps;
// 做視窗聽滑鼠事件	以及三種方式完成同樣事情
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PTL35 extends JFrame {
	private JTextField mesg;

	public PTL35() {
		super("PTL35");
		setLayout(new BorderLayout());
		mesg = new JTextField();
		add(mesg, BorderLayout.NORTH);

		JPanel content = new JPanel();
		add(content, BorderLayout.CENTER);

		// content.addMouseListener(new MyListener(this)); //此為第一招
		// content.addMouseListener(new MyListenerV2()); //此為第二招
		content.addMouseListener(new MouseAdapter() {	//此為第三招
			@Override
			public void mouseClicked(MouseEvent e) {
				mesg.setText(e.getX() + ", " + e.getY());
			}
		});
		
//		content.addMouseMotionListener(new MouseAdapter() { //同為第三招寫法，不同功能
//															//需注意兩種功能需各自分開+事件
//			@Override
//			public void mouseMoved(MouseEvent e) {
//				mesg.setText(e.getX() + ", " + e.getY());
//			}
//		});
		
		setVisible(true);
		setSize(640, 480);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void setMesg(String info) {
		mesg.setText(info);
	}

	public static void main(String[] args) {
		new PTL35();

	}

	private class MyListenerV2 extends MouseAdapter { // 此為第二招
		@Override // 下面MyListener類別可以直接用MyListenerV2類別代替
		public void mouseClicked(MouseEvent e) {
			mesg.setText(e.getX() + ", " + e.getY());
		}
	}

}

class MyListener extends MouseAdapter { // 整個類別皆為第一招
	private PTL35 win; // 此三行是讓此類別與PTL35類別有關聯
	public MyListener(PTL35 win) {
		this.win = win;
	}
	@Override
	public void mouseClicked(MouseEvent e) { // e為MouseEvent裡的物件，有他的屬性和方法
//		System.out.println("Click" + e.getX() + ", " + e.getY());
		win.setMesg(e.getX() + ", " + e.getY());
	}

}
