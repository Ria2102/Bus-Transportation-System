package GUI;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import Classes.*;

public class DriverForm extends javax.swing.JFrame {
        
     public static SystemManager manager ;
    
     public DriverForm() {
        initComponents();
        
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
   
    
    private void initComponents() {

        jLabelAttendence = new javax.swing.JLabel();
        jLabelBus = new javax.swing.JLabel();
        jLabelRoute = new javax.swing.JLabel();
        btnAttendance = new javax.swing.JButton();
        btnBus = new javax.swing.JButton();
        btnRoute = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        dp = new javax.swing.JDesktopPane();
        panelStatus = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Driver Page | Ride With Us");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(1900,990));
        setResizable(true);
        getContentPane().setLayout(null);

        try{ 
            int rows=0;
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection con=DriverManager.getConnection(  
            "jdbc:mysql://localhost:3306/bus_system","root","*Laya2003*");  
            Statement stmt=con.createStatement();  
            ResultSet rs=stmt.executeQuery("SELECT COUNT(*) FROM announcements");
            rs.next();
            rows = rs.getInt(1);
            String data[][] = new String[rows][];  

            ResultSet rs1=stmt.executeQuery("SELECT Date,Time,Info FROM announcements");
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
            JTable studentDetails = new JTable(data,column);
            studentDetails.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            studentDetails.getColumnModel().getColumn(0).setPreferredWidth(90);
            studentDetails.getColumnModel().getColumn(1).setPreferredWidth(90);
            studentDetails.getColumnModel().getColumn(2).setPreferredWidth(620);
            
            JScrollPane sp=new JScrollPane(studentDetails);
            sp.setBounds(1000,180,800,600);
            getContentPane().add(sp);
            setVisible(true);
            con.close();  
        }catch(Exception e){System.out.println(e);}  

        jLabelAttendence.setFont(new java.awt.Font("SansSerif", 0, 14)); 
        jLabelAttendence.setText("View Absenties ");
        jLabelAttendence.setForeground(Color.white);
        getContentPane().add(jLabelAttendence);
        jLabelAttendence.setBounds(396, 330, 250, 20);

        jLabelBus.setFont(new java.awt.Font("SansSerif", 0, 14)); 
        jLabelBus.setText("View Bus Details ");
        jLabelBus.setForeground(Color.white);
        getContentPane().add(jLabelBus);
        jLabelBus.setBounds(396, 420, 250, 20);

        jLabelRoute.setFont(new java.awt.Font("SansSerif", 0, 14)); 
        jLabelRoute.setText("View Bus Route ");
        jLabelRoute.setForeground(Color.white);
        getContentPane().add(jLabelRoute);
        jLabelRoute.setBounds(396, 510, 250, 20);

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
        btnBack.setBounds(10, 10, 90, 32);

        

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
        btnAttendance.setText("Absente");
        btnAttendance.setForeground(Color.white);
        btnAttendance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAttendanceActionPerformed(evt);
            }
        });
        getContentPane().add(btnAttendance);
        btnAttendance.setBounds(400, 350, 100, 32);


        //Bus Details Button
        btnBus.setBackground(new Color(112, 161, 180));
        btnBus.setForeground(Color.WHITE);
        btnBus.setUI(new StyledButtonUI());
        btnBus.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                btnBus.setBackground(new Color(92, 132, 147));
            }
            public void mouseExited(MouseEvent evt) {
                btnBus.setBackground(new Color(112, 161, 180));
            }
        });
        btnBus.setFont(new java.awt.Font("SansSerif", 0, 12)); 
        btnBus.setText("Bus");
        btnBus.setForeground(Color.white);

        
        btnBus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnBusActionPerformed(evt);
            }
        });
        getContentPane().add(btnBus);
        btnBus.setBounds(400, 440, 100, 32);

        //Route Details Button
        btnRoute.setBackground(new Color(112, 161, 180));
        btnRoute.setForeground(Color.WHITE);
        btnRoute.setUI(new StyledButtonUI());
        btnRoute.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                btnRoute.setBackground(new Color(92, 132, 147));
            }
            public void mouseExited(MouseEvent evt) {
                btnRoute.setBackground(new Color(112, 161, 180));
            }
        });
        btnRoute.setFont(new java.awt.Font("SansSerif", 0, 12)); 
        btnRoute.setText("Route");
        btnRoute.setForeground(Color.white);

        
        btnRoute.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnRouteActionPerformed(evt);
            }
        });
        getContentPane().add(btnRoute);
        btnRoute.setBounds(400, 530, 100, 32);


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
        DriverLogin ss = new DriverLogin();
        ss.setVisible(true);
        ss.pack();
        this.dispose();
        
    }
    private void btnAttendanceActionPerformed(java.awt.event.ActionEvent evt) {
        AbsentList ss = new AbsentList();
        ss.setVisible(true);
        ss.pack();
        this.dispose();
    }

    private void btnBusActionPerformed(java.awt.event.ActionEvent evt) {
        DBusDetails ss = new DBusDetails();
        ss.setVisible(true);
        ss.pack();
        this.dispose();
    }

    private void btnRouteActionPerformed(java.awt.event.ActionEvent evt) {
        DBusRoute ss = new DBusRoute();
        ss.setVisible(true);
        ss.pack();
        this.dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAttendance;
    private javax.swing.JButton btnRoute;
    private javax.swing.JButton btnBus;
    private javax.swing.JButton btnBack;
    private javax.swing.JLabel jLabelAttendence;
    private javax.swing.JLabel jLabelBus;
    private javax.swing.JLabel jLabelRoute;
    private javax.swing.JDesktopPane dp;
    private javax.swing.JPanel panelStatus;
    // End of variables declaration//GEN-END:variables
}