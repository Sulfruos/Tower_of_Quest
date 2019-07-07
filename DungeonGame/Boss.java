import java.lang.Math;

public class Boss
{
	private String name;
	private double maxHealth;
	private double health;
	private int attack;
	private double displayAttack;
	private int defense;
	private double displayDefense;
	private int mana;
	private int value;

	public Boss(int h, int a, int d, int v, int m, String n)
	{
		maxHealth = h;
		health = h;
		attack = a;
		defense = d;
		value = v;
		mana = m;
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

	public int getMana()
	{
		return mana;
	}

	public void subtractMana(int amount)
	{
		mana -= amount;
	}

	//TODO: mana based attacks that trigger at random if a certain condition is met 
	//boss chosen to fight based on floor number, and prologue is offered using if statement that takes the number
	//using specially defined boss scrolls might be helpful for choosing moves

}