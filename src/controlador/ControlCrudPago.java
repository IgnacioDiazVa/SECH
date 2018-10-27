/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.CuotaSocial;
import modelo.Socio;
import vista.Crud;

/**
 *
 * @author Ignacio
 */
public class ControlCrudPago {
    
    private Crud crud;
    private Socio socios, nuevo;
    private CuotaSocial cuota;
    
    public ControlCrudPago (Crud crud, Socio socios, Socio nuevo, CuotaSocial cuota){
        this.crud = crud;
        this.socios = socios;
        this.nuevo = nuevo;
        this.cuota = cuota;
    }
}
