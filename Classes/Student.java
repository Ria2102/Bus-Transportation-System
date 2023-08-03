package Classes;

public class Student {
    private String fname;
    private String lname;
    private String city;
    private String street;
    private String Id;
    private String PhoneNo;

    public Student() {
        
        //name = new Name();
        //address = new Address();
        this.PhoneNo = "";
        this.Id="";
    }

    public Student(String fname,String lname, String Id, String city,String street, String PhoneNo) {
        this.fname = fname;
        this.lname = lname;
        this.city = city;
        this.street=street;
        this.Id = Id;
        this.PhoneNo=PhoneNo;

    }/* 
    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNo(String PhoneNo) {
        this.PhoneNo = PhoneNo;
    }

    public void setId(String Id) {
        this.Id = Id;
    }
    
   // public String getName() {
    //    return name;
   // }
    
    public String getAddress() {
        return address;
    }
    
    public String getPhoneNo() {
        return PhoneNo;
    }
*/
    @Override
    public String toString() {
        return fname + lname + Id + city+ street + PhoneNo;
    }
     
      
}
