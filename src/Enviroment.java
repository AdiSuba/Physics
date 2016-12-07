import javax.swing.JFrame;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.awt.event.ActionEvent;
import java.util.HashMap;

public class Enviroment {
	Integer numberOfShapes;
	//The following are properties of the box that surrounds the objects - boundaries
	int startX;
	int startY;
	int sizeX;
	int sizeY;
	double angle;
	//
	HashMap<Integer, Object> shapes;
	HashMap<Integer, PhysicalAtributes> atributes;
	int timercount;
	
	Enviroment() {
		numberOfShapes = 0;
		shapes = new HashMap<Integer, Object>();
		atributes = new HashMap<Integer, PhysicalAtributes>();
		angle = 0;
		startX = 0; startY = 0;
		sizeX = 0; sizeY = 0; 
	}
	
	//with Attributes
	public void addObject(Object shape, PhysicalAtributes atribute) {
		numberOfShapes++;
		shapes.put(numberOfShapes, shape);
		atributes.put(numberOfShapes, atribute);
	}
	
	//with Speed
	public void addObject(Object shape, double vx, double vy) {
		numberOfShapes++;
		shape.set(startX + shape.getRealx(),startY +shape.getRealy());
		shapes.put(numberOfShapes, shape);
		PhysicalAtributes atribute = new PhysicalAtributes(vx, vy);
		atributes.put(numberOfShapes, atribute);
	}
	
	public void addObject(Object shape) {
		numberOfShapes++;
		shape.set(startX + shape.getRealx(),startY +shape.getRealy());
		shapes.put(numberOfShapes, shape);
		atributes.put(numberOfShapes, new PhysicalAtributes());
	}
	
	public void setSpeedOfCurrentObject(double vx, double vy) {
		PhysicalAtributes pa =  new PhysicalAtributes(vx, vy);
		atributes.remove(numberOfShapes);
		atributes.put(numberOfShapes, pa);
	}
	
	public void setSize(int x, int y) {
		sizeX = x; sizeY = y;
	}
	
	public void setStartOfEnvironment(int x, int y) {
		startX = x; startY = y;
	}
	
	public void setBoundaries(int x0, int y0, int sizex, int sizey) {
		startX = x0; startY = y0;
		sizeX = sizex; sizeY = sizey;
		
	}
	
	public void setAngle(double angle) {
		this.angle = Math.toRadians(angle);
	}
	
	public boolean checkCollisionWithEdgeX(Object o, double vx, double vy) {
		if(o instanceof Circle) {
			double[] distance = getDistanceFromEdge(o, vx, vy);
			if(distance[0] < Math.abs(vx)) 
				return true;
		}
		return false;
	}
	
	public boolean checkCollisionWithEdgeY(Object o, double vx, double vy) {
		if(o instanceof Circle) {
			double[] distance = getDistanceFromEdge(o, vx, vy);
			if(distance[1] < Math.abs(vy) ) 
				return true;
		}
		return false;
	}
	
	public double[] getDistanceFromEdge(Object o, double vx, double vy) {
		//Returns closest distance to edge for x and y axes
		int x = o.getx();
		int y = o.gety(), r = o.getRadius();
		double distanceX, distanceY;
		if(vx > 0) {
			distanceX = (startX + sizeX - x - r)*(1 + Math.tan(angle)*(sizeY - y)/x);
		}
		else distanceX = (x - startX)*(1 + Math.tan(angle)*(sizeY - y)/x);
		if(vy > 0) {
			distanceY = (startY + sizeY - y - r)*(1 + Math.tan(angle)*x/y);
		}
		else distanceY = (y - startY)*(1 + Math.tan(angle)*y/x);
		
		double[] distance =  new double[]{distanceX, distanceY};
		return distance;
	}
	
	public void Simulate() {
		Timer timer = new Timer(10,new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
			//System.out.println("timercount :"+timercount);
            //timercount++;
            for(int i = 1; i <= numberOfShapes; i++) {
            	Object o = shapes.get(i);
            	PhysicalAtributes pa = atributes.get(i);
            	double x = o.getRealx(), y = o.getRealy();
            	double vx = pa.getHorizontalSpeed();
            	double vy = pa.getVerticalSpeed();
            	double[] distance = getDistanceFromEdge(o, vx, vy);
            	if(checkCollisionWithEdgeX(o, vx, vy)) {
            		pa.setHorizontalSpeed(-vx);
            		int dx = (int)distance[0];
            		o.setx(x - vx + dx);
            	}
            	else o.setx(x + vx);
            	if(checkCollisionWithEdgeY(o, vx, vy)) {
            		pa.setVerticalSpeed(-vy);
            		int dy = (int)distance[1];
            		o.sety(y - vy + dy);
            	}
            	else o.sety(y + vy);
            }
            }
        });
		timer.start();
	}
	
}
