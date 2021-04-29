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
/**
 *
 * @author Usuario
 */
public class PruebaDeConexion {
   
/**
*
* @author SuNombre
*/

public static void main(String[] args)
{//Parametros de la conexion
Connection con = null;
PreparedStatement pstm = null;
ResultSet rs = null;
try
{
Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
System.out.println("Driver funciona correctamente");

}
catch (ClassNotFoundException e)
{
System.out.println("Error: XDXDXD "+e.getMessage());
}
finally
{
try
{
if(rs!=null) rs.close(); if(pstm!=null) pstm.close(); if(con!=null) con.close();
}
catch(Exception ex)
{
ex.printStackTrace(); throw new RuntimeException(ex);
}
}
}
}
    

