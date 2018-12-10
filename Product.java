/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linked_in;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author dell
 */
public class Product {
    protected int product_id;
    protected String name;
    protected double price;
    protected String time_required;
    protected boolean status;  //  -- available or not
    Connection c=null;
    Statement s1=null;
    
    Product ()
    {
       product_id =0;
       name=null;
       price=0;
       time_required=null;
       status=false;  
    }
    
    Product (int p_id, String n,int pr, String time)
     {
       product_id =p_id;
       name=n;
       price=pr;
       time_required=time;  // string
       status=false;  
     }
    
     public int getId()
     {
        return this.product_id;
     }
     
     public String getName()
      {
          return this.name;
      }
    
      public double get_price()
     {
        return this.price;
     }
      
       public String getTime()
      {
          return this.time_required;
      }
       
       public boolean get_status()
       {
           return this.status;
       }
       public  boolean add_product(int product_id,int user_id,String name, int price,String time_required , boolean stat )
          {
        int y2=0;
      //  user u = user.getInstance(); 
        try {       
            c = DriverManager.getConnection("jdbc:derby://localhost:1527/linkedin","event","123");
            s1 = c.createStatement();
            System.out.println("PPP ");
            y2 = s1.executeUpdate("INSERT INTO EVENT.PRODUCT VALUES("+product_id+","+user_id+",'"+name+"',"+price+",'"+time_required+"',"+stat+")");
            System.out.println("111 ");
        } catch (SQLException ex) {
         //   Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Product id already exists set new id ");
        }
             //s1.executeUpdateINSERT INTO Linked_in.SOCIAL_SELLING_PLATFORM VALUES("+u.user_id+","+pro.product_id+",'"+pro.name+"',"+pro.price+","+pro.time_required+","+pro.status+")");
          
            if (y2==1)
            {
                return true;
            }
            else 
            {
                return false;
            }
        }

    // need of user
    
   public boolean delete_product(user u,int p_Id)
    {
        //user u = user.getInstance();
        int y3=0;
       
        String sql="Delete Event.PRODUCT WHERE user_id=" +u.user_id+" ";
        try {       
             c = DriverManager.getConnection("jdbc:derby://localhost:1527/linkedin","event","123");
             s1 = c.createStatement();
             PreparedStatement ps1=c.prepareStatement(sql);
              ps1.setInt(1,p_Id);
              y3=ps1.executeUpdate(sql);
        } 
        catch (SQLException ex) {
           // Logger.getLogger(Social_selling_platform.class.getName()).log(Level.SEVERE, null, ex);
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
   
      public boolean update_price(int user,int p_id,int Price)
      {
        //user u = user.getInstance(); 
        int y3=0; 
        boolean exist= false;
        String sql="Update Event.Product SET price ="+Price+" WHERE user_id=" +user+" AND product_id="+p_id+" ";
                try {
                     c = DriverManager.getConnection("jdbc:derby://localhost:1527/linkedin","event","123");
                     s1 = c.createStatement();
                     PreparedStatement ps = c.prepareStatement("SELECT * from SOCIAL_SELLING_PLATFORM order by user_id desc");
           
            ResultSet rs=ps.executeQuery();
             
            // if this ID already exists, we quit
             int user1=0;
             while(rs.next()) 
             {
               user1 =  rs.getInt("user_id");
              if(user1== user) //this part does not happen even if it should
               {
                   System.out.println("It already exists");
                       exist=true;
                       y3= s1.executeUpdate(sql);
               }
              }
                 
                if (exist==false)
                    System.out.println("User or product id doesn't exist ");
                  
                }
                 catch (SQLException ex) {
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
      
       public boolean update_pid(int user,int p_id,int up_id)
      {
        //user u = user.getInstance(); 
        int y3=0; 
        boolean exist= false;
        String sql="Update Event.Product SET product_id ="+up_id+" WHERE user_id=" +user+" AND product_id="+p_id+" ";
                try {
                    System.out.println("PPP ");
                     c = DriverManager.getConnection("jdbc:derby://localhost:1527/linkedin","event","123");
                     s1 = c.createStatement();
                     System.out.println("LLP ");
                     PreparedStatement ps = c.prepareStatement("SELECT * from SOCIAL_SELLING_PLATFORM order by user_id desc");
           
            ResultSet rs=ps.executeQuery();
             
            // if this ID already exists, we quit
             int user1;
             while(rs.next()) 
             {
               user1 =  rs.getInt("user_id");
              if(user1== user) //this part does not happen even if it should
               {
                   System.out.println("It already exists");
                       exist=true;
                       y3= s1.executeUpdate(sql);
               }
              }
                 
                if (exist==false)
                    System.out.println("User or product id doesn't exist ");
                  
                }
                 catch (SQLException ex) {
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
    public void show_product()
    {
        System.out.println("Name of the Product:   " + name);
        System.out.println("Price of the Product:   " + price);
        System.out.println("Time required of the Product:   " + time_required);
        System.out.println("Status of the Product:   " + status);
    }
}
