import java.awt.Graphics2D;

public class Object {
	
	//x and y coordinates represent the top left corner of the objects bounding box
	//bounding box - a rectangle that completely encloses an object
	private double x;
	private double y;
	
	public Object(int X, int Y) {
		x = X;
		y = Y;
	}

	public Object(Object object) {
		x = object.getx();
		y = object.gety();
	}
	
	public void set(int X, int Y) {
		x = X;
		y = Y;
	}

	public void set(double X, double Y) {
		x = X;
		y = Y;
	}
	
	public void setx(double X) {
		x = X;
	}
	
	public void sety(double Y) {
		y = Y;
	}
	
	public int getx() {
		return (int)x;
	}
	
	public int gety() {
		return (int)y;
	}
	
	public double getRealx() {
		return x;
	}
	
	public double getRealy() {
		return y;
	}
	
	public int getRadius() {
		return 0;
	}
	
	public void draw(Graphics2D o) {
		
	}

}
