package GUI;
import java.sql.*;

public class Driver {
    public static String UserName;
    public static int busno;

    void setDriver(String id)
    {
        UserName = id; 

    }
    public int getbusno()
    {
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection con=DriverManager.getConnection(  
            "jdbc:mysql://localhost:3306/bus_system","root","*Laya2003*");  
            PreparedStatement select = con.prepareStatement("SELECT Busno FROM bus WHERE ID='"+UserName+"'");
            select.executeQuery();
            ResultSet rs=select.executeQuery();
            rs.next();
            
            busno = rs.getInt(1); 
        }catch(Exception e){System.out.println(e);}
        return busno;
    }
    public String getDID()
    {
        return UserName;
    }
}

