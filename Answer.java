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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dell
 */
public class Answer {
 String answer;
 boolean pinned;
 private int ansid_c; 
 private static int ACounter = 0;
 Connection c=null;
 Statement s1=null;
 
 public int count()
 {
    return this.ansid_c=ACounter++;
 }
 
  public int add_ans(int user_id,int q_id,String ans)
 {
      //  user u = user.getInstance(); 
        boolean add=false;
        int p = count();
        try {       
            c = DriverManager.getConnection("jdbc:derby://localhost:1527/linkedin","event","123");
            s1 = c.createStatement();
            System.out.println(" AA ");
            int y2=s1.executeUpdate("INSERT INTO EVENT.ANSWER VALUES("+user_id+","+p+","+q_id+",'"+ans+"','"+add+"')");
            System.out.println("Working----");
        } catch (SQLException ex) {
         //   Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("--Exception--");
        }
        return p;
 }
   public void setAns_status(boolean stat, int q_id) 
    {
        String sql1= "UPDATE EVENT.ANSWER SET PINNED='"+stat+"' WHERE Q_ID="+q_id+" ";
     try {
         int y1= s1.executeUpdate(sql1);
     } catch (SQLException ex) {
         //Logger.getLogger(Answer.class.getName()).log(Level.SEVERE, null, ex);
         System.out.println("--Exception--");
     }
    }
}
