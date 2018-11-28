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
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Actividad;
import modelo.Socio;
import vista.Crud;

/**
 *
 * @author Ignacio
 */
public class ControlCrudEstado implements ActionListener {
    
    private Crud crud;
    private Actividad actividad;
    private Socio socios;
    
    public ControlCrudEstado(Crud crud, Actividad actividad, Socio socios){
        this.crud = crud;
        this.actividad= actividad;
        this.socios= socios;
        this.crud.btnAgregarNuevoEstado.addActionListener(this);
        this.crud.btnAceptarEstado.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == crud.btnAgregarNuevoEstado){
           
            try {
                String anioI =crud.txtInicioAnio.getText();
                String mesI =crud.txtInicioMes.getText();
                String diaI =crud.txtInicioDia.getText();
                
                String anioT = crud.txtTerminoAnio.getText();
                String mesT = crud.txtTerminoMes.getText();
                String diaT = crud.txtTerminoDia.getText();
                
                SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
                Date parsed;
                Date parsed2;
                parsed = format.parse(anioI+mesI+diaI);
                parsed2 = format.parse(anioT+mesT+diaT);
                java.sql.Date sql = new java.sql.Date(parsed.getTime());
                java.sql.Date sql2 = new java.sql.Date(parsed2.getTime());
                
                int rut = Integer.parseInt(crud.txtBuscarEstado.getText());
                String categoria = socios.buscarCategoria(rut);
                
                actividad.setFechaInicio(sql);
                actividad.setFechaTermino(sql2);
                actividad.setEstadoActividad(crud.txtEstadoE.getText());
                actividad.setMotivo(crud.txtMotivoE.getText());
                actividad.setActividadRut(Integer.parseInt(crud.txtBuscarEstado.getText()));
                actividad.setActividadCategoria(categoria);
                
                if(actividad.agregarActividad(actividad)){
                    JOptionPane.showMessageDialog(null, "Ingresado con éxito");
                }else{
                    JOptionPane.showMessageDialog(null, "No se pudo ingresar el registro");
                }
            } catch (ParseException ex) {
                Logger.getLogger(ControlCrudEstado.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }
        
        if(e.getSource()==crud.btnAceptarEstado){
            //El socio cuenta con una estado +estado_actividad+ por motivo de +motivo+ desde +fecha_incio_inactividad+ hasta + fecha_termino_inactividad
            if(actividad.buscar(Integer.parseInt(crud.txtBuscarEstado.getText()))){
                Actividad nuevo =actividad.buscarRegistro(Integer.parseInt(crud.txtBuscarEstado.getText()));
                crud.txtEstadoActual.setText("El socio cuenta con un estado "+nuevo.getEstadoActividad()+" por motivo de "+nuevo.getMotivo()+" desde "+nuevo.getFechaInicio()+" hasta "+nuevo.getFechaTermino() );
            }else{
                crud.txtEstadoActual.setText("Este socio no cuenta con ningún estado en proceso, eximido o finalizado");
            }
        }
    }
    
}
