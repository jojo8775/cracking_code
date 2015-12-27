package interview.cracking_interview.moderateProb;

public class ModerateProblemSet
{
	public void swapNumber(int num1, int num2)
	{
		System.out.println("Num1 : " + num1 + " \t Num2: " + num2);
		
		num1 = num1 + num2; // 2 + 3 = 5
		num2 = num1 - num2; // 5 - 3 = 2
		num1 = num1 - num2; // 5 - 2 = 3
		
		System.out.println("Num1 : " + num1 + " \t Num2: " + num2);
	}
}
