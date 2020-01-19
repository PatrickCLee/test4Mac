package tw.ptl.apps;

public class PTL72 {

	public static void main(String[] args) {
		Thread1 t1 = new Thread1("X");
		Thread1 t2 = new Thread1("O");
		MyRunnable mr1 = new MyRunnable("W");	//因此創造Runnable物件
		Thread t3 = new Thread(mr1);			//帶入Runnable的建構式
		t1.start();						
		t2.start();
		t3.start();
		System.out.println("OK");		//有可能先做也可能後做，但不可能在最後
//		t1.start();  					//已死去無法再活
		t1.run();   	 				//物件還在
	}

}
class Thread1 extends Thread {
	private String name;
	Thread1(String name){
		this.name = name;
	}
	@Override
	public void run() {
//		super.run();		裡面是空的不用寫沒關係
		for(int i=0; i<10; i++) {
			System.out.println(name + " : " + i);
			try {
				Thread.sleep(100);		//睡了以後重新排隊, 但CPU不一定先叫它
			} catch (Exception e) {
			}
		}
	}
}

class MyRunnable implements Runnable {	//實做Runnable就可讓該物件找別人當爸並有生命特徵
	private String name;				//完全偷上面的code
	MyRunnable(String name){
		this.name = name;
	}
	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			System.out.println(name + " : " + i);
			try {
				Thread.sleep(100);		
			} catch (Exception e) {
			}
		}
	}
}