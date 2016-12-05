
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
	public void paint(Graphics g) {
		super.paintComponent(g);
		this.setBackground(Color.WHITE );
		repaint();
		for(Object o : objects) {
			o.draw((Graphics2D)g);
		}
//	g.setColor(Color.BLACK);
//	g.fillRect(45, 50, 25, 25);
  }
	public static void main(String[] a) {
		
	}   
}