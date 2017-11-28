
import java.sql.Connection;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author usuario
 */
public class NuevaSolicitud extends javax.swing.JFrame {
    Conexion cbd=new Conexion();
    Connection cn=cbd.conexion();
    int posx,posy;
    public static boolean imprimirSolicitud=false;
    /**
     * Creates new form NuevaSolicitud
     */
    public NuevaSolicitud() {
        initComponents();
        setLocationRelativeTo(null); 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        lbl_Nombre = new javax.swing.JLabel();
        txt_Nombre = new javax.swing.JTextField();
        lbl_Puesto = new javax.swing.JLabel();
        txt_Puesto = new javax.swing.JTextField();
        lbl_Fecha_Salida = new javax.swing.JLabel();
        date_Salida = new com.toedter.calendar.JDateChooser();
        lbl_Fecha_Llegada = new javax.swing.JLabel();
        date_Llegada = new com.toedter.calendar.JDateChooser();
        lbl_Pernoctado = new javax.swing.JLabel();
        lbl_Actividad = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_Actividad = new javax.swing.JTextArea();
        txt_Lugar = new javax.swing.JTextField();
        lbl_Lugar = new javax.swing.JLabel();
        cmb_Vehiculo = new javax.swing.JComboBox();
        lbl_Vehiculo = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        chb_Pernoctado = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        jLabel2.setText("Nueva solicitud");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, -1, -1));

        lbl_Nombre.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        lbl_Nombre.setText("Nombre:");
        getContentPane().add(lbl_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 106, -1, 20));
        getContentPane().add(txt_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 106, 290, -1));

        lbl_Puesto.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        lbl_Puesto.setText("Puesto:");
        getContentPane().add(lbl_Puesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 106, -1, -1));
        getContentPane().add(txt_Puesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(505, 106, 160, -1));

        lbl_Fecha_Salida.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        lbl_Fecha_Salida.setText("Fecha de salida:");
        getContentPane().add(lbl_Fecha_Salida, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 130, -1));
        getContentPane().add(date_Salida, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 170, -1));

        lbl_Fecha_Llegada.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        lbl_Fecha_Llegada.setText("Fecha de llegada:");
        getContentPane().add(lbl_Fecha_Llegada, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 150, 140, -1));
        getContentPane().add(date_Llegada, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 150, 170, -1));

        lbl_Pernoctado.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        lbl_Pernoctado.setText("Pernoctado:");
        getContentPane().add(lbl_Pernoctado, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 195, 90, -1));

        lbl_Actividad.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        lbl_Actividad.setText("Actividad a realizar:");
        getContentPane().add(lbl_Actividad, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 225, 160, -1));

        txt_Actividad.setColumns(20);
        txt_Actividad.setRows(5);
        jScrollPane1.setViewportView(txt_Actividad);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 620, 80));
        getContentPane().add(txt_Lugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 350, 150, -1));

        lbl_Lugar.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        lbl_Lugar.setText("Lugar:");
        getContentPane().add(lbl_Lugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, -1, -1));

        cmb_Vehiculo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione el vehículo", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(cmb_Vehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 350, 150, -1));

        lbl_Vehiculo.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        lbl_Vehiculo.setText("Vehículo:");
        getContentPane().add(lbl_Vehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 350, 80, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/guardar.png"))); // NOI18N
        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 390, 120, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cancelar.png"))); // NOI18N
        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 390, 130, 40));
        getContentPane().add(chb_Pernoctado, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 195, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondosoli2.png"))); // NOI18N
        jLabel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel1MouseDragged(evt);
            }
        });
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
        });
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 440));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
        posx=evt.getX();
        posy=evt.getY();
    }//GEN-LAST:event_jLabel1MousePressed

    private void jLabel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseDragged
        int xp=evt.getXOnScreen() -posx;
        int yp=evt.getYOnScreen() -posy;
        this.setLocation(xp,yp);
    }//GEN-LAST:event_jLabel1MouseDragged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       try{
            verificar_excepcion=true;
            validarDatos(true,"");
            if(cmb_Vehiculo.getSelectedIndex()==0){
                insertar_Solicitud();
            }
        }catch(ExcepcionDatosIncompletos e){
            if(verificar_excepcion)JOptionPane.showMessageDialog(this, e.getMessage());
            return;
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        if(imprimirSolicitud){
            insertar_Solicitud();
        }
    }//GEN-LAST:event_formWindowActivated
    public void insertar_Solicitud(){
        try{
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            String fecha_Salida=sdf.format(date_Salida.getDate().getTime());
            String fecha_Llegada=sdf.format(date_Llegada.getDate().getTime());
            Conexion conexion=new Conexion();
            conexion.conexion();
            String pernoctado="No";
            if(chb_Pernoctado.isSelected()){
                pernoctado="Si";
            }
            System.out.print("insert into Solicitud (Fecha_Salida,Lugar,Nombre,Actividad,Pernoctado,Vehiculo,Puesto,Fecha_Llegada,Estado,Reporte) values('"+fecha_Salida+"','"+txt_Lugar.getText()+"'"
                + ",'"+txt_Nombre.getText()+"','"+txt_Actividad.getText()+"','"+pernoctado+"','"+cmb_Vehiculo.getSelectedItem().toString()+"'"
                + ",'"+txt_Puesto.getText()+"','"+fecha_Llegada+"','P','0')");
            boolean insersion=conexion.ejecutar("insert into Solicitud (Fecha_Salida,Lugar,Nombre,Actividad,Pernoctado,Vehiculo,Puesto,Fecha_Llegada,Estado,Reporte) values('"+fecha_Salida+"','"+txt_Lugar.getText()+"'"
                + ",'"+txt_Nombre.getText()+"','"+txt_Actividad.getText()+"','"+pernoctado+"','"+cmb_Vehiculo.getSelectedItem().toString()+"'"
                + ",'"+txt_Puesto.getText()+"','"+fecha_Llegada+"','P','0')");
            if(insersion){
                JOptionPane.showMessageDialog(this, "Insersión correcta");
                this.setVisible(false);
            }else{
                JOptionPane.showMessageDialog(this, "Error al insertar pero no excepción");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    //Función para validar los datos que se insertan en el formulario.
    public void validarDatos(boolean verificar_fecha,String cad)throws ExcepcionDatosIncompletos{
        try{
            if(verificar_fecha && date_Llegada.getDate().before(date_Salida.getDate())){
                if(cad.equals("")){
                    cad+="-La fecha de salida es mayor que la de llegada";
                }
                else{
                    cad+="\n-La fecha de salida es mayor que la de llegada";
                }
            }
        }catch(NullPointerException e){
            if(cad.equals("")){
                cad+="-No se ha insertado alguna de las fechas, inserte las fechas de salida y de llegada";
            }
            else{
                cad+="\n-No se ha insertado alguna de las fechas, inserte las fechas de salida y de llegada";
            }
            try{
                verificar_excepcion=false;
                validarDatos(false,cad);
                return;
            }catch(ExcepcionDatosIncompletos ex){
                JOptionPane.showMessageDialog(this, ex.getMessage());
                return;
            }
        }
        if(chb_Pernoctado.isSelected()){
            if(date_Salida.getDate().getYear()==date_Llegada.getDate().getYear()
                    && date_Salida.getDate().getMonth()==date_Llegada.getDate().getMonth()
                    && date_Salida.getDate().getDay()==date_Llegada.getDate().getDay()){
                cad+="\nNo se puede seleccionar pernoctadar para una fecha de salida y de llagada igual";
            }
            
        }
        /*if(cmb_Vehiculo.getSelectedIndex()==0){
            if(cad.equals("")){
                cad+="-Vehiculo no seleccionado";
            }
            else{
                cad+="\n-Vehiculo no seleccionado";
            }
        }*/
        if(cmb_Vehiculo.getSelectedIndex()!=0){
            new descVehiculo().setVisible(true);
        }
        if(txt_Actividad.getText().equals("")){
            if(cad.equals("")){
                cad+="-No se ha insertado ninguna actividad, escriba la acitividad y vuelva a intentarlo";
            }
            else{
                cad+="\n-No se ha insertado ninguna actividad, escriba la acitividad y vuelva a intentarlo";
            }
        }
        if(txt_Lugar.getText().equals("")){
            if(cad.equals("")){
                cad+="-No se ha insertado el lugar, escriba el lugar y vuelva a intentarlo";
            }
            else{
                cad+="\n-No se ha insertado el lugar, escriba el lugar y vuelva a intentarlo";
            }
        }
        if(txt_Nombre.getText().equals("")){
            if(cad.equals("")){
                cad+="-No se ha insertado el nombre del epmpleado, escriba el nombre del empleado y vuelva a intentarlo";
            }
            else{
                cad+="\n-No se ha insertado el nombre del epmpleado, escriba el nombre del empleado y vuelva a intentarlo";
            }
        }
        if(txt_Puesto.getText().equals("")){
            if(cad.equals("")){
                cad+="-No se ha insertado el puesto del epmpleado, escriba el nombre del empleado y vuelva a intentarlo";
            }
            else{
                cad+="\n-No se ha insertado el puesto del epmpleado, escriba el nombre del empleado y vuelva a intentarlo";
            }
        }
        if(!cad.equals("")){
            throw new ExcepcionDatosIncompletos(cad);
        }else{
            return;
        }
    }
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
            java.util.logging.Logger.getLogger(NuevaSolicitud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NuevaSolicitud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NuevaSolicitud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NuevaSolicitud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NuevaSolicitud().setVisible(true);
            }
        });
    }
    private boolean verificar_excepcion=true;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox chb_Pernoctado;
    private javax.swing.JComboBox cmb_Vehiculo;
    private com.toedter.calendar.JDateChooser date_Llegada;
    private com.toedter.calendar.JDateChooser date_Salida;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_Actividad;
    private javax.swing.JLabel lbl_Fecha_Llegada;
    private javax.swing.JLabel lbl_Fecha_Salida;
    private javax.swing.JLabel lbl_Lugar;
    private javax.swing.JLabel lbl_Nombre;
    private javax.swing.JLabel lbl_Pernoctado;
    private javax.swing.JLabel lbl_Puesto;
    private javax.swing.JLabel lbl_Vehiculo;
    private javax.swing.JTextArea txt_Actividad;
    private javax.swing.JTextField txt_Lugar;
    private javax.swing.JTextField txt_Nombre;
    private javax.swing.JTextField txt_Puesto;
    // End of variables declaration//GEN-END:variables
}
