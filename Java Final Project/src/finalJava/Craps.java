package finalJava;
import javax.swing.*;
public class Craps{
	public static void displayCraps() {
			int dice1 = (int)(Math.random()* 6) + 1;
			int dice2 = (int)(Math.random()* 6) + 1;
			int roll = dice1 + dice2;
			int moneyBet = 0, winnings = 0;
			String money = JOptionPane.showInputDialog(null, "How much money are you willing to bet?");
			moneyBet = Integer.parseInt(money);
			JOptionPane.showMessageDialog(null, "You rolled "+roll+". ");
			if(roll == 2 || roll == 3 || roll == 12){
				JOptionPane.showMessageDialog(null, "You Lose !");
			}else if(roll == 7 || roll == 11){
				JOptionPane.showMessageDialog(null, "You Win !");
			}else{
				JOptionPane.showMessageDialog(null, "Point is "+roll+"\n");
				dice1 = (int)(Math.random()* 6) + 1;
				dice2 = (int)(Math.random()* 6) + 1;
				int roll2 = dice1 + dice2;
				JOptionPane.showMessageDialog(null, "You rolled "+roll2+". ");
				while(roll2 != 7){
					if(roll == roll2){
						winnings = moneyBet * 2;
						JOptionPane.showMessageDialog(null, "You Win $" + winnings + "!");
						break;
					}else{
						JOptionPane.showMessageDialog(null, "Point is "+roll+"\n");
					}
					dice1 = (int)(Math.random()* 6) + 1;
					dice2 = (int)(Math.random()* 6) + 1;
					roll2 = dice1 + dice2;
					JOptionPane.showMessageDialog(null, "You rolled "+roll2+". ");
				}
				if(roll2 == 7){
					winnings = moneyBet - (moneyBet * 2);
					JOptionPane.showMessageDialog(null, "You Lose $" + winnings + "!");
				}			
			}
		}
	}
