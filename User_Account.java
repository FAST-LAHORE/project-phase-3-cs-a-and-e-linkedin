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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
//import static project.functionality.myobj;
//import static project.functionality.myres;
//import static project.functionality.mystat;
//import static project.functionality.querypost;
//import static project.functionality.sqlstat;
//import static project.userlogin.myobj;
//import static project.userlogin.mystat;

/**
 *
 * @author Dell
 */
public class User_Account {
    
    
     public static Connection myobj=null;
        public static Statement mystat=null;
        public static ResultSet myres=null;
        public String queryrec = "select SENDER, MESSAGE from IRTAZA.MESSAGE where RECEIVER=?";
        public String querysend = "select RECEIVER, MESSAGE from IRTAZA.MESSAGE where SENDER=?";
        public static PreparedStatement sqlstat=null;
    
    
    
    
    
    
    
    
    
    private static User_Account user=new User_Account();
    private String username;
    private String password;
    private String name;
    private String email;
    private String country;
    private String degree;
    private String website;
    private String profession;
    private int no_of_products_bought; 
    private String university;
    private ArrayList<String> expertise;
    private ArrayList<String> industry_sector;
    private ArrayList<String> skills;
//    Saved_Items_Library library;
//    ArrayList<Article> article;
    private int views;
    private ArrayList<Post> posts;     //changing inheritance from aggregation
    private ArrayList<friendslist> friends=new ArrayList<friendslist>();;     //changing inheritance from aggregation
    
    private ArrayList<Message> sendmessages;
    private ArrayList<Message> recmessages;
    
    private User_Account(){
        posts = new ArrayList<Post>();
        friends = new ArrayList<friendslist>();
        sendmessages=new ArrayList<Message>();
        recmessages=new ArrayList<Message>();
    }
    
    
    public void addmessage(String msg,String u)
    {
        Message m=new Message(msg,u);
        sendmessages.add(m);
    }
    
    public ArrayList<Message> getmessages()
    {
        return sendmessages;
    }
    
    public ArrayList<Message> showreceive() throws SQLException
    {
       try {
            myobj=DriverManager.getConnection("jdbc:derby://localhost:1527/linkedin","irtaza","1234");
            mystat=myobj.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(userlogin.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("not connected");
        }
       
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
        
       
//        sqlstat = myobj.prepareStatement(queryrec);
//        myres=mystat.executeQuery(queryrec);        
//        int id=0;
//        while(myres.next()){
//               id=myres.getInt("ID");
//            }
//        id++;
//        System.out.println("IDDDD"+id);
//        
//        sqlstat.setString(1,username);
        
         
//        myres=sqlstat.executeQuery(queryrec);        
//        
//        while(myres.next()){
//            
//               
//               
//        
//        }
//        return recmessages;
////         int a = sqlstat.executeUpdate();    
         
       
    }
    
    
    public ArrayList<Message> showsend() throws SQLException
    {
       try {
            myobj=DriverManager.getConnection("jdbc:derby://localhost:1527/linkedin","irtaza","1234");
            mystat=myobj.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(userlogin.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("not connected");
        }
       
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
        
       
//        sqlstat = myobj.prepareStatement(queryrec);
//        myres=mystat.executeQuery(queryrec);        
//        int id=0;
//        while(myres.next()){
//               id=myres.getInt("ID");
//            }
//        id++;
//        System.out.println("IDDDD"+id);
//        
//        sqlstat.setString(1,username);
        
         
//        myres=sqlstat.executeQuery(queryrec);        
//        
//        while(myres.next()){
//            
//               
//               
//        
//        }
//        return recmessages;
////         int a = sqlstat.executeUpdate();    
         
       
    }
    
    
    
    
    public static User_Account getUser()
    {
        return user;
    }
    public void setName(String n)
    {
        name=n;
    }
    
    public void setuserName(String n)
    {
        username=n;
    }
    public String getuserName()
    {
        return username;
    }
    
    public void makeapost(String a)
    {
        int size=posts.size();
        Post temp=new Post(size,a);
        temp.setUser(this);
        posts.add(temp);
        

    }
    
    public Post getPost(int i)
    {
       	return posts.get(i);
		
    }
    
    public void comment(int i,User_Account user,String n)
    {
        Comment comment1 = new Comment(n,this);
        
        Post temp=user.getPost(i);
        
        temp.addcomment(comment1);
           
    }
    
    public void showposts()
    {
        for (int i=0;i<posts.size();i++)
        {
            
            posts.get(i).show();
            
            
        }
    }
    
    
    public void showFriends()
    {
        for(int i=0;i<friends.size();i++)
        {
            System.out.println("Friends "+ i+" "+ friends.get(i).getName());
        }
    }
    
    public void addFriend(friendslist u)
    {
        friends.add(u);
    }
    
    public String getName()
    {
        return name;
    }
    
    public void addvideo(String n,String cap)
    {
        int i=posts.size();
        video v=new video(i,n,cap);
        v.setUser(this);
        posts.add(v);
    }
    
    public void addphoto(String n,String cap)
    {
        int i=posts.size();
        photo v=new photo(i,n,cap);
        v.setUser(this);
        posts.add(v);
    }
    
    public ArrayList<friendslist> getfriendlist()
    {
        return friends;
    }
    
    
}
