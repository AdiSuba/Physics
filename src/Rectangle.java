import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.Rectangle2D;

public class Rectangle extends Object{
	//x2 and y2 represent the bottom left corner of the rectangle
	int x2;
	int y2;
	public Rectangle(int X, int Y, double deg, int width, int height) {
		super(X, Y, deg);
		x2 = this.getx() + width;
		y2 = this.gety() + height;
	}
	
	public void setWidth(int width) {
		x2 = this.getx() + width;
	}
	
	public int getWidth() {
		return x2 - this.getx();
	}
	
	public void setHeight(int height) {
		y2 = this.gety() + height;
	}
	
	public int getHeight() {
		return y2 - this.gety();
	}
	
	public int[] getCentralDistance() {
		return new int[] {(x2 - this.getx())/2, ((y2 - this.gety())/2)};
	}
	
	public void draw(Graphics2D g) {
		g.setStroke(new BasicStroke(2.0f));
		g.draw(new Rectangle2D.Double(this.getx(), this.gety(), x2 - this.getx(), y2 - this.gety()));
	}
	
	public void draw(Graphics2D g, Stroke s) {
		g.setStroke(s);
		g.draw(new Rectangle2D.Double(this.getx(), this.gety(), x2 - this.getx(), y2 - this.gety()));
	}

}
