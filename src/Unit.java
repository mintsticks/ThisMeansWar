import javafx.scene.effect.Effect;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Unit extends UIElement{
	private int health, attackRange, damage, mvmt, cost;
	private ImageView appearance;
	
	/**
	 * @param health
	 * @param attackRange
	 * @param damage
	 * @param mvmt
	 * @param cost
	 */
	public Unit (int health, int attackRange, int damage, int mvmt, int cost)
	{
		this.health = health;
		this.attackRange = attackRange;
		this.damage = damage;
		this.mvmt = mvmt;
		this.cost = cost;
		//will create in Tools method based on type of unit
		appearance = null;
	}
	/**
	 * 
	 * @return health of the unit
	 */
	public int getHealth()
	{
		return health;
	}
	/**
	 * 
	 * @return attack range of the unit
	 */
	public int getAttackRange()
	{
		return attackRange;
	}
	/**
	 * 
	 * @return damage of the unit
	 */
	public int getDamage()
	{
		return damage;
	}
	/**
	 * 
	 * @return movement range of the unit
	 */
	public int getMovementRange()
	{
		return mvmt;
	}
	/**
	 * 
	 * @return cost of the unit
	 */
	public int getCost()
	{
		return cost;
	}
	
	public ImageView getAppearance()
	{
		return appearance;
	}
	public void setAppearance(Image img, double height, double width, double xLoc, double yLoc,
			 double widthRatio, double heightRatio, double smallestRatio, Effect eff)
	{
		appearance = Tools.createImageView(img, height, width, xLoc, yLoc, widthRatio, heightRatio, smallestRatio, eff);
	}
	
}
