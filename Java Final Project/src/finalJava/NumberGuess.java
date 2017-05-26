package finalJava;

import javax.swing.JOptionPane;

public class NumberGuess {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
final int MIN = 1;
final int MAX = 10;
		int random;
		int guess;
		boolean isMatch;
		String guessString;
		int moneyWagered = 0, totalMonies = 500;
		
		random = MIN + (int)(Math.random() * MAX);
		
		MoneyTotal.displayMyMoney(moneyWagered, totalMonies);
		
		guessString = JOptionPane.showInputDialog(null, " Guess my number between " + MIN + " and " +
		MAX, "random guess",JOptionPane.INFORMATION_MESSAGE);
		
		guess = Integer.parseInt(guessString);
		isMatch = guess == random;
		
		JOptionPane.showMessageDialog(null, "Your guess was " + (random-guess) + " number away from the random number.");
		JOptionPane.showMessageDialog(null, "The number was " + random + ". The result is " + isMatch + ".");
		if(isMatch == false)
		{
			MoneyTotal.lostMoney(moneyWagered, totalMonies);
		}
		else if(isMatch == true)
		{
			MoneyTotal.addMoney(moneyWagered, totalMonies);
		}

	}

}
