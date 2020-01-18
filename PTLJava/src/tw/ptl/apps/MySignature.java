package tw.ptl.apps;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class MySignature extends JFrame{
	public MySignature() {
		super("Signature");
		setLayout(new BorderLayout());
	
		setVisible(true);
		setSize(800, 480);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new MySignature();
	}

}
