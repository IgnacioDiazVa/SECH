/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
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
public class ControlHome implements ActionListener {
    
    private Home home;
    private Socio nuevo;
    private CuotaSocial cuota;
    private Universidad universidad;
    private Laboral lab;
    private Actividad actividad;
    private Crud crud;
    
    
    public ControlHome(Home home, Socio nuevo, CuotaSocial cuota, Universidad universidad, Laboral lab){
        this.home=home;
        this.nuevo=nuevo;
        this.cuota=cuota;
        this.universidad=universidad;
        this.lab=lab;
        this.home.btnBusca.addActionListener(this);
        this.home.btnAsamblea.addActionListener(this);
        this.home.btnMorosos.addActionListener(this);
        this.home.btnSocioAlDia.addActionListener(this);
        this.home.btnRefrescar.addActionListener(this);
        this.home.btnExcel.addActionListener(this);
        this.home.btnCrudSocio.addActionListener(this);
        this.home.cmbCategoriaHome.addActionListener(this);
        this.home.cmbFilialHome.addActionListener(this);
        this.home.cmbSisHome.addActionListener(this);
        this.home.cmbUniversidadHome.addActionListener(this);
    }
    
    public void iniciar(){
        home.setLocationRelativeTo(null);
    }
    
    public void tablaTodo(JTable tablaD, String categoria, String sis, String filial){
        DefaultTableModel modeloT = new DefaultTableModel();
        tablaD.setModel(modeloT);
        
        modeloT.addColumn("Nombres");
        modeloT.addColumn("Apellido Paterno");
        modeloT.addColumn("Apellido Materno");
        modeloT.addColumn("Rut");
        modeloT.addColumn("Digito verificador");
        modeloT.addColumn("Categoría");
        modeloT.addColumn("Filial");
        modeloT.addColumn("Sis");
        
        Object[] columna = new Object[8];
        
        int numRegistros = nuevo.listTodo(categoria, sis, filial).size();
        
        for(int i=0; i< numRegistros; i++){
            columna[0]= nuevo.listTodo(categoria, sis, filial).get(i).getNombres();
            columna[1]= nuevo.listTodo(categoria, sis, filial).get(i).getApellidoPaterno();
            columna[2]= nuevo.listTodo(categoria, sis, filial).get(i).getApellidoMaterno();
            columna[3]= nuevo.listTodo(categoria, sis, filial).get(i).getRut();
            columna[4]= nuevo.listTodo(categoria, sis, filial).get(i).getDigitoVerificador();
            columna[5]= nuevo.listTodo(categoria, sis, filial).get(i).getCategoria();
            columna[6]= nuevo.listTodo(categoria, sis, filial).get(i).getFilial();
            columna[7]= nuevo.listTodo(categoria, sis, filial).get(i).getSis();
            modeloT.addRow(columna);
        }
    }
    
    public void tablaCaSis(JTable tablaD, String categoria, String sis){
        DefaultTableModel modeloT = new DefaultTableModel();
        tablaD.setModel(modeloT);
        
        modeloT.addColumn("Nombres");
        modeloT.addColumn("Apellido Paterno");
        modeloT.addColumn("Apellido Materno");
        modeloT.addColumn("Rut");
        modeloT.addColumn("Digito verificador");
        modeloT.addColumn("Categoría");
        modeloT.addColumn("Filial");
        modeloT.addColumn("Sis");
        
        Object[] columna = new Object[8];
        
        int numRegistros = nuevo.listCaSis(categoria, sis).size();
        
        for(int i=0; i< numRegistros; i++){
            columna[0]= nuevo.listCaSis(categoria, sis).get(i).getNombres();
            columna[1]= nuevo.listCaSis(categoria, sis).get(i).getApellidoPaterno();
            columna[2]= nuevo.listCaSis(categoria, sis).get(i).getApellidoMaterno();
            columna[3]= nuevo.listCaSis(categoria, sis).get(i).getRut();
            columna[4]= nuevo.listCaSis(categoria, sis).get(i).getDigitoVerificador();
            columna[5]= nuevo.listCaSis(categoria, sis).get(i).getCategoria();
            columna[6]= nuevo.listCaSis(categoria, sis).get(i).getFilial();
            columna[7]= nuevo.listCaSis(categoria, sis).get(i).getSis();
            modeloT.addRow(columna);
        }
    }
    
    public void tablaCaFi(JTable tablaD, String categoria, String filial){
        DefaultTableModel modeloT = new DefaultTableModel();
        tablaD.setModel(modeloT);
        
        modeloT.addColumn("Nombres");
        modeloT.addColumn("Apellido Paterno");
        modeloT.addColumn("Apellido Materno");
        modeloT.addColumn("Rut");
        modeloT.addColumn("Digito verificador");
        modeloT.addColumn("Categoría");
        modeloT.addColumn("Filial");
        modeloT.addColumn("Sis");
        
        Object[] columna = new Object[8];
        
        int numRegistros = nuevo.listCaFi(categoria, filial).size();
        
        for(int i=0; i< numRegistros; i++){
            columna[0]= nuevo.listCaFi(categoria, filial).get(i).getNombres();
            columna[1]= nuevo.listCaFi(categoria, filial).get(i).getApellidoPaterno();
            columna[2]= nuevo.listCaFi(categoria, filial).get(i).getApellidoMaterno();
            columna[3]= nuevo.listCaFi(categoria, filial).get(i).getRut();
            columna[4]= nuevo.listCaFi(categoria, filial).get(i).getDigitoVerificador();
            columna[5]= nuevo.listCaFi(categoria, filial).get(i).getCategoria();
            columna[6]= nuevo.listCaFi(categoria, filial).get(i).getFilial();
            columna[7]= nuevo.listCaFi(categoria, filial).get(i).getSis();
            modeloT.addRow(columna);
        }
    }
    
    public void tablaSiFi(JTable tablaD, String sis, String filial){
        DefaultTableModel modeloT = new DefaultTableModel();
        tablaD.setModel(modeloT);
        
        modeloT.addColumn("Nombres");
        modeloT.addColumn("Apellido Paterno");
        modeloT.addColumn("Apellido Materno");
        modeloT.addColumn("Rut");
        modeloT.addColumn("Digito verificador");
        modeloT.addColumn("Categoría");
        modeloT.addColumn("Filial");
        modeloT.addColumn("Sis");
        
        Object[] columna = new Object[8];
        
        int numRegistros = nuevo.listSiFi(sis, filial).size();
        
        for(int i=0; i< numRegistros; i++){
            columna[0]= nuevo.listSiFi(sis, filial).get(i).getNombres();
            columna[1]= nuevo.listSiFi(sis, filial).get(i).getApellidoPaterno();
            columna[2]= nuevo.listSiFi(sis, filial).get(i).getApellidoMaterno();
            columna[3]= nuevo.listSiFi(sis, filial).get(i).getRut();
            columna[4]= nuevo.listSiFi(sis, filial).get(i).getDigitoVerificador();
            columna[5]= nuevo.listSiFi(sis, filial).get(i).getCategoria();
            columna[6]= nuevo.listSiFi(sis, filial).get(i).getFilial();
            columna[7]= nuevo.listSiFi(sis, filial).get(i).getSis();
            modeloT.addRow(columna);
        }
    }
    
    public void tablaCategoria(JTable tablaD, String categoria){
        DefaultTableModel modeloT = new DefaultTableModel();
        tablaD.setModel(modeloT);
        
        modeloT.addColumn("Nombres");
        modeloT.addColumn("Apellido Paterno");
        modeloT.addColumn("Apellido Materno");
        modeloT.addColumn("Rut");
        modeloT.addColumn("Digito verificador");
        modeloT.addColumn("Categoría");
        modeloT.addColumn("Filial");
        modeloT.addColumn("Sis");
        
        Object[] columna = new Object[8];
        
        int numRegistros = nuevo.listCategoria(categoria).size();
        
        for(int i=0; i< numRegistros; i++){
            columna[0]= nuevo.listCategoria(categoria).get(i).getNombres();
            columna[1]= nuevo.listCategoria(categoria).get(i).getApellidoPaterno();
            columna[2]= nuevo.listCategoria(categoria).get(i).getApellidoMaterno();
            columna[3]= nuevo.listCategoria(categoria).get(i).getRut();
            columna[4]= nuevo.listCategoria(categoria).get(i).getDigitoVerificador();
            columna[5]= nuevo.listCategoria(categoria).get(i).getCategoria();
            columna[6]= nuevo.listCategoria(categoria).get(i).getFilial();
            columna[7]= nuevo.listCategoria(categoria).get(i).getSis();
            modeloT.addRow(columna);
        }
    }
    
    public void tablaFilial(JTable tablaD, String filial){
        DefaultTableModel modeloT = new DefaultTableModel();
        tablaD.setModel(modeloT);
        
        modeloT.addColumn("Nombres");
        modeloT.addColumn("Apellido Paterno");
        modeloT.addColumn("Apellido Materno");
        modeloT.addColumn("Rut");
        modeloT.addColumn("Digito verificador");
        modeloT.addColumn("Categoría");
        modeloT.addColumn("Filial");
        modeloT.addColumn("Sis");
        
        Object[] columna = new Object[8];
        
        int numRegistros = nuevo.listFilial(filial).size();
        
        for(int i=0; i< numRegistros; i++){
            columna[0]= nuevo.listFilial(filial).get(i).getNombres();
            columna[1]= nuevo.listFilial(filial).get(i).getApellidoPaterno();
            columna[2]= nuevo.listFilial(filial).get(i).getApellidoMaterno();
            columna[3]= nuevo.listFilial(filial).get(i).getRut();
            columna[4]= nuevo.listFilial(filial).get(i).getDigitoVerificador();
            columna[5]= nuevo.listFilial(filial).get(i).getCategoria();
            columna[6]= nuevo.listFilial(filial).get(i).getFilial();
            columna[7]= nuevo.listFilial(filial).get(i).getSis();
            modeloT.addRow(columna);
        }
    }
    
    public void tablaSis(JTable tablaD, String sis){
        DefaultTableModel modeloT = new DefaultTableModel();
        tablaD.setModel(modeloT);
        
        modeloT.addColumn("Nombres");
        modeloT.addColumn("Apellido Paterno");
        modeloT.addColumn("Apellido Materno");
        modeloT.addColumn("Rut");
        modeloT.addColumn("Digito verificador");
        modeloT.addColumn("Categoría");
        modeloT.addColumn("Filial");
        modeloT.addColumn("Sis");
        
        Object[] columna = new Object[8];
        
        int numRegistros = nuevo.listSis(sis).size();
        
        for(int i=0; i< numRegistros; i++){
            columna[0]= nuevo.listSis(sis).get(i).getNombres();
            columna[1]= nuevo.listSis(sis).get(i).getApellidoPaterno();
            columna[2]= nuevo.listSis(sis).get(i).getApellidoMaterno();
            columna[3]= nuevo.listSis(sis).get(i).getRut();
            columna[4]= nuevo.listSis(sis).get(i).getDigitoVerificador();
            columna[5]= nuevo.listSis(sis).get(i).getCategoria();
            columna[6]= nuevo.listSis(sis).get(i).getFilial();
            columna[7]= nuevo.listSis(sis).get(i).getSis();
            modeloT.addRow(columna);
        }
        
        
    }
    
    public void tablaUniversidad(JTable tablaD, String uni){
       DefaultTableModel modeloT = new DefaultTableModel();
       tablaD.setModel(modeloT); 
      
       modeloT.addColumn("Nombres");
       modeloT.addColumn("Apellido Paterno");
       modeloT.addColumn("Apellido Materno");
       modeloT.addColumn("Rut");
       modeloT.addColumn("Digito verificador");
       modeloT.addColumn("Categoría");
       modeloT.addColumn("Filial");
        
        
        Object[] columna = new Object[7];
        
        int numRegistros = nuevo.listUniversidad(uni).size();
        
        for(int i=0; i< numRegistros; i++){
            columna[0]= nuevo.listUniversidad(uni).get(i).getNombres();
            columna[1]= nuevo.listUniversidad(uni).get(i).getApellidoPaterno();
            columna[2]= nuevo.listUniversidad(uni).get(i).getApellidoMaterno();
            columna[3]= nuevo.listUniversidad(uni).get(i).getRut();
            columna[4]= nuevo.listUniversidad(uni).get(i).getDigitoVerificador();
            columna[5]= nuevo.listUniversidad(uni).get(i).getCategoria();
            columna[6]= nuevo.listUniversidad(uni).get(i).getFilial();
            modeloT.addRow(columna);
        }
       
    }
    
    public void tablaPersonal(JTable tablaD, int rut){
        DefaultTableModel modeloT = new DefaultTableModel();
        tablaD.setModel(modeloT);
        
        modeloT.addColumn("Nombres");
        modeloT.addColumn("Apellido Paterno");
        modeloT.addColumn("Apellido Materno");
        modeloT.addColumn("Rut");
        modeloT.addColumn("Digito verificador");
        modeloT.addColumn("Categoría");
        modeloT.addColumn("Filial");
        
        
        Object[] columna = new Object[7];
        
        int numRegistros = nuevo.listSocio(rut).size();
        
        for(int i=0; i< numRegistros; i++){
            columna[0]= nuevo.listSocio(rut).get(i).getNombres();
            columna[1]= nuevo.listSocio(rut).get(i).getApellidoPaterno();
            columna[2]= nuevo.listSocio(rut).get(i).getApellidoMaterno();
            columna[3]= nuevo.listSocio(rut).get(i).getRut();
            columna[4]= nuevo.listSocio(rut).get(i).getDigitoVerificador();
            columna[5]= nuevo.listSocio(rut).get(i).getCategoria();
            columna[6]= nuevo.listSocio(rut).get(i).getFilial();
            modeloT.addRow(columna);
        }
    }
    
    public void tablaAlDia(JTable tablaD, int anio, String mesPago){
        DefaultTableModel modeloT = new DefaultTableModel();
        tablaD.setModel(modeloT);
        
        modeloT.addColumn("Nombres");
        modeloT.addColumn("Apellido Paterno");
        modeloT.addColumn("Apellido Materno");
        modeloT.addColumn("Rut");
        modeloT.addColumn("Digito verificador");
        modeloT.addColumn("Categoría");
        modeloT.addColumn("Filial");
        
        
        Object[] columna = new Object[7];
        
        int numRegistros = nuevo.listAlDia(anio, mesPago).size();
        
        for(int i=0; i< numRegistros; i++){
            columna[0]= nuevo.listAlDia(anio, mesPago).get(i).getNombres();
            columna[1]= nuevo.listAlDia(anio, mesPago).get(i).getApellidoPaterno();
            columna[2]= nuevo.listAlDia(anio, mesPago).get(i).getApellidoMaterno();
            columna[3]= nuevo.listAlDia(anio, mesPago).get(i).getRut();
            columna[4]= nuevo.listAlDia(anio, mesPago).get(i).getDigitoVerificador();
            columna[5]= nuevo.listAlDia(anio, mesPago).get(i).getCategoria();
            columna[6]= nuevo.listAlDia(anio, mesPago).get(i).getFilial();
            modeloT.addRow(columna);
        }
    }
    
    //Tablas para las cuota adeudadas de socios por categoria y filial
    
    public void cuotasUnaCondicion (JTable tablaD,String categoria, String filial,  int anio, int condicion){
        DefaultTableModel modeloT = new DefaultTableModel();
        tablaD.setModel(modeloT);
        
        modeloT.addColumn("Nombres");
        modeloT.addColumn("Apellido Paterno");
        modeloT.addColumn("Apellido Materno");
        modeloT.addColumn("Correo");
        modeloT.addColumn("Celular");
        modeloT.addColumn("Categoría");
        modeloT.addColumn("Filial");
        
        Object[] columna = new Object[7];
        
        int numRegistros = nuevo.listUnaCondicion(categoria, filial, anio, condicion).size();
        
        for(int i=0; i< numRegistros; i++){
            columna[0]= nuevo.listUnaCondicion(categoria, filial, anio, condicion).get(i).getNombres();
            columna[1]= nuevo.listUnaCondicion(categoria, filial, anio, condicion).get(i).getApellidoPaterno();
            columna[2]= nuevo.listUnaCondicion(categoria, filial, anio, condicion).get(i).getApellidoMaterno();
            columna[3]= nuevo.listUnaCondicion(categoria, filial, anio, condicion).get(i).getCorreoElectronico();
            columna[4]= nuevo.listUnaCondicion(categoria, filial, anio, condicion).get(i).getCelular();
            columna[5]= nuevo.listUnaCondicion(categoria, filial, anio, condicion).get(i).getCategoria();
            columna[6]= nuevo.listUnaCondicion(categoria, filial, anio, condicion).get(i).getFilial();
            modeloT.addRow(columna);
        }
    }
    
    public void cuotasDosCondiciones(JTable tablaD,String categoria, String filial, int anioPasado, int primeraCondicion, int anio, int segundaCondicion){
        DefaultTableModel modeloT = new DefaultTableModel();
        tablaD.setModel(modeloT);
        
        modeloT.addColumn("Nombres");
        modeloT.addColumn("Apellido Paterno");
        modeloT.addColumn("Apellido Materno");
        modeloT.addColumn("Correo");
        modeloT.addColumn("Celular");
        modeloT.addColumn("Categoría");
        modeloT.addColumn("Filial");
        
        Object[] columna = new Object[7];
        
        int numRegistros = nuevo.listDosCondiciones(categoria, filial, anioPasado, primeraCondicion, anio, segundaCondicion).size();
        
        for(int i=0; i< numRegistros; i++){
            columna[0]= nuevo.listDosCondiciones(categoria, filial, anioPasado, primeraCondicion, anio, segundaCondicion).get(i).getNombres();
            columna[1]= nuevo.listDosCondiciones(categoria, filial, anioPasado, primeraCondicion, anio, segundaCondicion).get(i).getApellidoPaterno();
            columna[2]= nuevo.listDosCondiciones(categoria, filial, anioPasado, primeraCondicion, anio, segundaCondicion).get(i).getApellidoMaterno();
            columna[3]= nuevo.listDosCondiciones(categoria, filial, anioPasado, primeraCondicion, anio, segundaCondicion).get(i).getCorreoElectronico();
            columna[4]= nuevo.listDosCondiciones(categoria, filial, anioPasado, primeraCondicion, anio, segundaCondicion).get(i).getCelular();
            columna[5]= nuevo.listDosCondiciones(categoria, filial, anioPasado, primeraCondicion, anio, segundaCondicion).get(i).getCategoria();
            columna[6]= nuevo.listDosCondiciones(categoria, filial, anioPasado, primeraCondicion, anio, segundaCondicion).get(i).getFilial();
            modeloT.addRow(columna);
        }
    }
    
    public void eneFeb (JTable tablaD, String categoria, String filial, int anio, int condicion, Date antesD, Date junio, Date octubre, Date marzo, Date mayo){
        DefaultTableModel modeloT = new DefaultTableModel();
        tablaD.setModel(modeloT);
        
        modeloT.addColumn("Nombres");
        modeloT.addColumn("Apellido Paterno");
        modeloT.addColumn("Apellido Materno");
        modeloT.addColumn("Correo");
        modeloT.addColumn("Celular");
        modeloT.addColumn("Categoría");
        modeloT.addColumn("Filial");
        
        Object[] columna = new Object[7];
        
        int numRegistros = nuevo.listEneFeb(categoria, filial, anio, condicion, antesD, junio, octubre, marzo, mayo).size();
        
        for(int i=0; i< numRegistros; i++){
            columna[0]= nuevo.listEneFeb(categoria, filial, anio, condicion, antesD, junio, octubre, marzo, mayo).get(i).getNombres();
            columna[1]= nuevo.listEneFeb(categoria, filial, anio, condicion, antesD, junio, octubre, marzo, mayo).get(i).getApellidoPaterno();
            columna[2]= nuevo.listEneFeb(categoria, filial, anio, condicion, antesD, junio, octubre, marzo, mayo).get(i).getApellidoMaterno();
            columna[3]= nuevo.listEneFeb(categoria, filial, anio, condicion, antesD, junio, octubre, marzo, mayo).get(i).getCorreoElectronico();
            columna[4]= nuevo.listEneFeb(categoria, filial, anio, condicion, antesD, junio, octubre, marzo, mayo).get(i).getCelular();
            columna[5]= nuevo.listEneFeb(categoria, filial, anio, condicion, antesD, junio, octubre, marzo, mayo).get(i).getCategoria();
            columna[6]= nuevo.listEneFeb(categoria, filial, anio, condicion, antesD, junio, octubre, marzo, mayo).get(i).getFilial();
            modeloT.addRow(columna);
        }
    }
    
    public void marMay (JTable tablaD, String categoria, String filial, int anio, int anioPasado, Date antesD, Date noviembre, Date febrero, Date junio, Date octubre){
        DefaultTableModel modeloT = new DefaultTableModel();
        tablaD.setModel(modeloT);
        
        modeloT.addColumn("Nombres");
        modeloT.addColumn("Apellido Paterno");
        modeloT.addColumn("Apellido Materno");
        modeloT.addColumn("Correo");
        modeloT.addColumn("Celular");
        modeloT.addColumn("Categoría");
        modeloT.addColumn("Filial");
        
        Object[] columna = new Object[7];
        
        int numRegistros = nuevo.listMarMay(categoria, filial, anio, anioPasado, antesD, noviembre, febrero, junio, octubre).size();
        
        for(int i=0; i< numRegistros; i++){
            columna[0]= nuevo.listMarMay(categoria, filial, anio, anioPasado, antesD, noviembre, febrero, junio, octubre).get(i).getNombres();
            columna[1]= nuevo.listMarMay(categoria, filial, anio, anioPasado, antesD, noviembre, febrero, junio, octubre).get(i).getApellidoPaterno();
            columna[2]= nuevo.listMarMay(categoria, filial, anio, anioPasado, antesD, noviembre, febrero, junio, octubre).get(i).getApellidoMaterno();
            columna[3]= nuevo.listMarMay(categoria, filial, anio, anioPasado, antesD, noviembre, febrero, junio, octubre).get(i).getCorreoElectronico();
            columna[4]= nuevo.listMarMay(categoria, filial, anio, anioPasado, antesD, noviembre, febrero, junio, octubre).get(i).getCelular();
            columna[5]= nuevo.listMarMay(categoria, filial, anio, anioPasado, antesD, noviembre, febrero, junio, octubre).get(i).getCategoria();
            columna[6]= nuevo.listMarMay(categoria, filial, anio, anioPasado, antesD, noviembre, febrero, junio, octubre).get(i).getFilial();
            modeloT.addRow(columna);
        }
    }
    
    public void junOct (JTable tablaD, String categoria, String filial, int anio, int anioPasado, Date antesD, Date marzo, Date mayo, Date noviembre, Date febrero){
        DefaultTableModel modeloT = new DefaultTableModel();
        tablaD.setModel(modeloT);
        
        modeloT.addColumn("Nombres");
        modeloT.addColumn("Apellido Paterno");
        modeloT.addColumn("Apellido Materno");
        modeloT.addColumn("Correo");
        modeloT.addColumn("Celular");
        modeloT.addColumn("Categoría");
        modeloT.addColumn("Filial");
        
        Object[] columna = new Object[7];
        
        int numRegistros = nuevo.listJunOct(categoria, filial, anio, anioPasado, antesD, marzo, mayo, noviembre, febrero).size();
        
        for(int i=0; i< numRegistros; i++){
            columna[0]= nuevo.listJunOct(categoria, filial, anio, anioPasado, antesD, marzo, mayo, noviembre, febrero).get(i).getNombres();
            columna[1]= nuevo.listJunOct(categoria, filial, anio, anioPasado, antesD, marzo, mayo, noviembre, febrero).get(i).getApellidoPaterno();
            columna[2]= nuevo.listJunOct(categoria, filial, anio, anioPasado, antesD, marzo, mayo, noviembre, febrero).get(i).getApellidoMaterno();
            columna[3]= nuevo.listJunOct(categoria, filial, anio, anioPasado, antesD, marzo, mayo, noviembre, febrero).get(i).getCorreoElectronico();
            columna[4]= nuevo.listJunOct(categoria, filial, anio, anioPasado, antesD, marzo, mayo, noviembre, febrero).get(i).getCelular();
            columna[5]= nuevo.listJunOct(categoria, filial, anio, anioPasado, antesD, marzo, mayo, noviembre, febrero).get(i).getCategoria();
            columna[6]= nuevo.listJunOct(categoria, filial, anio, anioPasado, antesD, marzo, mayo, noviembre, febrero).get(i).getFilial();
            modeloT.addRow(columna);
        }
    }
    //Tablas para asambleas
    public void asambleaDos(JTable tablaD, int anio, String mesPago){
        DefaultTableModel modeloT = new DefaultTableModel();
        tablaD.setModel(modeloT);
        
        modeloT.addColumn("Nombres");
        modeloT.addColumn("Apellido Paterno");
        modeloT.addColumn("Apellido Materno");
        modeloT.addColumn("Rut");
        modeloT.addColumn("Digito verificador");
        
        
        Object[] columna = new Object[5];
        
        int numRegistros = nuevo.listAsambleaDos(anio, mesPago).size();
        
        for(int i=0; i< numRegistros; i++){
            columna[0]= nuevo.listAsambleaDos(anio, mesPago).get(i).getNombres();
            columna[1]= nuevo.listAsambleaDos(anio, mesPago).get(i).getApellidoPaterno();
            columna[2]= nuevo.listAsambleaDos(anio, mesPago).get(i).getApellidoMaterno();
            columna[3]= nuevo.listAsambleaDos(anio, mesPago).get(i).getRut();
            columna[4]= nuevo.listAsambleaDos(anio, mesPago).get(i).getDigitoVerificador();
            modeloT.addRow(columna);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==home.btnMorosos){
            if(categoria() && filial() && cuotasAdeudadas()){
                    if(home.cmbCuotasAdeudadas.getSelectedIndex()==1){
                       if(numeroMes()==0 || numeroMes()==1){
                          int primeraCondicion=2; 
                          int anioPasado = numeroAnio()-1;
                          String categoria = home.cmbCategoriaHome.getSelectedItem().toString();
                          String filial = home.cmbFilialHome.getSelectedItem().toString();
                          
                          Integer.toString(anioPasado);
                          Date antesD = Date.valueOf(anioPasado+"-02-29");
                          Date junio = Date.valueOf(anioPasado+"-06-01");
                          Date octubre = Date.valueOf(anioPasado+"-10-31");
                          Date marzo = Date.valueOf(anioPasado+"-03-01");
                          Date mayo = Date.valueOf(anioPasado+"-05-31");
                          
                          eneFeb(home.jtDatosHome, categoria, filial, anioPasado, primeraCondicion, antesD, junio, octubre, marzo, mayo);
                       }
                       if(numeroMes()==2 || numeroMes()==3 || numeroMes()==4){
                           String categoria = home.cmbCategoriaHome.getSelectedItem().toString();
                           String filial = home.cmbFilialHome.getSelectedItem().toString(); 
                           int anioPasado=numeroAnio()-1;
                           int anio=numeroAnio();
                           
                           Integer.toString(anioPasado);
                           Integer.toString(anio);
                           Date antesD = Date.valueOf(anioPasado+"-05-31");
                           Date noviembre = Date.valueOf(anioPasado+"-11-01");
                           Date febrero = Date.valueOf(anio+"-02-29");
                           Date junio = Date.valueOf(anioPasado+"-06-01");
                           Date octubre = Date.valueOf(anioPasado+"-10-31");
                           
                           marMay(home.jtDatosHome, categoria, filial, anio, anioPasado, antesD, noviembre, febrero, junio, octubre);
                       }
                       if(numeroMes()==5 || numeroMes()==6 || numeroMes()==7 || numeroMes()==8 || numeroMes()==9){
                           
                           int anioPasado=numeroAnio()-1;
                           int anio=numeroAnio();
                           String categoria = home.cmbCategoriaHome.getSelectedItem().toString();
                           String filial = home.cmbFilialHome.getSelectedItem().toString();
                           
                           Integer.toString(anio);
                           Integer.toString(anioPasado);
                           Date antesD = Date.valueOf(anioPasado+"-10-31");
                           Date marzo = Date.valueOf(anio+"-03-01");
                           Date mayo = Date.valueOf(anio+"-05-31");
                           Date noviembre = Date.valueOf(anioPasado+"-11-01");
                           Date febrero = Date.valueOf(anio+"-02-29");
                           
                           junOct(home.jtDatosHome, categoria, filial, anio, anioPasado, antesD, marzo, mayo, noviembre, febrero);
                       }
                       if(numeroMes()==10 || numeroMes()==11){
                           int primeraCondicion=3;
                           int segundaCondicion=2;
                           int anioPasado=numeroAnio()-1;
                           int anio=numeroAnio();
                           String categoria = home.cmbCategoriaHome.getSelectedItem().toString();
                           String filial = home.cmbFilialHome.getSelectedItem().toString();
                           cuotasDosCondiciones(home.jtDatosHome, categoria, filial, anioPasado, primeraCondicion, anio, segundaCondicion);
                       }
                       
                    }
                    if(home.cmbCuotasAdeudadas.getSelectedIndex()==2){
                       if(numeroMes()==0 || numeroMes()==1){
                          int primeraCondicion=1; 
                          int anioPasado = numeroAnio()-1; 
                          String categoria = home.cmbCategoriaHome.getSelectedItem().toString();
                          String filial = home.cmbFilialHome.getSelectedItem().toString();
                          cuotasUnaCondicion(home.jtDatosHome, categoria, filial, anioPasado, primeraCondicion);
                       }
                       if(numeroMes()==2 || numeroMes()==3 || numeroMes()==4){
                          int primeraCondicion=2;
                          int anioPasado=numeroAnio()-1;
                          String categoria = home.cmbCategoriaHome.getSelectedItem().toString();
                          String filial = home.cmbFilialHome.getSelectedItem().toString();
                          cuotasUnaCondicion(home.jtDatosHome, categoria, filial, anioPasado, primeraCondicion);
                          
                       }
                       if(numeroMes()==5 || numeroMes()==6 || numeroMes()==7 || numeroMes()==8 || numeroMes()==9){
                          int primeraCondicion=3;
                          int anioPasado=numeroAnio()-1;
                          String categoria = home.cmbCategoriaHome.getSelectedItem().toString();
                          String filial = home.cmbFilialHome.getSelectedItem().toString();
                          cuotasUnaCondicion(home.jtDatosHome, categoria, filial, anioPasado, primeraCondicion);
                       }
                       if(numeroMes()==10 || numeroMes()==11){
                          int primeraCondicion=3;
                          int segundaCondicion=1;
                          int anioPasado=numeroAnio()-1;
                          int anio=numeroAnio();
                          String categoria = home.cmbCategoriaHome.getSelectedItem().toString();
                          String filial = home.cmbFilialHome.getSelectedItem().toString();
                          cuotasDosCondiciones(home.jtDatosHome, categoria, filial, anioPasado, primeraCondicion, anio, segundaCondicion);
                       }
                    }
                    if(home.cmbCuotasAdeudadas.getSelectedIndex()==3){
                       if(numeroMes()==0 || numeroMes()==1){
                           int primeraCondicion=0; //esta va con otra query
                           int anioPasado=numeroAnio()-1;
                       }
                       if(numeroMes()==2 || numeroMes()==3 || numeroMes()==4){
                           int primeraCondicion=1;
                           int anioPasado=numeroAnio()-1;
                           String categoria = home.cmbCategoriaHome.getSelectedItem().toString();
                           String filial = home.cmbFilialHome.getSelectedItem().toString();
                           cuotasUnaCondicion(home.jtDatosHome, categoria, filial, anioPasado, primeraCondicion);
                       }
                       if(numeroMes()==5 || numeroMes()==6 || numeroMes()==7 || numeroMes()==8 || numeroMes()==9){
                          int primeraCondicion=2;
                          int anioPasado=numeroAnio()-1;
                          String categoria = home.cmbCategoriaHome.getSelectedItem().toString();
                          String filial = home.cmbFilialHome.getSelectedItem().toString();
                          cuotasUnaCondicion(home.jtDatosHome, categoria, filial, anioPasado, primeraCondicion);
                           
                       }
                       if(numeroMes()==10 || numeroMes()==11){
                          int primeraCondicion=3;
                          int segundaCondicion=0; //esta va con otra query
                          int anioPasado=numeroAnio()-1;
                          int anio=numeroAnio();
                          
                       }
                    }
            }else{
                JOptionPane.showMessageDialog(null, "Debe seleccionar una opción en categoría, filial y cuotas adeudadas");
            }
            
        }
        
        if(e.getSource()==home.btnAsamblea){
           if(numeroMes()==0 || numeroMes()==1){
               int anio = numeroAnio() - 1;
               String mesPago = mes();
               asambleaDos(home.jtDatosHome, anio, mesPago);
           }
           if(numeroMes()==2 || numeroMes()==3 || numeroMes()==4){
               int anio = numeroAnio();
               String mesPago = mes();
               asambleaDos(home.jtDatosHome, anio, mesPago);
           } 
           if(numeroMes()== 5 || numeroMes()== 6 || numeroMes()== 7 || numeroMes()== 8 || numeroMes()== 9){
               int anio = numeroAnio();
               String mesPago = mes();
               asambleaDos(home.jtDatosHome, anio, mesPago);
           }
           if(numeroMes()== 10 ||numeroMes()== 11){
               int anio = numeroAnio();
               String mesPago = mes();
               System.out.println(anio + mesPago);
               asambleaDos(home.jtDatosHome, anio, mesPago);
               
           }
           
        }
        
        if(e.getSource()==home.cmbCategoriaHome){
            if(categoria() && filial()){
                home.cmbCuotasAdeudadas.setVisible(true);
            }else{
                home.cmbCuotasAdeudadas.setVisible(false);
            }
        }
        
        if(e.getSource()==home.cmbFilialHome){
            if(categoria() && filial()){
                home.cmbCuotasAdeudadas.setVisible(true);
            }else{
                home.cmbCuotasAdeudadas.setVisible(false);
            }
        }
        
        if(e.getSource()==home.cmbSisHome){
            if(categoria() && filial() && sis()){
                home.cmbCuotasAdeudadas.setVisible(false);
            }else{
                if(categoria() && filial()){
                    home.cmbCuotasAdeudadas.setVisible(true);
                }
                
            }
            
        }
        
        if(e.getSource()==home.btnSocioAlDia){
            if(numeroMes()==0 || numeroMes()==1){
            int anio = numeroAnio() - 1;
            String mesPago = mes();
            tablaAlDia(home.jtDatosHome, anio, mesPago);
            }else{
               int anio = numeroAnio();
               String mesPago = mes();
               tablaAlDia(home.jtDatosHome, anio, mesPago); 
            }
        }
        
        if(e.getSource()==home.btnBusca){
            if(categoria() && sis() && filial()){
               String categoria = home.cmbCategoriaHome.getSelectedItem().toString(); 
               String sis = home.cmbSisHome.getSelectedItem().toString(); 
               String filial = home.cmbFilialHome.getSelectedItem().toString();
               tablaTodo(home.jtDatosHome, categoria, sis, filial);
            }else{
                if(categoria() && sis()){
                   String categoria = home.cmbCategoriaHome.getSelectedItem().toString(); 
                   String sis = home.cmbSisHome.getSelectedItem().toString();
                   tablaCaSis(home.jtDatosHome, categoria, sis);
                }else{
                    if(categoria() && filial()){
                        String categoria = home.cmbCategoriaHome.getSelectedItem().toString();
                        String filial = home.cmbFilialHome.getSelectedItem().toString();
                        tablaCaFi(home.jtDatosHome, categoria, filial);
                    }else{
                        if(sis() && filial()){
                            String sis = home.cmbSisHome.getSelectedItem().toString();
                            String filial = home.cmbFilialHome.getSelectedItem().toString();
                            tablaSiFi(home.jtDatosHome, sis, filial);
                        }else{
                            if(categoria()){
                                String categoria = home.cmbCategoriaHome.getSelectedItem().toString();
                                tablaCategoria(home.jtDatosHome, categoria);
                            }else{
                                if(filial()){
                                    String filial = home.cmbFilialHome.getSelectedItem().toString();
                                    tablaFilial(home.jtDatosHome, filial);
                                }else{
                             
                                    if(sis()){
                                           String sis = home.cmbSisHome.getSelectedItem().toString();
                                           tablaSis(home.jtDatosHome, sis);
                                        }else{
                                            if(universidad()){
                                               String uni = home.cmbUniversidadHome.getSelectedItem().toString();
                                               tablaUniversidad(home.jtDatosHome, uni);
                                            }else{
                                                if(home.txtBuscarHome.getText().length()>0){
                                                    int rut = Integer.parseInt(home.txtBuscarHome.getText());
                                                    tablaPersonal(home.jtDatosHome, rut);
                                                }else{
                                                    JOptionPane.showMessageDialog(null, "Debe seleccionar lo que desea buscar");
                                                }
                                            }
                                        }
                                    
                                }
                            }
                        }
                    }
                }
            }
        }
        
        if(e.getSource()==home.btnCrudSocio){
            nuevo = new Socio();
            crud = new Crud();
            universidad = new Universidad();
            lab = new Laboral();
            actividad = new Actividad();
            cuota = new CuotaSocial();
            ControlCrud ctrl = new ControlCrud(nuevo, crud, nuevo, universidad, lab);
            ControlCrudModi ctrlMod = new ControlCrudModi(nuevo, crud, lab, nuevo);
            ControlCrudEstado ctrlEs = new ControlCrudEstado(crud, actividad, nuevo);
            ControlCrudPago ctrlPa = new ControlCrudPago(crud, nuevo, nuevo, cuota);
            home.dispose();
            ctrl.iniciar();
            crud.setVisible(true);
        }
        
        if(e.getSource()==home.cmbCategoriaHome){
           if(categoria()){
               home.cmbUniversidadHome.setSelectedIndex(0);
               home.cmbUniversidadHome.setEnabled(false);
           }else{
               if(!(categoria()) && !(filial()) && !(sis())){
               home.cmbUniversidadHome.setEnabled(true);
               }
           }
        }
        
        if(e.getSource()==home.cmbFilialHome){
            if(filial()){
               home.cmbUniversidadHome.setSelectedIndex(0);
               home.cmbUniversidadHome.setEnabled(false); 
            }else{
                if(!(categoria()) && !(filial()) && !(sis())){
               home.cmbUniversidadHome.setEnabled(true);
                }
            }
        }
        
        if(e.getSource()==home.cmbSisHome){
           if(sis()){
               home.cmbUniversidadHome.setSelectedIndex(0);
               home.cmbUniversidadHome.setEnabled(false);
           }else{
               if(!(categoria()) && !(filial()) && !(sis())){
               home.cmbUniversidadHome.setEnabled(true);
               }
           }
        }
        
        if(e.getSource()==home.cmbUniversidadHome){
            if(universidad()){
                home.cmbCategoriaHome.setSelectedIndex(0);
                home.cmbFilialHome.setSelectedIndex(0);
                home.cmbSisHome.setSelectedIndex(0);
            }else{
                if(!universidad()){
                    
                }
            }
        }
        
        if(e.getSource()==home.btnRefrescar){
            refrescar();
        }
        
        
        
    }
    
    private boolean categoria(){
        return home.cmbCategoriaHome.getSelectedIndex() != 0 &&
               home.cmbCategoriaHome.getSelectedIndex() != -1;
    }
    
    private boolean sis(){
        return home.cmbSisHome.getSelectedIndex() != 0 &&
               home.cmbSisHome.getSelectedIndex() != -1;
    }
    
    private boolean filial(){
        return home.cmbFilialHome.getSelectedIndex() != 0 &&
               home.cmbFilialHome.getSelectedIndex() != -1;
    }
    
    private boolean universidad(){
        return home.cmbUniversidadHome.getSelectedIndex() != 0 &&
               home.cmbUniversidadHome.getSelectedIndex() != -1;
    }
    
    private boolean cuotasAdeudadas(){
        return home.cmbCuotasAdeudadas.getSelectedIndex() != 0 &&
               home.cmbCuotasAdeudadas.getSelectedIndex() != -1;
    }
    
    private int numeroMes(){
        Calendar calendario = Calendar.getInstance();
        int mes = calendario.get(Calendar.MONTH);
        return mes;
    }
    
    private int numeroAnio(){
        Calendar calendario = Calendar.getInstance();
        int anio = calendario.get(Calendar.YEAR);
        return anio;
    }
    
    private void refrescar(){
        home.cmbCategoriaHome.setSelectedIndex(0);
        home.cmbFilialHome.setSelectedIndex(0);
        home.cmbSisHome.setSelectedIndex(0);
        home.cmbUniversidadHome.setSelectedIndex(0);
        home.cmbCuotasAdeudadas.setSelectedIndex(0);
        home.txtBuscarHome.setText("");
    }
    
    private int cantidadCuotasPagadas(){
    int mes = numeroMes();
    int resultado;
    switch(mes){
        case(0):
            resultado =0;
            break;
        case(1):
            resultado =0;
            break;
        case(2):
            resultado =1;
            break;
        case(3):
            resultado =1;
            break;
        case(4):
            resultado =1;
            break;
        case(5):
            resultado =2;
            break;
        case(6):
            resultado =2;
            break;
        case(7):
            resultado =2;
            break;
        case(8):
            resultado =2;
            break;
        case(9):
            resultado =2;
            break;
        case(10):
            resultado =3;
            break;
        case(11):
            resultado =3;
            break;
        default:
            resultado = 0;
    }
    return resultado;
    }
    
    private String mes(){
    int mes = numeroMes();
    String resultado = null;
    switch(mes){
        case(0):
            resultado ="octubre";
            break;
        case(1):
            resultado ="octubre";
            break;
        case(2):
            resultado ="febrero";
            break;
        case(3):
            resultado ="febrero";
            break;
        case(4):
            resultado ="febrero";
            break;
        case(5):
            resultado ="mayo";
            break;
        case(6):
            resultado ="mayo";
            break;
        case(7):
            resultado ="mayo";
            break;
        case(8):
            resultado ="mayo";
            break;
        case(9):
            resultado ="mayo";
            break;
        case(10):
            resultado ="octubre";
            break;
        case(11):
            resultado ="octubre";
            break;
        
    }
    return resultado;
    }
}
