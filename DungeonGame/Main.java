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

		Player p1 = new Player();

		Scroll basicAttack = new Scroll(0.2, 5, 2, "Sword Slash", 0, true);
		Scroll swordCharge = new Scroll(0.4, 20, 6, "Sword Charge", 0, true);
		Scroll preciseStrike = new Scroll(0, 10, 2, "Precise Strike", 0, true);
		Scroll wildSwing = new Scroll(0.5, 5, 4, "Wild Swing", 0, true);
		Scroll dragonStrike = new Scroll(0, 30, 8, "Dragon Strike", 0, true);
		Scroll invigorate = new Scroll(0, 40, 0, "Invigorate", 1, false);
		Scroll darkAura = new Scroll(0, 100, 0, "Dark Aura", 2, false);
		Scroll bulwark = new Scroll(0, 30, 0, "Bulwark", 3, false);
		Scroll skullCrack = new Scroll(0.4, 25, 5, "Skullcrack", 4, false);


		scrollInventory scrollsOwned = new scrollInventory(basicAttack);
		scrollsOwned.addScroll(swordCharge);

		scrollInventory purchasableScrolls = new scrollInventory(preciseStrike);
		purchasableScrolls.addScroll(wildSwing);
		purchasableScrolls.addScroll(dragonStrike);
		purchasableScrolls.addScroll(invigorate);
		purchasableScrolls.addScroll(bulwark);
		purchasableScrolls.addScroll(skullCrack);
		purchasableScrolls.addScroll(darkAura);


		Scanner input = new Scanner(System.in);

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
		System.out.println("'You let the noble die so you could fight in the front lines.\n But they didn't see that.'");
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
		TimeUnit.SECONDS.sleep(1);
		System.out.println("'Before we begin, what is the hero's name?");
		p1.setName(input.next());
		System.out.println("'Very well " + p1.getName() + ". It is time to ascend the Tower.'");
		System.out.println("...");
		TimeUnit.SECONDS.sleep(1);

		/****************************************************************
		Part 2: The Actual Game (calling methods for encounters/fights)
		****************************************************************/

		int decFloor = 1;

		for (int i = 1; i < 100; i++)
		{
			if (p1.getStatus() == true)
			{
				System.out.println(p1.getName() + " has " + p1.getGold() + " gold, " + p1.getHealth() + " health, " + p1.getEnergy() + " energy, " + p1.getAttack() + " attack, and " + p1.getDefense() + " defense.");
				System.out.println("Floor: " + i);
				System.out.println("...");
				TimeUnit.SECONDS.sleep(1);
				if (decFloor == 1)
				{
					p1 = setUpFight(getRandomInt(1, 9), p1, scrollsOwned);
				}
				else if (decFloor == 2)
				{
					p1 = getEvent(getRandomInt(1, 7), p1, scrollsOwned); // 2, 5 ,9
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
					p1 = getEvent(getRandomInt(1, 7), p1, scrollsOwned); // 2, 5 ,9
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
					p1 = getEvent(getRandomInt(1, 7), p1, scrollsOwned); // 2, 5 ,9
				}
				else if (decFloor == 10)
				{
					p1 = getEvent(getRandomInt(1, 7), p1, scrollsOwned); // 2, 5 ,9
					p1 = floorShop(p1, scrollsOwned, purchasableScrolls);
					decFloor = 1;

				}

				decFloor++;

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

	public static Player setUpFight(int selection, Player p1, scrollInventory s1) throws InterruptedException
	{
		Enemy Ogre = new Enemy(40, 6, 7, 7, "Ogre");
		Enemy Bat = new Enemy(20, 5, 3, 4, "Bat");
		Enemy Golem = new Enemy(70, 2, 8, 7, "Golem");
		Enemy Elemental = new Enemy(25, 12, 2, 6, "Elemental");
		Enemy Feral = new Enemy(50, 5, 5, 5, "Feral");
		Enemy Sorcerer = new Enemy(40, 9, 4, 8, "Sorcerer");
		Enemy Fallen = new Enemy(80, 10, 5, 15, "Fallen");
		Enemy EyeEye = new Enemy(30, 6, 6, 6, "EyeEye");
		Enemy Slime = new Enemy(25, 2, 4, 2, "Slime");

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
							System.out.println("You channel your energy into your chi, letting it flow through you and restoring 10 HP.");
							p1.hpUp(10);
							System.out.println("You are now at " + p1.getHealth() + " health.");
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
							System.out.println("You feel your chest harden to the quality of stone. Your Defense increases by 25% and you reduce damage taken this turn by 25%.");
							int roundDefense = (int) (p1.getDisplayDefense() * 1.25);
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
								roundedPlayerDamage += getRandomInt(1, 4);
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
							roundedPlayerDamage += getRandomInt(1, 4);
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
				System.out.println("You guard this turn, restoring 10 energy and reducing damage taken by 25%.");
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

			System.out.println("It is the enemy's turn.");
			System.out.println("...");
			TimeUnit.SECONDS.sleep(1);
			double decimalEnemyDamage = (e1.getDisplayAttack() / 2) + getRandomInt(0, 4);
			decimalEnemyDamage -= (p1.getDisplayDefense() / 2);
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
			p1.energyUp(20);
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
		//Boss Idea: Anubis (Floor 10)
		// - Attacks: Basic Attack, Rend Soul (deals damage that ignores DEF and heals for 50%), Emanate (gains Attack and Defense)
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
				System.out.println("ATTACK UPGRADE: INCREASES MAX ATTACK BY 3. SHARPEN THAT SWORD! 10 GOLD PER SHINE.");
				System.out.println("Press 1 to buy Attack Upgrade or 2 to Go back to menu.");
				userChoice = input.nextInt();
				if (userChoice == 1)
				{
					if (p1.getGold() >= 10)
					{
						System.out.println("You bought an Attack Upgrade!");
						p1.atkUp(3);
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
				System.out.println("DEFENSE UPGRADE: INCREASES MAX DEFENSE BY 3. MAKE 'EM HATE YOU! 10 GOLD PER FORTIFICATION.");
				System.out.println("Press 1 to buy Defense Upgrade or 2 to Go back to menu.");
				userChoice = input.nextInt();
				if (userChoice == 1)
				{
					if (p1.getGold() >= 10)
					{
						System.out.println("You bought a Defense Upgrade!");
						p1.defUp(3);
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
				System.out.println("...");
				TimeUnit.SECONDS.sleep(1);
				System.out.println("'Aight kid, break a leg!'");
				stillShopping = false;
			} 
		}

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
		System.out.println("'I'm selling " + randomScroll.getName() + " for 50 gold. Take it er' leave it.'");
		System.out.println("Press 1 to purchase " + randomScroll.getName() + " or 2 to Quit.");

		int userChoice = input.nextInt();
		if (userChoice == 1)
		{
			if (p1.getGold() >= 50)
			{
				System.out.println("You bought " + randomScroll.getName() + "!");
				s1.addScroll(randomScroll);
				p1.subtractGold(50);
				System.out.println("You are now at " + p1.getGold() + " gold.");
			}
			else
			{
				System.out.println("Insufficient funds.");
			}
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