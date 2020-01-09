package all.from.PTL;
// 看完28後完全不偷看28寫出來的
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class P28 extends JFrame implements ActionListener{
	public JButton a,b,c;
	
	
	public P28() {
		super("window");
	
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		
		a=new JButton("a");
		b=new JButton("b");
		c=new JButton("c");
		
		this.add(a);this.add(b);this.add(c);
		
		a.addActionListener(this);
		b.addActionListener(this);
		c.addActionListener(this);
		
		this.setSize(300, 300);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	public static void main(String[] args) {
		
		P28 z = new P28();
		
		
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==a) {
			System.out.println("here lies a");
		}else if(e.getSource()==b) {
			System.out.println("here stands b");
		}else {
			System.out.println("c here");
		}
	}

}
