package tw.ptl.apps;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Racing extends JFrame{
	private JButton go;
	private JLabel [] lanes = new JLabel[8];
	
	public Racing() {
		super("Racing");
		setLayout(new GridLayout(9,1));		//rows, columns
		
		go = new JButton("GO!");
		go.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				go();			//要做的細節丟到外面寫
			}
		});
		add(go);		//GridLayout直接add, 有一定的順序, 詳見api
		
		for(int i=0; i<lanes.length; i++) {		//把底下的視窗們也都做出來
			lanes[i] = new JLabel();
			lanes[i].setText((i+1) + ".");
			add(lanes[i]);
		}
		
		setSize(800, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	private Car[] cars = new Car[8];	//每條lanes(視窗)都有一台車
	
	private void go() {					//按下go後做的事
		go.setEnabled(false);			//按下go後disable按鈕
		// new Round
		for(int i=0; i<lanes.length; i++) {	//清理lanes, 有此才可重複玩
			lanes[i].setText((i+1) + ".");
		}
		for(int i=0; i<cars.length; i++) {	//創造Car, 同時分配跑道, 跑道供run()底下使用 
			cars[i] = new Car(i);
		}
		for(int i=0; i<cars.length; i++) {	//也可跟上一個for loop合併
			cars[i].start();
		}
	}
	
	private class Car extends Thread {
		private int lane;			//一台車一條跑道
		Car(int lane){this.lane = lane;}	
		@Override
		public void run() {		//**繼承Thread就是要寫run(), 表現生命的方式(活的時候要做的事)
			for(int i=0; i<100; i++) {
				if(i==99) {
					lanes[lane].setText(lanes[lane].getText() + ">" + "No1");	//**lanes[lane]讓車和lanes正式扯上關係				
					stopRound();				//一個到終點就結束比賽
				}else {
					lanes[lane].setText(lanes[lane].getText() + ">");	//無append方法故取得現值再+上
				}

				try {
					Thread.sleep(10+(int)(Math.random()*300));
				} catch (Exception e) {			//stopRound()內的interrupt()後再去sleep()的話會拋出例外, 順勢終止迴圈
					break;
				}
			}
		}
	}
	
	private void stopRound() {
		for(int i=0; i<cars.length; i++) {
			cars[i].interrupt();			
		}
		go.setEnabled(true);
	}
	
	public static void main(String[] args) {
		new Racing();
	}

}
