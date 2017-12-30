package appLayer.Drawing;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class DrawingPanel extends JPanel{
	/**
	 * Template Pattern, paintComponent is a hook
	 */
	private static final long serialVersionUID = 1L;
	private Queue<ClassComponent> components;
	private Queue<RelationshipComponent> lines;
	
	public DrawingPanel(){
		components = new LinkedList<ClassComponent>();
		lines = new LinkedList<RelationshipComponent>();
	}
	
	public void addClass(ClassComponent component){
		components.add(component);
		repaint();
	}
	
	public void removeClass(ClassComponent component){
		components.remove(component);
		repaint();
	}
	
	public void addLine(RelationshipComponent line){
		lines.add(line);
		repaint();
	}
	
	public void removeLine(RelationshipComponent line){
		lines.remove(line);
		repaint();
	}
	
	public void clearObjects() {
		lines.clear();
		components.clear();
	}
	
	@SuppressWarnings("unchecked")
	public void setObjects(Object obj[]){
		components = (Queue<ClassComponent>) obj[0];
		lines = (Queue<RelationshipComponent>) obj[1];
	}
	
	public Object[] getObjects(){
		Object obj[] = {components, lines};
		return obj;
	}
	
	public void paintComponent (Graphics g){
		super.paintComponent(g);
		removeAll();
		
		drawClasses();
		
		drawLines(g);
	}
	
	private void drawClasses(){
		for(ClassComponent c : this.components){
			JLabel label = new JLabel(c.getName());
			int x = (int) c.getX();
			int y = (int) c.getY();
			label.setHorizontalAlignment(JLabel.CENTER);
			label.setSize(100, 50);
			label.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
			label.setBackground(Color.WHITE);
			label.setOpaque(true);
			// Adjustments are made so location is on the center of box
			label.setLocation(x-50, y-25);
			add(label);
		}
	}
	
	private void drawLines(Graphics g){
		for(RelationshipComponent line : lines){
			int x1 = (int)line.getStart().getX();
			int y1 = (int)line.getStart().getY();
			int x2 = (int)line.getEnd().getX();
			int y2 = (int)line.getEnd().getY();

	        Graphics2D g2d = (Graphics2D) g.create();
			
			switch(line.getLineType().trim().toUpperCase()){
				case "BIN":
					g.drawLine(x1, y1, x2, y2);
					break;
				case "GENSPE":
					g.drawLine(x1, y1, x2, y2);
			        int xGen[] = {x2-10, x2-10, x2};
			        int yGen[] = {y2+10, y2-10, y2};
			        g2d.drawPolygon(xGen, yGen, 3);
			        g2d.dispose();
					break;
				case "DEP":
					//Dashed lines source: https://stackoverflow.com/questions/21989082/drawing-dashed-line-in-java
			        Stroke dashed = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
			        g2d.setStroke(dashed);
			        g2d.drawLine(x1, y1, x2, y2);
			        int xDep[] = {x2-10 , x2, x2-10,x2};
			        int yDep[] = {y2+10, y2, y2-10,y2};
			        g2d.drawPolygon(xDep, yDep, 4);
			        g2d.dispose();
					break;
				case "AGG":
					g.drawLine(x1, y1, x2-10, y2);
					int xAgg[] = {x2-10, x2, x2+10, x2};
			        int yAgg[] = {y2, y2+10, y2, y2-10};
			        g2d.drawPolygon(xAgg, yAgg, 4);
			        g2d.dispose();
					break;
				case "COMP":
					g.drawLine(x1, y1, x2-10, y2);
					int xCom[] = {x2-10, x2, x2+10, x2};
			        int yCom[] = {y2, y2+10, y2, y2-10};
			        g2d.drawPolygon(xCom, yCom, 4);
			        g2d.fillPolygon(xCom, yCom, 4);
			        g2d.dispose();
					break;
				default:
					break;
			}
		}
	}

}
