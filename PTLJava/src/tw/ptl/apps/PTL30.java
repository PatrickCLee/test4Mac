package tw.ptl.apps;
// 用樂高組積木的概念拼出視窗 繼承JFrame，創小物件，拼裝，再用主體加上拼裝物
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PTL30 extends JFrame implements ActionListener {
	private JButton guess;			//宣告在此因為等一下還要用
	private JTextField input;		//宣告在此因為等一下還要用
	private JTextArea log;
	private String answer;
	private int counter;
	
	public PTL30() {
		super("Guess Game");

		initView();					//原本的code全部丟出去一個method 方便維護
		
		initRound();
		guess.addActionListener(this);
		
		setVisible(true);
		setSize(480, 320);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

	private void initRound() {
		counter = 0;
		answer = createAnswer(3);
		log.setText("");
		System.out.println(answer);
	}
	
	private void initView() {
		setLayout(new BorderLayout());
		JPanel topLine = new JPanel(new BorderLayout());
		guess = new JButton("Guess");
		input = new JTextField();
		topLine.add(guess, BorderLayout.EAST);
		topLine.add(input, BorderLayout.CENTER);  //到此為止只有組裝，還沒擺上去
		
		add(topLine, BorderLayout.NORTH);		//用this呼叫，但this可省略
		
		log = new JTextArea();
		log.setEditable(false);
		JScrollPane jsp = new JScrollPane(log);	//JScrollPane可捲動的視窗
		
		
		
		add(jsp, BorderLayout.CENTER);			//用this呼叫，但this可省略

	}
	
	
	public static void main(String[] args) {
		new PTL30();
	}
	
	boolean checkGuess(String g, int len) {		// 整段抄來用
		boolean ret = false;
		if (g.matches("^[0-9]{" + len + "}$")) { // ^開頭,[]裡面的字元出現(預設一次) ,{8}出現8次,$結尾
			boolean isDup = false;
			for (int i = 0; i < len - 1; i++) { // 往後檢查是否有重複 最後一個字元不用檢查
				char c = g.charAt(i);
				if (g.substring(i + 1).indexOf(c) >= 0) {
					isDup = true;
					break;
				}
			}
			ret = !isDup;
		}
		return ret;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		String userInput = input.getText();

		if (checkGuess(userInput,3)==false) {
			input.setText("Wrong Input, try again!");
		} else {
			counter++;
			String result = checkAB(answer, userInput);
			log.append(counter + ". " + userInput + " => " + result + "\n");

			input.setText("");

			if (result.equals("3A0B")) {
				showPromptDialog(true);
			} else if (counter == 20) {
				showPromptDialog(false);
			}
		}
		input.requestFocus();			//讓input這個欄位在事件發生(按下按鈕)後得到focus
	}
	private void showPromptDialog(boolean isWinner) {
		String mesg = isWinner?"Winner":"Loser: " + answer;
		int yesOrNo = JOptionPane.showConfirmDialog(
				this, mesg + ", Play new Game?","Result", JOptionPane.YES_NO_OPTION);
		
		if(yesOrNo == JOptionPane.YES_OPTION) {
			initRound();
		}else if(yesOrNo == JOptionPane.NO_OPTION) {
			System.exit(0);
		}
	}
	
	private String createAnswer(int d) { 
		int[] poker = new int[10];			// 從此開始整段抄洗牌
		for (int i = 0; i < poker.length; i++)
			poker[i] = i;

		for (int i = poker.length - 1; i > 0; i--) {
			int ran = (int) (Math.random() * (i + 1)); // ran here represents the index
			// poker[ran] <=> poker[i]
			int temp = poker[ran];
			poker[ran] = poker[i];
			poker[i] = temp;				// 洗牌結束
		}
		StringBuffer str = new StringBuffer();
		for (int i = 0; i < d; i++) {
			str.append(poker[i]);
		}
		return str.toString();
	}
	
	
	private String checkAB(String a, String g) {
		int A, B;
		A = B = 0;
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) == g.charAt(i)) {
				A++;
			} else if (a.indexOf(g.charAt(i)) != -1) {
				B++;
			}
		}
		return A + "A" + B + "B";
	}
	
}
