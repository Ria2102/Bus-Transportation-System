package GUI;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.sql.*;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import Classes.*;
class getBusNo extends DriverLogin{
    public String getID(){
        return d.getDID();
    }
    public int busno(){
        return d.getbusno();
    }
}
class getdate extends AbsentList{
    public String date(){
        return ds.getDate();
    }
}

public class Filter extends javax.swing.JFrame {
    // Creates new form DriverNew
    getdate d = new getdate();
    getBusNo n = new getBusNo();
     public static SystemManager manager ;
    
     public Filter() {
        initComponents();
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
   
    
    private void initComponents() {

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
            int rows = 0;
        
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection con=DriverManager.getConnection(  
            "jdbc:mysql://localhost:3306/bus_system","root","*Laya2003*");  
            
            PreparedStatement countrow = con.prepareStatement("SELECT COUNT(*) FROM absent WHERE Date=? AND ID in (SELECT ID FROM Reserved WHERE BusNo=?)");
            countrow.setString(1,d.date());
            countrow.setInt(2,n.busno());

            ResultSet rs0=countrow.executeQuery();
            rs0.next();
            rows = rs0.getInt(1);
            String data[][] = new String[rows][];  
            PreparedStatement select = con.prepareStatement("SELECT Date,ID,Name,Street,Bldg FROM Absent WHERE Date=? AND ID in (SELECT ID FROM Reserved WHERE BusNo =?)");
            select.setString(1,d.date());
            select.setInt(2,n.busno());
            select.executeQuery();
            ResultSet rs=select.executeQuery();
        
            int j=0;
            while(rs.next()){
                String entry[]= new String[5];
                for(int i =0; i<5; i++){
                    entry[i] = rs.getString(i+1);
                }
                data[j]=entry;
                j++;
            }  
            String column[]={"Date","ID","Name","Street","Building"};
            studentdetails = new JTable(data,column);
            JScrollPane sp=new JScrollPane(studentdetails);
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
        AbsentList ss = new AbsentList();
        ss.setVisible(true);
        ss.pack();
        this.dispose();
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JTable studentdetails;
    private javax.swing.JDesktopPane dp;
    private javax.swing.JPanel panelStatus;
    // End of variables declaration//GEN-END:variables
}

