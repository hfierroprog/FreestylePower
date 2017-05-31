package packet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Random;

public class Conector{
    String ruta = "c:/diccionario.db";
    Connection conexion;
    
    
    public void conectar(){
        try{
            conexion = DriverManager.getConnection("jdbc:sqlite:"+ruta);
            if (conexion != null){
                System.out.println("Conectado!");
            }
        }catch(SQLException ex){
            System.err.println("No se pudo conectar a la base de datos, ERROR:"+ex.getMessage());
        }
    }
    
    public void cerrar(){
        try{
            conexion.close();
            System.out.println("Cerrado correctamente!");
        }catch(SQLException ex){
            Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public String getAleatorio(){
        int aleatorio;
        String palabra = "";
        Random rnd = new Random();
        
        aleatorio = (int)(rnd.nextDouble() * 1036 + 1);
        
        try {
            Statement st = conexion.createStatement();
            ResultSet rs;
            rs = st.executeQuery("SELECT palabra from Palabras where id="+aleatorio);
            
            while(rs.next()){
                palabra = rs.getString("palabra");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
            palabra = "";
        }
        
        
        return palabra;
    }
}
