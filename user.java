/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linked_in;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author dell
 */
public class user {
     Connection c=null;
    Statement s1=null;
    ResultSet r = null;
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    int user_id;
    String username;
    String password;
    String name;
    String email;
    String country;
    String university;
    String degree;
    String profession;
    String website; 
    int salary;
   // savedLibrary s1 = new savedLibrary();
    
    private static user u = new user();
    private user(){};
    
    public static user getInstance(){
        return u;
    }
    
    public void setValues(int id,String un, String pass, String nm, String em, String coun, String uni, String deg, String prof, String web, int sal){
        user_id =id;
        username = un;
        password = pass;
        name = nm;
        email = em;
        country = coun;
        university = uni;
        degree = deg;
        profession = prof;
        website = web;
        salary = sal;
          try 
        {
            c=DriverManager.getConnection("jdbc:derby://localhost:1527/linkedin","event","123");
            s1=c.createStatement();
            System.out.println("Hello world");
            int y2 = s1.executeUpdate("INSERT INTO EVENT.USER_DATA VALUES("+id+",'"+un+"','"+pass+"','"+nm+"','"+em+"','"+coun+"','"+uni+"','"+deg+"','"+prof+"','"+web+"',"+sal+")");
        } 
        catch (SQLException ex) 
        {
           // Logger.getLogger(event.class.getName()).log(Level.SEVERE, null, ex);
             System.out.println("no connection");
        }
        
    }
   
}


