package tw.org.iii.apps.tool;
// 搭配MySig用的下方簽名畫面
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MyDrawer extends JPanel{	//繼承JPanel, MyD可稱為自訂視窗元件	
	private LinkedList<LinkedList<HashMap<String, Integer>>> lines, recycle; //用LL存放XY座標資料構成線, 用HM表示, 一條線不夠, 再包一層做很多條線
	private Color color;
	
	public MyDrawer() {
		setBackground(Color.YELLOW);
		
		lines = new LinkedList<>();
		recycle = new LinkedList<>();
		
		color = Color.BLUE;
		
		MyMouseListener listener = new MyMouseListener();
		addMouseListener(listener);
		addMouseMotionListener(listener);
	}
	public MyDrawer(File newFile) {		//打開時直接讀指定檔案
		this();
		try {
			loadObj(newFile);
		} catch (Exception e) {

		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {	//視窗裡, 元件的樣貌是由此段設定的
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(color);
		g2d.setStroke(new BasicStroke(3));
		
		for(LinkedList<HashMap<String, Integer>> line : lines ) {	//巡訪每條線, 後來多線時用這塊包住
			
			for(int i = 1; i<line.size(); i++) {	//用線畫出點
				HashMap<String, Integer> p0 = line.get(i-1);
				HashMap<String, Integer> p1 = line.get(i);
				g2d.drawLine(p0.get("x"), p0.get("y"), p1.get("x"), p1.get("y"));//輸入key取得value
			}
		
		}
		
	}
	
	public void clear() {
		lines.clear();
		repaint();
	}
	public void undo() throws Exception{
		if(lines.size()>0) {
			recycle.add(lines.removeLast());		//LL原本的功能, 丟掉的給recycle
			repaint();
		}else {
			throw new Exception();	//保留彈性讓使用者決定
		}
	}
	public void redo() {
		if(recycle.size()>0) {						
			lines.add(recycle.removeLast());		//拿回來給lines
			repaint();			
		}
	}
	public void saveJPEG(File file) {			//要存JFrame可用print(Graphics g), 所以以下流程
		BufferedImage img = new BufferedImage(	//記憶體創出空白畫布 
				getWidth(), getHeight(), 
				BufferedImage.TYPE_INT_RGB);
		
		Graphics g = img.getGraphics();			//轉為G的型態
		print(g);								//用myDrawer的功能print()把現在的畫面畫到空白畫布上
		try {
			ImageIO.write(img, "jpg", file);	//也可以不要存檔, 只把畫面io出去
		} catch(IOException e) {
			System.out.println(e.toString());
		}
		
	}
	public void saveObj(File file) throws Exception{	//存成物件, 讀取以後還可以undo, redo
		ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(file));
		oout.writeObject(lines);			//lines為LL, 已有實做序列化
		oout.flush();
		oout.close();
	}
	public void loadObj(File file) throws Exception{
		ObjectInputStream oin = new ObjectInputStream(new FileInputStream(file));
		Object obj = oin.readObject();
		if(obj instanceof LinkedList) {
			lines = (LinkedList<LinkedList<HashMap<String, Integer>>>)obj;
			repaint();
		}else {
			throw new Exception();
		}
		oin.close();
	}

	public void setLineColor(Color newColor) {
		color = newColor;
		repaint();
	}
	public Color getLineColor() {return color;}
	
	private class MyMouseListener extends MouseAdapter{	//內部類別
		@Override
		public void mousePressed(MouseEvent e) {	//按著; click是按下放開款
			super.mousePressed(e);
//			System.out.println("press");
			recycle.clear();
			LinkedList<HashMap<String, Integer>> line = new LinkedList<>();	//做完lines後再新增這段
			lines.add(line);
			
			HashMap<String, Integer> point = new HashMap<>();
			point.put("x", e.getX());
			point.put("y", e.getY());
			line.add(point);
		}
		
		@Override
			public void mouseDragged(MouseEvent e) {
				super.mouseDragged(e);
//				System.out.println("drag");
				HashMap<String, Integer> point = new HashMap<>();
				point.put("x", e.getX());
				point.put("y", e.getY());
				
				lines.getLast().add(point);	//原本是下面單行把值給一條線, 多條以後用getLast抓到最後一條線, 給值
//				line.add(point);	//把區域變數point的值給line以後point就沒用, 但值已經交給line
				repaint();			//重新繪製整個畫面的概念
		}
	}
		
//		@Override
//			public void mouseReleased(MouseEvent e) {	//最後沒用到
//				super.mouseReleased(e);
//				System.out.println("release");
//			}

	private class Point {		//此可用來取代HashMap
		private int x, y;
		void setXY(int x, int y) {
			this.x = x; this.y=y;
		}
		int getX() {return x;}
		int getY() {return y;}
	}
}
