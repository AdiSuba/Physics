import java.awt.Graphics2D;

public abstract class Object {
	
	//x and y coordinates represent the top left corner of the objects bounding box
	//bounding box - a rectangle that completely encloses an object
	private double x;
	private double y;
	private double angle; //in radians, entered in degrees
	
	public Object(int X, int Y) {
		x = X;
		y = Y;
		angle = 0;
	}
	
	public Object(int X, int Y, double deg) {
		x = X;
		y = Y;
		angle = Math.toRadians(deg);
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
	
	public void set(int X, int Y, double deg) {
		x = X;
		y = Y;
		angle = Math.toRadians(deg);
	}
	
	public void set(double X, double Y, double deg) {
		x = X;
		y = Y;
		angle = deg;
	}
	
	public void setx(double X) {
		x = X;
	}
	
	public void sety(double Y) {
		y = Y;
	}
	
	public void setAngle(double angle) {
		this.angle = angle;
	}
	
	public int getx() {
		return (int)x;
	}
	
	public int gety() {
		return (int)y;
	}
	
	public double getAngle() {
		return angle;
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
	
	public void increase(double dx, double dy) {
		x += dx;
		y += dy;
	}
	
	public abstract int[] getCentralDistance();
	
	public void draw(Graphics2D o) {
		
	}

}
