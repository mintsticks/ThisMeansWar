/**A class that provides the blueprints for a money pile on the screen. It
 * can be walked over to gain the amount of money stored inside
 * @author Daniel Wong
 * @author Shishir Jessu
 * @author Corey Rogan
 * Period: 3
 * Date: 05-19-16
 */
public class MoneyBag extends UIElement
{
	// amount of money inside the bag
	private int moneyValue;

	/**
	 * Creates a money bag with a given money value
	 * @param moneyValue amount of money inside the bag
	 */
	public MoneyBag(int moneyValue)
	{
		this.moneyValue = moneyValue;

	}

	/**
	 * Retrieves the money value return 
	 * @param moneyValue amount of money inside the bag
	 */
	public int getMoneyValue()
	{
		return moneyValue;
	}
}
