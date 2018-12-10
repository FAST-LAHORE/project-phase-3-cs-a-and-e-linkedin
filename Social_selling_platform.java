/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linked_in;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author dell
 */
public class Social_selling_platform {
   // int user_id;  // user u;
    String challenges;
    int no_of_products;
   // ArrayList<Product> p= new ArrayList();
    Connection c=null;
    Statement s1=null;
    Product p=new Product();
    Social_selling_platform()
     {
       challenges="";
       no_of_products=0;    
     }
    // user for platform
    
     public void add_user(int user_id,String challenges1)
     {
         //Statement st = conn.createStatement();
         int p=0;
         boolean exist=true;
        try {
             c=DriverManager.getConnection("jdbc:derby://localhost:1527/linkedin","event","123");
             s1=c.createStatement();
            
             PreparedStatement ps = c.prepareStatement("SELECT * from SOCIAL_SELLING_PLATFORM order by user_id desc");
           
             ResultSet rs=ps.executeQuery();
             
            // if this ID already exists, we quit
             int user=0;
             while(rs.next()) 
             {
               user =  rs.getInt("user_id");
              if(user== user_id) //this part does not happen even if it should
               {
                   System.out.println("It already exists");
                   exist = false;
                }
               }
               
            if(exist==true) {
                s1.executeUpdate("INSERT INTO EVENT.SOCIAL_SELLING_PLATFORM VALUES('"+challenges1+"',"+p+","+user_id+")");
            }      
        } catch (SQLException ex) {
              System.out.println("User already exist ");
                // jopption pane
          //  Logger.getLogger(Social_selling_platform.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
      
       public boolean delete_user(int u_id)
      {  
        //user u = user.getInstance();
        int y3=0;
        boolean exist=true;
        try {      
              c=DriverManager.getConnection("jdbc:derby://localhost:1527/linkedin","event","123");
              s1=c.createStatement();
              String sql="SELECT * from EVENT.SOCIAL_SELLING_PLATFORM WHERE user_id="+u_id+" ";
              System.out.println("KKA");
              PreparedStatement ps = c.prepareStatement(sql);
              ps.setInt(2,u_id);
              y3=ps.executeUpdate();
              System.out.println("KKK");
        } 
        catch (SQLException ex) {
            //Logger.getLogger(Social_selling_platform.class.getName()).log(Level.SEVERE, null, ex);
        }
            if (y3==1)
            {
                return true;
            }
            else 
            {
                return false;
            }
    }
       
       public void add_PP(int product_id,int user_id,String name, int price,String time_required , boolean stat)
       {
           boolean t;
           t= p.add_product(product_id, user_id, name, price, time_required, stat);
       }
       public void update_p(int user,int p_id,int Price)
       {
           boolean f=p.update_price(user,p_id,Price);
       }
 
}
   

