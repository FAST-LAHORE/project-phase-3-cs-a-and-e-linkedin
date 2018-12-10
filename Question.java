/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linked_in;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author dell
 */
public class Question {
 String question;
 boolean resolved;
 private int qid_c; 
 private static int QCounter = 0;
 Connection c=null;
 Statement s1=null;
 
 public int count()
 {
    return this.qid_c=QCounter++;
 }
 
 public int add_ques(int user_id,String que)
 {
      //  user u = user.getInstance(); 
        boolean add=false;
        int p= count();
     
        try {       
            c = DriverManager.getConnection("jdbc:derby://localhost:1527/linkedin","event","123");
            s1 = c.createStatement();
            System.out.println(" QQ ");
              int y2=s1.executeUpdate("INSERT INTO EVENT.QUESTION VALUES("+user_id+","+p+",'"+que+"','"+add+"')");
            System.out.println("Working3 ");
        } catch (SQLException ex) {
         //   Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Exception");
        }
        return p;
 }
 
  public void setQues_status(boolean stat, int q_id)
    {
        String sql1= "UPDATE EVENT.QUESTION SET RESOLVED='"+stat+"' WHERE Q_ID="+q_id+" ";
        try {
         int y1= s1.executeUpdate(sql1);
     } catch (SQLException ex) {
         //Logger.getLogger(Answer.class.getName()).log(Level.SEVERE, null, ex);
         System.out.println("--Exception--");
     }
    }
 /*
 Question()
 {
     question=null;
     resolved=false;
 }*/
}
