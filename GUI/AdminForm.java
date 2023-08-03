package GUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.sql.*;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import Classes.*;

public class AdminForm extends javax.swing.JFrame {
        
    //  Creates new form StudentNew

   
     public static SystemManager manager ;
    
   
     public AdminForm() {
        initComponents();
        
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
  
    private void initComponents() {

        jLabelPassengerDetails = new javax.swing.JLabel();
        jLabelRoute = new javax.swing.JLabel();
        jLabelPendingFee = new javax.swing.JLabel();
        jLabelAssignBus = new javax.swing.JLabel();
        jLabelUpdateBus = new javax.swing.JLabel();
        jLabelAnnounce = new javax.swing.JLabel();
        jLabelUpdateDriver = new javax.swing.JLabel();
        jLabelPBus = new javax.swing.JLabel();
        btnPassengerDetails = new javax.swing.JButton();
        btnRoute = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnAssignBus = new javax.swing.JButton();
        btnBus = new javax.swing.JButton();
        btnPayment = new javax.swing.JButton();
        btnUpdatebus = new javax.swing.JButton();
        btnUpdateDriver = new javax.swing.JButton();
        btnAnnouncements = new javax.swing.JButton();
        dp = new javax.swing.JDesktopPane();
        panelStatus = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Admin Page | Ride With Us");
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

            ResultSet rs1=stmt.executeQuery("SELECT Date,Time,Info FROM announcements ORDER BY Date DESC");
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

        jLabelPassengerDetails.setFont(new java.awt.Font("SansSerif", 0, 14)); 
        jLabelPassengerDetails.setText("View Passenger Details");
        jLabelPassengerDetails.setForeground(Color.white);
        getContentPane().add(jLabelPassengerDetails);
        jLabelPassengerDetails.setBounds(50, 150, 400, 20);

        jLabelRoute.setFont(new java.awt.Font("SansSerif", 0, 14)); 
        jLabelRoute.setText("Check Bus Routes");
        jLabelRoute.setForeground(Color.white);
        getContentPane().add(jLabelRoute);
        jLabelRoute.setBounds(50, 240, 400, 20);

        jLabelAssignBus.setFont(new java.awt.Font("SansSerif", 0, 14)); 
        jLabelAssignBus.setText("Assign Bus");
        jLabelAssignBus.setForeground(Color.white);
        getContentPane().add(jLabelAssignBus);
        jLabelAssignBus.setBounds(50, 330, 400, 20);

        jLabelPBus.setFont(new java.awt.Font("SansSerif", 0, 14)); 
        jLabelPBus.setText("View Passengers of Bus");
        jLabelPBus.setForeground(Color.white);
        getContentPane().add(jLabelPBus);
        jLabelPBus.setBounds(50, 420, 400, 20);

        jLabelPendingFee.setFont(new java.awt.Font("SansSerif", 0, 14)); 
        jLabelPendingFee.setText("View Students With Pending Fee ");
        jLabelPendingFee.setForeground(Color.white);
        getContentPane().add(jLabelPendingFee);
        jLabelPendingFee.setBounds(50, 510, 400, 20);

        jLabelUpdateBus.setFont(new java.awt.Font("SansSerif", 0, 14)); 
        jLabelUpdateBus.setText("Update Bus details");
        jLabelUpdateBus.setForeground(Color.white);
        getContentPane().add(jLabelUpdateBus);
        jLabelUpdateBus.setBounds(50, 600, 200, 20);

        jLabelUpdateDriver.setFont(new java.awt.Font("SansSerif", 0, 14)); 
        jLabelUpdateDriver.setText("Update Driver details");
        jLabelUpdateDriver.setForeground(Color.white);
        getContentPane().add(jLabelUpdateDriver);
        jLabelUpdateDriver.setBounds(50, 690, 200, 19);

        jLabelAnnounce.setFont(new java.awt.Font("SansSerif", 0, 14)); 
        jLabelAnnounce.setText("Announcements");
        jLabelAnnounce.setForeground(Color.white);
        getContentPane().add(jLabelAnnounce);
        jLabelAnnounce.setBounds(50, 780, 170, 19);

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
        btnBack.setBounds(50, 90, 100, 32);

        btnPassengerDetails.setBackground(new Color(112, 161, 180));
        btnPassengerDetails.setForeground(Color.WHITE);
        btnPassengerDetails.setUI(new StyledButtonUI());
        btnPassengerDetails.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                btnPassengerDetails.setBackground(new Color(92, 132, 147));
            }
            public void mouseExited(MouseEvent evt) {
                btnPassengerDetails.setBackground(new Color(112, 161, 180));
            }
        });
        btnPassengerDetails.setFont(new java.awt.Font("SansSerif", 0, 12)); 
        btnPassengerDetails.setText("Passenger");
        btnPassengerDetails.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnPassengerDetailsActionPerformed(evt);
            }
        });
        getContentPane().add(btnPassengerDetails);
        btnPassengerDetails.setBounds(50, 180, 100, 32);

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
        btnRoute.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnRouteActionPerformed(evt);
            }
        });
        getContentPane().add(btnRoute);
        btnRoute.setBounds(50, 260, 100, 32);

        //Bus Button
        btnAssignBus.setBackground(new Color(112, 161, 180));
        btnAssignBus.setForeground(Color.WHITE);
        btnAssignBus.setUI(new StyledButtonUI());
        btnAssignBus.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                btnAssignBus.setBackground(new Color(92, 132, 147));
            }
            public void mouseExited(MouseEvent evt) {
                btnAssignBus.setBackground(new Color(112, 161, 180));
            }
        });
        btnAssignBus.setFont(new java.awt.Font("SansSerif", 0, 12)); 
        btnAssignBus.setText("Assign Bus");
        btnAssignBus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnAssignBusActionPerformed(evt);
            }
        });
        getContentPane().add(btnAssignBus);
        btnAssignBus.setBounds(50, 350, 100, 32);

        //Bus Button
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
        btnBus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnBusActionPerformed(evt);
            }
        });
        getContentPane().add(btnBus);
        btnBus.setBounds(50, 440, 100, 32);

        //Student Details Button
        btnPayment.setBackground(new Color(112, 161, 180));
        btnPayment.setForeground(Color.WHITE);
        btnPayment.setUI(new StyledButtonUI());
        btnPayment.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                btnPayment.setBackground(new Color(92, 132, 147));
            }
            public void mouseExited(MouseEvent evt) {
                btnPayment.setBackground(new Color(112, 161, 180));
            }
        });
        btnPayment.setFont(new java.awt.Font("SansSerif", 0, 12)); 
        btnPayment.setText("Pending Fee");
        btnPayment.setForeground(Color.white);
        btnPayment.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnStudentActionPerformed(evt);
            }
        });
        getContentPane().add(btnPayment);
        btnPayment.setBounds(50, 530, 100, 32);

        //Update Bus Details Button
        btnUpdatebus.setBackground(new Color(112, 161, 180));
        btnUpdatebus.setForeground(Color.WHITE);
        btnUpdatebus.setUI(new StyledButtonUI());
        btnUpdatebus.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                btnUpdatebus.setBackground(new Color(92, 132, 147));
            }
            public void mouseExited(MouseEvent evt) {
                btnUpdatebus.setBackground(new Color(112, 161, 180));
            }
        });
        btnUpdatebus.setFont(new java.awt.Font("SansSerif", 0, 12)); 
        btnUpdatebus.setText("Bus Details");
        btnUpdatebus.setForeground(Color.white);

        
        btnUpdatebus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnDetailsActionPerformed(evt);
            }
        });
        getContentPane().add(btnUpdatebus);
        btnUpdatebus.setBounds(50, 620, 100, 32);

        //Bus Edit Button
        btnUpdateDriver.setBackground(new Color(112, 161, 180));
        btnUpdateDriver.setForeground(Color.WHITE);
        btnUpdateDriver.setUI(new StyledButtonUI());
        btnUpdateDriver.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                btnUpdateDriver.setBackground(new Color(92, 132, 147));
            }
            public void mouseExited(MouseEvent evt) {
                btnUpdateDriver.setBackground(new Color(112, 161, 180));
            }
        });
        btnUpdateDriver.setFont(new java.awt.Font("SansSerif", 0, 12)); 
        btnUpdateDriver.setText("Driver Details");
        btnUpdateDriver.setForeground(Color.white);
        btnUpdateDriver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnBusEditActionPerformed(evt);
            }
        });
        getContentPane().add(btnUpdateDriver);
        btnUpdateDriver.setBounds(50, 710, 100, 32);

        //Announcement Button
        btnAnnouncements.setBackground(new Color(112, 161, 180));
        btnAnnouncements.setForeground(Color.WHITE);
        btnAnnouncements.setUI(new StyledButtonUI());
        btnAnnouncements.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                btnAnnouncements.setBackground(new Color(92, 132, 147));
            }
            public void mouseExited(MouseEvent evt) {
                btnAnnouncements.setBackground(new Color(112, 161, 180));
            }
        });
        btnAnnouncements.setFont(new java.awt.Font("SansSerif", 0, 12)); 
        btnAnnouncements.setText("Announce");
        btnAnnouncements.setForeground(Color.white);
        btnAnnouncements.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnAnnouncementActionPerformed(evt);
            }
        });
        getContentPane().add(btnAnnouncements);
        btnAnnouncements.setBounds(50, 800, 100, 32);


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
        AdminLogin ss = new AdminLogin();
        ss.setVisible(true);
        ss.pack();
        this.dispose();
    }

    private void btnPassengerDetailsActionPerformed(ActionEvent evt) {
        PassengerDetails ss = new PassengerDetails();
        ss.setVisible(true);
        ss.pack();
        this.dispose();
    }

    private void btnRouteActionPerformed(ActionEvent evt) {
        ABusRoute ss = new ABusRoute();
        ss.setVisible(true);
        ss.pack();
        this.dispose();
    }

    private void btnAssignBusActionPerformed(ActionEvent evt) {
        assignBus ss = new assignBus();
        ss.setVisible(true);
        ss.pack();
        this.dispose();
    }

    private void btnBusActionPerformed(ActionEvent evt) {
        Bus ss = new Bus();
        ss.setVisible(true);
        ss.pack();
        this.dispose();
    }
    private void btnStudentActionPerformed(ActionEvent evt) {
        DueStudents s = new DueStudents();
        s.setVisible(true);
        s.pack();
        this.dispose();
    }
    private void btnDetailsActionPerformed(ActionEvent evt) {
        UpdateBus s = new UpdateBus();
        s.setVisible(true);
        s.pack();
        this.dispose();
    }
    private void btnAnnouncementActionPerformed(ActionEvent evt) {
        Announcement s = new Announcement();
        s.setVisible(true);
        s.pack();
        this.dispose();
    }

    private void btnBusEditActionPerformed(ActionEvent evt) {
        UpdateDriver s = new UpdateDriver();
        s.setVisible(true);
        s.pack();
        this.dispose();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnBus;
    private javax.swing.JButton btnPayment;
    private javax.swing.JButton btnUpdatebus;
    private javax.swing.JButton btnUpdateDriver;
    private javax.swing.JButton btnAnnouncements;
    private javax.swing.JButton btnAssignBus;
    private javax.swing.JButton btnPassengerDetails;
    private javax.swing.JButton btnRoute;
    private javax.swing.JLabel jLabelPassengerDetails;
    private javax.swing.JLabel jLabelRoute;
    private javax.swing.JLabel jLabelPendingFee;
    private javax.swing.JLabel jLabelAssignBus;
    private javax.swing.JLabel jLabelUpdateBus;
    private javax.swing.JLabel jLabelAnnounce;
    private javax.swing.JLabel jLabelUpdateDriver;
    private javax.swing.JLabel jLabelPBus;
    private javax.swing.JDesktopPane dp;
    private javax.swing.JPanel panelStatus;
    // End of variables declaration//GEN-END:variables
}