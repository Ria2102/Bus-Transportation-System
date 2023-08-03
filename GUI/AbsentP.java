package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.Format;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.sql.*;
import java.awt.event.*;
import java.awt.Color;

class getAbsentP extends ProfessorLogin{

    public String getId(){
        return p.getID();
    }
    public String getName(){
        return p.getName();
    }
    public String getCity(){
        return p.getCity();
    }
    public String getStreet(){
        return p.getStreet();
    }
    public String getBldg(){
        return p.getBldg();
    }
}


public class AbsentP extends javax.swing.JFrame {

    //  Creates new form Login
    
    public AbsentP() {
        initComponents();
        
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    
    private void initComponents() {
        s = new getAbsentP();
        titlelabel = new javax.swing.JLabel();
        absentlabel = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        btnNotify = new javax.swing.JButton();
        dp = new javax.swing.JDesktopPane();
        panelStatus = new javax.swing.JPanel();
        long millis = System.currentTimeMillis();
        Date today = new Date(millis);
        jDateChooser = new com.toedter.calendar.JDateChooser();

        jDateChooser.setFont(new java.awt.Font("SansSerif", 0, 14));
        getContentPane().add(jDateChooser);
        jDateChooser.setBounds(330, 250, 150, 25);
        jDateChooser.setMinSelectableDate(today);


        titlelabel.setFont(new java.awt.Font("SansSerif", 0, 14)); 
        titlelabel.setText("Inform the Driver when not using the transport:");
        titlelabel.setForeground(Color.white);
        getContentPane().add(titlelabel);
        titlelabel.setBounds(200, 200, 500, 20);

        absentlabel.setFont(new java.awt.Font("SansSerif", 0, 14)); 
        absentlabel.setText("Absent Date:");
        absentlabel.setForeground(Color.white);
        getContentPane().add(absentlabel);
        absentlabel.setBounds(230, 250, 250, 20);


        //Notify Button
        btnNotify.setBackground(new Color(112, 161, 180));
        btnNotify.setForeground(Color.WHITE);
        btnNotify.setUI(new StyledButtonUI());
        btnNotify.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                btnNotify.setBackground(new Color(92, 132, 147));
            }
            public void mouseExited(MouseEvent evt) {
                btnNotify.setBackground(new Color(112, 161, 180));
            }
        });
        btnNotify.setFont(new java.awt.Font("SansSerif", 0, 12)); 
        btnNotify.setText("Notify Driver");
        btnNotify.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnNotifyActionPerformed(evt);
            }
        });
        getContentPane().add(btnNotify);
        btnNotify.setBounds(230, 360, 100, 32);
 
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
        btnBack.setBounds(370, 360, 100, 32);

        
        try{ 
            int rows=0;
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection con=DriverManager.getConnection(  
            "jdbc:mysql://localhost:3306/bus_system","root","*Laya2003*"); 
            PreparedStatement countrow = con.prepareStatement("SELECT COUNT(*) FROM Absent WHERE ID =?");
            countrow.setString(1,s.getId());
            ResultSet rs1=countrow.executeQuery();
            rs1.next();
            rows = rs1.getInt(1);
            String data[][] = new String[rows][];  

            PreparedStatement details = con.prepareStatement("SELECT * FROM Absent WHERE ID = ? ORDER BY Date DESC");
            details.setString(1,s.getId());
            ResultSet rs2=details.executeQuery();
            
            int j=0;
            while(rs2.next()){
                String entry[]= new String[6];
                for(int i =0; i<6; i++){
                    entry[i] = rs2.getString(i+1);
                }
                data[j]=entry;
                j++;
            }  
            String column[]={"ID","Name","Date","City","Street","Bldg"};
            absentdetails = new JTable(data,column);
            JScrollPane sp=new JScrollPane(absentdetails);
            sp.setBounds(800,180,1000,600);
            getContentPane().add(sp);
            setVisible(false);
            con.close();  
        }catch(Exception e){System.out.println(e);} 

     
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Professor | Ride With Us");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(1900,990));
        setResizable(true);
        getContentPane().setLayout(null);

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

    

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {
        ProfessorForm dLogin = new ProfessorForm();
        dLogin.pack();
        dLogin.setVisible(true);
        this.dispose();
                     
	}

    private void btnNotifyActionPerformed(java.awt.event.ActionEvent evt) {
        Format f = new SimpleDateFormat("yyyy-MM-dd");
        String d = f.format(jDateChooser.getDate());
        //Date d = (Date) jDateChooser.getDate();
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection con=DriverManager.getConnection(  
            "jdbc:mysql://localhost:3306/bus_system","root","*Laya2003*");  
             
            PreparedStatement insert = con.prepareStatement("INSERT INTO Absent VALUES(?,?,?,?,?,?)");
            insert.setString(1,s.getId());
            insert.setString(2,s.getName());
            insert.setString(3,d);
            insert.setString(4,s.getCity());
            insert.setString(5,s.getStreet());
            insert.setString(6,s.getBldg());
            //insert.setInt(6,s.getContactNo());
            insert.executeUpdate();
            JOptionPane.showMessageDialog(null,"Notified The Driver!");
            con.close();  
        }catch(Exception e){System.out.println(e);}
        AbsentP bs = new AbsentP();
        bs.setVisible(true);
        bs.pack();
        this.dispose();         
	}
	
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnNotify;
    private javax.swing.JDesktopPane dp;
    private javax.swing.JPanel panelStatus;
    private javax.swing.JLabel absentlabel;
    private javax.swing.JLabel titlelabel;
    private javax.swing.JTable absentdetails;
    private getAbsentP s;
    private com.toedter.calendar.JDateChooser jDateChooser;

    
    // End of variables declaration//GEN-END:variables
}

