/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.CuotaSocial;
import modelo.Socio;
import vista.Crud;

/**
 *
 * @author Ignacio
 */
public class ControlCrudPago implements ActionListener {
    
    private Crud crud;
    private Socio socios, nuevo;
    private CuotaSocial cuota;
    
    public ControlCrudPago (Crud crud, Socio socios, Socio nuevo, CuotaSocial cuota){
        this.crud = crud;
        this.socios = socios;
        this.nuevo = nuevo;
        this.cuota = cuota;
        this.crud.btnAgregarNuevoPago.addActionListener(this);
        this.crud.btnAceptarPago.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==crud.btnAgregarNuevoPago){
            try {
                String categoria = socios.buscarCategoria(Integer.parseInt(crud.txtBuscarPago.getText()));
                String anio =crud.txtAnioPago.getText();
                String mes =crud.txtMesPago.getText();
                String dia =crud.txtDiaPago.getText();
                
                SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
                Date parsed;
                parsed = format.parse(anio+mes+dia);
                java.sql.Date sql = new java.sql.Date(parsed.getTime());
                
                cuota.setFechaPago(sql);
                cuota.setMonto(Integer.parseInt(crud.txtMontoN.getText()));
                cuota.setFormaPago(crud.txtFormaPagoN.getText());
                cuota.setCuotaRut(Integer.parseInt(crud.txtBuscarPago.getText()));
                cuota.setCuotaCategoria(categoria);
                
                if(cuota.agregar(cuota)){
                    JOptionPane.showMessageDialog(null, "Pago ingresado con éxito");
                }else{
                    JOptionPane.showMessageDialog(null, "No se pudo ingresar el pago");
                }
            } catch (ParseException ex) {
                Logger.getLogger(ControlCrudPago.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       
        if(e.getSource()==crud.btnAceptarPago){
            if(socios.buscarCategoria(Integer.parseInt(crud.txtBuscarPago.getText())).equalsIgnoreCase("Colaborador") || socios.buscarCategoria(Integer.parseInt(crud.txtBuscarPago.getText())).equalsIgnoreCase("Honorario") || socios.buscarCategoria(Integer.parseInt(crud.txtBuscarPago.getText())).equalsIgnoreCase("Activo/Director") || socios.buscarCategoria(Integer.parseInt(crud.txtBuscarPago.getText())).equalsIgnoreCase("Honorario/Director")){
                JOptionPane.showMessageDialog(null, "Este socio esta exento del pago de cuotas sociales"); 
            }else{
               int rut = Integer.parseInt(crud.txtBuscarPago.getText());
            Calendar calendario = Calendar.getInstance();
            int anio = calendario.get(Calendar.YEAR);
            
            switch(cuota.buscar(rut, anio)){
                case 0:
                    crud.txtPrimeraCuota.setText("Incompleta");
                    crud.txtSegundaCuota.setText("Incompleta");
                    crud.txtTerceraCuota.setText("Incompleta");
                    break;
                case 1:
                    crud.txtPrimeraCuota.setText("Pagada");
                    crud.txtSegundaCuota.setText("Incompleta");
                    crud.txtTerceraCuota.setText("Incompleta");
                    break;
                case 2:
                    crud.txtPrimeraCuota.setText("Pagada");
                    crud.txtSegundaCuota.setText("Pagada");
                    crud.txtTerceraCuota.setText("Incompleta");
                    break;
                case 3:
                    crud.txtPrimeraCuota.setText("Pagada");
                    crud.txtSegundaCuota.setText("Pagada");
                    crud.txtTerceraCuota.setText("Pagada");
                    break;
                default:
                    crud.txtPrimeraCuota.setText("Pagada");
                    crud.txtSegundaCuota.setText("Pagada");
                    crud.txtTerceraCuota.setText("Pagada");
                    JOptionPane.showMessageDialog(null, "Puede existir una inconsistencia en su base de datos");
                    break; 
            }
            
                    
            }
        }
    }
}
