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
public class DemoInsert {
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
String sql="";
sql+="INSERT INTO JavaI2.dbo.dept  ";
sql+="VALUES(?,?,?) ";
patm = con.prepareStatement(sql);
patm.setInt(1,4);
patm.setString(2,"Logistica");
patm.setString(3,"Mar del Plata");
int rtdo = patm.executeUpdate();
if( rtdo == 1 ) 
{   
    System.out.println("1 ﬁla correctamente insertada");
} else 
{   
    throw new RuntimeException("No se pudo insertar la ﬁla");
} 
//EN CASO DE QUE SEA MULTIPLES FILAS
/*
String sql="";
sql+="INSERT INTO dept (deptno, dname, loc) ";
sql+="VALUES(?,?,?)";
patm = con.prepareStatement(sql);
for(int i=100; i<150; i++)
{
    pstm.setInt(1,i);
    pstm.setString(2,"NombreDept ("+i+")");
    pstm.setString(3,"LocDept"+i+")");
    int rtdo = pstm.executeUpdate();
     if( rtdo != 1 )
    {
        throw new RuntimeException("Error...");
    } 
}
*/

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
