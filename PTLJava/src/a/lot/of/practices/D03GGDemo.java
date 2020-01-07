package a.lot.of.practices;
// runner 
public class D03GGDemo {

	public static void main(String[] args) {
		D01AbstractGuessGame guessGame = new D02TextModeGame();
		guessGame.setNumber(50);
		guessGame.start();
	}

}
