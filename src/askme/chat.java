/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package askme;

import static askme.Friends.hostpass;
import static askme.Login.con;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author crazymouse
 */
public class chat extends javax.swing.JFrame {

    /**
     * Creates new form chat
     */
    static String messages="";
    public static Connection con;
    static public String hostuser = "root";
    static public String hostpass = "root";
    static public String add = "jdbc:mysql://localhost:3306/ask_fm";
    public chat() throws SQLException {
        initComponents();
        this.setLocationRelativeTo(null);
        txt_area.removeAll();
         messages="";
        try {
            con = DriverManager.getConnection(Login.add,Login.hostuser, hostpass);
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "feild to connect");
        }
        PreparedStatement stmt1=con.prepareStatement("select *from chat");
        ResultSet res1=stmt1.executeQuery();
            
            while(res1.next()){
                if(res1.getString(1).equals(Login.user_name)&&res1.getString(2).equals(insert_user.user_insert)){
                    if(res1.getString(3).length()!=0){
                    messages+=Login.user_name;
                    messages+=" :   ";
                    messages+=res1.getString(3);
                    messages+="\n";
                    }
                    if(res1.getString(4).length()!=0){
                    messages+=insert_user.user_insert;
                    messages+=" :   ";
                    messages+=res1.getString(4);
                    messages+="\n";
                    }
                }
                else if(res1.getString(2).equals(Login.user_name)&&res1.getString(1).equals(insert_user.user_insert)){
                    if(res1.getString(3).length()!=0){
                    messages+=insert_user.user_insert;
                    messages+=" :   ";
                    messages+=res1.getString(3);
                    messages+="\n";
                    }
                     if(res1.getString(4).length()!=0){
                    messages+=Login.user_name;
                    messages+=" :   ";
                    messages+=res1.getString(4);
                    messages+="\n";
                    }
                }
            }
            txt_area.setText(messages);
        
        PreparedStatement stmt=Login.con.prepareStatement("select *from users");
        ResultSet res=null;
        try {
            res = stmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        String Name="";
        while(res.next()){
            String user_name_=Login.user_name;
            if(user_name_.equals(res.getString(1))){
                Name=res.getString(2)+" "+res.getString(3);
            }
        }
        name.setText(Name);
        
            
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        back_btn = new javax.swing.JButton();
        txt_F = new javax.swing.JTextField();
        send_btn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_area = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(61, 60, 60));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/Capture.PNG"))); // NOI18N

        name.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        name.setForeground(new java.awt.Color(255, 255, 255));
        name.setText("name");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 378, Short.MAX_VALUE)
                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 60));

        back_btn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        back_btn.setForeground(new java.awt.Color(255, 0, 51));
        back_btn.setText("Back");
        back_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_btnActionPerformed(evt);
            }
        });
        jPanel2.add(back_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 620, 120, 40));

        txt_F.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel2.add(txt_F, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 500, 660, 60));

        send_btn.setBackground(new java.awt.Color(255, 51, 51));
        send_btn.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        send_btn.setForeground(new java.awt.Color(255, 255, 255));
        send_btn.setText("Send");
        send_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                send_btnActionPerformed(evt);
            }
        });
        jPanel2.add(send_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(724, 500, 180, 60));

        txt_area.setEditable(false);
        txt_area.setColumns(20);
        txt_area.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_area.setRows(5);
        jScrollPane1.setViewportView(txt_area);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 870, 370));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/_background.jpg"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 690));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void back_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_btnActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        try {
            new Home().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_back_btnActionPerformed

    private void send_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_send_btnActionPerformed
        // TODO add your handling code here:
        messages+=Login.user_name;
        messages+=" :   ";
        messages+=txt_F.getText();
        messages+="\n";
        txt_area.setText(messages);
        PreparedStatement stmt1;
        try {
            stmt1 = con.prepareStatement("insert into chat (user_send,user_recive,question,reply) values(?,?,?,?)");
            stmt1.setString(1, Login.user_name);
            stmt1.setString(2, insert_user.user_insert);
            stmt1.setString(3, txt_F.getText());
            stmt1.setString(4, "");
            stmt1.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(chat.class.getName()).log(Level.SEVERE, null, ex);
        }
          txt_F.removeAll();
    }//GEN-LAST:event_send_btnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new chat().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(chat.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel name;
    private javax.swing.JButton send_btn;
    private javax.swing.JTextField txt_F;
    private javax.swing.JTextArea txt_area;
    // End of variables declaration//GEN-END:variables
}
