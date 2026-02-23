import java.util.*;

public class MyGuessingApp{
	
	public static void main(String[] args) {
		
		boolean restart=false;
		

		do{
		System.out.println();
		Scanner sc = new Scanner(System.in);
		System.out.println("WELCOME TO THE GUESSING GAME !!\n");
		System.out.print("Enter Player Name : ");
		String player = sc.nextLine();
		System.out.println("");
		GameConfig game = new GameConfig();
		game.showRules();
		int hintCount = game.getMaxHints();
		
        int currentAttempt = 0;
        boolean guessed = false;
		boolean win = false;

		
        while (currentAttempt < game.getMaxAttempts()) {
            System.out.print("Enter your guess : ");
            String val = sc.nextLine(); // read full line

            int guess;
            try {
                guess = ValidationService.validateValue(val);
            } catch (InvalidInputException ex) {
                System.out.println(ex.getMessage());
                continue;
            }

            String outcome = GuessValidator.validateGuess(guess, game.getTargetValue());
            currentAttempt++;
            System.out.println(outcome);
			System.out.println(game.getTargetValue());

            if (outcome.equals("CORRECT !!")) {
                guessed = true;
				win=true;
                break;
            }

            if (hintCount > 0) {
                System.out.println(HintService.getHints(hintCount, game.getTargetValue()));
                hintCount--;
            } else {
                System.out.println("You are not eligible for any more Hints !");
            }
            System.out.println();
        }

        if (!guessed) {
            System.out.println("You have reached your max chances");
			
        }
		StorageService.storeResult(player, currentAttempt, win);
		restart = GameController.restartGame(sc);
	}while(restart);
	}
}

class GameConfig{
	private final int MIN = 0;
	private final int MAX = 100;
	private final int MAX_HINTS = 2;
	private final int MAX_CHANCES = 10;
	
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