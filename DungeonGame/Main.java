import java.lang.Math;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main
{
	public static int floorNumber;

	public static void main (String [] args)
	{
		/****************************************************************
		Part 1: Setting Up Player, Defining Scrolls, Monsters, and Bosses
		****************************************************************/

		floorNumber = 0;

		/****************************************************************
		Part 2: The Actual Game (calling methods for encounters/fights)
		****************************************************************/
	}

	/****************************************************************
	Method to Call for Random Encounters
	****************************************************************/

	public Player getEvent(int selection, Player p1)
	{
		if (selection == 1) // Healing Fountain Event
		{
			System.out.println("You stumble upon a natural fountain pouring crystaline water.");
			System.out.println("...");
			TimeUnit.SECONDS.sleep(1);
			System.out.println("You drink the magical water and it restores your health and energy!");
			p1.energyUp(50);
			p1.hpUp(50);
		}

		else if (selection == 2) // Mysterious Rock Event
		{
			System.out.println("You stumble upon a mysterious looking rock. Dig the rock? Y/N");
			Scanner input = new Scanner(System.in);
			char userChoice = input.nextChar();
			if (userChoice == 'Y')
			{
				if (Math.random() > 0.49)
				{
					System.out.println("THONK THONK...");
					TimeUnit.SECONDS.sleep(1);
					System.out.println("You dig the rock and find a precious gold nugget as the source of its' pretty light.");
					System.out.println("You gain 8 gold!");
					p1.addGold(8);
				}
				else
				{
					System.out.println("THONK THONK...");
					TimeUnit.SECONDS.sleep(1);
					System.out.println("That wasn't just any rock...");
					System.out.println("It's a Rockalyte! And it's angry!");
					int rando = getRandomInt(1, 10);
					p1 = initiateFight(rando, p1, Rockalyte);
				}
			}
			else
			{
				System.out.println("You move on, leaving the rock asunder.");
			} 
		}
		else if (selection == 3) //Warlock Event
		{
			System.out.println("You stumble upon traveling warlock bearing a wide grin on his face and decide to talk to him.");
			System.out.println("...");
			TimeUnit.SECONDS.sleep(1);
			System.out.println("'Hero, do you wish to make a bloody pact? I can create gold for you, at the cost of your health.'");
			TimeUnit.SECONDS.sleep(1);
			System.out.println("Accept his offer? Y/N");
			Scanner input = new Scanner(System.in);
			char userChoice = input.nextChar();
			if (userChoice == 'Y')
			{
				System.out.println("You accept the evil pact. You lose 10 health and gain 10 gold.");
				p1.hpDown(10);
				p1.addGold(10);
			}
			else
			{
				System.out.println("You refuse the trade. The warlock walks off, still grinning.");
			}

		}
		else if (selection == 4) //Duelist Event
		{
			System.out.println("You stumble upon a traveling duelist. He points his sword at you.");
			System.out.println("...");
			TimeUnit.SECONDS.sleep(1);
			System.out.println("'Hmm, so you're the hero, huh. Want to fight me and see who the real hero is?'");
			System.out.println("...");
			TimeUnit.SECONDS.sleep(1);
			System.out.println("Accept his offer? Y/N");
			Scanner input = new Scanner(System.in);
			char userChoice = input.nextChar();
			if (userChoice == 'Y')
			{
				System.out.println("Without hesitation, the duelist laughes and lunges!");
				int rando = getRandomInt(1, 10);
				p1 = initiateFight(rando, p1, Duelist);
			}
			else
			{
				System.out.println("...");
				TimeUnit.SECONDS.sleep(1);
				System.out.println("'Hah! Coward!'");
			}

		}
		else if (selection == 5) // Rockslide Event
		{
			System.out.println("You stumble upon a crumbling wall.");
			System.out.println("...");
			TimeUnit.SECONDS.sleep(1);
			System.out.println("Oh no! Rocks from the wall fall onto you and you lose 15 health!");
			p1.hpDown(15);
		}
		else if (selection == 6) //Dryad Event
		{
			System.out.println("You stumble upon a beautiful dryad who looks like they were expecting you.");
			System.out.println("...");
			TimeUnit.SECONDS.sleep(1);
			System.out.println("'Hero, you must have taken quite a beating in the previous floors! I will completely heal you with my magic, but I will need a reimbursement in gold!");
			System.out.println("...");
			TimeUnit.SECONDS.sleep(1);
			System.out.println("Accept her offer? Y/N");
			Scanner input = new Scanner(System.in);
			char userChoice = input.nextChar();
			if (userChoice == 'Y')
			{
				System.out.println("The dryad channels her magic onto you, fully healing and energizing you!");
				p1.hpUp(p1.getMaxHealth());
				p1.energyUp(100);
				p1.subtractGold(25);
			}
			else
			{
				System.out.println("You reject the dryad's offer. She looks disappointed but wishes you luck anyways.");
			}
		}
		else if (selection == 7) // Blackjack Event
		{
			System.out.println("You stumble upon a card shark leaning against the wall of the tower. He nods his head at you.");
			System.out.println("...");
			TimeUnit.SECONDS.sleep(1);
			System.out.println("'Looking for a game of Blackjack? My pockets are heavy and could be yours!'");
			System.out.println("...");
			TimeUnit.SECONDS.sleep(1);
			System.out.println("Accept his offer? Y/N");
			Scanner input = new Scanner(System.in);
			char userChoice = input.nextChar();
			if (userChoice == 'Y')
			{
				boolean isPlaying == true;
				while (isPlaying)
				{
					if (p1.getGold() > 20)
					{
						p1 = playBlackjack(p1);
						System.out.println("Play again? Y/N");
						userChoice = input.nextChar();
						if (userChoice == 'N')
						{
							System.out.println("'All done? Hope you're happy!'");
							isPlaying == false;
						}
					}
					else
					{
						System.out.println("'I see I've emptied your pockets instead! Ahaha!'");
						isPlaying == false;
					}
				}
				
			}
			else
			{
				System.out.println("...");
				TimeUnit.SECONDS.sleep(1);
				System.out.println("'Don't want to test your luck, huh? I hear you.'");
			}

		}

		return p1;

	}

	/****************************************************************
	Method to Call for Random Fights with Basic Enemies
	****************************************************************/

	public Player initiateFight(int selection, Player p1, Enemy e1)
	{

	}

	/****************************************************************
	Method to Call for Fights with Bosses
	****************************************************************/

	public Player initiateBossFight(int selection, Player p1, Boss b1)
	{

	}

	/****************************************************************
	Method to Call for Shop after Boss Fight
	****************************************************************/

	public Player floorShop(Player p1)
	{

	}

	/****************************************************************
	Method to Call if the Player LOSES a fight
	****************************************************************/

	public void loseGame()
	{
		System.out.println("You lose!");
	}

	/****************************************************************
	Method to Call if the Player WINS the game
	****************************************************************/

	public void winGame()
	{
		System.out.println("You win!");
	}  

	public Player playBlackjack(Player p1)
	{
		Scanner input = new Scanner(System.in);
		final int threshhold = 21;
		int playerNumber = 0;
		int gamblerNumber = 0;
		int visibleGamblerNumber = 0;
		System.out.println("The gambler smiles and deals the cards.");
		playerNumber =  getRandomInt(1, 13) +  getRandomInt(1, 13);
		System.out.println("Your starting hand has a total of " + playerNumber + " points.");
		visibleGamblerNumber =  getRandomInt(1, 13);
		gamblerNumber = visibleGamblerNumber * 2;
		System.out.println("You see that the gambler has " + visibleGamblerNumber + " points.");
		for (int i = 0; i < 3; i++)
		{
			System.out.println("Deal(1) or Stand(2)? ");
			int userChoice = input.nextInt();
			if (userChoice == 1)
			{	
				int rando = getRandomInt(1, 13);
				playerNumber += rando;
				System.out.println("You now have a total of " + playerNumber + "points.");
				
			}
			else
			{
				System.out.println("You choose to stand.");
			}
			if (gamblerNumber < 10)
			{
				visibleGamblerNumber += getRandomInt(1, 13);
				System.out.println("The gambler takes a card. His visible total is now " + visibleGamblerNumber + " points.");
			}
			else
			{
				System.out.println("The gambler chooses to stand.");
			}
		}
		System.out.println("The gambler calls reveal!");
		System.out.println("You had " + playerNumber + " points. The gambler had " + gamblerNumber + " points.");
		if (playerNumber < 21 && gamblerNumber < 21)
		{
			if (playerNumber > gamblerNumber)
			{
				System.out.println("You win!");
				p1.addGold(20);
			}
			else
			{
				System.out.println("You lose!");
				p1.subtractGold(20);
			}
		}
		else if (playerNumber == 21)
		{
			System.out.println("You win!");
			p1.addGold(20);
		}
		else
		{
			System.out.println("You lose!");
			p1.subtractGold(20);
		}
		
	}

	public static int getRandomInt(int min, int max)
	{
    	int x = (int)(Math.random()*((max-min)+1))+min;
    	return x;
	}
}