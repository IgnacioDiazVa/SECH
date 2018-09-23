/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc;

import controlador.ControlCrud;
import modelo.Socio;
import vista.Crud;

/**
 *
 * @author Ignacio
 */
public class MVC {
    
    public static void main(String[] args){
        
        Socio socios = new Socio();
        Socio nuevo = new Socio();
        Crud crud = new Crud();
        
        ControlCrud ctrl = new ControlCrud(socios, crud, nuevo);
        ctrl.iniciar();
        crud.setVisible(true);

//        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        System.out.println("Fecha: "+dateFormat.format(date));
        
    }
    
}
