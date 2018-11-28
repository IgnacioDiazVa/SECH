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
public class ControlCrud implements ActionListener{
    
    private Socio socios, nuevo;
    private Crud crud;
    private Universidad uni;
    private Laboral lab;
    private Home home;
    private CuotaSocial cuota;
    
        
    
    public ControlCrud (Socio socios, Crud crud, Socio nuevo, Universidad uni, Laboral lab){
        this.socios = socios;
        this.nuevo = nuevo;
        this.crud = crud;
        this.uni = uni;
        this.lab = lab;
        this.crud.btnAgregar.addActionListener(this);
        this.crud.btnReestablecer.addActionListener(this);
        this.crud.btnNuevoSocio.addActionListener(this); 
        this.crud.txtCelular.addActionListener(this);
        this.crud.cmbCategoria.addActionListener(this);
        this.crud.btnRegresar.addActionListener(this);

//        this.crud.btnModificarSocio.addActionListener(this);
//        this.crud.btnNuevoPago.addActionListener(this);
//        this.crud.btnNuevoTiempo.addActionListener(this);
    }
     
    public void iniciar(){
        crud.setLocationRelativeTo(null);
    }
    
    /*
    *Falta agregar un método en donde revise los campos que se han rellenado y evalué si son socio, universidad o laboral antes de ingresarlos a la
    *base de datos, y que haga visible los campos en la vista en donde hay que rellenar
    *  Se puede evaluar tener restricciones en los jtextfield para reducir la posibilidad de errores
    */

    @Override
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource()==crud.btnRegresar){
            home = new Home();
            nuevo = new Socio();
            cuota = new CuotaSocial();
            uni = new Universidad();
            lab = new Laboral();
            ControlHome ctrlHo = new ControlHome(home, nuevo, cuota, uni, lab);
            crud.dispose();
            ctrlHo.iniciar();
            home.setVisible(true);
        }
        
        if(e.getSource() == crud.cmbCategoria){
           if(crud.cmbCategoria.getSelectedIndex()== 1){
            crud.txtNombreUniversidad.setEditable(true);
            crud.txtSede.setEditable(true);
            crud.txtAnio.setEditable(true);
            crud.txtMes.setEditable(true);
            crud.txtDia.setEditable(true);
        } else{
            crud.txtNombreUniversidad.setEditable(false);
            crud.txtSede.setEditable(false);
            crud.txtAnio.setEditable(false);
            crud.txtMes.setEditable(false);
            crud.txtDia.setEditable(false);  
          }
        }
        
        if(e.getSource() == crud.btnAgregar){
            if(validarEstudiantil() && validarFormularioSocio() && validarLaboralConPiso()){
                try {
                    String anio =crud.txtAnio.getText();
                    String mes =crud.txtMes.getText();
                    String dia =crud.txtDia.getText();
                    
                    SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
                    Date parsed;
                    parsed = format.parse(anio+mes+dia);
                    java.sql.Date sql = new java.sql.Date(parsed.getTime());

                    uni.setCodigoIngreso(crud.txtRut.getText());
                    uni.setAnioIngresoU(sql);
                    uni.setNombreUniversidad(crud.txtNombreUniversidad.getText());
                    uni.setSede(crud.txtSede.getText());
                    
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
                    java.util.Date date = new java.util.Date();
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime()); 
                    socios.setAnioIngreso(sqlDate);
                    socios.setCodigoSocioUniversidad(crud.txtRut.getText());
                    
                    
                    lab.setDireccion(crud.txtDireccion.getText()+ " " +crud.txtNumero.getText());
                    lab.setPiso(Integer.parseInt(crud.txtPiso.getText()));
                    lab.setOficina(crud.txtOficina.getText());
                    lab.setNumeroTelefono(Integer.parseInt(crud.txtTelefono.getText()));
                    lab.setReferencia(crud.txtReferencia.getText());
                    lab.setSitioWeb(crud.txtWeb.getText());
                    lab.setLaboralRut(Integer.parseInt(crud.txtRut.getText()));
                    lab.setLaboralCategoria(crud.cmbCategoria.getSelectedItem().toString());
                    int numero = lab.codigoComuna(crud.cmbComuna.getSelectedItem().toString());
                    lab.setCodigoComunaLaboral(numero);
                    lab.setNombreLaboral(crud.txtNomClinica.getText());
                    
                    
                    if(uni.agregar(uni) && nuevo.agregarEstudiantil(socios) && lab.agregar(lab)){
                        JOptionPane.showMessageDialog(null, "Ingresado con éxito");
                        limpiar();
                    }else{
                        JOptionPane.showMessageDialog(null, "No se pudo agregar");
                    }
                    
                } catch (ParseException ex) {
                    Logger.getLogger(ControlCrud.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }else{
                if(validarEstudiantil() && validarFormularioSocio() && validarLaboral()){
                    try {
                    String anio =crud.txtAnio.getText();
                    String mes =crud.txtMes.getText();
                    String dia =crud.txtDia.getText();
                    
                    SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
                    Date parsed;
                    parsed = format.parse(anio+mes+dia);
                    java.sql.Date sql = new java.sql.Date(parsed.getTime());

                    uni.setCodigoIngreso(crud.txtRut.getText());
                    uni.setAnioIngresoU(sql);
                    uni.setNombreUniversidad(crud.txtNombreUniversidad.getText());
                    uni.setSede(crud.txtSede.getText());
                    
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
                    java.util.Date date = new java.util.Date();
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime()); 
                    socios.setAnioIngreso(sqlDate);
                    socios.setCodigoSocioUniversidad(crud.txtRut.getText());
                    
                    
                    lab.setDireccion(crud.txtDireccion.getText()+ " " +crud.txtNumero.getText());
                    lab.setOficina(crud.txtOficina.getText());
                    lab.setNumeroTelefono(Integer.parseInt(crud.txtTelefono.getText()));
                    lab.setReferencia(crud.txtReferencia.getText());
                    lab.setSitioWeb(crud.txtWeb.getText());
                    lab.setLaboralRut(Integer.parseInt(crud.txtRut.getText()));
                    lab.setLaboralCategoria(crud.cmbCategoria.getSelectedItem().toString());
                    int numero = lab.codigoComuna(crud.cmbComuna.getSelectedItem().toString());
                    lab.setCodigoComunaLaboral(numero);
                    lab.setNombreLaboral(crud.txtNomClinica.getText());
                    
                    
                    if(uni.agregar(uni) && nuevo.agregarEstudiantil(socios) && lab.agregarSinPiso(lab)){
                        JOptionPane.showMessageDialog(null, "Ingresado con éxito");
                        limpiar();
                    }else{
                        JOptionPane.showMessageDialog(null, "No se pudo agregar");
                    }
                    
                } catch (ParseException ex) {
                    Logger.getLogger(ControlCrud.class.getName()).log(Level.SEVERE, null, ex);
                }
                }else{
                   if(validarEstudiantil() && validarFormularioSocio()){
                       try {
                    String anio =crud.txtAnio.getText();
                    String mes =crud.txtMes.getText();
                    String dia =crud.txtDia.getText();
                    
                    SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
                    Date parsed;
                    parsed = format.parse(anio+mes+dia);
                    java.sql.Date sql = new java.sql.Date(parsed.getTime());

                    uni.setCodigoIngreso(crud.txtRut.getText());
                    uni.setAnioIngresoU(sql);
                    uni.setNombreUniversidad(crud.txtNombreUniversidad.getText());
                    uni.setSede(crud.txtSede.getText());
                    
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
                    java.util.Date date = new java.util.Date();
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime()); 
                    socios.setAnioIngreso(sqlDate);
                    socios.setCodigoSocioUniversidad(crud.txtRut.getText());
                    
                    if(uni.agregar(uni) && nuevo.agregarEstudiantil(socios)){
                        JOptionPane.showMessageDialog(null, "Ingresado con éxito");
                        limpiar();
                    }else{
                        JOptionPane.showMessageDialog(null, "No se pudo agregar");
                    }
                    
                } catch (ParseException ex) {
                    Logger.getLogger(ControlCrud.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                   } else{
                       if(validarFormularioSocio() && validarLaboralConPiso()){
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
                            java.util.Date date = new java.util.Date();
                            java.sql.Date sqlDate = new java.sql.Date(date.getTime()); 
                            socios.setAnioIngreso(sqlDate);
                            
                            lab.setDireccion(crud.txtDireccion.getText()+ " " +crud.txtNumero.getText());
                            lab.setPiso(Integer.parseInt(crud.txtPiso.getText()));
                            lab.setOficina(crud.txtOficina.getText());
                            lab.setNumeroTelefono(Integer.parseInt(crud.txtTelefono.getText()));
                            lab.setReferencia(crud.txtReferencia.getText());
                            lab.setSitioWeb(crud.txtWeb.getText());
                            lab.setLaboralRut(Integer.parseInt(crud.txtRut.getText()));
                            lab.setLaboralCategoria(crud.cmbCategoria.getSelectedItem().toString());
                            int numero = lab.codigoComuna(crud.cmbComuna.getSelectedItem().toString());
                            lab.setCodigoComunaLaboral(numero);
                            lab.setNombreLaboral(crud.txtNomClinica.getText());
                            
                            if(nuevo.agregar(socios) && lab.agregar(lab)){
                                JOptionPane.showMessageDialog(null, "Ingresado con éxito");
                                limpiar();
                            }else{
                                JOptionPane.showMessageDialog(null, "No se pudo agregar");
                            }
                       } else{
                           if(validarFormularioSocio() && validarLaboral()){
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
                                java.util.Date date = new java.util.Date();
                                java.sql.Date sqlDate = new java.sql.Date(date.getTime()); 
                                socios.setAnioIngreso(sqlDate);

                                lab.setDireccion(crud.txtDireccion.getText()+ " " +crud.txtNumero.getText());
                                lab.setOficina(crud.txtOficina.getText());
                                lab.setNumeroTelefono(Integer.parseInt(crud.txtTelefono.getText()));
                                lab.setReferencia(crud.txtReferencia.getText());
                                lab.setSitioWeb(crud.txtWeb.getText());
                                lab.setLaboralRut(Integer.parseInt(crud.txtRut.getText()));
                                lab.setLaboralCategoria(crud.cmbCategoria.getSelectedItem().toString());
                                int numero = lab.codigoComuna(crud.cmbComuna.getSelectedItem().toString());
                                lab.setCodigoComunaLaboral(numero);
                                lab.setNombreLaboral(crud.txtNomClinica.getText());

                                if(nuevo.agregar(socios) && lab.agregarSinPiso(lab)){
                                    JOptionPane.showMessageDialog(null, "Ingresado con éxito");
                                    limpiar();
                                }else{
                                    JOptionPane.showMessageDialog(null, "No se pudo agregar");
                                }
                           } else{
                               if(validarFormularioSocio()){
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
            
                                  java.util.Date date = new java.util.Date();
                                  java.sql.Date sqlDate = new java.sql.Date(date.getTime()); 
                                  socios.setAnioIngreso(sqlDate);
            
                                  if(nuevo.agregar(socios)){
                                      JOptionPane.showMessageDialog(null, "Ingresado con éxito");
                                      limpiar();
                                  }else{
                                      JOptionPane.showMessageDialog(null, "No se pudo agregar");
                                  }
                              }else{
                                  JOptionPane.showMessageDialog(null, "Debe rellenar los campos correspondientes");
            }
                           }
                       }
                   }
                }
            }
            
            
            
            
            
        }
        
        if(e.getSource() == crud.btnReestablecer){
            limpiar();
        }

    }
    
    public void limpiar(){
        crud.txtNombres.setText(null);
        crud.txtAppPat.setText(null);
        crud.txtAppMat.setText(null);
        crud.txtCelular.setText(null);
        crud.txtCorreo.setText(null);
        crud.txtRut.setText(null);
        crud.txtDigitoV.setText(null);
        
        crud.txtReferencia.setText(null);
        crud.txtNomClinica.setText(null);
        crud.txtOficina.setText(null);
        crud.txtPiso.setText(null);
        crud.txtDireccion.setText(null);
        crud.txtNumero.setText(null);
        crud.txtTelefono.setText(null);
        crud.txtWeb.setText(null);
        
        crud.txtNombreUniversidad.setText(null);
        crud.txtDia.setText(null);
        crud.txtAnio.setText(null);
        crud.txtMes.setText(null);
        crud.txtSede.setText(null);
        
        crud.cmbCategoria.setSelectedIndex(0);
        crud.cmbComuna.setSelectedIndex(0);
        crud.cmbFilial.setSelectedIndex(0);
        crud.cmbSis.setSelectedIndex(0);
    }
    
    private boolean validarFormularioSocio(){
        return crud.txtNombres.getText().length()>0 &&
               crud.txtAppPat.getText().length()>0 &&
               crud.txtCorreo.getText().length()>0 &&
               crud.txtCelular.getText().length()>0 &&
               crud.txtRut.getText().length()>0 &&
               crud.txtDigitoV.getText().length()>0 &&
               crud.cmbCategoria.getSelectedIndex() != 0 &&
               crud.cmbCategoria.getSelectedIndex() != -1 &&
               crud.cmbFilial.getSelectedIndex() != 0 &&
               crud.cmbFilial.getSelectedIndex() != -1 &&
               crud.cmbSis.getSelectedIndex() != 0 &&
               crud.cmbSis.getSelectedIndex() != -1;
    }
    
    private boolean validarEstudiantil(){
        return crud.txtNombreUniversidad.getText().length()>0 &&
               crud.txtSede.getText().length()> 0 &&
               crud.txtDia.getText().length()> 0 &&
               crud.txtMes.getText().length()> 0 &&
               crud.txtAnio.getText().length()> 0;
    }
    
    private boolean validarLaboral(){
        return crud.txtDireccion.getText().length()>0 &&
               crud.txtNumero.getText().length()>0 &&
               crud.txtTelefono.getText().length()>0 &&
               crud.cmbComuna.getSelectedIndex() != 0 &&
               crud.cmbComuna.getSelectedIndex() != -1;                  
    }
    
    private boolean validarLaboralConPiso(){
        return crud.txtDireccion.getText().length()>0 &&
               crud.txtNumero.getText().length()>0 &&
               crud.txtTelefono.getText().length()>0 &&
               crud.cmbComuna.getSelectedIndex() != 0 &&
               crud.cmbComuna.getSelectedIndex() != -1 &&
               crud.txtPiso.getText().length()>0;                  
    }
    
}
