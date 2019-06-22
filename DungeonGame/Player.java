import java.lang.Math;

public class Player
{
	private String name;
	private double maxHealth;
	private double health;
	private int attack;
	private int defense;
	private int maxEnergy;
	private int energy;
	private int gold;
	private boolean isAlive;

	public Player()
	{
		maxHealth = 100;
		health = 100;
		attack = 10;
		defense = 10;
		maxEnergy = 100;
		energy = 100;
		gold = 0;
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