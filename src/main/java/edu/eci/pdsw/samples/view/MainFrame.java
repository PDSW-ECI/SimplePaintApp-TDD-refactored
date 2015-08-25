package edu.eci.pdsw.samples.view;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import edu.eci.pdsw.samples.controller.SimplePaintAppController;
import java.util.logging.Level;
import java.util.logging.Logger;




/**
 * 
 * @author hcadavid@ECI
 *
 */
public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	View view=null;
	JButton undoButton=null;
	JButton redoButton=null;
	JButton loadDataButton=null;
		
        SimplePaintAppController controller=null;        
        
	public MainFrame() {
		super("LINE PAINT");
                controller=new SimplePaintAppController(getContentPane());
        
                undoButton=new JButton("UNDO");
		redoButton=new JButton("REDO");
		loadDataButton=new JButton("Load data");
		
		view = new View(controller.getModel(),new PaintMouseListener(controller));
		
		this.setLayout(null);
		view.setSize(300,300);
		view.setLocation(new Point(10,10));
		
		this.setSize(350,400);
		
		this.getContentPane().add(view);
		
		undoButton.setLocation(10,320);
		undoButton.setSize(100,40);
		this.getContentPane().add(undoButton);

		redoButton.setLocation(120,320);
		redoButton.setSize(100,40);
		this.getContentPane().add(redoButton);

		loadDataButton.setLocation(230,320);
		loadDataButton.setSize(100,40);
		this.getContentPane().add(loadDataButton);
		
		//evento del boton Load Data
		loadDataButton.addActionListener(
			new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
                                    try {
                                        controller.loadDataFromDatabase();

                                    } catch (Exception ex) {
                                        Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                                        JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
                                    }
				}				
			}
		);

		
	
	}

	public static void main(String[] args) {
		MainFrame mf=new MainFrame();
		mf.setVisible(true);
	}
	
}
