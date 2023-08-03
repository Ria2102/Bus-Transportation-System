package GUI;
import java.sql.*;

public class Student {
    public static String UserName;
    public static String Name;
    public static String City;
    public static String Street;
    public static String Bldg;
    public static String endDate;
    public static int Contact_No;
    public static int BusNo;

    void setStudent(String id){
        UserName = id;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection con=DriverManager.getConnection(  
            "jdbc:mysql://localhost:3306/bus_system","root","*Laya2003*"); 
            PreparedStatement ProfessorDetails = con.prepareStatement("SELECT Name,Contact_No,City,Street,Bldg FROM Passenger WHERE ID=?");
            ProfessorDetails.setString(1,UserName);
            //ProfessorDetails.setString(1,UserName);
            ResultSet rs=ProfessorDetails.executeQuery();
            rs.next();
            Name = rs.getString(1);
            Contact_No = rs.getInt(2);
            City= rs.getString(3);
            Street = rs.getString(4);
            Bldg = rs.getString(5);
            con.close();  
        }catch(Exception e){System.out.println(e);} 

    }
    public String getID(){
        return UserName;
    }
    public String getName(){
        return Name;
    }
    public String getCity(){
        return City;
    }
    public String getStreet(){
        return Street;
    }
    public String getBldg(){
        return Bldg;
    }
    public void setendDate(String d){
        endDate = d;
    }
    public String getendDate(){
        return endDate;
    }
    public int getContactNo(){
        return Contact_No;
    }
   
}
