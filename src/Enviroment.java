import javax.swing.JFrame;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.awt.event.ActionEvent;
import java.util.HashMap;

public class Enviroment {
	Integer numberOfShapes;
	int sizeX;
	int sizeY;
	HashMap<Integer, Object> shapes;
	HashMap<Integer, PhysicalAtributes> atributes;
	int timercount;
	
	Enviroment() {
		numberOfShapes = 0;
		shapes = new HashMap<Integer, Object>();
		atributes = new HashMap<Integer, PhysicalAtributes>();
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
		shapes.put(numberOfShapes, shape);
		PhysicalAtributes atribute = new PhysicalAtributes(vx, vy);
		atributes.put(numberOfShapes, atribute);
	}
	
	public void addObject(Object shape) {
		numberOfShapes++;
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
	
	public boolean checkCollisionWithEdgeX(Object o, double vx, double vy) {
		if(o instanceof Circle) {
			int[] distance = getDistanceFromEdge(o, vx, vy);
			if(distance[0] < Math.abs(vx)) 
				return true;
		}
		return false;
	}
	
	public boolean checkCollisionWithEdgeY(Object o, double vx, double vy) {
		if(o instanceof Circle) {
			int[] distance = getDistanceFromEdge(o, vx, vy);
			if(distance[1] < Math.abs(vy) ) 
				return true;
		}
		return false;
	}
	
	public int[] getDistanceFromEdge(Object o, double vx, double vy) {
		//Returns closest distance to edge for x and y axes
		int x = o.getx(), distanceX;
		int y = o.gety(), distanceY, r = o.getRadius();
		if(vx > 0) {
			distanceX = sizeX - x - r;
		}
		else distanceX = x;
		if(vy > 0) {
			distanceY = sizeY - y - r;
		}
		else distanceY = y;
		
		int[] distance =  new int[]{distanceX, distanceY};
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
            	int[] distance = getDistanceFromEdge(o, vx, vy);
    			System.out.println("dx :"+ distance[0]);
            	if(checkCollisionWithEdgeX(o, vx, vy)) {
            		pa.setHorizontalSpeed(-vx);
            		int dx = distance[0];
            		o.setx(x - vx + dx);
            	}
            	else o.setx(x + vx);
            	if(checkCollisionWithEdgeY(o, vx, vy)) {
            		pa.setVerticalSpeed(-vy);
            		int dy = distance[1];
            		o.sety(y - vy + dy);
            	}
            	else o.sety(y + vy);
            }
            }
        });
		timer.start();
	}
	
}
