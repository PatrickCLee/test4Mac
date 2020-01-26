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
	private Color color;	//線條顏色
	
	public MyDrawer() {
		setBackground(Color.YELLOW);
		
		lines = new LinkedList<>();
		recycle = new LinkedList<>();
		
		color = Color.BLUE;
		
		MyMouseListener listener = new MyMouseListener();	//參考下方內部類別MyML, 實做MouseAdapter
		addMouseListener(listener);
		addMouseMotionListener(listener);
	}
	public MyDrawer(File newFile) {		//打開時直接讀指定檔案
		this();				//帶入上方的無參數建構式(初始設定)
		try {
			loadObj(newFile);
		} catch (Exception e) {

		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {	//視窗裡, 元件的樣貌是由此段設定的
		super.paintComponent(g);			//自動出現不知用途不刪除
		
		Graphics2D g2d = (Graphics2D)g;		//強制轉型G2d, 功能比較多
		g2d.setColor(color);				//設定線條顏色
		g2d.setStroke(new BasicStroke(3));	//設定線條粗細, 此為g2d功能
		
		for(LinkedList<HashMap<String, Integer>> line : lines ) {	//巡訪每條線, 後來多線時用這塊包住
			
			for(int i = 1; i < line.size(); i++) {	//用點畫出線
				HashMap<String, Integer> p0 = line.get(i-1);	//因i初始為1, 故需-1從上一點開始到這一點才為一條線
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
			recycle.add(lines.removeLast());		//LL原有功能; 將lines的最後一條丟掉, 給recycle
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
	public void saveJPEG(File file) {			//google save jframe to image, 抄自 https://stackoverflow.com/questions/4725320/how-to-save-window-contents-as-an-image
		BufferedImage img = new BufferedImage(	//記憶體創出空白畫布 
				getWidth(), getHeight(), 
				BufferedImage.TYPE_INT_RGB);
		
		Graphics g = img.getGraphics();			//轉為G的型態, 因為print內要帶G
		print(g);								//用myDrawer的功能print()把現在的畫面畫到空白畫布上
		try {
			ImageIO.write(img, "jpg", file);	//要write出去需要用到RenderedImage(介面), BufferedImage有實做故上方直接使用BI; 中間格式必須為正確副檔名, 否則不會存; 也可以不要存檔, 只把畫面io出去
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
		Object obj = oin.readObject();		//讀取回傳物件
		if(obj instanceof LinkedList) {
			lines = (LinkedList<LinkedList<HashMap<String, Integer>>>)obj;	//還原型態
			repaint();						//讀取後重畫
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
			super.mousePressed(e);					//自動出現的不確定用途不要亂砍
//			System.out.println("press");
			recycle.clear();				//畫新線時就不能redo, 因此把redo用的LL(recycle)清空
			LinkedList<HashMap<String, Integer>> line = new LinkedList<>();	//做完lines後再新增這段, 原本外面只有line時這裡單純將點點們加到line裡面, 現有lines, 因此在內部建立line再將點的資料給line, line為lines內的資料因此值會被儲存起來
			lines.add(line);			//要記得做add
			
			HashMap<String, Integer> point = new HashMap<>();	//創點
			point.put("x", e.getX());		//event功能抓x, y
			point.put("y", e.getY());					
			line.add(point);			//要記得做add
		}
		
		@Override
		public void mouseDragged(MouseEvent e) {
			super.mouseDragged(e);				//自動出現的不確定用途不要亂砍
//			System.out.println("drag");
			HashMap<String, Integer> point = new HashMap<>();
			point.put("x", e.getX());
			point.put("y", e.getY());
				
			lines.getLast().add(point);	//原本是下面單行把值給一條線, 多條以後用getLast抓到最後一條線, 給值
//			line.add(point);	//把區域變數point的值給line以後point就沒用, 但值已經交給line
			repaint();			//重新繪製整個畫面的概念
		}
	}
		
//		@Override
//			public void mouseReleased(MouseEvent e) {	//最後沒用到
//				super.mouseReleased(e);
//				System.out.println("release");
//			}

	private class Point {		//此可用來取代HashMap, 僅為範例, 無實際使用
		private int x, y;
		void setXY(int x, int y) {
			this.x = x; this.y=y;
		}
		int getX() {return x;}
		int getY() {return y;}
	}
}
