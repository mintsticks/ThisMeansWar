//Java imports
import java.util.List;

//JavaFx Imports
import javafx.scene.image.ImageView;
import javafx.scene.shape.Path;
import javafx.scene.shape.Shape;

public abstract class UIElement extends ImageView{
	//Shape of UIElement used to check for intersection
	private Shape collisionShape;
	
	/**Abstract method for the creation of collision shape in each subclass
	 */
	abstract void createCollShape();

	/**Retrieves the collision shape for the element
	 * @return collision shape of the element used to check for intersections
	 */
	public Shape getCollShape()
	{
		return collisionShape;
	}
	
	/**Checks the current shape with another given shape and checks for intersection. This method uses the intersect method in Shape,
	 * which returns a shape representing the intersection of the two shapes given. It then converts the intersection shape into a path. 
	 * If there are more than zero elements in the path then there is an intersection.
	 * @param other other UI element which is checked for intersection
	 * @return whether the two shapes intersect
	 */
	public boolean checkCollision(UIElement other)
	{
		return ((Path)Shape.intersect(this.collisionShape, other.getCollShape())).getElements().size() > 0;
	}
	
}
