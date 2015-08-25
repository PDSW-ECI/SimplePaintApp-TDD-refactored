/*
 * Copyright (C) 2015 hcadavid
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.eci.pdsw.samples.controller;

import com.datasoft.dataloader.DataLoadException;
import com.datasoft.dataloader.PointsDataLoader;
import edu.eci.pdsw.samples.view.Line;
import edu.eci.pdsw.samples.view.PaintMouseListener;
import edu.eci.pdsw.samples.view.View;
import edu.eci.pdsw.samples.view.model.Model;
import java.awt.Container;
import java.awt.Point;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author hcadavid
 */
public class SimplePaintAppController {
    
    private Model model=null;
    
    private Container viewContainer=null;

    public SimplePaintAppController(Container v) {
        model=new Model();    
        this.viewContainer=v;
    }
    
    public Model getModel(){
        return model;
    }

    public Container getViewContainer() {
        return viewContainer;
    }
    
    
    /**
     * DOCUMENTAR
     */
    public void deshacerAccion() throws ModelException{
        //IMPLEMENTAR PRUEBAS ANTES DE IMPLEMENTAR CÓDIGO!
    }
    
    /**
     * DOCUMENTAR
     */
    public void rehacerAccion() throws ModelException{
        //IMPLEMENTAR PRUEBAS ANTES DE IMPLEMENTAR CÓDIGO!
    }

    /**
     * Obj: rotar el modelo actual de la herramienta de dibujo
     * @param xorigen eje X del punto de referencia para la rotación
     * @param yorigen eje Y del punto de referencia para la rotación
     * @param anguloRad ángulo de rotación, en radianes.
     */
    public void rotar(int xorigen, int yorigen, int anguloRad){
        //IMPLEMENTAR PRUEBAS ANTES DE IMPLEMENTAR CÓDIGO!
    }
    
    
    /**
     * Obj: Agrega una línea al modelo
     * @param l  la línea a ser agregada
     * @pre l no puede ser nulo
     */
    public void addLine(Line l){
        model.addLine(l);
        viewContainer.repaint();               
    }
   
    
    public void loadDataFromDatabase() throws DataLoadException {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = DriverManager
                    .getConnection("jdbc:mysql://desarrollo.is.escuelaing.edu.co/bdprueba?"
                            + "user=bdprueba&password=bdprueba");

            model = new Model(new PointsDataLoader(connect));
            connect.close();

            viewContainer.removeAll();
            viewContainer.repaint();
            View view = new View(model,new PaintMouseListener(this));
            
            view.setSize(300, 300);
            view.setLocation(new Point(10, 10));
            viewContainer.add(view);
            viewContainer.repaint();

        } catch (DataLoadException e1) {
            throw new DataLoadException("Error on data loading.", e1);
        } catch (ClassNotFoundException e1) {
            throw new DataLoadException("Error on data loading.", e1);
        } catch (SQLException e1) {
            throw new DataLoadException("Error on data loading.", e1);
        }

    }


}
