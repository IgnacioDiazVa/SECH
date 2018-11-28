/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc;

import controlador.ControlCrud;
import controlador.ControlCrudEstado;
import controlador.ControlCrudModi;
import controlador.ControlCrudPago;
import controlador.ControlHome;
import java.text.ParseException;
import java.util.Calendar;
import modelo.Actividad;
import modelo.CuotaSocial;
import modelo.Laboral;
import modelo.Socio;
import modelo.Universidad;
import vista.Crud;
import vista.Home;

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
        Actividad actividad = new Actividad();
        CuotaSocial cuota = new CuotaSocial();
        Home home = new Home();
        
        ControlCrud ctrl = new ControlCrud(socios, crud, nuevo, uni, lab);
        ControlCrudModi ctrlMod = new ControlCrudModi(socios, crud, lab, nuevo);
        ControlCrudEstado ctrlEs = new ControlCrudEstado(crud, actividad, socios);
        ControlCrudPago ctrlPa = new ControlCrudPago(crud, socios, nuevo, cuota);
        ControlHome ctrlHo = new ControlHome(home, nuevo, cuota, uni, lab);
        ctrlHo.iniciar();
        home.setVisible(true);
        

//        Calendar calendario = Calendar.getInstance();
//        int anio = calendario.get(Calendar.MONTH);
//        System.out.println(anio);
//        
          
        
    }
    
}
