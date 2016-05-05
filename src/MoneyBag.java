public class MoneyBag extends UIElement{
	//amount of money inside the bag
	private int moneyValue;
	
	/**Creates a money bag with a given money value
	 * @param moneyValue amount of money inside the bag
	 */
	public MoneyBag(int moneyValue)
	{
		this.moneyValue = moneyValue;
		
	}
	
	/**Retrieves the money value
	 * return @param moneyValue amount of money inside the bag
	 */
	public int getMoneyValue()
	{
		return moneyValue;
	}
}
