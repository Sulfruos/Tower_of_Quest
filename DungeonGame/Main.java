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
		Part 1: Setting Up Player, Defining Scrolls
		****************************************************************/

		//possible classes:
		//Monk - Attack, Shock Palm, Invigorate
		//Warrior - Attack, Sword Charge, Guard Strike
		//Rogue - Attack, Precise Strike, 30 gold
		//Barbarian - Attack, Wild Swing, Decimate
		//Paladin - Attack, Purge, Health Potion

		Player p1 = new Player();

		System.out.println("A dishonored knight");
		System.out.println("...");
		TimeUnit.SECONDS.sleep(1);
		System.out.println("A terrible tower");
		System.out.println("...");
		TimeUnit.SECONDS.sleep(1);
		System.out.println("Yet still, a way to redemption");
		System.out.println("...");
		TimeUnit.SECONDS.sleep(2);
		System.out.println("'You weren't exiled for your inability.\n You were exiled for your boldness.'");
		TimeUnit.SECONDS.sleep(2);
		System.out.println("'You let the king die from the invasion so you could fight in the front lines.\n But your people didn't see that.'");
		System.out.println("'Prove them wrong.\n Climb the tower with nothing but your sword and your heroism.'");
		TimeUnit.SECONDS.sleep(3);
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
		System.out.println("...");
		TimeUnit.SECONDS.sleep(3);


		Scanner input = new Scanner(System.in);

		Scroll attack = new Scroll(0.1, 5, 2, "Attack", 0, true);
		attack.setDesc("A simple but reliable attack.");
		Scroll sword_Charge = new Scroll(0.35, 20, 5, "Sword Charge", 0, true);
		sword_Charge.setDesc("Riskily attacks the foe by lunging with the sword for high damage.");
		Scroll precise_Strike = new Scroll(0, 10, 3, "Precise Strike", 0, true);
		precise_Strike.setDesc("Aims for the perfect moment to strike with great accuracy.");
		Scroll wild_Swing = new Scroll(0.5, 5, 4, "Wild Swing", 0, true);
		wild_Swing.setDesc("Broadly swings at the foe for medium damage if it hits.");
		Scroll dragon_Strike = new Scroll(0, 30, 6, "Dragon Strike", 0, true);
		dragon_Strike.setDesc("Utilizes ancient technique to strike the foe with high power and accuracy.");
		Scroll invigorate = new Scroll(0, 20, 0, "Invigorate", 1, false);
		invigorate.setDesc("Naturally flows chi through the body, restoring 9 HP and 30 Energy over 3 turns.");
		Scroll dark_Aura = new Scroll(0, 80, 0, "Dark Aura", 2, false);
		dark_Aura.setDesc("Utilizes dark technique to double attack stat.");
		Scroll bulwark = new Scroll(0, 30, 0, "Bulwark", 3, false);
		bulwark.setDesc("Strengthens the body to increase defense by 20% and take 50% less damage on the turn used.");
		Scroll skullCrack = new Scroll(0.4, 25, 4, "Skullcrack", 4, false);
		skullCrack.setDesc("Riskily aims for the foe's head to deal damage and has a 50% chance to weaken them.");
		Scroll shock_Palm = new Scroll(0.1, 15, 3, "Shock Palm", 5, false);
		shock_Palm.setDesc("Quickly jabs the foe with the open hand. 20% chance to stun the foe.");
		Scroll all_or_nothing = new Scroll(0, 60, 7, "All or Nothing", 6, false);
		all_or_nothing.setDesc("Attacks with great energy, dealing high damage and stunning foe.");
		Scroll arcane_Bolt = new Scroll(0.1, 20, 0, "Arcane Bolt", 7, false);
		arcane_Bolt.setDesc("Shoots a mystical bolt at the foe that always does 10 damage.");
		Scroll guarding_Strike = new Scroll(0, 15, 2, "Guarding Strike", 8, false);
		guarding_Strike.setDesc("Attacks by bashing the foe with a shield and guards and take 50% less damage on the turn used.");
		Scroll decimate = new Scroll(0.2, 25, 3, "Decimate", 9, false);
		decimate.setDesc("Crushes through the opponent's armor to deal damage that ignores their defense.");
		Scroll purge = new Scroll(0, 20, 3, "Purge", 10, false);
		purge.setDesc("Blasts the foe with invoked light to deal damage and remove all stat changes.");

		scrollInventory scrollsOwned = new scrollInventory(attack);

		scrollInventory purchasableScrolls = new scrollInventory(arcane_Bolt);


		System.out.println("Now, all knights have identities. What is yours?");
		System.out.println("...");
		TimeUnit.SECONDS.sleep(1);
		System.out.println("Monk, who walks the path to enlightenment. Starter scrolls: ");
		System.out.println("...");
		TimeUnit.SECONDS.sleep(1);
		attack.getDesc();
		invigorate.getDesc();
		shock_Palm.getDesc();
		System.out.println("...");
		TimeUnit.SECONDS.sleep(3);
		System.out.println("Warrior, who decides matters by his might and intellect. Starter scrolls: ");
		System.out.println("...");
		TimeUnit.SECONDS.sleep(1);
		attack.getDesc();
		sword_Charge.getDesc();
		guarding_Strike.getDesc();
		System.out.println("...");
		TimeUnit.SECONDS.sleep(3);
		System.out.println("Barbarian, who uses brute force and the luck of battle to get his way. Starter scrolls: ");
		System.out.println("...");
		TimeUnit.SECONDS.sleep(1);
		attack.getDesc();
		wild_Swing.getDesc();
		decimate.getDesc();
		System.out.println("...");
		TimeUnit.SECONDS.sleep(3);
		System.out.println("Paladin, who has mastered the powers of light and justice. Has come prepared with two Health Potions. Starter scrolls: ");
		System.out.println("...");
		TimeUnit.SECONDS.sleep(1);
		attack.getDesc();
		purge.getDesc();
		System.out.println("...");
		TimeUnit.SECONDS.sleep(3);
		System.out.println("Rogue, who strikes fast and sharp. Snuck in 30 gold. Starter scrolls: ");
		attack.getDesc();
		precise_Strike.getDesc();
		System.out.println("...");
		TimeUnit.SECONDS.sleep(3);
		System.out.println("Now, choose a class to begin the ascent.");
		System.out.println("...");
		TimeUnit.SECONDS.sleep(1);
		System.out.println("Press 1 for Monk, 2 for Warrior, 3 for Barbarian, 4 for Paladin, or 5 for Rogue: ");

		int userChoice = input.nextInt();
		if (userChoice == 1)
		{
			System.out.println("You are a Monk! Now, let us begin...");
			scrollsOwned.addScroll(invigorate);
			scrollsOwned.addScroll(shock_Palm);

			purchasableScrolls.addScroll(guarding_Strike);
			purchasableScrolls.addScroll(sword_Charge);
			purchasableScrolls.addScroll(wild_Swing);
			purchasableScrolls.addScroll(decimate);
			purchasableScrolls.addScroll(dragon_Strike);
			purchasableScrolls.addScroll(invigorate);
			purchasableScrolls.addScroll(bulwark);
			purchasableScrolls.addScroll(skullCrack);
			purchasableScrolls.addScroll(dark_Aura);
			purchasableScrolls.addScroll(all_or_nothing);
			purchasableScrolls.addScroll(purge);
			purchasableScrolls.addScroll(precise_Strike);

		}
		else if (userChoice == 2)
		{
			System.out.println("You are a Warrior! Now, let us begin...");
			scrollsOwned.addScroll(sword_Charge);
			scrollsOwned.addScroll(guarding_Strike);

			purchasableScrolls.addScroll(shock_Palm);
			purchasableScrolls.addScroll(invigorate);
			purchasableScrolls.addScroll(wild_Swing);
			purchasableScrolls.addScroll(decimate);
			purchasableScrolls.addScroll(dragon_Strike);
			purchasableScrolls.addScroll(invigorate);
			purchasableScrolls.addScroll(bulwark);
			purchasableScrolls.addScroll(skullCrack);
			purchasableScrolls.addScroll(dark_Aura);
			purchasableScrolls.addScroll(all_or_nothing);
			purchasableScrolls.addScroll(purge);
			purchasableScrolls.addScroll(precise_Strike);
		}
		else if (userChoice == 3)
		{
			System.out.println("You are a Barbarian! Now, let us begin...");
			scrollsOwned.addScroll(wild_Swing);
			scrollsOwned.addScroll(decimate);

			purchasableScrolls.addScroll(guarding_Strike);
			purchasableScrolls.addScroll(sword_Charge);
			purchasableScrolls.addScroll(shock_Palm);
			purchasableScrolls.addScroll(invigorate);
			purchasableScrolls.addScroll(dragon_Strike);
			purchasableScrolls.addScroll(invigorate);
			purchasableScrolls.addScroll(bulwark);
			purchasableScrolls.addScroll(skullCrack);
			purchasableScrolls.addScroll(dark_Aura);
			purchasableScrolls.addScroll(all_or_nothing);
			purchasableScrolls.addScroll(purge);
			purchasableScrolls.addScroll(precise_Strike);
			
		}
		else if (userChoice == 4)
		{
			System.out.println("You are a Paladin! Now, let us begin...");
			scrollsOwned.addScroll(purge);
			p1.addPot();
			p1.addPot();

			purchasableScrolls.addScroll(wild_Swing);
			purchasableScrolls.addScroll(decimate);
			purchasableScrolls.addScroll(guarding_Strike);
			purchasableScrolls.addScroll(sword_Charge);
			purchasableScrolls.addScroll(shock_Palm);
			purchasableScrolls.addScroll(invigorate);
			purchasableScrolls.addScroll(dragon_Strike);
			purchasableScrolls.addScroll(invigorate);
			purchasableScrolls.addScroll(bulwark);
			purchasableScrolls.addScroll(skullCrack);
			purchasableScrolls.addScroll(dark_Aura);
			purchasableScrolls.addScroll(all_or_nothing);
			purchasableScrolls.addScroll(precise_Strike);
		}
		else if (userChoice == 5)
		{
			System.out.println("You are a Rogue! Now, let us begin...");
			scrollsOwned.addScroll(precise_Strike);
			p1.addGold(30);

			purchasableScrolls.addScroll(purge);
			purchasableScrolls.addScroll(wild_Swing);
			purchasableScrolls.addScroll(decimate);
			purchasableScrolls.addScroll(guarding_Strike);
			purchasableScrolls.addScroll(sword_Charge);
			purchasableScrolls.addScroll(shock_Palm);
			purchasableScrolls.addScroll(invigorate);
			purchasableScrolls.addScroll(dragon_Strike);
			purchasableScrolls.addScroll(invigorate);
			purchasableScrolls.addScroll(bulwark);
			purchasableScrolls.addScroll(skullCrack);
			purchasableScrolls.addScroll(dark_Aura);
			purchasableScrolls.addScroll(all_or_nothing);
		
		}

		System.out.println("...");
		TimeUnit.SECONDS.sleep(2);


		/****************************************************************
		Part 2: The Actual Game (calling methods for encounters/fights)
		****************************************************************/

		int decFloor = 1;
		int bossNumber = 1; // increments every ten floors, a boss is called for floor

		for (int i = 1; i < 71; i++)
		{
			if (p1.getStatus() == true)
			{
				System.out.println("The hero has " + p1.getGold() + " gold, " + p1.getHealth() + " health, " + p1.getEnergy() + " energy, " + p1.getAttack() + " attack, and " + p1.getDefense() + " defense.");
				System.out.println("Floor: " + i);
				System.out.println("...");
				TimeUnit.SECONDS.sleep(1);
				if (decFloor == 1)
				{
					
					p1 = setUpFight(getRandomInt(1, 9), p1, scrollsOwned);
				
				}
				else if (decFloor == 2)
				{
					p1 = getEvent(getRandomInt(1, 9), p1, scrollsOwned, purchasableScrolls); // 2, 5 ,9
				}
				else if (decFloor == 3)
				{
					p1 = setUpFight(getRandomInt(1, 9), p1, scrollsOwned);
				}
				else if (decFloor == 4)
				{
					p1 = setUpFight(getRandomInt(1, 9), p1, scrollsOwned);
				}
				else if (decFloor == 5)
				{
					p1 = getEvent(getRandomInt(1, 9), p1, scrollsOwned, purchasableScrolls); // 2, 5 ,9
				}
				else if (decFloor == 6)
				{
					p1 = setUpFight(getRandomInt(1, 9), p1, scrollsOwned);
				}
				else if (decFloor == 7)
				{
					p1 = setUpFight(getRandomInt(1, 9), p1, scrollsOwned);
				}
				else if (decFloor == 8)
				{
					p1 = setUpFight(getRandomInt(1, 9), p1, scrollsOwned);
				}
				else if (decFloor == 9)
				{
					p1 = getEvent(getRandomInt(1, 9), p1, scrollsOwned, purchasableScrolls); // 2, 5 ,9
				}
				else if (decFloor == 10)
				{
					p1 = floorShop(p1, scrollsOwned, purchasableScrolls);
					p1 = setUpBossFight(bossNumber, p1, scrollsOwned);
					decFloor = 0;
					bossNumber++;

				}

				decFloor++;

			}

			
		}

		if (p1.getStatus() == true)
		{
			System.out.println("...");
			TimeUnit.SECONDS.sleep(1);
			System.out.println("Struggling to stay conscious, you move past the fallen Anubis towards the tressure.");
			System.out.println("...");
			TimeUnit.SECONDS.sleep(1);
			System.out.println("With joy, you grab it and instantly are turned to ash by a huge sun ray.");
			System.out.println("...");
			TimeUnit.SECONDS.sleep(1);
			System.out.println("You win... technically.");
			System.out.println("...");
			TimeUnit.SECONDS.sleep(1);
			System.out.println("Congrats! Game written and coded by Arvind Pillai.");
		
		}
		else
		{
			if (bossNumber == 7)
			{
				System.out.println("Anubis knocks you down and juts his staff into your sternum.You feel your life energy slip away...");
				System.out.println("...");
				TimeUnit.SECONDS.sleep(1);
				System.out.println("You made it this far. Shame you couldn't end it.");
			}
			
		}
			
		
	}

	/****************************************************************
	Method to Call for Random Encounters
	****************************************************************/

	public static Player getEvent(int selection, Player p1, scrollInventory s1, scrollInventory s2) throws InterruptedException
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
					System.out.println("You gain 10 gold!");
					p1.addGold(10);
					System.out.println("You are now at " + p1.getGold() + " gold.");
				}
				else
				{
					System.out.println("THONK THONK...");
					TimeUnit.SECONDS.sleep(1);
					System.out.println("That wasn't just any rock...");
					System.out.println("It's a Rockalyte! And it's angry!");
					Enemy Rockalyte = new Enemy(50, 5, 15, 15, "Rockalyte");
					p1 = initiateFight(p1, Rockalyte, s1);
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
				Enemy Duelist = new Enemy(150, 15, 10, 40, "Duelist");
				p1 = initiateFight(p1, Duelist, s1);
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
		else if (selection == 8) // Blacksmith Event
		{
			System.out.println("You stumble upon a man carrying an anvil and a hammer.");
			System.out.println("...");
			TimeUnit.SECONDS.sleep(1);
			System.out.println("'Ey, your equipment looks quite flimsy! I can make it better if you give me 12 gold!'");
			System.out.println("...");
			TimeUnit.SECONDS.sleep(1);
			System.out.println("Accept his offer? Y/N");
			Scanner input = new Scanner(System.in);
			char userChoice = input.next().charAt(0);
			if (userChoice == 'Y')
			{
				if (p1.getGold() >= 12)
				{
					System.out.println("...");
					TimeUnit.SECONDS.sleep(1);
					p1.atkUp(2);
					p1.defUp(2);
					p1.subtractGold(12);
					System.out.println("The blacksmith shines your sword and sturdies your shield. You are now at " + p1.getAttack() + " attack and " + p1.getDefense() + " defense!");
				}
				else
				{
					System.out.println("...");
					TimeUnit.SECONDS.sleep(1);
					System.out.println("'No gold eh? A bummer.'");
				}
			}
			else
			{
				System.out.println("...");
				TimeUnit.SECONDS.sleep(1);
				System.out.println("'No gold eh? A bummer.'");
			}
				

		}
		else if (selection == 9)
		{
			System.out.println("You stumble upon a mysterious vendor holding a stuffed satchel.");
			System.out.println("...");
			TimeUnit.SECONDS.sleep(1);
			s1 = scrollVendor(p1, s1, s2);
		}

		return p1;
		

	}

	/****************************************************************
	Methods to Call for Random Fights with Basic Enemies
	****************************************************************/

	public static Player setUpFight(int selection, Player p1, scrollInventory s1) throws InterruptedException //bosses: similar system, but they have special attacks
	{
		Enemy Ogre = new Enemy(40, 6, 7, 8, "Ogre");
		Enemy Bat = new Enemy(20, 5, 3, 4, "Bat");
		Enemy Golem = new Enemy(70, 2, 8, 7, "Golem");
		Enemy Elemental = new Enemy(25, 12, 2, 6, "Elemental");
		Enemy Feral = new Enemy(50, 5, 5, 7, "Feral");
		Enemy Sorcerer = new Enemy(40, 9, 4, 9, "Sorcerer");
		Enemy Fallen = new Enemy(80, 10, 5, 15, "Fallen");
		Enemy EyeEye = new Enemy(30, 6, 6, 6, "EyeEye");
		Enemy Slime = new Enemy(25, 2, 4, 3, "Slime");

		if (selection == 1)
		{
			initiateFight(p1, Ogre, s1);
		}
		else if (selection == 2)
		{
			initiateFight(p1, Bat, s1);
		}
		else if (selection == 3)
		{
			initiateFight(p1, Golem, s1);
		}
		else if (selection == 4)
		{
			initiateFight(p1, Elemental, s1);
		}
		else if (selection == 5)
		{
			initiateFight(p1, Feral, s1);
		}
		else if (selection == 6)
		{
			initiateFight(p1, Sorcerer, s1);
		}
		else if (selection == 7)
		{
			initiateFight(p1, Fallen, s1);
		}
		else if (selection == 8)
		{
			initiateFight(p1, EyeEye, s1);
		}
		else if (selection == 9)
		{
			initiateFight(p1, Slime, s1);
		}

		return p1;
	}
	

	public static Player initiateFight(Player p1, Enemy e1, scrollInventory s1) throws InterruptedException
	{

		System.out.println("You face a " + e1.getName() + "!");
		System.out.println("...");
		TimeUnit.SECONDS.sleep(1);

		boolean stillFighting = true;
		boolean guardUp = false; // used to check if player guarded this turn
		boolean isStunned = false; //used to check if enemy is stunned by an attack
		int channelCount = 0; //amount of invigorate turns left
		Scanner input = new Scanner(System.in);

		boolean playerWins = false;
		boolean enemyWins = false;
		
		p1.setDisplayAttack(p1.getAttack());
		p1.setDisplayDefense(p1.getDefense());

		e1.setDisplayAttack(e1.getAttack());
		e1.setDisplayDefense(e1.getDefense());

		while (stillFighting)
		{
			// Player turn

			if (channelCount > 0)
			{
				System.out.println("...");
				TimeUnit.SECONDS.sleep(1);
				System.out.println("You feel your blood boil in a lukewarm way, causing you to relax. You regain 3 HP and 10 Energy!");
				p1.hpUp(3);
				p1.energyUp(10);
				channelCount--;
			}

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
				Scroll chosenMove = s1.chooseScroll(userChoice);
				if (p1.getEnergy() >= chosenMove.getEnergyCost())
				{

					if (chosenMove.getType() == false)
					{
						if (chosenMove.getID() == 1)
						{
							p1.subtractEnergy(chosenMove.getEnergyCost());
							System.out.println("You channel your energy into your chi, letting it flow through you for the next 3 turns.");
							channelCount = 3;
						}
						else if (chosenMove.getID() == 2)
						{
							p1.subtractEnergy(chosenMove.getEnergyCost());
							System.out.println("You feel a dark aura encompassing you. Your Attack increases by 100%.");
							int roundAttack = (int) (p1.getDisplayAttack() * 2);
							p1.setDisplayAttack(roundAttack);

							System.out.println("Your attack is now " + p1.getDisplayAttack() + ".");
						}
						else if (chosenMove.getID() == 3)
						{
							p1.subtractEnergy(chosenMove.getEnergyCost());
							System.out.println("You feel your chest harden to the quality of stone. Your Defense increases by 20% and you reduce damage taken this turn by 50%.");
							int roundDefense = (int) (p1.getDisplayDefense() * 1.2);
							p1.setDisplayDefense(roundDefense);
							System.out.println("Your defense is now " + p1.getDisplayDefense() + ".");
							guardUp = true;
						}
						else if (chosenMove.getID() == 4)
						{
							double scrollFormula = (p1.getPlayerDamage(s1.chooseScroll(userChoice)) * p1.getDisplayAttack() / 2);
							if (scrollFormula == 0)
							{
								System.out.println("Your attack missed!");
							}
							else
							{
								double decimalPlayerDamage = scrollFormula - e1.getDisplayDefense();
								int roundedPlayerDamage = (int) decimalPlayerDamage;
								roundedPlayerDamage += getRandomInt(1, 3);
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
									
										System.out.println("Your attack only scratched the foe's strong defense and dealt 1 damage.");
										e1.hpDown(1);
									
								}
								if (getRandomInt(1, 4) > 2)
								{
									System.out.println("The concussive power of Skullcrack caused your opponent to lose 20% Attack and Defense!");
									int roundEnemyAttack1 = (int) (p1.getDisplayAttack() * 0.8);
									e1.setDisplayAttack(roundEnemyAttack1);
									int roundEnemyDefense1 = (int) (p1.getDisplayDefense() * 0.8);
									e1.setDisplayDefense(roundEnemyDefense1);
								}
							}
							
						}
						else if (chosenMove.getID() == 5)
						{
							double scrollFormula = (p1.getPlayerDamage(s1.chooseScroll(userChoice)) * p1.getDisplayAttack() / 2);
							if (scrollFormula == 0)
							{
								System.out.println("Your attack missed!");
							}
							else
							{
								double decimalPlayerDamage = scrollFormula - e1.getDisplayDefense();
								int roundedPlayerDamage = (int) decimalPlayerDamage;
								roundedPlayerDamage += getRandomInt(1, 3);
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
									
										System.out.println("Your attack only scratched the foe's strong defense and dealt 1 damage.");
										e1.hpDown(1);
									
								}
								if (getRandomInt(1, 5) > 4)
								{
									System.out.println("Your attack is so sharp and surprising that it stuns the foe!");
									isStunned = true;
									
								}

							}
						}
						else if (chosenMove.getID() == 6)
						{
							double scrollFormula = (p1.getPlayerDamage(s1.chooseScroll(userChoice)) * p1.getDisplayAttack() / 2);
							if (scrollFormula == 0)
							{
								System.out.println("Your attack missed!");
							}
							else
							{
								double decimalPlayerDamage = scrollFormula - e1.getDisplayDefense();
								int roundedPlayerDamage = (int) decimalPlayerDamage;
								roundedPlayerDamage += getRandomInt(1, 3);
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
									
										System.out.println("Your attack only scratched the foe's strong defense and dealt 1 damage.");
										e1.hpDown(1);
									
								}

								System.out.println("The attack was so devastating that the foe is stunned from its' force!");
								isStunned = true;

							}
						}
						else if (chosenMove.getID() == 7)
						{
							p1.subtractEnergy(chosenMove.getEnergyCost());
							if (Math.random() < 0.1)
							{
								System.out.println("Your attack missed!");
							}
							else
							{
								e1.hpDown(10);
								System.out.println("The enemy took 10 damage from your attack and is now at " + e1.getHealth() + " health.");
								if (e1.getHealth() <= 0)
								{
									stillFighting = false;
									playerWins = true;
								}
							}
						}
						else if (chosenMove.getID() == 8)
						{
							double scrollFormula = (p1.getPlayerDamage(s1.chooseScroll(userChoice)) * p1.getDisplayAttack() / 2);
							if (scrollFormula == 0)
							{
								System.out.println("Your attack missed!");
							}
							else
							{
								double decimalPlayerDamage = scrollFormula - e1.getDisplayDefense();
								int roundedPlayerDamage = (int) decimalPlayerDamage;
								roundedPlayerDamage += getRandomInt(1, 3);
								if (roundedPlayerDamage > 0)
								{
									e1.hpDown(roundedPlayerDamage);
									System.out.println("The enemy took "  + roundedPlayerDamage + " damage from your attack and is now at " + e1.getHealth() + " health.");
									if (e1.getHealth() <= 0)
									{
										stillFighting = false;
										playerWins = true;
									}
									guardUp = true;
									System.out.println("You also quickly hold your weapon up, blocking 50% of the next damage you take.");
								}
								else
								{
									
										System.out.println("Your attack only scratched the foe's strong defense and dealt 1 damage.");
										e1.hpDown(1);
									
								}
							}
						}
						else if (chosenMove.getID() == 9)
						{
							double scrollFormula = (p1.getPlayerDamage(s1.chooseScroll(userChoice)) * p1.getDisplayAttack() / 2);
							if (scrollFormula == 0)
							{
								System.out.println("Your attack missed!");
							}
							else
							{
								double decimalPlayerDamage = scrollFormula;
								int roundedPlayerDamage = (int) decimalPlayerDamage;
								roundedPlayerDamage += getRandomInt(1, 3);
								if (roundedPlayerDamage > 0)
								{
									e1.hpDown(roundedPlayerDamage);
									System.out.println("You attack the floor with a mighty swing, sending a shockwave towards the opponent that ignores their armor.");
									System.out.println("The enemy took "  + roundedPlayerDamage + " damage from your attack and is now at " + e1.getHealth() + " health.");
									if (e1.getHealth() <= 0)
									{
										stillFighting = false;
										playerWins = true;
									}
								}
							}
						}
						else if (chosenMove.getID() == 10)
						{
							double scrollFormula = (p1.getPlayerDamage(s1.chooseScroll(userChoice)) * p1.getDisplayAttack() / 2);
							if (scrollFormula == 0)
							{
								System.out.println("Your attack missed!");
							}
							else
							{
								double decimalPlayerDamage = scrollFormula - e1.getDisplayDefense();
								int roundedPlayerDamage = (int) decimalPlayerDamage;
								roundedPlayerDamage += getRandomInt(1, 3);
								if (roundedPlayerDamage > 0)
								{
									e1.hpDown(roundedPlayerDamage);
									System.out.println("The enemy took "  + roundedPlayerDamage + " damage from your attack and is now at " + e1.getHealth() + " health.");
									if (e1.getHealth() <= 0)
									{
										stillFighting = false;
										playerWins = true;
									}
									System.out.println("The power of the light cleanses your opponent, removing all of their stat changes!");
									e1.setDisplayAttack(e1.getAttack());
									e1.setDisplayDefense(e1.getDefense());
									System.out.println("The enemy now has " + e1.getDisplayAttack() + " attack and " + e1.getDisplayDefense() + " defense!");
								}
								else
								{
									
										System.out.println("Your attack only scratched the foe's strong defense and dealt 1 damage.");
										e1.hpDown(1);
									
								}
							}
						}
					}
					else
					{
						double scrollFormula = (p1.getPlayerDamage(s1.chooseScroll(userChoice)) * p1.getDisplayAttack() / 2);
						if (scrollFormula == 0)
						{
							System.out.println("Your attack missed!");
						}
						else
						{
							double decimalPlayerDamage = scrollFormula - e1.getDisplayDefense();
							int roundedPlayerDamage = (int) decimalPlayerDamage;
							roundedPlayerDamage += getRandomInt(1, 3);
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
								
									System.out.println("Your attack only scratched the foe's strong defense and dealt 1 damage.");
									e1.hpDown(1);
								
							}
						}
					}
					
				}
				else
				{
					System.out.println("Not enough energy!");
				}
				
				
				
			}
			else if (userChoice == 2)
			{
				System.out.println("You guard this turn, restoring 10 energy and reducing damage taken by 50%.");
				p1.energyUp(10);
				guardUp = true;
			}
			else
			{
				if (p1.potCount() > 0)
				{
					System.out.println("HEALTH POTIONS: " + p1.potCount());
					System.out.println("Press 1 to use a Health Potion or 2 to Quit");
					userChoice = input.nextInt();
					if (userChoice == 1)
					{
						p1.usePot();
					}

				}
				else
				{
					System.out.println("Your bag is empty!");
				}
			}
			
			// Enemy turn
			if (isStunned)
			{
				System.out.println("...");
				TimeUnit.SECONDS.sleep(1);
				System.out.println("The enemy is stunned and can't act this turn!");
				isStunned = false;
			}
			else if (playerWins)
			{
				System.out.println("...");
				TimeUnit.SECONDS.sleep(1);
				System.out.println("The enemy is all out of HP!");
			}
			else
			{
				System.out.println("It is the enemy's turn.");
				System.out.println("...");
				TimeUnit.SECONDS.sleep(1);
				double decimalEnemyDamage = (e1.getDisplayAttack() / 2) + getRandomInt(1, 3);
				decimalEnemyDamage -= (p1.getDisplayDefense() / 2);
				if (guardUp)
				{
					decimalEnemyDamage /= 4;
					decimalEnemyDamage *= 2;
					guardUp = false;
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
			p1.energyUp(20);
			System.out.println("You win! You gain " + e1.getValue() + " gold and are now at " + p1.getGold() + " gold!");

			stillFighting = false;
		}
		else if (enemyWins)
		{
			loseGame(p1);
			return p1;
		}

		}

		return p1;

		

	}

	/****************************************************************
	Method to Call for Fights with Bosses
	****************************************************************/

	public static Player setUpBossFight(int selection, Player p1, scrollInventory s1) throws InterruptedException
	{

		Boss Anubis = new Boss(100, 6, 9, 30, 20, "Anubis, Noble Servant");
		Spell emanate = new Spell(0, 7, 0, "Emanate", 1);
		Spell soul_Eater = new Spell(0.2, 6, 1, "Soul Eater", 2);
		bossAttacks a1 = new bossAttacks(emanate);
		a1.addAttack(soul_Eater);

		Boss Raanix = new Boss(80, 15, 8, 30, 20, "Raanix the Rancid");
		Spell liquify = new Spell(0.2, 3, 0.8, "Liquify", 3);
		Spell perilous_Wings = new Spell(0.4, 5, 2, "Perilous Wings", 4);
		bossAttacks a2 = new bossAttacks(liquify);
		a2.addAttack(perilous_Wings);

		Boss Viktor = new Boss(150, 14, 14, 30, 20, "Viktor, Sword of Day");
		Spell ethereal_Strike = new Spell(0, 4, 1.6, "Ethereal Strike", 5);
		Spell purging_Fire = new Spell(0, 4, 1.6, "Purging Fire", 6);
		bossAttacks a3 = new bossAttacks(ethereal_Strike);
		a3.addAttack(purging_Fire);

		Boss Othvar = new Boss(200, 18, 12, 30, 20, "Othvar Sigmusson the Cruel");
		Spell double_Strike = new Spell(0.2, 4, 1, "Double Strike", 7);
		Spell outrage = new Spell(0.4, 4, 2.5, "Outrage", 8);
		bossAttacks a4 = new bossAttacks(double_Strike);
		a4.addAttack(outrage);

		Boss Petrallum = new Boss(170, 12, 22, 30, 20, "Petrallum the Goliath");
		Spell infuriate = new Spell(0, 4, 0, "Infuriate", 9);
		Spell reflect_Attack = new Spell(0, 6, 0, "Reflect Attack", 10);
		bossAttacks a5 = new bossAttacks(infuriate);
		a5.addAttack(reflect_Attack);

		Boss Ulula = new Boss(150, 17, 17, 30, 20, "Ulula the Banshee");
		Spell hijack = new Spell(0.2, 3, 1.5, "Hijack", 11);
		Spell aggravate = new Spell(0.1, 4, 2.5, "Aggravate", 12);
		bossAttacks a6 = new bossAttacks(hijack);
		a6.addAttack(aggravate);

		Boss AnubisX = new Boss(300, 15, 20, 10000, 20, "Anubis, the God-Emperor");

		if (selection == 1)
		{
			System.out.println("...");
			TimeUnit.SECONDS.sleep(1);
			System.out.println("As you reach the 10th floor of the tower, you stumble upon a towering jackal-headed figure standing at the door.");
			System.out.println("...");
			TimeUnit.SECONDS.sleep(1);
			System.out.println("'Traveler, this dungeon is dangerous. And since you haven't turned back yet, I will have to show you how dangerous!'");
			System.out.println("...");
			TimeUnit.SECONDS.sleep(1);
			initiateBossFight(p1, Anubis, a1, s1, 0);
		}
		else if (selection == 2)
		{
			System.out.println("...");
			TimeUnit.SECONDS.sleep(1);
			System.out.println("As you reach the 20th floor of the tower, you stumble upon a huge hairy bat hanging onto the ceiling.");
			System.out.println("...");
			TimeUnit.SECONDS.sleep(1);
			System.out.println("'Another snack? Either you stand still or I'll force you to lie down!'");
			initiateBossFight(p1, Raanix, a2, s1, 0);
		}
		else if (selection == 3)
		{
			System.out.println("...");
			TimeUnit.SECONDS.sleep(1);
			System.out.println("As you reach the 30th floor of the tower, you stumble upon an archangel with a burning sword.");
			System.out.println("...");
			TimeUnit.SECONDS.sleep(1);
			System.out.println("'My sword blazes with purity and can discern those with true pureness. If you really are a hero, then engage in combat with me!'");
			initiateBossFight(p1, Viktor, a3, s1, 0);

		}
		else if (selection == 4)
		{
			System.out.println("...");
			TimeUnit.SECONDS.sleep(1);
			System.out.println("As you reach the 40th floor of the tower, a huge viking veiled in darkness approaches you!");
			System.out.println("...");
			TimeUnit.SECONDS.sleep(1);
			System.out.println("'I was exiled to this place for my bloody frenzies that went against Nordic War Laws. You better hope you are stronger than an army.");
			System.out.println("...");
			TimeUnit.SECONDS.sleep(1);
			initiateBossFight(p1, Othvar, a4, s1, 1);
		}
		else if (selection == 5)
		{
			System.out.println("...");
			TimeUnit.SECONDS.sleep(1);
			System.out.println("As you reach the 50th floor of the tower, you stumble upon a sedentary golem with ebony skin.");
			System.out.println("...");
			TimeUnit.SECONDS.sleep(1);
			System.out.println("'Hmm? You know, I occupied this space for some peace and quiet. I haven't had visitors in a while, and unfortunetly for you I'm going to keep it that way.");
			System.out.println("...");
			TimeUnit.SECONDS.sleep(1);
			initiateBossFight(p1, Petrallum, a5, s1, 0);
		}
		else if (selection == 6)
		{
			System.out.println("...");
			TimeUnit.SECONDS.sleep(1);
			System.out.println("As you reach the 60th floor of the tower, you stumble upon a banshee who seems inbetween your reality and imagination.");
			System.out.println("...");
			TimeUnit.SECONDS.sleep(1);
			System.out.println("'Hero, how well do you really know yourself? How unbreakable is your will? I want to find out...'");
			System.out.println("...!");
			TimeUnit.SECONDS.sleep(1);
			System.out.println("The banshee transformed into a mirror image of you, and then attacked!");
			System.out.println("...");
			TimeUnit.SECONDS.sleep(1);
			initiateBossFight(p1, Ulula, a6, s1, 2);
		}

		else if (selection == 7)
		{
			System.out.println("...");
			TimeUnit.SECONDS.sleep(1);
			System.out.println("You climb up the stairs and in awe, you notice that you are at the top of the tower. The wind shrieks by your ears.");
			System.out.println("...");
			TimeUnit.SECONDS.sleep(1);
			System.out.println("But your awe turns to fear as you see the same jackal-headed figure you saw at the 10th floor, in an aggressive stance and profound features.");
			System.out.println("...");
			TimeUnit.SECONDS.sleep(1);
			System.out.println("He looks...");
			System.out.println("...");
			TimeUnit.SECONDS.sleep(1);
			System.out.println("Like he is both a god and an emperor.");
			System.out.println("...");
			TimeUnit.SECONDS.sleep(3);
			System.out.println("'So I see you have survived through this tower's trials. You have fought and killed monster upon monster. You have come to the top for the treasure.'");
			System.out.println("...");
			TimeUnit.SECONDS.sleep(2);
			System.out.println("'I am afraid, however, that absconding with the Tower of Quest's treasure is not an option for you and anyone else.'");
			System.out.println("...");
			TimeUnit.SECONDS.sleep(2);
			System.out.println("'This treasure was made as a tribute for Ra himself, so that he may retain his power as he rules above. He has given me godlike powers, including control of who lives or dies, to protect it.'");
			System.out.println("...");
			TimeUnit.SECONDS.sleep(2);
			System.out.println("'You will not strip him of his powers. I do not enjoy killing, as I warned you to leave on the 10th floor. You didn't turn back. Now, you must pay in blood.'");
			System.out.println("...");
			TimeUnit.SECONDS.sleep(2);
			System.out.println("'You had your chance.'");
			System.out.println("...");
			TimeUnit.SECONDS.sleep(1);
			initiateBossFight(p1, AnubisX, a1, s1, 3);
		}

		return p1;
	}


	public static Player initiateBossFight(Player p1, Boss b1, bossAttacks a1, scrollInventory s1, int h) throws InterruptedException
	{

		System.out.println("You face " + b1.getName() + "!");
		System.out.println("...");
		TimeUnit.SECONDS.sleep(1);

		boolean stillFighting = true;
		boolean guardUp = false; // used to check if player guarded this turn
		boolean isStunned = false; //used to check if enemy is stunned by an attack
		int channelCount = 0; //amount of invigorate turns left
		Scanner input = new Scanner(System.in);

		boolean playerWins = false;
		boolean enemyWins = false;
		
		p1.setDisplayAttack(p1.getAttack());
		p1.setDisplayDefense(p1.getDefense());

		b1.setDisplayAttack(b1.getAttack());
		b1.setDisplayDefense(b1.getDefense());

		while (stillFighting)
		{
			int forReflection = 0;

			// Player turn

			if (channelCount > 0)
			{
				System.out.println("...");
				TimeUnit.SECONDS.sleep(1);
				System.out.println("You feel your blood boil in a lukewarm way, causing you to relax. You regain 3 HP and 10 Energy!");
				p1.hpUp(3);
				p1.energyUp(10);
				channelCount--;
			} 

			System.out.println("You have " + p1.getHealth() + " HP and " + p1.getEnergy() + " energy remaining.");
			System.out.println("The enemy is at " + b1.getHealth() + " health.");
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
				Scroll chosenMove = s1.chooseScroll(userChoice);
				if (p1.getEnergy() >= chosenMove.getEnergyCost())
				{

					if (chosenMove.getType() == false)
					{
						if (chosenMove.getID() == 1)
						{
							p1.subtractEnergy(chosenMove.getEnergyCost());
							System.out.println("You channel your energy into your chi, letting it flow through you for the next 3 turns.");
							channelCount = 3;
						}
						else if (chosenMove.getID() == 2)
						{
							p1.subtractEnergy(chosenMove.getEnergyCost());
							System.out.println("You feel a dark aura encompassing you. Your Attack increases by 100%.");
							int roundAttack = (int) (p1.getDisplayAttack() * 2);
							p1.setDisplayAttack(roundAttack);

							System.out.println("Your attack is now " + p1.getDisplayAttack() + ".");
						}
						else if (chosenMove.getID() == 3)
						{
							p1.subtractEnergy(chosenMove.getEnergyCost());
							System.out.println("You feel your chest harden to the quality of stone. Your Defense increases by 20% and you reduce damage taken this turn by 50%.");
							int roundDefense = (int) (p1.getDisplayDefense() * 1.2);
							p1.setDisplayDefense(roundDefense);
							System.out.println("Your defense is now " + p1.getDisplayDefense() + ".");
							guardUp = true;
						}
						else if (chosenMove.getID() == 4)
						{
							double scrollFormula = (p1.getPlayerDamage(s1.chooseScroll(userChoice)) * p1.getDisplayAttack() / 2);
							if (scrollFormula == 0)
							{
								System.out.println("Your attack missed!");
							}
							else
							{
								double decimalPlayerDamage = scrollFormula - b1.getDisplayDefense();
								int roundedPlayerDamage = (int) decimalPlayerDamage;
								roundedPlayerDamage += getRandomInt(1, 4);
								forReflection = roundedPlayerDamage;
								if (roundedPlayerDamage > 0)
								{
									b1.hpDown(roundedPlayerDamage);
									System.out.println("The enemy took "  + roundedPlayerDamage + " damage from your attack and is now at " + b1.getHealth() + " health.");
									if (b1.getHealth() <= 0)
									{
										stillFighting = false;
										playerWins = true;
									}
								}
								else
								{
									
										System.out.println("Your attack only scratched the foe's strong defense and dealt 1 damage.");
										b1.hpDown(1);
									
								}
								if (getRandomInt(1, 4) > 2)
								{
									System.out.println("The concussive power of Skullcrack caused your opponent to lose 20% Attack and Defense!");
									int roundEnemyAttack1 = (int) (p1.getDisplayAttack() * 0.8);
									b1.setDisplayAttack(roundEnemyAttack1);
									int roundEnemyDefense1 = (int) (p1.getDisplayDefense() * 0.8);
									b1.setDisplayDefense(roundEnemyDefense1);
								}
							}
							
						}
						else if (chosenMove.getID() == 5)
						{
							double scrollFormula = (p1.getPlayerDamage(s1.chooseScroll(userChoice)) * p1.getDisplayAttack() / 2);
							if (scrollFormula == 0)
							{
								System.out.println("Your attack missed!");
							}
							else
							{
								double decimalPlayerDamage = scrollFormula - b1.getDisplayDefense();
								int roundedPlayerDamage = (int) decimalPlayerDamage;
								roundedPlayerDamage += getRandomInt(1, 4);
								forReflection = roundedPlayerDamage;
								if (roundedPlayerDamage > 0)
								{
									b1.hpDown(roundedPlayerDamage);
									System.out.println("The enemy took "  + roundedPlayerDamage + " damage from your attack and is now at " + b1.getHealth() + " health.");
									if (b1.getHealth() <= 0)
									{
										stillFighting = false;
										playerWins = true;
									}
								}
								else
								{
									
										System.out.println("Your attack only scratched the foe's strong defense and dealt 1 damage.");
										b1.hpDown(1);
									
								}
								if (getRandomInt(1, 5) > 4)
								{
									System.out.println("Your attack is so sharp and surprising that it stuns the foe!");
									isStunned = true;
									
								}

							}
						}
						else if (chosenMove.getID() == 6)
						{
							double scrollFormula = (p1.getPlayerDamage(s1.chooseScroll(userChoice)) * p1.getDisplayAttack() / 2);
							if (scrollFormula == 0)
							{
								System.out.println("Your attack missed!");
							}
							else
							{
								double decimalPlayerDamage = scrollFormula - b1.getDisplayDefense();
								int roundedPlayerDamage = (int) decimalPlayerDamage;
								roundedPlayerDamage += getRandomInt(1, 3);
								if (roundedPlayerDamage > 0)
								{
									b1.hpDown(roundedPlayerDamage);
									System.out.println("The enemy took "  + roundedPlayerDamage + " damage from your attack and is now at " + b1.getHealth() + " health.");
									
									if (b1.getHealth() <= 0)
									{
										stillFighting = false;
										playerWins = true;
									}
								}
								else
								{
									
										System.out.println("Your attack only scratched the foe's strong defense and dealt 1 damage.");
										b1.hpDown(1);
									
								}

								System.out.println("The attack was so devastating that the foe is stunned from its' force!");
								isStunned = true;

							}
						}
						else if (chosenMove.getID() == 7)
						{
							p1.subtractEnergy(chosenMove.getEnergyCost());
							if (Math.random() < 0.1)
							{
								System.out.println("Your attack missed!");
							}
							else
							{
								b1.hpDown(10);
								System.out.println("The enemy took 10 damage from your attack and is now at " + b1.getHealth() + " health.");
								if (b1.getHealth() <= 0)
								{
									stillFighting = false;
									playerWins = true;
								}
							}
						}
						else if (chosenMove.getID() == 8)
						{
							double scrollFormula = (p1.getPlayerDamage(s1.chooseScroll(userChoice)) * p1.getDisplayAttack() / 2);
							if (scrollFormula == 0)
							{
								System.out.println("Your attack missed!");
							}
							else
							{
								double decimalPlayerDamage = scrollFormula - b1.getDisplayDefense();
								int roundedPlayerDamage = (int) decimalPlayerDamage;
								roundedPlayerDamage += getRandomInt(1, 3);
								if (roundedPlayerDamage > 0)
								{
									b1.hpDown(roundedPlayerDamage);
									System.out.println("The enemy took "  + roundedPlayerDamage + " damage from your attack and is now at " + b1.getHealth() + " health.");
									if (b1.getHealth() <= 0)
									{
										stillFighting = false;
										playerWins = true;
									}
									guardUp = true;
									System.out.println("You also quickly hold your weapon up, blocking 50% of the next damage you take.");
								}
								else
								{
									
										System.out.println("Your attack only scratched the foe's strong defense and dealt 1 damage.");
										b1.hpDown(1);
									
								}
							}
						}
						else if (chosenMove.getID() == 9)
						{
							double scrollFormula = (p1.getPlayerDamage(s1.chooseScroll(userChoice)) * p1.getDisplayAttack() / 2);
							if (scrollFormula == 0)
							{
								System.out.println("Your attack missed!");
							}
							else
							{
								double decimalPlayerDamage = scrollFormula;
								int roundedPlayerDamage = (int) decimalPlayerDamage;
								roundedPlayerDamage += getRandomInt(1, 3);
								if (roundedPlayerDamage > 0)
								{
									b1.hpDown(roundedPlayerDamage);
									System.out.println("You attack the floor with a mighty swing, sending a shockwave towards the opponent that ignores their armor.");
									System.out.println("The enemy took "  + roundedPlayerDamage + " damage from your attack and is now at " + b1.getHealth() + " health.");
									if (b1.getHealth() <= 0)
									{
										stillFighting = false;
										playerWins = true;
									}
								}
							}
						}
						else if (chosenMove.getID() == 10)
						{
							double scrollFormula = (p1.getPlayerDamage(s1.chooseScroll(userChoice)) * p1.getDisplayAttack() / 2);
							if (scrollFormula == 0)
							{
								System.out.println("Your attack missed!");
							}
							else
							{
								double decimalPlayerDamage = scrollFormula - b1.getDisplayDefense();
								int roundedPlayerDamage = (int) decimalPlayerDamage;
								roundedPlayerDamage += getRandomInt(1, 3);
								if (roundedPlayerDamage > 0)
								{
									b1.hpDown(roundedPlayerDamage);
									System.out.println("The enemy took "  + roundedPlayerDamage + " damage from your attack and is now at " + b1.getHealth() + " health.");
									if (b1.getHealth() <= 0)
									{
										stillFighting = false;
										playerWins = true;
									}
									System.out.println("The power of the light cleanses your opponent, removing all of their stat changes!");
									b1.setDisplayAttack(b1.getAttack());
									b1.setDisplayDefense(b1.getDefense());
									System.out.println("The enemy now has " + b1.getDisplayAttack() + " attack and " + b1.getDisplayDefense() + " defense!");
								}
							}
						}
					}
					else
					{
						double scrollFormula = (p1.getPlayerDamage(s1.chooseScroll(userChoice)) * p1.getDisplayAttack() / 2);
						if (scrollFormula == 0)
						{
							System.out.println("Your attack missed!");
						}
						else
						{
							double decimalPlayerDamage = scrollFormula - b1.getDisplayDefense();
							int roundedPlayerDamage = (int) decimalPlayerDamage;
							roundedPlayerDamage += getRandomInt(1, 4);
							forReflection = roundedPlayerDamage;
							if (roundedPlayerDamage > 0)
							{
								b1.hpDown(roundedPlayerDamage);
								System.out.println("The enemy took "  + roundedPlayerDamage + " damage from your attack and is now at " + b1.getHealth() + " health.");
								if (b1.getHealth() <= 0)
								{
									stillFighting = false;
									playerWins = true;
								}
							}
							else
							{
								
									System.out.println("Your attack only scratched the foe's strong defense and dealt 1 damage.");
									b1.hpDown(1);
								
							}
						}
					}
					
				}
				else
				{
					System.out.println("Not enough energy!");
				}
				
				
				
			}
			else if (userChoice == 2)
			{
				System.out.println("You guard this turn, restoring 10 energy and reducing damage taken by 50%.");
				p1.energyUp(10);
				guardUp = true;
			}
			else
			{
				if (p1.potCount() > 0)
				{
					System.out.println("HEALTH POTIONS: " + p1.potCount());
					System.out.println("Press 1 to use a Health Potion or 2 to Quit");
					userChoice = input.nextInt();
					if (userChoice == 1)
					{
						p1.usePot();
					}

				}
				else
				{
					System.out.println("Your bag is empty!");
				}

			}

			
			// Boss turn
			if (isStunned)
			{
				System.out.println("...");
				TimeUnit.SECONDS.sleep(1);
				System.out.println("The enemy is stunned and can't act this turn!");
				isStunned = false;
			}
			else if (playerWins)
			{
				System.out.println("...");
				TimeUnit.SECONDS.sleep(1);
				System.out.println("The enemy is all out of HP!");
			}
			else
			{
				System.out.println("It is the enemy's turn.");
				System.out.println("...");
				TimeUnit.SECONDS.sleep(1);

				if (b1.getMana() > 0)
				{
					int rando = getRandomInt(1, 4);
					if (rando > 2)
					{
						double decimalBossDamage = b1.getDisplayAttack() + getRandomInt(1, 3);
						decimalBossDamage -= (p1.getDisplayDefense() / 2);
						if (guardUp)
						{
							decimalBossDamage /= 4;
							decimalBossDamage *= 2;
							guardUp = false;
						}
						int roundedBossDamage = (int) decimalBossDamage;
						if (roundedBossDamage > 0)
						{
							System.out.println(b1.getName() + " attacks you for " + roundedBossDamage + " damage.");
							p1.hpDown(roundedBossDamage);
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
					else
					{
						Spell randomAttack = a1.chooseAttack(getRandomInt(0, a1.getSize() - 1));
						b1.subtractMana(randomAttack.getManaCost());
						if (randomAttack.getID() == 1)
						{
							System.out.println(b1.getName() + " exerted a powerful aura, increasing its' Attack and Defense by 40%! ");
							int roundBossDefense = (int) (b1.getDisplayDefense() * 1.4);
							b1.setDisplayDefense(roundBossDefense);
							int roundBossAttack = (int) (b1.getDisplayAttack() * 1.4);
							b1.setDisplayAttack(roundBossAttack);
							System.out.println(b1.getName() + " is now at " + b1.getDisplayAttack() + " attack and " + b1.getDisplayDefense() + " defense.");

						}
						else if (randomAttack.getID() == 2)
						{
							double decimalBossDamage = b1.getDisplayAttack() + getRandomInt(1, 3);
							int roundedBossDamage = (int) decimalBossDamage;
							System.out.println(b1.getName() + " attacks you through ripping a shard of your soul out, striking through your defense and dealing " + roundedBossDamage + " damage!");
							p1.hpDown(roundedBossDamage);
							System.out.println("You are now at " + p1.getHealth() + " health.");
							int bossHeal = roundedBossDamage / 2;
							System.out.println(b1.getName() + " also absorbs 50% of the damage it did and restores " + bossHeal + " health.");
							b1.hpUp(bossHeal);
							System.out.println(b1.getName() + " is now at " + b1.getHealth() + " health.");
						}
						else if (randomAttack.getID() == 3)
						{
							double decimalBossDamage = b1.getDisplayAttack() * randomAttack.getPower() + getRandomInt(1, 3);
							decimalBossDamage -= (p1.getDisplayDefense() / 2);
							if (guardUp)
							{
								decimalBossDamage /= 4;
								decimalBossDamage *= 2;
								guardUp = false;
							}
							int roundedBossDamage = (int) decimalBossDamage;
							if (roundedBossDamage > 0)
							{
								System.out.println(b1.getName() + " attacks you for " + roundedBossDamage + " damage through spraying corrosive acid on you!");
								System.out.println("The acid also seeps through your armor,  lowering your defense by 20%!");
								p1.hpDown(roundedBossDamage);
								int roundPlayerDefense = (int) (p1.getDisplayDefense() * 0.8 - 1);
								p1.setDisplayDefense(roundPlayerDefense);
								System.out.println("You are now at " + p1.getHealth() + " health and " + p1.getDefense() + " defense");
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
						else if (randomAttack.getID() == 4)
						{
							if (Math.random() > 0.4)
							{
								double decimalBossDamage = b1.getDisplayAttack() * randomAttack.getPower() + getRandomInt(1, 3);
								decimalBossDamage -= (p1.getDisplayDefense() / 2);
								if (guardUp)
								{
									decimalBossDamage /= 4;
									decimalBossDamage *= 2;
									guardUp = false;
								}
								int roundedBossDamage = (int) decimalBossDamage;
								if (roundedBossDamage > 0)
								{
									System.out.println(b1.getName() + " attacks you for " + roundedBossDamage + " damage through striking you with its' huge wings.");
									p1.hpDown(roundedBossDamage);
									System.out.println("You are now at " + p1.getHealth() + " health.");
								}
								else
								{
									System.out.println("Your defense was too strong for the enemy's attack! It only did 1 damage!");
									p1.hpDown(1);
									System.out.println("You are now at " + p1.getHealth() + " health.");
								}
							}
							else
							{
								System.out.println(b1.getName() + " attempted to strike you with its' huge wings, but missed!");
							}
							
							

						}
						else if (randomAttack.getID() == 5)
						{
							double decimalBossDamage = b1.getDisplayAttack() * randomAttack.getPower() + getRandomInt(1, 3);
							if (guardUp)
							{
								decimalBossDamage /= 4;
								decimalBossDamage *= 2;
								guardUp = false;
							}
							int roundedBossDamage = (int) decimalBossDamage;
							if (roundedBossDamage > 0)
							{
								System.out.println(b1.getName() + " strikes right through you by making its' sword ethereal, ignoring your defense and dealing " + roundedBossDamage + " damage.");
								p1.hpDown(roundedBossDamage);
								System.out.println("You are now at " + p1.getHealth() + " health.");
							}
							else
							{
								System.out.println("Your defense was too strong for the enemy's attack! It only did 1 damage!");
								p1.hpDown(1);
								System.out.println("You are now at " + p1.getHealth() + " health.");
							}
						}
						else if (randomAttack.getID() == 6)
						{
							double decimalBossDamage = b1.getDisplayAttack() * randomAttack.getPower() + getRandomInt(1, 3);
							if (guardUp)
							{
								decimalBossDamage /= 4;
								decimalBossDamage *= 2;
								guardUp = false;
							}
							int roundedBossDamage = (int) decimalBossDamage;
							if (roundedBossDamage > 0)
							{
								System.out.println(b1.getName() + " strikes you with a purging flame that removes all of your stat changes and deals " + roundedBossDamage + " damage.");
								p1.hpDown(roundedBossDamage);
								p1.setDisplayDefense(p1.getDefense());
								p1.setDisplayAttack(p1.getAttack());
								System.out.println("You are now at " + p1.getHealth() + " health. You have " + p1.getDisplayAttack() + " attack and " + p1.getDisplayDefense() + " defense");
							}
							else
							{
								System.out.println("Your defense was too strong for the enemy's attack! It only did 1 damage!");
								p1.hpDown(1);
								System.out.println("You are now at " + p1.getHealth() + " health.");
							}
						}
						else if (randomAttack.getID() == 7)
						{
							double decimalBossDamage = b1.getDisplayAttack() + getRandomInt(1, 3);
							decimalBossDamage -= (p1.getDisplayDefense() / 2);
							if (guardUp)
							{
								decimalBossDamage /= 4;
								decimalBossDamage *= 2;
								guardUp = false;
							}
							int roundedBossDamage = (int) decimalBossDamage;
							if (roundedBossDamage > 0)
							{
								System.out.println(b1.getName() + " attacks you for " + roundedBossDamage + " damage.");
								p1.hpDown(roundedBossDamage);
								System.out.println("You are now at " + p1.getHealth() + " health.");
							}
							else
							{
								System.out.println("Your defense was too strong for the enemy's first attack! It only did 1 damage!");
								p1.hpDown(1);
								System.out.println("You are now at " + p1.getHealth() + " health.");
							}
							double decimalBossDamage2 = b1.getDisplayAttack() + getRandomInt(1, 3);
							decimalBossDamage2 -= (p1.getDisplayDefense() / 2);
							if (guardUp)
							{
								decimalBossDamage /= 4;
								decimalBossDamage *= 2;
								guardUp = false;
							}
							int roundedBossDamage2 = (int) decimalBossDamage2;
							if (roundedBossDamage2 > 0)
							{
								System.out.println(b1.getName() + " attacks you again for " + roundedBossDamage2 + " damage.");
								p1.hpDown(roundedBossDamage2);
								System.out.println("You are now at " + p1.getHealth() + " health.");
							}
							else
							{
								System.out.println("Your defense was too strong for the enemy's second attack! It only did 1 damage!");
								p1.hpDown(1);
								System.out.println("You are now at " + p1.getHealth() + " health.");
							}
						}
						else if (randomAttack.getID() == 8)
						{
							if (Math.random() > 0.3)
							{
								double decimalBossDamage = b1.getDisplayAttack() * randomAttack.getPower() + getRandomInt(1, 3);
								decimalBossDamage -= (p1.getDisplayDefense() / 2);
								if (guardUp)
								{
									decimalBossDamage /= 4;
									decimalBossDamage *= 2;
									guardUp = false;
								}
								int roundedBossDamage = (int) decimalBossDamage;
								if (roundedBossDamage > 0)
								{
									System.out.println(b1.getName() + " attacks you for " + roundedBossDamage + " damage through swinging at you wildly.");
									p1.hpDown(roundedBossDamage);
									System.out.println("You are now at " + p1.getHealth() + " health.");
								}
								else
								{
									System.out.println("Your defense was too strong for the enemy's first attack! It only did 1 damage!");
									p1.hpDown(1);
									System.out.println("You are now at " + p1.getHealth() + " health.");
								}
							}
							else
							{
								System.out.println("Othvar attempted to wildly attack you, but missed!");
							}
							
						}
						else if (randomAttack.getID() == 9)
						{
							System.out.println("Petrallum crystallizes its' arms, gaining 40% Attack but lowering its' defense by 15%.");
							int roundBossAttack3 = (int) (b1.getDisplayAttack() * 1.4);
							b1.setDisplayAttack(roundBossAttack3);
							int roundBossDefense3 = (int) (b1.getDisplayDefense() * 0.85);
							b1.setDisplayDefense(roundBossDefense3);
							System.out.println("Petrallum now has " + b1.getDisplayAttack() + " attack and " + b1.getDisplayDefense() + " defense.");
						}
						else if (randomAttack.getID() == 10)
						{
							int roundedBossDamage = forReflection / 2;
							System.out.println("Petrallum unleashes a demonic power from within, using 50% of the damage it took this turn and transforming it into an attack that deals " + roundedBossDamage + " damage!");
							p1.hpDown(roundedBossDamage);
							System.out.println("You are now at " + p1.getHealth() + " health.");
						}
						else if (randomAttack.getID() == 11)
						{
							if (Math.random() > 0.2)
							{
								double decimalBossDamage = p1.getDisplayAttack() * randomAttack.getPower() + getRandomInt(1, 3);
								decimalBossDamage -= (p1.getDisplayDefense() / 2);
								if (guardUp)
								{
									decimalBossDamage /= 4;
									decimalBossDamage *= 2;
									guardUp = false;
								}
								int roundedBossDamage = (int) decimalBossDamage;
								if (roundedBossDamage > 0)
								{
									System.out.println(b1.getName() + " uses your own attack stat to strike you for " + roundedBossDamage + " damage!");
									p1.hpDown(roundedBossDamage);
									System.out.println("You are now at " + p1.getHealth() + " health.");
								}
								else
								{
									System.out.println("Your defense was too strong for the enemy's attack! It only did 1 damage!");
									p1.hpDown(1);
									System.out.println("You are now at " + p1.getHealth() + " health.");
								}
							}
							else
							{
								System.out.println(b1.getName() + " attempted to strike you with a chilly fist, but missed!");
							}
						}
						else if (randomAttack.getID() == 12)
						{
							if (Math.random() > 0.1)
							{
								double decimalBossDamage = b1.getDisplayAttack() * randomAttack.getPower() + getRandomInt(1, 3);
								decimalBossDamage -= (p1.getDisplayDefense() / 2);
								if (guardUp)
								{
									decimalBossDamage /= 4;
									decimalBossDamage *= 2;
									guardUp = false;
								}
								int roundedBossDamage = (int) decimalBossDamage;
								if (roundedBossDamage > 0)
								{
									System.out.println(b1.getName() + " strikes you for " + roundedBossDamage + " damage with a frozen blast!");
									System.out.println("The great chill forces your veins to warm up, increasing your attack stat by 20%!");
									p1.hpDown(roundedBossDamage);
									int roundAttack2 = (int) (p1.getDisplayAttack() * 1.2);
									p1.setDisplayAttack(roundAttack2);
									System.out.println("You are now at " + p1.getHealth() + " health and " + p1.getDisplayAttack() + " attack!");
									
								}
								else
								{
									System.out.println("Your defense was too strong for the enemy's attack! It only did 1 damage!");
									p1.hpDown(1);
									System.out.println("You are now at " + p1.getHealth() + " health.");
								}
							}
							else
							{
								System.out.println(b1.getName() + " attempted to strike you with a frozen blast, but missed!");
							}
						}
					}

				}
				else
				{
					double decimalBossDamage = b1.getDisplayAttack() + getRandomInt(1, 3);
					decimalBossDamage -= (p1.getDisplayDefense() / 2);
					if (guardUp)
					{
						decimalBossDamage /= 4;
						decimalBossDamage *= 2;
						guardUp = false;
					}
					int roundedBossDamage = (int) decimalBossDamage;
					if (roundedBossDamage > 0)
					{
						System.out.println(b1.getName() + " attacks you for " + roundedBossDamage + " damage.");
						p1.hpDown(roundedBossDamage);
						System.out.println("You are now at " + p1.getHealth() + " health.");
					}
					else
					{
						System.out.println("Your defense was too strong for the enemy's attack! It only did 1 damage!");
						p1.hpDown(1);
						System.out.println("You are now at " + p1.getHealth() + " health.");
					}
					
				}

					if (p1.getHealth() <= 0)
					{
						stillFighting = false;
						enemyWins = true;
					}

			}

			if (h == 1)
			{
				System.out.println("...");
				TimeUnit.SECONDS.sleep(1);
				System.out.println("Othvar's Rising Fury increased his attack by 15%!");
				int roundBossAttack4 = (int) (b1.getDisplayAttack() * 1.15);
				b1.setDisplayAttack(roundBossAttack4);
				System.out.println(b1.getName() + " is now at " + b1.getDisplayAttack() + " attack.");
			}
			else if (h == 2)
			{
				System.out.println("...");
				TimeUnit.SECONDS.sleep(1);
				System.out.println("The very sight of Ulula chills you to the bone, and her frosty aura does 3 damage to you!");
				p1.hpDown(3);
				System.out.println("You are now at " + p1.getHealth() + " health.");
			}
			else if (h == 3)
			{
				if (b1.getHealth() < 150)
				{
					System.out.println("...");
					TimeUnit.SECONDS.sleep(1);
					System.out.println("Sensing that he has suffered mortal wounds, Anubis unleashes his power, fully restoring his HP but losing his godlike aura.");
					b1.hpUp(300);
					h = 0;
				}
				System.out.println("...");
				TimeUnit.SECONDS.sleep(1);
				System.out.println("I. Am. Infinite.");
				System.out.println("...");
				TimeUnit.SECONDS.sleep(1);
				System.out.println("Anubis regained 5 HP!");
				b1.hpUp(5);

			}

				if (playerWins)
				{
					p1.addGold(b1.getValue());
					p1.energyUp(20);
					System.out.println("You win! You gain " + b1.getValue() + " gold and are now at " + p1.getGold() + " gold!");
					System.out.println("...");
					TimeUnit.SECONDS.sleep(1);
					System.out.println("You take a day off from your adventure, restoring yourself to full health and energy.");
					p1.hpUp(100);
					p1.energyUp(100);

					stillFighting = false;
				}
				else if (enemyWins)
				{
					loseGame(p1);
					return p1;
				}

		}

		return p1;

	}

	/****************************************************************
	Method to Call for Shop after Boss Fight
	****************************************************************/

	public static Player floorShop(Player p1, scrollInventory s1, scrollInventory s2) throws InterruptedException
	{
		boolean stillShopping = true;
		boolean checkedScroll = false;
		Scanner input = new Scanner(System.in);
		
		System.out.println("...");
		TimeUnit.SECONDS.sleep(1);
		System.out.println("You encounter a shopkeeper carrying a cart of goods.");
		System.out.println("'So you made it out alive, eh? Take a look at some of my merchandise so you can stay in one piece.'");
		System.out.println("...");
		TimeUnit.SECONDS.sleep(1);
		while (stillShopping)
		{
			System.out.println("Press 1 to view Health Potion, 2 to view Attack Upgrade, 3 to view Defense Upgrade, 4 to view a new Physical Attack Scroll, or 5 to Quit.");
			int userChoice = input.nextInt();
			if (userChoice == 1)
			{
				System.out.println("HEALTH POTION: RESTORES 30 HP. TASTES LIKE CHERRY. 20 GOLD PER CASK.");
				System.out.println("Press 1 to buy Health Potion or 2 to Go back to menu.");
				userChoice = input.nextInt();
				if (userChoice == 1)
				{
					if (p1.getGold() >= 20)
					{
						System.out.println("You bought a Health Potion!");
						p1.addPot();
						p1.subtractGold(20);
						System.out.println("You are now at " + p1.getGold() + " gold.");
					}
					else
					{
						System.out.println("Insufficient funds.");
					}
				}
			}
			else if (userChoice == 2)
			{
				System.out.println("ATTACK UPGRADE: INCREASES MAX ATTACK BY 2. SHARPEN THAT SWORD! 10 GOLD PER SHINE.");
				System.out.println("Press 1 to buy Attack Upgrade or 2 to Go back to menu.");
				userChoice = input.nextInt();
				if (userChoice == 1)
				{
					if (p1.getGold() >= 10)
					{
						System.out.println("You bought an Attack Upgrade!");
						p1.atkUp(2);
						p1.subtractGold(10);
						System.out.println("You are now at " + p1.getGold() + " gold.");
					}
					else
					{
						System.out.println("Insufficient funds.");
					}
				}
			}
			else if (userChoice == 3)
			{
				System.out.println("DEFENSE UPGRADE: INCREASES MAX DEFENSE BY 2. MAKE 'EM HATE YOU! 10 GOLD PER FORTIFICATION.");
				System.out.println("Press 1 to buy Defense Upgrade or 2 to Go back to menu.");
				userChoice = input.nextInt();
				if (userChoice == 1)
				{
					if (p1.getGold() >= 10)
					{
						System.out.println("You bought a Defense Upgrade!");
						p1.defUp(2);
						p1.subtractGold(10);
						System.out.println("You are now at " + p1.getGold() + " gold.");
					}
					else
					{
						System.out.println("Insufficient funds.");
					}
				}
			}
			else if (userChoice == 4)
			{
				if (checkedScroll)
				{
					System.out.println("'You already saw it, bud!'");
				}
				else
				{
					s1 = scrollFloorShop(p1, s1, s2);
					checkedScroll = true;
				}
			}
			else
			{

				stillShopping = false;
			} 
		}

		System.out.println("...");
		TimeUnit.SECONDS.sleep(1);
		System.out.println("After you do business, the shopkeeper offers you to drink with him. \nThe rum refreshes you, and you restore 25 HP and 50 energy!");
		p1.hpUp(25);
		p1.energyUp(50);
		return p1;
		



	}

	public static scrollInventory scrollFloorShop(Player p1, scrollInventory s1, scrollInventory s2) throws InterruptedException
	{
		Scanner input = new Scanner(System.in);

		for (int i = 1; i < s1.getSize(); i++)
		{
			for (int j = 1; j < s2.getSize(); j++)
			{
				Scroll x = s1.chooseScroll(i);
				Scroll y = s2.chooseScroll(j);
				if (x.getName().equals(y.getName()))
				{
					s2.removeScroll(y);
				}
			}
			
		}

		Scroll randomScroll = s2.chooseScroll(getRandomInt(0, s2.getSize() - 1));
		System.out.println("...");
		TimeUnit.SECONDS.sleep(1);
		System.out.println("'I'm selling " + randomScroll.getName() + " for 40 gold. Take it er' leave it.'");
		randomScroll.getDesc();
		System.out.println("Press 1 to purchase " + randomScroll.getName() + " or 2 to Quit.");

		int userChoice = input.nextInt();
		if (userChoice == 1)
		{
			if (p1.getGold() >= 40)
			{
				System.out.println("You bought " + randomScroll.getName() + "!");
				s1.addScroll(randomScroll);
				p1.subtractGold(40);
				System.out.println("You are now at " + p1.getGold() + " gold.");
			}
			else
			{
				System.out.println("Insufficient funds.");
			}
		}

		return s1;
	}

	public static scrollInventory scrollVendor(Player p1, scrollInventory s1, scrollInventory s2) throws InterruptedException
	{
		Scanner input = new Scanner(System.in);

		for (int i = 1; i < s1.getSize(); i++)
		{
			for (int j = 1; j < s2.getSize(); j++)
			{
				Scroll x = s1.chooseScroll(i);
				Scroll y = s2.chooseScroll(j);
				if (x.getName().equals(y.getName()))
				{
					s2.removeScroll(y);
				}
			}
			
		}

		Scroll randomScroll = s2.chooseScroll(getRandomInt(0, s2.getSize() - 1));
		System.out.println("...");
		TimeUnit.SECONDS.sleep(1);
		System.out.println("'Hmm, an adventurer? You may find this technique quite helpful for whatever your purpose may be.'");
		System.out.println("...");
		TimeUnit.SECONDS.sleep(1);
		randomScroll.getDesc();
		System.out.println("Press 1 to purchase " + randomScroll.getName() + " or 2 to Reject the Vendor's offer.");

		int userChoice = input.nextInt();
		if (userChoice == 1)
		{
			if (p1.getGold() >= 20)
			{
				System.out.println("You bought " + randomScroll.getName() + "!");
				s1.addScroll(randomScroll);
				p1.subtractGold(20);
				System.out.println("You are now at " + p1.getGold() + " gold.");
			}
			else
			{
				System.out.println("Insufficient funds.");
			}
		}
		else
		{
			System.out.println("...");
			TimeUnit.SECONDS.sleep(1);
			System.out.println("'A pity. Truely.'");
		}

		return s1;
	}


	

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
		gamblerNumber = visibleGamblerNumber += getRandomInt(1, 13);
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
				int addition = getRandomInt(1, 13);
				visibleGamblerNumber += addition;
				gamblerNumber += addition;
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
				System.out.println("You are now at " + p1.getGold() + " gold.");
			}
			else
			{
				System.out.println("You lose!");
				p1.subtractGold(20);
				System.out.println("You are now at " + p1.getGold() + " gold.");
			}
		}
		else if (playerNumber == 21)
		{
			System.out.println("You win!");
			p1.addGold(20);
			System.out.println("You are now at " + p1.getGold() + " gold.");
		}
		else if (gamblerNumber > 21)
		{
			System.out.println("You win!");
			p1.addGold(20);
			System.out.println("You are now at " + p1.getGold() + " gold.");
		}
		else
		{
			System.out.println("You lose!");
			p1.subtractGold(20);
			System.out.println("You are now at " + p1.getGold() + " gold.");
		}

		return p1;
		
	}

	public static int getRandomInt(int min, int max)
	{
    	int x = (int)(Math.random()*((max-min)+1))+min;
    	return x;
	}
}