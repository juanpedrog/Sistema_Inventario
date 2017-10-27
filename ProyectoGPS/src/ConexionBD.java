
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
 * @author Juan Pedro Gil
 */
public class ConexionBD {
    public static Connection conectar=null;//conectar es el estatus de la conexión con la base de datos.
    //La función conectar es para hacer la conexión con la base de datos.
    public static Connection conexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conectar=DriverManager.getConnection("jdbc:mysql://localhost/viaticos","root","");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error en la conexión");
        }
        return conectar;
    }
    
    //Función para ejecutar un query de MYSQL, se recomienda usar en consultas
    public static ArrayList<String> consultar(String query){
        try{
            Statement statement=conectar.createStatement();
            ResultSet resultado=statement.executeQuery(query);
            ArrayList<String> datos=new ArrayList<String>();
            int a;
            while(resultado.next()){
                a=resultado.getMetaData().getColumnCount();
                for(int i=1;i<=resultado.getMetaData().getColumnCount();i++){
                    datos.add(resultado.getString(i));
                }
            }
            return datos;
        }catch(Exception e){
            //Muestra un mensaje si ocurrió algún error durante la ejecución del query
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return null;
    }
}
