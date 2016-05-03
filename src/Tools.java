//JavaFx Imports
import javafx.scene.effect.Effect;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Tools {
	//static initializer which runs when the class is initialized, loads different types of fonts for the whole class
	//Site used to learn initializer : https://docs.oracle.com/javase/tutorial/java/javaOO/initial.html
	static
	{
		
	}
	
	/**Creates a font based on desired font type, font weight, and size. 
	 * @param font type of font to create
	 * @param weight weight of the font; if null, creates font with default weight (regular)
	 * @param size size of the font
	 * @param smallestRatio ratio to resize font to the dimensions of the screen
	 * @return font created with input preferences
	 */
	public static Font createFont(String font, FontWeight weight, double size, double smallestRatio)
	{
		if(weight != null)
			return Font.font(font, weight, size * smallestRatio);
		else
			return Font.font(font, size * smallestRatio);	
	}
	
	/**Generates text on the screen in a given location with a given font and message
	 * @param xLoc the x-coordinate of the text
	 * @param yLoc the y-coordinate of the text
	 * @param widthRatio the ratio of the user's desired width resolution to the highest possible screen width
	 * @param heightRatio the ratio of the user's desired height resolution to the highest possible screen height
	 * @param content the context of the text 
	 * @param col the text color
	 * @param eff given visual effect 
	 * @param f the text font
	 * @return the text with all the aforementioned settings
	 */
	public static Text createText(double xLoc, double yLoc, double widthRatio, double heightRatio, 
			String content, Color col, Effect eff, Font f) 
	{
		Text text = new Text(content);
		
		text.setFill(col);
		text.setFont(f);
		text.setEffect(eff);
		
		AnchorPane.setTopAnchor(text, yLoc * heightRatio);
		AnchorPane.setLeftAnchor(text, xLoc * widthRatio);
	
		return text;
	}
	
	/**Loads an image and returns it based on a given string
	 * Uses ClassLoader to load the class and get its resources
	 * Site used to learn how to load images: http://stackoverflow.com/questions/14089146/file-loading-by-getclass-getresource
	 * @param name name of the image file, ex: "image.png"
	 * @return image that is at the given location
	 */
	public static Image createImage(String name)
	{
		return new Image(ClassLoader.getSystemClassLoader().getResourceAsStream("res/" + name));
	}
	
	/**Generates an image view on the screen in a given location with a given image, size, and effect
	 * @param img image to been displayed in the view
	 * @param height desired height of image view 
	 * @param width desired width of image view
	 * @param xLoc the x-coordinate of the image view
	 * @param yLoc the y-coordinate of the image view
	 * @param widthRatio the ratio of the user's desired width resolution to the highest possible screen width
	 * @param heightRatio the ratio of the user's desired height resolution to the highest possible screen height
	 * @param smallestRatio smallest of the two ratios, used to resize the image
	 * @param eff given visual effect
	 * @return the image view with the given settings
	 */
	public static ImageView createImageView(Image img, double height, double width, double xLoc, double yLoc,
			 double widthRatio, double heightRatio, double smallestRatio, Effect eff) 
	{
		ImageView imgV = new ImageView();
		
		imgV.setImage(img);
		imgV.setEffect(eff);
		
		imgV.setFitHeight(height * smallestRatio);
		imgV.setFitWidth(width * smallestRatio);
		
		//set the quality of the image
		imgV.setPreserveRatio(true);
		imgV.setSmooth(true);
		imgV.setCache(true);
		
		AnchorPane.setLeftAnchor(imgV, xLoc * widthRatio);
		AnchorPane.setTopAnchor(imgV, yLoc * heightRatio);

		return imgV;
	}
	
	public static Rectangle createRoundedRectangle()
	{
		return null;
	}
	
	public static Ellipse createEllipse()
	{
		return null;
	}
	
	public static Unit createPrivate()
	{
		return null;
	}
	
	public static Unit createCorporal()
	{
		return null;
	}
	
	public static Unit createSergeant()
	{
		return null;
	}
	
	public static Unit createTank()
	{
		return null;
	}
	
	public static Unit createScout()
	{
		return null;
	}
	
	public static Unit createSniper()
	{
		return null;
	}
	
	public static MoneyBag createMoneyBag()
	{
		return null;
	}
	
	public static Obstacle createRock()
	{
		return null;
	}
	
	public static Obstacle createTree()
	{
		return null;
	}
	
	public static Projectile createProjectile()
	{
		return null;
	}
}
