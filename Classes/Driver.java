package Classes;

public class Driver{
    private Name name;
    
    private String telephoneNumber;

    public Driver() {
        
        name = new Name();
       
        this.telephoneNumber = "";
    }

    public Driver(Name name, String telephoneNumber) {
        this.name = name;
        this.telephoneNumber=telephoneNumber;

    }

    public void setName(Name name) {
        this.name = name;
    }
    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }
    
    public Name getName() {
        return name;
    }
    
    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    @Override
    public String toString() {
        return name + "@" + telephoneNumber;
    }
     
      
}
