package tw.ptl.apps;
// 搭配tool pack裡的MyDrawer
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

import tw.org.iii.apps.tool.MyDrawer;

public class MySignature extends JFrame{
	private MyDrawer myDrawer;
	private JButton clear, undo, redo, saveJPEG, saveObj, loadObj, chColor;
	
	public MySignature() {
		super("Signature");
		setLayout(new BorderLayout());
		
		myDrawer = new MyDrawer();
		add(myDrawer, BorderLayout.CENTER);
		
		JPanel topLine = new JPanel(new FlowLayout());	//FL不帶參數的建構式預設align center
		clear = new JButton("Clear");
		clear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myDrawer.clear();
			}
		});
		undo = new JButton("Undo");
		undo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					myDrawer.undo();
				}catch(Exception e2) {
					System.out.println(e2);
				}
			}
		});
		redo = new JButton("Redo");
		redo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myDrawer.redo();
			}
		});
		saveJPEG = new JButton("Save JPEG");
		saveJPEG.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myDrawer.saveJPEG(new File("dir2/ptl.jpg"));	//saveJPEG method需帶入參數指定位置, 參考MyD
			}
		});
		saveObj = new JButton("Save Obj");
		saveObj.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					myDrawer.saveObj(new File("dir2/ptl.drawer"));	//示範用故直接寫好路徑
				} catch (Exception e1) {
				}
			}
		});
		loadObj = new JButton("Load Obj");
		loadObj.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					myDrawer.loadObj(new File("dir2/ptl.drawer"));	//示範用故直接寫好路徑
				} catch (Exception e1) {
				}
			}
		});
		chColor = new JButton("Change Color");
		chColor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changeColor();
			}
		});
		topLine.add(clear); topLine.add(undo); topLine.add(redo);
		topLine.add(saveJPEG); topLine.add(saveObj); topLine.add(loadObj);
		topLine.add(chColor);
		add(topLine, BorderLayout.NORTH);
	
		setVisible(true);
		setSize(800, 480);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void changeColor() {
		Color newColor = JColorChooser.showDialog(this, "change color", myDrawer.getLineColor());
		if (newColor != null) {
			myDrawer.setLineColor(newColor);
		}
	}
	
	public static void main(String[] args) {
		new MySignature();
	}

}
