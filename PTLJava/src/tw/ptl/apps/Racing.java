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
				go();
			}
		});
		add(go);
		
		for(int i=0; i<lanes.length; i++) {
			lanes[i] = new JLabel();
			lanes[i].setText((i+1) + ".");
			add(lanes[i]);
		}
		
		setSize(800, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	private Car[] cars = new Car[8];
	private int rank;
	private void go() {
		go.setEnabled(false);	
		rank=0;
		// new Round
		for(int i=0; i<lanes.length; i++) {	//清理lanes
			lanes[i].setText((i+1) + ".");
		}
		for(int i=0; i<cars.length; i++) {
			cars[i] = new Car(i);
		}
		for(int i=0; i<cars.length; i++) {
			cars[i].start();
		}
	}
	
	private class Car extends Thread {
		private int lane;
		Car(int lane){this.lane = lane;}
		@Override
		public void run() {
			for(int i=0; i<100; i++) {
				if(i==99) {
					lanes[lane].setText(lanes[lane].getText() + ">" + ++rank);	//(int)rank預設值為0					
					stopRound();				//一個到終點就結束比賽
				}else {
					lanes[lane].setText(lanes[lane].getText() + ">");	//無append方法故取得現值再+上
				}

				try {
					Thread.sleep(10+(int)(Math.random()*300));
				} catch (Exception e) {			//既然有stopRound()也就會拋出例外, 那就終止迴圈
					break;
				}
			}
		}
	}
	
	private void stopRound() {
		for(int i=0; i<cars.length; i++) {
			cars[i].interrupt();				//會拋出例外
		}
		go.setEnabled(true);
	}
	
	public static void main(String[] args) {
		new Racing();
	}

}
