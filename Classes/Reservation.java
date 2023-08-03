package Classes;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Reservation {
   // private int reservationNumber;
    private int numberOfStudents;
    private Student[] student; // = new Passenger[numberOfPassengers];
    private String busNumber;
    private String travelDate;
    private Seat[] reservedSeats;
    private int reservationNumber;

    public Reservation(){}
    
    public Reservation(int reservationNumber, int numberOfStudents, Student[] student, String busNumber, String travelDate, Seat[] reservedSeats) {
      this.reservationNumber = reservationNumber;
        this.numberOfStudents = numberOfStudents;
        this.student = student;
        this.busNumber = busNumber;
        this.travelDate = travelDate;
        this.reservedSeats = reservedSeats;
    }

     public void setReservationNumber(int reservationNumber) {
        this.reservationNumber = reservationNumber;
    }

    public void setNumberOfStudent(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    public void setStudent(Student[] student) {
        this.student = student;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    public void setTravelDate(int year, int month, int day) {
        SimpleDateFormat sdf = new SimpleDateFormat("d MMM yyyy");     //Defines the date format needed
        Calendar calendar1 = new GregorianCalendar(year, month-1, day);   //creates a date from Calendar class   
        this.travelDate = sdf.format(calendar1.getTime());
    }   

    public void setReservedSeats(Seat[] reservedSeats) {
        this.reservedSeats = reservedSeats;
    }

    public int getReservationNumber() {
        return reservationNumber;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void getStudents() {
        
        for(int i=0; i<student.length; i++){
            System.out.println(student[i]);
        }
        
    }

     public Student[] getStudentArray() {
        
        return student;
    }
    
    public String getBusNumber() {
        return busNumber;
    }

    public String getTravelDate() {
        return travelDate;
    }
    
   public String[] getReservedSeats(){
      String[] reservedSeatID = new String[this.getNumberOfStudents()];  
        for(int i=0; i<reservedSeatID.length; i++){
            reservedSeatID[i] = reservedSeats[i].getSeatID();
        }
        return reservedSeatID;
    } 

    @Override
    public String toString() {
        String array1 = Arrays.toString(student);
        String array2 = Arrays.toString(getReservedSeats());
        return  numberOfStudents + "*" + array1 + "*" + busNumber + "*" + travelDate + "*" + array2 ;
    }
    
    
    
} 

