package edu.eci.arsw.samples;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import org.jacksoft.paintmodel.Model;



/**
 * 
 * @author hcadavid@ECI
 *
 */
public class PaintMouseListener implements MouseListener, MouseMotionListener {



	DrawLineState state=DrawLineState.READY_FOR_FIRST_POINT;
	Point firstPoint;
	Model model;
	View view;
	
	
	public PaintMouseListener(Model m,View v) {
		super();
		model=m;
		view=v;
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		if (state==DrawLineState.READY_FOR_FIRST_POINT){
			firstPoint=new Point(e.getX(),e.getY());
			state=DrawLineState.FIRST_POINT_SELECTED;
		}
		else if (state==DrawLineState.FIRST_POINT_SELECTED){
			model.addLine(new Line(e.getX(),e.getY(),(int)firstPoint.getX(),(int)firstPoint.getY()));
			view.repaint();
			state=DrawLineState.READY_FOR_FIRST_POINT;
		}
		
		
	}


	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseMoved(MouseEvent e) {
		
		if (state==DrawLineState.FIRST_POINT_SELECTED){
			view.setTemporalLine(new Line((int)firstPoint.getX(),(int)firstPoint.getY(),(int)e.getX(),(int)e.getY()));
			view.repaint();
		}
	}
}
