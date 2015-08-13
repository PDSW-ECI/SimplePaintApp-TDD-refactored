package edu.eci.arsw.samples;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.jacksoft.paintmodel.Model;

import com.datasoft.dataloader.DataLoadException;
import com.datasoft.dataloader.PointsDataLoader;




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
	
	Model m;
	
	public MainFrame() {
		super("LINE PAINT");
		m=new Model();
		undoButton=new JButton("UNDO");
		redoButton=new JButton("REDO");
		loadDataButton=new JButton("Load data");
		
		view = new View(m);
		
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
						Class.forName("com.mysql.jdbc.Driver");
						Connection connect = DriverManager
								.getConnection("jdbc:mysql://desarrollo.is.escuelaing.edu.co/bdprueba?"
										+ "user=bdprueba&password=bdprueba");

						
						m=new Model(new PointsDataLoader(connect));
						connect.close();
					} catch (DataLoadException e1) {						
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, e1.getLocalizedMessage());
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, e1.getLocalizedMessage());
					} catch (SQLException e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, e1.getLocalizedMessage());
					}					
					getContentPane().remove(view);
					repaint();
					view = new View(m);
					view.setSize(300,300);
					view.setLocation(new Point(10,10));
					getContentPane().add(view);
					repaint();
					
				}				
			}
		);

		
	
	}

	public static void main(String[] args) {
		MainFrame mf=new MainFrame();
		mf.setVisible(true);
	}
	
}
