package tw.ptl.apps;

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

public class MyEditor extends JFrame {
	private JButton open, save, saveas, chcolor;
	private JTextArea jta;
	
	public MyEditor() {
		super("My Editor");
	
		setLayout(new BorderLayout());
		JPanel topLine = new JPanel(new FlowLayout());
		open = new JButton("Open"); topLine.add(open); 
		save = new JButton("Save"); topLine.add(save); 
		saveas = new JButton("Save as"); topLine.add(saveas);
		chcolor = new JButton("Change Coloe"); topLine.add(chcolor);
		add(topLine, BorderLayout.NORTH);
		
		jta = new JTextArea();
		jta.setForeground(nowColor);
		jta.setFont(new Font("", Font.BOLD + Font.ITALIC, 24));		//Font.style是int型態，故可以用+號來合併不同功能
		JScrollPane jsp = new JScrollPane(jta);
		add(jsp, BorderLayout.CENTER);
		
		initEvent();
		
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void initEvent() {
		open.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				openFile();
			}
		});
		save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				saveFile();
			}
		});
		saveas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				saveasFile();
			}
		});
		chcolor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changeColor();
			}
		});
	}
	
	private Color nowColor = Color.BLUE;
	private void changeColor() {
		nowColor = JColorChooser.showDialog(this, "Change Color", nowColor);
		jta.setForeground(nowColor);
		
	}
	
	private File openFile;
	
	private void openFile() {
		JFileChooser jfc = new JFileChooser(new File("."));
		if (jfc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			openFile = jfc.getSelectedFile();
			readFile();
		}
	}

	private void readFile() {
		if (openFile == null) return;
		
		try {
			BufferedReader reader = new BufferedReader(
					new FileReader(openFile));
			jta.setText(""); String line;
			while ( (line = reader.readLine()) != null) {
				jta.append(line + "\n");
			}
			reader.close();
		}catch(Exception e) {
			System.out.println(e.toString());
		}
		
		
	}
	
	private void saveFile() {
		if (openFile == null) {
			saveasFile();
		}else {
			writeFile();
		}
	}
	
	private void saveasFile() {
		JFileChooser jfc = new JFileChooser(new File("."));
		if (jfc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
			openFile = jfc.getSelectedFile();
			writeFile();
		}
	}
	
	private void writeFile() {
		try {
			BufferedWriter writter = new BufferedWriter(
					new FileWriter(openFile));
			writter.write(jta.getText());
			writter.flush();
			writter.close();
			JOptionPane.showMessageDialog(this, "Save OK");
		}catch(Exception e) {
			System.out.println(e.toString());
		}
	}
	
	public static void main(String[] args) {
		new MyEditor();
	}
}
