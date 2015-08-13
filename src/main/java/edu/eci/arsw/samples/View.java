package edu.eci.arsw.samples;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

import org.jacksoft.paintmodel.Model;


/**
 * 
 * @author hcadavid@ECI
 *
 */
public class View extends JComponent{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Model model;
	PaintMouseListener controller;
	Line temporalLine=null;

	public View(Model model) {
		super();
		this.model = model;
		controller=new PaintMouseListener(model,this);
		addMouseListener(controller);
		addMouseMotionListener(controller);
	}

	public void setTemporalLine(Line l){
		this.temporalLine=l;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());

		if (temporalLine!=null){
			g.setColor(Color.GREEN);
			g.drawLine(temporalLine.getX1(), temporalLine.getY1(), temporalLine.getX2(), temporalLine.getY2());			
			temporalLine=null;
		}

		
		g.setColor(Color.BLACK);
		for (Line l:model.getLines()){
			g.drawLine(l.getX1(), l.getY1(), l.getX2(), l.getY2());
		}
	}
	
	
}
