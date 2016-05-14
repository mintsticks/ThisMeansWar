//JavaFx Imports
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.effect.InnerShadow;
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
	//Constants available for every class
	public static final InnerShadow XLARGE_SHADE = new InnerShadow(10.0, Color.BLACK);
	public static final InnerShadow LARGE_SHADE = new InnerShadow(5.0, Color.BLACK);
	public static final InnerShadow MEDIUM_SHADE = new InnerShadow(3.0, Color.BLACK);
	public static final InnerShadow SMALL_SHADE = new InnerShadow(2.0, Color.BLACK);
	public static final DropShadow LARGE_OUT_SHADE = new DropShadow(5.0, Color.BLACK);
	
	//Constant statistics for units
	public static final int PRIV_HEALTH = 1;
	public static final double PRIV_ATT_RANGE = 1;
	public static final int PRIV_DMG = 1;
	public static final double PRIV_MOVE_RANGE = 1;
	public static final int PRIV_COST = 1;
	
	public static final int CORP_HEALTH = 2;
	public static final double CORP_ATT_RANGE = 2;
	public static final int CORP_DMG = 2;
	public static final double CORP_MOVE_RANGE = 2;
	public static final int CORP_COST = 2;
	
	public static final int SERG_HEALTH = 3;
	public static final double SERG_ATT_RANGE = 3;
	public static final int SERG_DMG = 3;
	public static final double SERG_MOVE_RANGE = 3;
	public static final int SERG_COST = 3;

	public static final int TANK_HEALTH = 4;
	public static final double TANK_ATT_RANGE = 4;
	public static final int TANK_DMG = 4;
	public static final double TANK_MOVE_RANGE = 2;
	public static final int TANK_COST = 4;
	
	public static final int SCOUT_HEALTH = 2;
	public static final double SCOUT_ATT_RANGE = 2;
	public static final int SCOUT_DMG = 1;
	public static final double SCOUT_MOVE_RANGE = 4;
	public static final int SCOUT_COST = 2;
	
	public static final int SNIP_HEALTH = 1;
	public static final double SNIP_ATT_RANGE = 4;
	public static final int SNIP_DMG = 3;
	public static final double SNIP_MOVE_RANGE = 2;
	public static final int SNIP_COST = 2;
	
	//Other element settings
	public static final int MONEY_BAG_SMALL = 100;
	public static final int MONEY_BAG_MEDIUM = 200;
	public static final int MONEY_BAG_LARGE = 500;
	public static final int MONEY_BAG_XLARGE = 1000;
	
	public static final double MONEY_BAG_SMALL_H = 100;
	public static final double MONEY_BAG_MEDIUM_H = 125;
	public static final int MONEY_BAG_LARGE_H = 150;
	public static final int MONEY_BAG_XLARGE_H = 175;
	
	public static final double MONEY_BAG_SMALL_W = 100;
	public static final double MONEY_BAG_MEDIUM_W = 125;
	public static final int MONEY_BAG_LARGE_W = 150;
	public static final int MONEY_BAG_XLARGE_W = 175;
	
	public static final double DEFAULT_ANGLE = 0;
	public static final int DEFAULT_FONT = 10;
	
	//static initializer which runs when the class is initialized, loads different types of fonts for the whole class
	//Site used to learn initializer : https://docs.oracle.com/javase/tutorial/java/javaOO/initial.html
	static
	{
		Font.loadFont(ClassLoader.getSystemResourceAsStream("res/BOOKOSB.TTF"), DEFAULT_FONT);
		Font.loadFont(ClassLoader.getSystemResourceAsStream("res/Agency_FB.ttf"), DEFAULT_FONT);

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
	
	/**Generates a rounded rectangle on the screen with a given size, arc size, effect, color, and location.
	 * @param width width of the rectangle
	 * @param height height of the rectangle
	 * @param arcW width of the arc at the corners of the rectangle
	 * @param arcH height of the arc at the corners of the rectangle
	 * @param xLoc the x-coordinate of the text
	 * @param yLoc the y-coordinate of the text
	 * @param widthRatio the ratio of the user's desired width resolution to the highest possible screen width
	 * @param heightRatio the ratio of the user's desired height resolution to the highest possible screen height
	 * @param smallestRatio smallest of the two ratios, used to resize the image
	 * @param col color of the rectangle
	 * @param eff given visual effect of the rectangle
	 * @return rectangle with the given settings
	 */
	public static Rectangle createRoundedRectangle(double width, double height, double arcW, double arcH, double xLoc, double yLoc, double widthRatio,
			double heightRatio, double smallestRatio, Color col, Effect eff) 
	{
		Rectangle rect = new Rectangle(width * widthRatio, height * heightRatio);
		rect.setArcHeight(arcH * heightRatio);
		rect.setArcWidth(arcW * widthRatio);
		
		AnchorPane.setTopAnchor(rect, yLoc * heightRatio);
		AnchorPane.setLeftAnchor(rect, xLoc * widthRatio);
		
		rect.setFill(col);
		rect.setEffect(eff);

		return rect;
	}
	
	/**Generates an ellipse on the screen with a given x and y radius, location, color, and effect
	 * @param centerX x coordinate of the center of the ellipse
	 * @param centerY y coordinate of the center of the ellipse
	 * @param radiusX size of the radius in the x direction of the ellipse
	 * @param radiusY size of the radius in the y direction of the ellipse
	 * @param widthRatio the ratio of the user's desired width resolution to the highest possible screen width
	 * @param heightRatio the ratio of the user's desired height resolution to the highest possible screen height
	 * @param smallestRatio smallest of the two ratios, used to resize the image
	 * @param col color of the ellipse
	 * @param eff given visual effect of the ellipse
	 * @return ellipse with the given settings
	 */
	public static Ellipse createEllipse(double centerX, double centerY, double radiusX, double radiusY, double widthRatio,
			double heightRatio, double smallestRatio, Color col, Effect eff)
	{
		return null;
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
	
	/**Sets the characteristics of given image view to the values given, including its
	 * height, width, x location, y location, and effect.
	 * @param imgV image view to modify and return
	 * @param height desired height of image view 
	 * @param width desired width of image view
	 * @param xLoc the x-coordinate of the image view
	 * @param yLoc the y-coordinate of the image view
	 * @param widthRatio the ratio of the user's desired width resolution to the highest possible screen width
	 * @param heightRatio the ratio of the user's desired height resolution to the highest possible screen height
	 * @param smallestRatio smallest of the two ratios, used to resize the image
	 * @param eff given visual effect
	 * @return the image view after it has been modified 
	 */
	public static ImageView setImgView(ImageView imgV, double height, double width, double xLoc, double yLoc,
			 double widthRatio, double heightRatio, double smallestRatio, Effect eff)
	{
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
	
	/**Generates a Unit with the statistics of a private. 
	 * It is displayed on the screen in a specified location with a given size and effect	 
	 * @param height desired height of image view 
	 * @param width desired width of image view
	 * @param angle desired angle of image view
	 * @param xLoc the x-coordinate of the image view
	 * @param yLoc the y-coordinate of the image view
	 * @param widthRatio the ratio of the user's desired width resolution to the highest possible screen width
	 * @param heightRatio the ratio of the user's desired height resolution to the highest possible screen height
	 * @param smallestRatio smallest of the two ratios, used to resize the image
	 * @param eff given visual effect
	 * @return the Private unit with the given settings
	 */
	public static Unit createPrivate(double height, double width, double angle, double xLoc, double yLoc,
			 double widthRatio, double heightRatio, double smallestRatio, Effect eff)
	{
		Unit priv = new Unit(PRIV_HEALTH, PRIV_ATT_RANGE, PRIV_DMG, PRIV_MOVE_RANGE, PRIV_COST, createImage("Units/Private.png"));
		priv = (Unit)setImgView(priv, height, width, xLoc, yLoc, widthRatio, heightRatio, smallestRatio, eff);
		priv.updateCollShape(height, width, angle, xLoc, yLoc, widthRatio, heightRatio, smallestRatio);
		return priv;
	}
	
	/**Generates a Unit with the statistics of a corporal. 
	 * It is displayed on the screen in a specified location with a given size and effect	 
	 * @param height desired height of image view 
	 * @param width desired width of image view
	 * @param angle desired angle of image view
	 * @param xLoc the x-coordinate of the image view
	 * @param yLoc the y-coordinate of the image view
	 * @param widthRatio the ratio of the user's desired width resolution to the highest possible screen width
	 * @param heightRatio the ratio of the user's desired height resolution to the highest possible screen height
	 * @param smallestRatio smallest of the two ratios, used to resize the image
	 * @param eff given visual effect
	 * @return the Corporal unit with the given settings
	 */
	public static Unit createCorporal(double height, double width, double angle, double xLoc, double yLoc,
			 double widthRatio, double heightRatio, double smallestRatio, Effect eff)
	{
		Unit corp = new Unit(CORP_HEALTH, CORP_ATT_RANGE, CORP_DMG, CORP_MOVE_RANGE, CORP_COST, createImage("Units/Corporal.png"));
		corp = (Unit)setImgView(corp, height, width, xLoc, yLoc, widthRatio, heightRatio, smallestRatio, eff);
		corp.updateCollShape(height, width, angle, xLoc, yLoc, widthRatio, heightRatio, smallestRatio);
		
		return corp;
	}
	
	/**Generates a Unit with the statistics of a sergeant. 
	 * It is displayed on the screen in a specified location with a given size and effect	
	 * @param height desired height of image view 
	 * @param width desired width of image view
	 * @param angle desired angle of image view
	 * @param xLoc the x-coordinate of the image view
	 * @param yLoc the y-coordinate of the image view
	 * @param widthRatio the ratio of the user's desired width resolution to the highest possible screen width
	 * @param heightRatio the ratio of the user's desired height resolution to the highest possible screen height
	 * @param smallestRatio smallest of the two ratios, used to resize the image
	 * @param eff given visual effect
	 * @return the Sergeant unit with the given settings
	 */
	public static Unit createSergeant(double height, double width, double angle, double xLoc, double yLoc,
			 double widthRatio, double heightRatio, double smallestRatio, Effect eff)
	{
		Unit serg = new Unit(SERG_HEALTH, SERG_ATT_RANGE, SERG_DMG, SERG_MOVE_RANGE, SERG_COST, createImage("Units/Sergeant.png"));
		serg = (Unit)setImgView(serg, height, width, xLoc, yLoc, widthRatio, heightRatio, smallestRatio, eff);
		serg.updateCollShape(height, width, angle, xLoc, yLoc, widthRatio, heightRatio, smallestRatio);
		
		return serg;
	}
	
	/**Generates a Unit with the statistics of a tank. 
     * It is displayed on the screen in a specified location with a given size and effect	 
     * @param height desired height of image view 
     * @param angle desired angle of image view
	 * @param width desired width of image view
	 * @param xLoc the x-coordinate of the image view
	 * @param yLoc the y-coordinate of the image view
	 * @param widthRatio the ratio of the user's desired width resolution to the highest possible screen width
	 * @param heightRatio the ratio of the user's desired height resolution to the highest possible screen height
	 * @param smallestRatio smallest of the two ratios, used to resize the image
	 * @param eff given visual effect
	 * @return the tank unit with the given settings
	 */
	public static Unit createTank(double height, double width, double angle, double xLoc, double yLoc,
			 double widthRatio, double heightRatio, double smallestRatio, Effect eff)
	{
		Unit tank = new Unit(TANK_HEALTH, TANK_ATT_RANGE, TANK_DMG, TANK_MOVE_RANGE, TANK_COST, createImage("Units/Tank.png"));
		tank = (Unit)setImgView(tank, height, width, xLoc, yLoc, widthRatio, heightRatio, smallestRatio, eff);
		tank.updateCollShape(height, width, angle, xLoc, yLoc, widthRatio, heightRatio, smallestRatio);
		
		return tank;
	}
	
	/**Generates a Unit with the statistics of a scout. 
	 * It is displayed on the screen in a specified location with a given size and effect
	 * @param height desired height of image view 
	 * @param width desired width of image view
	 * @param angle desired angle of image view
	 * @param xLoc the x-coordinate of the image view
	 * @param yLoc the y-coordinate of the image view
	 * @param widthRatio the ratio of the user's desired width resolution to the highest possible screen width
	 * @param heightRatio the ratio of the user's desired height resolution to the highest possible screen height
	 * @param smallestRatio smallest of the two ratios, used to resize the image
	 * @param eff given visual effect
	 * @return the Scout unit with the given settings
	 */
	public static Unit createScout(double height, double width, double angle, double xLoc, double yLoc,
			 double widthRatio, double heightRatio, double smallestRatio, Effect eff)
	{
		Unit scout = new Unit(SCOUT_HEALTH, SCOUT_ATT_RANGE, SCOUT_DMG, SCOUT_MOVE_RANGE, SCOUT_COST, createImage("Units/Scout.png"));
		scout = (Unit)setImgView(scout, height, width, xLoc, yLoc, widthRatio, heightRatio, smallestRatio, eff);
		scout.updateCollShape(height, width, angle, xLoc, yLoc, widthRatio, heightRatio, smallestRatio);
		
		return scout;
	}
	
	/**Generates a Unit with the statistics of a sniper. 
	 * It is displayed on the screen in a specified location with a given size and effect	 
	 * @param height desired height of image view 
	 * @param width desired width of image view
	 * @param angle desired angle of image view
	 * @param xLoc the x-coordinate of the image view
	 * @param yLoc the y-coordinate of the image view
	 * @param widthRatio the ratio of the user's desired width resolution to the highest possible screen width
	 * @param heightRatio the ratio of the user's desired height resolution to the highest possible screen height
	 * @param smallestRatio smallest of the two ratios, used to resize the image
	 * @param eff given visual effect
	 * @return the Sniper unit with the given settings
	 */
	public static Unit createSniper(double height, double width, double angle, double xLoc, double yLoc,
			 double widthRatio, double heightRatio, double smallestRatio, Effect eff)
	{
		Unit sniper = new Unit(SNIP_HEALTH, SNIP_ATT_RANGE, SNIP_DMG, SNIP_MOVE_RANGE, SNIP_COST, createImage("Units/Sniper.png"));
		sniper = (Unit)setImgView(sniper, height, width, xLoc, yLoc, widthRatio, heightRatio, smallestRatio, eff);
		sniper.updateCollShape(height, width, angle, xLoc, yLoc, widthRatio, heightRatio, smallestRatio);
		
		return sniper;
	}
	
	/**Creates a money bag with values based on a given setting number. 
	 * It is displayed on the screen in a specified location with a given size and effect
	 * @param setting a number to indicate what type of money bag desired
	 * 1: Smallest money bag, 2: medium money bag, 3: large money bag, 4: extra large money bag
	 * @param xLoc the x-coordinate of the image view
	 * @param yLoc the y-coordinate of the image view
	 * @param widthRatio the ratio of the user's desired width resolution to the highest possible screen width
	 * @param heightRatio the ratio of the user's desired height resolution to the highest possible screen height
	 * @param smallestRatio smallest of the two ratios, used to resize the image
	 * @param eff given visual effect
	 * @return MoneyBag with the given settings
	 */
	public static MoneyBag createMoneyBag(int setting, double xLoc, double yLoc, double widthRatio, double heightRatio, double smallestRatio, Effect eff)
	{
		MoneyBag bag;
		double height;
		double width;
		if(setting == 1)
		{
			bag = new MoneyBag(MONEY_BAG_SMALL);
			height = MONEY_BAG_SMALL_H;
			width = MONEY_BAG_SMALL_W;
		}
		else if(setting == 2)
		{
			bag = new MoneyBag(MONEY_BAG_MEDIUM);
			height = MONEY_BAG_MEDIUM_H;
			width = MONEY_BAG_MEDIUM_W;
		}
		else if(setting == 3)
		{
			bag = new MoneyBag(MONEY_BAG_LARGE);
			height = MONEY_BAG_LARGE_H;
			width = MONEY_BAG_LARGE_W;
		}
		else if(setting == 4)
		{
			bag = new MoneyBag(MONEY_BAG_XLARGE);
			height = MONEY_BAG_XLARGE_H;
			width = MONEY_BAG_XLARGE_W;
		}
		//default case
		else
		{
			bag = new MoneyBag(MONEY_BAG_MEDIUM);
			height = MONEY_BAG_MEDIUM_H;
			width = MONEY_BAG_MEDIUM_W;
		}
		bag.setImage(createImage("Money_Bag_Emote.png"));
		bag = (MoneyBag)setImgView(bag, height, width, xLoc, yLoc, widthRatio, heightRatio, smallestRatio, eff);
		bag.updateCollShape(height, widthRatio, DEFAULT_ANGLE, xLoc, yLoc, widthRatio, heightRatio, smallestRatio);
		return bag;
	}
	
	/**Creates an obstacle, which is a base where the players units spawn
	 * It is displayed on the screen in a specified location with a given size and effect
	 * @param height desired height of image view 
	 * @param width desired width of image view
	 * @param xLoc the x-coordinate of the image view
	 * @param yLoc the y-coordinate of the image view
	 * @param widthRatio the ratio of the user's desired width resolution to the highest possible screen width
	 * @param heightRatio the ratio of the user's desired height resolution to the highest possible screen height
	 * @param smallestRatio smallest of the two ratios, used to resize the image
	 * @param eff given visual effect
	 * @return obstacle that is a base with the given location, size, and effect
	 */
	public static Obstacle createBase(double height, double width, double xLoc, double yLoc,
			 double widthRatio, double heightRatio, double smallestRatio, Effect eff)
	{
		Obstacle base = new Obstacle(true);
		base.setImage(createImage("Base.png"));
		base = (Obstacle)setImgView(base, height, width, xLoc, yLoc, widthRatio, heightRatio, smallestRatio, eff);
		base.updateCollShape(height, widthRatio, DEFAULT_ANGLE, xLoc, yLoc, widthRatio, heightRatio, smallestRatio);
		return base;
	}
	
	/**Creates a solid object, which is a object which players cannot pass through
	 * It is displayed on the screen in a specified location with a given size and effect
	 * @param height desired height of solid 
	 * @param width desired width of solid
	 * @param xLoc the x-coordinate of the solid
	 * @param yLoc the y-coordinate of the solid
	 * @param widthRatio the ratio of the user's desired width resolution to the highest possible screen width
	 * @param heightRatio the ratio of the user's desired height resolution to the highest possible screen height
	 * @param smallestRatio smallest of the two ratios, used to resize the image
	 * @param eff given visual effect
	 * @return obstacle that is a rock with the given location, size, and effect
	 */
	public static Obstacle createSolid(String img, double height, double width, double xLoc, double yLoc,
			 double widthRatio, double heightRatio, double smallestRatio, Effect eff)
	{
		Obstacle solid = new Obstacle(false);
		solid.setImage(createImage(img));
		solid = (Obstacle)setImgView(solid, height, width, xLoc, yLoc, widthRatio, heightRatio, smallestRatio, eff);
		solid.updateCollShape(height, widthRatio, DEFAULT_ANGLE, xLoc, yLoc, widthRatio, heightRatio, smallestRatio);
		return solid;
	}
	/**Creates a projectile that has a certain amount of damage.
	 * Displays on the field with a given angle, size, location, and effect
	 * @param damage damage that the projectile will inflict on a unit that it hits
	 * @param height desired height of projectile
	 * @param width desired width of projectile
	 * @param startXLoc the starting x-coordinate of the projectile
	 * @param startYLoc the starting y-coordinate of the projectile
	 * @param widthRatio the ratio of the user's desired width resolution to the highest possible screen width
	 * @param heightRatio the ratio of the user's desired height resolution to the highest possible screen height
	 * @param smallestRatio smallest of the two ratios, used to resize the image
	 * @param eff given visual effect
	 * @return projectile with the given settings
	 */
	public static Projectile createProjectile(double damage, double height, double width, double angle, double startXLoc,
			double startYLoc, double widthRatio, double heightRatio, double smallestRatio, Effect eff)
	{
		Projectile bullet = new Projectile(damage);
		bullet.setImage(createImage("Bullet.png"));
		bullet = (Projectile)setImgView(bullet, height, width, startXLoc, startYLoc, widthRatio, heightRatio, smallestRatio, eff);
		
		bullet.setRotate(angle);
		bullet.updateCollShape(height, widthRatio, angle, startXLoc, startYLoc, widthRatio, heightRatio, smallestRatio);
		
		return bullet;
	}
}
