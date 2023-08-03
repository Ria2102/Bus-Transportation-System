package GUI;
import java.util.Calendar;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.sql.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Classes.*;

class getSReserve extends StudentLogin{

    public String getId(){
        return s.getID();
    }
    public String getCity(){
        return s.getCity();
    }
    public String getStreet(){
        return s.getStreet();
    }
    public String getBldg(){
        return s.getBldg();
    }
    public String getendDate(){
        return s.getendDate();
    }
 
}
public class SReserve extends javax.swing.JFrame {
        
    // Creates new form DriverNew
   
     public static SystemManager manager ;
    
     public SReserve() {
        initComponents();
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
   
    
    private void initComponents() {
        p1 = new getSReserve();
        JButton btnReserve = new JButton();
        JButton btnSetLoc = new JButton();
        textFCity = new javax.swing.JTextField();
        textFStreet = new javax.swing.JTextField();
        textFBldg = new javax.swing.JTextField();
        textFSem = new javax.swing.JTextField();
        jLabelCity = new javax.swing.JLabel();
        jLabelStreet = new javax.swing.JLabel();
        jLabelBldg = new javax.swing.JLabel();
        JLabel jLabelSem = new JLabel();
        btnBack = new javax.swing.JButton();
        dp = new javax.swing.JDesktopPane();
        panelStatus = new javax.swing.JPanel();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Student Page | Ride With Us");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(1900,990));
        setResizable(true);
        getContentPane().setLayout(null);

        textFCity.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //textField1ActionPerformed(evt);
            }
        });
        getContentPane().add(textFCity);
        textFCity.setBounds(450, 200, 180, 30);
        textFCity.setText(p1.getCity());

        textFStreet.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //textField1ActionPerformed(evt);
            }
        });
        getContentPane().add(textFStreet);
        textFStreet.setBounds(450, 290, 180, 30);
        textFStreet.setText(p1.getStreet());


        textFBldg.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //textField1ActionPerformed(evt);
            }
        });
        getContentPane().add(textFBldg);
        textFBldg.setBounds(450, 380, 180, 30);
        textFBldg.setText(p1.getBldg());


        textFSem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //textFSemActionPerformed(evt);
            }
        });
        getContentPane().add(textFSem);
        textFSem.setBounds(450, 510, 180, 30);
        

        try{ 
            int rows=0;
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection con=DriverManager.getConnection(  
            "jdbc:mysql://localhost:3306/bus_system","root","*Laya2003*");  
            Statement stmt=con.createStatement();  
            
            ResultSet rs=stmt.executeQuery("SELECT COUNT(*) FROM Reserved WHERE ID='"+p1.getId()+"' ORDER BY Date DESC");
            rs.next();
            rows = rs.getInt(1);
            String data[][] = new String[rows][];  

            PreparedStatement select = con.prepareStatement("SELECT * FROM Reserved WHERE ID='"+p1.getId()+"' ORDER BY Date DESC");
            //select.setString(1,p1.getId());
            ResultSet rs1=select.executeQuery();

            int j=0;
            while(rs1.next()){
                String entry[]= new String[5];
                for(int i =0; i<5; i++){
                    entry[i] = rs1.getString(i+1);
                }
                data[j]=entry;
                j++;
            }  
            String column[]={"ID","Date","BusNo","Semesters","End Date"};
            JTable reserveDetails = new JTable(data,column);
            JScrollPane sp=new JScrollPane(reserveDetails);
            sp.setBounds(1000,180,800,600);
            getContentPane().add(sp);
            setVisible(true);
            con.close();  
        }catch(Exception e)
        {
            String data[][]={{}};
            String column[]={"ID","Date","BusNo","Semesters","End Date"};
            JTable reserveDetails = new JTable(data,column);
            JScrollPane sp=new JScrollPane(reserveDetails);
            sp.setBounds(1000,180,800,600);
            getContentPane().add(sp);
            setVisible(true);
        }   
        
        jLabelCity.setFont(new java.awt.Font("SansSerif", 0, 14)); 
        jLabelCity.setText("City");
        jLabelCity.setForeground(Color.white);
        getContentPane().add(jLabelCity);
        jLabelCity.setBounds(200, 200, 250, 20);

        jLabelStreet.setFont(new java.awt.Font("SansSerif", 0, 14)); 
        jLabelStreet.setText("Street");
        jLabelStreet.setForeground(Color.white);
        getContentPane().add(jLabelStreet);
        jLabelStreet.setBounds(200, 290, 250, 20);

        jLabelBldg.setFont(new java.awt.Font("SansSerif", 0, 14)); 
        jLabelBldg.setText("Building");
        jLabelBldg.setForeground(Color.white);
        getContentPane().add(jLabelBldg);
        jLabelBldg.setBounds(200, 380, 250, 20);

        jLabelSem.setFont(new java.awt.Font("SansSerif", 0, 14)); 
        jLabelSem.setText("Number of Semesters");
        jLabelSem.setForeground(Color.white);
        getContentPane().add(jLabelSem);
        jLabelSem.setBounds(200, 510, 250, 20);

        //Back Button
        btnBack.setBackground(new Color(112, 161, 180));
        btnBack.setForeground(Color.WHITE);
        btnBack.setUI(new StyledButtonUI());
        btnBack.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                btnBack.setBackground(new Color(92, 132, 147));
            }
            public void mouseExited(MouseEvent evt) {
                btnBack.setBackground(new Color(112, 161, 180));
            }
        });
        btnBack.setFont(new java.awt.Font("SansSerif", 0, 12)); 
        btnBack.setText("Back");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnBack);
        btnBack.setBounds(10, 10, 90, 32);

        //Set Location Button
        btnSetLoc.setBackground(new Color(112, 161, 180));
        btnSetLoc.setForeground(Color.WHITE);
        btnSetLoc.setUI(new StyledButtonUI());
        btnSetLoc.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                btnSetLoc.setBackground(new Color(92, 132, 147));
            }
            public void mouseExited(MouseEvent evt) {
                btnSetLoc.setBackground(new Color(112, 161, 180));
            }
        });
        btnSetLoc.setFont(new java.awt.Font("SansSerif", 0, 12)); 
        btnSetLoc.setText("Set Location");
        btnSetLoc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnSetLocActionPerformed(evt);
            }
        });
        getContentPane().add(btnSetLoc);
        btnSetLoc.setBounds(400, 440, 120, 32);

        //SReserve Button
        btnReserve.setBackground(new Color(112, 161, 180));
        btnReserve.setForeground(Color.WHITE);
        btnReserve.setUI(new StyledButtonUI());
        btnReserve.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                btnReserve.setBackground(new Color(92, 132, 147));
            }
            public void mouseExited(MouseEvent evt) {
                btnReserve.setBackground(new Color(112, 161, 180));
            }
        });
        btnReserve.setFont(new java.awt.Font("SansSerif", 0, 12)); 
        btnReserve.setText("Reserve");
        btnReserve.setForeground(Color.white);
        btnReserve.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnReserveActionPerformed(evt);
            }
        });
        getContentPane().add(btnReserve);
        btnReserve.setBounds(400, 560, 100, 32);

       
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

        pack();
    }
    
    private void btnBackActionPerformed(ActionEvent evt) {
        StudentForm ss = new StudentForm();
        ss.setVisible(true);
        ss.pack();
        this.dispose(); 
    }

    private void btnSetLocActionPerformed(ActionEvent evt) {
        //int Semesters = Integer.parseInt(textFSem.getText());
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection con=DriverManager.getConnection(  
            "jdbc:mysql://localhost:3306/bus_system","root","*Laya2003*");  
             
            PreparedStatement insert = con.prepareStatement("UPDATE Passenger SET city=?, street=?, bldg=? WHERE ID=? ");
            insert.setString(1,textFCity.getText());
            insert.setString(2,textFStreet.getText());
            insert.setString(3,textFBldg.getText());
            insert.setString(4,p1.getId());
            insert.executeUpdate();
            JOptionPane.showMessageDialog(null,"New Location Set!");
            con.close();  
        }catch(Exception e){System.out.println(e);}
        SReserve bs = new SReserve();
        bs.setVisible(true);
        bs.pack();
        this.dispose();
    }

    private void btnReserveActionPerformed(ActionEvent evt) {
        Calendar cal = Calendar.getInstance();
        int Semesters = Integer.parseInt(textFSem.getText());
        //int day=0;
        int yr = 0;
        int month=0;
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection con=DriverManager.getConnection(  
            "jdbc:mysql://localhost:3306/bus_system","root","*Laya2003*");  

            Statement stmt1=con.createStatement();  
            ResultSet r=stmt1.executeQuery("SELECT max(endDate) FROM Reserved WHERE ID='"+p1.getId()+"'");
            r.next();
            //day = Integer.valueOf((r.getString(1)).substring(8,10));
            month = Integer.valueOf((r.getString(1)).substring(5,7));
            yr = Integer.valueOf((r.getString(1)).substring(0,4));
            if(month == 5){
                month++;
            }
            if(month==12){
                month=1;
                yr++;
            }
            con.close();
        }
        catch(Exception e){
            yr=cal.get(Calendar.YEAR);
            month=cal.get(Calendar.MONTH) + 1;
        }
        String end;
        if(month>=1 && month<=5)
        {
            if(Semesters == 1){ end = yr+"-05-31";}
            else{end = yr+"-12-31";}
        }
        else{
            if(Semesters == 1){end = yr+"-12-31";}
            else
            {
                yr = yr+1;
                end = yr+"-05-31";
            }
        }
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection con=DriverManager.getConnection(  
            "jdbc:mysql://localhost:3306/bus_system","root","*Laya2003*");  

            PreparedStatement insert = con.prepareStatement("INSERT INTO Reserved (ID,Date,BusNo,Semesters,EndDate) VALUES (?,curDate(),NULL,?,?) ");
            insert.setString(1,p1.getId());
            insert.setInt(2,Semesters);
            insert.setString(3,end);
            //insert.setString(4,Area);
            insert.executeUpdate();
            JOptionPane.showMessageDialog(null,"Record Added!");
            con.close();  
        }
             
        catch(Exception e){System.out.println(e);}
        SReserve bs = new SReserve();
        bs.setVisible(true);
        bs.pack();
        this.dispose();
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
            java.util.logging.Logger.getLogger(SReserve.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SReserve.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SReserve.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SReserve.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SReserve().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JLabel jLabelCity;
    private javax.swing.JLabel jLabelStreet;
    private javax.swing.JLabel jLabelBldg;
    private javax.swing.JTextField textFCity;
    private javax.swing.JTextField textFStreet;
    private javax.swing.JTextField textFBldg;
    private javax.swing.JTextField textFSem;
    private javax.swing.JDesktopPane dp;
    private javax.swing.JPanel panelStatus;
    private getSReserve p1;
    // End of variables declaration//GEN-END:variables
}
