/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linked_in;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author dell
 */
public class Linked_in {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
            // TODO code application logic here
            Connection con = null;
            Statement st = null;
            ResultSet r = null;
          //PreparedStatement ps=null;*/
           
           // user u = user.getInstance();
           event e= new event();
           //boolean s= e.delete_event(5,3);
       /*   
        try {
             con=DriverManager.getConnection("jdbc:derby://localhost:1527/linkedin","event","123");
            st=con.createStatement();
         //   r= st.executeQuery("select * from EVENT.EVENT_DATA");
             while (r.next())
                     {
                       System.out.println( "ID : "+r.getInt("user_id")+" Name : "+r.getString("day")+" Price : "+r.getInt("event_Id"));
             
            System.out.println("ggg");
            String sql="ALTER TABLE Answer ADD Q_ID integer";
              System.out.println("ggg");
             int t= st.executeUpdate(sql);
        } catch (SQLException ex) {
             System.out.println("fail");
           // Logger.getLogger(Linked_in.class.getName()).log(Level.SEVERE, null, ex);
        }        }*/
              Product pro=new Product();
              Social_selling_platform sp= new Social_selling_platform();
            //  sp.add_user(1,"A businessman");
              sp.add_user(2,"A seller");
              sp.delete_user(1);
              pro.update_price(11,11,1250);
              pro.update_pid(1,1,4);
              Q_A_platform q =new Q_A_platform() ;
            //  q.post_answer(2,2,"German is best ");
            //  q.post_answer(2,1,"Arabic is best ");
              //q.post_answer(3,1,"French is best ");
              q.add_question(1, "Which is the best language to learn?");
              //q.add_question(2, "Which is the best programming language to learn?");
              //q.add_question(3, "Which software company is good for CS student?");
              //boolean s5 =pro.add_product(1,1,"suit",1000,"1 day",true);
              // boolean s5 =pro.add_product(2,1,"shoes",1200,"1 day",true);
               // boolean s5 =pro.add_product(3,2,"suit",900," 2 day",true);
               user u = user.getInstance();   
                String username = "kzak97";             //          DATA FOR USER
        String password = "zee786";
        String name = "Khawaja Zeeshaur";
        String email = "zeeshaur1@gmail.com";
        String country_user = "Pakistan";
        String university = "FAST";
        String degree_user = "BsCS";
        String profession = "Student";
        String website = "kwcwatches.com"; 
        int salary_user = 100000;
         u.setValues(username, password, name, email, country_user, university, degree_user, profession, website, salary_user);
        System.out.println("ACCEPTED");
              
    }
    
}
