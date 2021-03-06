package tp.tools.others;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ColorTools {
	
	public static Color BACKGROUND = new Color(51,61,81); 
	
	public static Color POINT_NONE = new Color(255, 255, 255);
	public static Color POINT_BEGIN = new Color(255, 45, 45);
	public static Color POINT_END = new Color(45, 0, 255);
	public static Color POINT_INTERSECT = new Color(45, 255, 45);
	public static Color POINT_ZONE = new Color (125, 45, 125);
	
	public static Color SEGMENT = new Color(25,25,25);

	public static Color getRandomColor() {

		Random generator = new Random();

		Color c = Color.getHSBColor(generator.nextFloat(), 1, 1);

		return c;
	}
	
}
