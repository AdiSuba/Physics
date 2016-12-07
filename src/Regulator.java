import javax.swing.JFrame;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.BasicStroke;
import java.awt.event.ActionEvent;

public class Regulator {
	
	int timercount;

	public static void main(String[] args) {
		JFrame f = new JFrame("Physics Engine");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Display d = new Display();
		Circle o1 = new Circle(250, 250, 50);
		Circle o2 = new Circle(280, 50, 25);
		Circle o3 = new Circle(50, 400, 25);
		int x0 = 300, y0 = 300, sizeX = 500, sizeY = 500;
		double angle = 15;
		Rectangle rec1 = new Rectangle(x0, y0, 0, sizeX, sizeY);
		d.addObject(rec1);
		Rectangle rec = new Rectangle(x0, y0, angle, sizeX, sizeY);
		d.addObject(rec);
		d.addObject(o1);
		d.addObject(o2);
		d.addObject(o3);
		Enviroment e = new Enviroment();
		e.setBoundaries(x0, y0, sizeX, sizeY);
		e.setAngle(angle);
		e.addObject(o1, 5, 3);
		e.addObject(o2, 8, 25);
		e.addObject(o3, -0.5, 0.25);
		f.add(d);
		f.setSize(500, 500);
		f.setVisible(true);
		e.setSize(500, 500);
		e.Simulate();
	}

}
