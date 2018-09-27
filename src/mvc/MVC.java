/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc;

import controlador.ControlCrud;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import modelo.Laboral;
import modelo.Socio;
import modelo.Universidad;
import vista.Crud;

/**
 *
 * @author Ignacio
 */
public class MVC {
    
    public static void main(String[] args) throws ParseException{
        
        Socio socios = new Socio();
        Socio nuevo = new Socio();
        Crud crud = new Crud();
        Universidad uni = new Universidad();
        Laboral lab = new Laboral();
        
        ControlCrud ctrl = new ControlCrud(socios, crud, nuevo, uni, lab);
        ctrl.iniciar();
        crud.setVisible(true);

        
       
        
    }
    
}
