import javax.swing.JFrame;
import javax.swing.Timer;
import java.awt.event.ActionListener;
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
	
	//with Atributes
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
	
	public boolean checkCollisionWithEdge(Object o) {
		int x = o.getx();
		int y = o.gety();
		if(o instanceof Circle) {
			int r = o.getRadius();
			if(x <= 0 || y <= 0 || x + r >= sizeX || y + r >= sizeY) 
				return true;
		}
		return false;
	}
	
	public void Simulate() {
		Timer timer = new Timer(10,new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
			System.out.println("timercount :"+timercount);
            timercount++;
            for(int i = 1; i <= numberOfShapes; i++) {
            	Object o = shapes.get(i);
            	PhysicalAtributes pa = atributes.get(i);
            	double x = o.getRealx(), y = o.getRealy();
            	double vx = pa.getHorizontalSpeed();
            	double vy = pa.getVerticalSpeed();
            	o.setx(x + vx);
            	if(checkCollisionWithEdge(o)) {
            		pa.setHorizontalSpeed(-vx);
            		o.setx(x - 2*vx);
            	}
            	o.sety(y + vy);
            	if(checkCollisionWithEdge(o)) {
            		pa.setVerticalSpeed(-vy);
            		o.sety(y - 2*vy);
            	}
            }
            }
        });
		timer.start();
	}
	
}
