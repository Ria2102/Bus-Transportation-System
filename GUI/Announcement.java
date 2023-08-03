package GUI;
import java.awt.Color;
import java.sql.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;



public class Announcement extends javax.swing.JFrame {
        
    
     JFrame f;
     public Announcement() {
        initComponents();
        
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
  
    private void initComponents() {

        message = new javax.swing.JTextArea();
        JButton btnDone = new JButton();
        JButton btnBack = new JButton();
        JPanel panelStatus = new JPanel();
        dp = new javax.swing.JDesktopPane();
        JScrollPane s = new JScrollPane(f);
        getContentPane().add(s);


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Admin Page | Ride With Us");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(1900,990));
        setResizable(true);
        getContentPane().setLayout(null);
        
        message.setText("Enter Annoucement Here!");
        message.setBounds(180,180,1500,500);
        getContentPane().add(message);
        setVisible(true);
        //back button
        setVisible(true);
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
        btnBack.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
            
        });
        btnBack.setBackground(new Color(112,148,156));
        btnBack.setForeground(Color.white);
        getContentPane().add(btnBack);
        btnBack.setBounds(10, 10, 90, 32);

        //Done button
        setVisible(true);
        btnDone.setBackground(new Color(112, 161, 180));
        btnDone.setForeground(Color.WHITE);
        btnDone.setUI(new StyledButtonUI());
        btnDone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDone.setBackground(new Color(92, 132, 147));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDone.setBackground(new Color(112, 161, 180));
            }
        });
        btnDone.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnDone.setText("Done");
        btnDone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoneActionPerformed(evt);
            }
            
        });
        btnDone.setBackground(new Color(112,148,156));
        btnDone.setForeground(Color.white);
        getContentPane().add(btnDone);
        btnDone.setBounds(900, 700, 90, 32);


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
        
        AdminForm lf = new AdminForm();
        lf.setVisible(true);
        lf.pack();
        this.dispose();
        
    }

    private void btnDoneActionPerformed(java.awt.event.ActionEvent evt) {
        String a = message.getText();
        System.out.println(a);

        //sql
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection con=DriverManager.getConnection(  
            "jdbc:mysql://localhost:3306/bus_system","root","*Laya2003*");  
            Statement stmt=con.createStatement();  
            stmt.executeUpdate("INSERT INTO announcements (Date,Time,User_ID,Info) VALUES (curDate(),curTime(),'admin','"+a+"')");
            JOptionPane.showMessageDialog(null,"Announcement has been made!");
   
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
            java.util.logging.Logger.getLogger(Announcement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Announcement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Announcement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Announcement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
     
            
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Announcement().setVisible(true);
            }
        });
        
    }

    // Variables declaration
    private javax.swing.JDesktopPane dp;
    private javax.swing.JTextArea message;
    // End of variables declaration//GEN-END:variables
}






