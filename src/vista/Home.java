/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Conexion;

/**
 *
 * @author Ignacio
 */
public class Home extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    int x, y;
    public Home() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        cmbCuotasAdeudadas.setVisible(false);
        
        ResultSet rs;
        
        
        
        try{
            String sentencia = "SELECT DISTINCT nombre_universidad FROM tbl_universidad";
            PreparedStatement ps = Conexion.obtenerInstancia().prepareStatement(sentencia);
            rs = ps.executeQuery();
            
            cmbUniversidadHome.addItem("Seleccione universidad");
            
            
            while(rs.next()){
                if(rs.getString("nombre_universidad").length() > 0){
                
                cmbUniversidadHome.addItem(rs.getString("nombre_universidad"));
                }
                
            }
            
            rs.close();
            
        }catch(SQLException ex){
            System.out.println("No se pudo conectar a la base de datos");
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpBarraHerramientas = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        btnMorosos = new javax.swing.JButton();
        btnSocioAlDia = new javax.swing.JButton();
        btnAsamblea = new javax.swing.JButton();
        btnCrudSocio = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lbCategoria = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtBuscarHome = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cmbCategoriaHome = new javax.swing.JComboBox();
        cmbSisHome = new javax.swing.JComboBox();
        cmbUniversidadHome = new javax.swing.JComboBox();
        cmbFilialHome = new javax.swing.JComboBox();
        btnRefrescar = new javax.swing.JButton();
        btnExcel = new javax.swing.JButton();
        btnBusca = new javax.swing.JButton();
        cmbCuotasAdeudadas = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtDatosHome = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpBarraHerramientas.setBackground(new java.awt.Color(3, 169, 244));
        jpBarraHerramientas.setForeground(new java.awt.Color(3, 169, 244));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/menu.png"))); // NOI18N

        btnMorosos.setBackground(new java.awt.Color(3, 169, 244));
        btnMorosos.setForeground(new java.awt.Color(3, 169, 244));
        btnMorosos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/tiempo-es-dinero.png"))); // NOI18N
        btnMorosos.setBorder(null);
        btnMorosos.setBorderPainted(false);
        btnMorosos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMorosos.setFocusPainted(false);
        btnMorosos.setFocusable(false);
        btnMorosos.setOpaque(false);
        btnMorosos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMorososMouseClicked(evt);
            }
        });

        btnSocioAlDia.setBackground(new java.awt.Color(3, 169, 244));
        btnSocioAlDia.setForeground(new java.awt.Color(3, 169, 244));
        btnSocioAlDia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/archivo.png"))); // NOI18N
        btnSocioAlDia.setBorder(null);
        btnSocioAlDia.setBorderPainted(false);
        btnSocioAlDia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSocioAlDia.setFocusPainted(false);
        btnSocioAlDia.setFocusable(false);
        btnSocioAlDia.setOpaque(false);
        btnSocioAlDia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSocioAlDiaMouseClicked(evt);
            }
        });

        btnAsamblea.setBackground(new java.awt.Color(3, 169, 244));
        btnAsamblea.setForeground(new java.awt.Color(3, 169, 244));
        btnAsamblea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/trabajo-en-equipo.png"))); // NOI18N
        btnAsamblea.setBorder(null);
        btnAsamblea.setBorderPainted(false);
        btnAsamblea.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAsamblea.setFocusPainted(false);
        btnAsamblea.setFocusable(false);
        btnAsamblea.setOpaque(false);
        btnAsamblea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAsambleaMouseClicked(evt);
            }
        });

        btnCrudSocio.setBackground(new java.awt.Color(3, 169, 244));
        btnCrudSocio.setForeground(new java.awt.Color(3, 169, 244));
        btnCrudSocio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/usuario (3).png"))); // NOI18N
        btnCrudSocio.setBorder(null);
        btnCrudSocio.setBorderPainted(false);
        btnCrudSocio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCrudSocio.setFocusPainted(false);
        btnCrudSocio.setFocusable(false);
        btnCrudSocio.setOpaque(false);
        btnCrudSocio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCrudSocioMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jpBarraHerramientasLayout = new javax.swing.GroupLayout(jpBarraHerramientas);
        jpBarraHerramientas.setLayout(jpBarraHerramientasLayout);
        jpBarraHerramientasLayout.setHorizontalGroup(
            jpBarraHerramientasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBarraHerramientasLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel14)
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(jpBarraHerramientasLayout.createSequentialGroup()
                .addGroup(jpBarraHerramientasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMorosos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jpBarraHerramientasLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnCrudSocio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jpBarraHerramientasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpBarraHerramientasLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(btnSocioAlDia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jpBarraHerramientasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpBarraHerramientasLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(btnAsamblea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jpBarraHerramientasLayout.setVerticalGroup(
            jpBarraHerramientasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBarraHerramientasLayout.createSequentialGroup()
                .addGap(285, 285, 285)
                .addComponent(btnMorosos, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnCrudSocio, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 172, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addContainerGap())
            .addGroup(jpBarraHerramientasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpBarraHerramientasLayout.createSequentialGroup()
                    .addGap(26, 26, 26)
                    .addComponent(btnSocioAlDia, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(648, Short.MAX_VALUE)))
            .addGroup(jpBarraHerramientasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpBarraHerramientasLayout.createSequentialGroup()
                    .addGap(154, 154, 154)
                    .addComponent(btnAsamblea, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(520, Short.MAX_VALUE)))
        );

        getContentPane().add(jpBarraHerramientas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 780));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/certificado.png"))); // NOI18N
        lbCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbCategoriaMouseClicked(evt);
            }
        });
        jPanel1.add(lbCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/biblioteca.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 60, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/diploma-de-graduado (1).png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/marcador-de-posicion.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 60, -1, -1));
        jPanel1.add(txtBuscarHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 50, 120, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/menos-linea-recta-horizontal.png"))); // NOI18N
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 10, 20, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/cruz (1).png"))); // NOI18N
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 10, -1, -1));

        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel7.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel7MouseDragged(evt);
            }
        });
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel7MousePressed(evt);
            }
        });
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 60));

        cmbCategoriaHome.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cmbCategoriaHome.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione Categoría", "Honorario", "Colaborador", "De número", "Activo", "Activo/Director", "Honorario/Director", "Estudiantil" }));
        jPanel1.add(cmbCategoriaHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        cmbSisHome.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cmbSisHome.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione SIS", "Endodoncista", "Cirujano Dentista", "Sin Registro" }));
        jPanel1.add(cmbSisHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, -1, -1));

        cmbUniversidadHome.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel1.add(cmbUniversidadHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 110, -1, -1));

        cmbFilialHome.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cmbFilialHome.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione filial", "Punta Arenas", "Puerto Montt", "Santiago", "Temuco", "La Serena", "Ñuble", "Rancagua", "Talca", "Antofagasta", "Iquique" }));
        jPanel1.add(cmbFilialHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 110, -1, -1));

        btnRefrescar.setBackground(new java.awt.Color(255, 255, 255));
        btnRefrescar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/boton-de-refrescar-pagina.png"))); // NOI18N
        btnRefrescar.setBorderPainted(false);
        btnRefrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefrescarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRefrescar, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 50, 50, -1));

        btnExcel.setBackground(new java.awt.Color(255, 255, 255));
        btnExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/sobresalir (2).png"))); // NOI18N
        btnExcel.setBorderPainted(false);
        jPanel1.add(btnExcel, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 50, -1, 30));

        btnBusca.setText("Buscar");
        jPanel1.add(btnBusca, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 50, -1, -1));

        cmbCuotasAdeudadas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione cuotas adeudadas", "1", "2", "3" }));
        jPanel1.add(cmbCuotasAdeudadas, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 110, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, 1130, 150));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtDatosHome.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jtDatosHome);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1130, 630));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 1130, 630));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jLabel7MousePressed

    private void jLabel7MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseDragged
        this.setLocation(this.getLocation().x + evt.getX() - x, this.getLocation().y + evt.getY() - y);
    }//GEN-LAST:event_jLabel7MouseDragged

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        this.setState(Home.ICONIFIED);
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel9MouseClicked

    private void lbCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCategoriaMouseClicked
       
    }//GEN-LAST:event_lbCategoriaMouseClicked

    private void btnMorososMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMorososMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnMorososMouseClicked

    private void btnSocioAlDiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSocioAlDiaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSocioAlDiaMouseClicked

    private void btnAsambleaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAsambleaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAsambleaMouseClicked

    private void btnRefrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefrescarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRefrescarActionPerformed

    private void btnCrudSocioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrudSocioMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCrudSocioMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAsamblea;
    public javax.swing.JButton btnBusca;
    public javax.swing.JButton btnCrudSocio;
    public javax.swing.JButton btnExcel;
    public javax.swing.JButton btnMorosos;
    public javax.swing.JButton btnRefrescar;
    public javax.swing.JButton btnSocioAlDia;
    public javax.swing.JComboBox cmbCategoriaHome;
    public javax.swing.JComboBox cmbCuotasAdeudadas;
    public javax.swing.JComboBox cmbFilialHome;
    public javax.swing.JComboBox cmbSisHome;
    public javax.swing.JComboBox cmbUniversidadHome;
    public javax.swing.JLabel jLabel14;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpBarraHerramientas;
    public javax.swing.JTable jtDatosHome;
    public javax.swing.JLabel lbCategoria;
    public javax.swing.JTextField txtBuscarHome;
    // End of variables declaration//GEN-END:variables
}
