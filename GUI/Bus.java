package GUI;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import javax.swing.JButton;
import Classes.*;

public class Bus extends javax.swing.JFrame {
        
     public static SystemManager manager ;
    
     public Bus() {
        initComponents();
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
   
    
    private void initComponents() {
        JButton btnEdit = new JButton();
        textfbusno = new javax.swing.JTextField();
        jLabelbusno = new javax.swing.JLabel();
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
        textfbusno.setText("1");
        

        jLabelbusno.setFont(new java.awt.Font("SansSerif", 0, 14)); 
        jLabelbusno.setText("Bus Number:");
        jLabelbusno.setForeground(Color.white);
        getContentPane().add(jLabelbusno);
        jLabelbusno.setBounds(200, 290, 250, 20);


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
        btnEdit.setText("Search");
        btnEdit.setForeground(Color.white);
        btnEdit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        getContentPane().add(btnEdit);
        btnEdit.setBounds(380, 450, 70, 32);

       

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
        int busno = Integer.parseInt(textfbusno.getText());
        check bs = new check(busno);
        bs.setVisible(true);
        bs.pack();
        this.dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JLabel jLabelbusno;
    private javax.swing.JTextField textfbusno;
    private javax.swing.JDesktopPane dp;
    private javax.swing.JPanel panelStatus;
    // End of variables declaration//GEN-END:variables
}

