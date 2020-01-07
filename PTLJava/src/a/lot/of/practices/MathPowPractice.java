package a.lot.of.practices;

public class MathPowPractice {

	public static void main(String[] args) {
		int a;
		int n=100;
		
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				for(int k=0;k<6;k++) {
					a=(int)Math.pow(2, k)*(int)Math.pow(3, j)*(int)Math.pow(5, i);
					if(a<=n)
					System.out.println(a);
				}
			}
		}
	}
}
