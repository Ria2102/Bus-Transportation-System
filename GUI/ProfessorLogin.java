package GUI;
import java.util.Scanner;
import java.awt.Color;
import java.io.*;
import javax.swing.JOptionPane;

public class ProfessorLogin extends javax.swing.JFrame {

    /**
     * Creates new form ProfessorLogin
     */
    String username = "";
    String passWord = "";
    Professor p = new Professor();
    
    public ProfessorLogin() {
        initComponents();
        
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        usernameText = new javax.swing.JTextField();
        passwordText = new javax.swing.JPasswordField();
        btnCancel = new javax.swing.JButton();
        btnLogin = new javax.swing.JButton();
        btnNewUser = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Professor Login | Ride With Us");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(707, 569));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 14)); 
        jLabel1.setText("Username");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(170, 150, 64, 20);

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 14)); 
        jLabel2.setText("Password");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(170, 180, 61, 19);

        usernameText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameTextActionPerformed(evt);
            }
        });
        getContentPane().add(usernameText);
        usernameText.setBounds(280, 145, 123, 30);
        passwordText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordTextActionPerformed(evt);
            }
        });
        getContentPane().add(passwordText);
        passwordText.setBounds(280, 180, 123, 30);

        //Cancel Button
        btnCancel.setBackground(new Color(37, 150, 190));
        btnCancel.setForeground(Color.WHITE);
        btnCancel.setUI(new StyledButtonUI());
        btnCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCancel.setBackground(new Color(27, 119, 152));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCancel.setBackground(new Color(37, 150, 190));
            }
        });
        btnCancel.setFont(new java.awt.Font("SansSerif", 0, 12)); 
        btnCancel.setText("Back");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancel);
        btnCancel.setBounds(430, 180, 90, 32);

        jLabel3.setFont(new java.awt.Font("Freestyle Script", 0, 48)); 
        //jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Ride With Us");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(250, 20, 200, 50);

        //Login Button
        btnLogin.setBackground(new Color(37, 150, 190));
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setUI(new StyledButtonUI());
        btnLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLogin.setBackground(new Color(27, 119, 152));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLogin.setBackground(new Color(37, 150, 190));
            }
        });
        btnLogin.setFont(new java.awt.Font("SansSerif", 0, 12)); 
        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogin);
        btnLogin.setBounds(430, 145, 90, 32);

        //New User Button
        btnNewUser.setBackground(new Color(37, 150, 190));
        btnNewUser.setForeground(Color.WHITE);
        btnNewUser.setUI(new StyledButtonUI());
        btnNewUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnNewUser.setBackground(new Color(27, 119, 152));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnNewUser.setBackground(new Color(37, 150, 190));
            }
        });
        btnNewUser.setFont(new java.awt.Font("SansSerif", 0, 12)); 
        btnNewUser.setText("New User");
        btnNewUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewUserActionPerformed(evt);
            }
        });
        getContentPane().add(btnNewUser);
        btnNewUser.setBounds(270, 240, 150, 32);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/bus.gif"))); 
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 700, 650);

        pack();
    }

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {
        FirstPage fp = new FirstPage();
        fp.setVisible(true);
        fp.pack();
        this.dispose();  
    }

    private void btnNewUserActionPerformed(java.awt.event.ActionEvent evt) {
        ProfessorNew pn = new ProfessorNew();
        pn.setVisible(true);
        pn.pack();
        this.dispose();
    }

    private void passwordTextActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void usernameTextActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {
      String usernamei = usernameText.getText();
      char[] passWordi = passwordText.getPassword();
      String pi = new String(passWordi);
      
      String[] loginDetails = new String[2];
	  String userNamef = "";
	  String passwordf = "";
   
	
	try(Scanner read = new Scanner(new FileInputStream("PloginDetails.txt"))){
	
		boolean end = true;

		
		while(read.hasNextLine()&& end){

			loginDetails = read.nextLine().split(",");
            userNamef=loginDetails[0];
			passwordf = loginDetails[1];
            

                        
                        if(userNamef.compareTo(usernamei)==0 && passwordf.compareTo(pi)==0){
                            p.setProfessor(userNamef);
                            ProfessorForm lf = new ProfessorForm();
                            lf.setVisible(true);
                            lf.pack();
                            this.dispose();
                            end = false;
                        }
		}
        if(end){
            JOptionPane.showMessageDialog(null, "Invalid Credentials");
        }
	}
	catch(FileNotFoundException ex){
		 JOptionPane.showMessageDialog(null,"File Not Found");
	}
	catch(Exception ex){
		 JOptionPane.showMessageDialog(null,ex.getMessage());
	}
        
        
      
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
            java.util.logging.Logger.getLogger(ProfessorLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProfessorLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProfessorLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProfessorLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProfessorLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnNewUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField passwordText;
    private javax.swing.JTextField usernameText;
    // End of variables declaration//GEN-END:variables
}
