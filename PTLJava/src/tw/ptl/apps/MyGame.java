package tw.ptl.apps;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyGame extends JFrame{	//JFrame是window的後代, JPanel不是, 只有JP無法產生視窗, 故用一個單純的JF包JP
	private MyPanel myPanel;
	
	public MyGame() {
		setLayout(new BorderLayout());
	
		myPanel = new MyPanel();		//產生物件實體時還不知它的寬高
		add(myPanel, BorderLayout.CENTER);	//由BL(LayoutManager)設計時才知道寬高, (還要等到setSize後)
		
		setVisible(true);
		setSize(640, 480);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private class MyPanel extends JPanel {
		private BufferedImage ballImg;
		private Timer timer;
		private int ballX, ballY, myWidth, myHeight, ballW, ballH;
		private LinkedList<BallTask> balls = new LinkedList<MyGame.MyPanel.BallTask>();
		
		public MyPanel() {
			addMouseListener(new MyMouseAdapter());
			timer = new Timer();
			timer.schedule(new RefreshTask(), 0, 16);	//專門達成FPS60的一行
			
			try {
				ballImg = ImageIO.read(new File("dir2/emoji2.png"));	//** ImageIO
				ballW = ballImg.getWidth();					//**生成MyPanel後帶入圖片後就抓圖的長寬
				ballH = ballImg.getHeight();
			} catch (IOException e) {
				System.out.println(e);
			}
		}
		private class RefreshTask extends TimerTask{	//拿來做FPS60的class
			@Override
			public void run() {
				repaint();
			}
			
		}
		
		private class BallTask extends TimerTask {
			private int dx, dy;		//球的位移量
			int ballX, ballY;		//球的位置, 真正決定球的位置的是paintComponent()底下的drawImage帶入的參數
			BallTask(int ballX, int ballY){		
				dx = dy = 4;
				this.ballX = ballX; this.ballY = ballY;
			}
			@Override
			public void run() {
				if(ballX < 0 || ballX + ballW > myWidth) {	//碰壁反彈
					dx *= -1;
				}
				if(ballY < 0 || ballY + ballH > myHeight) {	//碰壁反彈
					dy *= -1;
				}
				ballX += dx;								//移動
				ballY += dy;								
//				repaint();				若多顆球時會一直repaint, 故挪出去用fps的概念處理就好
			}
		}
		
		private class MyMouseAdapter extends MouseAdapter {
			public void mouseClicked(MouseEvent e) {
				BallTask ball = new BallTask(e.getX()-ballW/2, e.getY()-ballH/2);//起始位置(圖片的左上角)為滑鼠按下的位置, 故要再減去寬高
				timer.schedule(ball, 1000, 30);	
				balls.add(ball);
			}
		}
		
		@Override
		protected void paintComponent(Graphics g) { //視窗裡, 元件的樣貌是由此段設定的
			super.paintComponent(g);		//自動帶出不刪
			myWidth = getWidth(); myHeight = getHeight();	//可放在此或BallTask的run裡, 原因在line26.27
			
			Graphics2D g2d = (Graphics2D)g;	
			for(BallTask ball : balls) {					//尋訪每顆球, 每顆球只有一個現在位置	
				g2d.drawImage(ballImg, ball.ballX, ball.ballY, null);					
			}
			
		}
	}
	
	public static void main(String[] args) {
		new MyGame();
	}

}
