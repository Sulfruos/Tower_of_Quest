/****************************************************************
Tower of Quest by Sulfruos
****************************************************************/

import java.lang.Math;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main
{
	public static int floorNumber;

	public static void main (String [] args) throws InterruptedException
	{
		/****************************************************************
		Part 1: Setting Up Player, Defining Scrolls, Monsters, and Bosses
		****************************************************************/

		Player p1 = new Player();

		Enemy Rockalyte = new Enemy(50, 5, 15, 10, "Rockalyte");
		Enemy Duelist = new Enemy(200, 15, 10, 35, "Duelist");

		Scroll basicAttack = new Scroll(0.2, 5, 1, "Sword Slash");

		scrollInventory scrollsOwned = new scrollInventory(basicAttack);


		/****************************************************************
		Part 2: The Actual Game (calling methods for encounters/fights)
		****************************************************************/

		System.out.println("A dishonored knight");
		System.out.println("...");
		TimeUnit.SECONDS.sleep(1);
		System.out.println("A terrible tower");
		System.out.println("...");
		TimeUnit.SECONDS.sleep(1);
		System.out.println("Yet still, a way to redemption");
		System.out.println("...");
		TimeUnit.SECONDS.sleep(1);
		System.out.println("'You weren't exiled for your inability. You were exiled for your boldness.'");
		TimeUnit.SECONDS.sleep(1);
		System.out.println("'You let the noble die so you could fight in the front lines. But they didn't see that'");
		System.out.println("'Prove them wrong. Climb the tower with nothing but your sword and your heroism'");
		TimeUnit.SECONDS.sleep(1);
		System.out.println("*******   *****   *       *       *  *****  * *  ");
		System.out.println("   *     *     *   *     * *     *   *      *   * ");
		System.out.println("   *     *     *    *   *   *   *    *****  * *   ");
		System.out.println("   *     *     *     * *     * *     *      *   * ");
		System.out.println("   *      *****       *       *      *****  *    *");
		TimeUnit.SECONDS.sleep(1);
		System.out.println(" *****   *****");
		System.out.println("*     *  *    ");
		System.out.println("*     *  *****");
		System.out.println("*     *  *    ");
		System.out.println(" *****   *    ");
		TimeUnit.SECONDS.sleep(1);
		System.out.println(" *****   *    *  *****  *****  *******");
	    System.out.println("*     *  *    *  *      *         *   ");
		System.out.println("*     *  *    *  *****  *****     *   ");
		System.out.println("*     *  *    *  *          *     *   ");
		System.out.println(" ***** * ******  *****  *****     *   ");



		for (int i = 1; i < 100; i++)
		{
			if (p1.getStatus() == true)
			{
				System.out.println("Floor: " + i);
				System.out.println("...");
				TimeUnit.SECONDS.sleep(1);
				p1 = getEvent(getRandomInt(1, 7), p1, scrollsOwned);

			}
		}
		
	}

	/****************************************************************
	Method to Call for Random Encounters
	****************************************************************/

	public static Player getEvent(int selection, Player p1, scrollInventory s) throws InterruptedException
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
			char userChoice = input.next().charAt(0);
			if (userChoice == 'Y')
			{
				if (Math.random() > 0.49)
				{
					System.out.println("THONK THONK...");
					TimeUnit.SECONDS.sleep(1);
					System.out.println("You dig the rock and find a precious gold nugget as the source of its' pretty light.");
					System.out.println("You gain 8 gold!");
					p1.addGold(8);
					System.out.println("You are now at " + p1.getGold() + " gold.");
				}
				else
				{
					System.out.println("THONK THONK...");
					TimeUnit.SECONDS.sleep(1);
					System.out.println("That wasn't just any rock...");
					System.out.println("It's a Rockalyte! And it's angry!");
					Enemy Rockalyte = new Enemy(50, 5, 15, 10, "Rockalyte");
					p1 = initiateFight(p1, Rockalyte, s);
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
			char userChoice = input.next().charAt(0);
			if (userChoice == 'Y')
			{
				System.out.println("You accept the evil pact. You lose 10 health and gain 10 gold.");
				p1.hpDown(10);
				p1.addGold(10);
				System.out.println("You are now at " + p1.getHealth() + " health and " + p1.getGold() + " gold.");
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
			char userChoice = input.next().charAt(0);
			if (userChoice == 'Y')
			{
				System.out.println("Without hesitation, the duelist laughes and lunges!");
				Enemy Duelist = new Enemy(200, 15, 10, 35, "Duelist");
				p1 = initiateFight(p1, Duelist, s);
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
			System.out.println("You are now at " + p1.getHealth() + " health.");
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
			char userChoice = input.next().charAt(0);
			if (userChoice == 'Y')
			{
				if (p1.getGold() > 25)
				{
					System.out.println("The dryad channels her magic onto you, fully healing and energizing you!");
					p1.hpUp(100);
					p1.energyUp(100);
					p1.subtractGold(25);
					System.out.println("You are now at " + p1.getGold() + " gold.");
				}
				else
				{
					System.out.println("...");
					TimeUnit.SECONDS.sleep(1);
					System.out.println("'I am sorry hero, but you lack sufficient gold. I wish you luck regardless.'");
				}
				
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
			char userChoice = input.next().charAt(0);
			if (userChoice == 'Y')
			{
				boolean isPlaying = true;
				while (isPlaying)
				{
					if (p1.getGold() > 20)
					{
						p1 = playBlackjack(p1);
						System.out.println("Play again? Y/N");
						userChoice = input.next().charAt(0);
						if (userChoice == 'N')
						{
							System.out.println("'All done? Hope you're happy!'");
							isPlaying = false;
						}
					}
					else
					{
						System.out.println("...");
						TimeUnit.SECONDS.sleep(1);
						System.out.println("'Man, your pockets are empty!'");
						isPlaying = false;
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
	Methods to Call for Random Fights with Basic Enemies
	****************************************************************/
/*
	public static Player setUpFight(int selection)
	{
		if (selection == 1)
		{

		}
	}
	*/

	public static Player initiateFight(Player p1, Enemy e1, scrollInventory s1) throws InterruptedException
	{

		System.out.println("You face a " + e1.getName() + "!");
		System.out.println("...");
		TimeUnit.SECONDS.sleep(1);

		boolean stillFighting = true;
		boolean guardUp = false; // used to check if player guarded this turn
		Scanner input = new Scanner(System.in);

		boolean playerWins = false;
		boolean enemyWins = false;
		

		while (stillFighting)
		{
			// Player turn 

			System.out.println("You have " + p1.getHealth() + " HP and " + p1.getEnergy() + " energy remaining.");
			System.out.println("The enemy is at " + e1.getHealth() + " health.");
			System.out.println("Choose an action.");
			System.out.println("...");
			TimeUnit.SECONDS.sleep(1);
			System.out.println("Attack(1), Guard(2), Items(3)");
			int userChoice = input.nextInt();
			if (userChoice == 1)
			{
				System.out.println("Choose an attack.");
				s1.printScrolls();
				userChoice = input.nextInt();
				double scrollFormula = (p1.getPlayerDamage(s1.chooseScroll(userChoice)) / 2) * getRandomInt(1, 3);
				double decimalPlayerDamage = scrollFormula - e1.getDefense();
				int roundedPlayerDamage = (int) decimalPlayerDamage;
				if (roundedPlayerDamage > 0)
				{
					e1.hpDown(roundedPlayerDamage);
					System.out.println("The enemy took "  + roundedPlayerDamage + " damage from your attack and is now at " + e1.getHealth() + " health.");
					if (e1.getHealth() <= 0)
					{
						stillFighting = false;
						playerWins = true;
					}
				}
				else
				{
					if (scrollFormula == 0)
					{
						System.out.println("Your attack missed!");
					}
					else
					{
						System.out.println("Your attack only scratched the foe's strong defense and dealt 1 damage.");
						e1.hpDown(1);
					}
					
				}
				
			}
			else if (userChoice == 2)
			{
				System.out.println("You guard this turn, restoring 10 energy and reducing damage taken by 25%.");
				p1.energyUp(10);
				guardUp = true;
			}
			else
			{

			}
			
			// Enemy turn

			System.out.println("It is the enemy's turn.");
			System.out.println("...");
			TimeUnit.SECONDS.sleep(1);
			double decimalEnemyDamage = (e1.getAttack() / 2) * getRandomInt(1, 3);
			decimalEnemyDamage -= p1.getDefense();
			if (guardUp)
			{
				decimalEnemyDamage /= 4;
				decimalEnemyDamage *= 3;
			}
			int roundedEnemyDamage = (int) decimalEnemyDamage;
			if (roundedEnemyDamage > 0)
			{
				System.out.println(e1.getName() + " attacks you for " + roundedEnemyDamage + " damage.");
				p1.hpDown(roundedEnemyDamage);
				System.out.println("You are now at " + p1.getHealth() + " health.");
			}
			else
			{
				System.out.println("Your defense was too strong for the enemy's attack! It only did 1 damage!");
				p1.hpDown(1);
				System.out.println("You are now at " + p1.getHealth() + " health.");
			}
			
			

			if (p1.getHealth() <= 0)
			{
				stillFighting = false;
				enemyWins = true;
			}


		}

		if (playerWins)
		{
			p1.addGold(e1.getValue());
			System.out.println("You win! You gain " + e1.getValue() + " gold and are now at " + p1.getGold() + " gold!");

			return p1;
		}
		else
		{
			loseGame(p1);
			return p1;
		}
	}

	/****************************************************************
	Method to Call for Fights with Bosses
	****************************************************************/
/*
	public Player initiateBossFight(int selection, Player p1, Boss b1)
	{

	}

	/****************************************************************
	Method to Call for Shop after Boss Fight
	****************************************************************/
/*
	public static Player floorShop(Player p1)
	{

	}

	*/

	/****************************************************************
	Method to Call if the Player LOSES a fight
	****************************************************************/

	public static void loseGame(Player p1)
	{
		System.out.println("You lose!");
		p1.setStatus(false);
	}

	/****************************************************************
	Method to Call if the Player WINS the game
	****************************************************************/

	public static void winGame()
	{
		System.out.println("You win!");
	}  

	public static Player playBlackjack(Player p1) throws InterruptedException
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

		return p1;
		
	}

	public static int getRandomInt(int min, int max)
	{
    	int x = (int)(Math.random()*((max-min)+1))+min;
    	return x;
	}
}