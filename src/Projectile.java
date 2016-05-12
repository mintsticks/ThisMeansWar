
public class Projectile extends UIElement
{	
	private double startX;
	private double startY;
	private double endX;
	private double endY;
	private double damage;
	
	/**Creates a projectile that starts from a location and has an ending location.
	 * @param startX
	 * @param startY
	 * @param endX
	 * @param endY
	 * @param damage
	 */
	public Projectile(double startX, double startY, double endX, double endY, double damage) 
	{
		this.startX = startX;
		this.startY = startY;
		this.endX = endX;
		this.endY = endY;
		this.damage = damage;
	}
	
}
