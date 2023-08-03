package GUI;
import java.awt.Color;


public class FirstPage extends javax.swing.JFrame {

    
    public FirstPage() {
        initComponents();
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    private void initComponents() {

        btnProf = new javax.swing.JButton();
        btnStudent = new javax.swing.JButton();
        btnDriver = new javax.swing.JButton();
        btnAdmin = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("User | Ride With Us");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(700, 570));
        setResizable(false);
        getContentPane().setLayout(null);

        
        jLabel1.setFont(new java.awt.Font("Freestyle Script", 0, 48)); // NOI18N
        jLabel1.setText("Ride With Us");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(200, 20, 300, 50);

        //Professor Button
        btnProf.setBackground(new Color(37, 150, 190));
        btnProf.setForeground(Color.WHITE);
        btnProf.setUI(new StyledButtonUI());
        btnProf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnProf.setBackground(new Color(27, 119, 152));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnProf.setBackground(new Color(37, 150, 190));
            }
        });
        btnProf.setFont(new java.awt.Font("SansSerif", 0, 12)); 
        btnProf.setText("Professor");
        btnProf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfActionPerformed(evt);
            }
        });
        getContentPane().add(btnProf);
        btnProf.setBounds(100, 100, 90, 32);


        //Student Button
        btnStudent.setBackground(new Color(37, 150, 190));
        btnStudent.setForeground(Color.WHITE);
        btnStudent.setUI(new StyledButtonUI());
        btnStudent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnStudent.setBackground(new Color(27, 119, 152));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnStudent.setBackground(new Color(37, 150, 190));
            }
        });
        btnStudent.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnStudent.setText("Student");
        btnStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStudentActionPerformed(evt);
            }
        });
        getContentPane().add(btnStudent);
        btnStudent.setBounds(220, 100, 90, 32);

        //Driver Button
        btnDriver.setBackground(new Color(37, 150, 190));
        btnDriver.setForeground(Color.WHITE);
        btnDriver.setUI(new StyledButtonUI());
        btnDriver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDriver.setBackground(new Color(27, 119, 152));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDriver.setBackground(new Color(37, 150, 190));
            }
        });
        btnDriver.setFont(new java.awt.Font("SansSerif", 0, 12)); 
        btnDriver.setText("Driver");
        btnDriver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDriverActionPerformed(evt);
            }
        });
        getContentPane().add(btnDriver);
        btnDriver.setBounds(340, 100, 90, 32);

        //Admin Button
        btnAdmin.setBackground(new Color(37, 150, 190));
        btnAdmin.setForeground(Color.WHITE);
        btnAdmin.setUI(new StyledButtonUI());
        btnAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAdmin.setBackground(new Color(27, 119, 152));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAdmin.setBackground(new Color(37, 150, 190));
            }
        });
        btnAdmin.setFont(new java.awt.Font("SansSerif", 0, 12));
        btnAdmin.setText("Admin");
        btnAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdmin);
        btnAdmin.setBounds(460, 100, 90, 32);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/bus.gif"))); 
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 800, 650);


        pack();
    }

    private void btnProfActionPerformed(java.awt.event.ActionEvent evt) {
        ProfessorLogin pLogin = new ProfessorLogin();
        pLogin.pack();
        pLogin.setVisible(true);
        this.dispose();
                     
	}

    private void btnStudentActionPerformed(java.awt.event.ActionEvent evt) {
        StudentLogin sLogin = new StudentLogin();
        sLogin.pack();
        sLogin.setVisible(true);
        this.dispose();
                     
	}

    private void btnDriverActionPerformed(java.awt.event.ActionEvent evt) {
        DriverLogin dLogin = new DriverLogin();
        dLogin.pack();
        dLogin.setVisible(true);
        this.dispose();
                     
	}

    private void btnAdminActionPerformed(java.awt.event.ActionEvent evt) {
        AdminLogin aLogin = new AdminLogin();
        aLogin.pack();
        aLogin.setVisible(true);
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
            java.util.logging.Logger.getLogger(FirstPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FirstPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FirstPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FirstPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FirstPage().setVisible(true);
            }
        });
    }

    // Variables declaration 
    private javax.swing.JButton btnProf;
    private javax.swing.JButton btnStudent;
    private javax.swing.JButton btnDriver;
    private javax.swing.JButton btnAdmin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration
}

