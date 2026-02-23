
public class ValidationService{
	public static int validateValue(String input)throws InvalidInputException{
		
		try{
			int num = Integer.parseInt(input);
			if(num<0 || num>100){
				throw new InvalidInputException("Enter numbers between 1 and 100 only");
			}
			return num;
		}
		catch(NumberFormatException e){
			throw new InvalidInputException("Please Enter Numbers only !!");
		}
	}
}