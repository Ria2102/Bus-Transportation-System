package GUI;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

class id extends StudentLogin{
    public String getId(){
        return s.getID();
    }
}
public class Payment extends javax.swing.JFrame {
        

     JFrame f;
     public Payment() {
        initComponents();
        
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
     
    
    private void initComponents() {
        textFAmount = new javax.swing.JTextField();
        jLabelAmount = new javax.swing.JLabel();
        btnBack = new JButton();
        btnPay = new JButton();
        dp = new JDesktopPane();
        panelStatus = new JPanel();
        obj = new id();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Student Page | Ride With Us");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(1900,990));
        setResizable(true);
        getContentPane().setLayout(null);
        //sql
        
        try{ 
            int rows; 
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection con=DriverManager.getConnection(  
            "jdbc:mysql://localhost:3306/bus_system","root","*Laya2003*");  
            Statement stmt=con.createStatement();  
            ResultSet rs=stmt.executeQuery("SELECT COUNT(*) FROM Payment_history WHERE ID ='"+obj.getId()+"'");
            rs.next();
            rows = rs.getInt(1);
            String data[][] = new String[rows][];  

            ResultSet rs1=stmt.executeQuery("SELECT Date,Amount FROM Payment_history WHERE ID ='"+obj.getId()+"'");
            int j=0;
            while(rs1.next()){
                String entry[]= new String[2];
                for(int i =0; i<2; i++){
                    entry[i] = rs1.getString(i+1);
                }
                data[j]=entry;
                j++;
            }  
            String column[]={"Date","Amount"};
            JTable studentDetails = new JTable(data,column);
            JScrollPane sp=new JScrollPane(studentDetails);
            sp.setBounds(1000,180,800,600);
            getContentPane().add(sp);
            setVisible(true);
            con.close();  
        }catch(Exception e){System.out.println(e);}  

        textFAmount.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //textField2ActionPerformed(evt);
            }
        });
        getContentPane().add(textFAmount);
        textFAmount.setBounds(450, 380, 180, 30);

        
       
     
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
        
        jLabelAmount.setFont(new java.awt.Font("SansSerif", 0, 14)); 
        jLabelAmount.setText("Amount Paid:");
        jLabelAmount.setForeground(Color.white);
        getContentPane().add(jLabelAmount);
        jLabelAmount.setBounds(200, 380, 250, 20);

        btnPay.setBackground(new Color(112, 161, 180));
        btnPay.setForeground(Color.WHITE);
        btnPay.setUI(new StyledButtonUI());
        btnPay.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                btnPay.setBackground(new Color(92, 132, 147));
            }
            public void mouseExited(MouseEvent evt) {
                btnPay.setBackground(new Color(112, 161, 180));
            }
        });
        btnPay.setFont(new java.awt.Font("SansSerif", 0, 12)); 
        btnPay.setText("Record");
        btnPay.setForeground(Color.white);
        btnPay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnPayActionPerformed(evt);
            }
        });
        getContentPane().add(btnPay);
        btnPay.setBounds(200, 650, 100, 32);



        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(panelStatus, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(dp)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(dp)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelStatus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pack();
        
    }
    private void btnBackActionPerformed(ActionEvent evt) {
        StudentForm lf = new StudentForm();
        lf.setVisible(true);
        lf.pack();
        this.dispose();
    }

    private void btnPayActionPerformed(ActionEvent evt) {
        int Amount = Integer.parseInt(textFAmount.getText());
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection con=DriverManager.getConnection(  
            "jdbc:mysql://localhost:3306/bus_system","root","*Laya2003*");  
             
            PreparedStatement insert = con.prepareStatement("INSERT INTO Payment_history VALUES ('"+obj.getId()+"',curDate(),"+Amount+")");
            insert.executeUpdate();
            JOptionPane.showMessageDialog(null,"Record Added!");
            con.close();  
        }catch(Exception e){System.out.println(e);}
        Payment bs = new Payment();
        bs.setVisible(true);
        bs.pack();
        this.dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane dp;
    private javax.swing.JPanel panelStatus;
    private javax.swing.JButton btnPay;
    private javax.swing.JButton btnBack;
    private javax.swing.JTextField textFAmount;
    private javax.swing.JLabel jLabelAmount;
    private id obj;
    // End of variables declaration//GEN-END:variables
}