import java.util.*;

public class Player
{
	private String name;
	private List<Unit> units;
	private int money;

	public Player(String name)
	{
		this.name = name;
		units = new ArrayList<Unit>();
		money = 400;
	}

	public void addMoney(int toAdd)
	{
		money += toAdd;
	}

	public void addUnit(Unit unit)
	{
		units.add(unit);
	}

	public void deductMoney(int toDeduct)
	{
		money -= toDeduct;
	}

	public int getAmountOfMoney()
	{
		return money;
	}

	public String getName()
	{
		return name;
	}

	public List<Unit> getUnitList()
	{
		return units;
	}

	public boolean isEmpty()
	{
		return units.size() == 0;
	}

	public void removeUnit(Unit unit)
	{
		units.remove(unit);
	}

}
