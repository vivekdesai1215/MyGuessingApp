import java.util.*;

public class MyGuessingApp{
	public static void main(String[] args){
		System.out.println("");
		System.out.println("WELCOME TO THE GUESSING GAME !!");
		GameConfig game = new GameConfig();
		game.showRules();
		
	}
}

class GameConfig{
	private final int MIN = 0;
	private final int MAX = 100;
	private final int MAX_HINTS = 3;
	private final int MAX_CHANCES = 5;
	
	private final int target;
	
	public GameConfig(){
		Random random = new Random();
		this.target = random.nextInt(MAX - MIN +1) + MIN;
		
	}
	
	public int getTargetValue(){
		return this.target;
	}
	public int getMaxAttempts(){
		return this.MAX_CHANCES;
	}
	public int getMaxHints(){
		return this.MAX_HINTS;
	}
	
	public void showRules(){
		System.out.println("Guess a Number between: "+MIN+" and : "+MAX);
		System.out.println("You Have "+MAX_CHANCES+" Chances to Guess!!");
		System.out.println("Hints will be provided after wrong guesses");
		System.out.println("");
	}
}