/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dell
 */
public class userlogin extends javax.swing.JFrame {

    /**
     * Creates new form userlogin
     */
    public userlogin() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Press to Enter");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(142, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(138, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        user=user.getUser();
        user.setName("Irtaza");
        user.setuserName("irtazafayaz");
        try {
            myobj=DriverManager.getConnection("jdbc:derby://localhost:1527/linkedin","irtaza","1234");
            mystat=myobj.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(userlogin.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("not connected");
        }
        
        this.setVisible(false);
        functionality f=new functionality(myobj,mystat,myres,sqlstat,user);
        f.setVisible(true);
        
//        
//        try {
//            add_user("irtazafayaz");
//            add_user("bilawal");
//            add_user("ahmad");
//            add_user("zain");
//            add_user("zeeshaur");
//            
//            
//            //posts
//        } catch (SQLException ex) {
//            Logger.getLogger(userlogin.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
        
        
//        user=user.getUser();
        System.out.println(user.getName());
//        
//        String n="Hello!!!";
//        if(n.length()!= 0)
//            
//                try {
//                    addpostdb(n);
//        } catch (SQLException ex) {
//            Logger.getLogger(userlogin.class.getName()).log(Level.SEVERE, null, ex);
//        }
//                showposts();
//                // user.makeapost(n);
//        
//        user.showposts();
//        
//        
        
    }//GEN-LAST:event_jButton1ActionPerformed
    
    public static void add_user(String n) throws SQLException 
    {
//        query1="INSERT INTO IRATZAFAYAZ.UNTITLED VALUES (3,"augmenton",40)";
        
        
            
                //System.out.println("entered function");
                sqlstat = myobj.prepareStatement("INSERT INTO IRTAZA.USERS(username) VALUES(?)");
                sqlstat.setString(1,n);
      
         
         int a = sqlstat.executeUpdate();

       
             
        
    }
    
    
    
    
    public void addpostdb(String n) throws SQLException
    {
                //System.out.println("entered function");
        sqlstat = myobj.prepareStatement("INSERT INTO IRTAZA.POSTS(ID,USERNAME,PID,POST) VALUES(?,?,?,?)");
        myres=mystat.executeQuery(querypost);        
        int id=0;
        while(myres.next()){
               id=myres.getInt("ID");
            }
        id++;
        System.out.println("IDDDD"+id);
        
        sqlstat.setInt(1,id);
         sqlstat.setString(2,user.getuserName());
         sqlstat.setInt(3, id);
         sqlstat.setString(4,n);
         
         
         int a = sqlstat.executeUpdate();
         
             

            
    }
    
    public void showposts()
    {
        try {
               // System.out.println("entered function");
//                String qu="Delete from IRATZAFAYAZ.UNTITLED where id="+id;
                 myres=mystat.executeQuery(querypost);
            
            while(myres.next()){
               int id=myres.getInt("ID");
               String name= myres.getString("username");
               int pid = myres.getInt("pid");
               String post = myres.getString("post");
                System.out.println(id+name+pid+post);
            }
        }
                
 
             catch (SQLException ex) {
                Logger.getLogger(userlogin.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("error");
            }
    }
    
//    public void 
    
    public Connection getcon()
    {
        return myobj;
    }
    public Statement getstat()
    {
        return mystat;
    }
    public PreparedStatement pStat()
    {
        return sqlstat;
    }
    public ResultSet getres()
    {
        return myres;
    }
    
    
    public User_Account getUser()
    {
        return user;
    }
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
            java.util.logging.Logger.getLogger(userlogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(userlogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(userlogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(userlogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new userlogin().setVisible(true);
            }
        });
    }

        public static Connection myobj=null;
        public static Statement mystat=null;
        public static ResultSet myres=null;
        public static String querypost="select * from IRTAZA.POSTS";
        public static PreparedStatement sqlstat=null;
    private User_Account user=null;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
