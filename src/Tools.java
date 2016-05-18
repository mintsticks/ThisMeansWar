//JavaFx Imports
import javafx.scene.control.TextField;
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
	public static final Color[] TEAM_COLORS = {Color.web("#ff0000"), Color.web("#24fff7"), Color.web("#69ff34"), Color.web("#f334ff")};
	public static final Color TRANSPARENT =  Color.rgb(100, 100, 100, 0);
	public static final Color DARK_GREEN = Color.web("#2a5a1e");
	public static final Color LIGHT_GRAY = Color.web("#8e8e8e");
	//Constants available for every class
	public static final InnerShadow XLARGE_SHADE = new InnerShadow(10.0, Color.BLACK);
	public static final InnerShadow LARGE_SHADE = new InnerShadow(5.0, Color.BLACK);
	public static final InnerShadow MEDIUM_SHADE = new InnerShadow(3.0, Color.BLACK);
	public static final InnerShadow SMALL_SHADE = new InnerShadow(2.0, Color.BLACK);
	public static final DropShadow LARGE_OUT_SHADE = new DropShadow(5.0, Color.BLACK);
	public static final DropShadow MEDIUM_OUT_SHADE = new DropShadow(3.0, Color.BLACK);
	public static final DropShadow SMALL_OUT_SHADE = new DropShadow(2.0, Color.BLACK);
	
	public static final DropShadow LARGE_WHITE_OUT = new DropShadow(5.0, Color.WHITE);
	public static final DropShadow RED_OUT_SHADE = new DropShadow(5.0, TEAM_COLORS[0]);
	public static final DropShadow CYAN_OUT_SHADE = new DropShadow(5.0, TEAM_COLORS[1]);
	public static final DropShadow GREEN_OUT_SHADE = new DropShadow(5.0, TEAM_COLORS[2]);
	public static final DropShadow PINK_OUT_SHADE = new DropShadow(5.0, TEAM_COLORS[3]);

	//Constant statistics for units
	public static final int PRIV_HEALTH = 50;
	public static final double PRIV_ATT_RANGE = 1000;
	public static final int PRIV_DMG = 25;
	public static final double PRIV_MOVE_RANGE = 1000;
	public static final int PRIV_COST = 100;
	
	public static final int CORP_HEALTH = 100;
	public static final double CORP_ATT_RANGE = 1000;
	public static final int CORP_DMG = 50;
	public static final double CORP_MOVE_RANGE = 2000;
	public static final int CORP_COST = 200;
	
	public static final int SERG_HEALTH = 150;
	public static final double SERG_ATT_RANGE = 1000;
	public static final int SERG_DMG = 75;
	public static final double SERG_MOVE_RANGE = 3000;
	public static final int SERG_COST = 300;

	public static final int TANK_HEALTH = 200;
	public static final double TANK_ATT_RANGE = 1000;
	public static final int TANK_DMG = 100;
	public static final double TANK_MOVE_RANGE = 2000;
	public static final int TANK_COST = 400;
	
	public static final int SCOUT_HEALTH = 100;
	public static final double SCOUT_ATT_RANGE = 1000;
	public static final int SCOUT_DMG = 25;
	public static final double SCOUT_MOVE_RANGE = 4000;
	public static final int SCOUT_COST = 200;
	
	public static final int SNIP_HEALTH = 50;
	public static final double SNIP_ATT_RANGE = 1000;
	public static final int SNIP_DMG = 75;
	public static final double SNIP_MOVE_RANGE = 2000;
	public static final int SNIP_COST = 200;
	
	//Other element settings
	public static final int MAX_MONEY_BAG = 400;
	public static final double MONEY_SIZE = 200;
	
	public static final double DEFAULT_ANGLE = 0;
	public static final int DEFAULT_FONT = 10;
	
	//Icons for the units
	public static final Image PRIVATE_ICON = Tools.createImage("Icons/PrivateIcon.png");
	public static final Image CORP_ICON = Tools.createImage("Icons/CorpIcon.png");
	public static final Image SERG_ICON = Tools.createImage("Icons/SergIcon.png");
	public static final Image TANK_ICON = Tools.createImage("Icons/TankIcon.png");
	public static final Image SNIPER_ICON = Tools.createImage("Icons/SniperIcon.png");
	public static final Image SCOUT_ICON = Tools.createImage("Icons/ScoutIcon.png");
	
	//Images for the units
	public static final Image PRIVATE = Tools.createImage("Units/Private.png");
	public static final Image CORP = Tools.createImage("Units/Corporal.png");
	public static final Image SERG = Tools.createImage("Units/Sergeant.png");
	public static final Image TANK = Tools.createImage("Units/Tank.png");
	public static final Image SNIPER = Tools.createImage("Units/Sniper.png");
	public static final Image SCOUT = Tools.createImage("Units/Scout.png");
	
	public static final String PRIVATE_TEXT = "Private";
	public static final String CORP_TEXT = "Corporal";
	public static final String SERG_TEXT = "Sergeant";
	public static final String TANK_TEXT = "Tank";
	public static final String SNIPER_TEXT = "Sniper";
	public static final String SCOUT_TEXT = "Scout";

	
	//static initializer which runs when the class is initialized, loads different types of fonts for the whole class
	//Site used to learn initializer : https://docs.oracle.com/javase/tutorial/java/javaOO/initial.html
	static
	{
		Font.loadFont(ClassLoader.getSystemResourceAsStream("res/BOOKOSB.TTF"), DEFAULT_FONT);
		Font.loadFont(ClassLoader.getSystemResourceAsStream("res/Agency_FB.ttf"), DEFAULT_FONT);

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
		base.setEffect(eff);
		
		base.setFitHeight(height * smallestRatio);
		base.setFitWidth(width * smallestRatio);
		
		//set the quality of the image
		base.setPreserveRatio(false);
		base.setSmooth(true);
		base.setCache(true);
		
		base.setLayoutX(xLoc * widthRatio);
		base.setLayoutY(yLoc * heightRatio);
		base.updateCollShape(height, widthRatio, DEFAULT_ANGLE, xLoc, yLoc, widthRatio, heightRatio, smallestRatio);
		
		return base;
	}
	
	/**Generates a Unit with the statistics of a corporal. 
	 * It is displayed on the screen in a specified location with a given size and effect	 
	 * @param team team that this unit belongs to
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
	public static Unit createCorporal(int team, double height, double width, double angle, double xLoc, double yLoc,
			 double widthRatio, double heightRatio, double smallestRatio, Effect eff)
	{
		Unit corp = new Unit(team, CORP_HEALTH, CORP_ATT_RANGE, CORP_DMG, CORP_MOVE_RANGE, CORP_COST, CORP_ICON, CORP, CORP_TEXT);
		corp = (Unit)setImgView(corp, height, width, xLoc, yLoc, widthRatio, heightRatio, smallestRatio, eff);
		corp.updateCollShape(height, width, angle, xLoc, yLoc, widthRatio, heightRatio, smallestRatio);
		
		return corp;
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
	public static MoneyBag createMoneyBag(int value, double xLoc, double yLoc, double widthRatio, double heightRatio, double smallestRatio, Effect eff)
	{
		MoneyBag bag = new MoneyBag(value);
		bag = (MoneyBag)setImgView(bag, MONEY_SIZE * value / MAX_MONEY_BAG, MONEY_SIZE * value / MAX_MONEY_BAG,
				xLoc, yLoc, widthRatio, heightRatio, smallestRatio, eff);

		bag.updateCollShape( MONEY_SIZE * value / MAX_MONEY_BAG,  MONEY_SIZE * value / MAX_MONEY_BAG, DEFAULT_ANGLE, xLoc, yLoc, widthRatio, heightRatio, smallestRatio);
		
		return bag;
	}
	
	/**Generates a Unit with the statistics of a private. 
	 * It is displayed on the screen in a specified location with a given size and effect	 
	 * @param team team that the unit belongs to
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
	public static Unit createPrivate(int team, double height, double width, double angle, double xLoc, double yLoc,
			 double widthRatio, double heightRatio, double smallestRatio, Effect eff)
	{
		Unit priv = new Unit(team, PRIV_HEALTH, PRIV_ATT_RANGE, PRIV_DMG, PRIV_MOVE_RANGE, PRIV_COST, PRIVATE_ICON, PRIVATE, PRIVATE_TEXT);
		priv = (Unit)setImgView(priv, height, width, xLoc, yLoc, widthRatio, heightRatio, smallestRatio, eff);
		priv.updateCollShape(height, width, angle, xLoc, yLoc, widthRatio, heightRatio, smallestRatio);
		return priv;
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
		
		rect.setLayoutX(xLoc * widthRatio);
		rect.setLayoutY(yLoc * heightRatio);
		
		rect.setFill(col);
		rect.setEffect(eff);

		return rect;
	}
	
	/**Generates a Unit with the statistics of a scout. 
	 * It is displayed on the screen in a specified location with a given size and effect
	 * @param team team that the unit belongs to
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
	public static Unit createScout(int team, double height, double width, double angle, double xLoc, double yLoc,
			 double widthRatio, double heightRatio, double smallestRatio, Effect eff)
	{
		Unit scout = new Unit(team, SCOUT_HEALTH, SCOUT_ATT_RANGE, SCOUT_DMG, SCOUT_MOVE_RANGE, SCOUT_COST, SCOUT_ICON, SCOUT, SCOUT_TEXT);
		scout = (Unit)setImgView(scout, height, width, xLoc, yLoc, widthRatio, heightRatio, smallestRatio, eff);
		scout.updateCollShape(height, width, angle, xLoc, yLoc, widthRatio, heightRatio, smallestRatio);
		
		return scout;
	}
	
	/**Generates a Unit with the statistics of a sergeant. 
	 * It is displayed on the screen in a specified location with a given size and effect	
	 * @param team team that the unit belongs to
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
	public static Unit createSergeant(int team, double height, double width, double angle, double xLoc, double yLoc,
			 double widthRatio, double heightRatio, double smallestRatio, Effect eff)
	{
		Unit serg = new Unit(team, SERG_HEALTH, SERG_ATT_RANGE, SERG_DMG, SERG_MOVE_RANGE, SERG_COST, SERG_ICON, SERG, SERG_TEXT);
		serg = (Unit)setImgView(serg, height, width, xLoc, yLoc, widthRatio, heightRatio, smallestRatio, eff);
		serg.updateCollShape(height, width, angle, xLoc, yLoc, widthRatio, heightRatio, smallestRatio);
		
		return serg;
	}
	
	/**Generates a Unit with the statistics of a sniper. 
	 * It is displayed on the screen in a specified location with a given size and effect	 
	 * @param team team that the unit belongs to
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
	public static Unit createSniper(int team, double height, double width, double angle, double xLoc, double yLoc,
			 double widthRatio, double heightRatio, double smallestRatio, Effect eff)
	{
		Unit sniper = new Unit(team, SNIP_HEALTH, SNIP_ATT_RANGE, SNIP_DMG, SNIP_MOVE_RANGE, SNIP_COST, SNIPER_ICON, SNIPER, SNIPER_TEXT);
		sniper = (Unit)setImgView(sniper, height, width, xLoc, yLoc, widthRatio, heightRatio, smallestRatio, eff);
		sniper.updateCollShape(height, width, angle, xLoc, yLoc, widthRatio, heightRatio, smallestRatio);
		
		return sniper;
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
	
	/**Generates a Unit with the statistics of a tank. 
     * It is displayed on the screen in a specified location with a given size and effect	 
	 * @param team team that the unit belongs to
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
	public static Unit createTank(int team, double height, double width, double angle, double xLoc, double yLoc,
			 double widthRatio, double heightRatio, double smallestRatio, Effect eff)
	{
		Unit tank = new Unit(team, TANK_HEALTH, TANK_ATT_RANGE, TANK_DMG, TANK_MOVE_RANGE, TANK_COST, TANK_ICON, TANK, TANK_TEXT);
		tank = (Unit)setImgView(tank, height, width, xLoc, yLoc, widthRatio, heightRatio, smallestRatio, eff);
		tank.updateCollShape(height, width, angle, xLoc, yLoc, widthRatio, heightRatio, smallestRatio);
		
		return tank;
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
	
	/**Generates a text field on the screen with a given size, starting string, effect, and location.
	 * @param width width of the text field
	 * @param height height of the text field
	 * @param xLoc the x-coordinate of the text field
	 * @param yLoc the y-coordinate of the text field
	 * @param widthRatio the ratio of the user's desired width resolution to the highest possible screen width
	 * @param heightRatio the ratio of the user's desired height resolution to the highest possible screen height
	 * @param content the context field of the text 
	 * @param eff given visual effect
	 * @return the text field with the aforementioned settings
	 */
	public static TextField createTextField(double width, double height, double xLoc, double yLoc, double widthRatio, double heightRatio, String content, Effect eff)
	{
		TextField firstName = new TextField(content);
		firstName.setLayoutX(xLoc * widthRatio);
		firstName.setLayoutY(yLoc * heightRatio);
		firstName.setPrefWidth(width * widthRatio);
		firstName.setPrefHeight(height * heightRatio);
		firstName.setStyle("-fx-font: 20px \"Bookman Old Style\";");
		firstName.setEffect(eff);
		return firstName;
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
		
		imgV.setLayoutX(xLoc * widthRatio);
		imgV.setLayoutY(yLoc * heightRatio);

		return imgV;
	}
}
