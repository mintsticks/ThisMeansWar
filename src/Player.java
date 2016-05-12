import java.util.*;

public class Player {
	
	private List<Unit> units;
	private int money;
	
	public Player() 
	{
		units = new ArrayList<Unit>();
		money = 100; //some default value we can change later
	}
	
	public List<Unit> getUnitList()
	{
		return units;
	}
	
	public boolean isEmpty()
	{
		return units.size() == 0;
	}
	public int getAmountOfMoney()
	{
		return money;
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
