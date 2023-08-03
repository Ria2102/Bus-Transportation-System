package GUI;
import java.awt.Color;
// import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
// import java.awt.image.BufferedImage;
// import java.net.URL;
// import java.text.DateFormat;
// import java.text.SimpleDateFormat;
// import java.util.Calendar;
// import javax.imageio.ImageIO;
// import javax.swing.JFrame;
// import javax.swing.JInternalFrame;
// import javax.swing.JOptionPane;
// import javax.swing.Timer;
// import java.io.*;
// import javax.swing.JOptionPane;
import java.sql.*;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
// import javax.swing.table.DefaultTableModel;

import Classes.*;

public class UpdateBus extends javax.swing.JFrame {
        
    // Creates new form DriverNew
   
     public static SystemManager manager ;
    
     public UpdateBus() {
        initComponents();
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
   
    
    private void initComponents() {

        //lblNow = new javax.swing.JLabel();
        JButton btnAdd = new JButton();
        JButton btnEdit = new JButton();
        JButton btnDelete = new JButton();
        textfbusno = new javax.swing.JTextField();
        textfid = new javax.swing.JTextField();
        textfcapacity = new javax.swing.JTextField();
        textfplateno = new javax.swing.JTextField();
        jLabelbusno = new javax.swing.JLabel();
        JLabel jLabelid = new JLabel();
        JLabel jLabelcapacity = new JLabel();
        JLabel jLabelplateno = new JLabel();
        //btnAttendance = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        dp = new javax.swing.JDesktopPane();
        panelStatus = new javax.swing.JPanel();

        

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Admin Page | Ride With Us");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(1900,990));
        setResizable(true);
        getContentPane().setLayout(null);

       

        textfbusno.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //textField1ActionPerformed(evt);
            }
        });
        getContentPane().add(textfbusno);
        textfbusno.setBounds(450, 290, 180, 30);

        textfid.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //textField2ActionPerformed(evt);
            }
        });
        getContentPane().add(textfid);
        textfid.setBounds(450, 380, 180, 30);

        textfcapacity.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //textField3ActionPerformed(evt);
            }
        });
        getContentPane().add(textfcapacity);
        textfcapacity.setBounds(450, 470, 180, 30);

        textfplateno.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //textField3ActionPerformed(evt);
            }
        });
        getContentPane().add(textfplateno);
        textfplateno.setBounds(450, 560, 180, 30);

        try{ 
            int rows=0;
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection con=DriverManager.getConnection(  
            "jdbc:mysql://localhost:3306/bus_system","root","*Laya2003*");  
            Statement stmt=con.createStatement();  
            ResultSet rs=stmt.executeQuery("SELECT COUNT(*) FROM bus");
            rs.next();
            rows = rs.getInt(1);
            String data[][] = new String[rows][];  

            ResultSet rs1=stmt.executeQuery("SELECT * FROM bus");
            // DefaultTableModel table = (DefaultTableModel) busdetails.getModel();
            
            int j=0;
            while(rs1.next()){
                String entry[]= new String[4];
                for(int i =0; i<4; i++){
                    entry[i] = rs1.getString(i+1);
                }
                data[j]=entry;
                j++;
            }  
            String column[]={"Bus No.","Driver ID","Capacity","Plate Number"};
            busdetails = new JTable(data,column);
            busdetails.addMouseListener(new MouseAdapter(){
                public void mouseClicked (MouseEvent evt){
                        JTable target = (JTable)evt.getSource();
                        int selectedrow = target.getSelectedRow();
                        textfbusno.setText(busdetails.getModel().getValueAt(selectedrow,0).toString());
                        textfid.setText(busdetails.getModel().getValueAt(selectedrow,1).toString());
                        textfcapacity.setText(busdetails.getModel().getValueAt(selectedrow,2).toString());
                        textfplateno.setText(busdetails.getModel().getValueAt(selectedrow,3).toString());
                }
            });
            
            
            JScrollPane sp=new JScrollPane(busdetails);
            sp.setBounds(1000,180,800,600);
            getContentPane().add(sp);
            setVisible(false);
            con.close();  
        }catch(Exception e){System.out.println(e);} 
        

        jLabelbusno.setFont(new java.awt.Font("SansSerif", 0, 14)); 
        jLabelbusno.setText("Bus Number:");
        jLabelbusno.setForeground(Color.white);
        getContentPane().add(jLabelbusno);
        jLabelbusno.setBounds(200, 290, 250, 20);

        jLabelid.setFont(new java.awt.Font("SansSerif", 0, 14)); 
        jLabelid.setText("Driver ID:");
        jLabelid.setForeground(Color.white);
        getContentPane().add(jLabelid);
        jLabelid.setBounds(200, 380, 250, 20);

        jLabelcapacity.setFont(new java.awt.Font("SansSerif", 0, 14)); 
        jLabelcapacity.setText("Capacity:");
        jLabelcapacity.setForeground(Color.white);
        getContentPane().add(jLabelcapacity);
        jLabelcapacity.setBounds(200, 470, 250, 20);

        jLabelplateno.setFont(new java.awt.Font("SansSerif", 0, 14)); 
        jLabelplateno.setText("Plateno:");
        jLabelplateno.setForeground(Color.white);
        getContentPane().add(jLabelplateno);
        jLabelplateno.setBounds(200, 560, 250, 20);


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

        //Add Button
        btnAdd.setBackground(new Color(112, 161, 180));
        btnAdd.setForeground(Color.WHITE);
        btnAdd.setUI(new StyledButtonUI());
        btnAdd.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                btnAdd.setBackground(new Color(92, 132, 147));
            }
            public void mouseExited(MouseEvent evt) {
                btnAdd.setBackground(new Color(112, 161, 180));
            }
        });
        btnAdd.setFont(new java.awt.Font("SansSerif", 0, 12)); 
        btnAdd.setText("Add");
        btnAdd.setForeground(Color.white);
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdd);
        btnAdd.setBounds(200, 650, 70, 32);

        //Edit button
        btnEdit.setBackground(new Color(112, 161, 180));
        btnEdit.setForeground(Color.WHITE);
        btnEdit.setUI(new StyledButtonUI());
        btnEdit.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                btnEdit.setBackground(new Color(92, 132, 147));
            }
            public void mouseExited(MouseEvent evt) {
                btnEdit.setBackground(new Color(112, 161, 180));
            }
        });
        btnEdit.setFont(new java.awt.Font("SansSerif", 0, 12)); 
        btnEdit.setText("Edit");
        btnEdit.setForeground(Color.white);
        btnEdit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        getContentPane().add(btnEdit);
        btnEdit.setBounds(380, 650, 70, 32);

        //Delete Button
        btnDelete.setBackground(new Color(112, 161, 180));
        btnDelete.setForeground(Color.WHITE);
        btnDelete.setUI(new StyledButtonUI());
        btnDelete.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                btnDelete.setBackground(new Color(92, 132, 147));
            }
            public void mouseExited(MouseEvent evt) {
                btnDelete.setBackground(new Color(112, 161, 180));
            }
        });
        btnDelete.setFont(new java.awt.Font("SansSerif", 0, 12)); 
        btnDelete.setText("Delete");
        btnDelete.setForeground(Color.white);
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btnDelete);
        btnDelete.setBounds(560, 650, 70, 32);

       

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
        AdminForm ss = new AdminForm();
        ss.setVisible(true);
        ss.pack();
        this.dispose();
        
    }
    private void btnAddActionPerformed(ActionEvent evt) {
        int busno = Integer.parseInt(textfbusno.getText());
        String id = textfid.getText();
        int capacity = Integer.parseInt(textfcapacity.getText());
        String plateno = textfplateno.getText();
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection con=DriverManager.getConnection(  
            "jdbc:mysql://localhost:3306/bus_system","root","*Laya2003*");  
             
            PreparedStatement insert = con.prepareStatement("INSERT INTO bus VALUES (?,?,?,?)");
            insert.setInt(1,busno);
            insert.setString(2,id);
            insert.setInt(3,capacity);
            insert.setString(4,plateno);
            insert.executeUpdate();
            JOptionPane.showMessageDialog(null,"Record Added!");
            con.close();  
        }catch(Exception e){System.out.println(e);}
        UpdateBus bs = new UpdateBus();
        bs.setVisible(true);
        bs.pack();
        this.dispose();
    }

    private void btnEditActionPerformed(ActionEvent evt) {
        int busno = Integer.parseInt(textfbusno.getText());
        String id = textfid.getText();
        int capacity = Integer.parseInt(textfcapacity.getText());
        String plateno = textfplateno.getText();
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection con=DriverManager.getConnection(  
            "jdbc:mysql://localhost:3306/bus_system","root","*Laya2003*");  
             
            PreparedStatement insert = con.prepareStatement("UPDATE bus set id=?, capacity=?, plate_no=? WHERE BusNo=?");
            insert.setInt(4,busno);
            insert.setString(1,id);
            insert.setInt(2,capacity);
            insert.setString(3,plateno);
            insert.executeUpdate();
            JOptionPane.showMessageDialog(null,"Record Updated!");
            con.close();  
        }catch(Exception e){System.out.println(e);}
        UpdateBus bs = new UpdateBus();
        bs.setVisible(true);
        bs.pack();
        this.dispose();
    }

    private void btnDeleteActionPerformed(ActionEvent evt) {
        int busno = Integer.parseInt(textfbusno.getText());
   
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection con=DriverManager.getConnection(  
            "jdbc:mysql://localhost:3306/bus_system","root","*Laya2003*");  
             
            PreparedStatement delete = con.prepareStatement("DELETE FROM bus WHERE BusNo=?");
            delete.setInt(1,busno);
            delete.executeUpdate();
            JOptionPane.showMessageDialog(null,"Record Deleted!");
            con.close();  
        }catch(Exception e){System.out.println(e);}
        UpdateBus bs = new UpdateBus();
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
            java.util.logging.Logger.getLogger(UpdateBus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateBus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateBus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateBus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateBus().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    //private javax.swing.JLabel lblNow;
    //private javax.swing.JButton btnAttendance;
    private javax.swing.JButton btnBack;
    private javax.swing.JTable busdetails;
    private javax.swing.JLabel jLabelbusno;
    private javax.swing.JTextField textfbusno;
    private javax.swing.JTextField textfid;
    private javax.swing.JTextField textfcapacity;
    private javax.swing.JTextField textfplateno;
    private javax.swing.JDesktopPane dp;
    private javax.swing.JPanel panelStatus;
    // End of variables declaration//GEN-END:variables
}
