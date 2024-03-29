import java.lang.Math;

public class Enemy
{
	private String name;
	private double maxHealth;
	private double health;
	private int attack;
	private double displayAttack;
	private int defense;
	private double displayDefense;
	private int value;

	public Enemy(int h, int a, int d, int v, String n)
	{
		maxHealth = h;
		health = h;
		attack = a;
		defense = d;
		value = v;
		name = n;
	}

	public void setName(String s)
	{
		name = s;
	}

	public String getName()
	{
		return name;
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

	public void hpUp(int amount)
	{
		health+= amount;
		if (health > maxHealth)
		{
			health = maxHealth;
		} 
	}

	public void hpDown(int amount)
	{
		health -= amount;
	}

	public double getHealth()
	{
		return health;
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

	public int getValue()
	{
		return value;
	}

	public int getEnemyDamage()
	{
		if (Math.random() > 0.1)
		{
			return attack;
		}
		else
		{
			return 0;
		}
	}

}