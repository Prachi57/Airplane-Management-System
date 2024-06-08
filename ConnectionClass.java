
package AMS;

import java.sql.*;
public class ConnectionClass {
    Connection con;
    Statement stm;
    ConnectionClass()
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/information","root","Arunita5757@");
            stm=con.createStatement();
            if(con.isClosed())
            {
                System.out.println("yes");
            }
            else
            {
                System.out.println("no");
            }
            
        }
        catch(Exception ex)
        {
            
            ex.printStackTrace();
        }
    }
    public static void main(String args[]){
        new ConnectionClass();
    }
    
    
}
