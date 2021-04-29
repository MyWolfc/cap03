/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Libro.Cap03;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Usuario
 */
public class DemoDelete {
    public static void main(String[] args) throws ClassNotFoundException, SQLException
{//Parametros de la conexion
    //String usr = "sa";
    //String pwd = "123";
    //String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";      
    //mitad es "jdbc:sqlserver:// y despues el server:
   // String url = "jdbc:sqlserver://DESKTOP-9EFFBS7\\SQLEXPRESS"; 
    
Connection con = null;
PreparedStatement patm = null;
ResultSet rs = null;
try
{
    //En caso de querer o no poder usar UConnection QUITE LOS COMENTARIOS usr pwd driver url y las siguientes lineas del codigo comentadas
    //Class.forName(driver);
    //con = DriverManager.getConnection(url, usr, pwd);
con = UConnection.getConnection();
String sql=""; sql+="DELETE FROM JavaI2.dbo.emp WHERE empno = ? ";
patm = con.prepareStatement(sql);
// quiero borrar al empleado cuyo empno es 20 
patm.setInt(1,20);

int rtdo = patm.executeUpdate();
if( rtdo > 1 ) 
{
    String mssg=("Error: "+rtdo+" ﬁlas eliminadas...");
    throw new RuntimeException(mssg); } 

}
catch(SQLException ex)
{
    System.out.println("Error: "+ex.getMessage());
}

finally
{

}
try 
{
    if(rs!= null) rs.close();
    if (patm!= null) patm.close();
    if (con!= null) con.close();
        
}
catch(SQLException e)
{
    System.out.println(e.getMessage());
}
}
    
    
}
