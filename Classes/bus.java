package Classes;

import java.text.SimpleDateFormat;
import java.util.Calendar;
// import java.util.Date;
import java.util.GregorianCalendar;
// import Classes.Address;


public class bus {
    private String busNumber;
    private String travelDate;
    private String travelTime;
    

    //constructor 01
    public bus() {
    }
    
    //constructor 02
    public bus(String busNumber, int day, int month, int year, String TravelTime) {
       
        this.setBusNumber(busNumber);        
        setTravelDate(day, month, year);
        this.travelTime = TravelTime;
        
       // this.sections = sections;
    }

    
    public void setBusNumber(String number) {        
        if(number.matches("[0-9 ]+$")){
            this.busNumber = number;
            
        }
        else{
            System.out.println("Invalid bus number");
        }        
        
    }
    
    public void setTravelDate(int day, int month, int year) {             
        SimpleDateFormat sdf = new SimpleDateFormat("d MMM yyyy");     //Defines the date format needed
        Calendar calendar1 = new GregorianCalendar(year, month-1, day);   //creates a date from Calendar class   
        this.travelDate = sdf.format(calendar1.getTime());
    }      
 

    public void setTravelTime(int hour, int minute) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm ");     //Defines the date format needed
        Calendar calendar1 = new GregorianCalendar(2016, 12, 5, hour, minute);   //creates a date from Calendar class
        this.travelTime = sdf.format(calendar1.getTime());
        
    }  


    /*public void setSections(FlightSection[] sections) {
        this.sections = sections;
    }*/     //erase
    
    public String getBusNumber() {
        return busNumber;
    }
    
    public String getTravelDate() {
        return travelDate;
    }


     public String getTravelTime() {
        return travelTime;
    }
    
    @Override
    public String toString() {
        return busNumber + "," + travelDate + ","  +  travelTime ;
    }
   
    
    
}
 
