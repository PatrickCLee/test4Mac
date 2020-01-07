package a.lot.of.practices;
//抽象類別
public abstract class D01AbstractGuessGame {
	  private int number;
	  
	    public void setNumber(int number) {
	        this.number = number;
	    }
	 
	    public void start() {
	        showMessage("歡迎");
	        int guess = 0;
	        do {
	            guess = getUserInput();
	            if(guess > number) {
	                showMessage("輸入的數字較大");
	            }
	            else if(guess < number) {
	                showMessage("輸入的數字較小");
	            }
	            else {
	                showMessage("猜中了");
	            }
	        } while(guess != number);
	    }

	    protected abstract void showMessage(String message);
	    protected abstract int getUserInput();
}
