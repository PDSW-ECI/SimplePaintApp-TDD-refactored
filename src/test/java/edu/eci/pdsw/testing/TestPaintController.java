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
package edu.eci.pdsw.testing;

import edu.eci.pdsw.samples.controller.SimplePaintAppController;
import edu.eci.pdsw.samples.view.Line;
import java.awt.Container;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author hcadavid
 */
public class TestPaintController {
    
    SimplePaintAppController ctrl;
    
    public TestPaintController() {
    }
    
    @Before
    public void setUp() {        
        ctrl=new SimplePaintAppController(new Container());
    }
    
    @Test
    public void testDibujoBasico(){
        ctrl.addLine(new Line(0,0,100,100));
        ctrl.addLine(new Line(10,10,100,100));
        
        assertTrue("El número de líneas dentro del modelo no es consistente tras agregar dos a un modelo vacío.",ctrl.getModel().getLines().size()==2);
        assertTrue("No se encontró uno de los segmentos de recta agregados al modelo vacío.",ctrl.getModel().getLines().contains(new Line(0,0,100,100)));
        assertTrue("No se encontró uno de los segmentos de recta agregados al modelo vacío.", ctrl.getModel().getLines().contains(new Line(10,10,100,100)));
        
    }
    
    
}
