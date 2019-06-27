import java.lang.Math;

public class Player
{
	private String name;
	private double maxHealth;
	private double health;
	private int attack;
	private double displayAttack;
	private int defense;
	private double displayDefense;
	private int maxEnergy;
	private int energy;
	private int gold;
	private int healthPots;
	private boolean isAlive;

	public Player()
	{
		maxHealth = 100;
		health = 100;
		attack = 10;
		defense = 4;
		maxEnergy = 100;
		energy = 100;
		gold = 0;
		healthPots = 0;
		isAlive = true;
	}

	public void setStatus(boolean a)
	{
		isAlive = a;
	}

	public boolean getStatus()
	{
		return isAlive;
	}

	public void setName(String s)
	{
		name = s;
	}

	public String getName()
	{
		return name;
	}

	public void atkUp(int amount)
	{
		attack += amount;
	}

	public int getAttack()
	{
		return attack;
	}

	public double getDisplayAttack()
	{
		return displayAttack;
	}

	public void setDisplayAttack(double amount)
	{
		displayAttack = amount;
	}

	public void setMaxHp(int amount)
	{
		maxHealth = amount;
	}

	public void hpUp(int amount)
	{
		health += amount;
		if (health > maxHealth)
		{
			health = maxHealth;
		} 
	}

	public void hpMaxUp(int amount)
	{
		health += amount;
		maxHealth += amount;
	}

	public void hpDown(int amount)
	{
		health -= amount;
	}

	public double getHealth()
	{
		return health;
	}

	public void defUp(int amount)
	{
		defense += amount;
	}

	public int getDefense()
	{
		return defense;
	}

	public double getDisplayDefense()
	{
		return displayDefense;
	}

	public void setDisplayDefense(double amount)
	{
		displayDefense = amount;
	}

	public int getEnergy()
	{
		return energy;
	}

	public void setEnergy(int amount)
	{
		maxEnergy = amount;
		energy = amount;
	}

	public void energyUp(int amount)
	{
		energy += amount;
		if (energy > maxEnergy)
		{
			energy = maxEnergy;
		}
	}

	public void subtractEnergy(int amount)
	{
		energy -= amount;
	}

	public void addGold(int amount)
	{
		gold += amount;
	}

	public void subtractGold(int amount)
	{
		gold -= amount;
	}

	public int getGold()
	{
		return gold;
	}

	public void addPot()
	{
		healthPots++;
	}

	public void usePot()
	{
		healthPots--;
		hpUp(30);
	}

	public int potCount()
	{
		return healthPots;
	}

	//below method takes player's attack choice and gets 
	//its' power if it works
	public int getPlayerDamage(Scroll x)
	{
		energy -= x.getEnergyCost();

		if (Math.random() > x.getAccuracy())
		{
			return x.getPower();
		}
		else
		{
			return 0;
		}
	}

}