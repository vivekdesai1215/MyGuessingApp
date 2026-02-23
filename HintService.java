public class HintService{
	public static String getHints(int hintCount, int value){
		if(hintCount==1){
			if(value%2 == 0) return "Hint 2 : The Value is Even";
			else return "Hint 2 : The Value is Odd";
		}
		else if(hintCount==2){
			if(value>50) return "Hint 1 : The Value is greater than 50";
			else return "Hint 1 : The Value is lesser than 50";
		}
		
		return "You are not eligible for any more Hints !";
	}
}