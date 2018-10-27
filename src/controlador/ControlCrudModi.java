/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Laboral;
import modelo.Socio;
import vista.Crud;

/**
 *
 * @author Ignacio
 * Queda hacer algunas celdas no editables en el modificar, tal como el rut o su digito verificador
 * Generar advertencia cuando no estan rellenados el minimo de campos a ingresar
 * Hay que diseñar la opcion para borrar registros desde la interfaz en el jtable
 */
public class ControlCrudModi implements ActionListener {
    
    private Crud crud;
    private Socio socios, nuevo;
    private Laboral lab;
    
    public ControlCrudModi (Socio socios, Crud crud, Laboral lab, Socio nuevo){
        this.socios = socios;
        this.nuevo = nuevo;
        this.crud = crud;
        this.lab = lab;
        this.crud.btnAceptarModi.addActionListener(this);
        this.crud.txtBuscarModi.addActionListener(this);
        this.crud.txtNombrePersonal.addActionListener(this);
        this.crud.txtApellidoPaterno.addActionListener(this);
        this.crud.btnModificarPersonal.addActionListener(this);
        this.crud.btnAgregarLab.addActionListener(this);
        this.crud.cmbTipoModi.addActionListener(this);
        
        
        
    }
     
    public void iniciar(){
        crud.setLocationRelativeTo(null);
    }
    
    public void LlenarTabla(JTable tablaD, int rut){
        DefaultTableModel modeloT = new DefaultTableModel();
        tablaD.setModel(modeloT);
        
        modeloT.addColumn("Dirección");
        modeloT.addColumn("Piso");
        modeloT.addColumn("Oficina");
        modeloT.addColumn("Teléfono");
        modeloT.addColumn("Referencia o torre");
        modeloT.addColumn("Sitio web");
        modeloT.addColumn("Rut");
        modeloT.addColumn("Categoría");
        modeloT.addColumn("Código comuna");
        modeloT.addColumn("Nombre");
        
        Object[] columna = new Object[10];
        
        int numRegistros = lab.listLaboral(rut).size();
        
        for(int i=0; i< numRegistros; i++){
            columna[0]= lab.listLaboral(rut).get(i).getDireccion();
            columna[1]= lab.listLaboral(rut).get(i).getPiso();
            columna[2]= lab.listLaboral(rut).get(i).getOficina();
            columna[3]= lab.listLaboral(rut).get(i).getNumeroTelefono();
            columna[4]= lab.listLaboral(rut).get(i).getReferencia();
            columna[5]= lab.listLaboral(rut).get(i).getSitioWeb();
            columna[6]= lab.listLaboral(rut).get(i).getLaboralRut();
            columna[7]= lab.listLaboral(rut).get(i).getLaboralCategoria();
            columna[8]= lab.listLaboral(rut).get(i).getCodigoComunaLaboral();
            columna[9]= lab.listLaboral(rut).get(i).getNombreLaboral();
            modeloT.addRow(columna);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()== crud.btnAgregarLab){
            if(validarLaboralConPiso()){
                lab.setDireccion(crud.txtDireccionLab.getText()+ " " +crud.txtNumeroLab.getText());
                lab.setPiso(Integer.parseInt(crud.txtPisoLab.getText()));
                lab.setOficina(crud.txtOficinaLab.getText());
                lab.setNumeroTelefono(Integer.parseInt(crud.txtTelefonoLab.getText()));
                lab.setReferencia(crud.txtReferenciaLab.getText());
                lab.setSitioWeb(crud.txtSitioLab.getText());
                lab.setLaboralRut(Integer.parseInt(crud.txtBuscarModi.getText()));
                lab.setLaboralCategoria(crud.cmbCategoriaLab.getSelectedItem().toString());
                int numero = lab.codigoComuna(crud.cmbComunaLab.getSelectedItem().toString());
                lab.setCodigoComunaLaboral(numero);
                lab.setNombreLaboral(crud.txtNombreClinicaLab.getText());
                
                if(lab.agregar(lab)){
                   JOptionPane.showMessageDialog(null, "Ingresado con éxito");
                   limpiarLaboral(); 
                }else{
                    JOptionPane.showMessageDialog(null, "No se pudo agregar");
                }
            } else{   
                    if(validarLaboralSinPiso()){
                        lab.setDireccion(crud.txtDireccionLab.getText()+ " " +crud.txtNumeroLab.getText());
                        lab.setOficina(crud.txtOficinaLab.getText());
                        lab.setNumeroTelefono(Integer.parseInt(crud.txtTelefonoLab.getText()));
                        lab.setReferencia(crud.txtReferenciaLab.getText());
                        lab.setSitioWeb(crud.txtSitioLab.getText());
                        lab.setLaboralRut(Integer.parseInt(crud.txtBuscarModi.getText()));
                        lab.setLaboralCategoria(crud.cmbCategoriaLab.getSelectedItem().toString());
                        int numero0 = lab.codigoComuna(crud.cmbComunaLab.getSelectedItem().toString());
                        lab.setCodigoComunaLaboral(numero0);
                        lab.setNombreLaboral(crud.txtNombreClinicaLab.getText());
                        
                        if(lab.agregarSinPiso(lab)){
                            JOptionPane.showMessageDialog(null, "Ingresado con éxito");
                            limpiarLaboral();
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "No se pudo agregar");
                    }
            }                
            
        }
        if(e.getSource()== crud.btnAceptarModi && crud.cmbTipoModi.getSelectedIndex()==1){
            int rut = Integer.parseInt(crud.txtBuscarModi.getText());
            LlenarTabla(crud.jtDatosLaboral, rut);
        }
        if(e.getSource()==crud.cmbTipoModi){
            if(crud.cmbTipoModi.getSelectedIndex()==0){
                crud.jpnModificarLaboral.setVisible(false);
                crud.jpnModificarPersonal.setVisible(true);
            }
            if(crud.cmbTipoModi.getSelectedIndex()==1){
                crud.jpnModificarPersonal.setVisible(false);
                crud.jpnModificarLaboral.setVisible(true);
            }
        }
        if(e.getSource()==crud.btnAceptarModi){
            socios.setRut(Integer.parseInt(crud.txtBuscarModi.getText()));
            
            if(nuevo.buscar(socios)){
                crud.txtNombrePersonal.setText(socios.getNombres());
                crud.txtApellidoPaterno.setText(socios.getApellidoPaterno());
                crud.txtApellidoMaterno.setText(socios.getApellidoMaterno());
                crud.txtCorreoPersonal.setText(socios.getCorreoElectronico());
                crud.txtCelPersonal.setText(socios.getCelular());
                crud.cmbFilialPersonal.setSelectedItem(socios.getFilial());
                crud.cmbSisPersonal.setSelectedItem(socios.getSis());
                crud.txtRutPersonal.setText(socios.getRut().toString());
                crud.txtDvPersonal.setText(String.valueOf(socios.getDigitoVerificador()));
                crud.cmbCategoriaPersonal.setSelectedItem(socios.getCategoria());
            }else{
                JOptionPane.showMessageDialog(null, "No se encontró ningún resultado");
            }
        }
        
        if(e.getSource()==crud.btnModificarPersonal){
            socios.setRut(Integer.parseInt(crud.txtRutPersonal.getText()));
            socios.setCategoria(crud.cmbCategoriaPersonal.getSelectedItem().toString());
            socios.setDigitoVerificador(crud.txtDvPersonal.getText().charAt(0));
            socios.setApellidoPaterno(crud.txtApellidoPaterno.getText());
            socios.setApellidoMaterno(crud.txtApellidoMaterno.getText());
            socios.setCorreoElectronico(crud.txtCorreoPersonal.getText());
            socios.setCelular(crud.txtCelPersonal.getText());
            socios.setSis(crud.cmbSisPersonal.getSelectedItem().toString());
            socios.setFilial(crud.cmbFilialPersonal.getSelectedItem().toString());
            
            if(nuevo.modificar(socios)){
                JOptionPane.showMessageDialog(null, "Registro modificado");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Error al modificar");
            }
        }
    
    }
    
    public void limpiar(){
        crud.txtNombrePersonal.setText(null);
        crud.txtApellidoPaterno.setText(null);
        crud.txtApellidoMaterno.setText(null);
        crud.txtCelPersonal.setText(null);
        crud.txtCorreoPersonal.setText(null);
        crud.txtRutPersonal.setText(null);
        crud.txtDvPersonal.setText(null);
        
        crud.cmbCategoriaPersonal.setSelectedIndex(0);
        crud.cmbFilialPersonal.setSelectedIndex(0);
        crud.cmbSisPersonal.setSelectedIndex(0);
    }
    
    public void limpiarLaboral(){
        crud.txtDireccionLab.setText(null);
        crud.txtNombreClinicaLab.setText(null);
        crud.txtOficinaLab.setText(null);
        crud.txtPisoLab.setText(null);
        crud.txtNumeroLab.setText(null);
        crud.txtTelefonoLab.setText(null);
        crud.txtReferenciaLab.setText(null);
        crud.txtSitioLab.setText(null);
        
        crud.cmbComunaLab.setSelectedIndex(0);
    }
    
    private boolean validarLaboralConPiso(){
        return crud.txtDireccionLab.getText().length()>0 &&
               crud.txtNumeroLab.getText().length()>0 &&
               crud.txtTelefonoLab.getText().length()>0 &&
               crud.cmbComunaLab.getSelectedIndex() != 0 &&
               crud.cmbComunaLab.getSelectedIndex() != -1 &&
               crud.txtPisoLab.getText().length()>0;                  
    }
    
    private boolean validarLaboralSinPiso(){
        return crud.txtDireccionLab.getText().length()>0 &&
               crud.txtNumeroLab.getText().length()>0 &&
               crud.txtTelefonoLab.getText().length()>0 &&
               crud.cmbComunaLab.getSelectedIndex() != 0 &&
               crud.cmbComunaLab.getSelectedIndex() != -1;                  
    }
}
