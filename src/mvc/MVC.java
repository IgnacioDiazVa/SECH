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
import java.sql.Date;
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
        

        String categoria = "activo";
                           String filial = "Santiago";
                           int anioPasado=2017;
                           int anio=2018;
                           
                           
                           
                           Integer.toString(anio);
                           Integer.toString(anioPasado);
                           Date antesD = Date.valueOf(anioPasado+"-10-31");
                           Date marzo = Date.valueOf(anio+"-03-01");
                           Date mayo = Date.valueOf(anio+"-05-31");
                           Date noviembre = Date.valueOf(anioPasado+"-11-01");
                           Date febrero = Date.valueOf(anio+"-02-29");
                           
                           ctrlHo.junOct(home.jtDatosHome, categoria, filial, anio, anioPasado, antesD, marzo, mayo, noviembre, febrero);

       
    }
       
    

    
}
