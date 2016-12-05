import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class Circle extends Object{
	
	int radius;
	
	public Circle(int X, int Y, int r) {
		super(X, Y);
		radius = r;
	}
	
	public void setRadius(int r) {
		radius = r;
	}
	
	public int getRadius() {
		return radius;
	}
	
	public void draw(Graphics2D g) {
		g.setStroke(new BasicStroke(2.0f));
		g.draw(new Ellipse2D.Double(this.getx(), this.gety(),radius,radius));
	}
}
