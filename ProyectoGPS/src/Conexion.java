
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
public class Conexion {
    Connection conectar=null;//conectar es el estatus de la conexión con la base de datos.
    //La función conectar es para hacer la conexión con la base de datos.
    public Connection conexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conectar=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Viaticos_prueba","root","");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        return conectar;
    }
    public boolean ejecutar(String sql) {
        try {
            Statement sentencia = conectar.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            sentencia.executeUpdate(sql);
            sentencia.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }        return true;
    }
    public ArrayList<String> acceder(String sql){
        ArrayList<String> arr=new ArrayList<String>();
        try {
            Statement comando=conectar.createStatement();
            ResultSet registro = comando.executeQuery(sql);
            while(registro.next()){
                
            }
            comando.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return arr;
    }
}
