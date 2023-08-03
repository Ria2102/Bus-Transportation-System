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

class did extends DriverLogin{
    public String getId(){
        return d.getDID();
    }
}
public class DBusRoute extends javax.swing.JFrame {
        

     JFrame f;
     public DBusRoute() {
        initComponents();
        
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
     
    
    private void initComponents() {
        d = new did();
        btnBack = new JButton();
        dp = new JDesktopPane();
        panelStatus = new JPanel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Driver Page | Ride With Us");
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
            ResultSet rs=stmt.executeQuery("SELECT COUNT(*) FROM Reserved r, Passenger p, Route rt, bus b WHERE rt.busno=b.busno and b.ID='"+d.getId()+"' and r.ID=p.ID and p.street=rt.location and r.enddate>=curdate()");
            rs.next();
            rows = rs.getInt(1);
            String data[][] = new String[rows][];  
            //SELECT rt.busno,rt.city,rt.location FROM Reserved r, Passenger p, Route rt, bus b WHERE rt.busno=b.busno and b.ID='2021001D' and r.ID=p.ID and p.street=rt.location and r.enddate>=curdate();
            ResultSet rs1=stmt.executeQuery("SELECT rt.busno,rt.city,rt.location FROM Reserved r, Passenger p, Route rt, bus b WHERE rt.busno=b.busno and b.ID='"+d.getId()+"' and r.ID=p.ID and p.street=rt.location and r.enddate>=curdate()");
            int j=0;
            while(rs1.next()){
                String entry[]= new String[3];
                for(int i =0; i<3; i++){
                    entry[i] = rs1.getString(i+1);
                }
                data[j]=entry;
                j++;
            }  
            String column[]={"Bus Number","City","Location"};
            JTable studentDetails = new JTable(data,column);
            JScrollPane sp=new JScrollPane(studentDetails);
            sp.setBounds(180,180,1500,500);
            getContentPane().add(sp);
            setVisible(true);
            con.close();  
        }catch(Exception e){System.out.println(e);}  

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
        DriverForm lf = new DriverForm();
        lf.setVisible(true);
        lf.pack();
        this.dispose();
   
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane dp;
    private javax.swing.JPanel panelStatus;
    private javax.swing.JButton btnBack;
    private did d;
    // End of variables declaration//GEN-END:variables
}
