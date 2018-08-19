/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import conexionDB.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import modelo.Actividad;
import modelo.CuotaSocial;
import modelo.Laboral;
import modelo.Socio;
import modelo.Universidad;

/**
 *
 * @author Ignacio
 */
public class Registro {

    private static Registro aux;
    
    
    private Registro(){}
    
    
    public static Registro metodo(){
        if(aux == null){
            aux = new Registro();
        }
        return aux;
    }
    
    //Métodos relacionados al ingreso de socios
    public boolean agregarSocioCompleto(Socio nuevo){//Referencia
        try {
            Statement s = Conexion.obtenerInstancia().createStatement();
            if(!buscar(nuevo.getRut())){
                String sentencia = "INSERT INTO TBL_SOCIO (CATEGORIA, RUT, DV, NOMBRES, APELLIDO_PATERNO, APELLIDO_MATERNO, CORREO, CELULAR, TBL_UNIVERSIDAD_CODIGO_INGRESO, ESTADO, FILIAL, FECHA_INGRESO, SIS)"+
                                   "VALUES ('"+nuevo.getCategoria()+"',"+nuevo.getRut()+","+nuevo.getDigitoVerificador()+",'"+nuevo.getApellidoPaterno()+"','"+nuevo.getApellidoMaterno()+"','"+nuevo.getCorreoElectronico()+"','"+nuevo.getCelular()+"','"+
                                   nuevo.getCodigoSocioUniversidad()+"',"+nuevo.getEstado()+",'"+nuevo.getFilial()+"',"+nuevo.getAnioIngreso()+",'"+nuevo.getSis()+"')";

                s.execute(sentencia);

                System.out.println("Insertado con exito");
                return true;
            }else{
                System.out.println("Codigo repetido");
            }
        } catch (SQLException ex) {
            System.out.println("No se pudo agregar");
        }
        return false;
    }
    
    public boolean agregarSocioCompletoEstudiantil(Socio nuevo){//Completo
        try {
            Statement s = Conexion.obtenerInstancia().createStatement();
            if(!buscar(nuevo.getRut())){
                String sentencia = "INSERT INTO TBL_SOCIO (CATEGORIA, RUT, DV, NOMBRES, APELLIDO_PATERNO, APELLIDO_MATERNO, CORREO, CELULAR, TBL_UNIVERSIDAD_CODIGO_INGRESO, ESTADO, FILIAL, FECHA_INGRESO, SIS)"+
                                   "VALUES ('"+nuevo.getCategoria()+"',"+nuevo.getRut()+","+nuevo.getDigitoVerificador()+",'"+nuevo.getApellidoPaterno()+"','"+nuevo.getApellidoMaterno()+"','"+nuevo.getCorreoElectronico()+"','"+nuevo.getCelular()+"','"+
                                   nuevo.getCodigoSocioUniversidad()+"',"+nuevo.getEstado()+",'"+nuevo.getFilial()+"',"+nuevo.getAnioIngreso()+",'"+nuevo.getSis()+"')";

                s.execute(sentencia);

                System.out.println("Insertado con exito");
                return true;
            }else{
                System.out.println("Codigo repetido");
            }
        } catch (SQLException ex) {
            System.out.println("No se pudo agregar");
        }
        return false;
    }
    
    public boolean agregarSocioEstudiantil(Socio nuevo){//Sin apellido materno
        try {
            Statement s = Conexion.obtenerInstancia().createStatement();
            if(!buscar(nuevo.getRut())){
                String sentencia = "INSERT INTO TBL_SOCIO (CATEGORIA, RUT, DV, NOMBRES, APELLIDO_PATERNO,  CORREO, CELULAR, TBL_UNIVERSIDAD_CODIGO_INGRESO, ESTADO, FILIAL, FECHA_INGRESO, SIS)"+
                                   "VALUES ('"+nuevo.getCategoria()+"',"+nuevo.getRut()+","+nuevo.getDigitoVerificador()+",'"+nuevo.getApellidoPaterno()+"','"+nuevo.getCorreoElectronico()+"','"+nuevo.getCelular()+"','"+
                                   nuevo.getCodigoSocioUniversidad()+"',"+nuevo.getEstado()+",'"+nuevo.getFilial()+"',"+nuevo.getAnioIngreso()+",'"+nuevo.getSis()+"')";

                s.execute(sentencia);

                System.out.println("Insertado con exito");
                return true;
            }else{
                System.out.println("Codigo repetido");
            }
        } catch (SQLException ex) {
            System.out.println("No se pudo agregar");
        }
        return false;
    }
    
    public boolean agregarSocioComp(Socio nuevo){//Socio completo
        try {
            Statement s = Conexion.obtenerInstancia().createStatement();
            if(!buscar(nuevo.getRut())){
                String sentencia = "INSERT INTO TBL_SOCIO (CATEGORIA, RUT, DV, NOMBRES, APELLIDO_PATERNO, APELLIDO_MATERNO, CORREO, CELULAR,  ESTADO, FILIAL, FECHA_INGRESO, SIS)"+
                                   "VALUES ('"+nuevo.getCategoria()+"',"+nuevo.getRut()+","+nuevo.getDigitoVerificador()+",'"+nuevo.getApellidoPaterno()+"','"+nuevo.getApellidoMaterno()+"','"+nuevo.getCorreoElectronico()+"','"+nuevo.getCelular()+"',"+nuevo.getEstado()+",'"+nuevo.getFilial()+"',"+nuevo.getAnioIngreso()+",'"+nuevo.getSis()+"')";

                s.execute(sentencia);

                System.out.println("Insertado con exito");
                return true;
            }else{
                System.out.println("Codigo repetido");
            }
        } catch (SQLException ex) {
            System.out.println("No se pudo agregar");
        }
        return false;
    }
    
    public boolean agregarSocio(Socio nuevo){//Sin apellido materno
        try {
            Statement s = Conexion.obtenerInstancia().createStatement();
            if(!buscar(nuevo.getRut())){
                String sentencia = "INSERT INTO TBL_SOCIO (CATEGORIA, RUT, DV, NOMBRES, APELLIDO_PATERNO,  CORREO, CELULAR,  ESTADO, FILIAL, FECHA_INGRESO, SIS)"+
                                   "VALUES ('"+nuevo.getCategoria()+"',"+nuevo.getRut()+","+nuevo.getDigitoVerificador()+",'"+nuevo.getApellidoPaterno()+"','"+nuevo.getCorreoElectronico()+"','"+nuevo.getCelular()+"',"+nuevo.getEstado()+",'"+nuevo.getFilial()+"',"+nuevo.getAnioIngreso()+",'"+nuevo.getSis()+"')";

                s.execute(sentencia);

                System.out.println("Insertado con exito");
                return true;
            }else{
                System.out.println("Codigo repetido");
            }
        } catch (SQLException ex) {
            System.out.println("No se pudo agregar");
        }
        return false;
    }
    
    //Metodo de borrar un socio
    public boolean borrar(int rut){
        if(buscar(rut)){//se usa el metodo buscar para comprobar si elcodigo ya esta registrado
            String sentencia="DELETE FROM SOCIO WHERE RUT="+rut;//String de la sentencia para borrar el producto con el codigo
            try {
                Statement s = Conexion.obtenerInstancia().createStatement();//se crea el statment de la conexion
                s.executeUpdate(sentencia);//se ejecuta la sentencia sql
                System.out.println(" registro borrado...");//mensaje de exito
                return true;//retorno de exito al borrar
            } catch (SQLException ex) {
                System.out.println("registro no encontrado");//mensaje de error
            }
            return false;//retorno de error al borrar
        }
        return false;//retorno de no se encuentra en la base de datos
    }
    
    //Modificar un socio ... CATEGORIA, RUT, DV, NOMBRES, APELLIDO_PATERNO, APELLIDO_MATERNO, CORREO, CELULAR, TBL_UNIVERSIDAD_CODIGO_INGRESO, ESTADO, FILIAL, FECHA_INGRESO, SIS
    public boolean modificarSocioCompleto(Socio nuevo){
        
        try {
            Statement s = Conexion.obtenerInstancia().createStatement();//se crea el statment de la conexion
            if(buscar(nuevo.getRut())){//se usa el metodo buscar para comprobar si elcodigo ya esta registrado
                String sentencia =  "UPDATE SOCIO SET "+ 
                                        "CATEGORIA = '"+nuevo.getCategoria()+"',"+
                                        "RUT = "+nuevo.getRut()+","+
                                        "DV = "+nuevo.getDigitoVerificador()+","+
                                        "NOMBRES = '"+nuevo.getNombres()+"'"+
                                        "APELLIDO_PATERNO = '"+nuevo.getApellidoPaterno()+"'"+
                                        "APELLIDO_MATERNO = '"+nuevo.getApellidoMaterno()+"'"+
                                        "CORREO = '"+nuevo.getCorreoElectronico()+"'"+
                                        "CELULAR = '"+nuevo.getCelular()+"'"+
                                        "ESTADO = "+nuevo.getEstado()+""+
                                        "FILIAL = '"+nuevo.getFilial()+"'"+
                                        "FECHA_INGRESO = "+nuevo.getAnioIngreso()+""+
                                        "SIS = '"+nuevo.getSis()+"'"+
                                    "WHERE RUT = "+nuevo.getRut();//busca el codigo especifico

                s.execute(sentencia);//se ejecuta la sentencia sql

                System.out.println("Modificado con exito");//mensaje de exito
                return true;//reorno de exito
            }else{
                System.out.println("Codigo no encontrado");//mensaje de error si el codigo no esta registrado
            }
        } catch (SQLException ex) {
            System.out.println("No se pudo modficar");//mensaje de error si no se modificó
        }
        return false;//retorno de error
    }
    
    public boolean modificarSocio(Socio nuevo){//Sin apellido materno
        
        try {
            Statement s = Conexion.obtenerInstancia().createStatement();//se crea el statment de la conexion
            if(buscar(nuevo.getRut())){//se usa el metodo buscar para comprobar si elcodigo ya esta registrado
                String sentencia =  "UPDATE SOCIO SET "+ 
                                        "CATEGORIA = '"+nuevo.getCategoria()+"',"+
                                        "RUT = "+nuevo.getRut()+","+
                                        "DV = "+nuevo.getDigitoVerificador()+","+
                                        "NOMBRES = '"+nuevo.getNombres()+"'"+
                                        "APELLIDO_PATERNO = '"+nuevo.getApellidoPaterno()+"'"+
                                        "CORREO = '"+nuevo.getCorreoElectronico()+"'"+
                                        "CELULAR = '"+nuevo.getCelular()+"'"+
                                        "ESTADO = "+nuevo.getEstado()+""+
                                        "FILIAL = '"+nuevo.getFilial()+"'"+
                                        "FECHA_INGRESO = "+nuevo.getAnioIngreso()+""+
                                        "SIS = '"+nuevo.getSis()+"'"+
                                    "WHERE RUT = "+nuevo.getRut();//busca el codigo especifico

                s.execute(sentencia);//se ejecuta la sentencia sql

                System.out.println("Modificado con exito");//mensaje de exito
                return true;//reorno de exito
            }else{
                System.out.println("Codigo no encontrado");//mensaje de error si el codigo no esta registrado
            }
        } catch (SQLException ex) {
            System.out.println("No se pudo modficar");//mensaje de error si no se modificó
        }
        return false;//retorno de error
    }
    
    //Mostrar todos los socios
    public ResultSet mostrarSocio(){
        String sentencia = "SELECT * FROM SOCIO";//String de la sentencia para buscar los productos agregados
        Statement s;//se crea el statment de la conexion
        
        try {
            s = Conexion.obtenerInstancia().createStatement();//se instancia el statment de la conexion
            System.out.println(" Cargando datos...");
            ResultSet resultado=s.executeQuery(sentencia);//se ejecuta la sentencia sql y se le da valor al resulltado
            return resultado;//se retorna el resulatdo de la consulta como ResultSet
        } 
        catch (SQLException ex) {
            System.out.println("Error en la carga de datos");//mensaje de error
            return null;//retorna nulo si hubo un fallo en la carga de datos
        } 
    }
    
    //Ingresar Universidad
    public boolean agregarUniversidad(Universidad nuevo){//Universidad
        try {
            Statement s = Conexion.obtenerInstancia().createStatement();
            if(!buscarUniversidad(nuevo.getCodigoIngreso())){
                String sentencia = "INSERT INTO TBL_UNIVERSIDAD (CODIGO_INGRESO, ANIO_INGRESO, NOMBRE_UNIVERSIDAD, SEDE)"+
                                   "VALUES ('"+nuevo.getCodigoIngreso()+"',"+nuevo.getAnioIngresoU()+",'"+nuevo.getNombreUniversidad()+"','"+nuevo.getSede()+"')";

                s.execute(sentencia);

                System.out.println("Insertado con exito");
                return true;
            }else{
                System.out.println("Codigo repetido");
            }
        } catch (SQLException ex) {
            System.out.println("No se pudo agregar");
        }
        return false;
    }
    
    
    //Ingresar laborales
    public boolean agregarLaboral(Laboral nuevo){//LaboralCompleto
        try {
            Statement s = Conexion.obtenerInstancia().createStatement();
            if(!buscarLaboral(nuevo.getDireccion(), nuevo.getLaboralRut())){
                String sentencia = "INSERT INTO TBL_LABORAL (DIRECCION, PISO, OFICINA, TELEFONO, REFERENCIA, SITIO_WEB, TBL_SOCIO_RUT, TBL_SOCIO_CATEGORIA, TBL_COMUNA_CODIGO_COMUNA, NOMBRE_LABORAL)"+
                                   "VALUES ('"+nuevo.getDireccion()+"',"+nuevo.getPiso()+",'"+nuevo.getOficina()+"',"+nuevo.getNumeroTelefono()+",'"+nuevo.getReferencia()+"','"+nuevo.getSitioWeb()+"',"+nuevo.getLaboralRut()+",'"+nuevo.getLaboralCategoria()+"',"+nuevo.getCodigoComunaLaboral()+",'"+nuevo.getNombreLaboral()+"')";

                s.execute(sentencia);

                System.out.println("Insertado con exito");
                return true;
            }else{
                System.out.println("Codigo repetido");
            }
        } catch (SQLException ex) {
            System.out.println("No se pudo agregar");
        }
        return false;
    }
    
    public boolean agregarLaboralSimple(Laboral nuevo){//Laboral con el minimo de los campos a llenar
        try {
            Statement s = Conexion.obtenerInstancia().createStatement();
            if(!buscarLaboral(nuevo.getDireccion(), nuevo.getLaboralRut())){
                String sentencia = "INSERT INTO TBL_LABORAL (DIRECCION,  TELEFONO,  TBL_SOCIO_RUT, TBL_SOCIO_CATEGORIA, TBL_COMUNA_CODIGO_COMUNA)"+
                                   "VALUES ('"+nuevo.getDireccion()+"',"+nuevo.getNumeroTelefono()+","+nuevo.getLaboralRut()+",'"+nuevo.getLaboralCategoria()+"',"+nuevo.getCodigoComunaLaboral()+")";

                s.execute(sentencia);

                System.out.println("Insertado con exito");
                return true;
            }else{
                System.out.println("Codigo repetido");
            }
        } catch (SQLException ex) {
            System.out.println("No se pudo agregar");
        }
        return false;
    }
    
    public boolean agregarLaboralPiso(Laboral nuevo){//Laboral con el minimo de los campos a llenar más el piso
        try {
            Statement s = Conexion.obtenerInstancia().createStatement();
            if(!buscarLaboral(nuevo.getDireccion(), nuevo.getLaboralRut())){
                String sentencia = "INSERT INTO TBL_LABORAL (DIRECCION, PISO,  TELEFONO,  TBL_SOCIO_RUT, TBL_SOCIO_CATEGORIA, TBL_COMUNA_CODIGO_COMUNA)"+
                                   "VALUES ('"+nuevo.getDireccion()+"',"+nuevo.getPiso()+","+nuevo.getNumeroTelefono()+","+nuevo.getLaboralRut()+",'"+nuevo.getLaboralCategoria()+"',"+nuevo.getCodigoComunaLaboral()+")";

                s.execute(sentencia);

                System.out.println("Insertado con exito");
                return true;
            }else{
                System.out.println("Codigo repetido");
            }
        } catch (SQLException ex) {
            System.out.println("No se pudo agregar");
        }
        return false;
    }
    
    public boolean agregarLaboralPisoC(Laboral nuevo){//LaboralCompleto
        try {
            Statement s = Conexion.obtenerInstancia().createStatement();
            if(!buscarLaboral(nuevo.getDireccion(), nuevo.getLaboralRut())){
                String sentencia = "INSERT INTO TBL_LABORAL (DIRECCION, PISO,  TELEFONO, REFERENCIA, SITIO_WEB, TBL_SOCIO_RUT, TBL_SOCIO_CATEGORIA, TBL_COMUNA_CODIGO_COMUNA, NOMBRE_LABORAL)"+
                                   "VALUES ('"+nuevo.getDireccion()+"',"+nuevo.getPiso()+","+nuevo.getNumeroTelefono()+",'"+nuevo.getReferencia()+"','"+nuevo.getSitioWeb()+"',"+nuevo.getLaboralRut()+",'"+nuevo.getLaboralCategoria()+"',"+nuevo.getCodigoComunaLaboral()+",'"+nuevo.getNombreLaboral()+"')";

                s.execute(sentencia);

                System.out.println("Insertado con exito");
                return true;
            }else{
                System.out.println("Codigo repetido");
            }
        } catch (SQLException ex) {
            System.out.println("No se pudo agregar");
        }
        return false;
    }
    
    public boolean agregarLaboralOficina(Laboral nuevo){//Laboral con el minimo de los campos a llenar más la oficina
        try {
            Statement s = Conexion.obtenerInstancia().createStatement();
            if(!buscarLaboral(nuevo.getDireccion(), nuevo.getLaboralRut())){
                String sentencia = "INSERT INTO TBL_LABORAL (DIRECCION, OFICINA, TELEFONO,  TBL_SOCIO_RUT, TBL_SOCIO_CATEGORIA, TBL_COMUNA_CODIGO_COMUNA)"+
                                   "VALUES ('"+nuevo.getDireccion()+"','"+nuevo.getOficina()+"',"+nuevo.getNumeroTelefono()+","+nuevo.getLaboralRut()+",'"+nuevo.getLaboralCategoria()+"',"+nuevo.getCodigoComunaLaboral()+")";

                s.execute(sentencia);

                System.out.println("Insertado con exito");
                return true;
            }else{
                System.out.println("Codigo repetido");
            }
        } catch (SQLException ex) {
            System.out.println("No se pudo agregar");
        }
        return false;
    }
    
    public boolean agregarLaboralOficinaC(Laboral nuevo){//LaboralCompleto
        try {
            Statement s = Conexion.obtenerInstancia().createStatement();
            if(!buscarLaboral(nuevo.getDireccion(), nuevo.getLaboralRut())){
                String sentencia = "INSERT INTO TBL_LABORAL (DIRECCION,  OFICINA, TELEFONO, REFERENCIA, SITIO_WEB, TBL_SOCIO_RUT, TBL_SOCIO_CATEGORIA, TBL_COMUNA_CODIGO_COMUNA, NOMBRE_LABORAL)"+
                                   "VALUES ('"+nuevo.getDireccion()+"','"+nuevo.getOficina()+"',"+nuevo.getNumeroTelefono()+",'"+nuevo.getReferencia()+"','"+nuevo.getSitioWeb()+"',"+nuevo.getLaboralRut()+",'"+nuevo.getLaboralCategoria()+"',"+nuevo.getCodigoComunaLaboral()+",'"+nuevo.getNombreLaboral()+"')";

                s.execute(sentencia);

                System.out.println("Insertado con exito");
                return true;
            }else{
                System.out.println("Codigo repetido");
            }
        } catch (SQLException ex) {
            System.out.println("No se pudo agregar");
        }
        return false;
    }
    
    public boolean agregarLaboralPiOf(Laboral nuevo){//Laboral con el minimo de los campos a llenar más el piso y la oficina
        try {
            Statement s = Conexion.obtenerInstancia().createStatement();
            if(!buscarLaboral(nuevo.getDireccion(), nuevo.getLaboralRut())){
                String sentencia = "INSERT INTO TBL_LABORAL (DIRECCION, PISO, OFICINA,  TELEFONO,  TBL_SOCIO_RUT, TBL_SOCIO_CATEGORIA, TBL_COMUNA_CODIGO_COMUNA)"+
                                   "VALUES ('"+nuevo.getDireccion()+"',"+nuevo.getPiso()+",'"+nuevo.getOficina()+"',"+nuevo.getNumeroTelefono()+","+nuevo.getLaboralRut()+",'"+nuevo.getLaboralCategoria()+"',"+nuevo.getCodigoComunaLaboral()+")";

                s.execute(sentencia);

                System.out.println("Insertado con exito");
                return true;
            }else{
                System.out.println("Codigo repetido");
            }
        } catch (SQLException ex) {
            System.out.println("No se pudo agregar");
        }
        return false;
    }
    
    //Borrar un laboral
    public boolean borrarLaboral(int rut, String direccion){
        if(buscarLaboral(direccion, rut)){//se usa el metodo buscar para comprobar si elcodigo ya esta registrado
            String sentencia="DELETE FROM LABORAL WHERE TBL_SOCIO_RUT ="+rut+"AND DIRECCION ="+direccion;//String de la sentencia para borrar el producto con el codigo
            try {
                Statement s = Conexion.obtenerInstancia().createStatement();//se crea el statment de la conexion
                s.executeUpdate(sentencia);//se ejecuta la sentencia sql
                System.out.println(" registro borrado...");//mensaje de exito
                return true;//retorno de exito al borrar
            } catch (SQLException ex) {
                System.out.println("registro no encontrado");//mensaje de error
            }
            return false;//retorno de error al borrar
        }
        return false;//retorno de no se encuentra en la base de datos
    }
    
    //Mostrar laboral 
    public ResultSet mostrarLaboral(){
        String sentencia = "SELECT * FROM TBL_LABORAL ORDER BY TBL_SOCIO_RUT ASC";//String de la sentencia para buscar los productos agregados
        Statement s;//se crea el statment de la conexion
        
        try {
            s = Conexion.obtenerInstancia().createStatement();//se instancia el statment de la conexion
            System.out.println(" Cargando datos...");
            ResultSet resultado=s.executeQuery(sentencia);//se ejecuta la sentencia sql y se le da valor al resulltado
            return resultado;//se retorna el resulatdo de la consulta como ResultSet
        } 
        catch (SQLException ex) {
            System.out.println("Error en la carga de datos");//mensaje de error
            return null;//retorna nulo si hubo un fallo en la carga de datos
        } 
    }
    
    
    //Agregar un nuevo pago
    public boolean agregarNuevoPago(CuotaSocial nuevo){//Cuota Social
        try {
            Statement s = Conexion.obtenerInstancia().createStatement();
            if(!buscarCuota(nuevo.getCuotaRut(), nuevo.getFechaPago())){
                String sentencia = "INSERT INTO TBL_CUOTA_SOCIAL (FECHA_PAGO, MONTO, FORMA_PAGO, TBL_SOCIO_RUT, TBL_SOCIO_CATEGORIA)"+
                                   "VALUES ("+nuevo.getFechaPago()+","+nuevo.getMonto()+",'"+nuevo.getFormaPago()+"',"+nuevo.getCuotaRut()+",'"+nuevo.getCuotaCategoria()+"')";

                s.execute(sentencia);

                System.out.println("Insertado con exito");
                return true;
            }else{
                System.out.println("Codigo repetido");
            }
        } catch (SQLException ex) {
            System.out.println("No se pudo agregar");
        }
        return false;
    }
    
    //Agregar una nueva actividad
    public boolean agregarActividad(Actividad nuevo){//Actividad
        try {
            Statement s = Conexion.obtenerInstancia().createStatement();
            if(!buscarActividad(nuevo.getActividadRut())){
                String sentencia = "INSERT INTO TBL_ACTIVIDAD (FECHA_INICIO_INACTIVIDAD, FECHA_TERMINO_INACTIVIDAD, ESTADO_ACTIVIDAD, MOTIVO, TBL_SOCIO_RUT, TBL_SOCIO_CATEGORIA)"+
                                   "VALUES ("+nuevo.getFechaInicio()+","+nuevo.getFechaTermino()+",'"+nuevo.getEstadoActividad()+"','"+nuevo.getMotivo()+"',"+nuevo.getActividadRut()+",'"+nuevo.getActividadCategoria()+"')";

                s.execute(sentencia);

                System.out.println("Insertado con exito");
                return true;
            }else{
                System.out.println("Codigo repetido");
            }
        } catch (SQLException ex) {
            System.out.println("No se pudo agregar");
        }
        return false;
    }
    
    
    //Buscadores
    public boolean buscar(int rut){
        String sentencia = "SELECT * FROM TBL_SOCIO WHERE RUT = "+rut;//String de la sentencia para buscar el producto
        Statement s;//se crea el statment de la conexion
        
        try {
            s = Conexion.obtenerInstancia().createStatement();//se instancia el statment de la conexion
            System.out.println(" Cargando datos...");
            ResultSet resultado=s.executeQuery(sentencia);//se captura el resultado de la consulta
            if(resultado.next()){//se comprueba que no esté vacio
                System.out.println("encontrado");//mensaje de encontrado
                return true;//retorno de encontrado
            }else{
                System.out.println("no encontrado");//mensaje de no encontrado
                return false;//retorno de no encontrado
            }
        } 
        catch (SQLException ex) {
            System.out.println("Error en la carga de datos");//mensaje de error en la consulta
            return false;//retorno de error en la consulta
        }
    }
    
    public boolean buscarActividad(int rut){//Hay que agregar dentro de la busqueda que revise si el estado de la actividad esta activo, ya que si se termino se puede volver a ingresar el rut. Puede ser que se deba modificar las llaves primarias en la base de datos
        String sentencia = "SELECT * FROM TBL_ACTIVIDAD WHERE TBL_SOCIO_RUT = "+rut;//String de la sentencia para buscar el producto
        Statement s;//se crea el statment de la conexion
        
        try {
            s = Conexion.obtenerInstancia().createStatement();//se instancia el statment de la conexion
            System.out.println(" Cargando datos...");
            ResultSet resultado=s.executeQuery(sentencia);//se captura el resultado de la consulta
            if(resultado.next()){//se comprueba que no esté vacio
                System.out.println("encontrado");//mensaje de encontrado
                return true;//retorno de encontrado
            }else{
                System.out.println("no encontrado");//mensaje de no encontrado
                return false;//retorno de no encontrado
            }
        } 
        catch (SQLException ex) {
            System.out.println("Error en la carga de datos");//mensaje de error en la consulta
            return false;//retorno de error en la consulta
        }
    }
    
    public boolean buscarCuota(int rut, Date fechaPago){
        String sentencia = "SELECT * FROM TBL_CUOTA_SOCIAL WHERE TBL_SOCIO_RUT = "+rut+ "AND FECHA_PAGO"+fechaPago;//String de la sentencia para buscar el producto
        Statement s;//se crea el statment de la conexion
        
        try {
            s = Conexion.obtenerInstancia().createStatement();//se instancia el statment de la conexion
            System.out.println(" Cargando datos...");
            ResultSet resultado=s.executeQuery(sentencia);//se captura el resultado de la consulta
            if(resultado.next()){//se comprueba que no esté vacio
                System.out.println("encontrado");//mensaje de encontrado
                return true;//retorno de encontrado
            }else{
                System.out.println("no encontrado");//mensaje de no encontrado
                return false;//retorno de no encontrado
            }
        } 
        catch (SQLException ex) {
            System.out.println("Error en la carga de datos");//mensaje de error en la consulta
            return false;//retorno de error en la consulta
        }
    }
    
    public boolean buscarUniversidad(String codigoIngreso){
        String sentencia = "SELECT * FROM TBL_UNIVERSIDAD WHERE CODIGO_INGRESO = '"+codigoIngreso+"'";//String de la sentencia para buscar el producto
        Statement s;//se crea el statment de la conexion
        
        try {
            s = Conexion.obtenerInstancia().createStatement();//se instancia el statment de la conexion
            System.out.println(" Cargando datos...");
            ResultSet resultado=s.executeQuery(sentencia);//se captura el resultado de la consulta
            if(resultado.next()){//se comprueba que no esté vacio
                System.out.println("encontrado");//mensaje de encontrado
                return true;//retorno de encontrado
            }else{
                System.out.println("no encontrado");//mensaje de no encontrado
                return false;//retorno de no encontrado
            }
        } 
        catch (SQLException ex) {
            System.out.println("Error en la carga de datos");//mensaje de error en la consulta
            return false;//retorno de error en la consulta
        }
    }
    
    public boolean buscarLaboral(String direccion, int rut){
        String sentencia = "SELECT * FROM TBL_LABORAL WHERE DIRECCION = '"+direccion+"' AND TBL_SOCIO_RUT ="+rut;//String de la sentencia para buscar el producto
        Statement s;//se crea el statment de la conexion
        
        try {
            s = Conexion.obtenerInstancia().createStatement();//se instancia el statment de la conexion
            System.out.println(" Cargando datos...");
            ResultSet resultado=s.executeQuery(sentencia);//se captura el resultado de la consulta
            if(resultado.next()){//se comprueba que no esté vacio
                System.out.println("encontrado");//mensaje de encontrado
                return true;//retorno de encontrado
            }else{
                System.out.println("no encontrado");//mensaje de no encontrado
                return false;//retorno de no encontrado
            }
        } 
        catch (SQLException ex) {
            System.out.println("Error en la carga de datos");//mensaje de error en la consulta
            return false;//retorno de error en la consulta
        }
    }
    
    //Metodos de busqueda 
    public ResultSet mostrarFilial(String filial){
        String sentencia = "SELECT * FROM SOCIO WHERE FILIAL ='" +filial+ "'";//String de la sentencia para buscar los productos agregados
        Statement s;//se crea el statment de la conexion
        
        try {
            s = Conexion.obtenerInstancia().createStatement();//se instancia el statment de la conexion
            System.out.println(" Cargando datos...");
            ResultSet resultado=s.executeQuery(sentencia);//se ejecuta la sentencia sql y se le da valor al resulltado
            return resultado;//se retorna el resulatdo de la consulta como ResultSet
        } 
        catch (SQLException ex) {
            System.out.println("Error en la carga de datos");//mensaje de error
            return null;//retorna nulo si hubo un fallo en la carga de datos
        } 
    }
    
    public ResultSet mostrarCategoria(String categoria){
        String sentencia = "SELECT * FROM SOCIO WHERE CATEGORIA ='"+categoria+"'";//String de la sentencia para buscar los productos agregados
        Statement s;//se crea el statment de la conexion
        
        try {
            s = Conexion.obtenerInstancia().createStatement();//se instancia el statment de la conexion
            System.out.println(" Cargando datos...");
            ResultSet resultado=s.executeQuery(sentencia);//se ejecuta la sentencia sql y se le da valor al resulltado
            return resultado;//se retorna el resulatdo de la consulta como ResultSet
        } 
        catch (SQLException ex) {
            System.out.println("Error en la carga de datos");//mensaje de error
            return null;//retorna nulo si hubo un fallo en la carga de datos
        } 
    }
    
    public ResultSet mostrarSis(String sis){
        String sentencia = "SELECT * FROM SOCIO WHERE SIS ='"+sis+"'";//String de la sentencia para buscar los productos agregados
        Statement s;//se crea el statment de la conexion
        
        try {
            s = Conexion.obtenerInstancia().createStatement();//se instancia el statment de la conexion
            System.out.println(" Cargando datos...");
            ResultSet resultado=s.executeQuery(sentencia);//se ejecuta la sentencia sql y se le da valor al resulltado
            return resultado;//se retorna el resulatdo de la consulta como ResultSet
        } 
        catch (SQLException ex) {
            System.out.println("Error en la carga de datos");//mensaje de error
            return null;//retorna nulo si hubo un fallo en la carga de datos
        } 
    }
    
    
    
}
