package finalJava;

import javax.swing.JOptionPane;

public class MoneyTotal {

	private static int moneyBet;

	public static int displayMyMoney(int moneyWagered, int totalMonies)
	{
		String money = JOptionPane.showInputDialog(null, "How much money are you willing to bet? You have $" + totalMonies);
		moneyBet = Integer.parseInt(money);
		totalMonies = 500;
		return totalMonies = totalMonies + moneyWagered; 
	}
	public static void addMoney(int moneyWagered, int totalMonies)
	{
		totalMonies = moneyBet + totalMonies;
		JOptionPane.showMessageDialog(null, "You now have $" + totalMonies + ".");
	}
	public static void lostMoney(int moneyWagered, int totalMonies)
	{
		totalMonies = moneyBet - totalMonies;
		JOptionPane.showMessageDialog(null, "You now have $" + totalMonies + ".");
	}

}
