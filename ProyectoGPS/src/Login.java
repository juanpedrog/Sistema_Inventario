
import com.sun.awt.AWTUtilities;
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
public class Login {
    
    /**
     * *@param args the command line arguments
     */
    public static void main(String[] args){
        VenLogin vl=new VenLogin();
        AWTUtilities.setWindowOpaque(vl,false);
        vl.setVisible(true);
        vl.conexion();
    }
}
