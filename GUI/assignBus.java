package GUI;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.sql.*;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;


import Classes.*;

public class assignBus extends javax.swing.JFrame {
        
    // Creates new form DriverNew
   
     public static SystemManager manager ;
    
     public assignBus() {
        initComponents();
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
   
    
    private void initComponents() {

        JButton btnEdit = new JButton();
        textfid = new javax.swing.JTextField();
        textfdate = new javax.swing.JTextField();
        textfbusno = new javax.swing.JTextField();
        textfsem = new javax.swing.JTextField();
        textfend = new javax.swing.JTextField();
        idlabel = new javax.swing.JLabel();
        datelabel = new javax.swing.JLabel();
        busnolabel = new javax.swing.JLabel();
        semlabel = new javax.swing.JLabel();
        endlabel = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        dp = new javax.swing.JDesktopPane();
        panelStatus = new javax.swing.JPanel();

        

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Admin Page | Ride With Us");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(1900,990));
        setResizable(true);
        getContentPane().setLayout(null);

       

        textfid.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //textField1ActionPerformed(evt);
            }
        });
        getContentPane().add(textfid);
        textfid.setBounds(450, 200, 180, 30);
        textfid.setEditable(false);

        textfdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //textField1ActionPerformed(evt);
            }
        });
        getContentPane().add(textfdate);
        textfdate.setBounds(450, 290, 180, 30);
        textfdate.setEditable(false);


        textfbusno.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //textField1ActionPerformed(evt);
            }
        });
        getContentPane().add(textfbusno);
        textfbusno.setBounds(450, 380, 180, 30);

        textfsem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //textField1ActionPerformed(evt);
            }
        });
        getContentPane().add(textfsem);
        textfsem.setBounds(450, 470, 180, 30);
        textfsem.setEditable(false);


        textfend.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //textField1ActionPerformed(evt);
            }
        });
        getContentPane().add(textfend);
        textfend.setBounds(450, 560, 180, 30);
        textfend.setEditable(false);



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

            ResultSet rs1=stmt.executeQuery("SELECT * FROM Reserved");
            // DefaultTableModel table = (DefaultTableModel) driverdetails.getModel();
            
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
            driverdetails = new JTable(data,column);

            driverdetails.addMouseListener(new MouseAdapter(){
                public void mouseClicked (MouseEvent evt){
                        JTable target = (JTable)evt.getSource();
                        int selectedrow = target.getSelectedRow();
                        textfid.setText(driverdetails.getModel().getValueAt(selectedrow,0).toString());
                        textfdate.setText(driverdetails.getModel().getValueAt(selectedrow,1).toString());
                        textfsem.setText(driverdetails.getModel().getValueAt(selectedrow,3).toString());
                        textfend.setText(driverdetails.getModel().getValueAt(selectedrow,4).toString());
                }
            });
            JScrollPane sp=new JScrollPane(driverdetails);
            sp.setBounds(800,180,1000,600);
            getContentPane().add(sp);
            setVisible(false);
            con.close();  
        }catch(Exception e){System.out.println(e);} 
        

        idlabel.setFont(new java.awt.Font("SansSerif", 0, 14)); 
        idlabel.setText("ID:");
        idlabel.setForeground(Color.white);
        getContentPane().add(idlabel);
        idlabel.setBounds(200, 200, 250, 20);

        datelabel.setFont(new java.awt.Font("SansSerif", 0, 14)); 
        datelabel.setText("Date:");
        datelabel.setForeground(Color.white);
        getContentPane().add(datelabel);
        datelabel.setBounds(200, 290, 250, 20);


        busnolabel.setFont(new java.awt.Font("SansSerif", 0, 14)); 
        busnolabel.setText("Bus Number:");
        busnolabel.setForeground(Color.white);
        getContentPane().add(busnolabel);
        busnolabel.setBounds(200, 380, 250, 20);


        semlabel.setFont(new java.awt.Font("SansSerif", 0, 14)); 
        semlabel.setText("Number of Semesters:");
        semlabel.setForeground(Color.white);
        getContentPane().add(semlabel);
        semlabel.setBounds(200, 470, 250, 20);

        endlabel.setFont(new java.awt.Font("SansSerif", 0, 14)); 
        endlabel.setText("End Date:");
        endlabel.setForeground(Color.white);
        getContentPane().add(endlabel);
        endlabel.setBounds(200, 560, 250, 20);

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
        btnEdit.setText("Set Bus");
        btnEdit.setForeground(Color.white);
        btnEdit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        getContentPane().add(btnEdit);
        btnEdit.setBounds(380, 670, 120, 32);

        

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


    private void btnEditActionPerformed(ActionEvent evt) {
        String id = textfid.getText();
        int busno = Integer.parseInt(textfbusno.getText());
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection con=DriverManager.getConnection(  
            "jdbc:mysql://localhost:3306/bus_system","root","*Laya2003*");  
             
            PreparedStatement insert = con.prepareStatement("UPDATE Reserved SET BusNo = ? WHERE ID = ?");
            insert.setInt(1,busno);
            insert.setString(2,id);
            insert.executeUpdate();
            JOptionPane.showMessageDialog(null,"Bus Number Set!");
            con.close();  
        }catch(Exception e){System.out.println(e);}
        assignBus bs = new assignBus();
        bs.setVisible(true);
        bs.pack();
        this.dispose();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JTable driverdetails;
    private javax.swing.JLabel idlabel;
    private javax.swing.JLabel datelabel;
    private javax.swing.JLabel busnolabel;
    private javax.swing.JLabel semlabel;
    private javax.swing.JLabel endlabel;
    private javax.swing.JTextField textfbusno;
    private javax.swing.JTextField textfdate;
    private javax.swing.JTextField textfend;
    private javax.swing.JTextField textfsem;
    private javax.swing.JTextField textfid;
    private javax.swing.JDesktopPane dp;
    private javax.swing.JPanel panelStatus;
    // End of variables declaration//GEN-END:variables
}

