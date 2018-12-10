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
import java.util.ArrayList;
/**
 *
 * @author dell
 */
public class Q_A_platform {
    Connection c=null;
    Statement s1=null;
  
    public void add_question (int user_id,String que)
    {
        int y2=0;
        String ans=null;
        boolean add=false;
        Question q=new Question();
      //  user u = user.getInstance(); 
        try {       
            c = DriverManager.getConnection("jdbc:derby://localhost:1527/linkedin","event","123");
            s1 = c.createStatement();
            System.out.println(" YY ");
             int c= q.add_ques(user_id,que);
               y2 = s1.executeUpdate("INSERT INTO EVENT.Q_APLATFORM VALUES("+c+",'"+que+"','"+add+"','"+ans+"','"+add+"')");
            System.out.println("Working ");
        } catch (SQLException ex) {
         //   Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Exception");
        }
             //s1.executeUpdateINSERT INTO Linked_in.SOCIAL_SELLING_PLATFORM VALUES("+u.user_id+","+pro.product_id+",'"+pro.name+"',"+pro.price+","+pro.time_required+","+pro.status+")");
    }
    
    public void post_answer(int user_id,int q_id,String ans1)
    {
        int y2=0;
       // String ans=null;
        //boolean add=false;
        Answer a=new Answer();
      //  user u = user.getInstance(); 
        try {       
            c = DriverManager.getConnection("jdbc:derby://localhost:1527/linkedin","event","123");
            s1 = c.createStatement();
            System.out.println(" YY ");
             int c= a.add_ans(user_id,q_id,ans1);
          
               y2 = s1.executeUpdate("UPDATE EVENT.Q_APLATFORM SET answer1='"+ans1+"' WHERE Q_ID="+q_id+"");
              
             System.out.println("--Working--");
        } catch (SQLException ex) {
         //   Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Exception");
        }
    }
    
    public void setAns_statusQP(boolean stat, int q_id)
    {
        String sql1= "UPDATE EVENT.Q_APLATFORM SET PINNED='"+stat+"' WHERE Q_ID="+q_id+" ";
        try {
         int y1= s1.executeUpdate(sql1);
     } catch (SQLException ex) {
         //Logger.getLogger(Answer.class.getName()).log(Level.SEVERE, null, ex);
         System.out.println("--Exception--");
     }
    }
    public void setQues_statusQP(boolean stat, int q_id)
    {
        String sql1= "UPDATE EVENT.Q_APLATFORM SET RESOLVED='"+stat+"' WHERE Q_ID="+q_id+" ";
        try {
         int y1= s1.executeUpdate(sql1);
     } catch (SQLException ex) {
         //Logger.getLogger(Answer.class.getName()).log(Level.SEVERE, null, ex);
         System.out.println("--Exception--");
     }
    }
}
