package GUI;
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

class getPReserve extends ProfessorLogin{

    public String getId(){
        return p.getID();
    }
 
}
public class PReserve extends javax.swing.JFrame {
        
   
     public static SystemManager manager ;
    
     public PReserve() {
        initComponents();
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
   
    
    private void initComponents() {
        p1 = new getPReserve();
        JButton btnReserve = new JButton();
        textField1 = new javax.swing.JTextField();
        textField2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        JLabel jLabel2 = new JLabel();
        btnBack = new javax.swing.JButton();
        dp = new javax.swing.JDesktopPane();
        panelStatus = new javax.swing.JPanel();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Professor Page | Ride With Us");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(1900,990));
        setResizable(true);
        getContentPane().setLayout(null);

        textField1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //textField1ActionPerformed(evt);
            }
        });

        getContentPane().add(textField1);
        textField1.setBounds(450, 290, 180, 30);

        textField2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //textField2ActionPerformed(evt);
            }
        });
        getContentPane().add(textField2);
        textField2.setBounds(450, 380, 180, 30);

        try{ 
            int rows=0;
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection con=DriverManager.getConnection(  
            "jdbc:mysql://localhost:3306/bus_system","root","*Laya2003*");  
            Statement stmt=con.createStatement();  
            ResultSet rs=stmt.executeQuery("SELECT COUNT(*) FROM Reserved");
            rs.next();
            rows = rs.getInt(1);
            String data[][] = new String[rows][];  

            PreparedStatement select = con.prepareStatement("SELECT * FROM Reserved");
            //select.setString(1,p1.getId());
            ResultSet rs1=select.executeQuery();

            int j=0;
            while(rs1.next()){
                String entry[]= new String[4];
                for(int i =0; i<4; i++){
                    entry[i] = rs1.getString(i+1);
                }
                data[j]=entry;
                j++;
            }  
            String column[]={"ID","Date","BusNo","Semesters"};
            JTable reserveDetails = new JTable(data,column);
            JScrollPane sp=new JScrollPane(reserveDetails);
            sp.setBounds(1000,180,800,600);
            getContentPane().add(sp);
            setVisible(true);
            con.close();  
        }catch(Exception e){System.out.println(e);}   
        

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 14)); 
        jLabel1.setText("Bus Number");
        jLabel1.setForeground(Color.white);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(200, 290, 250, 20);

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 14)); 
        jLabel2.setText("Number of Semesters");
        jLabel2.setForeground(Color.white);
        getContentPane().add(jLabel2);
        jLabel2.setBounds(200, 380, 250, 20);

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

        //PReserve Button
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
        btnReserve.setText("PReserve");
        btnReserve.setForeground(Color.white);
        btnReserve.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnReserveActionPerformed(evt);
            }
        });
        getContentPane().add(btnReserve);
        btnReserve.setBounds(200, 650, 100, 32);

       
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
        ProfessorForm ss = new ProfessorForm();
        ss.setVisible(true);
        ss.pack();
        this.dispose();
        
    }
    private void btnReserveActionPerformed(ActionEvent evt) {
        int BusNo = Integer.parseInt(textField1.getText());
        int Semesters = Integer.parseInt(textField2.getText());
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection con=DriverManager.getConnection(  
            "jdbc:mysql://localhost:3306/bus_system","root","*Laya2003*");  
             
            PreparedStatement insert = con.prepareStatement("INSERT INTO Reserved (ID,Date,BusNo,Semesters) VALUES (?,curDate(),?,?) ");
            insert.setString(1,p1.getId());
            insert.setInt(2,BusNo);
            insert.setInt(3,Semesters);
            //insert.setString(4,Area);
            insert.executeUpdate();
            JOptionPane.showMessageDialog(null,"Record Added!");
            con.close();  
        }catch(Exception e){System.out.println(e);}
        PReserve bs = new PReserve();
        bs.setVisible(true);
        bs.pack();
        this.dispose();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField textField1;
    private javax.swing.JTextField textField2;
    private javax.swing.JDesktopPane dp;
    private javax.swing.JPanel panelStatus;
    private getPReserve p1;
    // End of variables declaration//GEN-END:variables
}
