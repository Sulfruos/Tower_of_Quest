import java.lang.Math;

public class Enemy
{
	private String name;
	private double maxHealth;
	private double health;
	private int attack;
	private int defense;
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

	public void atkUp(int amount)
	{
		attack += amount;
	}

	public void hpMaxUp(int amount)
	{
		health += amount;
		maxHealth += amount;
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

	public int getValue()
	{
		return value;
	}

	public void setValue(int amount)
	{
		value = amount;
	}

	public void defUp(int amount)
	{
		defense += amount;
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