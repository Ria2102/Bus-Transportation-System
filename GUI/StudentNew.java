package GUI;
import java.io.*;
import java.sql.*;

import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.event.*;

// import Classes.*;

public class StudentNew extends javax.swing.JFrame {

    //  Creates new form StudentNew
   
    String FirstN ="";
    String LastN = "";
    String Id = "";
    int PhoneNo = 0;
    String street = "";
    String Bldg = "";
    String city = "";
    char[] passWord;
    
    public StudentNew() {
        initComponents();
        
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        FirstNameText = new javax.swing.JTextField();
        LastNameText = new javax.swing.JTextField();
        passwordText = new javax.swing.JPasswordField();
        PhoneNoText = new javax.swing.JTextField();
        CityAddressText = new javax.swing.JTextField();
        StreetAddressText = new javax.swing.JTextField();
        BldgAddressText = new javax.swing.JTextField();
        IdText = new javax.swing.JTextField();
        btnCancel = new javax.swing.JButton();
        btnCreateAccount = new javax.swing.JButton();
        dp = new javax.swing.JDesktopPane();
        panelStatus = new javax.swing.JPanel();
        

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Student CreateAccount | Ride With Us");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(707, 569));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 14)); 
        jLabel1.setText("First Name:");
        jLabel1.setForeground(Color.white);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(170, 100, 150, 20);

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 14)); 
        jLabel2.setText("Last Name:");
        jLabel2.setForeground(Color.white);
        getContentPane().add(jLabel2);
        jLabel2.setBounds(170, 130, 100, 20);

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 14)); 
        jLabel3.setText("ID:");
        jLabel3.setForeground(Color.white);
        getContentPane().add(jLabel3);
        jLabel3.setBounds(170, 160, 100, 19);

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 14)); 
        jLabel4.setText("Phone Number:");
        jLabel4.setForeground(Color.white);
        getContentPane().add(jLabel4);
        jLabel4.setBounds(170, 190, 120, 19);

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 14)); 
        jLabel5.setText("City:");
        jLabel5.setForeground(Color.white);
        getContentPane().add(jLabel5);
        jLabel5.setBounds(170, 220, 100, 19);

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 14)); 
        jLabel6.setText("Street:");
        jLabel6.setForeground(Color.white);
        getContentPane().add(jLabel6);
        jLabel6.setBounds(170, 250, 100, 19);

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 15)); 
        jLabel8.setText("Bldg:");
        jLabel8.setForeground(Color.white);
        getContentPane().add(jLabel8);
        jLabel8.setBounds(170, 280, 100, 19);


        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 15)); 
        jLabel7.setText("Password:");
        jLabel7.setForeground(Color.white);
        getContentPane().add(jLabel7);
        jLabel7.setBounds(170, 310, 100, 19);


        FirstNameText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                NameTextActionPerformed(evt);
            }
        });
        getContentPane().add(FirstNameText);
        FirstNameText.setBounds(280, 100, 140, 28);

        LastNameText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                NameTextActionPerformed(evt);
            }
        });
        getContentPane().add(LastNameText);
        LastNameText.setBounds(280, 130, 140, 28);

        IdText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                IdTextActionPerformed(evt);
            }
        });
        getContentPane().add(IdText);
        IdText.setBounds(280, 160, 140, 28);

        PhoneNoText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                PhoneNoTextActionPerformed(evt);
            }
        });
        getContentPane().add(PhoneNoText);
        PhoneNoText.setBounds(280, 190, 140, 28);

        CityAddressText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                AddressTextActionPerformed(evt);
            }
        });
        getContentPane().add(CityAddressText);
        CityAddressText.setBounds(280, 220, 140, 28);

        StreetAddressText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                AddressTextActionPerformed(evt);
            }
        });
        getContentPane().add(StreetAddressText);
        StreetAddressText.setBounds(280, 250, 140, 28);
        
        BldgAddressText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                AddressTextActionPerformed(evt);
            }
        });
        getContentPane().add(BldgAddressText);
        BldgAddressText.setBounds(280, 280, 140, 28);


        passwordText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                passwordTextActionPerformed(evt);
            }
        });
        
        getContentPane().add(passwordText);
        passwordText.setBounds(280, 310, 140, 28);

        btnCancel.setFont(new java.awt.Font("SansSerif", 0, 12)); 
        btnCancel.setText("Back");
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancel);
        btnCancel.setBounds(400, 400, 90, 32);

        /*jLabel3.setFont(new java.awt.Font("Freestyle Script", 0, 48)); 
        //jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Ride With Us");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(250, 25, 200, 50); */

        btnCreateAccount.setFont(new java.awt.Font("SansSerif", 0, 12)); 
        btnCreateAccount.setText("CreateAccount");
        btnCreateAccount.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnCreateAccountActionPerformed(evt);
            }
        });
        getContentPane().add(btnCreateAccount);
        btnCreateAccount.setBounds(200, 400, 150, 32);
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(dp)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(dp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        /*jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/bus.gif"))); 
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 700, 650); */

        pack();
    }

    private void btnCancelActionPerformed(ActionEvent evt) {
        StudentLogin sl = new StudentLogin();
        sl.setVisible(true);
        sl.pack();
        this.dispose();

    }

    private void passwordTextActionPerformed(ActionEvent evt) {
       passWord = passwordText.getPassword();
    }

    private void NameTextActionPerformed(ActionEvent evt) {
        
   
    }

    private void IdTextActionPerformed(ActionEvent evt) {
        Id = IdText.getText();
    }

    private void PhoneNoTextActionPerformed(ActionEvent evt) {
        PhoneNo = Integer.parseInt(PhoneNoText.getText());
    }

    private void AddressTextActionPerformed(ActionEvent evt) {
        city = CityAddressText.getText();
        street = StreetAddressText.getText();
        Bldg = BldgAddressText.getText();
    }

    private void btnCreateAccountActionPerformed(ActionEvent evt) {
        FirstN = FirstNameText.getText();
        LastN = LastNameText.getText();
        Id = IdText.getText();
        PhoneNo = Integer.parseInt(PhoneNoText.getText());
        city = CityAddressText.getText();
        street = StreetAddressText.getText();
        Bldg = BldgAddressText.getText();
        passWord = passwordText.getPassword();

        try(PrintWriter bw = new PrintWriter(new BufferedWriter(new FileWriter("loginDetails.txt",true)))){
	
            //boolean end = false;
            //Student s = new Student(FirstN,LastN,Id,street,city,PhoneNo);
            String p = new String(passWord);
            bw.write(IdText.getText()+","+p+"\n");
            //JOptionPane.showMessageDialog(null, "New User created"); 
            
        }
        catch(FileNotFoundException ex){
             JOptionPane.showMessageDialog(null,"File Not Found");
        }
        catch(Exception ex){
             JOptionPane.showMessageDialog(null,ex.getMessage());
        }
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection con=DriverManager.getConnection(  
            "jdbc:mysql://localhost:3306/bus_system","root","*Laya2003*");  
             
            PreparedStatement insert = con.prepareStatement("INSERT INTO Passenger (ID,Name,Contact_No,City,Street,Bldg) VALUES (?,?,?,?,?,?)");
            insert.setString(1,Id);
            insert.setString(2,FirstN+" "+LastN);
            insert.setInt(3,PhoneNo);
            insert.setString(4,city);
            insert.setString(5,street);
            insert.setString(6,Bldg);
            insert.executeUpdate();
            JOptionPane.showMessageDialog(null,"Account Created!");
            con.close();  
        }catch(Exception e){System.out.println(e);}

        
    }       
   
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StudentLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnCreateAccount;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPasswordField passwordText;
    private javax.swing.JTextField FirstNameText;
    private javax.swing.JTextField LastNameText;
    private javax.swing.JTextField PhoneNoText;
    private javax.swing.JTextField CityAddressText;
    private javax.swing.JTextField StreetAddressText;
    private javax.swing.JTextField IdText;
    private javax.swing.JTextField BldgAddressText;
    private javax.swing.JDesktopPane dp;
    private javax.swing.JPanel panelStatus;
    // End of variables declaration//GEN-END:variables
}