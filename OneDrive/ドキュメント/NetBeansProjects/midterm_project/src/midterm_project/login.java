package midterm_project;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class login extends javax.swing.JFrame {

    public login() {
        initComponents();
        setLocationRelativeTo(null);
    }

    private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {
        
        Connection conn = connection_IT26b_Mid.getConnection();
        
        String username = txt_username.getText();
        String password = txt_password.getText();
        
        try {
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "Login Successful!");
                // open dashboard
                // it26b_midterm dashboard = new it26b_midterm();
                // dashboard.setVisible(true);
                // this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password!");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }
}