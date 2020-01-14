package tw.ptl.apps;
// 先用之前學過的J系列和BL, FL做出簡單視窗及按鈕
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class MyEditor extends JFrame{
	private JButton open, save, saveas, chcolor;
	private JTextArea jta;
	
	public MyEditor(){
		super("My Editor");
		
		setLayout(new BorderLayout());	//BL天地左右中
		JPanel topLine = new JPanel(new FlowLayout());//FL靠左靠右中
		open = new JButton("Open"); topLine.add(open); 
		save = new JButton("Save");	topLine.add(save);
		saveas = new JButton("Save As"); topLine.add(saveas);
		chcolor = new JButton("Change Color"); topLine.add(chcolor);		
		this.add(topLine, BorderLayout.NORTH);	//BL天地左右中
		
		
		jta = new JTextArea();
		JScrollPane jsp = new JScrollPane(jta);
		jta.setFont(new Font("", Font.ITALIC + Font.BOLD, 16));	//Font.style是int型態，故可以用+號來合併不同功能
		jta.setForeground(nowColor);
		add(jsp, BorderLayout.CENTER);	//BL天地左右中
		
		initEvent();	//按下按鈕發生事件，外包
		
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void initEvent() {						//處理事件
		open.addActionListener(new ActionListener() {//open新增事件
			@Override
			public void actionPerformed(ActionEvent e) {
				openFile();							//開檔實際動作外包
			}
		});
		save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				saveFile();							//存檔外包
			}
		});
		saveas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				saveasFile();						//另存新檔外包
			}
		});
		chcolor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changeColor();						//更改顏色外包
			}
		});
	}
	
	private File file;								//原名為openFile易混淆，故更名
	
	private void openFile() {						//開檔
		JFileChooser jfc = new JFileChooser(new File("."));	//JFC要接File，File從本層開始"."
		if(jfc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {//jfc的SOD method回傳int為該類別定義的常數
			file = jfc.getSelectedFile();						//上行意思為如果popup的視窗傳回值為approve動作則...
			readFile();								//讀檔外包		//i.e.動作如果為"按下open按鈕"則...
		}
	}
	
	private void readFile() {
		if(file == null) return;				
		try {BufferedReader reader = new BufferedReader(//接管子讀進來
					new FileReader(file));
			jta.setText(""); String line;			//讀進來前清空文字區
			while( (line = reader.readLine()) != null) {
				jta.append(line + "\n");	//BufferReader的readLine()會忽略換列符號故補上
			}
			reader.close();								//有開有關
		}catch(Exception e) {
			System.out.println(e.toString());
		}
		
	}
	
	
	private void saveFile() {						//存檔
		if(file == null) {
			saveasFile();
		}else {
			writeFile();
		}		
	}
	
	private void saveasFile() {						//另存新檔
		JFileChooser jfc = new JFileChooser(new File("."));
		if(jfc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
			file = jfc.getSelectedFile();
			writeFile();
		}
	}
	
	private void writeFile() {
		try {BufferedWriter writer = new BufferedWriter(
				new FileWriter(file));
		writer.write(jta.getText());	
		writer.flush();
		writer.close();
		JOptionPane.showMessageDialog(this, "Save OK");
		}catch(Exception e) {
			System.out.println(e.toString());
		}
	}
	
	private Color nowColor = Color.cyan;
	private void changeColor() {
		nowColor = JColorChooser.showDialog(this, "change color", nowColor);
		jta.setForeground(nowColor);		
	}
	
	public static void main(String[] args) {
		new MyEditor();
	}

}
