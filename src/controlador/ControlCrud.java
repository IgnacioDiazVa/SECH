/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import javax.swing.JOptionPane;
import modelo.Socio;
import modelo.Universidad;
import vista.Crud;



/**
 *
 * @author Ignacio
 */
public class ControlCrud implements ActionListener{
    
    private Socio socios, nuevo;
    private Crud crud;
    private Universidad universidad;
    
    
    
    public ControlCrud (Socio socios, Crud crud){
        this.socios = socios;
        this.crud = crud;
        this.crud.btnAgregar.addActionListener(this);
        this.crud.btnReestablecer.addActionListener(this);
        this.crud.btnNuevoSocio.addActionListener(this); 
        this.crud.txtCelular.addActionListener(this);
        
        
//        this.crud.btnModificarSocio.addActionListener(this);
//        this.crud.btnNuevoPago.addActionListener(this);
//        this.crud.btnNuevoTiempo.addActionListener(this);
    }
     
    
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == crud.btnAgregar){
            socios.setRut(Integer.parseInt(crud.txtRut.getText()));
            socios.setCategoria(crud.cmbCategoria.getSelectedItem().toString());
            socios.setDigitoVerificador(crud.txtDigitoV.getText().charAt(0));
            socios.setNombres(crud.txtNombres.getText());
            socios.setApellidoPaterno(crud.txtAppPat.getText());
            socios.setApellidoMaterno(crud.txtAppMat.getText());
            socios.setCorreoElectronico(crud.txtCorreo.getText());
            socios.setCelular(crud.txtCelular.getText());
            socios.setSis(crud.cmbSis.getSelectedItem().toString());
            socios.setFilial(crud.cmbFilial.getSelectedItem().toString());
            
            socios.setEstado('a');
            socios.setAnioIngreso((Date) new java.util.Date());
            
            if(nuevo.agregar(socios)){
                JOptionPane.showMessageDialog(null, "Ingresado con éxito");
            }else{
                JOptionPane.showMessageDialog(null, "No se pudo agregar");
            }
            
        }
        
        if(e.getSource() == crud.btnReestablecer){
            limpiar();
        }
        
        
        
    }
    
    public void limpiar(){
        crud.txtNombres.setText(null);
        
    }
    
}
