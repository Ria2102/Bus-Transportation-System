package GUI;
import java.sql.*;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import Classes.*;

class id1 extends StudentLogin{
    public String getId(){
        return s.getID();
    }
}

public class StudentForm extends javax.swing.JFrame {
        
   
     public static SystemManager manager ;
    
   
     public StudentForm() {
        initComponents();
        
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void initComponents() {
        i = new id1();

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        btnBack = new javax.swing.JButton();
        btnDetails = new javax.swing.JButton();
        btnAttendance = new javax.swing.JButton();
        btnPayment = new javax.swing.JButton();
        btnRouteView = new javax.swing.JButton();
        btnReserve = new javax.swing.JButton();
        dp = new javax.swing.JDesktopPane();
        panelStatus = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Student Page | Ride With Us");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(1900,990));
        setResizable(true);
        getContentPane().setLayout(null);

        //sql
        try{ 
            int rows=0;
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection con=DriverManager.getConnection(  
            "jdbc:mysql://localhost:3306/bus_system","root","*Laya2003*");  
            Statement stmt=con.createStatement();  
            ResultSet rs=stmt.executeQuery("SELECT COUNT(*) FROM Announcements");
            
            rs.next();
            rows = rs.getInt(1);
            String data[][] = new String[rows][];  

            ResultSet rs1=stmt.executeQuery("SELECT Date, time, Info FROM Announcements");
            
            int j=0;
            while(rs1.next()){
                String entry[]= new String[3];
                for(int i =0; i<3; i++){
                    entry[i] = rs1.getString(i+1);
                }
                data[j]=entry;
                j++;
            }  
            String column[]={"Date","Time","Announcement"};
            JTable announcement = new JTable(data,column);
            announcement.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            announcement.getColumnModel().getColumn(0).setPreferredWidth(90);
            announcement.getColumnModel().getColumn(1).setPreferredWidth(90);
            announcement.getColumnModel().getColumn(2).setPreferredWidth(620);

            
            JScrollPane sp=new JScrollPane(announcement);
            sp.setBounds(1000,300,800,500);
            getContentPane().add(sp);
            setVisible(true);
            con.close();  
        }catch(Exception e){System.out.println(e);}  

        try{ 
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection con=DriverManager.getConnection(  
            "jdbc:mysql://localhost:3306/bus_system","root","*Laya2003*");  
            Statement stmt=con.createStatement();  
            
            String data1[][] = new String[1][];
            ResultSet rs2=stmt.executeQuery("SELECT ID,dues,Amount,(dues-Amount) AS Balance FROM payment_status WHERE ID='"+i.getId()+"'");
            
            rs2.next();
            String row[] = new String[4];
            for(int i=0; i<4; i++){
                row[i] = rs2.getString(i+1);
            }
            data1[0]=row;
            
            String column1[]={"ID","Due","Amount Paid","Balance"};
            JTable Payment_status = new JTable(data1,column1);

            JScrollPane sp0=new JScrollPane(Payment_status);
            sp0.setBounds(1000,180,800,100);
            getContentPane().add(sp0);
            setVisible(true);
            con.close();  
        }catch(Exception e){System.out.println(e);}

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 14)); 
        jLabel2.setText("View Bus Details");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(50,330, 180, 20);
        jLabel2.setForeground(Color.white);

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 14)); 
        jLabel3.setText("Mark your Attendance");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(50, 420, 150, 19);
        jLabel3.setForeground(Color.white);

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 14)); 
        jLabel4.setText("Check Route");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(50, 510, 150, 19);
        jLabel4.setForeground(Color.white);

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 14)); 
        jLabel5.setText("Make Payment");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(50, 600, 150, 19);
        jLabel5.setForeground(Color.white);

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 14)); 
        jLabel6.setText("Reserve Seat");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(50, 690, 150, 19);
        jLabel6.setForeground(Color.white);

        //Back Button
        btnBack.setBackground(new Color(112, 161, 180));
        btnBack.setForeground(Color.WHITE);
        btnBack.setUI(new StyledButtonUI());
        btnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBack.setBackground(new Color(92, 132, 147));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBack.setBackground(new Color(112, 161, 180));
            }
        });
        btnBack.setFont(new java.awt.Font("SansSerif", 0, 12)); 
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnBack);
        btnBack.setBounds(10, 10, 100, 32);

        
        //Bus Details Button
        btnDetails.setBackground(new Color(112, 161, 180));
        btnDetails.setForeground(Color.WHITE);
        btnDetails.setUI(new StyledButtonUI());
        btnDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDetails.setBackground(new Color(92, 132, 147));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDetails.setBackground(new Color(112, 161, 180));
            }
        });
        btnDetails.setFont(new java.awt.Font("SansSerif", 0, 12)); 
        btnDetails.setText("Bus Details");
        btnDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetailsActionPerformed(evt);
            }
        });
        getContentPane().add(btnDetails);
        btnDetails.setBounds(50, 350, 100, 32);

        
        //Attendence Button
        btnAttendance.setBackground(new Color(112, 161, 180));
        btnAttendance.setForeground(Color.WHITE);
        btnAttendance.setUI(new StyledButtonUI());
        btnAttendance.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAttendance.setBackground(new Color(92, 132, 147));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAttendance.setBackground(new Color(112, 161, 180));
            }
        });
        btnAttendance.setFont(new java.awt.Font("SansSerif", 0, 12)); 
        btnAttendance.setText("Attendance");
        btnAttendance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAttendanceActionPerformed(evt);
            }
        });
        getContentPane().add(btnAttendance);
        btnAttendance.setBounds(50, 440, 100, 32);
        
        btnRouteView.setBackground(new Color(112, 161, 180));
        btnRouteView.setForeground(Color.WHITE);
        btnRouteView.setUI(new StyledButtonUI());
        btnRouteView.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRouteView.setBackground(new Color(92, 132, 147));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRouteView.setBackground(new Color(112, 161, 180));
            }
        });
        btnRouteView.setFont(new java.awt.Font("SansSerif", 0, 12)); 
        btnRouteView.setText("View");
        btnRouteView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRouteViewActionPerformed(evt);
            }
        });
        getContentPane().add(btnRouteView);
        btnRouteView.setBounds(50, 530, 100, 32);

        btnPayment.setBackground(new Color(112, 161, 180));
        btnPayment.setForeground(Color.WHITE);
        btnPayment.setUI(new StyledButtonUI());
        btnPayment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPayment.setBackground(new Color(92, 132, 147));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPayment.setBackground(new Color(112, 161, 180));
            }
        });
        btnPayment.setFont(new java.awt.Font("SansSerif", 0, 12)); 
        btnPayment.setText("Payment");
        btnPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPaymentActionPerformed(evt);
            }
        });
        getContentPane().add(btnPayment);
        btnPayment.setBounds(50, 620, 100, 32);

        btnReserve.setBackground(new Color(112, 161, 180));
        btnReserve.setForeground(Color.WHITE);
        btnReserve.setUI(new StyledButtonUI());
        btnReserve.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnReserve.setBackground(new Color(92, 132, 147));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnReserve.setBackground(new Color(112, 161, 180));
            }
        });
        btnReserve.setFont(new java.awt.Font("SansSerif", 0, 12)); 
        btnReserve.setText("Reserve");
        btnReserve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReserveActionPerformed(evt);
            }
        });
        getContentPane().add(btnReserve);
        btnReserve.setBounds(50, 710, 100, 32);
        
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
        StudentLogin ss = new StudentLogin();
        ss.setVisible(true);
        ss.pack();
        this.dispose();
        
    }
   
    private void btnDetailsActionPerformed(java.awt.event.ActionEvent evt) {
        SBusDetails cb = new SBusDetails();
        cb.setVisible(true);
        cb.pack();
        this.dispose();   
    }
    private void btnAttendanceActionPerformed(java.awt.event.ActionEvent evt) {
        AbsentS sl = new AbsentS();
        sl.setVisible(true);
        sl.pack();
        this.dispose();       
    }
    private void btnRouteViewActionPerformed(java.awt.event.ActionEvent evt) {
        SBusRoute rt = new SBusRoute();
        rt.setVisible(true);
        rt.pack();
        this.dispose();       
    }
    private void btnPaymentActionPerformed(java.awt.event.ActionEvent evt) {
        Payment pt = new Payment();
        pt.setVisible(true);
        pt.pack();
        this.dispose();       
    }
    private void btnReserveActionPerformed(java.awt.event.ActionEvent evt) {
        SReserve rs = new SReserve();
        rs.setVisible(true);
        rs.pack();
        this.dispose();       
    }
    //GEN-LAST:event_btnCancelActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDetails;
    private javax.swing.JButton btnAttendance;
    private javax.swing.JButton btnRouteView;
    private javax.swing.JButton btnPayment;
    private javax.swing.JButton btnReserve;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JDesktopPane dp;
    private javax.swing.JPanel panelStatus;
    private id1 i;
    // End of variables declaration//GEN-END:variables
}