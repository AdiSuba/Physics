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
		Rectangle rec = new Rectangle(0, 0, 500, 500);
		d.addObject(rec);
		d.addObject(o1);
		d.addObject(o2);
		d.addObject(o3);
		Enviroment e = new Enviroment();
		e.addObject(o1, 5, 3);
		e.addObject(o2, 2, 1);
		e.addObject(o3, -0.5, 0.25);
		f.add(d);
		f.setSize(500, 500);
		f.setVisible(true);
		e.setSize(500, 500);
		e.Simulate();
	}

}
