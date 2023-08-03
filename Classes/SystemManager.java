package Classes;

// import GUI.*;
import java.io.*;
// import java.util.Arrays;
import java.util.Scanner;
// import java.util.logging.Level;
// import java.util.logging.Logger;
// import javax.swing.JOptionPane;

public class SystemManager {
   
    private String inputFile;       //the file contains all details    
    //private Airport[] airport;      //stores details of all airports
    //private Airline[] airlines;     //store details of all airlines
    private bus[] bus;       //stores details of all bus belongs to all airlines    
    private Seat[][] seats;          //stores details of seats belongs to all bus;
    private Reservation[] reservations = new Reservation[448];
    public static int reservationNumber = -1;
    

    public SystemManager(String inputFile){
        
        this.inputFile = inputFile;
        
       // this.readAirportDetails();
        //this.readAirLineDetails();
        this.readBusDetails();
        
        this.setBusSeatDetails();
        
        this.loadReservations();
    }
    public void setBus(bus[] bus) {
        this.bus = bus;
    }

    public void setSeat(Seat[][] seat) {
        this.seats = seat;
    }

    public void setInputFile(String inputFile) {
        this.inputFile = inputFile;
    }

    public void setReservations(Reservation[] reservations) {
        this.reservations = reservations;
    }

    public bus[] getBus() {
        return bus;
    }

    public Seat[][] getSeat() {
        return seats;
    }

    public String getInputFile() {
        return inputFile;
    }
     
        //This Method reads all fhtDetails from the relevant inputFile and writes them in an array
    public final void readBusDetails(){
        
        //bus[] b = new bus[40];
        String[] busDetails = new String[6];
        String busNumber = "";
        String[] travelDate = new String[3];
        //String destinationAirport = "" ;
        String travelTime = "";
        
        int i = 0;
        
        try(Scanner read = new Scanner(new FileInputStream(this.inputFile));

            PrintWriter pw = new PrintWriter(new FileOutputStream("bus.txt"))){
        
            boolean end = false;
            
            while(read.hasNextLine()&& !end){

                String line = read.nextLine();

                if(line.compareTo("*") == 0){                    
                    busDetails = read.nextLine().split(",");
                     busNumber = busDetails[0];
                     travelDate = busDetails[1].split("-");
                     int deptDay = Integer.parseInt(travelDate[0]);
                     int deptMonth = Integer.parseInt(travelDate[1]);
                     int deptYear = Integer.parseInt(travelDate[2]);
                     //String location = busDetails[2];
                     //destinationAirport = ftDetails[3]; 
                     travelTime = busDetails[4];
                     

                     bus[i] = new bus(busNumber, deptDay, deptMonth, deptYear, travelTime);
                     
                     
                     pw.println(bus[i]);
                     i++;
                     
                    // pw.println(busNumber + "\t" + Arrays.toString(TravelDate) + "\t" + TravelAirport + "\t" + destinationAirport + "\t" + TravelTime + "\t" + arrivalTime);
                    
                }           
            }
        }
        catch(FileNotFoundException ex){
            System.out.println("File Not Found");
        }
        catch(Exception ex){
            System.out.println("Exception");
        }
        
        this.setBus(bus);
    }
    
     //This Method reads all seatDetails o and assign relevClass from the relevant inputFile and writes them in an array
    public Seat[] readBusSeatDetails(String busNumber){          
        Seat[] seat = new Seat[30];
        String[] ftDetails = new String[6];        
        String ftID = "";
        int numberOfRows = 0;
        String[] rowsOfTheClass = new String[numberOfRows]; 
        String columnChar = "";
        String rowNumber = "";
        String seatID = "";
        boolean seatAvailability = true;       //true if available
        int seatArrayIndex = -1;
        
        try(Scanner read = new Scanner(new FileInputStream(inputFile));
            PrintWriter pw = new PrintWriter(new FileOutputStream("seat.txt"),true))
            {
             
             while(read.hasNextLine())
             {     
                   if(read.nextLine().compareTo("*") == 0)
                   {
                       ftDetails = read.nextLine().split(",");
                        ftID = ftDetails[0]; 

                        if(ftID.compareTo(busNumber) == 0)
                        { 
                            //for(int className=0; className<3; className++){
                              //  switch(className){              //splits classes into rows and store in the array
                                //    case 0:
                                        numberOfRows = 5;
                                        rowsOfTheClass = read.nextLine().split("@"); 
                                        for(int i=0; i<rowsOfTheClass.length; i++)
                                        {                                            
                                            rowNumber = Integer.toString(i+1);
                                            for(int j=0; j<4; j++)
                                            {
                                                switch(j)
                                                {
                                                case 0:
                                                     columnChar = "A";
                                                    break;
                                                case 1:
                                                    columnChar = "B";
                                                    break;
                                                case 2:
                                                    columnChar = "G";
                                                    break;
                                                case 3:
                                                    columnChar = "H"; 
                                                    break;
                                                }                                            
                                                seatID = columnChar + rowNumber;
                                                if(rowsOfTheClass[i].charAt(j)== 'f'){
                                                    seatAvailability = true;
                                                }
                                                else{
                                                    seatAvailability = false;
                                                }
                                                seatArrayIndex+=1;
                                                seat[seatArrayIndex] = new Seat(seatID, seatAvailability);
                                                
                                                pw.println(seatArrayIndex + "\t" + seatID + "\t" + seatAvailability);
                                            }                                            
                                            
                                        }
                                        
                                        break;

                                                              
                            }
                        }
                   }      
                                  
                        
        }
         catch(FileNotFoundException ex){
             System.out.println("File Not Found");
         }
         catch(Exception ex){
             System.out.println("Exception");
         }
        
        return seat;
    }
    //this takes seat details of all bus into an array
    public void setBusSeatDetails(){
        Seat[][] busSeats = new Seat[40][448];
        for(int m=0; m<bus.length; m++){
            String busNumber = this.bus[m].getBusNumber();
            busSeats[m] = this.readBusSeatDetails(busNumber);
        }
        
        this.setSeat(busSeats);
    }
    
    //this seatches for  availability for a particu
    public String searchBus(int day, int month, int year)
    {
//      boolean end = false;
//      int i=0;
    //   String alineID = "";      
      bus bus1 = new bus();
      bus1.setTravelDate(day, month, year);
      int availableSeatCount = 0;
      String str = "";
      
      for(int i=0; i<bus.length; i++){
        //   alineID = bus[i].getBusNumber().substring(0,2);
          
          //if(alineID.compareTo(getBusNumber) == 0){
            //  if(bus[i].getTravelAirport().compareTo(TravelAirport) == 0 && bus[i].getDestinationAirport().compareTo(destinationAirport) == 0){
              //    if(bus[i].getTravelDate().compar1.getTravelDate()) == 0){
                     Seat[][] seat = this.getSeat();
                      for(int j=0; j<seat.length; j++){
                          if(seat[i][j].isStatus()==true)
                          {
                              availableSeatCount+=1;
                          }
                          
                      }
                      str = bus[i].getBusNumber() + "@" + bus[i].getTravelTime() +  "@" + availableSeatCount;
                     
                  }
                  return str;
                }
        
      
    
    //gives the number of seats available to reserve in a particu
    public String searchBusSeatAvailability(String BusNumber){
        Seat[][] seat = this.getSeat();
        // String seatID = "";
        // boolean seatAvailability = false;
        int availableFClass = 0;
        int availableBClass = 0;
        int availableEClass = 0;
        String str = "";
        
        for(int j=0; j<bus.length; j++){
            if(bus[j].getBusNumber().compareTo(BusNumber) == 0){
                for(int i=0; i<448; i++){
                    if(seat[j][i].isStatus()==false){
                        if(i<16){
                            availableFClass+=1;
                        }
                        else if(i<64){
                            availableBClass+=1;
                        }
                        else{
                            availableEClass+=1;
                        }
                    }
                }
            }
        }
        
       str = availableFClass + "@" + availableBClass + "@" + availableEClass;
       return str; 
    }
    //gives seat details of a particu
    public Seat[] getSeatDetails(String busNumber ){
        Seat[][] seat = this.getSeat();
        Seat[] seatDetails = new Seat[448];
        String seatID = "";
        boolean seatStatus = false;
        
        for(int j=0; j<bus.length; j++){
            if(bus[j].getBusNumber().compareTo(busNumber) == 0){
                for(int i=0; i<448; i++){
                    seatID = seat[j][i].getSeatID();
                    seatStatus = seat[j][i].isStatus();
                    
                    seatDetails[i] = new Seat(seatID, seatStatus);
                }
            }
        }
        
       return seatDetails;
    }
     //gets the Travel date of a particu 
    public String getTraveldate(String busNumber){
        String deptDate = ""; 
        
        for(int j=0; j<bus.length; j++){
            if(bus[j].getBusNumber().compareTo(busNumber) == 0){
               deptDate = bus[j].getTravelDate();
            }
        }
        return deptDate;
    }
    
     //returns a reservation type object for a particular reservation
     public Reservation makeReservation(int reservationNumber,int number, Student[] student,String busNumber,String deptDate,Seat[] seat)
     {         
         reservationNumber++;
         
         
         Reservation reserve = new Reservation(reservationNumber, number, student, busNumber, deptDate,seat);
         
         reservations[reservationNumber]=reserve;
         
         return reserve;
     }
     //save reservation details to file from array
     public void saveReservations()
     {
         try(PrintWriter pw = new PrintWriter(new FileOutputStream("reservations.txt"))){
        
           for(int q=0; q<=reservationNumber; q++){
               pw.println("#");
               pw.println(reservations[q].toString());
               pw.print("##");
           }
        }
        catch(FileNotFoundException ex){
            System.out.println(ex.getMessage());
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
     }
     
    //load reservation details from file to array
         //set the reservationNumber to the reservationID of the last entry of the reservation file
     public void loadReservations(){
         try(Scanner read = new Scanner(new FileInputStream("reservations.txt"))){             
            //PrintWriter pw = new PrintWriter(new FileOutputStream("airport.txt"))){
            String[] reserveDetails = new String[6];
            boolean end = false;
            // int resNumber;            
            int numberOfStudents = 0;
            Student[] student = new Student[numberOfStudents];
            // String busNumber = "";
            // String TravelDate = "";
            String[] reservedseatId;
            String[] StudentDetails = new String[numberOfStudents];
            String[] singleStudentDetails = new String[5];
            Seat[] reservedSeats = new Seat[numberOfStudents];
            
            while(read.hasNextLine()&& !end){

                String line = read.nextLine();

                if(line.compareTo("#") == 0){
                    while(!read.hasNext("##")){                        
                        for(int q=0; q<=reservationNumber; q++){
                            reserveDetails=read.nextLine().split("*");
                            // resNumber = Integer.parseInt(reserveDetails[0]);
                            numberOfStudents = Integer.parseInt(reserveDetails[1]);
                            
                             StudentDetails = reserveDetails[2].substring(1, reserveDetails[2].length()).split(", ");        //check
                            for(int d=0; d<StudentDetails.length; d++){
                                singleStudentDetails = StudentDetails[d].split("@");
                                //Name name = new Name(singleStudentDetails[0], singleStudentDetails[1]);
                                //Address address = new Address(singleStudentDetails[2], singleStudentDetails[3]);
                                String id = "";
                                student[d] = new Student(singleStudentDetails[0], singleStudentDetails[1],id,singleStudentDetails[2], singleStudentDetails[3],singleStudentDetails[4]);
                            }
                            // String busNumber = reserveDetails[3];
                        //    String TravelDate = reserveDetails[4];                            
                             reservedseatId = reserveDetails[5].substring(1, reserveDetails[5].length()).split(", ");      //check
                            for(int x=0; x<reservedseatId.length; x++){
                                reservedSeats[x] = new Seat(reservedseatId[x],true);  
                            }
                            
                            //Reservation reserve = new Reservation(reservationNumber,numberOfStudents, student, busNumber, TravelDate,reservedSeats);
                        }
                    }
                    end = true; 
                    line = "";
                }
            }
        }
        catch(FileNotFoundException ex){
            System.out.println(ex.getMessage());
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
         
         this.setReservations(reservations);
     }
     
   
         //delete reservation from array and adjust the array
        public void cancelReservation(int resNumber){

            for(int i = 0 ; i < reservationNumber+1 ; i++){
                int resID = reservations[i].getReservationNumber();
                if(resID == resNumber){
                    for(int j = i ; j < reservationNumber ; j++){
                        reservations[j] = reservations[j+1];
                    }
                }

            }

        }
        public Student[] viewStudentList(String busNumber){
            String ftID = "";            
            Student[] student = new Student[448];
            //int StudentCount = 0;
            for(int i=0; i<=reservationNumber; i++){
                ftID = reservations[i].getBusNumber();
                if(ftID.compareTo(busNumber)==0){
                    student = reservations[i].getStudentArray();
                }
            }
            return student;
        
        }
         
         
    }