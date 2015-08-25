package edu.eci.pdsw.samples.view.model;

import java.util.LinkedList;

import com.datasoft.dataloader.LineDescriptor;
import com.datasoft.dataloader.PointsDataLoader;


import edu.eci.pdsw.samples.view.Line;

public class Model {

	private java.util.LinkedList<Line> lines;

	public Model() {
		super();
		lines=new LinkedList<Line>();
	}

	public Model(PointsDataLoader pdl) {
		super();
		lines=new LinkedList<Line>();
		while (pdl.hasMoreDataPoints()){
			LineDescriptor ld=pdl.getNextDataPoint();
			lines.add(new Line(ld.getX1(),ld.getY1(),ld.getX2(),ld.getY2()));
		}
	}
	
	public void addLine(Line l){
		lines.add(l);
	}

	public java.util.LinkedList<Line> getLines() {
		return lines;
	}
	
	
}
