
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JComponent;

class Display extends JComponent {
	
	ArrayList<Object> objects; 
	
	Display() {
		objects =  new ArrayList<Object>();
	}
	
	public void addObject(Object o) {
		objects.add(o);
	}
	public void removeObject(Object o) {
		objects.remove(o);
	}
	public void drawObject(Graphics2D g2d, Object o) {
		int x0 = o.getx(), y0 = o.gety();
		int xMid = o.getCentralDistance()[0];
		int yMid = o.getCentralDistance()[1];
		//g2d.rotate(o.getAngle());
		g2d.rotate(o.getAngle(), x0 + xMid, y0 + yMid);
		System.out.println("ang :"+ o.getAngle());
		o.draw(g2d);
		g2d.dispose();
//		g2d.rotate(-2*o.getAngle(), x0 + xMid, y0 + yMid);
//		System.out.println("ang2 :"+ o.getAngle());
		//g2d.rotate(-o.getAngle());
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(Color.WHITE );
		Graphics2D g2d= (Graphics2D)(g);
		repaint();
		for(Object o : objects) {
			g2d = (Graphics2D) g.create();
			drawObject(g2d, o);
			g2d.rotate(o.getAngle());
		}
//	g.setColor(Color.BLACK);
//	g.fillRect(45, 50, 25, 25);
  }
	public static void main(String[] a) {
		
	}   
}