
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author DenisseYEA
 */
public class VentTablonSolicitud extends javax.swing.JFrame {

    int posx, posy, i;
    DefaultTableModel modelo;

    /**
     * Creates new form VentTablonSolicitud
     */
    public VentTablonSolicitud() {
        initComponents();
        jButton3.setVisible(false);
        jButton5.setVisible(false);
        jButton6.setVisible(false);
        modelo = new DefaultTableModel();
        modelo.addColumn("Nombre");
        modelo.addColumn("Puesto");
        modelo.addColumn("Fecha de salida");
        modelo.addColumn("Fecha de llegada");
        modelo.addColumn("Lugar");
        this.jTable1.setModel(modelo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jlFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pendientes", "Aceptadas", "Canceladas", " " }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 190, 120, -1));

        jButton1.setText("ACEPTAR");
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, 90, -1));

        jButton3.setText("ASIGNAR MONTO");
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, -1, -1));

        jButton2.setText("CANCELAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 470, -1, -1));

        jButton4.setText("CONSULTAR");
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, -1, -1));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 130, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar.png"))); // NOI18N
        jLabel1.setText("BUSCAR");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, -1, -1));

        jLabel2.setText("TABLÒN DE SOLICITUD");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 140, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, 750, 300));

        jButton5.setText("OFICIO DE COMISIÒN");
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, -1, -1));

        jButton6.setText("OFICIO DE VIÀTICOS");
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 190, -1, -1));

        jlFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/prueba6.png"))); // NOI18N
        jlFondo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jlFondoMouseDragged(evt);
            }
        });
        jlFondo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jlFondoMousePressed(evt);
            }
        });
        getContentPane().add(jlFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jlFondoMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlFondoMouseDragged
        int xp = evt.getXOnScreen() - posx;
        int yp = evt.getYOnScreen() - posy;
        this.setLocation(xp, yp);
    }//GEN-LAST:event_jlFondoMouseDragged

    private void jlFondoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlFondoMousePressed
        posx = evt.getX();
        posy = evt.getY();
    }//GEN-LAST:event_jlFondoMousePressed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        // TODO add your handling code here:
        switch (jComboBox1.getSelectedIndex()) {
            case 0: {
                jButton3.setVisible(false);
                jButton2.setVisible(true);
                jButton1.setVisible(true);
                jButton5.setVisible(false);
                jButton6.setVisible(false);
                modelo = new DefaultTableModel();
                modelo.addColumn("Nombre");
                modelo.addColumn("Puesto");
                modelo.addColumn("Fecha de salida");
                modelo.addColumn("Fecha de llegada");
                modelo.addColumn("Lugar");
                this.jTable1.setModel(modelo);
                break;
            }
            case 1: {
                jButton1.setVisible(false);
                jButton3.setVisible(true);
                jButton2.setVisible(true);
                jButton5.setVisible(true);
                jButton6.setVisible(true);
                modelo = new DefaultTableModel();
                modelo.addColumn("Folio");
                modelo.addColumn("Monto");
                modelo.addColumn("Fecha de salida");
                modelo.addColumn("Fecha de llegada");
                modelo.addColumn("Lugar");
                this.jTable1.setModel(modelo);
                break;
            }
            case 2: {
                jButton3.setVisible(false);
                jButton2.setVisible(false);
                jButton1.setVisible(true);
                jButton5.setVisible(false);
                jButton6.setVisible(false);
                modelo = new DefaultTableModel();
                modelo.addColumn("Nombre");
                modelo.addColumn("Puesto");
                modelo.addColumn("Fecha de salida");
                modelo.addColumn("Fecha de llegada");
                modelo.addColumn("Lugar");
                this.jTable1.setModel(modelo);
                break;
            }
        }
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentTablonSolicitud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentTablonSolicitud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentTablonSolicitud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentTablonSolicitud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentTablonSolicitud().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel jlFondo;
    // End of variables declaration//GEN-END:variables
}