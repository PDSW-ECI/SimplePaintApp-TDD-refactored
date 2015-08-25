package edu.eci.pdsw.samples.view;

import edu.eci.pdsw.samples.controller.SimplePaintAppController;
import edu.eci.pdsw.samples.view.model.DrawLineState;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import edu.eci.pdsw.samples.view.model.Model;



/**
 * 
 * @author hcadavid@ECI
 *
 */
public class PaintMouseListener implements MouseListener, MouseMotionListener {



	DrawLineState state=DrawLineState.READY_FOR_FIRST_POINT;
	Point firstPoint;
        SimplePaintAppController ctrl;
       
        
	
	public PaintMouseListener(SimplePaintAppController ctrl) {
		super();
		this.ctrl=ctrl;
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		if (state==DrawLineState.READY_FOR_FIRST_POINT){
			firstPoint=new Point(e.getX(),e.getY());
			state=DrawLineState.FIRST_POINT_SELECTED;
		}
		else if (state==DrawLineState.FIRST_POINT_SELECTED){
			ctrl.addLine(new Line(e.getX(),e.getY(),(int)firstPoint.getX(),(int)firstPoint.getY()));			
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
			((View)ctrl.getViewContainer().getComponent(0)).setTemporalLine(new Line((int)firstPoint.getX(),(int)firstPoint.getY(),(int)e.getX(),(int)e.getY()));
			ctrl.getViewContainer().repaint();
		}
	}
}
