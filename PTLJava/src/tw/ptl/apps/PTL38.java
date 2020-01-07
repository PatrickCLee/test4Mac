package tw.ptl.apps;
// 應用 加上finally敘述句 
public class PTL38 {
	public static void main(String[] args) {
		Bird bird = new Bird();
		Hunter hunter = new Hunter(bird);
		try {
		hunter.shootBird();
		}catch(Exception e) {
			
		}
	}

}
class Bird{
	private int leg;
	Bird(){leg = 2;}
	void setLeg(int leg) throws Exception {
		if(leg<0 || leg>2) {
			throw new Exception();
		}else {
			this.leg = leg;
		}
	}
}

class Hunter{
	Bird bird;
	Hunter(Bird bird){
		this.bird = bird;
	}
	void shootBird() throws Exception{
		try {
		bird.setLeg(3);
//		}catch (Exception e) {
//			System.out.println("nothing happened");
//			return;			//提早離開,結束
		}finally {			//確保即使return也一定會做
			System.out.println("here");
		}
		System.out.println("OK"); //如果前面return則不會執行到此
	}
}

class HunterV2 extends Hunter{
	HunterV2(Bird bird){
		super(bird);
	}
	
	void shootBird() {
		
	}
	
}