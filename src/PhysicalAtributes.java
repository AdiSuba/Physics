
public class PhysicalAtributes {
	double vx;	//velocity on x axis +right	-left
	double vy;	//velocity on y axis +down	-up
	
	PhysicalAtributes() {
		vx = 0;
		vy = 0;
	}
	
	PhysicalAtributes(double vX, double vY) {
		vx = vX;
		vy = vY;
	}
	
	public void setSpeed(double vX, double vY) {
		vx = vX;
		vy = vY;
	}
	
	public void setHorizontalSpeed(double vX) {
		vx = vX;
	}
	
	public void setVerticalSpeed(double vY) {
		vy = vY;
	}
	
	public double getHorizontalSpeed() {
		return vx;
	}
	
	public double getVerticalSpeed() {
		return vy;
	}
	
	public void increaseSpeed(double vX, double vY) {
		vx += vX;
		vy += vY;
	}
}