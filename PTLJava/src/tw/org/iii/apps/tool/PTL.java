package tw.org.iii.apps.tool;

public class PTL {
	public PTL() {
		
	}
	public PTL(int a) {
		this();		//呼叫上方no parameters的constructor，則不會呼叫super()
	}
	
	public String toString() {
		return "I'm PTL";
	}
}
