package GUI;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.sql.*;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import Classes.*;
class get extends DriverLogin{
    public String getId(){
        return d.getDID();
    }
}

public class AbsentList extends javax.swing.JFrame {
        
    // Creates new form DriverNew
    JTextField textDate = new JTextField();
    get n= new get();
    String date = textDate.getText();
    DateStore ds = new DateStore();

     public static SystemManager manager ;
    
     public AbsentList() {
        initComponents();
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
   
    
    private void initComponents() {

        JButton btnFilter = new JButton();
        datelabel = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        dp = new javax.swing.JDesktopPane();
        panelStatus = new javax.swing.JPanel();
        

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Driver Page | Ride With Us");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(1900,990));
        setResizable(true);
        getContentPane().setLayout(null);

       

        textDate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //textField1ActionPerformed(evt);
            }
        });

        getContentPane().add(textDate);
        textDate.setBounds(450, 290, 180, 30);


        try{ 
            int rows=0;
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection con=DriverManager.getConnection(  
            "jdbc:mysql://localhost:3306/bus_system","root","*Laya2003*");  
            

            PreparedStatement countrow = con.prepareStatement("SELECT count(*) FROM Absent WHERE ID in (SELECT r.ID FROM Reserved r,bus b WHERE r.busno=b.busno AND b.id ='"+n.getId()+"')");
            ResultSet rs1=countrow.executeQuery();
            rs1.next();
            rows = rs1.getInt(1);
            String data[][] = new String[rows][];  

            PreparedStatement details = con.prepareStatement("SELECT Date,ID,Name,Street,Bldg FROM Absent WHERE ID in (SELECT r.ID FROM Reserved r,bus b WHERE r.busno=b.busno AND b.id ='"+n.getId()+"')");
            ResultSet rs2=details.executeQuery();

            int j=0;
            while(rs2.next()){
                String entry[]= new String[5];
                for(int i =0; i<5; i++){
                    entry[i] = rs2.getString(i+1);
                }
                data[j]=entry;
                j++;
            }  
            String column[]={"Date","ID","Name","Street","Building"};
            studentdetails = new JTable(data,column);
            JScrollPane sp=new JScrollPane(studentdetails);
            sp.setBounds(800,180,1000,600);
            getContentPane().add(sp);
            setVisible(true);
            con.close();  
        }catch(Exception e){System.out.println(e+"Its me again!");} 
        

        datelabel.setFont(new java.awt.Font("SansSerif", 0, 14)); 
        datelabel.setText("Date:");
        datelabel.setForeground(Color.white);
        getContentPane().add(datelabel);
        datelabel.setBounds(300, 290, 250, 20);

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

        //Edit Button
        btnFilter.setBackground(new Color(112, 161, 180));
        btnFilter.setForeground(Color.WHITE);
        btnFilter.setUI(new StyledButtonUI());
        btnFilter.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                btnFilter.setBackground(new Color(92, 132, 147));
            }
            public void mouseExited(MouseEvent evt) {
                btnFilter.setBackground(new Color(112, 161, 180));
            }
        });
        btnFilter.setFont(new java.awt.Font("SansSerif", 0, 12)); 
        btnFilter.setText("Filter By Date");
        btnFilter.setForeground(Color.white);
        btnFilter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnFilterActionPerformed(evt);
            }
        });
        getContentPane().add(btnFilter);
        btnFilter.setBounds(380, 400, 120, 32);


       

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
        DriverForm ss = new DriverForm();
        ss.setVisible(true);
        ss.pack();
        this.dispose();
        
    }
    

    private void btnFilterActionPerformed(ActionEvent evt) {
        ds.setdate(textDate.getText());
        Filter ss = new Filter();
        ss.setVisible(true);
        ss.pack();
        this.dispose();
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JTable studentdetails;
    private javax.swing.JLabel datelabel;
    private javax.swing.JDesktopPane dp;
    private javax.swing.JPanel panelStatus;
    // End of variables declaration//GEN-END:variables
}
