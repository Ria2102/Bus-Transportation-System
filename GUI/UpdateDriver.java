package GUI;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.awt.event.*;
import java.sql.*;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;


import Classes.*;

public class UpdateDriver extends javax.swing.JFrame {
        
    // Creates new form DriverNew
   
     public static SystemManager manager ;
    
     public UpdateDriver() {
        initComponents();
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
   
    
    private void initComponents() {

        JButton btnEdit = new JButton();
        JButton btnAdd = new JButton();
        JButton btnDelete = new JButton();
        textfpswd = new javax.swing.JTextField();
        textfname = new javax.swing.JTextField();
        textfcontact = new javax.swing.JTextField();
        textfid = new javax.swing.JTextField();
        idlabel = new javax.swing.JLabel();
        namelabel = new javax.swing.JLabel();
        contactlabel = new javax.swing.JLabel();
        pswdlabel = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        dp = new javax.swing.JDesktopPane();
        panelStatus = new javax.swing.JPanel();

        

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Admin Page | Ride With Us");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(1900,990));
        setResizable(true);
        getContentPane().setLayout(null);

        textfpswd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //textField1ActionPerformed(evt);
            }
        });

        getContentPane().add(textfpswd);
        textfpswd.setBounds(450, 200, 180, 30);
       

        textfid.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //textField1ActionPerformed(evt);
            }
        });

        getContentPane().add(textfid);
        textfid.setBounds(450, 290, 180, 30);

        textfname.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //textField1ActionPerformed(evt);
            }
        });

        getContentPane().add(textfname);
        textfname.setBounds(450, 380, 180, 30);

        textfcontact.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //textField1ActionPerformed(evt);
            }
        });

        getContentPane().add(textfcontact);
        textfcontact.setBounds(450, 470, 180, 30);


        try{ 
            int rows=0;
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection con=DriverManager.getConnection(  
            "jdbc:mysql://localhost:3306/bus_system","root","*Laya2003*");  
            Statement stmt=con.createStatement();  
            ResultSet rs=stmt.executeQuery("SELECT COUNT(*) FROM Driver");
            rs.next();
            rows = rs.getInt(1);
            String data[][] = new String[rows][];  

            ResultSet rs1=stmt.executeQuery("SELECT * FROM Driver");
            // DefaultTableModel table = (DefaultTableModel) driverdetails.getModel();
            
            int j=0;
            while(rs1.next()){
                String entry[]= new String[3];
                for(int i =0; i<3; i++){
                    entry[i] = rs1.getString(i+1);
                }
                data[j]=entry;
                j++;
            }  
            String column[]={"Driver_ID","Driver_Name","Contact No."};
            driverdetails = new JTable(data,column);

            driverdetails.addMouseListener(new MouseAdapter(){
                public void mouseClicked (MouseEvent evt){
                        JTable target = (JTable)evt.getSource();
                        int selectedrow = target.getSelectedRow();
                        textfid.setText(driverdetails.getModel().getValueAt(selectedrow,0).toString());
                        textfname.setText(driverdetails.getModel().getValueAt(selectedrow,1).toString());
                        textfcontact.setText(driverdetails.getModel().getValueAt(selectedrow,2).toString());
                }
            });
            JScrollPane sp=new JScrollPane(driverdetails);
            sp.setBounds(800,180,1000,600);
            getContentPane().add(sp);
            setVisible(false);
            con.close();  
        }catch(Exception e){System.out.println(e);} 
        
        pswdlabel.setFont(new java.awt.Font("SansSerif", 0, 14)); 
        pswdlabel.setText("Login Password:");
        pswdlabel.setForeground(Color.white);
        getContentPane().add(pswdlabel);
        pswdlabel.setBounds(200, 200, 250, 20);

        idlabel.setFont(new java.awt.Font("SansSerif", 0, 14)); 
        idlabel.setText("Driver ID:");
        idlabel.setForeground(Color.white);
        getContentPane().add(idlabel);
        idlabel.setBounds(200, 290, 250, 20);

        namelabel.setFont(new java.awt.Font("SansSerif", 0, 14)); 
        namelabel.setText("Driver Name:");
        namelabel.setForeground(Color.white);
        getContentPane().add(namelabel);
        namelabel.setBounds(200, 380, 250, 20);

        
        contactlabel.setFont(new java.awt.Font("SansSerif", 0, 14)); 
        contactlabel.setText("Phone Number:");
        contactlabel.setForeground(Color.white);
        getContentPane().add(contactlabel);
        contactlabel.setBounds(200, 470, 250, 20);
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
        btnAdd.setBounds(200, 540, 70, 32);

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
        btnEdit.setBounds(380, 540, 70, 32);

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
        btnDelete.setBounds(560, 540, 70, 32);

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
        String driverID = textfid.getText();
        String dname = textfname.getText();
        String passWord = textfpswd.getText();
        int contactno = Integer.parseInt(textfcontact.getText());
        try(PrintWriter bw = new PrintWriter(new BufferedWriter(new FileWriter("DloginDetails.txt",true)))){
            bw.write(driverID+","+passWord+"\n");
            
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
             
            PreparedStatement insert = con.prepareStatement("INSERT INTO Driver VALUES (?,?,?)");
            insert.setString(1,driverID);
            insert.setString(2,dname);
            insert.setInt(3,contactno);
            insert.executeUpdate();
            JOptionPane.showMessageDialog(null,"Record Added!");
            con.close();  
        }catch(Exception e){System.out.println(e);}
        UpdateDriver bs = new UpdateDriver();
        bs.setVisible(true);
        bs.pack();
        this.dispose();
    }
    
   
    

    private void btnEditActionPerformed(ActionEvent evt) {
        String driverID = textfid.getText();
        int contactno = Integer.parseInt(textfcontact.getText());
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection con=DriverManager.getConnection(  
            "jdbc:mysql://localhost:3306/bus_system","root","*Laya2003*");  
             
            PreparedStatement insert = con.prepareStatement("UPDATE Driver set Contact = ? WHERE D_ID = ?;");
            insert.setInt(1,contactno);
            insert.setString(2,driverID);
            insert.executeUpdate();
            JOptionPane.showMessageDialog(null,"Record Updated!");
            con.close();  
        }catch(Exception e){System.out.println(e);}
        UpdateDriver bs = new UpdateDriver();
        bs.setVisible(true);
        bs.pack();
        this.dispose();
    }

    private void btnDeleteActionPerformed(ActionEvent evt) {
        String driverID = textfid.getText();

        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection con=DriverManager.getConnection(  
            "jdbc:mysql://localhost:3306/bus_system","root","*Laya2003*");  
             
            PreparedStatement delete = con.prepareStatement("DELETE FROM Driver WHERE D_ID=?");
            delete.setString(1,driverID);
            delete.executeUpdate();
            JOptionPane.showMessageDialog(null,"Record Deleted!");
            con.close();  
        }catch(Exception e){System.out.println(e);}
        UpdateDriver bs = new UpdateDriver();
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
            java.util.logging.Logger.getLogger(UpdateDriver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateDriver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateDriver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateDriver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateDriver().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    //private javax.swing.JLabel lblNow;
    //private javax.swing.JButton btnAttendance;
    private javax.swing.JButton btnBack;
    private javax.swing.JTable driverdetails;
    private javax.swing.JLabel idlabel;
    private javax.swing.JLabel pswdlabel;
    private javax.swing.JLabel namelabel;
    private javax.swing.JLabel contactlabel;
    private javax.swing.JTextField textfpswd;
    private javax.swing.JTextField textfcontact;
    private javax.swing.JTextField textfname;
    private javax.swing.JTextField textfid;
    private javax.swing.JDesktopPane dp;
    private javax.swing.JPanel panelStatus;
    // End of variables declaration//GEN-END:variables
}

