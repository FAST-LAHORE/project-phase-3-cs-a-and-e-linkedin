/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linked_in;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author dell
 */
public class event {
    protected int event_Id;
    protected String name;
    protected String day;
    protected String venue;
    protected String time; 
    protected String date;
    Connection c=null;
    Statement s1=null;
    ResultSet r = null;
    
    public int getId()
    {
        return this.event_Id;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public String getday()
    {
        return this.day;
    }
    
    public String getvenue()
    {
        return this.venue;
    }
    
    public String getTime()
    {
        return this.time;
    }
    
    public String getDate()
    {
        return this.date;
    }
   
    event ()
    {
        event_Id= 0;
        name=null;
        day=null;
        venue=null;
        date = null;
        time=null;
    }
    
    event(int e_Id,String d,String v,String date1, String t)
    {
        event_Id= e_Id;
        day=d;
        venue=v;
        date = date1;
        time=t;
     
    }
    
    //"+n+",   string name ad into table
     public boolean add_event2(int user_id,int e_Id,String d,String v,String date ,String t)
     {
        
        int y2=0;
        //user u = user.getInstance(); 
        try 
        {
            c=DriverManager.getConnection("jdbc:derby://localhost:1527/linkedin","event","123");
            s1=c.createStatement();
            y2 = s1.executeUpdate("INSERT INTO EVENT.EVENT_DATA VALUES("+user_id+","+e_Id+",'"+d+"','"+t+"','"+date+"','"+v+"')");
        } 
        catch (SQLException ex) 
        {
           // Logger.getLogger(event.class.getName()).log(Level.SEVERE, null, ex);
             System.out.println("no connection");
        }
               
            if (y2==1)
            {
                return true;
            }
            else 
            {
                return false;
            }
        }
 
}
