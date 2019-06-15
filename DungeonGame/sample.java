import java.util.Scanner;
import java.lang.Math;

public class sample
{
	public static void main (String [] args)
	{
		Scanner input = new Scanner(System.in);
		final int threshhold = 21;
		int playerNumber = 0;
		int gamblerNumber = 0;
		int visibleGamblerNumber = 0;
		System.out.println("The gambler smiles and deals the cards.");
		playerNumber =  Math.random(13) +  Math.random(13);
		System.out.println("Your starting hand has a total of " + playerNumber + " points.");
		visibleGamblerNumber =  Math.random(13);
		gamblerNumber = visibleGamblerNumber * 2;
		System.out.println("You see that the gambler has " + visibleGamblerNumber + " points.");
		for (int i = 0; i < 3; i++)
		{
			System.out.println("Deal(1) or Stand(2)? ");
			int userChoice = input.nextInt();
			if (userChoice == 1)
			{	
				int rando = Math.random(13);
				playerNumber += rando;
				System.out.println("You now have a total of " + playerNumber + "points.");
				
			}
			else
			{
				System.out.println("You choose to stand.");
			}
			System.out.println("The gambler chooses to stand.");
		}
		System.out.println("The gambler calls reveal!");
		System.out.println("You had " + playerNumber + " points. The gambler had " + gamblerNumber + " points.");
		if (playerNumber < 21 && gamblerNumber < 21)
		{
			if (playerNumber > gamblerNumber)
			{
				System.out.println("You win!");
			}
			else
			{
				System.out.println("You lose!");
			}
		}
		else if (playerNumber == 21)
		{
			System.out.println("You win!");
		}
		else
		{
			System.out.println("You lose!");
		}
	}
}