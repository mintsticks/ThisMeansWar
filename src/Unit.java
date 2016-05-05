import javafx.scene.effect.Effect;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Unit extends UIElement{
	
	//Instance variables for the unit to store its statistics
	private int health;
	private double attackRange;
	private int damage;
	private double moveRange;
	private int cost;
	private Image appearance;
	
	/**Creates a unit with the given statistics of health, attack/movement ranges, damage, cost, and appearance
	 * @param health the health value that the unit has
	 * @param attackRange the distance that a bullet fired by this unit can travel
	 * @param damage damage that a bullet fired by this unit will do to an enemy unit
	 * @param moveRange the distance that this unit can travel in one turn
	 * @param cost the amount of money that it takes for a Player to purchase this unit
	 * @param appearance the image that this unit will display on the UI screen
	 * @param collShape collision shape of the Unit, which is used to check for intersection
	 */
	public Unit (int health, double attackRange, int damage, double moveRange, int cost, Image appearance)
	{
		this.health = health;
		this.attackRange = attackRange;
		this.damage = damage;
		this.moveRange = moveRange;
		this.cost = cost;
		
		this.appearance = appearance;
		this.setImage(appearance);
		
		super.createCollShape();
	}
	
	/**Returns the health of the unit
	 * @return the health value that the unit has
	 */
	public int getHealth()
	{
		return health;
	}
	
	/**Returns the attack range of the unit
	 * @return the distance that a bullet fired by this unit can travel
	 */
	public double getAttackRange()
	{
		return attackRange;
	}
	
	/**Returns the damage of the unit
	 * @return damage that a bullet fired by this unit will do to the health of an enemy unit
	 */
	public int getDamage()
	{
		return damage;
	}
	
	/**Returns the movement range of the unit
	 * @return the distance that this unit can travel in one turn
	 */
	public double getMovementRange()
	{
		return moveRange;
	}
	
	/**Returns the cost of the unit
	 * @return the amount of money that it takes for a Player to purchase this unit
	 */
	public int getCost()
	{
		return cost;
	}
	
	/**Returns the appearance of this unit in an ImageView
	 * @return the image that this unit will display on the UI screen
	 */
	public Image getAppearance()
	{
		return appearance;
	}
	
	/**Sets the new health of the unit
	 * @param the health value that the unit has
	 */
	public void setHealth(int newHealth)
	{
		health = newHealth;
	}
	
	/**Sets the appearance of this unit
	 * @param Image that the unit will be changed to
	 */
	public void setAppearance(Image picture)
	{
		appearance = picture;
		this.setImage(appearance);
	}
}
