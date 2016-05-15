import java.util.*;

public class Player {
	private String name;
	private List<Unit> units;
	private int money;
	
	public Player(String name) 
	{
		this.name = name;
		units = new ArrayList<Unit>();
		money = 300;
	}
	
	public boolean isEmpty()
	{
		return units.size() == 0;
	}
	
	public List<Unit> getUnitList()
	{
		return units;
	}

	public int getAmountOfMoney()
	{
		return money;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void addUnit(Unit unit)
	{
		units.add(unit);
	}
	
	public void removeUnit (Unit unit)
	{
		units.remove(unit);
	}
	
	public void addMoney(int toAdd)
	{
		money += toAdd;
	}
	
	public void deductMoney (int toDeduct)
	{
		money -= toDeduct;
	}
	

}
