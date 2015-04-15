package tp.tools;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Point2D extends StructureGeometrique implements Comparable {

	private int x;
	private int y;
	
	private RolePoint role;
	private Color color;
	
	public Point2D(int x, int y) {
		super("");
		this.x = x;
		this.y = y;
		setRole(RolePoint.NONE);
		this.color = ColorTools.POINT_NONE;
	}
	
	public Point2D(int x, int y, RolePoint role) {
		super("");
		this.x = x;
		this.y = y;
		setRole(role);
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public RolePoint getRole() {
		return role;
	}
	
	public void setRole(RolePoint role) {
		this.role = role;
		
		switch(role){
			case BEGIN: 
				color = ColorTools.POINT_BEGIN;
			case INTERSECT:
				color = ColorTools.POINT_INTERSECT;
			case END:
				color = ColorTools.POINT_END;
			case ZONE:
				color = ColorTools.POINT_ZONE;
			default :
				color = ColorTools.POINT_NONE;
		}
	}
	
	public Color getColor() {
		return color;
	}
	
	public void draw(Graphics2D g2d) {
		g2d.setColor(color);
		Rectangle r = new Rectangle((int)x, (int)y, 3, 3);
		g2d.fill(r);
		drawName(g2d);
	}
	
	public void drawName(Graphics2D g2d) {
		FontMetrics fm = g2d.getFontMetrics();
		int centeredText = (int) (x - fm.stringWidth(getName())/2 + fm.stringWidth("_"));
		g2d.drawString(getName(), centeredText, (int) (y-2));		
	}
	
    public static boolean isLeft(Point2D a, Point2D b, Point2D c) {
        return ( (b.x-a.x)*(c.y-a.y) - (b.y-a.y)*(c.x-a.x) ) >= 0;
    }

	public int distance (Point2D p) {
		
		int X = (int) ((p.getX() - this.getX()) * (p.getX() - this.getX()));
		int Y = (int) ((p.getY() - this.getY()) * (p.getY() - this.getY()));
		
		return (int) Math.sqrt(X + Y);
	}
	
	public boolean isInFirstX (Point2D p) {
		return this.getX() < p.getX();
	}

	@Override
	public int compareTo(Object o) {
        Point2D other = (Point2D) o;
        int otherX = other.getX();
        if (this.x < otherX)  return -1;
        else if(this.x == otherX) return 0;
        else return 1;
	}
	
}