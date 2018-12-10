/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;

/**
 *
 * @author KHAWAJA ZEESHAUR
 */

public class user {
    
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
//    SavedLib s1= new SavedLib();
    ArrayList<job> AppliedJobs = new ArrayList();
    
    private ArrayList<Message> sendmessages = new ArrayList();
    private ArrayList<Message> recmessages = new ArrayList();
    
    
    public static Connection myobj=null;
    public static Statement mystat=null;
    public static ResultSet myres=null;
    public String queryrec = "select SENDER, MESSAGE from IRTAZA.MESSAGE where RECEIVER=?";
    public String querysend = "select RECEIVER, MESSAGE from IRTAZA.MESSAGE where SENDER=?";
    public static PreparedStatement sqlstat=null;
    
    private static user u = new user();
    private user(){};
    
    public static user getInstance(){
        return u;
    }
    
    public void setValues(String un, String pass, String nm, String em, String coun, String uni, String deg, String prof, String web, int sal){
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
    }
    
    public String getUsername(){
        return username;
    }
    public String getuserName()
    {
        return username;
    }
    
    public void addmessage(String msg,String u)
    {
        Message m=new Message(msg,u);
        sendmessages.add(m);
    }
    
    public ArrayList<Message> showsend() throws SQLException
    {
            myobj=DriverManager.getConnection("jdbc:derby://localhost:1527/connect","zaid","1234");
            mystat=myobj.createStatement();
        
       
sqlstat = myobj.prepareStatement(querysend);
sqlstat.setString(1,username);
ResultSet rs = sqlstat.executeQuery();
Message ms=new Message();
        String nmsg,nuser;
while (rs.next()) {
	nmsg = rs.getString("MESSAGE");
	nuser = rs.getString("RECEIVER");	
//        nmsg=myres.getString("SENDER");
//               nuser=myres.getString("MESSAGE");
               ms.set(nmsg,nuser);
               sendmessages.add(ms);
               
        
}
       
       return sendmessages;
       
    }
    
     public ArrayList<Message> showreceive() throws SQLException
    {
            myobj=DriverManager.getConnection("jdbc:derby://localhost:1527/connect","zaid","1234");
            mystat=myobj.createStatement();
       
sqlstat = myobj.prepareStatement(queryrec);
sqlstat.setString(1,"a");
ResultSet rs = sqlstat.executeQuery();
Message ms=new Message();
        String nmsg,nuser;
while (rs.next()) {
	nmsg = rs.getString("MESSAGE");
	nuser = rs.getString("SENDER");	
//        nmsg=myres.getString("SENDER");
//               nuser=myres.getString("MESSAGE");
               ms.set(nmsg,nuser);
               recmessages.add(ms);
               
        
}
       
       return recmessages;
    }
   
}
