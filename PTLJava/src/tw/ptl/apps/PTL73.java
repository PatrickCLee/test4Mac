package tw.ptl.apps;
// timer ; timerTask 類似JS的setInterval & setTimeout
import java.util.Timer;
import java.util.TimerTask;

public class PTL73 {

	public static void main(String[] args) {
		Timer timer = new Timer();				//就是無形的時間, 只要一個就夠了
		MyTask1 mt1 = new MyTask1();
		EndTask end = new EndTask(timer);
		timer.schedule(end, 6000);
		timer.schedule(mt1, 0, 500);
		System.out.println("OK");
	}

}

class MyTask1 extends TimerTask {
	int i;
	@Override
	public void run() {				//此處為時間到要做的事
		System.out.println(i++);
	}
}

class EndTask extends TimerTask {
	Timer timer;
	EndTask(Timer timer){this.timer = timer;}
	@Override
	public void run() {
		timer.cancel();
		timer.purge();
		timer = null;
	}
}