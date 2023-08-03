
package GUI;
import java.sql.*;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import Classes.*;

public class ProfessorForm extends javax.swing.JFrame {
        
    /**
     * Creates new form ProfessorNew
     */
   
     public static SystemManager manager ;
    
   
     public ProfessorForm() {
        initComponents();
        
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        //jLabel4 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        btnBus = new javax.swing.JButton();
        btnRoute = new javax.swing.JButton();
        btnAttendance = new javax.swing.JButton();
        //btnReserve = new javax.swing.JButton();
        dp = new javax.swing.JDesktopPane();
        panelStatus = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Professor Page | Ride With Us");
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

            ResultSet rs1=stmt.executeQuery("SELECT Date,Time,Info FROM Announcements");
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
            JTable ProfessorDetails = new JTable(data,column);
            ProfessorDetails.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            ProfessorDetails.getColumnModel().getColumn(0).setPreferredWidth(90);
            ProfessorDetails.getColumnModel().getColumn(1).setPreferredWidth(90);
            ProfessorDetails.getColumnModel().getColumn(2).setPreferredWidth(620);
            
            JScrollPane sp=new JScrollPane(ProfessorDetails);
            sp.setBounds(1000,180,800,600);
            getContentPane().add(sp);
            setVisible(true);
            con.close();  
        }catch(Exception e){System.out.println(e+"Here");}  

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 14)); 
        jLabel1.setText("View Bus Routes");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(50,240, 180, 20);
        jLabel1.setForeground(Color.white);

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 14)); 
        jLabel2.setText("Check Bus Details");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(50,330, 180, 20);
        jLabel2.setForeground(Color.white);

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 14)); 
        jLabel3.setText("Mark your Attendance");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(50, 420, 150, 19);
        jLabel3.setForeground(Color.white);

        //Reserve Button
        // jLabel4.setFont(new java.awt.Font("SansSerif", 0, 14)); 
        // jLabel4.setText("Reserve your Seat");
        // getContentPane().add(jLabel4);
        // jLabel4.setBounds(50, 510, 120, 18);
        // jLabel4.setForeground(Color.white);

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


        //Bus Route Button
        btnRoute.setBackground(new Color(112, 161, 180));
        btnRoute.setForeground(Color.WHITE);
        btnRoute.setUI(new StyledButtonUI());
        btnRoute.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRoute.setBackground(new Color(92, 132, 147));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRoute.setBackground(new Color(112, 161, 180));
            }
        });
        btnRoute.setFont(new java.awt.Font("SansSerif", 0, 12)); 
        btnRoute.setText("Bus Route");
        btnRoute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRouteActionPerformed(evt);
            }
        });
        getContentPane().add(btnRoute);
        btnRoute.setBounds(50, 260, 100, 32);

        
        //Bus Details Button
        btnBus.setBackground(new Color(112, 161, 180));
        btnBus.setForeground(Color.WHITE);
        btnBus.setUI(new StyledButtonUI());
        btnBus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBus.setBackground(new Color(92, 132, 147));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBus.setBackground(new Color(112, 161, 180));
            }
        });
        btnBus.setFont(new java.awt.Font("SansSerif", 0, 12)); 
        btnBus.setText("Bus Details");
        btnBus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBusActionPerformed(evt);
            }
        });
        getContentPane().add(btnBus);
        btnBus.setBounds(50, 350, 100, 32);

        
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

        //Reserve Button
        // btnReserve.setBackground(new Color(112, 161, 180));
        // btnReserve.setForeground(Color.WHITE);
        // btnReserve.setUI(new StyledButtonUI());
        // btnReserve.addMouseListener(new java.awt.event.MouseAdapter() {
        //     public void mouseEntered(java.awt.event.MouseEvent evt) {
        //         btnReserve.setBackground(new Color(92, 132, 147));
        //     }
        //     public void mouseExited(java.awt.event.MouseEvent evt) {
        //         btnReserve.setBackground(new Color(112, 161, 180));
        //     }
        // });
        // btnReserve.setFont(new java.awt.Font("SansSerif", 0, 12)); 
        // btnReserve.setText("Reservation");
        // btnReserve.addActionListener(new java.awt.event.ActionListener() {
        //     public void actionPerformed(java.awt.event.ActionEvent evt) {
        //         btnReserveActionPerformed(evt);
        //     }
        // });
        // getContentPane().add(btnReserve);
        // btnReserve.setBounds(50, 530, 100, 32);

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
        ProfessorLogin ss = new ProfessorLogin();
        ss.setVisible(true);
        ss.pack();
        this.dispose();
        
    }

    private void btnRouteActionPerformed(java.awt.event.ActionEvent evt) {
        PBusRoute cb = new PBusRoute();
        cb.setVisible(true);
        cb.pack();
        this.dispose();   
    }
   
    private void btnBusActionPerformed(java.awt.event.ActionEvent evt) {
        PBusDetails cb = new PBusDetails();
        cb.setVisible(true);
        cb.pack();
        this.dispose();   
    }
    private void btnAttendanceActionPerformed(java.awt.event.ActionEvent evt) {
        AbsentP sl = new AbsentP();
        sl.setVisible(true);
        sl.pack();
        this.dispose();

        
    }//GEN-LAST:event_btnCancelActionPerformed
    // private void btnReserveActionPerformed(java.awt.event.ActionEvent evt) {
    //     PReserve s2 = new PReserve();
    //     s2.setVisible(true);
    //     s2.pack();
    //     this.dispose();

    // }


    // Variables declaration - do not modify//GEN-BEGIN:variables

    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnBus;
    private javax.swing.JButton btnRoute;
    private javax.swing.JButton btnAttendance;
    //private javax.swing.JButton btnReserve;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    //private javax.swing.JLabel jLabel4;
    private javax.swing.JDesktopPane dp;
    private javax.swing.JPanel panelStatus;
    // End of variables declaration//GEN-END:variables
}